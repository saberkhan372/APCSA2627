// Checks the Boundary-Case Tester: every method against an independent oracle, the exact set of inputs that
// expose each bug, that exactly one repair choice is right, and that the Java case table is current.
import { readFileSync } from 'node:fs';
import { loadPage, engineCopyProblem } from './lib-page.mjs';
import { runCases } from './mj-java.mjs';
import { batchProgram, variants, withFix } from './lib-boundary.mjs';
const { html, api } = loadPage('boundary.html', ['MJ', 'ITEMS', 'TRANSFER', 'runCall', 'exposing', 'inputGrid', 'compareMethods', 'specAt', 'specText', 'buggyText', 'MAX_INPUT', 'MAX_COMBOS']);
const { cases, problems, MJ } = runCases(new URL('boundary-cases.json', import.meta.url));
const copy = engineCopyProblem(html); if (copy) problems.push(copy);
const known = new Map(cases.map(c => [c[0], c[1]]));

// Independent JavaScript versions of each specification and of each bug, written from the item's
// plain-English text, not from the Java.
const SPEC = {
  grade: s => s >= 90 ? 'A' : s >= 80 ? 'B' : 'C',
  teen: a => a >= 13 && a <= 19,
  month: m => m >= 1 && m <= 12,
  bonus: s => s >= 1000 ? 100 : s >= 500 ? 50 : 0,
  sumto: n => n < 1 ? 0 : n * (n + 1) / 2,
  threes: n => n < 1 ? 0 : Math.floor(n / 3),
  ride: (age, h) => age >= 10 && h >= 120,
  size: n => n < 10 ? 'small' : n < 100 ? 'medium' : 'large',
  hour: h => h >= 0 && h <= 23,
  discount: i => i >= 10 ? 20 : 0,
  sumodd: n => { let t = 0; for (let i = 1; i <= n; i += 2) t += i; return t; },
  borrow: (age, b) => age >= 12 && b < 5,
};
const BUG = {
  grade: s => s > 90 ? 'A' : s >= 80 ? 'B' : 'C',
  teen: a => a > 13 && a < 19,
  month: () => true,
  bonus: s => { let b = 0; if (s >= 1000) b = 100; if (s >= 500) b = 50; return b; },
  sumto: n => { let t = 0; for (let i = 1; i < n; i++) t += i; return t; },
  threes: n => { let c = 0; for (let i = 0; i <= n; i++) if (i % 3 === 0) c++; return c; },
  ride: (age, h) => age > 10 && h >= 120,
  size: n => n < 100 ? 'medium' : n < 10 ? 'small' : 'large',
  hour: h => h > 0 && h < 23,
  discount: i => i > 10 ? 20 : 0,
  sumodd: n => { let t = 0; for (let i = 1; i < n; i += 2) t += i; return t; },
  borrow: (age, b) => age >= 12 && b <= 5,
};
// What each insight text claims about where the bug shows, as a rule over the inputs (checked on the grid).
const CLAIM = {
  grade: ([s]) => s === 90,
  teen: ([a]) => a === 13 || a === 19,
  month: ([m]) => m < 1 || m > 12,
  bonus: ([s]) => s >= 1000,
  sumto: ([n]) => n >= 1,
  threes: ([n]) => n >= 0,
  ride: ([age, h]) => age === 10 && h >= 120,
  size: ([n]) => n < 10,
  hour: ([h]) => h === 0 || h === 23,
  discount: ([i]) => i === 10,
  sumodd: ([n]) => n % 2 === 1,
  borrow: ([age, b]) => age >= 12 && b === 5,
};
const grid = (it, full) => api.inputGrid(it.ranges.map(r => full ? [r[0], r[1], 1] : r));
const all = [...api.ITEMS, ...api.TRANSFER];
const ids = new Set();
for (const it of all) {
  if (ids.has(it.id)) problems.push('duplicate item id ' + it.id); ids.add(it.id);
  if (!SPEC[it.id] || !BUG[it.id]) { problems.push('no oracle for ' + it.id); continue; }
  if (!it.insight || !it.spec || !it.title) problems.push(it.id + ': missing text');
  if (it.fixes.length < 1 || it.answer >= it.fixes.length) problems.push(it.id + ': bad answer index');
  const show = x => typeof x === 'boolean' ? String(x) : String(x);
  // Whole-range check in one run per version: the batch program prints every result.
  const specLines = grid(it, true).map(a => show(SPEC[it.id](...a))), bugLines = grid(it, true).map(a => show(BUG[it.id](...a)));
  const outOf = method => { const r = MJ.run(batchProgram(method, it.name, it.ranges, true)); return r.compileError || r.unsupported || r.limit ? 'ERR ' + (r.compileError || r.unsupported || r.limit) : r.out.replace(/\n$/, '').split('\n'); };
  const specOut = outOf(variants(it)[1 + it.answer].method), bugOut = outOf(variants(it)[0].method);
  if (JSON.stringify(specOut) !== JSON.stringify(specLines)) problems.push(`${it.id}: the correct repair disagrees with the oracle over the whole range`);
  if (JSON.stringify(bugOut) !== JSON.stringify(bugLines)) problems.push(`${it.id}: the buggy method disagrees with the buggy oracle over the whole range`);
  // The page uses the grid (a subset); its set of exposing inputs must be non-empty, and match the oracles.
  const gridAll = grid(it, false), expectBug = gridAll.filter(a => show(SPEC[it.id](...a)) !== show(BUG[it.id](...a)));
  const gotBug = api.exposing(it, api.buggyText(it));
  if (!expectBug.length) problems.push(it.id + ': no input in the range exposes the bug');
  const claimed = gridAll.filter(a => CLAIM[it.id](a));
  if (JSON.stringify(claimed) !== JSON.stringify(expectBug)) problems.push(`${it.id}: the insight's claim does not match where the bug really shows: ${JSON.stringify(expectBug)}`);
  if (JSON.stringify(gotBug) !== JSON.stringify(expectBug)) problems.push(`${it.id}: exposing set ${JSON.stringify(gotBug)} differs from the oracles' ${JSON.stringify(expectBug)}`);
  // Exactly one repair is right, and "right" means right over every integer, not just the grid.
  const rightIdx = [];
  it.fixes.forEach((f, i) => {
    const m = withFix(it, f), r = MJ.run(batchProgram(m, it.name, it.ranges, true));
    if (r.compileError || r.unsupported) { problems.push(`${it.id}: repair ${i} does not compile: ${r.compileError || r.unsupported}`); return; }
    const fullOk = JSON.stringify(r.out.replace(/\n$/, '').split('\n')) === JSON.stringify(specLines), gridOk = api.exposing(it, m).length === 0;
    if (fullOk !== gridOk) problems.push(`${it.id}: repair ${i} looks ${gridOk ? 'right' : 'wrong'} on the page's grid but is ${fullOk ? 'right' : 'wrong'} over the whole range`);
    if (fullOk) rightIdx.push(i);
  });
  if (rightIdx.length !== 1 || rightIdx[0] !== it.answer) problems.push(`${it.id}: the right repair should be only index ${it.answer} (got ${JSON.stringify(rightIdx)})`);
  // The hint line must point at a line that the right repair changes.
  const spec = api.specText(it).split('\n'), bug = it.buggy;
  if (spec[it.fix.from] === bug[it.fix.from]) problems.push(it.id + ': the hint line is not changed by the right repair');
  // The page runs one call at a time; it must match the batch lines that Java checks.
  const fullGrid = grid(it, true);
  for (const a of gridAll.filter((_, k) => k % 7 === 0)) {
    const one = api.runCall(api.buggyText(it), it.name, a), idx = fullGrid.findIndex(b => b.join() === a.join());
    if (one !== bugOut[idx]) problems.push(`${it.id}: a single call at ${a} gives ${one}, the batch run gives ${bugOut[idx]}`);
  }
  // The Java case table must hold every version's program with the interpreter's result.
  for (const v of variants(it)) {
    const p = batchProgram(v.method, it.name, it.ranges), want = MJ.label(MJ.run(p));
    if (!known.has(p)) problems.push(`${it.id} ${v.label}: not in boundary-cases.json (run node visualizers/tests/gen-boundary-cases.mjs)`);
    else if (known.get(p) !== want) problems.push(`${it.id} ${v.label}: table is out of date`);
  }
}
// Compare two methods.
const c = api.compareMethods(api.buggyText(api.ITEMS[0]), api.specText(api.ITEMS[0]), [[80, 100]]);
if (c.diffs.length !== 1 || c.diffs[0].args[0] !== 90) problems.push('compare: grade should differ only at 90');
if (!api.compareMethods('static int f(int x) { return x; }', 'static int g(int x) { return x; }', []).error) problems.push('compare: different names should be refused');
if (!api.compareMethods('static int f(double x) { return 1; }', 'static int f(double x) { return 1; }', []).error) problems.push('compare: non-int parameters should be refused');
if (!api.compareMethods('static int f(int x) { return x; }', 'static int f(int x) { return x; }', [[0, 5000]]).error) problems.push('compare: huge ranges should be refused');
const same = api.compareMethods('static int f(int x) { return x * 2; }', 'static int f(int x) { return x + x; }', [[-3, 3]]);
if (same.diffs.length !== 0 || same.total !== 7) problems.push('compare: equal methods should agree on all 7 inputs');
const thrower = api.compareMethods('static int f(int x) { return 10 / x; }', 'static int f(int x) { return 10 / (x + 1); }', [[-2, 2]]);
if (!thrower.rows.some(r => /throws ArithmeticException/.test(r.a)) || !thrower.rows.some(r => /throws ArithmeticException/.test(r.b))) problems.push('compare: exceptions should show as results');

