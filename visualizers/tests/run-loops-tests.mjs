// Runs the interpreter against loops-cases.json and checks the Loop Tracer's questions.
import { loadPage, engineCopyProblem } from './lib-page.mjs';
import { runCases } from './mj-java.mjs';
const { html, api } = loadPage('loops.html', ['MJ', 'bodyCount', 'phaseOf', 'PREDICT', 'TRANSFER', 'PRESETS']);
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
problems.forEach(p => console.log('FAIL ' + p));
console.log(problems.length ? `${problems.length} problem(s)` : `PASS: ${cases.length} programs, ${items.length} page items covered`);
process.exit(problems.length ? 1 : 0);
