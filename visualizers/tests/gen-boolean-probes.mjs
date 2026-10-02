// Adds the branch map programs (each item and preset, plus its probe) to boolean-cases.json, with the
// interpreter's result as the expected output. Real Java then checks every one in CI.
// Run after changing the branching items or presets: node visualizers/tests/gen-boolean-probes.mjs
import { readFileSync, writeFileSync } from 'node:fs';
import { loadPage } from './lib-page.mjs';
import { loadMJ } from './lib-mj.mjs';
import { probeOf, branchPrograms } from './lib-probe.mjs';
const { api } = loadPage('boolean.html', ['PREDICT', 'TRANSFER', 'PROG_PRESETS', 'branchEntries']);
const MJ = loadMJ(), file = new URL('boolean-cases.json', import.meta.url);
const cases = JSON.parse(readFileSync(file, 'utf8')), known = new Set(cases.map(c => c[0]));
let added = 0;
for (const code of branchPrograms(api)) for (const prog of [code, probeOf(MJ, api, code)]) {
  if (!prog || known.has(prog)) continue;
  cases.push([prog, MJ.label(MJ.run(prog))]); known.add(prog); added++;
}
writeFileSync(file, '[\n' + cases.map(c => '  [' + JSON.stringify(c[0]) + ', ' + JSON.stringify(c[1]) + ']').join(',\n') + '\n]\n');
console.log(`Added ${added} programs (${cases.length} in total)`);
