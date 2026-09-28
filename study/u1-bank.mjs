// Unit 1 practice bank. Run `node study/u1-bank.mjs` to rebuild content/study/u1-bank.json.
// Answers and explanations for expressions, String calls and compareTo come from the
// visualizer engines. Every executable item carries Java specs that StudyCheck.java runs
// in real Java; conceptual items are marked for teacher review instead.
import { writeFileSync } from 'node:fs';
import { expr, str, cmp } from './lib/engines.mjs';

const items = [];
const ids = new Set();
function add(it) {
  if (ids.has(it.id)) throw new Error('duplicate id ' + it.id);
  ids.add(it.id);
  items.push(it);
}
const enc = encodeURIComponent;
function codeOf(d, s) { return [...d.split(';').map(x => x.trim()).filter(Boolean).map(x => x + ';'), s].join('\n'); }
function exprExplain(r) {
  if (r.compileError) return `It does not compile. ${r.compileError}`;
  const ops = r.steps.map(x => x.op.replace(/ → /, ' gives ').trim());
  const whys = r.steps.filter(x => !x.error).map(x => x.why).filter(w => !/^Look up/.test(w));
  // The reasons that carry the lesson: truncation, promotion, joining text, overflow, and assignment last.
  const keys = [...new Set(whys.filter(w => /truncat|widen|promot|joins text|wraps|chops|Casting|always returns|same type|Assignment/.test(w)))].slice(-2);
  const key = keys.length ? keys.join(' ') : (whys[whys.length - 1] || '');
  return (ops.length ? ops.join('; ') + '. ' : '') + (r.runtimeError ? `It compiles, then throws an ${r.runtimeError} when it runs. ` : '') + key;
}
function runExpr(d, s) {
  const r = expr.runJava(d, s);
  if (r.unsupported || r.internal) throw new Error(`engine cannot evaluate [${d}] ${s}: ${r.unsupported || r.internal}`);
  return r;
}

/* ---------- item builders ---------- */
// Predict the value (or compile error / crash) of an expression or declaration.
function value(id, section, skill, origin, d, s, prompt, note = '') {
  const r = runExpr(d, s);
  const stmtTarget = /^\s*(int|double|String)\s+(\w+)\s*=/.exec(s);
  add({
    id, section, skill, origin, format: 'value',
    prompt: prompt || (stmtTarget ? `What is stored in ${stmtTarget[2]}? (Or does it not compile, or crash?)` : 'What is the result? (Or does it not compile, or crash?)'),
    code: codeOf(d, s), answer: { label: r.label },
    explain: (exprExplain(r) + ' ' + note).trim(),
    java: [{ k: 'expr', d, s, label: r.label }],
    link: `exprtracer.html?d=${enc(d)}&s=${enc(s)}`,
  });
}
// Predict a String method call.
function call(id, section, skill, origin, s, m, args, note = '') {
  const r = str.callString(s, m, args);
  const label = r.kind === 'throws' ? 'throws' : `${r.kind}:${r.value}`;
  const name = m.startsWith('substring') ? 'substring' : m;
  const argText = m === 'indexOf' ? str.jstr(args[0]) : args.join(', ');
  add({
    id, section, skill, origin, format: 'call',
    prompt: 'What does this call return? (Or does it throw an exception?)',
    code: `${str.jstr(s)}.${name}(${argText})`, answer: { label },
    explain: (str.explainCall(s, m, args, r) + ' ' + note).trim(),
    java: [{ k: 'call', s, m, args, label }],
    link: `stringindex.html?s=${enc(s)}&m=${m}&a=${enc(m === 'indexOf' ? args[0] : args.join(','))}`,
  });
}
function compareTo(id, section, skill, origin, a, b) {
  const t = cmp.traceCompareTo(a, b);
  add({
    id, section, skill, origin, format: 'int',
    prompt: 'What int does this return?',
    code: `"${a}".compareTo("${b}")`, answer: { value: t.value },
    explain: cmp.explain(t),
    java: [{ k: 'cmp', a, b, value: t.value }],
    link: `compareto.html?a=${enc(a)}&b=${enc(b)}`,
  });
}
// Exact console output of a snippet (expected output is confirmed in Java).
function output(id, section, skill, origin, code, out, explain, prompt = 'What exactly does this print? (Spaces and line breaks count.)') {
  add({ id, section, skill, origin, format: 'output', prompt, code, answer: { text: out }, explain, java: [{ k: 'output', code, out }] });
}
function lineCount(id, section, skill, origin, code, out, explain) {
  const lines = out.replace(/\n$/, '').split('\n').length;
  add({ id, section, skill, origin, format: 'int', prompt: 'How many lines of text does this print?', code, answer: { value: lines }, explain, java: [{ k: 'output', code, out }] });
}
function int(id, section, skill, origin, prompt, code, v, explain, java) {
  add({ id, section, skill, origin, format: 'int', prompt, code, answer: { value: v }, explain, java: java || [], conceptual: !java });
}
// Multiple choice where each choice is an expression; correct = the choice whose Java result is `target`.
function mcExpr(id, section, skill, origin, prompt, d, target, choices, code = '') {
  const cs = choices.map(([s, why]) => {
    const r = runExpr(d, s);
    return { text: s, code: true, correct: r.label === target, why, spec: { k: 'expr', d, s, label: r.label } };
  });
  finishMc({ id, section, skill, origin, prompt, code: code || (d ? codeOf(d, '') .trim() : ''), choices: cs });
}
// Multiple choice where each choice is a snippet with a known output; correct = output equals target.
function mcOutput(id, section, skill, origin, prompt, setup, target, choices, code = '') {
  const cs = choices.map(([snippet, out, why]) => ({
    text: snippet, code: true, correct: out === target, why,
    spec: { k: 'output', code: (setup ? setup + '\n' : '') + `System.out.print(${snippet});`, out },
  }));
  finishMc({ id, section, skill, origin, prompt, code, choices: cs });
}
// Plain multiple choice: [text, correct, why, optional java spec]; code-like text is shown as code.
function mc(id, section, skill, origin, prompt, code, choices) {
  const cs = choices.map(([text, correct, why, spec, isCode]) => ({ text, code: !!isCode, correct, why, spec: spec || null }));
  finishMc({ id, section, skill, origin, prompt, code, choices: cs });
}
function finishMc(it) {
  const correct = it.choices.filter(c => c.correct).length;
  if (correct !== 1) throw new Error(`${it.id}: ${correct} correct choices`);
  const texts = it.choices.map(c => c.text);
  if (new Set(texts).size !== texts.length) throw new Error(`${it.id}: duplicate choices`);
  const java = it.choices.filter(c => c.spec).map(c => c.spec);
  add({
    id: it.id, section: it.section, skill: it.skill, origin: it.origin, format: 'mc', prompt: it.prompt, code: it.code || '',
    answer: { choices: it.choices.map(({ text, code, correct, why }) => ({ text, code, correct, why })) },
    explain: it.choices.find(c => c.correct).why,
    java, conceptual: java.length === 0,
  });
}
function tf(id, section, skill, origin, statement, v, why, java) {
  add({ id, section, skill, origin, format: 'tf', prompt: 'True or false?', statement, answer: { value: v }, explain: why, java: java || [], conceptual: !java });
}

