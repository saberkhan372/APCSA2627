// Runs the interpreter against loops-cases.json and checks the Loop Tracer's questions.
import { loadPage, engineCopyProblem } from './lib-page.mjs';
import { runCases } from './mj-java.mjs';
import { presetPrograms, probeOf, LONG_PROGRAMS } from './lib-compare.mjs';
const { html, api } = loadPage('loops.html', ['MJ', 'bodyCount', 'phaseOf', 'PREDICT', 'TRANSFER', 'PRESETS', 'COMPARE_PRESETS', 'compareLoops', 'summarizeRun', 'parseValues']);
const { cases, problems, MJ } = runCases(new URL('loops-cases.json', import.meta.url));
const copy = engineCopyProblem(html); if (copy) problems.push(copy);
const known = new Set(cases.map(c => c[0]));
const items = [...api.PREDICT, ...api.TRANSFER, ...api.PRESETS];
for (const it of items) {
  if (!known.has(it.code)) problems.push('uncovered page program: ' + JSON.stringify(it.code));
  const run = MJ.run(it.code);
  if (it.ask === 'mc' && it.choices.filter(c => c.match === MJ.label(run)).length !== 1) problems.push(`${JSON.stringify(it.code)}: exactly one choice must match ${MJ.label(run)}`);
  // "How many times" answers must equal the count the program itself prints (checked in Java).
  if (it.ask === 'count' && String(api.bodyCount(run)) + '\n' !== run.out) problems.push(`${JSON.stringify(it.code)}: body count ${api.bodyCount(run)} differs from the printed count ${JSON.stringify(run.out)}`);
}
// "What happens next" answers, checked against hand-worked expectations.
const nextExpect = [[api.PREDICT[3], 1], [api.PREDICT[8], 3]];
for (const [it, want] of nextExpect) if (api.phaseOf(MJ.run(it.code), it.code, it.after) !== want) problems.push(`next-step question ${JSON.stringify(it.code)}: expected choice ${want}`);
// for → while rewriting must keep the same output.
for (const it of items) { const w = MJ.forToWhile(it.code); if (w && MJ.label(MJ.run(w)) !== MJ.label(MJ.run(it.code))) problems.push('for→while changes the result of ' + JSON.stringify(it.code)); }

// ---- Compare two loops. Every program a preset runs is in the Java table, and the tool's looping counts match a
// probe that counts body runs (the probe is checked in real Java).
for (const p of api.COMPARE_PRESETS) {
  for (const r of presetPrograms(api, p)) {
    if (!known.has(r.src)) problems.push(`uncovered compare program (run node visualizers/tests/gen-loops-compare.mjs): ${p.label}, n = ${r.n}`);
    const probe = probeOf(MJ, r.src), s = api.summarizeRun(r.src);
    if (!probe) { problems.push(`${p.label}: no probe for ${JSON.stringify(r.code)}`); continue; }
    if (!known.has(probe)) problems.push(`uncovered compare probe: ${p.label}, n = ${r.n}`);
    if (s.problem) { problems.push(`${p.label}: ${s.problem}`); continue; }
    if (s.inconclusive) continue;
    const m = /visits=(\d+)\n$/.exec(MJ.run(probe).out);
    if (!m || +m[1] !== s.iterations) problems.push(`${p.label}, n = ${r.n}: the tool counts ${s.iterations} body runs, the probe counted ${m && m[1]}`);
    if (s.end === 'finishes normally' && s.checks !== s.iterations + 1) problems.push(`${p.label}, n = ${r.n}: ${s.checks} checks for ${s.iterations} body runs`);
    if (!p.note) problems.push(p.label + ': no note');
  }
}
// What each preset is meant to teach, worked out by hand: [outputs differ, variables differ, looping differs, ending differs] per n.
const EXPECT = {
  'for vs while': { n: [0, 1, 5, 6], out: [0, 0, 0, 0], vars: [1, 1, 1, 1], work: [0, 0, 0, 0], end: [0, 0, 0, 0] },
  'Up vs down': { n: [0, 1, 5, 6], out: [0, 0, 0, 0], vars: [0, 0, 0, 0], work: [0, 0, 0, 0], end: [0, 0, 0, 0] },
  'Shifted start and bound': { n: [1, 3, 5], out: [1, 1, 1], vars: [1, 1, 1], work: [0, 0, 0], end: [0, 0, 0] },
  'First item outside the loop': { n: [1, 2, 5, 0], out: [0, 0, 0, 1], vars: [0, 0, 0, 1], work: [1, 1, 1, 0], end: [0, 0, 0, 0] },
  'Never ends for some n': { n: [3, 0, -2], out: [0, 0, 2], vars: [1, 1, 2], work: [0, 0, 2], end: [0, 0, 2] },
};
for (const p of api.COMPARE_PRESETS) {
  const want = EXPECT[p.label];
  if (!want) { problems.push('no hand-worked expectation for preset ' + p.label); continue; }
  const c = api.compareLoops(p.setup, p.a, p.b, api.parseValues(p.values).values);
  if (JSON.stringify(c.runs.map(r => r.n)) !== JSON.stringify(want.n)) { problems.push(`${p.label}: values ${JSON.stringify(c.runs.map(r => r.n))}`); continue; }
  for (const k of ['out', 'vars', 'work', 'end']) {
    const got = c.runs.map(r => r.inconclusive ? 2 : r[k] ? 0 : 1);
    if (JSON.stringify(got) !== JSON.stringify(want[k])) problems.push(`${p.label}: "${k}" differs as ${JSON.stringify(got)}, expected ${JSON.stringify(want[k])}`);
  }
}
// Setup handling and value parsing.
const noN = api.compareLoops('int total = 0;', 'total = 1;', 'total = 2;', [1, 2]);
if (noN.runs.length !== 1 || noN.hasN) problems.push('compare: without an int n in the setup there should be one run');
if (api.compareLoops('int n = 5;', 'int x = n', 'int y = n;', [1]).problem === null) problems.push('compare: a compile error should be reported');
if (!api.parseValues('1, 2, x').error || !api.parseValues('').error || !api.parseValues('1,2,3,4,5,6,7,8,9').error || !api.parseValues('12345').error) problems.push('parseValues should refuse bad lists');
if (JSON.stringify(api.parseValues('0, −3, 7').values) !== '[0,-3,7]') problems.push('parseValues should read 0, −3, 7');
const same = api.compareLoops('int n = 3;', 'int t = 0;\nfor (int i = 0; i < n; i++) { t += 2; }\nSystem.out.println(t);', 'int t = 0;\nint i = 0;\nwhile (i < n) { t += 2; i++; }\nSystem.out.println(t);', [3]);
if (!same.runs[0].out || !same.runs[0].work || same.runs[0].vars) problems.push('compare: for and while should match in output and looping but differ in leftover variables');
if (!html.includes('id="m-cmp"') || !html.includes("'#compare'")) problems.push('missing the Compare two loops entry');

