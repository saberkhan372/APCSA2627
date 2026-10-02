// Adds the programs behind "Compare two loops" (each preset, for each value of n, loop A and loop B, plus a
// probe that counts body runs) to loops-cases.json. Real Java then checks every one in CI.
// Run after changing the compare presets: node visualizers/tests/gen-loops-compare.mjs
import { readFileSync, writeFileSync } from 'node:fs';
import { loadPage } from './lib-page.mjs';
import { loadMJ } from './lib-mj.mjs';
import { presetPrograms, probeOf } from './lib-compare.mjs';
const { api } = loadPage('loops.html', ['COMPARE_PRESETS', 'parseValues']);
const MJ = loadMJ(), file = new URL('loops-cases.json', import.meta.url);
const cases = JSON.parse(readFileSync(file, 'utf8')), known = new Set(cases.map(c => c[0]));
let added = 0;
for (const p of api.COMPARE_PRESETS) for (const r of presetPrograms(api, p)) for (const prog of [r.src, probeOf(MJ, r.src)]) {
  if (!prog || known.has(prog)) continue;
  cases.push([prog, MJ.label(MJ.run(prog))]); known.add(prog); added++;
}
writeFileSync(file, '[\n' + cases.map(c => '  [' + JSON.stringify(c[0]) + ', ' + JSON.stringify(c[1]) + ']').join(',\n') + '\n]\n');
console.log(`Added ${added} programs (${cases.length} in total)`);