/* ================= Section 1: How Java runs (AP 1.1–1.3) ================= */
const S1 = 'running';
mc('u1-run-logic', S1, 'errors', 'new', 'A program compiles and runs, but prints an average of 85.0 when the right answer is 85.33. What kind of error is this?', '', [
  ['A logic error', true, 'The program compiles and runs; it just computes the wrong thing (here, integer division before storing in a double).', { k: 'expr', d: '', s: 'double avg = (90 + 85 + 81) / 3;', label: 'double:85.0' }],
  ['A compile-time error', false, 'A compile-time error stops the program from running at all. This one ran.'],
  ['A run-time error', false, 'A run-time error crashes the program with an exception. This one finished and printed a number.'],
  ['No error: Java always rounds averages', false, 'Java does not round. It printed 85.0 because (90 + 85 + 81) / 3 is int division.'],
]);
mcExpr('u1-run-crash', S1, 'errors', 'new', 'Which line compiles, but then crashes when it runs?', '', 'throws:ArithmeticException', [
  ['int x = 5 / 0;', 'Integer division by zero compiles, then throws an ArithmeticException when it runs.'],
  ['int x = 5 / 0.0;', 'This does not compile: 5 / 0.0 is a double, and a double cannot be stored in an int without a cast.'],
  ['double d = 5 / 0.0;', 'Double division by zero does not crash. It gives Infinity.'],
  ['int x = 5 / 2;', 'This runs fine and stores 2.'],
]);
int('u1-run-bits', S1, 'bits', 'sibling', 'How many different values can 6 bits represent?', '', 64, 'Each extra bit doubles the number of patterns: 2 × 2 × 2 × 2 × 2 × 2 = 2⁶ = 64.');
int('u1-run-bits2', S1, 'bits', 'new', 'What is the fewest number of bits needed to give each of 200 students a different ID?', '', 8, '7 bits give 2⁷ = 128 patterns, which is not enough. 8 bits give 2⁸ = 256, which is.');
const ident = (name, ok) => ({ k: 'ident', name, ok });
mc('u1-run-ident', S1, 'identifiers', 'sibling', 'Which is a legal Java variable name?', '', [
  ['score2', true, 'Letters and digits are allowed as long as the name does not start with a digit.', ident('score2', true), true],
  ['2ndPlace', false, 'A name cannot start with a digit.', ident('2ndPlace', false), true],
  ['first-name', false, 'A hyphen is not allowed; Java would read it as subtraction.', ident('first-name', false), true],
  ['my score', false, 'Names cannot contain spaces.', ident('my score', false), true],
  ['class', false, 'class is a reserved word.', ident('class', false), true],
]);
mc('u1-run-ident2', S1, 'identifiers', 'new', 'Which is NOT a legal variable name?', '', [
  ['total!', true, 'Only letters, digits, _ and $ are allowed. ! is not.', ident('total!', false), true],
  ['_count', false, 'Starting with an underscore is legal.', ident('_count', true), true],
  ['$price', false, 'Starting with $ is legal (though rarely used).', ident('$price', true), true],
  ['numberOfStudents', false, 'Legal, and it follows the naming convention for variables.', ident('numberOfStudents', true), true],
  ['x2', false, 'Legal: a digit may appear after the first character.', ident('x2', true), true],
]);
mc('u1-run-naming', S1, 'identifiers', 'sibling', 'Following Java naming conventions, which is the best name for a class about library books?', '', [
  ['LibraryBook', true, 'Class names start with a capital letter and capitalize each word.', ident('LibraryBook', true), true],
  ['libraryBook', false, 'Legal, but this style (lower case first) is the convention for variables and methods.', ident('libraryBook', true), true],
  ['LIBRARY_BOOK', false, 'Legal, but all capitals is the convention for constants.', ident('LIBRARY_BOOK', true), true],
  ['Library-Book', false, 'Not legal: hyphens are not allowed in names.', ident('Library-Book', false), true],
]);
mc('u1-run-ram', S1, 'hardware', 'sibling', 'Which kind of storage loses its contents when the power is turned off?', '', [
  ['RAM (main memory)', true, 'RAM is volatile: it needs power to keep its contents. That is why unsaved work is lost in a power cut.'],
  ['A hard drive', false, 'A hard drive keeps data without power (non-volatile).'],
  ['A solid-state drive (SSD)', false, 'SSDs are non-volatile flash storage.'],
  ['A USB flash drive', false, 'Flash drives keep data without power.'],
]);
tf('u1-run-save-tf', S1, 'hardware', 'new', 'Saving a file copies it from RAM to long-term storage, such as a disk, so it survives when the power goes off.', true,
  'While you work, the document lives in RAM, which is volatile. Saving writes it to non-volatile storage (a disk, SSD or flash drive), which keeps it without power.');
