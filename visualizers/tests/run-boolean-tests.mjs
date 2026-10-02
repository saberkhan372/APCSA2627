// Runs the interpreter against boolean-cases.json and checks the Boolean Explorer's questions.
import { loadPage, engineCopyProblem } from './lib-page.mjs';
import { runCases } from './mj-java.mjs';
import { probeOf, branchPrograms } from './lib-probe.mjs';
const { html, api } = loadPage('boolean.html', ['MJ', 'printProgram', 'evalCondition', 'displayNodes', 'compareConditions', 'PREDICT', 'TRANSFER', 'COND_PRESETS', 'PROG_PRESETS', 'reindent', 'hasDangling', 'branchEntries', 'branchState', 'whyUnchecked', 'branchSummary', 'ST']);
const { cases, problems, MJ } = runCases(new URL('boolean-cases.json', import.meta.url));
const copy = engineCopyProblem(html); if (copy) problems.push(copy);
const known = new Set(cases.map(c => c[0]));
const items = [...api.PREDICT, ...api.TRANSFER];
for (const it of items) {
  if (it.cond) {
    const p = api.printProgram(it.decls, it.cond);
    if (!known.has(p)) problems.push('uncovered condition: ' + it.cond);
    // The tree view (condition inside an if) must agree with the printed value.
    const e = api.evalCondition(it.decls, it.cond), lab = MJ.label(MJ.run(p));
    const treeLab = e.error ? '|throws:' + e.error : String(e.value) + '\n';
    if (treeLab !== lab) problems.push(`${it.cond}: tree view gives ${treeLab}, print gives ${lab}`);
  } else if (it.ask === 'mc') {
    const outs = it.choices.map(c => MJ.run(it.code.split(it.choices[0].prog).join(c.prog)).out);
    it.choices.forEach(c => { if (!known.has(it.code.split(it.choices[0].prog).join(c.prog))) problems.push('uncovered choice program: ' + c.prog); });
    if (outs.filter(o => o === '0\n').length !== 1) problems.push(`${it.show}: exactly one choice must always agree (got ${outs.join(', ')})`);
  } else if (!known.has(it.code)) problems.push('uncovered program: ' + JSON.stringify(it.code));
}
for (const p of api.PROG_PRESETS) if (!known.has(p.code)) problems.push('uncovered preset: ' + p.label);
for (const p of api.COND_PRESETS) if (!known.has(api.printProgram(p.decls, p.cond))) problems.push('uncovered condition preset: ' + p.label);
// The skipped-operand display: for "x != 0 && y / x > 1" with x = 0, the right side must be marked not evaluated.
const e = api.evalCondition('int x = 0;\nint y = 10;', 'x != 0 && y / x > 1');
if (e.tree.has(e.node.r.id)) problems.push('short-circuit display: the right side should not be evaluated');
// De Morgan comparisons: booleans give a full truth table.
const c = api.compareConditions('boolean a = true;\nboolean b = false;', '!(a && b)', '!a || !b');
if (c.rows.length !== 4 || c.mismatches.length) problems.push('De Morgan truth table should have 4 agreeing rows');
// "How Java reads it": the re-indented program must be valid Java with the same result.
for (const p of [...api.PROG_PRESETS.map(x => x.code), ...items.filter(it => it.ask === 'output').map(it => it.code)]) {
  const r = MJ.run(p);
  if (!r.prog || !api.hasDangling(r.prog)) continue;
  const again = api.reindent(r.prog, p), r2 = MJ.run(again);
  if (MJ.label(r2) !== MJ.label(r)) problems.push(`re-indented program behaves differently (${MJ.label(r2)}):\n${again}`);
}
const dang = api.PROG_PRESETS.find(x => x.label === 'Dangling else');
if (!dang || !/\n    else\n/.test(api.reindent(MJ.run(dang.code).prog, dang.code))) problems.push('dangling else: the else should line up with the inner if');

