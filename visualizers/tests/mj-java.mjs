// Shared Java-check generator for the tools built on the mini-Java interpreter. Each case is
// [program, expected] where expected is the exact output (with "|throws:Type" after a crash),
// "compile-error" (javac must reject it), "unsupported" or "limit" (valid Java javac must accept).
import { readFileSync, writeFileSync } from 'node:fs';
import { loadMJ } from './lib-mj.mjs';
const NAMED = { 8: '\\b', 9: '\\t', 10: '\\n', 12: '\\f', 13: '\\r', 34: '\\"', 92: '\\\\' };
export function lit(s) { let o = '"'; for (let i = 0; i < s.length; i++) { const c = s.charCodeAt(i); o += NAMED[c] || (c >= 32 && c <= 126 ? s[i] : c < 32 || c === 127 ? '\\' + c.toString(8).padStart(3, '0') : '\\u' + c.toString(16).padStart(4, '0')); } return o + '"'; }
const indent = (code, n) => code ? code.split('\n').map(l => ' '.repeat(n) + l).join('\n') : '';
const PLAYER = `static class Player {
    private String name;
    private int score;
    public Player(String startName, int startScore) { name = startName; score = startScore; }
    public String getName() { return name; }
    public int getScore() { return score; }
    public void addScore(int amount) { score += amount; }
}`;
// Splits a program into its static methods and its main statements, using the parser's positions.
function split(MJ, code) {
  let prog;
  try { prog = MJ.parse(code); } catch (e) { return null; }
  const methods = prog.methods.map(m => code.slice(m.pos, m.end)).join('\n\n');
  // A simple statement's parsed range stops before its semicolon, so include the ';' that ends it.
  const through = end => { let j = end; while (j < code.length && /\s/.test(code[j])) j++; return code[j] === ';' ? j + 1 : end; };
  const main = prog.main.map(s => code.slice(s.pos, through(s.end))).join('\n');
  return { methods, main };
}
// The same split done on the text, for programs that do not parse (compile-error cases): a line
// starting with "static" at the top level begins a method, which runs until its braces balance.
export function splitText(code) {
  const methods = [], main = [];
  let depth = 0, inMethod = false, opened = false;
  for (const line of code.split('\n')) {
    if (depth === 0 && !inMethod && /^static\s/.test(line)) { inMethod = true; opened = false; }
    (inMethod ? methods : main).push(line);
    const bare = line.replace(/\/\/.*$/, '').replace(/"(?:\\.|[^"\\])*"|'(?:\\.|[^'\\])*'/g, '');
    for (const ch of bare) { if (ch === '{') { depth++; opened = true; } else if (ch === '}') depth--; }
    if (inMethod && opened && depth === 0) inMethod = false;
    if (inMethod && !opened && /;\s*$/.test(bare)) inMethod = false;   // a one-line static variable
  }
  return { methods: methods.join('\n'), main: main.join('\n') };
}
export function writeCheck(casesUrl, className, outUrl) {
  const MJ = loadMJ();
  const cases = JSON.parse(readFileSync(casesUrl, 'utf8'));
  const helpers = [], runs = [], compiles = [];
  cases.forEach(([code, want], i) => {
    if (want === 'compile-error' || want === 'unsupported' || want === 'limit') {
      const t = splitText(code);
      compiles.push(`        compileCheck(javac, ${lit(code)}, ${lit(`import java.util.ArrayList;\npublic class Snip {\n${PLAYER}\n${t.methods}\nstatic void run() {\n${t.main}\n}\n}`)}, ${want !== 'compile-error'});`);
      return;
    }
    const parts = split(MJ, code);
    if (!parts) throw new Error('cannot split case ' + i);
    // The pieces copied into Java must still be the same program.
    const again = MJ.label(MJ.run(parts.methods + '\n' + parts.main));
    if (again !== MJ.label(MJ.run(code))) throw new Error(`case ${i} changes when split into methods and main (${again}): ${code}`);
    helpers.push(`    static class C${i} {\n${indent(parts.methods, 8)}\n        static void run() {\n${indent(parts.main, 12)}\n        }\n    }`);
    runs.push(`        check(${lit(code)}, ${lit(want)}, C${i}::run);`);
  });
  const java = `// Generated from ${casesUrl.pathname.split('/').pop()} by mj-java.mjs. Do not edit by hand.
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

public class ${className} {
${indent(PLAYER, 4)}

${helpers.join('\n\n')}

    static int passed = 0, failed = 0;
    static String capture(Runnable r) {
        PrintStream old = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buf, true));
        String tail = "";
        try { r.run(); } catch (RuntimeException e) { tail = "|throws:" + e.getClass().getSimpleName(); } finally { System.setOut(old); }
        return buf.toString().replace(System.lineSeparator(), "\\n") + tail;
    }
    static void check(String code, String want, Runnable r) {
        String got = capture(r);
        if (got.equals(want)) passed++;
        else { failed++; System.out.println("FAIL " + show(code) + "\\n  Java  " + show(got) + "\\n  table " + show(want)); }
    }
    static void compileCheck(JavaCompiler javac, String code, String source, boolean shouldCompile) throws Exception {
        JavaFileObject src = new SimpleJavaFileObject(URI.create("string:///Snip.java"), JavaFileObject.Kind.SOURCE) {
            @Override public CharSequence getCharContent(boolean ignore) { return source; }
        };
        String out = Files.createTempDirectory("snip").toString();
        boolean ok = javac.getTask(null, null, new DiagnosticCollector<JavaFileObject>(), List.of("-d", out), null, List.of(src)).call();
        if (ok == shouldCompile) passed++;
        else { failed++; System.out.println("FAIL " + show(code) + ": Java " + (ok ? "compiles" : "rejects") + " it, the table says it " + (shouldCompile ? "is valid Java" : "does not compile")); }
    }
    static String show(String s) { return "\\"" + s.replace("\\n", "\\\\n") + "\\""; }

    public static void main(String[] args) throws Exception {
${runs.join('\n')}
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        if (javac == null) throw new IllegalStateException("A JDK is needed to check compile claims.");
${compiles.join('\n')}
        System.out.println(failed == 0 ? "PASS: " + passed + " programs match Java " + System.getProperty("java.version") : failed + " of " + (passed + failed) + " programs differ");
    }
}
`;
  writeFileSync(outUrl, java);
  return { runs: runs.length, compiles: compiles.length };
}
// Runs the interpreter on every case and reports disagreements (used by each tool's run-*-tests.mjs).
export function runCases(casesUrl) {
  const MJ = loadMJ();
  const cases = JSON.parse(readFileSync(casesUrl, 'utf8'));
  const problems = [];
  for (const [code, want] of cases) {
    let got;
    try { got = MJ.label(MJ.run(code)); } catch (e) { got = 'ENGINE CRASH: ' + e.message; }
    if (got !== want) problems.push(`${JSON.stringify(code)}\n  got      ${JSON.stringify(got)}\n  expected ${JSON.stringify(want)}`);
    const r = MJ.run(code);
    if (r.steps.some(s => !s.note)) problems.push(`${JSON.stringify(code)}: a step has no explanation`);
  }
  return { cases, problems, MJ };
}
