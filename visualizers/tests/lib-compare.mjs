// Shared helpers for the Loop Tracer's "Compare two loops" checks: the programs each preset runs, and a
// "probe" version of each that counts how many times the loop body runs, so the tool's looping counts can
// be checked against real Java.
export const withN = (setup, v) => v === null ? setup : setup.replace(/\bint\s+n\s*=\s*-?\d+\s*;/, `int n = ${v};`);
export function presetPrograms(api, p) {
  const vals = /\bint\s+n\s*=\s*-?\d+\s*;/.test(p.setup) ? api.parseValues(p.values).values : [null];
  return vals.flatMap(v => [p.a, p.b].map(code => ({ n: v, code, src: `${withN(p.setup, v)}\n${code}` })));
}
// The program with a counter: int visits = 0; before it, visits++; first in the loop body, and the count
// printed at the end. Works for a loop with a { } body.
export function probeOf(MJ, src) {
  let prog; try { prog = MJ.parse(src); } catch (e) { return null; }
  let body = null;
  const walk = n => { if (!n || typeof n !== 'object' || body) return; if (['while', 'for'].includes(n.k) && n.body.k === 'block') { body = n.body; return; } for (const k of ['then', 'els', 'body']) walk(n[k]); if (n.k === 'block') n.body.forEach(walk); };
  prog.main.forEach(walk);
  if (!body) return null;
  return 'int visits = 0;\n' + src.slice(0, body.pos + 1) + ' visits++;' + src.slice(body.pos + 1) + '\nSystem.out.println("visits=" + visits);';
}
