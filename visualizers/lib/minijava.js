// A small Java interpreter for teaching traces. It follows the JLS for the subset it accepts:
// the whole program is parsed and type-checked first (as javac does), then run one step at a time,
// recording a snapshot of every step for the visualizers.
//   Types: int, double, boolean, String, 1-D arrays, ArrayList<Integer|String|Double>, the course's
//   Player class. Statements: declarations with a value, assignment (= += -= *= /= %=), ++ and --,
//   if/else, while, for, enhanced for, static methods with return, System.out.print/println.
// Valid Java outside this subset is reported as unsupported, never as a compile error.
// Relies on javaDouble, castToInt and toInt32 from the Expression Tracer engine (embedded beside it).
const MJ = (function () {
  class CompileError extends Error { constructor(msg, line) { super(msg); this.line = line; } }
  class Unsupported extends Error { constructor(msg, line) { super(msg); this.line = line; } }
  class JavaThrow extends Error { constructor(type, line, why) { super(type); this.javaType = type; this.line = line; this.why = why; } }
  class ToolLimit extends Error { constructor(kind, line) { super(kind); this.kind = kind; this.line = line; } }
  const INT_MAX = 2147483647, INT_MIN = -2147483648;

  /* ---------------- Tokens ---------------- */
  const OPS = ['>>>=', '<<=', '>>=', '>>>', '...', '->', '::', '++', '--', '&&', '||', '==', '!=', '<=', '>=', '+=', '-=', '*=', '/=', '%=',
    '&=', '|=', '^=', '<<', '>>', '+', '-', '*', '/', '%', '=', '<', '>', '!', '(', ')', '{', '}', '[', ']', ',', '.', ';', ':', '?', '&', '|', '^', '~', '@'];
  const UNSUPPORTED_OPS = { '?': 'the ?: operator', '&': 'the & operator', '|': 'the | operator', '^': 'the ^ operator', '~': 'the ~ operator',
    '<<': 'bit shifts', '>>': 'bit shifts', '>>>': 'bit shifts', '<<=': 'bit shifts', '>>=': 'bit shifts', '>>>=': 'bit shifts',
    '&=': 'the &= operator', '|=': 'the |= operator', '^=': 'the ^= operator', '->': 'lambdas', '::': 'method references', '...': 'varargs', '@': 'annotations' };
  function lex(src) {
    const toks = [];
    let i = 0, line = 1;
    while (i < src.length) {
      const c = src[i], rest = src.slice(i);
      if (c === '\n') { line++; i++; continue; }
      if (' \t\r\f'.includes(c)) { i++; continue; }
      if (rest.startsWith('//')) { while (i < src.length && src[i] !== '\n') i++; continue; }
      if (rest.startsWith('/*')) {
        const e = src.indexOf('*/', i + 2);
        if (e < 0) throw new CompileError('unclosed comment', line);
        line += src.slice(i, e).split('\n').length - 1; i = e + 2; continue;
      }
      const num = /^(?:\d+(?:\.\d*)?(?:[eE][+-]?\d+)?[\w.]*|\.\d[\w]*)/.exec(rest);
      if (num) {
        const raw = num[0];
        let tok;
        if (/^\d+$/.test(raw)) {
          if (raw.length > 1 && raw[0] === '0') throw new Unsupported(`${raw}: a leading 0 makes Java read the number as octal; this tool does not.`, line);
          if (Number(raw) > 2147483648) throw new CompileError(`integer number too large: ${raw}`, line);
          tok = { k: 'int', v: Number(raw) };
        } else if (/^(\d+\.\d*|\d+)([eE][+-]?\d+)?$/.test(raw)) {
          const v = Number(raw);
          if (v === Infinity) throw new CompileError(`floating-point number too large: ${raw}`, line);
          tok = { k: 'double', v };
        } else throw new Unsupported(`the number ${raw} is not supported here (hex, underscores, a leading dot, or a suffix such as L or f).`, line);
        toks.push({ ...tok, raw, line, pos: i, end: i + raw.length }); i += raw.length; continue;
      }
      if (c === '"') {
        let j = i + 1, v = '';
        while (j < src.length && src[j] !== '"') {
          if (src[j] === '\n') throw new CompileError('unclosed String literal', line);
          if (src[j] === '\\') {
            const e = src[j + 1], map = { n: '\n', t: '\t', '"': '"', "'": "'", '\\': '\\' };
            if (!(e in map)) throw new Unsupported(`the escape \\${e} is not supported here.`, line);
            v += map[e]; j += 2;
          } else v += src[j++];
        }
        if (j >= src.length) throw new CompileError('unclosed String literal', line);
        toks.push({ k: 'str', v, raw: src.slice(i, j + 1), line, pos: i, end: j + 1 }); i = j + 1; continue;
      }
      if (c === "'") throw new Unsupported('char values are not supported here.', line);
      const id = /^[A-Za-z_$][\w$]*/.exec(rest);
      if (id) { toks.push({ k: 'id', v: id[0], line, pos: i, end: i + id[0].length }); i += id[0].length; continue; }
      const op = OPS.find(o => rest.startsWith(o));
      if (op) {
        if (UNSUPPORTED_OPS[op]) throw new Unsupported(`${UNSUPPORTED_OPS[op]} ${/s$/.test(UNSUPPORTED_OPS[op]) ? 'are' : 'is'} not supported here.`, line);
        toks.push({ k: op, line, pos: i, end: i + op.length }); i += op.length; continue;
      }
      throw new Unsupported(`the character ${JSON.stringify(c)} is not supported here.`, line);
    }
    toks.push({ k: 'end', line, pos: src.length, end: src.length });
    return toks;
  }

  /* ---------------- Parser ---------------- */
  const PRIM = ['int', 'double', 'boolean'];
  const BASE_TYPES = ['int', 'double', 'boolean', 'String', 'void', 'Player', 'Integer', 'Double'];
  const OTHER_TYPES = ['char', 'long', 'float', 'short', 'byte', 'var', 'Object', 'Boolean', 'List', 'Scanner', 'Random', 'HashMap', 'Map', 'Set', 'StringBuilder', 'Character'];
  const RESERVED_UNSUPPORTED = ['break', 'continue', 'do', 'switch', 'try', 'throw', 'class', 'new', 'this', 'super', 'final', 'instanceof', 'case', 'default'];
  let nodeSeq = 0;
  function parse(src) {
    const t = lex(src);
    let p = 0;
    const peek = (k = 0) => t[p + k], next = () => t[p++];
    const at = (k, v) => peek().k === k && (v === undefined || peek().v === v);
    const atId = v => at('id', v);
    const expect = (k, what) => { if (!at(k)) throw new CompileError(`${what || `'${k}'`} expected`, peek().line); return next(); };
    const mk = (o, startTok) => ({ id: nodeSeq++, line: startTok.line, pos: startTok.pos, ...o, end: t[p - 1].end, get src() { return src.slice(this.pos, this.end); } });

    function isTypeStart(k = 0) {
      const tk = peek(k);
      return tk.k === 'id' && (BASE_TYPES.includes(tk.v) || tk.v === 'ArrayList' || OTHER_TYPES.includes(tk.v));
    }
    function parseType() {
      const tk = next();
      if (OTHER_TYPES.includes(tk.v)) throw new Unsupported(`the type ${tk.v} is not supported here.`, tk.line);
      let type = tk.v;
      if (type === 'ArrayList') {
        expect('<', "'<' (ArrayList needs an element type, such as ArrayList<Integer>)");
        const e = expect('id', 'element type').v;
        if (['int', 'double', 'boolean', 'char', 'long', 'float', 'short', 'byte'].includes(e)) throw new CompileError(`unexpected type: ArrayList needs a class type such as ${e === 'int' ? 'Integer' : e === 'double' ? 'Double' : 'Boolean'}, not the primitive ${e}`, tk.line);
        if (!['Integer', 'String', 'Double'].includes(e)) throw new Unsupported(`ArrayList<${e}> is not supported here (Integer, String or Double).`, tk.line);
        expect('>');
        type = `ArrayList<${e}>`;
      }
      if (at('[')) {
        next(); expect(']');
        if (at('[')) throw new Unsupported('2-D arrays are not supported here.', tk.line);
        if (type === 'void' || type.startsWith('ArrayList')) throw new Unsupported(`arrays of ${type} are not supported here.`, tk.line);
        type += '[]';
      }
      return type;
    }
    // Expressions, lowest precedence first. Assignments and ++/-- are statements only.
    function expr() { return orExpr(); }
    function bin(nextFn, ops) {
      return function () {
        const s = peek();
        let l = nextFn();
        while (ops.includes(peek().k)) { const op = next().k; const r = nextFn(); l = mk({ k: 'bin', op, l, r }, s); }
        return l;
      };
    }
    function unary() {
      const s = peek();
      if (at('-') || at('+') || at('!')) { const op = next().k; return mk({ k: 'unary', op, e: unary() }, s); }
      if (at('++') || at('--')) throw new Unsupported('++ and -- are supported only as their own statements, such as i++;', s.line);
      if (at('(') && peek(1).k === 'id' && (peek(1).v === 'int' || peek(1).v === 'double') && peek(2).k === ')') {
        next(); const to = next().v; next();
        return mk({ k: 'cast', to, e: unary() }, s);
      }
      if (at('(') && peek(1).k === 'id' && (BASE_TYPES.includes(peek(1).v) || OTHER_TYPES.includes(peek(1).v)) && peek(2).k === ')') throw new Unsupported(`casts to ${peek(1).v} are not supported here.`, s.line);
      return postfix();
    }
    const mul = bin(unary, ['*', '/', '%']);
    const add = bin(mul, ['+', '-']);
    const rel = bin(add, ['<', '<=', '>', '>=']);
    const eq = bin(rel, ['==', '!=']);
    const andExpr = bin(eq, ['&&']);
    const orExpr = bin(andExpr, ['||']);
    function args() {
      expect('(');
      const a = [];
      if (!at(')')) { a.push(expr()); while (at(',')) { next(); a.push(expr()); } }
      expect(')');
      return a;
    }
    function postfix() {
      const s = peek();
      let e = primary();
      for (;;) {
        if (at('.')) {
          next();
          const name = expect('id', 'a name after the dot').v;
          if (at('(')) e = mk({ k: 'call', recv: e, name, args: args() }, s);
          else e = mk({ k: 'field', recv: e, name }, s);
        } else if (at('[')) {
          next(); const i = expr(); expect(']');
          e = mk({ k: 'index', arr: e, i }, s);
        } else break;
      }
      if (at('++') || at('--')) throw new Unsupported('++ and -- are supported only as their own statements, such as i++;', s.line);
      // Assignment used as a value: type-checked (so if (x = 5) is the compile error javac gives) but not run.
      if (at('=') || ['+=', '-=', '*=', '/=', '%='].includes(peek().k)) {
        const op = next().k;
        if (e.k !== 'var' && e.k !== 'index') throw new CompileError('unexpected type: the left side of an assignment must be a variable', s.line);
        return mk({ k: 'assignExpr', op, target: e, e: expr() }, s);
      }
      return e;
    }
    function primary() {
      const s = next();
      if (s.k === 'int') return mk({ k: 'lit', type: 'int', v: s.v === 2147483648 ? null : s.v, big: s.v === 2147483648 }, s);
      if (s.k === 'double') return mk({ k: 'lit', type: 'double', v: s.v }, s);
      if (s.k === 'str') return mk({ k: 'lit', type: 'String', v: s.v }, s);
      if (s.k === '(') { const e = expr(); expect(')'); return e; }
      if (s.k === '{') throw new Unsupported('an array initializer { … } is supported only in a declaration, such as int[] a = {1, 2, 3};', s.line);
      if (s.k === 'id') {
        if (s.v === 'true' || s.v === 'false') return mk({ k: 'lit', type: 'boolean', v: s.v === 'true' }, s);
        if (s.v === 'null') return mk({ k: 'lit', type: 'null', v: null }, s);
        if (s.v === 'new') return creation(s);
        if (RESERVED_UNSUPPORTED.includes(s.v)) throw new Unsupported(`${s.v} is not supported here.`, s.line);
        if (s.v === 'Math' || s.v === 'Integer' || s.v === 'System' || s.v === 'Double' || s.v === 'String') return mk({ k: 'class', name: s.v }, s);
        if (at('(')) return mk({ k: 'scall', name: s.v, args: args() }, s);
        return mk({ k: 'var', name: s.v }, s);
      }
      throw new CompileError(s.k === 'end' ? 'the program ends in the middle of an expression' : `illegal start of expression: '${s.k}'`, s.line);
    }
    function creation(s) {
      if (!isTypeStart()) { const n = peek(); throw new Unsupported(`new ${n.v || n.k} is not supported here.`, s.line); }
      const base = next().v;
      if (OTHER_TYPES.includes(base)) throw new Unsupported(`new ${base} is not supported here.`, s.line);
      if (base === 'ArrayList') {
        expect('<');
        let e = null;
        if (!at('>')) { e = expect('id').v; if (!['Integer', 'String', 'Double'].includes(e)) throw new Unsupported(`ArrayList<${e}> is not supported here.`, s.line); }
        expect('>');
        const a = args();
        if (a.length) throw new Unsupported('new ArrayList with arguments is not supported here.', s.line);
        return mk({ k: 'newList', elem: e }, s);
      }
      if (at('[')) {
        next();
        if (at(']')) {
          next();
          if (!at('{')) throw new CompileError('array dimension missing', s.line);
          return mk({ k: 'arrInit', elem: base, items: initItems() }, s);
        }
        const n = expr(); expect(']');
        if (at('[')) throw new Unsupported('2-D arrays are not supported here.', s.line);
        return mk({ k: 'newArr', elem: base, n }, s);
      }
      if (base === 'Player') return mk({ k: 'newPlayer', args: args() }, s);
      if (base === 'String') throw new Unsupported('new String(…) is not supported in this tool; the Memory Diagram shows it.', s.line);
      throw new Unsupported(`new ${base}(…) is not supported here.`, s.line);
    }
    function initItems() {
      expect('{');
      const items = [];
      if (!at('}')) { items.push(expr()); while (at(',')) { next(); if (at('}')) break; items.push(expr()); } }
      expect('}');
      return items;
    }
    // Statements
    function block() {
      const s = expect('{');
      const body = [];
      while (!at('}')) { if (at('end')) throw new CompileError("reached end of file while parsing: a '}' is missing", peek().line); body.push(statement()); }
      next();
      return mk({ k: 'block', body }, s);
    }
    function varDecl(s, needSemi) {
      const type = parseType();
      const name = expect('id', 'variable name').v;
      if (at('[')) throw new Unsupported('put the [] after the type, as in int[] a, not after the name.', s.line);
      if (!at('=')) {
        if (at(',')) throw new Unsupported('declare one variable per statement here.', s.line);
        throw new Unsupported('declare each variable with a starting value here, for example int count = 0;', s.line);
      }
      next();
      let init;
      if (at('{')) { if (!type.endsWith('[]')) throw new CompileError('illegal initializer: { … } is only for arrays', s.line); init = mk({ k: 'arrInit', elem: type.slice(0, -2), items: initItems() }, s); }
      else init = expr();
      if (at(',')) throw new Unsupported('declare one variable per statement here.', s.line);
      if (needSemi) expect(';', "';'");
      return mk({ k: 'decl', type, name, init }, s);
    }
    // An expression statement: assignment, compound assignment, ++/--, a method call, or a print.
    function simple(s) {
      if (at('++') || at('--')) { const op = next().k; const target = postfix(); return mk({ k: 'incdec', op, target, prefix: true }, s); }
      if (atId('System')) {
        next(); expect('.'); const o = expect('id');
        if (o.v !== 'out') throw new Unsupported('only System.out.print and System.out.println are supported here.', s.line);
        expect('.'); const m = expect('id').v;
        if (m !== 'print' && m !== 'println') throw new Unsupported(`System.out.${m} is not supported here.`, s.line);
        return mk({ k: 'print', ln: m === 'println', args: args() }, s);
      }
      const save = p;
      let target;
      const e1 = peek();
      // Parse a primary/postfix chain without the "no assignment" guard.
      target = (function () {
        let e = primary();
        for (;;) {
          if (at('.')) { next(); const name = expect('id', 'a name after the dot').v; if (at('(')) e = mk({ k: 'call', recv: e, name, args: args() }, e1); else e = mk({ k: 'field', recv: e, name }, e1); }
          else if (at('[')) { next(); const i = expr(); expect(']'); e = mk({ k: 'index', arr: e, i }, e1); }
          else break;
        }
        return e;
      })();
      if (at('=') || ['+=', '-=', '*=', '/=', '%='].includes(peek().k)) {
        const op = next().k;
        if (target.k !== 'var' && target.k !== 'index') throw new CompileError('unexpected type: the left side of an assignment must be a variable', s.line);
        if (at('{')) throw new Unsupported('an array initializer { … } is supported only in a declaration.', s.line);
        return mk({ k: 'assign', op, target, e: expr() }, s);
      }
      if (at('++') || at('--')) {
        const op = next().k;
        if (target.k !== 'var' && target.k !== 'index') throw new CompileError(`unexpected type: ${op} needs a variable`, s.line);
        return mk({ k: 'incdec', op, target, prefix: false }, s);
      }
      if (target.k === 'call' || target.k === 'scall' || target.k === 'newPlayer' || target.k === 'newList') {
        // Allow the rest of a larger expression to be flagged: a call followed by an operator is "not a statement".
        if (!at(';') && !at(')')) { p = save; const e = expr(); return mk({ k: 'exprStmt', e }, s); }
        return mk({ k: 'exprStmt', e: target }, s);
      }
      p = save;
      const e = expr();
      return mk({ k: 'exprStmt', e }, s);
    }
    function statement() {
      const s = peek();
      if (at('{')) return block();
      if (at(';')) { next(); return mk({ k: 'empty' }, s); }
      if (atId('if')) {
        next(); expect('('); const cond = expr(); expect(')', "')'");
        const then = statement();
        let els = null;
        if (atId('else')) { next(); els = statement(); }
        return mk({ k: 'if', cond, then, els }, s);
      }
      if (atId('while')) { next(); expect('('); const cond = expr(); expect(')', "')'"); return mk({ k: 'while', cond, body: statement() }, s); }
      if (atId('for')) {
        next(); expect('(');
        if (isTypeStart() && peek(1).k === 'id' && peek(2).k === ':') {
          const type = parseType(); const name = next().v; next();
          const iter = expr(); expect(')', "')'");
          return mk({ k: 'foreach', type, name, iter, body: statement() }, s);
        }
        let init = null, cond = null, update = null;
        if (!at(';')) { const is = peek(); init = isTypeStart() && peek(1).k === 'id' ? varDecl(is, false) : simple(is); if (at(',')) throw new Unsupported('more than one statement in a for header is not supported here.', s.line); }
        expect(';', "';'");
        if (!at(';')) cond = expr();
        expect(';', "';'");
        if (!at(')')) { update = simple(peek()); if (at(',')) throw new Unsupported('more than one update in a for header is not supported here.', s.line); }
        expect(')', "')'");
        return mk({ k: 'for', init, cond, update, body: statement() }, s);
      }
      if (atId('return')) { next(); const e = at(';') ? null : expr(); expect(';', "';'"); return mk({ k: 'return', e }, s); }
      if (at('id') && ['break', 'continue', 'do', 'switch', 'try', 'throw', 'class', 'final'].includes(peek().v)) throw new Unsupported(`${peek().v} is not supported here.`, s.line);
      if (at('id') && ['public', 'private', 'static', 'protected'].includes(peek().v)) throw new CompileError('illegal start of expression: methods must be declared outside other methods and statements', s.line);
      if (isTypeStart() && (peek(1).k === 'id' || peek(1).k === '<' || (peek(1).k === '[' && peek(2).k === ']'))) return varDecl(s, true);
      const st = simple(s);
      expect(';', "';'");
      return st;
    }
    function isMethodStart() {
      let k = 0;
      while (peek(k).k === 'id' && ['public', 'private', 'protected', 'static', 'final'].includes(peek(k).v)) k++;
      if (k === 0) return false;
      return true;
    }
    const methods = [], main = [];
    while (!at('end')) {
      const s = peek();
      if (atId('class') || (atId('public') && peek(1).k === 'id' && peek(1).v === 'class')) throw new Unsupported('write methods and statements directly; this tool supplies the class around them.', s.line);
      if (isMethodStart()) {
        let isStatic = false;
        while (at('id') && ['public', 'private', 'protected', 'static', 'final'].includes(peek().v)) { if (next().v === 'static') isStatic = true; }
        if (!isStatic) throw new Unsupported('this tool supports static methods only.', s.line);
        const ret = parseType();
        const name = expect('id', 'method name').v;
        if (at('=') || at(';') || at(',')) throw new Unsupported('static variables (fields declared outside a method) are not supported here.', s.line);
        expect('(');
        const params = [];
        if (!at(')')) {
          do { if (at(',')) next(); const pt = parseType(); const pn = expect('id', 'parameter name').v; params.push({ type: pt, name: pn }); } while (at(','));
        }
        expect(')', "')'");
        const body = block();
        methods.push(mk({ k: 'method', ret, name, params, body }, s));
      } else main.push(statement());
    }
    return { methods, main };
  }

  /* ---------------- Types (javac's job) ---------------- */
  const ELEM = t => t.endsWith('[]') ? t.slice(0, -2) : t.startsWith('ArrayList<') ? t.slice(10, -1) : null;
  const UNBOX = { Integer: 'int', Double: 'double' };
  // Real ArrayList methods beyond the AP subset: valid Java this tool does not run.
  const ARRAYLIST_METHODS = ['contains', 'indexOf', 'lastIndexOf', 'isEmpty', 'clear', 'addAll', 'removeAll', 'retainAll', 'containsAll', 'removeIf', 'sort', 'toArray', 'iterator', 'listIterator', 'forEach', 'subList', 'equals', 'hashCode', 'toString', 'stream', 'clone', 'replaceAll', 'ensureCapacity', 'trimToSize', 'spliterator', 'getClass', 'reversed', 'getFirst', 'getLast', 'addFirst', 'addLast', 'removeFirst', 'removeLast'];
  const numeric = t => t === 'int' || t === 'double' || t === 'Integer' || t === 'Double';
  const prim = t => UNBOX[t] || t;
  const isRef = t => !PRIM.includes(t) && t !== 'void';
  function assignable(to, from) {
    if (to === from) return true;
    if (from === 'null') return isRef(to);
    if (to === 'double' && (from === 'int' || from === 'Integer' || from === 'Double')) return true;
    if (to === 'int' && from === 'Integer') return true;
    if (to === 'Integer' && from === 'int') return true;
    if (to === 'Double' && from === 'double') return true;
    return false;
  }
  function check(prog) {
    const mtab = new Map();
    for (const m of prog.methods) {
      if (m.name === 'main') throw new Unsupported('write the statements for main directly; this tool supplies main.', m.line);
      if (mtab.has(m.name)) throw new Unsupported('overloaded methods (two methods with the same name) are not supported here.', m.line);
      if (m.params.some(pp => pp.type === 'void')) throw new CompileError("'void' type not allowed here", m.line);
      mtab.set(m.name, m);
    }
    let scopes, retType, deferred = null;   // deferred: valid Java this tool cannot run, reported only if nothing else is wrong
    const lookup = (name, line) => { for (let i = scopes.length - 1; i >= 0; i--) if (scopes[i].has(name)) return scopes[i].get(name); throw new CompileError(`cannot find symbol: variable ${name}`, line); };
    const declare = (name, type, line) => {
      for (const sc of scopes) if (sc.has(name)) throw new CompileError(`variable ${name} is already defined in this method`, line);
      scopes[scopes.length - 1].set(name, type);
    };
    function ty(n) {
      const T = (() => {
        switch (n.k) {
          case 'lit':
            if (n.big) throw new CompileError('integer number too large: 2147483648', n.line);
            return n.type;
          case 'var': return lookup(n.name, n.line);
          case 'assignExpr': {
            const tt = ty(n.target), t = ty(n.e);
            if (n.op === '=' ? !assignable(tt, t) : !(tt === 'String' && n.op === '+=') && !(numeric(tt) && numeric(t))) throw new CompileError(`incompatible types: ${t} cannot be converted to ${tt}`, n.line);
            deferred = deferred || new Unsupported('assignment inside an expression is not supported here.', n.line);
            return tt;
          }
          case 'class': throw new CompileError(`${n.name} is a class name, not a value`, n.line);
          case 'unary': {
            if (n.op === '-' && n.e.k === 'lit' && n.e.big) { n.e.type = 'int'; return 'int'; }   // -2147483648 is legal only negated
            const a = ty(n.e);
            if (n.op === '!') { if (a !== 'boolean') throw new CompileError(`bad operand type ${a} for unary operator '!'`, n.line); return 'boolean'; }
            if (!numeric(a)) throw new CompileError(`bad operand type ${a} for unary operator '${n.op}'`, n.line);
            return prim(a);
          }
          case 'cast': { const a = ty(n.e); if (!numeric(a)) throw new CompileError(`incompatible types: ${a} cannot be converted to ${n.to}`, n.line); return n.to; }
          case 'bin': {
            const a = ty(n.l), b = ty(n.r), op = n.op;
            if (a === 'void' || b === 'void') throw new CompileError("'void' type not allowed here", n.line);
            if (op === '&&' || op === '||') { if (a !== 'boolean' || b !== 'boolean') throw new CompileError(`bad operand types for binary operator '${op}' (${a} and ${b})`, n.line); return 'boolean'; }
            if (op === '+' && (a === 'String' || b === 'String')) {
              const other = a === 'String' ? b : a;
              if (other === 'Player' || other.endsWith('[]')) throw new Unsupported(`joining ${other === 'Player' ? 'a Player' : 'an array'} to a String prints something like ${other === 'Player' ? 'Player' : '[I'}@1b6d3586, which varies.`, n.line);
              return 'String';
            }
            if (['+', '-', '*', '/', '%'].includes(op)) {
              if (!numeric(a) || !numeric(b)) throw new CompileError(`bad operand types for binary operator '${op}' (${a} and ${b})`, n.line);
              return prim(a) === 'double' || prim(b) === 'double' ? 'double' : 'int';
            }
            if (['<', '<=', '>', '>='].includes(op)) {
              if (!numeric(a) || !numeric(b)) throw new CompileError(`bad operand types for binary operator '${op}' (${a} and ${b})`, n.line);
              return 'boolean';
            }
            // == and !=
            if (numeric(a) && numeric(b)) {
              if ((a === 'Integer' || a === 'Double') && (b === 'Integer' || b === 'Double')) throw new Unsupported('comparing two Integer objects with == depends on object identity; use equals, or compare int values.', n.line);
              return 'boolean';
            }
            if (a === 'boolean' && b === 'boolean') return 'boolean';
            if (a === 'String' && b === 'String') throw new Unsupported('comparing two Strings with == compares object identity; use equals (the Memory Diagram shows why).', n.line);
            if (isRef(a) && isRef(b) && (a === b || a === 'null' || b === 'null')) return 'boolean';
            throw new CompileError(`incomparable types: ${a} and ${b}`, n.line);
          }
          case 'index': {
            const a = ty(n.arr), i = ty(n.i);
            if (!a.endsWith('[]')) throw new CompileError(`array required, but ${a} found`, n.line);
            if (prim(i) !== 'int') throw new CompileError(`incompatible types: ${i} cannot be converted to int`, n.line);
            return ELEM(a);
          }
          case 'field': {
            if (n.recv.k === 'class' && n.recv.name === 'Integer' && (n.name === 'MAX_VALUE' || n.name === 'MIN_VALUE')) return 'int';
            if (n.recv.k === 'class') throw new Unsupported(`${n.recv.name}.${n.name} is not supported here.`, n.line);
            const r = ty(n.recv);
            if (r.endsWith('[]') && n.name === 'length') return 'int';
            if (r === 'String' && n.name === 'length') throw new CompileError('cannot find symbol: length is a method for Strings, so write length()', n.line);
            if (r.startsWith('ArrayList') && (n.name === 'length' || n.name === 'size')) throw new CompileError(`cannot find symbol: ${n.name}. An ArrayList uses the method size()`, n.line);
            throw new CompileError(`cannot find symbol: ${n.name}`, n.line);
          }
          case 'newArr': { if (prim(ty(n.n)) !== 'int') throw new CompileError('incompatible types: the array size must be an int', n.line); return n.elem + '[]'; }
          case 'arrInit': {
            for (const it of n.items) { const t2 = ty(it); if (!assignable(n.elem, t2)) throw new CompileError(`incompatible types: ${t2} cannot be converted to ${n.elem}`, it.line); }
            return n.elem + '[]';
          }
          case 'newList': return n.elem ? `ArrayList<${n.elem}>` : 'ArrayList<?>';
          case 'newPlayer': {
            const ts = n.args.map(ty);
            if (ts.length !== 2 || !assignable('String', ts[0]) || !assignable('int', ts[1])) throw new CompileError('constructor Player cannot be applied to given types: it needs (String name, int score)', n.line);
            return 'Player';
          }
          case 'scall': {
            const m = mtab.get(n.name);
            if (!m) throw new CompileError(`cannot find symbol: method ${n.name}`, n.line);
            const ts = n.args.map(ty);
            if (ts.length !== m.params.length || ts.some((t2, i) => !assignable(m.params[i].type, t2))) throw new CompileError(`method ${n.name} cannot be applied to given types: it needs (${m.params.map(q => q.type).join(', ')})`, n.line);
            n.method = m;
            return m.ret;
          }
          case 'call': return callType(n);
        }
      })();
      n.type = T;
      return T;
    }
    function callType(n) {
      if (n.recv.k === 'class') {
        const ts = n.args.map(ty);
        if (n.recv.name === 'Math') {
          if (n.name === 'random') throw new Unsupported('Math.random() is not supported in this tool, because each run would differ; the Range Builder covers it.', n.line);
          const need = { abs: 1, sqrt: 1, pow: 2 }[n.name];
          if (!need) throw new Unsupported(`Math.${n.name} is not supported here (abs, pow and sqrt are).`, n.line);
          if (ts.length !== need || !ts.every(numeric)) throw new CompileError(`Math.${n.name} cannot be applied to these arguments`, n.line);
          return n.name === 'abs' ? prim(ts[0]) : 'double';
        }
        if (n.recv.name === 'Integer' && n.name === 'valueOf' && ts.length === 1 && prim(ts[0]) === 'int') return 'Integer';
        throw new Unsupported(`${n.recv.name}.${n.name}(…) is not supported here.`, n.line);
      }
      const r = ty(n.recv), ts = n.args.map(ty);
      if (PRIM.includes(r)) throw new CompileError(`${r} cannot be dereferenced: an ${r} is not an object, so it has no methods`, n.line);
      if (r === 'null' || r === 'void') throw new CompileError(`${r} cannot be dereferenced`, n.line);
      if (r === 'String') {
        if (n.name === 'length' && !ts.length) return 'int';
        if (n.name === 'substring' && (ts.length === 1 || ts.length === 2) && ts.every(x => prim(x) === 'int')) return 'String';
        if (n.name === 'indexOf' && ts.length === 1 && ts[0] === 'String') return 'int';
        if (n.name === 'equals' && ts.length === 1) return 'boolean';
        if (n.name === 'compareTo' && ts.length === 1 && assignable('String', ts[0])) return 'int';
        if (['length', 'substring', 'compareTo'].includes(n.name)) throw new CompileError(`method ${n.name} in class String cannot be applied to these arguments`, n.line);
        throw new Unsupported(`the String method ${n.name}(…) is not supported here (length, substring, indexOf, equals and compareTo are).`, n.line);
      }
      if (r === 'Player') {
        const sig = { getName: [[], 'String'], getScore: [[], 'int'], addScore: [['int'], 'void'] }[n.name];
        if (n.name === 'equals' && ts.length === 1) return 'boolean';
        if (!sig) throw new CompileError(`cannot find symbol: method ${n.name} in class Player`, n.line);
        if (ts.length !== sig[0].length || ts.some((x, i) => !assignable(sig[0][i], x))) throw new CompileError(`method ${n.name} in class Player cannot be applied to given types`, n.line);
        return sig[1];
      }
      if (r.startsWith('ArrayList')) {
        const e = ELEM(r);
        if (e === '?') throw new Unsupported('give the ArrayList an element type, such as new ArrayList<Integer>().', n.line);
        switch (n.name) {
          case 'size': if (!ts.length) return 'int'; break;
          case 'get': if (ts.length === 1 && prim(ts[0]) === 'int') return e; break;
          case 'set': if (ts.length === 2 && prim(ts[0]) === 'int' && assignable(e, ts[1])) return e; break;
          case 'add':
            if (ts.length === 1 && assignable(e, ts[0])) return 'boolean';
            if (ts.length === 2 && prim(ts[0]) === 'int' && assignable(e, ts[1])) return 'void';
            break;
          case 'remove':
            if (ts.length === 1 && ts[0] === 'int') { n.byIndex = true; return e; }
            // Any other argument boxes to an object: remove(Object) removes by value.
            // equals() is true only for the same boxed class: Double 4.0 never equals Integer 4.
            if (ts.length === 1 && ts[0] !== 'void') { n.byIndex = false; n.argBox = { double: 'Double', boolean: 'Boolean' }[ts[0]] || ts[0]; return 'boolean'; }
            break;
          default:
            if (!ARRAYLIST_METHODS.includes(n.name)) throw new CompileError(`cannot find symbol: method ${n.name}(…) in class ArrayList`, n.line);
            throw new Unsupported(`the ArrayList method ${n.name}(…) is not supported here (size, get, set, add and remove are).`, n.line);
        }
        throw new CompileError(`method ${n.name} in class ArrayList<${e}> cannot be applied to these arguments`, n.line);
      }
      if (r.endsWith('[]')) throw new CompileError(`cannot find symbol: method ${n.name}; arrays have a length field, not methods`, n.line);
      if (r === 'Integer' || r === 'Double') throw new Unsupported(`calling methods on ${r} objects is not supported here.`, n.line);
      throw new CompileError(`cannot find symbol: method ${n.name}`, n.line);
    }
    const constVal = n => {
      if (n.k === 'lit' && n.type === 'boolean') return n.v;
      if (n.k === 'unary' && n.op === '!') { const v = constVal(n.e); return v === undefined ? undefined : !v; }
      if (n.k === 'bin' && (n.op === '&&' || n.op === '||')) { const a = constVal(n.l), b = constVal(n.r); if (a === undefined || b === undefined) return undefined; return n.op === '&&' ? a && b : a || b; }
      if (n.k === 'bin' && ['<', '<=', '>', '>=', '==', '!='].includes(n.op) && n.l.k === 'lit' && n.r.k === 'lit' && numeric(n.l.type) && numeric(n.r.type)) {
        const a = n.l.v, b = n.r.v;
        return { '<': a < b, '<=': a <= b, '>': a > b, '>=': a >= b, '==': a === b, '!=': a !== b }[n.op];
      }
      return undefined;
    };
    // Returns whether the statement can complete normally (JLS 14.22), reporting unreachable code.
    function st(n) {
      switch (n.k) {
        case 'block': {
          scopes.push(new Map());
          let ok = true;
          for (const s of n.body) {
            if (!ok) throw new CompileError('unreachable statement', s.line);
            ok = st(s);
          }
          scopes.pop();
          return ok;
        }
        case 'empty': return true;
        case 'decl': {
          if (n.type === 'void') throw new CompileError("'void' type not allowed here", n.line);
          const t = ty(n.init);
          if (t === 'ArrayList<?>' && n.type.startsWith('ArrayList<')) { n.init.type = n.type; n.init.elem = ELEM(n.type); }
          else if (!assignable(n.type, t)) throw new CompileError(`incompatible types: ${t} cannot be converted to ${n.type}`, n.line);
          declare(n.name, n.type, n.line);
          return true;
        }
        case 'assign': {
          const tt = n.target.k === 'var' ? lookup(n.target.name, n.line) : ty(n.target);
          n.target.type = tt;
          const t = ty(n.e);
          if (n.op === '=') {
            if (t === 'ArrayList<?>' && tt.startsWith('ArrayList<')) { n.e.type = tt; n.e.elem = ELEM(tt); }
            else if (!assignable(tt, t)) throw new CompileError(`incompatible types: ${t} cannot be converted to ${tt}`, n.line);
          } else {
            // Compound assignment: E1 op= E2 means E1 = (T) (E1 op E2) (JLS 15.26.2).
            if (n.op === '+=' && tt === 'String') return true;
            if (!numeric(tt) || !numeric(t)) throw new CompileError(`bad operand types for binary operator '${n.op[0]}' (${tt} and ${t})`, n.line);
            if (tt === 'Integer' || tt === 'Double') throw new Unsupported(`compound assignment on ${tt} variables is not supported here.`, n.line);
          }
          return true;
        }
        case 'incdec': {
          const tt = n.target.k === 'var' ? lookup(n.target.name, n.line) : ty(n.target);
          n.target.type = tt;
          if (!numeric(tt)) throw new CompileError(`bad operand type ${tt} for unary operator '${n.op}'`, n.line);
          if (tt === 'Integer' || tt === 'Double') throw new Unsupported(`${n.op} on ${tt} variables is not supported here.`, n.line);
          return true;
        }
        case 'print': {
          if (n.args.length > 1) throw new CompileError('print and println take at most one argument', n.line);
          if (!n.args.length && !n.ln) throw new CompileError('System.out.print() needs something to print', n.line);
          if (n.args.length) {
            const t = ty(n.args[0]);
            if (t === 'void') throw new CompileError("'void' type not allowed here", n.line);
            if (t === 'Player' || t.endsWith('[]')) throw new Unsupported(`printing ${t === 'Player' ? 'a Player' : 'an array'} directly shows something like ${t === 'Player' ? 'Player' : '[I'}@1b6d3586, which varies.`, n.line);
            if (t === 'null') throw new Unsupported('println(null) is ambiguous in Java; print a variable instead.', n.line);
          }
          return true;
        }
        case 'exprStmt': {
          const e = n.e;
          if (!['call', 'scall', 'newPlayer', 'newList'].includes(e.k)) throw new CompileError('not a statement', n.line);
          ty(e);
          return true;
        }
        case 'if': {
          if (ty(n.cond) !== 'boolean') throw new CompileError(`incompatible types: ${n.cond.type} cannot be converted to boolean`, n.line);
          scopes.push(new Map()); const a = st(n.then); scopes.pop();
          if (!n.els) return true;
          scopes.push(new Map()); const b = st(n.els); scopes.pop();
          return a || b;
        }
        case 'while': {
          if (ty(n.cond) !== 'boolean') throw new CompileError(`incompatible types: ${n.cond.type} cannot be converted to boolean`, n.line);
          const c = constVal(n.cond);
          if (c === false) throw new CompileError('unreachable statement: the loop condition is always false, so the body can never run', n.body.line);
          scopes.push(new Map()); st(n.body); scopes.pop();
          return c !== true;
        }
        case 'for': {
          scopes.push(new Map());
          if (n.init) st(n.init);
          let c;
          if (n.cond) {
            if (ty(n.cond) !== 'boolean') throw new CompileError(`incompatible types: ${n.cond.type} cannot be converted to boolean`, n.line);
            c = constVal(n.cond);
            if (c === false) throw new CompileError('unreachable statement: the loop condition is always false, so the body can never run', n.body.line);
          } else c = true;
          if (n.update) st(n.update);
          scopes.push(new Map()); st(n.body); scopes.pop();
          scopes.pop();
          return c !== true;
        }
        case 'foreach': {
          const it = ty(n.iter), e = ELEM(it);
          if (!e || it === 'ArrayList<?>') throw new CompileError(`for-each not applicable to expression type ${it}`, n.line);
          if (!assignable(n.type, e)) throw new CompileError(`incompatible types: ${e} cannot be converted to ${n.type}`, n.line);
          scopes.push(new Map()); declare(n.name, n.type, n.line); st(n.body); scopes.pop();
          return true;
        }
        case 'return': {
          if (retType === null) throw new Unsupported('return in the main statements is not supported here.', n.line);
          if (retType === 'void') { if (n.e) throw new CompileError('incompatible types: unexpected return value in a void method', n.line); return false; }
          if (!n.e) throw new CompileError('missing return value', n.line);
          const t = ty(n.e);
          if (!assignable(retType, t)) throw new CompileError(`incompatible types: ${t} cannot be converted to ${retType}`, n.line);
          return false;
        }
      }
      throw new Unsupported('this statement is not supported here.', n.line);
    }
    for (const m of prog.methods) {
      scopes = [new Map()]; retType = m.ret;
      for (const q of m.params) declare(q.name, q.type, m.line);
      const completes = st(m.body);
      if (completes && m.ret !== 'void') throw new CompileError(`missing return statement in ${m.name}`, m.body.end ? m.line : m.line);
    }
    scopes = [new Map()]; retType = null;
    let ok = true;
    for (const s of prog.main) { if (!ok) throw new CompileError('unreachable statement', s.line); ok = st(s); }
    if (deferred) throw deferred;
    return mtab;
  }

  /* ---------------- Running ---------------- */
  function run(src, opts = {}) {
    const maxOps = opts.maxOps || 200000, maxSteps = opts.maxSteps || 3000, maxDepth = opts.maxDepth || 200;
    nodeSeq = 0;
    let prog, mtab;
    try { prog = parse(src); mtab = check(prog); }
    catch (e) {
      if (e instanceof CompileError) return { compileError: e.message, line: e.line, steps: [] };
      if (e instanceof Unsupported) return { unsupported: e.message, line: e.line, steps: [] };
      throw e;
    }
    const steps = [];
    let out = '', ops = 0, heapSeq = 0, truncated = false;
    // Loop totals are counted as the program runs, not read back from the saved steps, so they stay right
    // when the step list is full (maxSteps) and the animation stops recording.
    let loopChecks = 0, loopBodies = 0;
    const lc = ran => { loopChecks++; if (ran) loopBodies++; };
    const frames = [{ name: 'main', scopes: [new Map()], line: 0 }];
    const loops = new Map();   // loop node id -> { line, kind, iterations of the current run }
    const fr = () => frames[frames.length - 1];
    const tick = line => { if (++ops > maxOps) throw new ToolLimit('steps', line); };
    const newObj = o => ({ hid: ++heapSeq, ...o });
    const text = (t, v) => {
      if (v === null) return 'null';
      if (t === 'double' || t === 'Double') return javaDouble(v);
      if (t && t.startsWith('ArrayList')) { const e = ELEM(t); return '[' + v.values.map(x => text(e, x)).join(', ') + ']'; }
      return String(v);
    };
    const show = (t, v) => {
      if (v !== null && typeof v === 'object' && v.kind !== 'list') return `→ ${v.kind === 'player' ? 'Player' : 'array'} #${v.hid}`;
      return t === 'String' && v !== null ? JSON.stringify(v) : text(t, v);
    };
    // For call and return notes: a reference reads as the object it points to.
    const showRef = (t, v) => v !== null && typeof v === 'object' ? `→ ${v.kind === 'player' ? 'Player' : v.kind === 'list' ? 'ArrayList' : 'array'} #${v.hid}` : show(t, v);
    const snapVal = (t, v) => (v !== null && typeof v === 'object') ? { ref: v.hid } : v;
    function snapshot() {
      const heap = {};
      const visit = o => {
        if (!o || typeof o !== 'object' || heap[o.hid]) return;
        if (o.kind === 'array' || o.kind === 'list') {
          heap[o.hid] = { hid: o.hid, kind: o.kind, elem: o.elem, values: o.values.map(x => snapVal(o.elem, x)) };
          if (o.elem === 'Player') o.values.forEach(visit);
        } else if (o.kind === 'player') heap[o.hid] = { hid: o.hid, kind: 'player', name: o.name, score: o.score };
      };
      const fs = frames.map(f => {
        const vars = [];
        for (const sc of f.scopes) for (const [name, cell] of sc) { vars.push({ name, type: cell.type, v: snapVal(cell.type, cell.v) }); visit(cell.v); }
        return { name: f.name, line: f.line, vars, args: f.args, params: f.params || [] };
      });
      return { frames: fs, heap };
    }
    function record(kind, node, note, extra = {}) {
      if (steps.length >= maxSteps) { truncated = true; return; }
      steps.push({ kind, line: node.line, note, out, depth: frames.length, ...snapshot(), ...extra });
    }
    const lookupCell = name => { const f = fr(); for (let i = f.scopes.length - 1; i >= 0; i--) if (f.scopes[i].has(name)) return f.scopes[i].get(name); throw new Error('unknown variable ' + name); };
    const npe = (line, what) => { throw new JavaThrow('NullPointerException', line, `${what} is null, so there is no object to use.`); };
    function num(t, v) { return v; }
    function arith(op, a, b, t, line) {
      if (t === 'int') {
        if ((op === '/' || op === '%') && b === 0) throw new JavaThrow('ArithmeticException', line, 'Integer division by zero has no answer.');
        if (op === '+') return (a + b) | 0;
        if (op === '-') return (a - b) | 0;
        if (op === '*') return Math.imul(a, b);
        if (op === '/') return toInt32(Math.trunc(a / b));
        return (a % b) | 0;
      }
      return op === '+' ? a + b : op === '-' ? a - b : op === '*' ? a * b : op === '/' ? a / b : a % b;
    }
    function conv(to, from, v, line) {
      if ((to === 'int' || to === 'double') && (from === 'Integer' || from === 'Double') && v === null)
        npe(line, 'the ' + from + ' value being converted to ' + to);
      return v;
    }
    // Condition trees: which parts of a boolean expression were evaluated, and their values.
    let treeRec = null;
    function ev(n) {
      tick(n.line);
      let v;
      try { v = ev0(n); }
      catch (e) { if (e instanceof JavaThrow && e.node === undefined) e.node = n.id; throw e; }
      if (treeRec) treeRec.set(n.id, v);
      return v;
    }
    function ev0(n) {
      switch (n.k) {
        case 'lit': return n.v;
        case 'var': return lookupCell(n.name).v;
        case 'unary': {
          if (n.e.big) return INT_MIN;
          const a = n.op === '!' ? ev(n.e) : conv(prim(n.e.type), n.e.type, ev(n.e), n.line);
          if (n.op === '!') return !a;
          if (n.op === '+') return a;
          return n.type === 'int' ? (-a) | 0 : -a;
        }
        case 'cast': { const a = conv(n.to, n.e.type, ev(n.e), n.line); return n.to === 'int' ? (n.e.type === 'int' || n.e.type === 'Integer' ? a : castToInt(a)) : a; }
        case 'bin': {
          if (n.op === '&&') { const a = ev(n.l); return a ? ev(n.r) : false; }
          if (n.op === '||') { const a = ev(n.l); return a ? true : ev(n.r); }
          const a = ev(n.l), b = ev(n.r), lt = n.l.type, rt = n.r.type;
          if (n.type === 'String') return text(lt, a) + text(rt, b);
          // Unboxing a null Integer or Double for arithmetic or a numeric comparison throws.
          const numericOp = ['+', '-', '*', '/', '%', '<', '<=', '>', '>='].includes(n.op) || (numeric(lt) && numeric(rt));
          if (numericOp) {
            if ((lt === 'Integer' || lt === 'Double') && a === null) npe(n.line, n.l.src);
            if ((rt === 'Integer' || rt === 'Double') && b === null) npe(n.line, n.r.src);
          }
          if (['+', '-', '*', '/', '%'].includes(n.op)) return arith(n.op, a, b, n.type, n.line);
          if (['<', '<=', '>', '>='].includes(n.op)) return { '<': a < b, '<=': a <= b, '>': a > b, '>=': a >= b }[n.op];
          const same = a === b;
          return n.op === '==' ? same : !same;
        }
        case 'index': {
          const arr = ev(n.arr), i = conv('int', n.i.type, ev(n.i), n.line);
          if (arr === null) npe(n.line, n.arr.src);
          if (i < 0 || i >= arr.values.length) throw new JavaThrow('ArrayIndexOutOfBoundsException', n.line, `Index ${i} is outside the array, whose indexes run from 0 to ${arr.values.length - 1}.`);
          return arr.values[i];
        }
        case 'field': {
          if (n.recv.k === 'class') return n.name === 'MAX_VALUE' ? INT_MAX : INT_MIN;
          const r = ev(n.recv);
          if (r === null) npe(n.line, n.recv.src);
          return r.values.length;
        }
        case 'newArr': {
          const len = conv('int', n.n.type, ev(n.n), n.line);
          if (len < 0) throw new JavaThrow('NegativeArraySizeException', n.line, `An array cannot have ${len} elements.`);
          const d = n.elem === 'int' ? 0 : n.elem === 'double' ? 0 : n.elem === 'boolean' ? false : null;
          return newObj({ kind: 'array', elem: n.elem, values: new Array(len).fill(d) });
        }
        case 'arrInit': return newObj({ kind: 'array', elem: n.elem, values: n.items.map(it => conv(n.elem, it.type, ev(it), it.line)) });
        case 'newList': return newObj({ kind: 'list', elem: n.elem, values: [], modCount: 0 });
        case 'newPlayer': { const a = n.args.map(ev); return newObj({ kind: 'player', name: a[0], score: conv('int', n.args[1].type, a[1], n.line) }); }
        case 'scall': return invoke(n);
        case 'call': return method(n);
      }
    }
    function method(n) {
      if (n.recv.k === 'class') {
        const a = n.args.map(ev);
        if (n.recv.name === 'Integer') return conv('int', n.args[0].type, a[0], n.line);
        const nums = a.map((v, i) => conv(prim(n.args[i].type), n.args[i].type, v, n.line));
        if (n.name === 'abs') return n.type === 'int' ? toInt32(Math.abs(nums[0])) : Math.abs(nums[0]);
        if (n.name === 'sqrt') return Math.sqrt(nums[0]);
        return Math.pow(nums[0], nums[1]);
      }
      const r = ev(n.recv), a = n.args.map(ev);
      if (r === null) npe(n.line, n.recv.src);
      const rt = n.recv.type;
      if (rt === 'String') {
        if (n.name === 'length') return r.length;
        if (n.name === 'equals') return n.args[0].type === 'String' && a[0] === r;
        if (n.name === 'indexOf') { if (a[0] === null) npe(n.line, n.args[0].src); return r.indexOf(a[0]); }
        if (n.name === 'compareTo') {
          if (a[0] === null) npe(n.line, n.args[0].src);
          const lim = Math.min(r.length, a[0].length);
          for (let k = 0; k < lim; k++) if (r.charCodeAt(k) !== a[0].charCodeAt(k)) return r.charCodeAt(k) - a[0].charCodeAt(k);
          return r.length - a[0].length;
        }
        const b = conv('int', n.args[0].type, a[0], n.line), e = a.length > 1 ? conv('int', n.args[1].type, a[1], n.line) : r.length;
        if (b < 0 || e > r.length || b > e) throw new JavaThrow('StringIndexOutOfBoundsException', n.line, `substring(${a.join(', ')}) is outside ${JSON.stringify(r)}, whose length is ${r.length}.`);
        return r.slice(b, e);
      }
      if (rt === 'Player') {
        if (n.name === 'equals') return n.args[0].type === 'Player' && r === a[0];
        if (n.name === 'getName') return r.name;
        if (n.name === 'getScore') return r.score;
        const old = r.score; r.score = (r.score + conv('int', n.args[0].type, a[0], n.line)) | 0;
        record('mutate', n, `addScore changes the Player that ${n.recv.src} refers to: its score goes from ${old} to ${r.score}.`, { obj: r.hid });
        return undefined;
      }
      // ArrayList
      const L = r.values, size = L.length, e = ELEM(rt);
      if (['get', 'set'].includes(n.name) || n.name === 'add' && a.length === 2 || n.name === 'remove' && n.byIndex) a[0] = conv('int', n.args[0].type, a[0], n.line);
      const oob = (i, hi) => { throw new JavaThrow('IndexOutOfBoundsException', n.line, `Index ${i} is out of bounds for length ${size}: valid indexes here are 0 to ${hi}.`); };
      switch (n.name) {
        case 'size': return size;
        case 'get': if (a[0] < 0 || a[0] >= size) oob(a[0], size - 1); return L[a[0]];
        case 'set': {
          if (a[0] < 0 || a[0] >= size) oob(a[0], size - 1);
          const old = L[a[0]]; L[a[0]] = a[1];
          record('list', n, `set(${a[0]}, ${show(e, a[1])}) replaces ${show(e, old)} at index ${a[0]}. Nothing moves, and the size stays ${size}.`, { list: { hid: r.hid, op: 'set', index: a[0] } });
          return old;
        }
        case 'add':
          if (a.length === 1) {
            L.push(a[0]); r.modCount++;
            record('list', n, `add(${show(e, a[0])}) puts it at the end, index ${size}. The size becomes ${size + 1}.`, { list: { hid: r.hid, op: 'add', index: size } });
            return true;
          }
          if (a[0] < 0 || a[0] > size) oob(a[0], size);
          L.splice(a[0], 0, a[1]); r.modCount++;
          record('list', n, `add(${a[0]}, ${show(e, a[1])}) inserts it at index ${a[0]}.` + (a[0] < size ? ` The elements from index ${a[0]} on each move one place right, to a higher index.` : ''), { list: { hid: r.hid, op: 'insert', index: a[0] } });
          return undefined;
        case 'remove': {
          if (n.byIndex) {
            if (a[0] < 0 || a[0] >= size) oob(a[0], size - 1);
            const old = L.splice(a[0], 1)[0]; r.modCount++;
            record('list', n, `remove(${a[0]}) removes the element at index ${a[0]}, ${show(e, old)}.` + (a[0] < size - 1 ? ` Every later element moves one place left, so the one that was at index ${a[0] + 1} is now at index ${a[0]}.` : ''), { list: { hid: r.hid, op: 'remove', index: a[0] } });
            return old;
          }
          const k = n.argBox !== e && n.argBox !== 'null' ? -1 : L.findIndex(x => e === 'Double' ? Object.is(x, a[0]) : x === a[0]);
          if (k < 0) { record('list', n, `remove(${n.args[0].src.trim()}) looks for an element equal to ${show(e, a[0])}, finds none, and returns false. The list is unchanged.`, { list: { hid: r.hid, op: 'none' } }); return false; }
          L.splice(k, 1); r.modCount++;
          record('list', n, `remove(${n.args[0].src.trim()}) removes the first element equal to ${show(e, a[0])}, found at index ${k}, and returns true. This is remove by value, not by index.` + (k < size - 1 ? ` Later elements move one place left.` : ''), { list: { hid: r.hid, op: 'remove', index: k } });
          return true;
        }
      }
    }
    function invoke(n) {
      const m = n.method, a = n.args.map((arg, i) => conv(m.params[i].type, arg.type, ev(arg), arg.line));
      if (frames.length >= maxDepth) throw new ToolLimit('depth', n.line);
      const scope = new Map();
      m.params.forEach((q, i) => scope.set(q.name, { type: q.type, v: a[i] }));
      const caller = fr().name;
      frames.push({ name: m.name, ret: m.ret, scopes: [scope], line: n.line, params: m.params.map(q => q.name), args: m.params.map((q, i) => `${q.name} = ${showRef(q.type, a[i])}`) });
      const argText = m.params.map((q, i) => `${q.name} = ${showRef(q.type, a[i])}`).join(', ');
      const hasRef = m.params.some(q => isRef(q.type) && q.type !== 'String');
      record('call', m, `Call ${m.name}(${n.args.map(x => x.src.trim()).join(', ')}): a new frame${m.params.length ? ` where ${argText}` : ''}. ${hasRef ? 'A reference parameter gets a copy of the reference, so it refers to the same object as the argument.' : m.params.length ? 'Each parameter gets a copy of its argument.' : ''}`.trim(),
        { callLine: n.line, method: m.name, caller, args: m.params.map((q, i) => ({ name: q.name, type: q.type, src: n.args[i].src, v: snapVal(q.type, a[i]), text: showRef(q.type, a[i]) })) });
      let ret;
      try { execBlockBody(m.body); ret = undefined; }
      catch (e) { if (e instanceof Ret) ret = e.v; else { throw e; } }
      const f = frames.pop();
      const to = fr().name === m.name ? `the ${m.name} call that was waiting for it` : fr().name;
      record('return', n, m.ret === 'void' ? `${m.name} finishes. Its frame and its variables are removed, and execution continues in ${to}.` : `${m.name} returns ${showRef(m.ret, ret)} to ${to}, and its frame is removed.`,
        { returned: m.ret === 'void' ? undefined : showRef(m.ret, ret), retType: m.ret, retValue: m.ret === 'void' ? undefined : snapVal(m.ret, ret), from: f.name, method: m.name });
      return ret;
    }
    class Ret { constructor(v) { this.v = v; } }
    function execBlockBody(b) { fr().scopes.push(new Map()); try { for (const s of b.body) exec(s); } finally { fr().scopes.pop(); } }
    let lastArr = null;   // the array an element assignment just changed
    function assignTo(target, v, n) {
      if (target.k === 'var') { lookupCell(target.name).v = v; return; }
      const arr = ev(target.arr), i = conv('int', target.i.type, ev(target.i), n.line);
      if (arr === null) npe(n.line, target.arr.src);
      if (i < 0 || i >= arr.values.length) throw new JavaThrow('ArrayIndexOutOfBoundsException', n.line, `Index ${i} is outside the array, whose indexes run from 0 to ${arr.values.length - 1}.`);
      arr.values[i] = v;
      lastArr = arr.hid;
      return i;
    }
    function condition(n, node) {
      treeRec = new Map();
      const v = ev(n);
      const tree = treeRec; treeRec = null;
      return { v, tree: [...tree.entries()] };
    }
    function exec(n) {
      tick(n.line);
      switch (n.k) {
        case 'block': execBlockBody(n); return;
        case 'empty': return;
        case 'decl': {
          const v = conv(n.type, n.init.type, ev(n.init), n.line);
          fr().scopes[fr().scopes.length - 1].set(n.name, { type: n.type, v });
          record('decl', n, `Creates ${n.name} (${n.type}) and stores ${describe(n.type, v)}.`, { changed: [n.name] });
          return;
        }
        case 'assign': {
          const tt = n.target.type;
          const old = n.target.k === 'var' ? lookupCell(n.target.name).v : undefined;
          let v;
          if (n.op === '=') v = ev(n.e);
          else {
            const cur = ev(n.target), rhs = ev(n.e), op = n.op[0];
            if (tt === 'String') v = text('String', cur) + text(n.e.type, rhs);
            else {
              const t = prim(tt) === 'double' || prim(n.e.type) === 'double' ? 'double' : 'int';
              v = arith(op, cur, rhs, t, n.line);
              if (prim(tt) === 'int' && t === 'double') v = castToInt(v);
            }
          }
          if (n.op === '=') v = conv(tt, n.e.type, v, n.line);
          const idx = assignTo(n.target, v, n);
          const who = n.target.k === 'var' ? n.target.name : `${n.target.arr.src}[${idx}]`;
          const note = n.op === '='
            ? `${who} becomes ${describe(tt, v)}${n.target.k === 'var' && old !== undefined && old !== v && (typeof v !== 'object') ? ` (it was ${show(tt, old)})` : ''}.`
            : `${n.op} updates ${who}: it becomes ${show(tt, v)}.` + (prim(tt) === 'int' && prim(n.e.type) === 'double' ? ' The result is cast back to int automatically.' : '');
          record('assign', n, note, { changed: [n.target.k === 'var' ? n.target.name : n.target.arr.src], arrayIndex: idx, obj: n.target.k === 'index' ? lastArr : undefined });
          return;
        }
        case 'incdec': {
          const cur = ev(n.target), tt = n.target.type;
          const v = n.op === '++' ? (prim(tt) === 'int' ? (cur + 1) | 0 : cur + 1) : (prim(tt) === 'int' ? (cur - 1) | 0 : cur - 1);
          const idx = assignTo(n.target, v, n);
          const who = n.target.k === 'var' ? n.target.name : `${n.target.arr.src}[${idx}]`;
          record(n.forUpdate ? 'update' : 'assign', n, `${n.src.trim()} ${n.op === '++' ? 'adds' : 'subtracts'} 1: ${who} goes from ${show(tt, cur)} to ${show(tt, v)}.`, { changed: [n.target.k === 'var' ? n.target.name : n.target.arr.src], arrayIndex: idx, obj: n.target.k === 'index' ? lastArr : undefined });
          return;
        }
        case 'print': {
          const s = n.args.length ? text(n.args[0].type, ev(n.args[0])) : '';
          out += s + (n.ln ? '\n' : '');
          record('print', n, n.args.length ? `${n.ln ? 'println' : 'print'} shows ${JSON.stringify(s)}${n.ln ? ' and ends the line' : ''}.` : 'println() ends the line.', { printed: s });
          return;
        }
        case 'exprStmt': {
          const v = ev(n.e);
          if (n.e.k === 'scall' && n.e.type !== 'void') record('discard', n, `The value ${show(n.e.type, v)} returned by ${n.e.name} is not used.`);
          if (n.e.k === 'call' && n.e.type === 'String') record('discard', n, 'The String returned is not stored, so it is lost. String methods never change the String they are called on.');
          return;
        }
        case 'if': {
          const c = condition(n.cond);
          record('cond', n, `The condition ${n.cond.src} is ${c.v}, so ${c.v ? 'the if branch runs' : n.els ? 'the else branch runs' : 'the if body is skipped'}.`, { cond: n.cond.id, value: c.v, tree: c.tree, branch: c.v ? 'then' : n.els ? 'else' : 'skip' });
          fr().scopes.push(new Map());
          try { if (c.v) exec(n.then); else if (n.els) exec(n.els); } finally { fr().scopes.pop(); }
          return;
        }
        case 'while': {
          let it = 0;
          for (;;) {
            const c = condition(n.cond);
            lc(c.v);
            record('cond', n, c.v ? `Check ${n.cond.src}: true, so the body runs${it ? ' again' : ''} (iteration ${it + 1}).` : `Check ${n.cond.src}: false, so the loop ends after ${it} iteration${it === 1 ? '' : 's'}.`, { loop: n.id, iteration: it + 1, value: c.v, tree: c.tree, cond: n.cond.id });
            if (!c.v) break;
            it++;
            fr().scopes.push(new Map());
            try { exec(n.body); } finally { fr().scopes.pop(); }
          }
          return;
        }
        case 'for': {
          fr().scopes.push(new Map());
          try {
            if (n.init) { if (n.init.k === 'decl') exec(n.init); else exec(n.init); steps.length && (steps[steps.length - 1].phase = 'init'); }
            let it = 0;
            for (;;) {
              let v = true, tree = [];
              if (n.cond) { const c = condition(n.cond); v = c.v; tree = c.tree; }
              lc(v);
              record('cond', n, v ? `Check ${n.cond ? n.cond.src : '(no condition)'}: true, so the body runs (iteration ${it + 1}).` : `Check ${n.cond.src}: false, so the loop ends after ${it} iteration${it === 1 ? '' : 's'}.`, { loop: n.id, iteration: it + 1, value: v, tree, cond: n.cond && n.cond.id, phase: 'cond' });
              if (!v) break;
              it++;
              fr().scopes.push(new Map());
              try { exec(n.body); } finally { fr().scopes.pop(); }
              if (n.update) { n.update.forUpdate = true; exec(n.update); if (steps.length) steps[steps.length - 1].phase = 'update'; }
            }
          } finally { fr().scopes.pop(); }
          return;
        }
        case 'foreach': {
          const coll = ev(n.iter);
          if (coll === null) npe(n.line, n.iter.src);
          const e = ELEM(n.iter.type);
          fr().scopes.push(new Map());
          try {
            if (coll.kind === 'array') {
              for (let i = 0; i < coll.values.length; i++) {
                const v = conv(n.type, e, coll.values[i], n.line);
                fr().scopes[fr().scopes.length - 1].set(n.name, { type: n.type, v });
                lc(true);
                record('foreach', n, `${n.name} gets a copy of the next element, ${show(e, v)} (index ${i}).`, { loop: n.id, iteration: i + 1, changed: [n.name], index: i });
                fr().scopes.push(new Map());
                try { exec(n.body); } finally { fr().scopes.pop(); }
              }
            } else {
              // The iterator that an enhanced for uses on an ArrayList: hasNext() then next(), which checks
              // whether the list was structurally changed (added to or removed from) since the loop began.
              let cursor = 0, it = 0;
              const expected = coll.modCount;
              while (cursor !== coll.values.length) {
                if (coll.modCount !== expected) throw new JavaThrow('ConcurrentModificationException', n.line, 'The list was changed (an add or remove) while the enhanced for loop was walking through it.');
                const v = conv(n.type, e, coll.values[cursor++], n.line);
                fr().scopes[fr().scopes.length - 1].set(n.name, { type: n.type, v });
                lc(true);
                record('foreach', n, `${n.name} gets the next element, ${show(e, v)} (index ${cursor - 1}).`, { loop: n.id, iteration: ++it, changed: [n.name], index: cursor - 1, iter: { hid: coll.hid, cursor } });
                fr().scopes.push(new Map());
                try { exec(n.body); } finally { fr().scopes.pop(); }
              }
              lc(false);
              const size = coll.values.length;
              record('cond', n, it < size || coll.modCount !== expected ? `hasNext() is false: the iterator's cursor is at index ${cursor}, which equals size() ${size}, so the loop ends.` : 'No more elements, so the loop ends.', { loop: n.id, value: false, done: true, iter: { hid: coll.hid, cursor } });
              return;
            }
            lc(false);
            record('cond', n, 'No more elements, so the loop ends.', { loop: n.id, value: false, done: true });
          } finally { fr().scopes.pop(); }
          return;
        }
        case 'return': {
          const v = n.e ? conv(fr().ret, n.e.type, ev(n.e), n.line) : undefined;
          const t = n.e ? n.e.type : 'void';
          record('returning', n, n.e ? `return ${n.e.src.trim()}: the value is ${showRef(t, v)}. ${fr().name} stops here, and this value goes back to the call.` : `return; ends ${fr().name} here.`, { value: n.e ? showRef(t, v) : undefined, method: fr().name });
          throw new Ret(v);
        }
      }
    }
    function describe(t, v) {
      if (v === null) return 'null (no object)';
      if (typeof v === 'object') {
        if (v.kind === 'array') return `a reference to a new array of ${v.values.length} ${v.elem}${v.values.length === 1 ? '' : 's'}`;
        if (v.kind === 'list') return `a reference to an ArrayList with ${v.values.length} element${v.values.length === 1 ? '' : 's'}`;
        if (v.kind === 'player') return `a reference to a Player (${v.name}, ${v.score})`;
      }
      return show(t, v);
    }
    let crashed = null, limit = null;
    try { for (const s of prog.main) exec(s); }
    catch (e) {
      if (e instanceof JavaThrow) {
        crashed = e.javaType;
        // Keep the part of a condition that was evaluated before it threw, and where it threw.
        steps.push({ kind: 'error', line: e.line, note: `${e.why} Java throws a${/^[AEIOU]/.test(e.javaType) ? 'n' : ''} ${e.javaType}, and the program stops.`, out, error: e.javaType, depth: frames.length, failNode: e.node, tree: treeRec ? [...treeRec.entries()] : null, ...snapshot() });
      } else if (e instanceof ToolLimit || e instanceof RangeError && /call stack/i.test(e.message) || e && e.name === 'InternalError') {
        // The browser's own stack can run out before maxDepth; treat that as the same depth limit.
        limit = e instanceof ToolLimit ? e.kind : 'depth';
        const line = e instanceof ToolLimit ? e.line : frames[frames.length - 1].line;
        steps.push({ kind: 'limit', line, note: limit === 'depth' ? `This tool stops at ${frames.length} frames on the call stack. Java itself would keep going deeper before stopping with a StackOverflowError.` : `This tool stopped after ${maxOps.toLocaleString()} operations. The program may have an infinite loop.`, out, depth: frames.length, ...snapshot() });
      } else throw e;
    }
    // The variables of main as they stand when the run ends (after any block scopes have closed), also
    // independent of the saved steps.
    const end = snapshot();
    return { steps, out, crashed, limit, truncated, prog, stats: { checks: loopChecks, iterations: loopBodies }, finalFrame: { vars: end.frames[0].vars, heap: end.heap } };
  }
  function label(r) {
    if (r.compileError) return 'compile-error';
    if (r.unsupported) return 'unsupported';
    if (r.limit) return 'limit';
    return r.crashed ? `${r.out}|throws:${r.crashed}` : r.out;
  }
  // The loops in a program with their nesting, for the loop and nested-loop views.
  function loopsOf(prog) {
    const found = [];
    const walk = (n, parent) => {
      if (!n || typeof n !== 'object') return;
      if (['while', 'for', 'foreach'].includes(n.k)) { found.push({ id: n.id, k: n.k, line: n.line, bodyLine: n.body.line, endPos: n.end, parent, var: n.k === 'for' && n.init && n.init.k === 'decl' ? n.init.name : n.k === 'foreach' ? n.name : null }); parent = n.id; }
      for (const key of ['body', 'then', 'els', 'main']) { const c = n[key]; if (Array.isArray(c)) c.forEach(x => walk(x, parent)); else if (c) walk(c, parent); }
      if (n.k === 'block') n.body.forEach(x => walk(x, parent));
    };
    prog.methods.forEach(m => walk(m.body, null));
    prog.main.forEach(s => walk(s, null));
    return found;
  }
  // Rewrites every for loop whose body is a block as the equivalent while loop, wrapped in its own
  // block so the loop variable keeps its limited scope: for (init; cond; update) { body } becomes
  // { init; while (cond) { body update; } }.
  function forToWhile(src) {
    // Rewrite one loop at a time (the last one in the text, so an inner loop goes before its outer
    // loop), re-parsing after each rewrite so every position is current.
    const findFors = text => {
      nodeSeq = 0;
      const prog = parse(text), fors = [];
      const walk = n => {
        if (!n || typeof n !== 'object') return;
        if (n.k === 'for') fors.push(n);
        for (const key of ['body', 'then', 'els', 'init', 'update']) { const c = n[key]; if (Array.isArray(c)) c.forEach(walk); else if (c && typeof c === 'object') walk(c); }
      };
      prog.methods.forEach(m => walk(m.body)); prog.main.forEach(walk);
      return fors.filter(f => f.body.k === 'block' && f.cond);
    };
    let out = src, changed = false;
    for (let guard = 0; guard < 50; guard++) {
      const fors = findFors(out);
      if (!fors.length) break;
      const f = fors.sort((a, b) => b.pos - a.pos)[0];
      const indent = (/[ \t]*$/.exec(out.slice(0, f.pos)) || [''])[0];
      const inner = out.slice(f.body.pos + 1, f.body.end - 1).replace(/^[ \t]*\n/, '').replace(/\s+$/, '');
      const pad = indent + '    ';
      const lines = ['{'];
      if (f.init) lines.push(pad + f.init.src.trim().replace(/;$/, '') + ';');
      lines.push(`${pad}while (${f.cond.src}) {`);
      if (inner) lines.push(inner.split('\n').map(l => l.trim() ? '    ' + l : l).join('\n'));
      if (f.update) lines.push(`${pad}    ${f.update.src.trim().replace(/;$/, '')};`);
      lines.push(`${pad}}`, `${indent}}`);
      out = out.slice(0, f.pos) + lines.join('\n') + out.slice(f.end);
      changed = true;
    }
    return changed ? out : null;
  }
  return { run, label, parse, loopsOf, forToWhile, CompileError, Unsupported };
})();
