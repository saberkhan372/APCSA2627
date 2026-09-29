// Runs the Range Builder analysis against range-cases.json and checks the page's questions are sound.
import { readFileSync } from 'node:fs';
import { loadPage, engineCopyProblem } from './lib-page.mjs';
const { html, api } = loadPage('randomrange.html', ['compileFormula', 'analyze', 'PREDICT', 'TRANSFER', 'PRESETS']);
const cases = JSON.parse(readFileSync(new URL('range-cases.json', import.meta.url), 'utf8'));
let fail = 0;
const bad = m => { fail++; console.log('FAIL ' + m); };
const copy = engineCopyProblem(html);
if (copy) bad(copy);
for (const c of cases) {
  const f = api.compileFormula(c.f);
  if (c.error) {
    const got = f.compileError ? 'compile-error' : f.type === 'int' && api.analyze(f).error ? 'throws:' + api.analyze(f).error : 'ok';
    if (got !== c.error) bad(`${c.f}: got ${got}, expected ${c.error}`);
    continue;
  }
  if (f.type !== 'int') { bad(`${c.f}: not an int formula (${f.compileError || f.unsupported || f.type})`); continue; }
  const a = api.analyze(f);
  if (c.tooMany) { if (!a.tooMany || a.min !== c.min || a.max !== c.max) bad(`${c.f}: expected too many values with ${c.min} to ${c.max}`); continue; }
  if (a.tooMany) { bad(`${c.f}: reported too many values`); continue; }
  const got = { min: a.min, max: a.max, count: a.values.length, mode: a.mode, edgeLow: a.edgeLow, edgeTop: a.edgeTop };
  for (const k of Object.keys(got)) if (JSON.stringify(got[k]) !== JSON.stringify(c[k])) bad(`${c.f}: ${k} is ${JSON.stringify(got[k])}, table says ${JSON.stringify(c[k])}`);
}
const known = new Set(cases.map(c => c.f));
const items = [...api.PREDICT, ...api.TRANSFER, ...api.PRESETS];
for (const it of items) {
  for (const f of it.f ? [it.f] : it.choices) if (!known.has(f)) bad('uncovered page formula: ' + f);
  if (it.ask === 'mc') {
    const right = it.choices.filter(c => { const a = api.analyze(api.compileFormula(c)); return a.min === it.lo && a.max === it.hi && a.edges.length === 0; });
    if (right.length !== 1) bad(`multiple-choice ${it.lo} to ${it.hi}: ${right.length} correct choices`);
    if (new Set(it.choices).size !== it.choices.length) bad(`multiple-choice ${it.lo} to ${it.hi}: duplicate choices`);
  }
  if (it.ask === 'mode' && api.analyze(api.compileFormula(it.f)).mode === null) bad(`${it.f}: asks for the most common value, but values are equally likely`);
}
console.log(fail ? `${fail} problem(s)` : `PASS: ${cases.length} formulas, ${items.length} page items covered`);
process.exit(fail ? 1 : 0);
