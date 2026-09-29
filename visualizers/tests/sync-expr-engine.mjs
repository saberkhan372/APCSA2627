// Embeds exact copies of the shared engines into the pages that use them, between markers:
//   // EXPR ENGINE START … // EXPR ENGINE END   the Expression Tracer engine (from exprtracer.html)
//   // MINIJAVA START … // MINIJAVA END         the mini-Java interpreter (lib/minijava.js)
//   // TRACE UI START … // TRACE UI END         shared trace UI pieces (lib/trace-ui.js)
// Every page test fails if a copy differs from its source. Run: node visualizers/tests/sync-expr-engine.mjs
import { readFileSync, writeFileSync, readdirSync } from 'node:fs';
const dir = new URL('../', import.meta.url);
export function exprEngineSource() {
  const html = readFileSync(new URL('exprtracer.html', dir), 'utf8');
  const a = html.indexOf('// ENGINE START'), b = html.indexOf('// ENGINE END');
  return html.slice(html.indexOf('\n', a) + 1, b).trimEnd();
}
export const BLOCKS = [
  { start: '// EXPR ENGINE START', end: '// EXPR ENGINE END', source: exprEngineSource },
  { start: '// MINIJAVA START', end: '// MINIJAVA END', source: () => readFileSync(new URL('lib/minijava.js', dir), 'utf8').trimEnd() },
  { start: '// TRACE UI START', end: '// TRACE UI END', source: () => readFileSync(new URL('lib/trace-ui.js', dir), 'utf8').trimEnd() },
];
export function embedded(html, block) {
  const a = html.indexOf(block.start), b = html.indexOf(block.end);
  if (a < 0 || b < 0) return null;
  return html.slice(html.indexOf('\n', a) + 1, b).trimEnd();
}
export function embeddedCopy(html) { return embedded(html, BLOCKS[0]); }
export function syncHtml(html) {
  for (const block of BLOCKS) {
    if (embedded(html, block) === null) continue;
    const a = html.indexOf(block.start), b = html.indexOf(block.end);
    html = html.slice(0, html.indexOf('\n', a) + 1) + block.source() + '\n' + html.slice(b);
  }
  return html;
}
if (import.meta.url === `file://${process.argv[1]}`) {
  for (const f of readdirSync(dir).filter(f => f.endsWith('.html') && f !== 'exprtracer.html')) {
    const html = readFileSync(new URL(f, dir), 'utf8'), out = syncHtml(html);
    if (out !== html) { writeFileSync(new URL(f, dir), out); console.log('updated', f); }
  }
}
