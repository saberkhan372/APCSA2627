// Builds a "probe" version of a program for the branch map checks: every if condition becomes
// t("L<k>", condition), where t prints its label and returns the condition's value. Running the
// probe in real Java shows exactly which conditions get evaluated, and how often, so the branch
// map's "checked" and "never checked" claims rest on Java's own behavior.
export const PROBE_METHOD = 'static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}';
export function probeOf(MJ, api, code) {
  const run = MJ.run(code);
  if (run.compileError || run.unsupported) return null;
  const conds = api.branchEntries(run.prog).filter(e => e.kind !== 'else').map(e => e.node.cond);
  let out = code;
  conds.map((c, k) => ({ c, k })).sort((a, b) => b.c.pos - a.c.pos).forEach(({ c, k }) => { out = out.slice(0, c.pos) + `t("L${k}", ${out.slice(c.pos, c.end)})` + out.slice(c.end); });
  return PROBE_METHOD + '\n' + out;
}
// Every program the branch map items and presets rely on, for the case table.
export function branchPrograms(api) {
  const items = [...api.PREDICT, ...api.TRANSFER].filter(it => it.ask === 'nchecked' || it.ask === 'status').map(it => it.code);
  const presets = api.PROG_PRESETS.map(p => p.code);
  return [...new Set([...items, ...presets])];
}
