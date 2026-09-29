// Runs the interpreter against boolean-cases.json and checks the Boolean Explorer's questions.
import { loadPage, engineCopyProblem } from './lib-page.mjs';
import { runCases } from './mj-java.mjs';
const { html, api } = loadPage('boolean.html', ['MJ', 'printProgram', 'evalCondition', 'displayNodes', 'compareConditions', 'PREDICT', 'TRANSFER', 'COND_PRESETS', 'PROG_PRESETS', 'reindent', 'hasDangling']);
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
problems.forEach(p => console.log('FAIL ' + p));
console.log(problems.length ? `${problems.length} problem(s)` : `PASS: ${cases.length} programs, ${items.length} page items covered`);
process.exit(problems.length ? 1 : 0);