tf('u1-run-case', S1, 'identifiers', 'new', 'Java is case-sensitive, so score and Score are two different names.', true,
  'Java treats upper and lower case letters as different, so both can be declared in the same method.', [{ k: 'compiles', code: 'int score = 1;\nint Score = 2;', ok: true }]);
tf('u1-run-compiles', S1, 'errors', 'new', 'If a program compiles, it has no errors.', false,
  'Compiling only checks the rules of the language. A program can still crash while running (for example 1 / 0) or give wrong answers (a logic error).',
  [{ k: 'expr', d: '', s: '1 / 0', label: 'throws:ArithmeticException' }]);
mc('u1-run-comment', S1, 'syntax', 'sibling', 'Which of these is NOT a Java comment?', '', [
  ['# total points', true, 'Java does not use # for comments; this line does not compile.', { k: 'compiles', code: '# total points\nint a = 1;', ok: false }, true],
  ['// total points', false, 'A line comment: everything after // is ignored.', { k: 'compiles', code: '// total points\nint a = 1;', ok: true }, true],
  ['/* total points */', false, 'A block comment, which can span several lines.', { k: 'compiles', code: '/* total points */\nint a = 1;', ok: true }, true],
  ['/** total points */', false, 'A documentation (Javadoc) comment. It is also a block comment.', { k: 'compiles', code: '/** total points */\nint a = 1;', ok: true }, true],
]);
const greeting = (body) => `public class Greeting {\n    public static void main(String[] args) {\n        ${body}\n    }\n}`;
mc('u1-run-fix', S1, 'syntax', 'sibling', 'This program does not compile. Which change fixes it?', greeting('System.out.println("Hi there")'), [
  ['Add ; after the closing parenthesis', true, 'Every statement ends with a semicolon.', { k: 'compilesClass', code: greeting('System.out.println("Hi there");'), ok: true }],
  ['Change println to print', false, 'print would also need a semicolon; the method name is not the problem.', { k: 'compilesClass', code: greeting('System.out.print("Hi there")'), ok: false }],
  ["Use single quotes: 'Hi there'", false, "Single quotes are for one char, not text. 'Hi there' does not compile.", { k: 'compilesClass', code: greeting("System.out.println('Hi there');"), ok: false }],
  ['Remove the word static', false, 'The missing semicolon would still stop it compiling.', { k: 'compilesClass', code: 'public class Greeting {\n    public void main(String[] args) {\n        System.out.println("Hi there")\n    }\n}', ok: false }],
]);

