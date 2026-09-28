// Structural checks for every study guide and its bank. Java behavior is checked by StudyCheck.java.
import { readFileSync, readdirSync, existsSync } from 'node:fs';
import { expr, str, cmp } from '../lib/engines.mjs';
const root = new URL('../../', import.meta.url);
const dir = new URL('content/study/', root);
let fail = 0, items = 0;
const bad = (m) => { fail++; console.log('FAIL ' + m); };
const allIds = new Set();
for (const f of readdirSync(dir).filter(f => f.endsWith('.json') && !f.endsWith('-bank.json'))) {
  const g = JSON.parse(readFileSync(new URL(f, dir), 'utf8'));
  const bank = JSON.parse(readFileSync(new URL(`${g.id}-bank.json`, dir), 'utf8'));
  const sections = Object.fromEntries(g.sections.map(s => [s.id, s]));
  const conceptual = [];
  for (const it of bank) {
    items++;
    const where = `${g.id}/${it.id}`;
    if (allIds.has(it.id)) bad(`${where}: duplicate id`);
    allIds.add(it.id);
    for (const k of ['section', 'skill', 'origin', 'format', 'prompt', 'answer', 'explain']) if (it[k] === undefined || it[k] === '') bad(`${where}: missing ${k}`);
    if (!sections[it.section]) bad(`${where}: unknown section ${it.section}`);
    else if (!sections[it.section].skills.includes(it.skill)) bad(`${where}: skill ${it.skill} is not listed in section ${it.section}`);
    if (!['sibling', 'new'].includes(it.origin)) bad(`${where}: origin must be sibling or new`);
    if (!it.java.length && !it.conceptual) bad(`${where}: no Java spec and not marked conceptual`);
    if (it.conceptual) conceptual.push(it.id);
    if (it.format === 'mc') {
      const cs = it.answer.choices;
      if (cs.length < 3 || cs.length > 5) bad(`${where}: ${cs.length} choices`);
      if (new Set(cs.map(c => c.text.trim())).size !== cs.length) bad(`${where}: choices are not distinct`);
      if (cs.filter(c => c.correct).length !== 1) bad(`${where}: must have exactly one correct choice`);
      if (cs.some(c => !c.why)) bad(`${where}: every choice needs a reason`);
    }
    if (it.format === 'tf' && typeof it.answer.value !== 'boolean') bad(`${where}: T/F answer must be boolean`);
    if (it.format === 'value') {
      const spec = it.java.find(s => s.k === 'expr');
      const r = expr.runJava(spec.d, spec.s);
      if (r.label !== it.answer.label || spec.label !== it.answer.label) bad(`${where}: engine gives ${r.label}, bank says ${it.answer.label}`);
    }
    if (it.format === 'call') {
      const spec = it.java.find(s => s.k === 'call');
      const r = str.callString(spec.s, spec.m, spec.args);
      const label = r.kind === 'throws' ? 'throws' : `${r.kind}:${r.value}`;
      if (label !== it.answer.label) bad(`${where}: engine gives ${label}, bank says ${it.answer.label}`);
    }
    const c = it.java.find(s => s.k === 'cmp');
    if (it.format === 'int' && c && cmp.traceCompareTo(c.a, c.b).value !== it.answer.value) bad(`${where}: compareTo engine disagrees`);
    if (it.format === 'output' && it.answer.text !== it.java[0].out) bad(`${where}: shown answer differs from the Java-checked output`);
  }
  // Every mock mode must be able to draw perSection items from every section, and the
  // assessment-format mode must use multiple choice only, like the real assessment.
  for (const mode of g.mock.modes) {
    for (const s of g.sections) {
      const pool = bank.filter(i => i.section === s.id && mode.formats.includes(i.format));
      if (pool.length < g.mock.perSection * 2) bad(`${g.id}: mock mode ${mode.id} has only ${pool.length} items in section ${s.id} (need at least ${g.mock.perSection * 2} for variety)`);
    }
  }
  const assessmentMode = g.mock.modes.find(m => m.id === 'assessment');
  if (!assessmentMode || assessmentMode.formats.join() !== 'mc') bad(`${g.id}: the assessment-format mock must be multiple choice only`);
  for (const k of Object.keys(g.skills)) {
    const n = bank.filter(i => i.skill === k).length;
    if (n < 2) bad(`${g.id}: skill ${k} has ${n} practice item(s)`);
  }
  for (const t of g.codeTasks) {
    const d = new URL(`study/code/${t.id}/`, root);
    const files = existsSync(d) ? readdirSync(d) : [];
    if (!files.some(f => f.endsWith('Check.java')) || !files.includes('README.md') || !existsSync(new URL('solution/', d))) bad(`${g.id}: code task ${t.id} needs a starter, a Check class, README.md and solution/`);
  }
  console.log(`${g.id}: ${bank.length} items; conceptual (teacher review, no Java spec): ${conceptual.join(', ') || 'none'}`);
}
console.log(fail ? `${fail} problem(s)` : `PASS: ${items} study items are well formed and match the engines`);
process.exit(fail ? 1 : 0);
