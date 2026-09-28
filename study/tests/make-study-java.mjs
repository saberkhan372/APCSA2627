// Generates StudyCheck.java: every Java spec in content/study/*-bank.json, checked in real Java.
// Expressions go through typed(int|double|String) overloads so javac confirms each result's type;
// compile / does-not-compile claims and identifier legality are checked with the in-memory compiler.
import { readFileSync, readdirSync, writeFileSync } from 'node:fs';
const root = new URL('../../', import.meta.url);
const banks = readdirSync(new URL('content/study/', root)).filter(f => f.endsWith('-bank.json')).sort();
const specs = [];
const seen = new Set();
for (const f of banks) {
  for (const item of JSON.parse(readFileSync(new URL('content/study/' + f, root), 'utf8'))) {
    for (const spec of item.java) {
      const key = JSON.stringify(spec);
      if (seen.has(key)) continue;
      seen.add(key);
      specs.push({ ...spec, item: item.id });
    }
  }
}

const NAMED = { 8: '\\b', 9: '\\t', 10: '\\n', 12: '\\f', 13: '\\r', 34: '\\"', 92: '\\\\' };
function lit(s) {
  let out = '"';
  for (let i = 0; i < s.length; i++) {
    const c = s.charCodeAt(i);
    if (NAMED[c]) out += NAMED[c];
    else if (c >= 32 && c <= 126) out += s[i];
    else if (c < 32 || c === 127) out += '\\' + c.toString(8).padStart(3, '0');
    else out += '\\u' + c.toString(16).padStart(4, '0');
  }
  return out + '"';
}
const indent = (code, n) => code.split('\n').map(l => ' '.repeat(n) + l).join('\n');
function exprBody(d, s) {
  const ds = d.split(';').map(x => x.trim()).filter(Boolean).map(x => x + ';').join(' ');
  const t = s.trim().replace(/;$/, '');
  const m = /^(int|double|String)\s+([A-Za-z_$][\w$]*)\s*=([\s\S]*)$/.exec(t);
  return (ds ? ds + ' ' : '') + (m ? `${m[1]} ${m[2]} =${m[3]}; return typed(${m[2]});` : `return typed(${t});`);
}

// Helpers every snippet may use: the course's Player class (projects/W06) and two sample methods.
const HELPERS = `static String typed(int v) { return "int:" + v; }
static String typed(double v) { return "double:" + v; }
static String typed(String v) { return "String:" + v; }
static class Player {
    private String name;
    private int score;
    public Player(String startName, int startScore) { name = startName; score = startScore; }
    public String getName() { return name; }
    public int getScore() { return score; }
    public void addScore(int amount) { score += amount; }
}
static double area(double width, int sides) { return width * sides; }
static int roll(int sides) { return (int) (Math.random() * sides) + 1; }`;