/* ================= Section 2: Expressions and types (AP 1.3–1.6) ================= */
const S2 = 'numbers';
value('u1-num-ratio', S2, 'division', 'sibling', '', 'double ratio = 3 / 4;');
value('u1-num-lossy', S2, 'casting', 'sibling', '', 'int n = 90 / 4.0;');
value('u1-num-chain', S2, 'division', 'sibling', 'int a = 90; int b = 7; int c = 4;', 'a / b / c');
value('u1-num-cast1', S2, 'casting', 'new', '', '(double) 17 / 4');
value('u1-num-cast2', S2, 'casting', 'new', '', '(double) (17 / 4)');
value('u1-num-trunc', S2, 'casting', 'new', '', '(int) 9.99 + (int) 0.5');
value('u1-num-negdiv', S2, 'division', 'new', '', '-17 / 5');
value('u1-num-negmod', S2, 'division', 'new', '', '-17 % 5');
value('u1-num-prec', S2, 'division', 'sibling', '', '20 - 12 / 4 * 2 + 7 % 3');
value('u1-num-time', S2, 'division', 'sibling', 'int total = 7384;', 'total % 3600 / 60', '', '7384 seconds is 2 hours (7200 s) with 184 s left over; 184 / 60 is 3 whole minutes.');
value('u1-num-digit', S2, 'division', 'sibling', 'int code = 4829;', 'code / 10 % 10', '', '/ 10 drops the last digit; % 10 then keeps the new last digit, which was the tens digit.');
value('u1-num-overflow', S2, 'casting', 'new', '', 'Integer.MAX_VALUE + 1');
mc('u1-num-explain1', S2, 'division', 'new', 'A student predicted 0.75 is stored. What was their mistake?', 'double ratio = 3 / 4;', [
  ['They assumed the division is done in double because ratio is a double.', true, '3 / 4 is evaluated first, as int division, giving 0. Only then is 0 widened to 0.0 for the double variable.', { k: 'expr', d: '', s: 'double ratio = 3 / 4;', label: 'double:0.0' }],
  ['They forgot that Java rounds 0.75 up to 1.', false, 'Java never rounds in division; int division truncates. The stored value is 0.0.'],
  ['They should have said it does not compile, because 3 / 4 is an int.', false, 'An int can be stored in a double (widening), so this compiles.'],
  ['Nothing: Java stores 0.75.', false, 'Java stores 0.0. The fraction is lost in 3 / 4 before assignment.'],
]);
mc('u1-num-explain2', S2, 'casting', 'new', 'A student says this line crashes when it runs. What is actually true?', 'int n = 90 / 4.0;', [
  ['It does not compile: the right side is a double, and storing a double in an int needs a cast.', true, '90 / 4.0 is 22.5, a double. Java refuses to silently drop the fraction, so the compiler reports an error before anything runs.', { k: 'expr', d: '', s: 'int n = 90 / 4.0;', label: 'compile-error' }],
  ['It runs and stores 22.', false, 'That would need a cast: int n = (int) (90 / 4.0);'],
  ['It runs and stores 22.5.', false, 'An int cannot hold 22.5.'],
  ['It crashes with an ArithmeticException.', false, 'Nothing runs: the compiler rejects it first. ArithmeticException is for int division by zero.'],
]);
mcExpr('u1-num-repair', S2, 'casting', 'sibling', 'This should store the exact average, 4.25, but stores 4.0. Which replacement for the last line fixes it?', 'int sum = 17; int count = 4;', 'double:4.25', [
  ['double avg = (double) sum / count;', 'The cast applies to sum before dividing, so the division is done in double: 17.0 / 4 = 4.25.'],
  ['double avg = (double) (sum / count);', 'The parentheses make the int division happen first (4), so the cast only turns 4 into 4.0.'],
  ['double avg = sum / count * 1.0;', 'sum / count is still int division (4); multiplying by 1.0 afterwards is too late.'],
  ['int avg = sum / (double) count;', 'The division is now double (4.25), but it cannot be stored in an int: this does not compile.'],
], 'int sum = 17;\nint count = 4;\ndouble avg = sum / count;');
tf('u1-num-prec-tf', S2, 'division', 'sibling', '* and % have the same precedence, so they are done left to right.', true,
  'They share precedence. 7 % 3 * 2 is (7 % 3) * 2 = 2. If * went first, it would be 7 % 6 = 1.', [{ k: 'expr', d: '', s: '7 % 3 * 2', label: 'int:2' }]);
tf('u1-num-round-tf', S2, 'casting', 'new', '(int) 3.99 rounds to 4.', false, 'Casting to int truncates (chops off the fraction). (int) 3.99 is 3.', [{ k: 'expr', d: '', s: '(int) 3.99', label: 'int:3' }]);

