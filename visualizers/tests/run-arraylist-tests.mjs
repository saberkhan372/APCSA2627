// Runs the interpreter against arraylist-cases.json and checks the ArrayList Mutation Explorer's questions.
import { loadPage, engineCopyProblem } from './lib-page.mjs';
import { runCases } from './mj-java.mjs';
const { html, api } = loadPage('arraylist.html', ['MJ', 'afterRemoval', 'skippedValues', 'nextChecked', 'cursorAt', 'PREDICT', 'TRANSFER', 'PRESETS']);
const { cases, problems, MJ } = runCases(new URL('arraylist-cases.json', import.meta.url));
const copy = engineCopyProblem(html); if (copy) problems.push(copy);
const known = new Set(cases.map(c => c[0]));
const items = [...api.PREDICT, ...api.TRANSFER, ...api.PRESETS];
for (const it of items) {
  if (!known.has(it.code)) problems.push('uncovered page program: ' + JSON.stringify(it.code));
  if (it.ask === 'mc' && it.choices.filter(c => c.match === MJ.label(MJ.run(it.code))).length !== 1) problems.push(`${JSON.stringify(it.code)}: exactly one choice must match ${MJ.label(MJ.run(it.code))}`);
}
// "Which value is checked next?", worked out by hand.
for (const [it, want] of [[api.PREDICT[5], 5], [api.TRANSFER[3], 9]]) { const got = api.nextChecked(MJ.run(it.code), it.code, it.nth); if (got !== want) problems.push(`next checked after the first removal in ${JSON.stringify(it.code.split('\n').slice(-6, -5)[0])}: expected ${want}, got ${got}`); }
// Skips, cross-checked with the Java-checked output: every match left in the final list was skipped,
// and every skipped value is still in the final list.
const removal = [[api.PREDICT[4], x => x % 2 === 0], [api.TRANSFER[0], x => x === 'a'], [api.TRANSFER[3], x => x > 5], [api.PREDICT[6], x => x % 2 === 0], [api.PREDICT[7], x => x % 2 === 0], [api.TRANSFER[1], x => x === 'a']];
for (const [it, match] of removal) {
  const run = MJ.run(it.code), final = run.out.trim().slice(1, -1).split(', ').filter(Boolean).map(t => /^-?\d+$/.test(t) ? +t : t);
  const skipped = api.skippedValues(run, it.code), count = (arr, x) => arr.filter(y => y === x).length;
  const unexplained = final.filter(match).filter(x => count(skipped, x) < count(final.filter(match), x));
  const phantom = skipped.filter(x => count(final, x) < count(skipped, x));
  if (unexplained.length || phantom.length) problems.push(`${JSON.stringify(run.out)}: skipped ${skipped.join(',') || 'none'} does not explain the matches left`);
}
// The loop cursor: an index loop shows its variable; an enhanced for shows the iterator's position.
{
  const run = MJ.run(api.PREDICT[4].code), k = run.steps.findIndex(s => s.list && s.list.op === 'remove');
  const c = api.cursorAt(run, api.PREDICT[4].code, k);
  if (!c || c.name !== 'i' || c.at !== 0) problems.push('cursor at the first removal should be i = 0');
  const run2 = MJ.run(api.PREDICT[9].code), k2 = run2.steps.findIndex(s => s.kind === 'cond' && s.done);
  if (!/hasNext\(\) is false/.test(run2.steps[k2].note)) problems.push('the silent-skip for-each should explain hasNext()');
}
problems.forEach(p => console.log('FAIL ' + p));
console.log(problems.length ? `${problems.length} problem(s)` : `PASS: ${cases.length} programs, ${items.length} page items covered`);
process.exit(problems.length ? 1 : 0);