const methods = [], checks = [], rejects = [];
specs.forEach((sp, i) => {
  const label = lit(`${sp.item} [${sp.k}]`);
  switch (sp.k) {
    case 'expr':
      if (sp.label === 'compile-error') {
        rejects.push(`        compileCheck(javac, ${label}, ${lit(`public class Snip { ${HELPERS.replace(/\n/g, ' ')} static String run() { ${exprBody(sp.d, sp.s)} } }`)}, "Snip", false);`);
      } else {
        methods.push(`    static String e${i}() { ${exprBody(sp.d, sp.s)} }`);
        checks.push(`        check(${label}, ${lit(sp.label)}, () -> e${i}());`);
      }
      break;
    case 'call': {
      const call = sp.m === 'length' ? `"int:" + ${lit(sp.s)}.length()`
        : sp.m === 'charAt' ? `"char:" + ${lit(sp.s)}.charAt(${sp.args[0]})`
        : sp.m === 'substring1' ? `"String:" + ${lit(sp.s)}.substring(${sp.args[0]})`
        : sp.m === 'substring2' ? `"String:" + ${lit(sp.s)}.substring(${sp.args[0]}, ${sp.args[1]})`
        : `"int:" + ${lit(sp.s)}.indexOf(${lit(sp.args[0])})`;
      methods.push(`    static String e${i}() { return ${call}; }`);
      checks.push(`        check(${label}, ${lit(sp.label)}, () -> e${i}());`);
      break;
    }
    case 'cmp':
      checks.push(`        check(${label}, ${lit(String(sp.value))}, () -> String.valueOf(${lit(sp.a)}.compareTo(${lit(sp.b)})));`);
      break;
    case 'output':
      methods.push(`    static void o${i}() {\n${indent(sp.code, 8)}\n    }`);
      checks.push(`        check(${label}, ${lit(sp.out)}, () -> capture(StudyCheck::o${i}));`);
      break;
    case 'throws':
      methods.push(`    static void o${i}() {\n${indent(sp.code, 8)}\n    }`);
      checks.push(`        check(${label}, ${lit(sp.type)}, () -> thrown(StudyCheck::o${i}));`);
      break;
    case 'range':
      methods.push(`    static int r${i}(double r) { return ${sp.expr}; }`);
      checks.push(`        check(${label}, ${lit(`${sp.min}..${sp.max}`)}, () -> r${i}(0.0) + ".." + r${i}(Math.nextDown(1.0)));`);
      break;
    case 'compiles':
      rejects.push(`        compileCheck(javac, ${label}, ${lit(`public class Snip {\n${HELPERS}\nstatic void run() {\n${sp.code}\n}\n}`)}, "Snip", ${sp.ok});`);
      break;
    case 'compilesClass': {
      const name = /public class (\w+)/.exec(sp.code)[1];
      rejects.push(`        compileCheck(javac, ${label}, ${lit(sp.code)}, ${lit(name)}, ${sp.ok});`);
      break;
    }
    case 'ident':
      rejects.push(`        compileCheck(javac, ${label}, ${lit(`public class Snip { void f() { int ${sp.name} = 0; } }`)}, "Snip", ${sp.ok});`);
      break;
    default: throw new Error('unknown spec kind ' + sp.k);
  }
});

const java = `// Generated by study/tests/make-study-java.mjs from content/study/*-bank.json. Do not edit by hand.
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.nio.file.Files;
import java.util.List;
import java.util.function.Supplier;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

public class StudyCheck {
${indent(HELPERS, 4)}

${methods.join('\n')}

    static int passed = 0, failed = 0;

    static void check(String label, String expected, Supplier<String> actual) {
        String got;
        try { got = actual.get(); } catch (ArithmeticException e) { got = "throws:ArithmeticException"; }
          catch (StringIndexOutOfBoundsException e) { got = "throws"; }
        if (got.equals(expected)) passed++;
        else { failed++; System.out.println("FAIL " + label + ": Java gives " + show(got) + ", bank says " + show(expected)); }
    }

    static String capture(Runnable r) {
        PrintStream old = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buf, true));
        try { r.run(); } finally { System.setOut(old); }
        return buf.toString().replace(System.lineSeparator(), "\\n");
    }

    static String thrown(Runnable r) {
        try { capture(r); return "no exception"; } catch (RuntimeException e) { return e.getClass().getSimpleName(); }
    }

    static void compileCheck(JavaCompiler javac, String label, String code, String className, boolean shouldCompile) throws Exception {
        JavaFileObject src = new SimpleJavaFileObject(URI.create("string:///" + className + ".java"), JavaFileObject.Kind.SOURCE) {
            @Override public CharSequence getCharContent(boolean ignoreEncodingErrors) { return code; }
        };
        String out = Files.createTempDirectory("snip").toString();
        boolean ok = javac.getTask(null, null, new DiagnosticCollector<JavaFileObject>(), List.of("-d", out), null, List.of(src)).call();
        if (ok == shouldCompile) passed++;
        else { failed++; System.out.println("FAIL " + label + ": Java " + (ok ? "compiles" : "rejects") + " it, bank says it " + (shouldCompile ? "compiles" : "does not")); }
    }

    static String show(String s) { return "\\"" + s.replace("\\n", "\\\\n").replace("\\t", "\\\\t") + "\\""; }

    public static void main(String[] args) throws Exception {
${checks.join('\n')}
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        if (javac == null) throw new IllegalStateException("A JDK (not just a JRE) is needed to check compile claims.");
${rejects.join('\n')}
        System.out.println(failed == 0
            ? "PASS: " + passed + " study specs match Java " + System.getProperty("java.version")
            : failed + " of " + (passed + failed) + " study specs differ");
    }
}
`;
writeFileSync(new URL('StudyCheck.java', import.meta.url), java);
console.log(`Wrote StudyCheck.java with ${specs.length} specs (${checks.length} run, ${rejects.length} compile checks) from ${banks.join(', ')}`);
