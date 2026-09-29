// Copies the Expression Tracer's engine into pages that evaluate Java expressions with it
// (between "// EXPR ENGINE START" and "// EXPR ENGINE END"). The run-*-tests for those pages fail
// if a copy differs, so there is one source of truth. Run: node visualizers/tests/sync-expr-engine.mjs
import { readFileSync, writeFileSync, readdirSync } from 'node:fs';
const dir = new URL('../', import.meta.url);
export function exprEngineSource() {
  const html = readFileSync(new URL('exprtracer.html', dir), 'utf8');
  const a = html.indexOf('// ENGINE START'), b = html.indexOf('// ENGINE END');
  return html.slice(html.indexOf('\n', a) + 1, b).trimEnd();
}
export function embeddedCopy(html) {
  const a = html.indexOf('// EXPR ENGINE START'), b = html.indexOf('// EXPR ENGINE END');
  if (a < 0 || b < 0) return null;
  return html.slice(html.indexOf('\n', a) + 1, b).trimEnd();
}
if (import.meta.url === `file://${process.argv[1]}`) {
  const src = exprEngineSource();
  for (const f of readdirSync(dir).filter(f => f.endsWith('.html') && f !== 'exprtracer.html')) {
    const html = readFileSync(new URL(f, dir), 'utf8');
    if (embeddedCopy(html) === null) continue;
    const a = html.indexOf('// EXPR ENGINE START'), b = html.indexOf('// EXPR ENGINE END');
    const out = html.slice(0, html.indexOf('\n', a) + 1) + src + '\n' + html.slice(b);
    if (out !== html) { writeFileSync(new URL(f, dir), out); console.log('updated', f); } else console.log('up to date', f);
  }
}
