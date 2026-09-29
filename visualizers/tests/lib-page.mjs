// Shared helpers for the visualizer tests: load a page's engine, data and embedded expression engine.
import { readFileSync } from 'node:fs';
import { BLOCKS, embedded } from './sync-expr-engine.mjs';
const dir = new URL('../', import.meta.url);
export function loadPage(file, names) {
  const html = readFileSync(new URL(file, dir), 'utf8');
  const grab = (a, b) => { const i = html.indexOf(a), j = html.indexOf(b); return i < 0 ? '' : html.slice(i, j); };
  const src = grab('// EXPR ENGINE START', '// EXPR ENGINE END') + grab('// MINIJAVA START', '// MINIJAVA END') + grab('// ENGINE START', '// ENGINE END') + grab('// DATA START', '// DATA END');
  return { html, api: new Function(src + `; return { ${names.join(', ')} };`)() };
}
// A page that embeds a shared engine must hold an exact copy of each one it embeds.
export function engineCopyProblem(html) {
  for (const b of BLOCKS) {
    const copy = embedded(html, b);
    if (copy !== null && copy !== b.source()) return `embedded copy after "${b.start}" differs from its source; run node visualizers/tests/sync-expr-engine.mjs`;
  }
  return null;
}
