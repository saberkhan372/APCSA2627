// Runs the String engine embedded in ../stringindex.html against strings-cases.json.
import { readFileSync } from 'node:fs';
const here = new URL('.', import.meta.url);
const html = readFileSync(new URL('../stringindex.html', here), 'utf8');
const src = html.slice(html.indexOf('// ENGINE START'), html.indexOf('// ENGINE END'));
const { callString, explainCall, runLab } = new Function(src + '; return { callString, explainCall, runLab };')();
const { calls, lab } = JSON.parse(readFileSync(new URL('strings-cases.json', here), 'utf8'));
let fail = 0;
const key = (s, m, args) => JSON.stringify([s, m, args]);
for (const [s, m, args, kind, value] of calls) {
  const r = callString(s, m, args);
  const got = r.kind === 'throws' ? '' : String(r.value);
  if (r.kind !== kind || got !== value || !explainCall(s, m, args, r)) {
    fail++; console.log(`FAIL ${JSON.stringify(s)}.${m}(${JSON.stringify(args)}): got ${r.kind} ${JSON.stringify(got)}, expected ${kind} ${JSON.stringify(value)}`);
  }
}
for (const [name, phrase, expected] of lab) {
  const got = runLab(name, phrase).summary;
  if (got !== expected) { fail++; console.log(`FAIL lab ${JSON.stringify(name)} / ${JSON.stringify(phrase)}:\n  got      ${got}\n  expected ${expected}`); }
}
// Every Predict/Transfer question in the page must appear in the case table.
const known = new Set(calls.map(([s, m, args]) => key(s, m, args)));
const qs = [...html.matchAll(/\{ s: '((?:[^'\\]|\\.)*)', m: '(\w+)', args: (\[[^\]]*\])/g)]
  .map(([, s, m, args]) => [s, m, JSON.parse(args.replace(/'/g, '"'))]);
for (const [s, m, args] of qs) if (!known.has(key(s, m, args))) { fail++; console.log(`UNCOVERED page question: ${s} ${m} ${JSON.stringify(args)}`); }
console.log(fail ? `${fail} problem(s)` : `PASS: ${calls.length} calls, ${lab.length} lab runs, ${qs.length} page questions covered`);
process.exit(fail ? 1 : 0);
