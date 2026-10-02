// Shared helpers for the Boundary-Case Tester's checks: the programs that run a method over a whole
// range of inputs, and the table of programs real Java verifies.
export const rangeOf = (r, full) => full ? [r[0], r[1], 1] : [r[0], r[1], r[2] || 1];
// A program that defines the method and prints its result for every input in the ranges, in the same
// order the page tries them (the first parameter changes slowest).
export function batchProgram(method, name, ranges, full = false) {
  const rs = ranges.map(r => rangeOf(r, full));
  let body = `System.out.println(${name}(${rs.map((_, i) => 'p' + i).join(', ')}));`, pad = '';
  const loops = rs.map(([lo, hi, step], i) => `for (int p${i} = ${lo}; p${i} <= ${hi}; p${i} += ${step}) {`);
  const lines = [];
  loops.forEach((l, i) => lines.push('    '.repeat(i) + l));
  lines.push('    '.repeat(rs.length) + body);
  for (let i = rs.length - 1; i >= 0; i--) lines.push('    '.repeat(i) + '}');
  return method + '\n' + lines.join('\n');
}
export const withFix = (item, text) => { const lines = item.buggy.slice(); lines.splice(item.fix.from, item.fix.to - item.fix.from + 1, ...text.split('\n')); return lines.join('\n'); };
// Every version of every method that the page runs: the original, each repair choice.
export function variants(item) {
  return [{ label: 'buggy', method: item.buggy.join('\n') }, ...item.fixes.map((f, i) => ({ label: 'fix ' + i, method: withFix(item, f) }))];
}
