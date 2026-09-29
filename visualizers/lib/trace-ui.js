// Shared pieces for the trace visualizers: code panel, stepping controls, variable table, call frames
// with arrows to objects, console, tabs, and Predict/Transfer question sets. Styles use each page's
// color tokens (--ink, --line, --accent and so on).
const TUI = (function () {
  const CSS = `
.tui-code { list-style: none; margin: 0; padding: 10px 0; background: var(--soft); border-radius: 8px; font: 14px/1.7 var(--mono); overflow-x: auto; counter-reset: ln; }
.tui-code li { padding: 0 12px 0 8px; white-space: pre; border-left: 4px solid transparent; }
.tui-code li::before { counter-increment: ln; content: counter(ln); display: inline-block; width: 2em; color: var(--faint); font-weight: 400; }
.tui-code li.done { color: var(--muted); }
.tui-code li.on { background: var(--accent-soft); border-left-color: var(--accent); font-weight: 700; color: var(--ink); }
.tui-code li.err { background: var(--diff-bg); border-left-color: var(--diff-line); color: var(--diff-ink); font-weight: 700; }
.tui-code li.called { background: var(--extra-bg); border-left-color: var(--extra-line); }
.tui-note { border: 1px solid var(--line); border-radius: 8px; padding: 10px 12px; margin-top: 10px; }
.tui-note.err { background: var(--diff-bg); border-color: var(--diff-line); color: var(--diff-ink); }
.tui-note .phase { font: 600 12px var(--sans); text-transform: uppercase; letter-spacing: .06em; color: var(--accent); }
.tui-note .op { font: 700 15px var(--mono); margin: 2px 0 4px; }
.tui-note p { margin: 0; }
.tui-console { background: #10181A; color: #E8EEEC; border-radius: 8px; padding: 8px 12px; font: 15px/1.5 var(--mono); min-height: 2.4em; white-space: pre-wrap; overflow-x: auto; }
.tui-vars { width: 100%; border-collapse: collapse; font-size: 14px; }
.tui-vars th { text-align: left; font: 600 12px var(--sans); color: var(--muted); border-bottom: 1px solid var(--line); padding: 4px 6px; }
.tui-vars td { padding: 4px 6px; border-bottom: 1px solid var(--line); font-family: var(--mono); white-space: pre; }
.tui-vars td.t { color: var(--muted); font-size: 12px; }
.tui-vars tr.changed td { background: var(--same-bg); color: var(--same-ink); font-weight: 700; }
.tui-stack { position: relative; }
.tui-mem { position: relative; display: grid; grid-template-columns: minmax(0, 1fr) minmax(0, 1fr); gap: 40px; }
.tui-frame { position: relative; z-index: 1; border: 2px solid var(--line); border-radius: 8px; background: var(--panel); padding: 6px 10px; margin-bottom: 10px; }
.tui-frame.top { border-color: var(--accent); box-shadow: 0 0 0 3px var(--accent-soft); }
.tui-frame.old { opacity: .75; }
.tui-frame.ghost { border-style: dashed; opacity: .6; background: transparent; }
.tui-frame .ptag { font: 600 10px var(--sans); text-transform: uppercase; letter-spacing: .04em; color: var(--accent); border: 1px solid var(--accent); border-radius: 3px; padding: 0 3px; margin-right: 5px; vertical-align: 1px; }
.tui-frame .ghostnote { font: 600 12px var(--sans); color: var(--muted); }
@media (prefers-reduced-motion: no-preference) { .tui-frame.enter { animation: tui-in .35s ease-out; } @keyframes tui-in { from { transform: translateY(-8px); opacity: 0; } } }
.tui-frame .fhead { font: 600 13px var(--mono); color: var(--muted); margin-bottom: 4px; display: flex; flex-wrap: wrap; justify-content: space-between; gap: 0 6px; }
.tui-frame .fvar { display: flex; flex-wrap: wrap; justify-content: space-between; gap: 0 8px; font: 14px var(--mono); padding: 1px 0; }
.tui-frame .fvar > span:last-child { margin-left: auto; white-space: nowrap; }
.tui-frame .fvar.changed { background: var(--same-bg); color: var(--same-ink); font-weight: 700; border-radius: 3px; }
.tui-frame .fvar .ty { color: var(--muted); font-size: 11px; margin-right: 4px; }
.tui-anchor { width: 11px; height: 11px; border-radius: 50%; background: var(--accent); display: inline-block; vertical-align: middle; }
.tui-obj { position: relative; z-index: 1; border: 2px solid var(--line); border-radius: 8px; background: var(--panel); padding: 6px 10px; margin-bottom: 10px; }
.tui-obj .ohead { font: 600 12px var(--sans); color: var(--muted); }
.tui-obj.changed { border-color: var(--extra-line); background: var(--extra-bg); }
.tui-cells { display: flex; flex-wrap: wrap; gap: 3px; margin-top: 4px; }
.tui-cell { min-width: 38px; border: 1.5px solid var(--line); border-radius: 5px; text-align: center; padding: 2px 4px; background: var(--panel); }
.tui-cell .cv { font: 700 15px var(--mono); }
.tui-cell .ci { font: 11px var(--mono); color: var(--muted); }
.tui-cell.hot { border-color: var(--extra-line); background: var(--extra-bg); }
.tui-cell.new { border-color: var(--same-line); background: var(--same-bg); }
.tui-cell.cur { box-shadow: 0 0 0 3px var(--accent); }
svg.tui-arrows { position: absolute; inset: 0; width: 100%; height: 100%; pointer-events: none; overflow: visible; z-index: 2; }
svg.tui-arrows path.link { fill: none; stroke: var(--muted); stroke-width: 2; }
svg.tui-arrows path.head { fill: var(--muted); }
.tui-choices { border: 0; margin: 0 0 10px; padding: 0; display: grid; gap: 6px; }
.tui-choice { display: flex; gap: 8px; align-items: baseline; padding: 6px 8px; border: 1px solid var(--line); border-radius: 4px; cursor: pointer; }
.tui-choice code { font-size: 14px; white-space: pre-wrap; }
.tui-cmp { display: grid; grid-template-columns: repeat(auto-fit, minmax(12rem, 1fr)); gap: 10px; margin-top: 6px; }
.tui-cmp pre { margin: 2px 0 0; background: var(--panel); border: 1px solid var(--line); padding: 6px 8px; font: 14px/1.4 var(--mono); white-space: pre-wrap; border-radius: 4px; color: var(--ink); }
.tui-err { border: 1px solid var(--diff-line); background: var(--diff-bg); color: var(--diff-ink); border-radius: 8px; padding: 12px 14px; margin-top: 12px; }
.tui-codebox { font: 600 14px/1.6 var(--mono); background: var(--soft); border-radius: 8px; padding: 10px 14px; white-space: pre; overflow-x: auto; margin: 10px 0 14px; }
textarea.tui-codein { font: 14px/1.5 var(--mono); min-height: 10em; }
textarea.tui-outin { font: 15px/1.5 var(--mono); min-height: 3.5em; }
@media (max-width: 560px) { .tui-mem { gap: 26px; } }
`;
  function injectCSS() { if (document.getElementById('tui-css')) return; const s = document.createElement('style'); s.id = 'tui-css'; s.textContent = CSS; document.head.append(s); }
  const $ = id => document.getElementById(id);
  function el(tag, cls, text) { const e = document.createElement(tag); if (cls) e.className = cls; if (text != null) e.textContent = text; return e; }
  const visible = s => s.replace(/ /g, '·').replace(/\t/g, '⇥').replace(/\n/g, '↵\n');

  function tabs(names, onSwitch) {
    const select = (name, focus) => {
      names.forEach(n => { const on = n === name, t = $('tab-' + n); t.setAttribute('aria-selected', on); t.tabIndex = on ? 0 : -1; $('mode-' + n).classList.toggle('hidden', !on); if (on && focus) t.focus(); });
      if (onSwitch) onSwitch(name);
    };
    names.forEach((n, i) => {
      const t = $('tab-' + n);
      t.addEventListener('click', () => select(n));
      t.addEventListener('keydown', e => { if (e.key === 'ArrowRight' || e.key === 'ArrowLeft') { e.preventDefault(); select(names[(i + (e.key === 'ArrowRight' ? 1 : names.length - 1)) % names.length], true); } });
    });
    return select;
  }

  // Code panel: numbered lines with the current line highlighted.
  function renderCode(ol, src, current, doneLines, cls = 'on', extra = {}) {
    ol.textContent = '';
    src.split('\n').forEach((t, k) => {
      const n = k + 1, li = el('li', null, t || ' ');
      li.className = n === current ? cls : extra[n] || (doneLines && doneLines.has(n) ? 'done' : '');
      ol.append(li);
    });
    const on = ol.querySelector('li.' + cls);
    if (on && on.scrollIntoViewIfNeeded) on.scrollIntoViewIfNeeded(false);
  }

  // Stepping controls with keyboard support; calls onChange(i) with 0 = before the first step.
  function stepper(host, onChange, labels = {}) {
    host.classList.add('controls');
    host.innerHTML = `<button class="btn" type="button" data-a="reset">⟲ Reset</button><button class="btn" type="button" data-a="back">← Back</button><button class="btn primary" type="button" data-a="next">${labels.next || 'Next →'}</button><button class="btn" type="button" data-a="end">${labels.end || 'Run to end'}</button>`;
    const st = { i: 0, n: 0 };
    const go = i => { st.i = Math.max(0, Math.min(st.n, i)); sync(); onChange(st.i); };
    const sync = () => {
      host.querySelector('[data-a="back"]').disabled = host.querySelector('[data-a="reset"]').disabled = st.i === 0;
      host.querySelector('[data-a="next"]').disabled = host.querySelector('[data-a="end"]').disabled = st.i === st.n;
    };
    host.querySelectorAll('[data-a]').forEach(b => b.addEventListener('click', () => { const a = b.dataset.a; go(a === 'next' ? st.i + 1 : a === 'back' ? st.i - 1 : a === 'reset' ? 0 : st.n); }));
    return {
      set(n, i = 0) { st.n = n; go(i); },
      go, get i() { return st.i; },
      keys(target) {
        target.tabIndex = 0;
        target.addEventListener('keydown', e => {
          if (e.target.closest('input, textarea, select')) return;
          const a = { ArrowRight: st.i + 1, ArrowLeft: st.i - 1, Home: 0, End: st.n }[e.key];
          if (a !== undefined) { e.preventDefault(); go(a); }
        });
      },
    };
  }

  // How a variable's value reads in a table or frame.
  function valueText(v, type, heap) {
    if (v === null) return 'null';
    if (v !== undefined && typeof v === 'object' && 'ref' in v) {
      const o = heap && heap[v.ref];
      if (!o) return '→ object';
      if (o.kind === 'array') return `→ array #${v.ref}`;
      if (o.kind === 'list') return `→ list #${v.ref}`;
      if (o.kind === 'player') return `→ Player #${v.ref}`;
    }
    if (type === 'double' || type === 'Double') return javaDouble(v);
    if (type === 'String') return JSON.stringify(v);
    return String(v);
  }
  function renderVars(table, frame, heap, changed = []) {
    table.textContent = '';
    const head = el('tr'); ['Variable', 'Type', 'Value'].forEach(h => head.append(el('th', null, h)));
    const thead = el('thead'); thead.append(head); table.append(thead);
    const tb = el('tbody');
    (frame ? frame.vars : []).forEach(v => {
      const tr = el('tr', changed.includes(v.name) ? 'changed' : '');
      tr.append(el('td', null, v.name), el('td', 't', v.type), el('td', null, valueText(v.v, v.type, heap)));
      tb.append(tr);
    });
    if (!frame || !frame.vars.length) { const tr = el('tr'); const td = el('td', 't', 'No variables yet.'); td.colSpan = 3; tr.append(td); tb.append(tr); }
    table.append(tb);
  }

  // Call frames (top of the stack first) and the objects they refer to, with arrows.
  function renderMemory(host, step, opts = {}) {
    host.textContent = '';
    host.classList.add('tui-stack');
    const mem = el('div', 'tui-mem'), left = el('div'), right = el('div');
    left.append(el('div', 'colhead', opts.framesLabel || 'Call stack (newest on top)'));
    right.append(el('div', 'colhead', 'Objects'));
    mem.append(left, right); host.append(mem);
    const svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg'); svg.setAttribute('class', 'tui-arrows'); svg.setAttribute('aria-hidden', 'true');
    const mid = 'tuih' + Math.random().toString(36).slice(2, 7);
    svg.innerHTML = `<defs><marker id="${mid}" viewBox="0 0 10 10" refX="9" refY="5" markerWidth="7" markerHeight="7" orient="auto-start-reverse"><path class="head" d="M 0 0 L 10 5 L 0 10 z"></path></marker></defs>`;
    host.append(svg);
    if (!step) { left.append(el('p', 'small', 'Nothing has run yet.')); return; }
    const frames = step.frames.slice().reverse();
    const changed = step.changed || [];
    const head = f => f.name === 'main' ? 'main' : `${f.name}(${(f.params || []).join(', ') || ''})`;
    // A frame that a return just removed: drawn dashed above the stack for this one step.
    if (opts.ghost) {
      const g = el('div', 'tui-frame ghost'), h = el('div', 'fhead');
      h.append(el('span', null, head(opts.ghost.frame)), el('span', 'ghostnote', opts.ghost.label));
      g.append(h); left.append(g);
    }
    // A very deep stack shows its newest frames, a count of the hidden ones, and the oldest two.
    const hidden = frames.length > 12 ? frames.length - 8 : 0;
    frames.forEach((f, k) => {
      if (hidden && k >= 6 && k < 6 + hidden) { if (k === 6) left.append(el('div', 'tui-frame ghost', `… ${hidden} more frames …`)); return; }
      const box = el('div', 'tui-frame' + (k === 0 ? ' top' : ' old') + (k === 0 && opts.entering ? ' enter' : ''));
      const h = el('div', 'fhead'); h.append(el('span', null, head(f)), el('span', null, k === 0 ? 'running' : 'waiting'));
      box.append(h);
      if (!f.vars.length) box.append(el('div', 'small', 'no variables'));
      f.vars.forEach(v => {
        const row = el('div', 'fvar' + (k === 0 && changed.includes(v.name) ? ' changed' : ''));
        const name = el('span');
        if ((f.params || []).includes(v.name)) { const t = el('span', 'ptag', 'param'); t.title = 'A parameter: it got a copy of the argument when the method was called.'; name.append(t); }
        name.append(el('span', 'ty', v.type), v.name);
        const val = el('span');
        if (v.v && typeof v.v === 'object' && 'ref' in v.v) { const full = 'refers to ' + valueText(v.v, v.type, step.heap).replace('→ ', ''); val.title = full; val.setAttribute('aria-label', full); val.append(`#${v.v.ref} `); const an = el('span', 'tui-anchor'); an.dataset.ref = v.v.ref; val.append(an); }
        else val.textContent = valueText(v.v, v.type, step.heap);
        row.append(name, val); box.append(row);
      });
      left.append(box);
    });
    const objs = Object.values(step.heap);
    if (!objs.length) right.append(el('p', 'small', 'None.'));
    objs.forEach(o => {
      const box = el('div', 'tui-obj' + (step.list && step.list.hid === o.hid ? ' changed' : ''));
      box.dataset.hid = o.hid;
      if (o.kind === 'player') { box.append(el('div', 'ohead', `Player #${o.hid}`)); box.append(el('div', 'small', `name "${o.name}", score ${o.score}`)); }
      else {
        box.append(el('div', 'ohead', `${o.kind === 'array' ? 'array' : 'ArrayList'} #${o.hid} · ${o.kind === 'array' ? 'length' : 'size()'} ${o.values.length}`));
        const cells = el('div', 'tui-cells');
        o.values.forEach((v, i) => {
          const c = el('div', 'tui-cell' + (step.arrayIndex === i && changed.length ? ' hot' : '') + (step.list && step.list.hid === o.hid && step.list.index === i ? ' new' : '') + (opts.cursor && opts.cursor(o, i) ? ' cur' : ''));
          c.append(el('div', 'cv', valueText(v, o.elem, step.heap)), el('div', 'ci', String(i)));
          cells.append(c);
        });
        if (!o.values.length) cells.append(el('span', 'small', 'empty'));
        box.append(cells);
      }
      right.append(box);
    });
    requestAnimationFrame(() => drawArrows(host, svg, mid));
  }
  function drawArrows(host, svg, mid) {
    [...svg.querySelectorAll('path.link')].forEach(p => p.remove());
    const box = host.getBoundingClientRect();
    host.querySelectorAll('.tui-anchor[data-ref]').forEach(a => {
      const t = host.querySelector(`.tui-obj[data-hid="${a.dataset.ref}"]`);
      if (!t) return;
      const ra = a.getBoundingClientRect(), rt = t.getBoundingClientRect();
      const x1 = ra.left + ra.width / 2 - box.left, y1 = ra.top + ra.height / 2 - box.top;
      const x2 = rt.left - box.left - 2, y2 = Math.min(Math.max(y1, rt.top - box.top + 12), rt.bottom - box.top - 12);
      const dx = Math.max(20, (x2 - x1) / 2);
      const p = document.createElementNS('http://www.w3.org/2000/svg', 'path');
      p.setAttribute('d', `M ${x1} ${y1} C ${x1 + dx} ${y1}, ${x2 - dx} ${y2}, ${x2} ${y2}`);
      p.setAttribute('class', 'link'); p.setAttribute('marker-end', `url(#${mid})`);
      svg.append(p);
    });
  }

  // Predict / Transfer: items have { code, ask, … }; expected(it) gives the answer, and kinds are
  // 'output' (exact text), 'int', 'text', 'mc' (any item with choices: [{ text }]; expected is the index), 'line'.
  function questions(prefix, items, opts) {
    const state = items.map(() => ({ val: '', why: '', done: false }));
    let idx = 0;
    const form = $(prefix + '-form');
    const kind = it => it.ask === 'output' ? 'output' : it.ask === 'mc' || it.choices ? 'mc' : it.kind || 'int';
    function build(it) {
      form.innerHTML = '';
      const k = kind(it);
      if (k === 'mc') {
        const fs = el('fieldset', 'tui-choices'); fs.append(el('legend', 'small', 'Choose one'));
        it.choices.forEach((c, i) => { const l = el('label', 'tui-choice'); const r = el('input'); r.type = 'radio'; r.name = prefix + '-mc'; r.value = i; l.append(r, c.code ? el('code', null, c.text) : el('span', null, c.text)); fs.append(l); });
        form.append(fs);
      } else {
        const l = el('label', 'field'); l.append(k === 'output' ? 'Output ' : 'Answer ', el('span', 'hint', k === 'output' ? '(type it exactly; press Enter for a new line)' : k === 'text' ? '(exactly, without quotes)' : ''));
        const inp = k === 'output' ? el('textarea', 'tui-outin') : el('input');
        if (k !== 'output') { inp.type = 'text'; inp.className = k === 'text' ? 'strin' : 'num'; if (k !== 'text') inp.inputMode = 'numeric'; }
        inp.id = prefix + '-val'; inp.spellcheck = false; inp.autocomplete = 'off';
        l.append(inp); form.append(l);
      }
      const w = el('label', 'field'); w.append(opts.reasonPrompt + ' '); const why = el('textarea'); why.id = prefix + '-why'; why.rows = 2; w.append(why);
      const row = el('div', 'row'); const b = el('button', 'btn primary', opts.submitLabel); b.type = 'submit'; const err = el('span', 'formerr'); err.id = prefix + '-err'; err.setAttribute('role', 'alert'); row.append(b, err);
      form.append(w, row);
    }
    const readVal = it => kind(it) === 'mc' ? ((form.querySelector('input:checked') || {}).value || '') : $(prefix + '-val').value;
    function show() {
      const it = items[idx], st = state[idx];
      $(prefix + '-count').textContent = `Question ${idx + 1} of ${items.length}`;
      $(prefix + '-prev').disabled = idx === 0; $(prefix + '-next').disabled = idx === items.length - 1;
      $(prefix + '-ask').textContent = opts.askText(it);
      $(prefix + '-code').textContent = it.code;
      build(it);
      if (kind(it) === 'mc') { const r = form.querySelector(`input[value="${st.val}"]`); if (r) r.checked = true; } else $(prefix + '-val').value = st.val;
      $(prefix + '-why').value = st.why;
      form.querySelectorAll('input, textarea, button').forEach(x => { x.disabled = st.done; });
      $(prefix + '-after').classList.toggle('hidden', !st.done);
      if (st.done) reveal(it, st);
    }
    function reveal(it, st) {
      const want = opts.expected(it), fb = $(prefix + '-feedback'), k = kind(it);
      let ok;
      if (k === 'output') { const norm = s => s.replace(/\r\n/g, '\n').replace(/\n$/, ''); ok = norm(st.val) === norm(want); }
      else if (k === 'mc') ok = +st.val === want;
      else if (k === 'text') ok = st.val === want;
      else ok = parseInt(String(st.val).replace('−', '-'), 10) === want;
      fb.className = 'feedback ' + (ok ? 'good' : 'bad'); fb.textContent = '';
      const head = ok ? 'Correct.' : k === 'mc' ? `Not quite: the answer is “${it.choices[want].text}”.` : k === 'output' ? 'Not quite. Compare (· is a space, ↵ a line break):' : `Not quite: the answer is ${want}.`;
      const p = el('p'); p.append(el('span', 'tag', head)); fb.append(p);
      if (!ok && k === 'output') {
        const cmp = el('div', 'tui-cmp');
        const y = el('div'); y.append(el('div', 'small', 'Yours'), el('pre', null, visible(st.val.replace(/\r\n/g, '\n'))));
        const j = el('div'); j.append(el('div', 'small', 'Java'), el('pre', null, visible(want)));
        cmp.append(y, j); fb.append(cmp);
      }
      fb.append(el('p', null, 'Your reasoning: “' + st.why.trim() + '”'));
      opts.onReveal(it, want);
    }
    form.addEventListener('submit', e => {
      e.preventDefault();
      const it = items[idx], st = state[idx], v = readVal(it), why = $(prefix + '-why').value, err = $(prefix + '-err'), k = kind(it);
      if (String(v).trim() === '' && k !== 'text') { err.textContent = k === 'mc' ? 'Choose an answer first.' : 'Write your answer first.'; return; }
      if ((k === 'int' || k === 'line') && !/^\s*[−-]?\d+\s*$/.test(v)) { err.textContent = 'Enter a whole number.'; return; }
      if (why.trim().length < 3) { err.textContent = 'Write a short reason before checking.'; return; }
      Object.assign(st, { val: v, why, done: true });
      show();
    });
    const save = () => { const st = state[idx]; if (!st.done) { st.val = readVal(items[idx]); st.why = $(prefix + '-why').value; } };
    $(prefix + '-prev').addEventListener('click', () => { save(); idx--; show(); });
    $(prefix + '-next').addEventListener('click', () => { save(); idx++; show(); });
    show();
  }
  function errorBox(host, r) {
    host.textContent = '';
    host.append(el('b', null, r.compileError ? `Does not compile (line ${r.line}). ` : `Not supported here (line ${r.line}): `), r.compileError || r.unsupported);
    if (r.compileError) host.append(el('p', 'small', 'Java checks the whole program before running any of it, so nothing runs.'));
  }
  return { injectCSS, el, $, tabs, renderCode, stepper, renderVars, renderMemory, valueText, questions, errorBox, visible };
})();
