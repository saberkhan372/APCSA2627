// Loads the Java engines embedded in the visualizer pages, so study answers and
// explanations come from the same code the visualizers use (and that CI checks in Java).
import { readFileSync } from 'node:fs';
const root = new URL('../../', import.meta.url);
function extract(file, names) {
  const html = readFileSync(new URL('visualizers/' + file, root), 'utf8');
  const grab = (a, b) => { const i = html.indexOf(a); return i < 0 ? '' : html.slice(i, html.indexOf(b)); };
  // Pages that reuse the Expression Tracer engine carry a copy of it before their own engine.
  const src = grab('// EXPR ENGINE START', '// EXPR ENGINE END') + grab('// ENGINE START', '// ENGINE END');
  return new Function(src + `; return { ${names.join(', ')} };`)();
}
export const expr = extract('exprtracer.html', ['runJava', 'javaDouble', 'show', 'asText']);
export const str = extract('stringindex.html', ['callString', 'explainCall', 'showValue', 'jstr']);
export const cmp = extract('compareto.html', ['traceCompareTo', 'explain']);
export const mem = extract('memory.html', ['runMemory', 'memLabel']);
export const out = extract('output.html', ['runProgram']);
export const range = extract('randomrange.html', ['compileFormula']);