/* ================= Section 3: Output and + with Strings (AP 1.1, 1.15) ================= */
const S3 = 'output';
output('u1-out-print', S3, 'printing', 'sibling', 'System.out.print("Rain");\nSystem.out.println("bow " + "Road");\nSystem.out.println("Sun" + "  set");',
  'Rainbow Road\nSun  set\n', 'print leaves the cursor on the same line, so "bow Road" continues right after "Rain". + joins Strings exactly as written: no space is added, and the two spaces inside "  set" stay.');
lineCount('u1-out-lines', S3, 'printing', 'sibling', 'System.out.println("one\\ttwo\\nthree\\\\four");', 'one\ttwo\nthree\\four\n',
  '\\t is a tab (same line), \\n starts a new line, and \\\\ prints one backslash. So: "one<tab>two" on line 1 and "three\\four" on line 2.');
mc('u1-out-quote', S3, 'printing', 'sibling', 'Which statement prints exactly this, including the quotes?   He said "go"', '', [
  ['System.out.println("He said \\"go\\"");', true, '\\" puts a quote character inside a String without ending it.', { k: 'output', code: 'System.out.println("He said \\"go\\"");', out: 'He said "go"\n' }, true],
  ['System.out.println("He said "go"");', false, 'The second " ends the String early, so this does not compile.', { k: 'compiles', code: 'System.out.println("He said "go"");', ok: false }, true],
  ['System.out.println("He said \\"go");', false, 'This compiles but prints He said "go (the closing quote is missing).', { k: 'output', code: 'System.out.println("He said \\"go");', out: 'He said "go\n' }, true],
  ["System.out.println('He said \"go\"');", false, 'Single quotes are for one char; this does not compile.', { k: 'compiles', code: "System.out.println('He said \"go\"');", ok: false }, true],
]);
value('u1-out-cat1', S3, 'concat', 'sibling', 'int y = 3; int z = 4;', '"Total: " + y + z');
value('u1-out-cat2', S3, 'concat', 'sibling', 'int y = 3; int z = 4;', 'y + z + " total"');
value('u1-out-cat3', S3, 'concat', 'sibling', 'int x = 10; int y = 5;', '"" + x + y');
value('u1-out-cat4', S3, 'concat', 'new', '', '"Area: " + 3 * 4');
value('u1-out-cat5', S3, 'concat', 'new', '', '"Half: " + 7 / 2');
mc('u1-out-explain', S3, 'concat', 'new', 'A student expected this to print Score: 10. Why does it print Score: 82?', 'System.out.println("Score: " + 8 + 2);', [
  ['+ works left to right: "Score: " + 8 is already a String, so 2 is joined as text.', true, 'After the first +, the left side is the String "Score: 8", and String + 2 joins "2".', { k: 'expr', d: '', s: '"Score: " + 8 + 2', label: 'String:Score: 82' }],
  ['Java always joins numbers as text.', false, 'Not always: 8 + 2 + "" gives "10", because the numbers are added before any String appears.', { k: 'expr', d: '', s: '8 + 2 + ""', label: 'String:10' }],
  ['The space inside "Score: " turns the numbers into text.', false, 'The space has nothing to do with it; any String on the left causes joining.'],
  ['println converts each number to text before adding.', false, 'println receives one finished String; the joining happens in the expression, left to right.'],
]);
mcExpr('u1-out-repair', S3, 'concat', 'new', 'This should print the sum, Sum: 7. Which replacement fixes it?', 'int a = 2; int b = 5;', 'String:Sum: 7', [
  ['"Sum: " + (a + b)', 'The parentheses make a + b happen first, as int addition (7), before joining.'],
  ['("Sum: " + a) + b', 'This is the same as the original: "Sum: 2" + 5 gives "Sum: 25".'],
  ['"Sum: " + "" + a + b', 'Adding "" keeps everything as text: "Sum: 25".'],
  ['a + b + "Sum: "', 'The sum is right (7) but it ends up in front: "7Sum: ".'],
], 'int a = 2;\nint b = 5;\nSystem.out.println("Sum: " + a + b);');
output('u1-out-cursor', S3, 'printing', 'new', 'String name = "Kai";\nSystem.out.print("Hi, ");\nSystem.out.print(name);\nSystem.out.println("!");\nSystem.out.println("Bye");',
  'Hi, Kai!\nBye\n', 'The three prints stay on one line until println moves to the next line.');
tf('u1-out-space-tf', S3, 'printing', 'new', 'System.out.print adds a space after what it prints.', false, 'print adds nothing: print("a") then print("b") shows ab.', [{ k: 'output', code: 'System.out.print("a");\nSystem.out.print("b");', out: 'ab' }]);

