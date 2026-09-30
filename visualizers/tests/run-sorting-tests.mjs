// Checks the Search and Sort Workbench: its readings of the plain algorithms (passes, comparisons,
// swaps, shifts, indexes checked) must equal what instrumented copies print, which real Java checks.
import { loadPage, engineCopyProblem } from './lib-page.mjs';
import { runCases } from './mj-java.mjs';
import { instrumented, readInstrumented } from './sorting-instrument.mjs';
const { html, api } = loadPage('sorting.html', ['MJ', 'ALGOS', 'programFor', 'summary', 'PREDICT', 'TRANSFER', 'PRESETS']);
const { cases, problems, MJ } = runCases(new URL('sorting-cases.json', import.meta.url));
const copy = engineCopyProblem(html); if (copy) problems.push(copy);
const known = new Set(cases.map(c => c[0]));
// Every question, and every preset under every algorithm, is a run the Workbench can show.
const RUNS = [...api.PREDICT, ...api.TRANSFER].map(it => [it.algo, it.data, it.target])
  .concat(api.PRESETS.flatMap(p => Object.keys(api.ALGOS).map(a => [a, p.data, p.target])));
for (const [algo, data, target] of RUNS) {
  const plain = api.programFor(algo, data, target), inst = instrumented(algo, data, target);
  if (!known.has(plain)) { problems.push('uncovered program: ' + JSON.stringify(plain.split('\n').slice(-2).join(' '))); continue; }
  if (!known.has(inst)) { problems.push('missing instrumented copy for ' + algo + ' ' + data.join(',')); continue; }
  const run = MJ.run(plain), got = api.summary(run, algo), want = readInstrumented(algo, MJ.run(inst).out);
  const tag = `${algo} {${data.join(', ')}}${target !== undefined ? ' target ' + target : ''}`;
  if (api.ALGOS[algo].search) {
    if (got.checked.join(' ') !== want.checked.join(' ')) problems.push(`${tag}: checks ${got.checked.join(' ')}, instrumented ${want.checked.join(' ')}`);
    if (got.result !== want.result) problems.push(`${tag}: returns ${got.result}, instrumented ${want.result}`);
  } else {
    if (got.passes.map(p => p.join(' ')).join('|') !== want.passes.map(p => p.join(' ')).join('|')) problems.push(`${tag}: passes differ`);
    for (const k of ['comparisons', 'swaps', 'shifts']) if (got[k] !== want[k]) problems.push(`${tag}: ${k} ${got[k]}, instrumented ${want[k]}`);
  }
}
for (const it of [...api.PREDICT, ...api.TRANSFER]) if (it.ask === 'mc' && it.choices.filter(c => c.match === api.summary(MJ.run(api.programFor(it.algo, it.data, it.target)), it.algo).result).length !== 1) problems.push('an mc item needs exactly one matching choice');
problems.forEach(p => console.log('FAIL ' + p));
console.log(problems.length ? `${problems.length} problem(s)` : `PASS: ${cases.length} programs; ${RUNS.length} Workbench runs match their instrumented copies`);
process.exit(problems.length ? 1 : 0);
