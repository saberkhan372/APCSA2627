// Runs the Memory Diagram engine against memory-cases.json and checks every page program is covered.
import { readFileSync } from 'node:fs';
import { loadPage } from './lib-page.mjs';
const { api } = loadPage('memory.html', ['runMemory', 'memLabel', 'PREDICT', 'TRANSFER', 'PRESETS']);
const cases = JSON.parse(readFileSync(new URL('memory-cases.json', import.meta.url), 'utf8'));
let fail = 0;
const bad = m => { fail++; console.log('FAIL ' + m); };
for (const [code, want] of cases) {
  let got;
  try { got = api.memLabel(api.runMemory(code)); } catch (e) { got = 'ENGINE CRASH: ' + e.message; }
  if (got !== want) bad(`${JSON.stringify(code)}\n  got      ${JSON.stringify(got)}\n  expected ${JSON.stringify(want)}`);
  // Every step must carry an explanation.
  const r = api.runMemory(code);
  if (r.steps.some(s => !s.note)) bad(`${JSON.stringify(code)}: a step has no explanation`);
}
const known = new Set(cases.map(c => c[0]));
const items = [...api.PREDICT, ...api.TRANSFER, ...api.PRESETS];
for (const it of items) {
  if (!known.has(it.code)) bad('uncovered page program: ' + JSON.stringify(it.code));
  if (it.ask === 'mc') {
    const lab = api.memLabel(api.runMemory(it.code));
    const right = it.choices.filter(c => c.match === lab).length;
    if (right !== 1) bad(`${JSON.stringify(it.code)}: ${right} choices match the result ${JSON.stringify(lab)}`);
  }
}
console.log(fail ? `${fail} problem(s)` : `PASS: ${cases.length} programs, ${items.length} page items covered`);
process.exit(fail ? 1 : 0);
