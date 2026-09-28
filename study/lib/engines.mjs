// Loads the Java engines embedded in the visualizer pages, so study answers and
// explanations come from the same code the visualizers use (and that CI checks in Java).
import { readFileSync } from 'node:fs';
const root = new URL('../../', import.meta.url);
function extract(file, names) {
  const html = readFileSync(new URL('visualizers/' + file, root), 'utf8');
  const src = html.slice(html.indexOf('// ENGINE START'), html.indexOf('// ENGINE END'));
  return new Function(src + `; return { ${names.join(', ')} };`)();
}
export const expr = extract('exprtracer.html', ['runJava', 'javaDouble', 'show', 'asText']);
export const str = extract('stringindex.html', ['callString', 'explainCall', 'showValue', 'jstr']);
export const cmp = extract('compareto.html', ['traceCompareTo', 'explain']);
