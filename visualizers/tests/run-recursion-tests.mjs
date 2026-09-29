// Runs the interpreter against recursion-cases.json and checks the Recursion Call Stack's questions.
import { loadPage, engineCopyProblem } from './lib-page.mjs';
import { runCases } from './mj-java.mjs';
const { html, api } = loadPage('recursion.html', ['MJ', 'callTree', 'activeNode', 'totalCalls', 'maxDepth', 'maxCopies', 'firstReturn', 'afterBase', 'PREDICT', 'TRANSFER', 'PRESETS']);
const { cases, problems, MJ } = runCases(new URL('recursion-cases.json', import.meta.url));
const copy = engineCopyProblem(html); if (copy) problems.push(copy);
const known = new Set(cases.map(c => c[0]));
// A copy of a program that prints * as the first thing in every call to its first method.
const starred = code => code.replace(/^(static [^\n]*\) \{\n)/m, '$1    System.out.print("*");\n');
const items = [...api.PREDICT, ...api.TRANSFER, ...api.PRESETS];
for (const it of items) {
  if (!known.has(it.code)) problems.push('uncovered page program: ' + JSON.stringify(it.code));
  const run = MJ.run(it.code);
  if (it.ask === 'mc' && !it.after && it.choices.filter(c => c.match === MJ.label(run)).length !== 1) problems.push(`${JSON.stringify(it.code)}: exactly one choice must match ${MJ.label(run)}`);
  if (it.after === 'base' && it.choices.filter(c => c.key === api.afterBase(run)).length !== 1) problems.push(`${JSON.stringify(it.code)}: exactly one choice must match ${api.afterBase(run)}`);
  // "What does it return?" answers must equal what the program prints (checked in Java).
  if (it.ask === 'returns' && api.firstReturn(run) + '\n' !== run.out) problems.push(`${it.call}: returns ${api.firstReturn(run)}, but the program prints ${JSON.stringify(run.out)}`);
  // "How many calls?" answers must equal the stars the starred copy prints (also checked in Java).
  if (it.ask === 'calls') {
    const s = starred(it.code);
    if (s === it.code || !known.has(s)) problems.push('the starred copy of a calls question is missing from the cases: ' + JSON.stringify(s));
    else { const stars = (MJ.run(s).out.match(/\*/g) || []).length; if (stars !== api.totalCalls(run)) problems.push(`${JSON.stringify(it.code)}: ${api.totalCalls(run)} calls in the tree, ${stars} stars printed`); }
  }
}
// Hand-worked answers.
const P = api.PREDICT, T = api.TRANSFER;
const hand = [['calls', P[8], 9], ['calls', P[11], 2], ['calls', T[2], 15], ['calls', T[7], 3], ['depth', P[12], 5], ['copies', P[1], 4], ['copies', T[4], 4]];
for (const [what, it, want] of hand) {
  const run = MJ.run(it.code), got = what === 'calls' ? api.totalCalls(run) : what === 'depth' ? api.maxDepth(run) : api.maxCopies(run, it.name);
  if (got !== want) problems.push(`${what} for ${JSON.stringify(it.code.split('\n').pop())}: expected ${want}, got ${got}`);
}
if (api.afterBase(MJ.run(P[2].code)) !== 'caller') problems.push('after fact(1) returns, fact(2) should continue');
// The call tree: labels, returned values and base cases.
const fact = api.callTree(MJ.run(P[0].code));
if (fact.map(n => `${n.label}=${n.value}${n.base ? '*' : ''}`).join(' ') !== 'fact(4)=24 fact(3)=6 fact(2)=2 fact(1)=1*') problems.push('factorial tree: ' + fact.map(n => `${n.label}=${n.value}`).join(' '));
const fib = api.callTree(MJ.run(P[8].code));
if (fib.filter(n => n.base).length !== 5 || fib.filter(n => n.label === 'fib(2)').length !== 2) problems.push('fib(4) should have 5 base cases and compute fib(2) twice');
const find = api.callTree(MJ.run(P[11].code));
if (find.map(n => n.label).join(' ') !== 'find(a, 23, 0, 6) find(a, 23, 4, 6)') problems.push('binary search labels: ' + find.map(n => n.label).join(' '));
problems.forEach(p => console.log('FAIL ' + p));
console.log(problems.length ? `${problems.length} problem(s)` : `PASS: ${cases.length} programs, ${items.length} page items covered`);
process.exit(problems.length ? 1 : 0);
