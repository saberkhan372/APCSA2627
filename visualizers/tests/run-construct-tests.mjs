// Checks the Loop Construction Workbench: every combination of choices for every item against a wider set of
// inputs than the page shows, so a build that passes the page's tests is genuinely right; that each wrong
// option carries an explanation; and that the trace-table values match a probe program.
import { loadPage, engineCopyProblem } from './lib-page.mjs';
import { runCases } from './mj-java.mjs';
import { allBuilds, javaPrograms, probeSource } from './lib-construct.mjs';
const { html, api } = loadPage('construct.html', ['MJ', 'ITEMS', 'TRANSFER', 'assemble', 'runBuild', 'judge', 'culprits', 'traceRows', 'valueAfterPasses', 'passCount', 'describeLabel', 'sameBuild', 'RUN_OPTS']);
const { cases, problems, MJ } = runCases(new URL('construct-cases.json', import.meta.url));
const copy = engineCopyProblem(html); if (copy) problems.push(copy);
const known = new Map(cases.map(c => [c[0], c[1]]));
const range = (a, b) => Array.from({ length: b - a + 1 }, (_, i) => a + i);
const arr = a => `int[] a = {${a.join(', ')}};`;
const wordSet = ['pizza', 'plain', 'z', 'fizz', 'az', 'za', 'zz', 'abc', 'level', 'xyz9', 'a', 'ab', 'loop'];
// A wider "hidden" domain per item, with the expected output worked out in JavaScript from the goal text.
const DOMAIN = {
  sum: range(0, 12).map(n => [`int n = ${n};`, String(n * (n + 1) / 2)]),
  count3: range(0, 16).map(n => [`int n = ${n};`, String(Math.floor(n / 3))]),
  evens: range(0, 13).map(n => [`int n = ${n};`, String(range(1, n).filter(x => x % 2 === 0).reduce((s, x) => s + x, 0))]),
  max: [[-7, -3, -9], [-1], [3, 1, 2], [2, 9, 4, 9], [7], [1, 2, 3, 4, 5], [5, 4, 3], [-2, -2], [0, -5], [8, 8, 1]].map(a => [arr(a), String(Math.max(...a))]),
  flag: wordSet.map(w => [`String word = "${w}";`, String(w.includes('z'))]),
  reverse: wordSet.map(w => [`String word = "${w}";`, [...w].reverse().join('')]),
  power2: range(0, 40).map(n => [`int n = ${n};`, String((() => { let p = 1; while (p < n) p *= 2; return p; })())]),
  digits: [1, 5, 9, 10, 11, 99, 100, 101, 999, 1000, 4721, 12345, 90000].map(n => [`int n = ${n};`, String(String(n).length)]),
  factorial: range(0, 8).map(n => [`int n = ${n};`, String(range(1, n).reduce((p, x) => p * x, 1))]),
  negatives: [[-2, 5, -1], [3, 4], [-4], [-1, -1, -1], [0], [0, -1, 2], [5, -5, 5, -5], [1, 2, 3]].map(a => [arr(a), String(a.filter(x => x < 0).length)]),
  allpos: [[3, 5, 1], [3, -1, 2], [0], [-1, -2], [4, -3], [1], [-1], [2, 2, 2, 0], [5, 1, 7, 9]].map(a => [arr(a), String(a.every(x => x > 0))]),
  halves: range(1, 40).map(n => [`int n = ${n};`, String(Math.floor(Math.log2(n)))]),
};
const all = [...api.ITEMS, ...api.TRANSFER], ids = new Set();
for (const it of all) {
  if (ids.has(it.id)) problems.push('duplicate id ' + it.id); ids.add(it.id);
  if (!DOMAIN[it.id]) { problems.push('no hidden domain for ' + it.id); continue; }
  // The visible tests agree with the oracle.
  it.tests.forEach(t => { const o = DOMAIN[it.id].find(d => d[0] === t.data); const want = o ? o[1] : null; if (want !== null && want !== t.want) problems.push(`${it.id}: test ${t.data} says ${t.want}, oracle says ${want}`); });
  // Option sets are sane.
  it.blanks.forEach((b, k) => { const texts = b.options.map(o => o.text); if (new Set(texts).size !== texts.length) problems.push(`${it.id}: blank ${b.key} has duplicate options`); if (it.ref[k] >= b.options.length) problems.push(`${it.id}: bad ref index`); if (!template(it).includes(`[[${b.key}]]`)) problems.push(`${it.id}: blank ${b.key} is not in the template`); });
  const builds = allBuilds(it), accepted = builds.filter(b => api.judge(it, b).ok);
  if (!accepted.some(b => api.sameBuild(b, it.ref))) problems.push(`${it.id}: the standard build does not pass its own tests`);
  // A build that passes the page's tests must pass the wider domain too (the visible tests are not too weak).
  for (const b of accepted) for (const [data, want] of DOMAIN[it.id]) {
    const r = MJ.label(MJ.run(api.assemble(it, b, { data }), api.RUN_OPTS));
    if (r !== want + '\n') problems.push(`${it.id}: build ${JSON.stringify(b)} passes the page's tests but prints ${JSON.stringify(r)} for ${data} (expected ${want})`);
  }
  // Every option that appears in no accepted build is wrong, so it needs a "why".
  it.blanks.forEach((bl, k) => bl.options.forEach((o, i) => { const used = accepted.some(b => b[k] === i); if (!used && !o.why) problems.push(`${it.id}: wrong option "${o.text}" in ${bl.key} has no explanation`); }));
  // Changing one blank of the standard build to a wrong option is found by the culprit search.
  it.blanks.forEach((bl, k) => bl.options.forEach((o, i) => {
    if (i === it.ref[k]) return;
    const b = it.ref.map((x, j) => j === k ? i : x);
    if (api.judge(it, b).ok) return;
    const c = api.culprits(it, b).map(x => x.blank);
    if (!c.includes(k)) problems.push(`${it.id}: culprit search misses ${bl.key} = ${o.text}`);
  }));
  // The watched variable: the trace table's value after k passes equals a probe program's k-th printed line.
  if (it.watch) for (const t of it.tests) {
    const src = api.assemble(it, it.ref, t), probe = probeSource(it, src), po = MJ.run(probe, api.RUN_OPTS);
    // The probe's last line is the program's own final output; the lines before it are one per pass.
    const lines = po.out.replace(/\n$/, '').split('\n').slice(0, -1);
    const run = api.runBuild(it, it.ref, t).run;
    if (api.passCount(run) !== lines.length) problems.push(`${it.id} ${t.data}: ${api.passCount(run)} passes in the trace, the probe printed ${lines.length} lines`);
    lines.forEach((ln, k) => { const v = api.valueAfterPasses(run, it.watch.name, k + 1); if (String(v).replace(/^"|"$/g, '') !== ln) problems.push(`${it.id} ${t.data}: after ${k + 1} passes the trace says ${v}, the probe says ${ln}`); });
    const probeOk = probe && !MJ.run(probe).compileError;
    if (!probeOk) problems.push(it.id + ': the probe does not compile');
  }
  // The Java case table is current.
  for (const p of javaPrograms(api, it).programs) {
    const want = MJ.label(MJ.run(p, api.RUN_OPTS));
    if (!known.has(p)) problems.push(`${it.id}: a program is missing from construct-cases.json (run node visualizers/tests/gen-construct-cases.mjs)`);
    else if (known.get(p) !== want) problems.push(`${it.id}: table out of date`);
  }
  if (it.meaning && (it.meaning.answer >= it.meaning.choices.length || it.meaning.choices.length < 3)) problems.push(it.id + ': bad meaning question');
  if (!it.goal || !it.pattern || !it.title) problems.push(it.id + ': missing text');
}
function template(it) { return it.template; }
// Result wording for each kind of outcome.
const D = api.describeLabel;
if (D('limit') !== 'never stops (an infinite loop)' || !/ArrayIndexOutOfBoundsException/.test(D('|throws:ArrayIndexOutOfBoundsException')) || D('5\n') !== '"5"') problems.push('describeLabel wording');
if (!html.includes("params.get('item')")) problems.push('missing the ?item= deep link');
problems.forEach(p => console.log('FAIL ' + p));
console.log(problems.length ? `${problems.length} problem(s)` : `PASS: ${cases.length} programs, ${all.length} items, ${all.reduce((n, it) => n + allBuilds(it).length, 0)} builds checked against a wider domain`);
process.exit(problems.length ? 1 : 0);
