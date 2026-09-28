// Runs the expression engine embedded in ../exprtracer.html against expr-cases.json.
import { readFileSync } from 'node:fs';
const here = new URL('.', import.meta.url);
const html = readFileSync(new URL('../exprtracer.html', here), 'utf8');
const src = html.slice(html.indexOf('// ENGINE START'), html.indexOf('// ENGINE END'));
const { runJava } = new Function(src + '; return { runJava };')();
const cases = JSON.parse(readFileSync(new URL('expr-cases.json', here), 'utf8'));
let fail = 0;
for (const [d, s, expected] of cases) {
  let got;
  try { got = runJava(d, s).label; } catch (e) { got = 'ENGINE CRASH: ' + e.message; }
  if (got !== expected) { fail++; console.log(`FAIL [${d}] ${s}\n  got      ${got}\n  expected ${expected}`); }
}
// Every Predict/Transfer question and Explore preset must appear in the case table.
const known = new Set(cases.map(([d, s]) => d + '\u0000' + s));
const qs = [...html.matchAll(/\{ (?:label: '[^']*', )?d: '((?:[^'\\]|\\.)*)', s: '((?:[^'\\]|\\.)*)'/g)].map(m => [m[1], m[2]]);
for (const [d, s] of qs) if (!known.has(d + '\u0000' + s)) { fail++; console.log(`UNCOVERED page item: [${d}] ${s}`); }
console.log(fail ? `${fail} problem(s)` : `PASS: ${cases.length} cases, ${qs.length} page items covered`);
process.exit(fail ? 1 : 0);