/* ================= Section 4: String methods (AP 1.15) ================= */
const S4 = 'strings';
call('u1-str-sub1', S4, 'substring', 'sibling', 'Good Morning', 'substring2', [2, 7]);
call('u1-str-sub2', S4, 'substring', 'sibling', 'Good Morning', 'substring1', [5]);
call('u1-str-sub3', S4, 'substring', 'new', 'planet', 'substring1', [6]);
call('u1-str-sub4', S4, 'substring', 'new', 'planet', 'substring2', [3, 7]);
call('u1-str-len', S4, 'substring', 'new', 'Hi there', 'length', []);
call('u1-str-idx1', S4, 'indexOf', 'sibling', 'Robinson', 'indexOf', ['bin']);
call('u1-str-idx2', S4, 'indexOf', 'new', 'Robinson', 'indexOf', ['son']);
call('u1-str-idx3', S4, 'indexOf', 'new', 'Robinson', 'indexOf', ['Son'], 'Case matters: "Son" is not the same as "son".');
call('u1-str-idx4', S4, 'indexOf', 'new', 'banana', 'indexOf', ['na']);
compareTo('u1-str-cmp1', S4, 'compareTo', 'sibling', 'Tran', 'Park');
compareTo('u1-str-cmp2', S4, 'compareTo', 'sibling', 'Park', 'Parker');
compareTo('u1-str-cmp3', S4, 'compareTo', 'new', 'apple', 'Apple');
compareTo('u1-str-cmp4', S4, 'compareTo', 'sibling', 'Lee', 'Lee');
mc('u1-str-explain', S4, 'substring', 'new', 'A student says this returns "ane". What went wrong?', '"planet".substring(2, 4)', [
  ['They included index 4. substring stops before its end index, so the result is "an".', true, 'Boxes 2 and 3 only: "an". The end index is where the cut is made, not the last box included.', { k: 'call', s: 'planet', m: 'substring2', args: [2, 4], label: 'String:an' }],
  ['They started counting at 1 instead of 0.', false, 'Counting from 1 would give "la", not "ane".'],
  ['substring includes both end points.', false, 'That is exactly the mistake: substring excludes the end index.'],
  ['Nothing: it returns "ane".', false, 'It returns "an".'],
]);
mcOutput('u1-str-repair', S4, 'indexOf', 'new', 'For any "First Last" name, this should store the first name with no space, but it keeps the space. Which replacement fixes it?', 'String full = "Ada Lovelace";', 'Ada', [
  ['full.substring(0, full.indexOf(" "))', 'Ada', 'The space is at index 3, and substring stops before its end index, so you get indexes 0 to 2.'],
  ['full.substring(1, full.indexOf(" "))', 'da', 'Starting at 1 drops the first letter.'],
  ['full.substring(0, full.indexOf(" ") - 1)', 'Ad', 'Subtracting 1 cuts one letter too early.'],
  ['full.substring(full.indexOf(" "))', ' Lovelace', 'This starts at the space and keeps everything after it.'],
], 'String first = full.substring(0, full.indexOf(" ") + 1);');
output('u1-str-flip', S4, 'indexOf', 'sibling', 'String s = "Lin Wei";\nint sp = s.indexOf(" ");\nSystem.out.println(s.substring(sp + 1) + ", " + s.substring(0, sp));',
  'Wei, Lin\n', 'sp is 3. substring(4) is "Wei" and substring(0, 3) is "Lin", joined with ", ".');
mc('u1-str-type1', S4, 'signatures', 'sibling', 'What type does "hello".indexOf("l") return?', '', [
  ['int', true, 'indexOf returns a position (or −1), which is an int.', { k: 'compiles', code: 'int i = "hello".indexOf("l");', ok: true }, true],
  ['String', false, 'It returns where the text is, not the text.', { k: 'compiles', code: 'String t = "hello".indexOf("l");', ok: false }, true],
  ['boolean', false, 'It does not just say whether the text is there; it says where.', { k: 'compiles', code: 'boolean b = "hello".indexOf("l");', ok: false }, true],
  ['char', false, 'It returns an index, not a character.', { k: 'compiles', code: 'char c = "hello".indexOf("l");', ok: false }, true],
]);
mc('u1-str-type2', S4, 'signatures', 'sibling', 'What type does a.equals(b) return, for Strings a and b?', '', [
  ['boolean', true, 'equals answers a yes/no question: true or false.', { k: 'compiles', code: 'boolean e = "a".equals("b");', ok: true }, true],
  ['int', false, 'compareTo returns an int; equals returns a boolean.', { k: 'compiles', code: 'int e = "a".equals("b");', ok: false }, true],
  ['String', false, 'It does not return text.', { k: 'compiles', code: 'String e = "a".equals("b");', ok: false }, true],
  ['void', false, 'equals returns a value you can use in a condition, so it is not void.'],
]);
tf('u1-str-cmp-tf1', S4, 'compareTo', 'new', 'If one String matches the start of the other, compareTo returns the difference in their lengths.', true,
  '"Park".compareTo("Parker") has no mismatch in the first 4 letters, so it returns 4 − 6 = −2.', [{ k: 'cmp', a: 'Park', b: 'Parker', value: -2 }]);