// Guards: huge inputs and ranges are refused, and an endless loop reads as such, not as a number.
if (!api.compareMethods('static int f(int x) { return x; }', 'static int f(int x) { return x; }', [[0, api.MAX_INPUT + 1]]).error) problems.push('compare: an input beyond the limit should be refused');
if (!api.compareMethods('static int f(int x) { return x; }', 'static int f(int x) { return x; }', [[0, api.MAX_COMBOS]]).error) problems.push('compare: more than the allowed number of inputs should be refused');
if (api.runCall('static int f(int x) {\n    while (true) {\n        x++;\n    }\n}', 'f', [1]) !== 'never stops (the tool gave up)') problems.push('an endless loop should read "never stops"');
{ const sum = api.ITEMS.find(i => i.id === 'sumto'), t0 = Date.now(); api.runCall(api.buggyText(sum), 'sumTo', [api.MAX_INPUT]); if (Date.now() - t0 > 2000) problems.push('the largest allowed input is too slow'); }
// Every Explore preset opens within the limits and shows what its item says it exposes.
for (const it of api.ITEMS) {
  const rs = (it.exploreRanges || it.ranges).map(r => [r[0], r[1]]), c = api.compareMethods(api.buggyText(it), api.specText(it), rs);
  if (c.error) problems.push(`${it.id}: its Explore preset is refused: ${c.error}`);
  else if (!c.diffs.length) problems.push(`${it.id}: its Explore preset shows no difference`);
}
// Every Find item has a distinct way to be wrong, and the page offers the deep link and the hint.
if (!html.includes("params.get('item')")) problems.push('missing the ?item= deep link');
problems.forEach(p => console.log('FAIL ' + p));
console.log(problems.length ? `${problems.length} problem(s)` : `PASS: ${cases.length} programs, ${all.length} items checked against oracles`);
process.exit(problems.length ? 1 : 0);
