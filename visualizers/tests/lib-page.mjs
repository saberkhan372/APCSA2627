// Shared helpers for the visualizer tests: load a page's engine, data and embedded expression engine.
import { readFileSync } from 'node:fs';
import { exprEngineSource, embeddedCopy } from './sync-expr-engine.mjs';
const dir = new URL('../', import.meta.url);
export function loadPage(file, names) {
  const html = readFileSync(new URL(file, dir), 'utf8');
  const grab = (a, b) => { const i = html.indexOf(a), j = html.indexOf(b); return i < 0 ? '' : html.slice(i, j); };
  const src = grab('// EXPR ENGINE START', '// EXPR ENGINE END') + grab('// ENGINE START', '// ENGINE END') + grab('// DATA START', '// DATA END');
  return { html, api: new Function(src + `; return { ${names.join(', ')} };`)() };
}
// A page that embeds the Expression Tracer engine must hold an exact copy of it.
export function engineCopyProblem(html) {
  const copy = embeddedCopy(html);
  if (copy === null) return null;
  return copy === exprEngineSource() ? null : 'embedded expression engine differs from exprtracer.html; run node visualizers/tests/sync-expr-engine.mjs';
}
