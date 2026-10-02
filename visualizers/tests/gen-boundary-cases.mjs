// Writes boundary-cases.json: for every item, the buggy method and each repair choice run over the page's
// input grid (and the buggy method and the right repair over every integer in the range), with the
// interpreter's output as the expected result. Real Java then runs the same programs in CI.
// Run after changing the items: node visualizers/tests/gen-boundary-cases.mjs
import { writeFileSync } from 'node:fs';
import { loadPage } from './lib-page.mjs';
import { loadMJ } from './lib-mj.mjs';
import { batchProgram, variants } from './lib-boundary.mjs';
const { api } = loadPage('boundary.html', ['ITEMS', 'TRANSFER']);
const MJ = loadMJ(), cases = [];
for (const it of [...api.ITEMS, ...api.TRANSFER]) {
  variants(it).forEach(v => { const p = batchProgram(v.method, it.name, it.ranges); cases.push([p, MJ.label(MJ.run(p))]); });
  for (const v of [variants(it)[0], variants(it)[1 + it.answer]]) { const p = batchProgram(v.method, it.name, it.ranges, true); if (!cases.some(c => c[0] === p)) cases.push([p, MJ.label(MJ.run(p))]); }
}
writeFileSync(new URL('boundary-cases.json', import.meta.url), '[\n' + cases.map(c => '  [' + JSON.stringify(c[0]) + ', ' + JSON.stringify(c[1]) + ']').join(',\n') + '\n]\n');
console.log(`Wrote ${cases.length} programs`);