tf('u1-str-cmp-tf2', S4, 'compareTo', 'new', 'compareTo compares the lengths of the two Strings first.', false,
  'It compares characters first and only uses length when one String runs out. "zoo".compareTo("apple") is 25, positive even though "zoo" is shorter.', [{ k: 'cmp', a: 'zoo', b: 'apple', value: 25 }]);

/* ================= Section 5: Math.random and method signatures (AP 1.7–1.11) ================= */
const S5 = 'methods';
const range = (e, min, max) => ({ k: 'range', expr: e, min, max });
int('u1-met-max', S5, 'random', 'sibling', 'What is the largest value this can produce?', '(int) (Math.random() * 8) + 3', 10,
  'Math.random() is at least 0.0 and less than 1.0, so Math.random() * 8 is less than 8, and the cast gives 0 to 7. Adding 3 gives 3 to 10.', [range('(int) (r * 8) + 3', 3, 10)]);
int('u1-met-min', S5, 'random', 'new', 'What is the smallest value this can produce?', '(int) (Math.random() * 6) + 10', 10,
  'When Math.random() is 0.0 the product is 0, so the smallest result is 0 + 10 = 10 (the largest is 15).', [range('(int) (r * 6) + 10', 10, 15)]);
function mcRange(id, origin, prompt, lo, hi, choices) {
  const cs = choices.map(([text, min, max, why]) => ({ text, code: true, correct: min === lo && max === hi, why, spec: range(text.replace(/Math\.random\(\)/g, 'r'), min, max) }));
  finishMc({ id, section: S5, skill: 'random', origin, prompt, code: '', choices: cs });
}
mcRange('u1-met-formula', 'sibling', 'Which expression gives a random int from 20 to 30, inclusive?', 20, 30, [
  ['(int) (Math.random() * 11) + 20', 20, 30, '20 to 30 is 30 − 20 + 1 = 11 values: multiply by 11, cast, then add 20.'],
  ['(int) (Math.random() * 10) + 20', 20, 29, 'Only 10 values: 20 to 29. It can never give 30.'],
  ['(int) Math.random() * 11 + 20', 20, 20, 'The cast applies to Math.random() alone, which always becomes 0, so this is always 20.'],
  ['(int) (Math.random() * 30) + 20', 20, 49, 'Multiplying by 30 gives 30 values, 20 to 49.'],
]);
mc('u1-met-die', S5, 'random', 'new', 'A student wrote this for a die roll. What does it actually produce?', '(int) Math.random() * 6 + 1', [
  ['Always 1', true, 'The cast applies to Math.random() alone and turns it into 0 before multiplying, so it is 0 * 6 + 1 every time.', range('(int) r * 6 + 1', 1, 1)],
  ['1 to 6, as intended', false, 'That needs the cast around the product: (int) (Math.random() * 6) + 1.', range('(int) (r * 6) + 1', 1, 6)],
  ['0 to 5', false, 'That would be (int) (Math.random() * 6), with no + 1.'],
  ['1 to 7', false, 'No version of this formula reaches 7.'],
]);
const areaHeader = 'public static double area(double width, int sides)';
mc('u1-met-sig1', S5, 'signatures', 'new', `Given the method header below, which statement compiles?`, areaHeader, [
  ['double a = area(2.5, 4);', true, 'A double and an int, in that order, and the double result is stored in a double.', { k: 'compiles', code: 'double a = area(2.5, 4);', ok: true }, true],
  ['double a = area(4, 2.5);', false, 'The first argument is fine (an int can widen to double), but 2.5 cannot be passed to the int parameter sides.', { k: 'compiles', code: 'double a = area(4, 2.5);', ok: false }, true],
  ['int a = area(2.5, 4);', false, 'area returns a double, which cannot be stored in an int without a cast.', { k: 'compiles', code: 'int a = area(2.5, 4);', ok: false }, true],
  ['double a = area(2.5);', false, 'The method needs two arguments.', { k: 'compiles', code: 'double a = area(2.5);', ok: false }, true],
]);
mc('u1-met-sig2', S5, 'signatures', 'new', 'Given public static int roll(int sides), what is the type of roll(6) + 0.5?', '', [
  ['double', true, 'roll(6) is an int; adding the double 0.5 promotes the result to double.', { k: 'compiles', code: 'double v = roll(6) + 0.5;', ok: true }],
  ['int', false, 'int + double is a double.', { k: 'compiles', code: 'int v = roll(6) + 0.5;', ok: false }],
  ['String', false, 'No String is involved.'],
  ['It does not compile.', false, 'It compiles: an int return value can be used in arithmetic.', { k: 'compiles', code: 'double v = roll(6) + 0.5;', ok: true }],
]);
mc('u1-met-math', S5, 'signatures', 'new', 'Which call returns an int when given an int?', '', [
  ['Math.abs(-4)', true, 'Math.abs returns the same type it is given.', { k: 'compiles', code: 'int a = Math.abs(-4);', ok: true }, true],
  ['Math.sqrt(16)', false, 'Math.sqrt always returns a double (4.0).', { k: 'compiles', code: 'int a = Math.sqrt(16);', ok: false }, true],
  ['Math.pow(2, 3)', false, 'Math.pow always returns a double (8.0).', { k: 'compiles', code: 'int a = Math.pow(2, 3);', ok: false }, true],
  ['Math.random()', false, 'Math.random takes no argument and returns a double.', { k: 'compiles', code: 'int a = Math.random();', ok: false }, true],
]);
tf('u1-met-random-tf', S5, 'random', 'new', 'Math.random() can return 1.0.', false, 'Math.random() returns a value from 0.0 up to, but not including, 1.0. That is why (int) (Math.random() * n) never reaches n.');
value('u1-met-pow', S5, 'signatures', 'new', '', 'Math.pow(3, 2)');
value('u1-met-abs', S5, 'signatures', 'new', '', 'Math.abs(-7) / 2');
value('u1-met-sqrt', S5, 'signatures', 'new', '', 'Math.sqrt(25) + 1');

