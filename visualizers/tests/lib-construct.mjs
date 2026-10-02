// Shared helpers for the Loop Construction Workbench's checks: every build of an item, the programs real Java
// verifies, and the "probe" that prints the watched variable after each pass through the loop body.
export function allBuilds(item) {
  return item.blanks.reduce((acc, b) => acc.flatMap(a => b.options.map((_, i) => [...a, i])), [[]]);
}
// The program with a line added at the end of the loop body that prints the watched variable.
export function probeSource(item, src) {
  const lines = src.split('\n');
  const close = lines.lastIndexOf('}');
  if (close < 0) throw new Error(item.id + ': no loop-closing brace');
  lines.splice(close, 0, `    System.out.println(${item.watch.name});`);
  return lines.join('\n');
}
// Every program the Java check runs for an item: each build that passes the tests (so "also works" is
// checked), each single change to the standard build that does not, and the probes for the standard build.
export function javaPrograms(api, item) {
  const out = new Map();
  const add = (build, probe) => item.tests.forEach(t => { let src = api.assemble(item, build, t); if (probe) src = probeSource(item, src); out.set(src, true); });
  const accepted = allBuilds(item).filter(b => api.judge(item, b).ok);
  accepted.forEach(b => add(b, false));
  item.blanks.forEach((bl, k) => bl.options.forEach((_, o) => { if (o !== item.ref[k]) add(item.ref.map((x, j) => j === k ? o : x), false); }));
  add(item.ref, true);
  return { programs: [...out.keys()], accepted };
}
