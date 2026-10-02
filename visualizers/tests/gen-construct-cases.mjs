// Writes construct-cases.json: every program the Loop Construction Workbench relies on, with the interpreter's
// result as the expected output. Real Java then runs the same programs in CI.
// Run after changing the items: node visualizers/tests/gen-construct-cases.mjs
import { writeFileSync } from 'node:fs';
import { loadPage } from './lib-page.mjs';
import { loadMJ } from './lib-mj.mjs';
import { javaPrograms } from './lib-construct.mjs';
const { api } = loadPage('construct.html', ['MJ', 'ITEMS', 'TRANSFER', 'assemble', 'judge', 'RUN_OPTS']);
const MJ = loadMJ(), cases = [], seen = new Set();
for (const it of [...api.ITEMS, ...api.TRANSFER]) for (const p of javaPrograms(api, it).programs) {
  if (seen.has(p)) continue; seen.add(p);
  cases.push([p, MJ.label(MJ.run(p, api.RUN_OPTS))]);
}
writeFileSync(new URL('construct-cases.json', import.meta.url), '[\n' + cases.map(c => '  [' + JSON.stringify(c[0]) + ', ' + JSON.stringify(c[1]) + ']').join(',\n') + '\n]\n');
console.log(`Wrote ${cases.length} programs`);
