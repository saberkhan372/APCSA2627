// Runs the interpreter against calls-cases.json and checks the Method-Call Tracer's questions.
import { loadPage, engineCopyProblem } from './lib-page.mjs';
import { runCases } from './mj-java.mjs';
const { html, api } = loadPage('calls.html', ['MJ', 'maxDepth', 'firstReturn', 'openingCall', 'holders', 'callLog', 'PREDICT', 'TRANSFER', 'PRESETS']);
const { cases, problems, MJ } = runCases(new URL('calls-cases.json', import.meta.url));
const copy = engineCopyProblem(html); if (copy) problems.push(copy);
const known = new Set(cases.map(c => c[0]));
const items = [...api.PREDICT, ...api.TRANSFER, ...api.PRESETS];
for (const it of items) {
  if (!known.has(it.code)) problems.push('uncovered page program: ' + JSON.stringify(it.code));
  const run = MJ.run(it.code);
  if (it.ask === 'mc' && it.choices.filter(c => c.match === MJ.label(run)).length !== 1) problems.push(`${JSON.stringify(it.code)}: exactly one choice must match ${MJ.label(run)}`);
  // "What does it return?" answers must equal what the program prints (checked in Java).
  if (it.ask === 'returns' && api.firstReturn(run) + '\n' !== run.out) problems.push(`${it.call}: returns ${api.firstReturn(run)}, but the program prints ${JSON.stringify(run.out)}`);
  // Every call step lists one argument per parameter, and every call is matched by a return.
  if (!run.compileError && !run.unsupported) {
    const calls = run.steps.filter(s => s.kind === 'call'), rets = run.steps.filter(s => s.kind === 'return');
    if (!run.crashed && !run.limit && !run.truncated && calls.length !== rets.length) problems.push(`${JSON.stringify(it.code)}: ${calls.length} calls but ${rets.length} returns`);
    calls.forEach(s => { const top = s.frames[s.frames.length - 1]; if (s.args.length !== top.params.length) problems.push(`${s.method}: arguments and parameters differ in number`); });
  }
}
// Stack depths, worked out by hand.
for (const [it, want] of [[api.PREDICT[10], 4], [api.TRANSFER[4], 3], [api.PREDICT[0], 2]]) if (api.maxDepth(MJ.run(it.code)) !== want) problems.push(`depth of ${JSON.stringify(it.code)}: expected ${want}`);
// The "who sees the change" callout: in bonus(a), p and main's a refer to the changed Player.
{
  const run = MJ.run(api.PREDICT[3].code), k = run.steps.findIndex(s => s.kind === 'mutate'), s = run.steps[k];
  const who = api.holders(s, s.obj).map(w => `${w.frame}.${w.name}`).sort().join(' ');
  if (who !== 'bonus.p main.a') problems.push('holders at addScore should be bonus.p and main.a, got ' + who);
  const call = api.openingCall(run.steps, k);
  if (!call || call.method !== 'bonus' || call.args[0].src !== 'a') problems.push('openingCall should find bonus(a)');
}
// Reassigning p inside replace leaves main's a on the original Player.
{
  const run = MJ.run(api.PREDICT[4].code), s = run.steps.find(x => x.kind === 'assign' && x.frames.length === 2);
  const [main, rep] = s.frames, a = main.vars.find(v => v.name === 'a'), p = rep.vars.find(v => v.name === 'p');
  if (!a || !p || a.v.ref === p.v.ref) problems.push('after p = new Player(…), p and a should refer to different objects');
}
// The call log reads in call order.
if (api.callLog(MJ.run(api.PREDICT[9].code)).join('; ') !== 'f(1) returns 2; f(2) returns 3') problems.push('call log for f(f(1)): ' + api.callLog(MJ.run(api.PREDICT[9].code)).join('; '));
problems.forEach(p => console.log('FAIL ' + p));
console.log(problems.length ? `${problems.length} problem(s)` : `PASS: ${cases.length} programs, ${items.length} page items covered`);
process.exit(problems.length ? 1 : 0);