/* ================= Section 6: Objects and references (AP 1.12–1.14) ================= */
const S6 = 'objects';
output('u1-obj-alias', S6, 'references', 'new', 'Player a = new Player("Ana", 10);\nPlayer b = a;\nb.addScore(5);\nSystem.out.println(a.getScore());',
  '15\n', 'b = a copies the reference, not the object. a and b refer to the same Player, so adding 5 through b is seen through a.');
output('u1-obj-two', S6, 'references', 'new', 'Player a = new Player("Ana", 10);\nPlayer b = new Player("Ana", 10);\nb.addScore(5);\nSystem.out.println(a.getScore() + " " + b.getScore());',
  '10 15\n', 'Two uses of new make two separate objects, even with the same values. Changing b does not affect a.');
output('u1-obj-reassign', S6, 'references', 'new', 'Player a = new Player("Ana", 10);\nPlayer b = a;\na = new Player("Bo", 3);\nb.addScore(1);\nSystem.out.println(a.getName() + " " + b.getScore());',
  'Bo 11\n', 'After b = a, both refer to Ana. Then a is pointed at a new Player (Bo), but b still refers to Ana, whose score goes from 10 to 11.');
mc('u1-obj-null', S6, 'references', 'new', 'What happens when this runs?', 'Player p = null;\nSystem.out.println(p.getScore());', [
  ['It compiles, then throws a NullPointerException.', true, 'p does not refer to any object, so there is no score to get. The compiler cannot know that; the crash happens when the line runs.', { k: 'throws', code: 'Player p = null;\nSystem.out.println(p.getScore());', type: 'NullPointerException' }],
  ['It prints 0.', false, 'There is no Player object at all, so there is no score, not even 0.'],
  ['It does not compile.', false, 'It compiles: p has type Player, which has getScore().'],
  ['It prints null.', false, 'Calling a method on null does not return null; it throws an exception.'],
]);
mc('u1-obj-equals', S6, 'references', 'new', 'What does this print?', 'String s = new String("hi");\nString t = new String("hi");\nSystem.out.println(s.equals(t) + " " + (s == t));', [
  ['true false', true, 'equals compares the characters (the same); == compares references, and new made two different objects.', { k: 'output', code: 'String s = new String("hi");\nString t = new String("hi");\nSystem.out.println(s.equals(t) + " " + (s == t));', out: 'true false\n' }],
  ['true true', false, '== is false here: two separate objects, even though they hold the same text.'],
  ['false false', false, 'equals is true: the contents match.'],
  ['false true', false, 'This is backwards: equals checks contents, == checks whether it is the same object.'],
]);
tf('u1-obj-copy-tf', S6, 'references', 'new', 'Player b = a; makes a copy of the Player object.', false,
  'It copies the reference, so a and b refer to the same single object.', [{ k: 'output', code: 'Player a = new Player("Ana", 10);\nPlayer b = a;\nb.addScore(5);\nSystem.out.println(a.getScore());', out: '15\n' }]);
tf('u1-obj-immutable-tf', S6, 'references', 'new', 'Calling w.substring(1) changes the String that w refers to.', false,
  'Strings never change. substring returns a new String; unless you store it (w = w.substring(1);), w is unchanged.', [{ k: 'output', code: 'String w = "hello";\nw.substring(1);\nSystem.out.println(w);', out: 'hello\n' }]);
output('u1-obj-store', S6, 'references', 'new', 'String w = "hello";\nw = w.substring(1);\nSystem.out.println(w);', 'ello\n',
  'This time the new String is stored back in w, so w now refers to "ello". The original "hello" object is unchanged.');

writeFileSync(new URL('../content/study/u1-bank.json', import.meta.url), JSON.stringify(items, null, 1) + '\n');
console.log(`Wrote ${items.length} items`);