for (const src of LONG_PROGRAMS) { const pr = probeOf(MJ, src), sm = api.summarizeRun(src); if (!known.has(src) || !known.has(pr)) problems.push('long program not in the Java table (run gen-loops-compare.mjs)'); const m = /visits=(\d+)\n$/.exec(MJ.run(pr).out); if (!m || +m[1] !== sm.iterations) problems.push('long program: the tool counts ' + sm.iterations + ' body runs, the probe counted ' + (m && m[1])); }
// A long run: the saved steps stop at a cap, but the totals and final variables must not.
{
  const long = api.summarizeRun('int s = 0;\nfor (int i = 0; i < 9999; i++) {\n    s++;\n}\nSystem.out.println(s);');
  if (long.out !== '9999\n' || long.iterations !== 9999 || long.checks !== 10000 || long.vars !== 's = 9999') problems.push('long loop summary: ' + JSON.stringify(long));
  const longRun = MJ.run('int s = 0;\nfor (int i = 0; i < 9999; i++) {\n    s++;\n}');
  if (!longRun.truncated) problems.push('the long-loop reproduction should exceed the step cap');
  const whileLong = api.summarizeRun('int s = 0;\nint i = 0;\nwhile (i < 5000) {\n    s += 2;\n    i++;\n}\nSystem.out.println(s);');
  if (whileLong.iterations !== 5000 || whileLong.vars !== 's = 10000; i = 5000') problems.push('long while summary: ' + JSON.stringify(whileLong));
  const each = api.summarizeRun('int[] a = {4, 5, 6};\nint t = 0;\nfor (int v : a) {\n    t += v;\n}\nSystem.out.println(t);');
  if (each.iterations !== 3 || each.checks !== 4 || each.vars !== 'a = [4, 5, 6]; t = 15') problems.push('foreach summary: ' + JSON.stringify(each));
  // Two finite loops that need more operations than the tool allows: inconclusive, never "differ" or "agree".
  const big = (v) => `int c = 0;\nfor (int i = 0; i < 1000; i++) {\n    for (int j = 0; j < 1000; j++) {\n        c++;\n    }\n}\nSystem.out.println(${v});`;
  const cmp = api.compareLoops('int n = 1;', big('1'), big('2'), [1]);
  if (!cmp.runs[0].inconclusive || 'out' in cmp.runs[0]) problems.push('over-limit runs must be inconclusive and make no agreement claim');
  if (/never stops/.test(JSON.stringify(cmp.runs[0].A))) problems.push('over-limit runs must not be called endless');
  // A finished run beside one that hit the limit is also inconclusive.
  const mixed = api.compareLoops('int n = 1;', 'System.out.println(1);', 'while (n > 0) {\n    n++;\n}\nSystem.out.println(1);', [1]);
  if (!mixed.runs[0].inconclusive) problems.push('a finished run next to a limit run should be inconclusive');
}
problems.forEach(p => console.log('FAIL ' + p));
console.log(problems.length ? `${problems.length} problem(s)` : `PASS: ${cases.length} programs, ${items.length} page items covered`);
process.exit(problems.length ? 1 : 0);
