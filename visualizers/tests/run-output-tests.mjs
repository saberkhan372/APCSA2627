// Runs the Output Predictor engine against output-cases.json, and checks every page program is covered.
import { readFileSync } from 'node:fs';
import { loadPage, engineCopyProblem } from './lib-page.mjs';
const { html, api } = loadPage('output.html', ['runProgram', 'PREDICT', 'TRANSFER', 'PRESETS']);
const cases = JSON.parse(readFileSync(new URL('output-cases.json', import.meta.url), 'utf8'));
let fail = 0;
const copy = engineCopyProblem(html);
if (copy) { fail++; console.log('FAIL ' + copy); }
const label = r => r.compileError ? 'compile-error' : r.unsupported ? 'unsupported' : r.crashed ? `${r.out}|throws:${r.crashed}` : r.out;
for (const [code, want] of cases) {
  const got = label(api.runProgram(code));
  if (got !== want) { fail++; console.log(`FAIL ${JSON.stringify(code)}\n  got      ${JSON.stringify(got)}\n  expected ${JSON.stringify(want)}`); }
}
const known = new Set(cases.map(c => c[0]));
const items = [...api.PREDICT, ...api.TRANSFER, ...api.PRESETS];
for (const it of items) if (!known.has(it.code)) { fail++; console.log('UNCOVERED page program: ' + JSON.stringify(it.code)); }
console.log(fail ? `${fail} problem(s)` : `PASS: ${cases.length} programs, ${items.length} page items covered`);
process.exit(fail ? 1 : 0);