// ---- Branch map: every claim about "checked" and "never checked" is compared with a probe program.
// The probe wraps each if condition in t("L<k>", ...), which prints its label when evaluated, so the
// printed labels are exactly the conditions Java evaluated (and how many times). Real Java runs the
// same probes in CI.
for (const code of branchPrograms(api)) {
  const probe = probeOf(MJ, api, code);
  if (!probe) { problems.push('branch program does not run: ' + JSON.stringify(code)); continue; }
  if (!known.has(probe)) problems.push('uncovered probe (run node visualizers/tests/gen-boolean-probes.mjs): ' + JSON.stringify(code));
  const b = api.branchSummary(code), run = MJ.run(probe);
  const printed = [...run.out.matchAll(/L(\d+)\n/g)].map(m => 'L' + m[1]);
  b.conds.forEach((x, k) => {
    const n = printed.filter(l => l === 'L' + k).length;
    if (n !== x.t + x.f) problems.push(`${x.entry.node.cond.src}: the probe evaluated it ${n} time(s), the branch map says ${x.t + x.f}`);
    if ((n === 0) !== (x.status === 'unchecked')) problems.push(`${x.entry.node.cond.src}: status ${x.status} disagrees with the probe`);
    if (x.status === 'unchecked' && !api.whyUnchecked(b.st, b.st.indexOf(x), b.run)) problems.push(`${x.entry.node.cond.src}: no reason given for never checked`);
  });
  b.st.filter(x => x.entry.kind === 'else').forEach(x => {
    const own = b.st.find(y => y.entry.node === x.entry.node && y.entry.kind !== 'else');
    if (x.status === 'runs' && own.f === 0) problems.push('else runs without its if being false');
  });
  const stripped = run.out.replace(/L\d+\n/g, '');
  if (stripped !== MJ.run(code).out) problems.push(`the probe changes the program's own output: ${JSON.stringify(code)}`);
}
for (const it of items.filter(x => x.ask === 'nchecked' || x.ask === 'status')) {
  const b = api.branchSummary(it.code);
  if (it.ask === 'status') {
    const x = b.conds[it.target];
    if (!x) problems.push('status item targets a missing condition: ' + JSON.stringify(it.code));
    else if (x.status === 'mixed') problems.push('status item targets a condition that is both true and false: ' + x.entry.node.cond.src);
  }
  if (api.PREDICT.includes(it) && !it.tests) problems.push('Predict item has no "what this tests" text: ' + JSON.stringify(it.code));
}
// Both ends of the insight are present: a condition that is false, and one that is never checked.
const statusAnswers = api.PREDICT.filter(x => x.ask === 'status').map(x => api.branchSummary(x.code).conds[x.target].status);
for (const want of ['true', 'false', 'unchecked']) if (!statusAnswers.includes(want) && want !== 'true') problems.push('Predict has no status question whose answer is ' + want);
// The reasons read correctly for the two common shapes.
const chain = api.branchSummary(api.PREDICT[15].code), nest = api.branchSummary(api.PREDICT[17].code);
if (api.whyUnchecked(chain.st, chain.st.findIndex(x => x.status === 'unchecked'), chain.run) !== 'score >= 80 was true, so Java skipped the rest of the chain.') problems.push('chain reason: ' + api.whyUnchecked(chain.st, 2, chain.run));
if (api.whyUnchecked(nest.st, 1, nest.run) !== 'the if around it, a > 0, was false, so its body never ran.') problems.push('nested reason: ' + api.whyUnchecked(nest.st, 1, nest.run));
// Inside a loop the counts add up: x > 0 is checked 5 times, x < 0 only when x > 0 is false (3 times).
const loopB = api.branchSummary(api.PROG_PRESETS.find(x => x.label === 'if inside a loop').code);
if (loopB.conds[0].t !== 2 || loopB.conds[0].f !== 3 || loopB.conds[1].t !== 2 || loopB.conds[1].f !== 1) problems.push('loop counts: ' + JSON.stringify(loopB.conds.map(x => [x.t, x.f])));
// Mid-run, a condition has no status until its step has run.
const early = api.branchState(chain.entries, chain.run.steps, 1);
if (early.some(x => x.status !== 'unchecked')) problems.push('before the first condition runs, nothing should have a status');
// The page offers the Branching entry point and its presets.
if (!html.includes('id="go-branching"') || !html.includes("'#branching'")) problems.push('the Branching entry point is missing');
if (!api.PROG_PRESETS.find(x => x.label === 'Grade ladder · 85')) problems.push('missing preset: Grade ladder · 85');

// Edge programs: a condition that throws is "threw", not "never checked"; reasons read correctly; no crashes.
{
  const sum = src => api.branchSummary(src);
  const thr = sum('int[] a = {1};\nif (a[3] > 0) {\n    System.out.println("a");\n} else if (a[0] > 0) {\n    System.out.println("b");\n}');
  if (thr.st[0].status !== 'threw' || thr.st[0].error !== 'ArrayIndexOutOfBoundsException') problems.push('a condition that throws should have status threw, got ' + thr.st[0].status);
  if (api.whyUnchecked(thr.st, 1, thr.run) !== 'the check above it threw an exception first.') problems.push('reason after a thrown condition: ' + api.whyUnchecked(thr.st, 1, thr.run));
  const early = sum('int x = 0;\nint y = 5 / x;\nif (y > 1) {\n    System.out.println("a");\n}');
  if (early.st[0].status !== 'unchecked' || api.whyUnchecked(early.st, 0, early.run) !== 'the program stopped with an ArithmeticException before it got here.') problems.push('a condition after a crash: ' + api.whyUnchecked(early.st, 0, early.run));
  const blk = sum('int a = 9;\nif (a > 5) {\n    System.out.println(1);\n} else {\n    if (a > 0) {\n        System.out.println(2);\n    }\n}');
  if (api.whyUnchecked(blk.st, 2, blk.run) !== 'the else branch of the if above, a > 5, never ran because that condition was true.') problems.push('nested-in-else reason: ' + api.whyUnchecked(blk.st, 2, blk.run));
  const meth = sum('static int f(int v) {\n    if (v > 0) {\n        return 1;\n    }\n    return 0;\n}\nSystem.out.println(1);');
  if (api.whyUnchecked(meth.st, 0, meth.run) !== 'the method f was never called.') problems.push('uncalled method reason');
  const never = sum('int n = 0;\nfor (int i = 0; i < n; i++) {\n    if (i > 1) {\n        n++;\n    }\n}');
  if (api.whyUnchecked(never.st, 0, never.run) !== 'the loop body never ran.') problems.push('loop never entered reason');
  if (sum('int a = 1;').entries.length !== 0) problems.push('a program with no if should have an empty branch map');
}
problems.forEach(p => console.log('FAIL ' + p));
console.log(problems.length ? `${problems.length} problem(s)` : `PASS: ${cases.length} programs, ${items.length} page items covered`);
process.exit(problems.length ? 1 : 0);
