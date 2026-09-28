// Runs the compareTo engine embedded in ../compareto.html against compareto-cases.json.
import { readFileSync } from 'node:fs';
const here = new URL('.', import.meta.url);
const html = readFileSync(new URL('../compareto.html', here), 'utf8');
const src = html.slice(html.indexOf('// ENGINE START'), html.indexOf('// ENGINE END'));
const { traceCompareTo, explain } = new Function(src + '; return { traceCompareTo, explain };')();
const cases = JSON.parse(readFileSync(new URL('compareto-cases.json', here), 'utf8'));
let fail = 0;
for (const [a, b, expected, why] of cases) {
  const t = traceCompareTo(a, b);
  const last = t.steps[t.steps.length - 1];
  const ok = t.value === expected && last.value === expected && explain(t).length > 0;
  if (!ok) { fail++; console.log(`FAIL ${JSON.stringify(a)} vs ${JSON.stringify(b)}: got ${t.value}, expected ${expected} (${why})`); }
}
// Every question set in the page must be covered by a case above.
const sets = html.match(/\{ a: '[^']*', b: '[^']*'/g).map(m => m.match(/'([^']*)', b: '([^']*)'/).slice(1));
const known = new Set(cases.map(c => c[0] + '\u0000' + c[1]));
for (const [a, b] of sets) if (!known.has(a + '\u0000' + b)) { fail++; console.log(`UNCOVERED page question: "${a}" vs "${b}"`); }
console.log(fail ? `${fail} problem(s)` : `PASS: ${cases.length} cases, ${sets.length} page questions covered`);
process.exit(fail ? 1 : 0);
