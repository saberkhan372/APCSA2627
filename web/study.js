// Study guide pages: practice with immediate feedback, a mock that reveals answers only at the end,
// self-ratings kept separate from results, and code-task notes. Everything is saved in this
// browser only (localStorage); nothing is sent anywhere.
(function () {
  const dataEl = document.getElementById('study-data');
  if (!dataEl) return;
  const DATA = JSON.parse(dataEl.textContent);
  const G = DATA.guide, BANK = DATA.bank;
  const BY_ID = Object.fromEntries(BANK.map(i => [i.id, i]));
  const SECTION = Object.fromEntries(G.sections.map(s => [s.id, s]));
  const KEY = 'apcsa-study:' + G.id;
  const $ = (sel, root = document) => root.querySelector(sel);
  const $$ = (sel, root = document) => [...root.querySelectorAll(sel)];
  function el(tag, cls, text) { const e = document.createElement(tag); if (cls) e.className = cls; if (text != null) e.textContent = text; return e; }

  /* ---------- Storage (this browser only) ---------- */
  function load() { try { return JSON.parse(localStorage.getItem(KEY)) || {}; } catch (e) { return {}; } }
  const store = Object.assign({ ratings: {}, practice: {}, mocks: [], code: {} }, load());
  function save() { try { localStorage.setItem(KEY, JSON.stringify(store)); } catch (e) { /* private window or storage blocked */ } }

  /* ---------- Tabs ---------- */
  const tabs = $$('[role="tab"]');
  function selectTab(name, focus) {
    tabs.forEach(t => {
      const on = t.dataset.tab === name;
      t.setAttribute('aria-selected', on); t.tabIndex = on ? 0 : -1;
      $('#panel-' + t.dataset.tab).hidden = !on;
      if (on && focus) t.focus();
    });
    if (name === 'guide') renderProgress();
  }
  tabs.forEach((t, i) => {
    t.addEventListener('click', () => selectTab(t.dataset.tab));
    t.addEventListener('keydown', e => {
      if (e.key !== 'ArrowRight' && e.key !== 'ArrowLeft') return;
      e.preventDefault();
      selectTab(tabs[(i + (e.key === 'ArrowRight' ? 1 : tabs.length - 1)) % tabs.length].dataset.tab, true);
    });
  });

  /* ---------- Answers ---------- */
  function shuffle(a) { a = a.slice(); for (let i = a.length - 1; i > 0; i--) { const j = Math.floor(Math.random() * (i + 1)); [a[i], a[j]] = [a[j], a[i]]; } return a; }
  function javaEsc(s) { return s.replace(/[\\"\n\t]/g, c => ({ '\\': '\\\\', '"': '\\"', '\n': '\\n', '\t': '\\t' }[c])); }
  function splitLabel(label) { const i = label.indexOf(':'); return i < 0 ? [label, ''] : [label.slice(0, i), label.slice(i + 1)]; }
  function describeLabel(label) {
    if (label === 'compile-error') return 'It does not compile.';
    if (label === 'throws') return 'It throws a StringIndexOutOfBoundsException.';
    const [k, v] = splitLabel(label);
    if (k === 'throws') return `It compiles, then throws an ${v}.`;
    if (k === 'String') return `"${javaEsc(v)}" (a String)`;
    if (k === 'char') return `'${v}' (a char)`;
    return `${v} (${k === 'int' ? 'an int' : 'a ' + k})`;
  }
  function visible(s) { return s.replace(/ /g, '·').replace(/\t/g, '→').replace(/\n/g, '↵\n'); }

  // Builds the answer controls for an item; returns { root, read() -> answer | null, error message }.
  function answerControls(item, saved) {
    const root = el('div', 'answer');
    const uid = item.id + '-' + Math.random().toString(36).slice(2, 7);
    if (item.format === 'value' || item.format === 'call') {
      const kinds = item.format === 'value'
        ? [['int', 'an int'], ['double', 'a double'], ['String', 'a String'], ['compile-error', 'does not compile'], ['throws', 'compiles, then crashes']]
        : [['int', 'an int'], ['String', 'a String'], ['char', 'a char'], ['throws', 'throws an exception']];
      const row = el('div', 'answer-row');
      const kl = el('label', 'field'); kl.append(item.format === 'value' ? 'The result is…' : 'It returns…');
      const sel = el('select'); sel.append(new Option('choose…', ''));
      kinds.forEach(([v, t]) => sel.append(new Option(t, v)));
      kl.append(sel);
      const vl = el('label', 'field'); vl.append('Value ');
      const q1 = el('span', 'q', '"'), q2 = el('span', 'q', '"');
      const inp = el('input'); inp.type = 'text'; inp.autocomplete = 'off'; inp.spellcheck = false;
      const wrap = el('span', 'quoted'); wrap.append(q1, inp, q2); vl.append(wrap);
      row.append(kl, vl); root.append(row);
      const sync = () => {
        const k = sel.value, hasVal = ['int', 'double', 'String', 'char'].includes(k);
        vl.hidden = !hasVal;
        const quote = k === 'String' ? '"' : k === 'char' ? "'" : '';
        q1.textContent = q2.textContent = quote; q1.hidden = q2.hidden = !quote;
      };
      sel.addEventListener('change', sync);
      if (saved) { sel.value = saved.kind; inp.value = saved.val || ''; }
      sync();
      return {
        root, focus: () => sel.focus(),
        read() {
          const k = sel.value;
          if (!k && inp.value === '') return { blank: true };
          if (!k) return { error: 'Choose what happens first.' };
          if (!['int', 'double', 'String', 'char'].includes(k)) return { kind: k };
          let v = inp.value;
          if (k === 'int' && !/^\s*[−-]?\d+\s*$/.test(v)) return { error: 'Enter a whole number, like -3 or 8.' };
          if (k === 'double' && !/^\s*[−-]?(\d+(\.\d*)?([eE][−-]?\d+)?|Infinity|NaN)\s*$/.test(v)) return { error: 'Enter a number, like 2.0 or 0.5.' };
          if (k === 'char' && v.replace(/^'(.)'$/, '$1').length !== 1) return { error: 'A char is exactly one character.' };
          return { kind: k, val: v };
        },
      };
    }
    if (item.format === 'int') {
      const l = el('label', 'field'); l.append('Answer ');
      const inp = el('input'); inp.type = 'text'; inp.inputMode = 'numeric'; inp.className = 'num'; inp.autocomplete = 'off';
      if (saved) inp.value = saved.val;
      l.append(inp); root.append(l);
      return { root, focus: () => inp.focus(), read: () => inp.value.trim() === '' ? { blank: true } : /^\s*[−-]?\d+\s*$/.test(inp.value) ? { kind: 'int', val: inp.value } : { error: 'Enter a whole number.' } };
    }
    if (item.format === 'output') {
      const l = el('label', 'field'); l.append('Output ', el('span', 'hint', '(type it exactly; press Enter for a new line)'));
      const ta = el('textarea', 'mono'); ta.rows = 3; ta.spellcheck = false;
      if (saved) ta.value = saved.val;
      l.append(ta); root.append(l);
      return { root, focus: () => ta.focus(), read: () => ta.value.trim() === '' ? { blank: true } : { kind: 'output', val: ta.value } };
    }
    // mc and tf: radio groups
    const fs = el('fieldset', 'choices');
    fs.append(el('legend', 'sr-only', 'Choose one'));
    const opts = item.format === 'tf'
      ? [{ key: 'true', text: 'True' }, { key: 'false', text: 'False' }]
      : (saved && saved.order ? saved.order : shuffle(item.answer.choices.map((c, i) => i))).map(i => ({ key: String(i), text: item.answer.choices[i].text, code: item.answer.choices[i].code }));
    opts.forEach(o => {
      const l = el('label', 'choice');
      const r = el('input'); r.type = 'radio'; r.name = uid; r.value = o.key;
      if (saved && saved.val === o.key) r.checked = true;
      l.append(r, o.code ? el('code', null, o.text) : el('span', null, o.text));
      fs.append(l);
    });
    root.append(fs);
    const order = item.format === 'mc' ? opts.map(o => +o.key) : null;
    return {
      root, focus: () => { const r = $('input', fs); if (r) r.focus(); },
      read: () => { const r = $('input:checked', fs); return r ? { kind: item.format, val: r.value, order } : { blank: true }; },
    };
  }

  // Returns { ok, head } for an answer.
  function grade(item, a) {
    const ans = item.answer;
    if (item.format === 'mc') {
      const c = ans.choices[+a.val];
      return { ok: c.correct, head: c.correct ? 'Correct.' : 'Not quite.' };
    }
    if (item.format === 'tf') {
      const ok = (a.val === 'true') === ans.value;
      return { ok, head: ok ? 'Correct.' : `Not quite: it is ${ans.value ? 'true' : 'false'}.` };
    }
    if (item.format === 'int') {
      const ok = parseInt(a.val.replace('−', '-'), 10) === ans.value;
      return { ok, head: ok ? 'Correct.' : `Not quite: the answer is ${ans.value}.` };
    }
    if (item.format === 'output') {
      const norm = s => s.replace(/\r\n/g, '\n').replace(/\n$/, '');
      const ok = norm(a.val) === norm(ans.text);
      return { ok, head: ok ? 'Correct, exactly.' : 'Not quite. Compare yours with Java\'s output (· is a space, ↵ a line break):' };
    }
    // value / call labels
    const label = ans.label;
    const [k, v] = splitLabel(label);
    const expectKind = label === 'compile-error' ? 'compile-error' : (k === 'throws' || label === 'throws') ? 'throws' : k;
    if (a.kind !== expectKind) return { ok: false, head: `Not quite. ${describeLabel(label)}` };
    if (expectKind === 'compile-error' || expectKind === 'throws') return { ok: true, head: `Correct. ${describeLabel(label)}` };
    let val = a.val.trim().replace(/−/g, '-');
    if (k === 'String') { val = a.val; if (/^".*"$/.test(val)) val = val.slice(1, -1); }
    if (k === 'char') val = val.replace(/^'(.)'$/, '$1');
    let ok;
    if (k === 'double') {
      const n = Number(val), want = Number(v);
      ok = n === want || (Number.isNaN(n) && Number.isNaN(want));
    } else ok = val === v;
    if (ok && k === 'double' && val !== v) return { ok, head: `Correct. Java prints it as ${v}.` };
    return { ok, head: ok ? 'Correct.' : `Right type, but the value is ${describeLabel(label)}` };
  }

  function feedbackBox(item, a, g) {
    const box = el('div', 'feedback ' + (g.ok ? 'good' : 'bad'));
    box.setAttribute('role', 'status');
    box.append(el('p', 'tag', g.head));
    if (item.format === 'output' && !g.ok) {
      const grid = el('div', 'outcompare');
      const yours = el('div'); yours.append(el('div', 'small', 'Yours'), el('pre', null, visible(a.val.replace(/\r\n/g, '\n'))));
      const java = el('div'); java.append(el('div', 'small', 'Java'), el('pre', null, visible(item.answer.text)));
      grid.append(yours, java); box.append(grid);
    }
    if (item.format === 'mc' && !g.ok) {
      box.append(el('p', null, 'Your choice: ' + item.answer.choices[+a.val].why));
      const c = item.answer.choices.find(x => x.correct);
      const right = el('p'); right.append('Correct answer: ', el(c.code ? 'code' : 'strong', null, c.text));
      box.append(right, el('p', null, item.explain));
    } else box.append(el('p', null, item.explain));
    if (item.link) {
      const p = el('p'); const l = el('a', null, 'See it step by step in the visualizer'); l.href = '../visualizers/' + item.link; p.append(l); box.append(p);
    }
    return box;
  }

  function itemView(item, saved) {
    const card = el('div', 'item');
    const meta = el('div', 'item-meta');
    meta.append(el('span', null, SECTION[item.section].title), el('span', null, item.origin === 'sibling' ? 'Quiz-style' : 'New'));
    card.append(meta, el('p', 'prompt', item.prompt));
    if (item.statement) card.append(el('p', 'statement', item.statement));
    if (item.code) card.append(el('pre', 'code', item.code));
    const ctl = answerControls(item, saved);
    card.append(ctl.root);
    return { card, ctl };
  }

  function record(item, ok) {
    const p = store.practice[item.skill] || (store.practice[item.skill] = { a: 0, c: 0 });
    p.a++; if (ok) p.c++;
    save();
  }

  /* ---------- Practice: immediate feedback ---------- */
  const practice = { section: 'all', queue: [], cur: null, done: 0, right: 0 };
  function practiceItems(sec) { return BANK.filter(i => sec === 'all' || i.section === sec); }
  function setSection(sec) {
    practice.section = sec; practice.queue = shuffle(practiceItems(sec)); practice.done = practice.right = 0;
    $$('#practice-sections button').forEach(b => b.setAttribute('aria-pressed', b.dataset.section === sec));
    nextPractice();
  }
  function nextPractice() {
    if (!practice.queue.length) { practice.queue = shuffle(practiceItems(practice.section)); practice.lap = true; }
    practice.cur = practice.queue.shift();
    renderPractice();
  }
  function renderPractice() {
    const host = $('#practice-item'); host.textContent = '';
    const item = practice.cur;
    const status = el('p', 'small');
    const total = practiceItems(practice.section).length;
    status.textContent = `This session: ${practice.right} of ${practice.done} correct · ${total} questions in this set` + (practice.lap ? ' · You have seen them all; this is a new order.' : '');
    const { card, ctl } = itemView(item);
    const btn = el('button', 'btn primary', 'Check'); btn.type = 'button';
    const err = el('span', 'formerr'); err.setAttribute('role', 'alert');
    const row = el('div', 'row'); row.append(btn, err); card.append(row);
    const fbHost = el('div'); card.append(fbHost);
    btn.addEventListener('click', () => {
      const a = ctl.read();
      if (a.blank) { err.textContent = 'Answer the question first.'; return; }
      if (a.error) { err.textContent = a.error; return; }
      err.textContent = '';
      const g = grade(item, a);
      practice.done++; if (g.ok) practice.right++;
      record(item, g.ok);
      $$('input, select, textarea', ctl.root).forEach(x => { x.disabled = true; });
      btn.remove();
      fbHost.append(feedbackBox(item, a, g));
      const next = el('button', 'btn primary', 'Next question →'); next.type = 'button';
      next.addEventListener('click', nextPractice);
      fbHost.append(next);
      next.focus();
    });
    host.append(status, card);
  }
  function buildPractice() {
    const bar = $('#practice-sections');
    [['all', 'Mixed: all sections'], ...G.sections.map(s => [s.id, s.title])].forEach(([id, t]) => {
      const b = el('button', 'chip', t); b.type = 'button'; b.dataset.section = id;
      b.addEventListener('click', () => setSection(id));
      bar.append(b);
    });
    $$('[data-practice]').forEach(b => b.addEventListener('click', () => { selectTab('practice'); setSection(b.dataset.practice); $('#practice-item').scrollIntoView({ block: 'start' }); }));
    setSection('all');
  }

  /* ---------- Mock: answers first, explanations at the end ---------- */
  const mock = { items: [], answers: [], i: 0, timer: null, deadline: null, started: 0 };
  function pickMock(mode) {
    const cfg = G.mock, picked = [];
    G.sections.forEach(s => {
      const pool = shuffle(BANK.filter(i => i.section === s.id && mode.formats.includes(i.format)));
      picked.push(...pool.slice(0, cfg.perSection));
    });
    return shuffle(picked).slice(0, cfg.count);
  }
  function startMock() {
    mock.mode = G.mock.modes.find(m => m.id === ($('input[name="mock-mode"]:checked') || {}).value) || G.mock.modes[0];
    mock.items = pickMock(mock.mode); mock.answers = mock.items.map(() => null); mock.i = 0; mock.started = Date.now(); mock.dropped = 0;
    const timed = $('#mock-timed').checked;
    mock.deadline = timed ? Date.now() + G.mock.minutes * 60000 : null;
    $('#mock-intro').hidden = true; $('#mock-run').hidden = false; $('#mock-results').hidden = true;
    if (mock.timer) clearInterval(mock.timer);
    if (timed) mock.timer = setInterval(tick, 1000);
    tick(); renderMock();
  }
  function tick() {
    const t = $('#mock-timer');
    if (!mock.deadline) { t.textContent = 'Untimed'; return; }
    const left = Math.max(0, Math.round((mock.deadline - Date.now()) / 1000));
    t.textContent = `${Math.floor(left / 60)}:${String(left % 60).padStart(2, '0')} left`;
    if (left === 0) { clearInterval(mock.timer); mock.timer = null; submitMock(true); }
  }
  let mockCtl = null;
  // Saves the current answer. A blank answer clears any earlier one. An invalid answer blocks moving on,
  // unless force is set (time ran out), in which case it is dropped and counted as unanswered.
  function keepMockAnswer(force) {
    if (!mockCtl) return true;
    const a = mockCtl.read(), msg = $('#mock-error');
    if (a.blank) { mock.answers[mock.i] = null; msg.textContent = ''; return true; }
    if (a.error) {
      if (force) { mock.answers[mock.i] = null; mock.dropped++; return true; }
      msg.textContent = a.error + ' Fix it or clear it before moving on.';
      mockCtl.focus();
      return false;
    }
    mock.answers[mock.i] = a; msg.textContent = '';
    return true;
  }
  function renderMock() {
    const host = $('#mock-item'); host.textContent = '';
    const item = mock.items[mock.i];
    host.append(el('p', 'small', `Question ${mock.i + 1} of ${mock.items.length}. Answers are checked when you submit.`));
    const { card, ctl } = itemView(item, mock.answers[mock.i]);
    mockCtl = ctl; host.append(card);
    const nav = $('#mock-nav'); nav.textContent = '';
    mock.items.forEach((_, n) => {
      const b = el('button', 'dot' + (n === mock.i ? ' on' : '') + (mock.answers[n] ? ' answered' : ''), String(n + 1));
      b.type = 'button'; b.setAttribute('aria-label', `Question ${n + 1}${mock.answers[n] ? ', answered' : ''}`);
      b.addEventListener('click', () => { if (keepMockAnswer()) { mock.i = n; renderMock(); } });
      nav.append(b);
    });
    $('#mock-prev').disabled = mock.i === 0;
    $('#mock-next').disabled = mock.i === mock.items.length - 1;
  }
  function submitMock(timeUp) {
    if (!keepMockAnswer(timeUp)) return;
    const unanswered = mock.answers.filter(a => !a).length;
    if (!timeUp && unanswered && !confirm(`${unanswered} question${unanswered > 1 ? 's are' : ' is'} unanswered. Submit anyway?`)) return;
    if (mock.timer) { clearInterval(mock.timer); mock.timer = null; }
    const results = mock.items.map((item, n) => { const a = mock.answers[n]; return { item, a, g: a ? grade(item, a) : { ok: false, head: 'Not answered.' } }; });
    const bySkill = {};
    results.forEach(({ item, g }) => { const s = bySkill[item.skill] || (bySkill[item.skill] = { c: 0, t: 0 }); s.t++; if (g.ok) s.c++; });
    const score = results.filter(r => r.g.ok).length;
    store.mocks.push({ date: new Date().toISOString(), mode: mock.mode.id, score, total: results.length, timed: !!mock.deadline, seconds: Math.round((Date.now() - mock.started) / 1000), bySkill, timeUp: !!timeUp });
    save();
    showMockResults(results, score, bySkill, timeUp);
  }
  function showMockResults(results, score, bySkill, timeUp) {
    $('#mock-run').hidden = true;
    const host = $('#mock-results'); host.hidden = false; host.textContent = '';
    host.append(el('h3', null, `Score: ${score} of ${results.length}`));
    host.append(el('p', 'small', mock.mode.label));
    if (timeUp) host.append(el('p', 'small', 'Time ran out, so your answers were submitted automatically.' + (mock.dropped ? ` ${mock.dropped} answer${mock.dropped > 1 ? 's were' : ' was'} not valid and counted as unanswered.` : '')));
    const weak = Object.entries(bySkill).filter(([, s]) => s.c < s.t);
    const tbl = el('table', 'skilltable');
    tbl.innerHTML = '<thead><tr><th>Skill</th><th>Correct</th></tr></thead>';
    const tb = el('tbody');
    Object.entries(bySkill).forEach(([k, s]) => { const tr = el('tr', s.c < s.t ? 'weak' : ''); tr.append(el('td', null, G.skills[k]), el('td', null, `${s.c} of ${s.t}`)); tb.append(tr); });
    tbl.append(tb); host.append(tbl);
    if (weak.length) {
      host.append(el('p', null, 'Practice next:'));
      const bar = el('div', 'presets');
      [...new Set(weak.map(([k]) => G.sections.find(s => s.skills.includes(k)).id))].forEach(sec => {
        const b = el('button', 'chip', SECTION[sec].title); b.type = 'button';
        b.addEventListener('click', () => { selectTab('practice'); setSection(sec); });
        bar.append(b);
      });
      host.append(bar);
    } else host.append(el('p', null, 'No weak skills in this mock. Try another mock, or the code tasks.'));
    host.append(el('h3', null, 'Review'));
    results.forEach(({ item, a, g }, n) => {
      const { card } = itemView(item, a);
      $$('input, select, textarea', card).forEach(x => { x.disabled = true; });
      card.prepend(el('p', 'small', `Question ${n + 1}`));
      card.append(a ? feedbackBox(item, a, g) : (() => { const b = el('div', 'feedback bad'); b.append(el('p', 'tag', 'Not answered.'), el('p', null, item.explain)); return b; })());
      host.append(card);
    });
    const again = el('button', 'btn primary', 'Start another mock'); again.type = 'button';
    again.addEventListener('click', () => { $('#mock-results').hidden = true; $('#mock-intro').hidden = false; renderMockHistory(); });
    host.append(again);
    host.scrollIntoView({ block: 'start' });
    renderMockHistory();
  }
  function renderMockHistory() {
    const h = $('#mock-history'); h.textContent = '';
    if (!store.mocks.length) return;
    h.append(el('h3', null, 'Your earlier mocks (this browser)'));
    const ul = el('ul');
    store.mocks.slice(-8).reverse().forEach(m => {
      const d = new Date(m.date);
      const mode = m.mode === 'mixed' ? 'mixed review' : 'assessment format';
      ul.append(el('li', null, `${d.toLocaleDateString()} ${d.toLocaleTimeString([], { hour: 'numeric', minute: '2-digit' })}: ${m.score} of ${m.total}, ${mode}${m.timed ? `, timed (${Math.round(m.seconds / 60)} min)` : ''}`));
    });
    h.append(ul);
  }
  function buildMock() {
    $('#mock-start').addEventListener('click', startMock);
    $('#mock-prev').addEventListener('click', () => { if (keepMockAnswer()) { mock.i--; renderMock(); } });
    $('#mock-next').addEventListener('click', () => { if (keepMockAnswer()) { mock.i++; renderMock(); } });
    $('#mock-submit').addEventListener('click', () => submitMock(false));
    renderMockHistory();
  }

  /* ---------- Guide: self-ratings (separate from results) ---------- */
  const LEVELS = ['Not yet', 'Getting there', 'Confident'];
  function buildRatings() {
    $$('.rating').forEach(r => {
      const skill = r.dataset.skill;
      r.textContent = '';
      LEVELS.forEach((t, lvl) => {
        const b = el('button', 'rate', t); b.type = 'button';
        b.setAttribute('aria-pressed', store.ratings[skill] === lvl);
        b.addEventListener('click', () => { store.ratings[skill] = lvl; save(); buildRatings(); renderProgress(); });
        r.append(b);
      });
    });
  }
  function renderProgress() {
    const host = $('#progress'); if (!host) return;
    host.textContent = '';
    const tbl = el('table', 'skilltable');
    tbl.innerHTML = '<thead><tr><th>Skill</th><th>You rated</th><th>Practice (this browser)</th><th>Last mock</th></tr></thead>';
    const tb = el('tbody');
    const last = store.mocks[store.mocks.length - 1];
    Object.entries(G.skills).forEach(([k, text]) => {
      const p = store.practice[k], m = last && last.bySkill[k];
      const tr = el('tr');
      tr.append(el('td', null, text), el('td', null, store.ratings[k] != null ? LEVELS[store.ratings[k]] : '—'),
        el('td', null, p ? `${p.c} of ${p.a} correct` : '—'), el('td', null, m ? `${m.c} of ${m.t}` : '—'));
      tb.append(tr);
    });
    tbl.append(tb); host.append(tbl);
    const reset = el('button', 'btn', 'Clear my saved progress'); reset.type = 'button';
    reset.addEventListener('click', () => {
      if (!confirm('Clear your ratings, practice counts, mock history and code notes for this guide in this browser?')) return;
      store.ratings = {}; store.practice = {}; store.mocks = []; store.code = {}; save();
      buildRatings(); renderProgress(); renderMockHistory(); buildCode();
    });
    host.append(reset);
  }

  /* ---------- Code tasks ---------- */
  function buildCode() {
    $$('.codetask').forEach(t => {
      const id = t.dataset.task, ta = $('textarea', t), btn = $('.showmodel', t), model = $('.model', t);
      ta.value = store.code[id] || '';
      const sync = () => { btn.disabled = ta.value.replace(/\s/g, '').length < 15; };
      ta.oninput = () => { store.code[id] = ta.value; save(); sync(); };
      btn.onclick = () => { model.hidden = false; btn.hidden = true; };
      model.hidden = true; btn.hidden = false;
      sync();
    });
  }

  /* ---------- Print or save as PDF ---------- */
  // Seeded shuffle so printed multiple-choice letters are the same every time you print.
  function seeded(id) {
    let h = 2166136261;
    for (const ch of id) h = Math.imul(h ^ ch.charCodeAt(0), 16777619);
    return () => { h = Math.imul(h ^ (h >>> 15), 2246822507); h = Math.imul(h ^ (h >>> 13), 3266489909); return ((h ^= h >>> 16) >>> 0) / 4294967296; };
  }
  function printOrder(item) {
    const rnd = seeded(item.id), idx = item.answer.choices.map((_, i) => i);
    for (let i = idx.length - 1; i > 0; i--) { const j = Math.floor(rnd() * (i + 1)); [idx[i], idx[j]] = [idx[j], idx[i]]; }
    return idx;
  }
  // Short set: two items per skill, preferring two different formats.
  function shortSet() {
    const chosen = new Set();
    Object.keys(G.skills).forEach(k => {
      const pool = BANK.filter(i => i.skill === k && !chosen.has(i.id));
      if (!pool.length) return;
      chosen.add(pool[0].id);
      const second = pool.find(i => i !== pool[0] && i.format !== pool[0].format) || pool[1];
      if (second) chosen.add(second.id);
    });
    return BANK.filter(i => chosen.has(i.id));
  }
  const LETTERS = 'ABCDE';
  function keyText(item) {
    const a = item.answer;
    if (item.format === 'mc') { const order = printOrder(item), pos = order.findIndex(i => a.choices[i].correct); return `${LETTERS[pos]}. ${a.choices[order[pos]].text}`; }
    if (item.format === 'tf') return a.value ? 'True' : 'False';
    if (item.format === 'int') return String(a.value);
    if (item.format === 'output') return null;
    return describeLabel(a.label);
  }
  function buildPrintView(which, withKey) {
    const items = which === 'all' ? BANK.slice() : shortSet();
    const order = G.sections.map(s => s.id);
    items.sort((x, y) => order.indexOf(x.section) - order.indexOf(y.section) || BANK.indexOf(x) - BANK.indexOf(y));
    let v = $('#print-view');
    if (!v) { v = el('div'); v.id = 'print-view'; document.body.append(v); }
    v.textContent = '';
    const back = el('p', 'p-screen-only'); const bl = el('a', null, '← Back to the interactive guide'); bl.href = location.pathname; back.append(bl, ' · Use your browser\'s Print command and choose "Save as PDF" to make a PDF.'); v.append(back);
    const a = G.assessment;
    v.append(el('h1', null, G.title), el('p', 'p-sub', `${G.unit} · ${a.name}: ${new Date(a.date + 'T12:00').toLocaleDateString(undefined, { weekday: 'long', month: 'long', day: 'numeric', year: 'numeric' })}`),
      el('p', 'p-sub', a.format), el('p', 'p-name', 'Name ______________________________    Date ______________'));
    // Key ideas and checklist
    G.sections.forEach(s => {
      const sec = el('section', 'p-section');
      // A heading and the list under it form one unbreakable block, so a heading never sits alone at a page bottom.
      const keep = el('div', 'p-keep');
      keep.append(el('h2', null, `${s.title} (${s.topics})`));
      const ul = el('ul'); s.ideas.forEach(i => ul.append(el('li', null, i))); keep.append(ul);
      sec.append(keep);
      const cl = el('ul', 'p-check'); s.skills.forEach(k => cl.append(el('li', null, '☐ ' + G.skills[k]))); sec.append(cl);
      v.append(sec);
    });
    // Questions
    const qh = el('h2', 'p-break', `Practice questions (${items.length})`); v.append(qh);
    v.append(el('p', 'p-sub', 'For "value" questions, write the type (int, double, String) and the value, or write "does not compile" or "crashes".'));
    let n = 0, lastSec = null;
    const numbered = [];
    items.forEach(item => {
      let heading = null;
      if (item.section !== lastSec) { heading = el('h3', null, SECTION[item.section].title); lastSec = item.section; }
      n++; numbered.push([n, item]);
      const q = el('div', 'p-item');
      if (heading) q.prepend(heading);
      q.append(el('p', 'p-q', `${n}. ${item.prompt}`));
      if (item.statement) q.append(el('p', null, item.statement));
      if (item.code) q.append(el('pre', null, item.code));
      if (item.format === 'mc') {
        const ol = el('ol', 'p-choices');
        printOrder(item).forEach((ci, pos) => { const li = el('li'); const c = item.answer.choices[ci]; li.append(`${LETTERS[pos]}. `, c.code ? el('code', null, c.text) : c.text); ol.append(li); });
        q.append(ol);
      } else if (item.format === 'tf') q.append(el('p', 'p-line', 'Circle one:   True     False'));
      else if (item.format === 'output') q.append(el('div', 'p-box'));
      else if (item.format === 'value') q.append(el('p', 'p-line', 'Type: ____________   Value: ______________________'));
      else if (item.format === 'call') q.append(el('p', 'p-line', 'Returns (type): ____________   Value: ______________________'));
      else q.append(el('p', 'p-line', 'Answer: ______________'));
      if (item.format !== 'mc' && item.format !== 'tf') q.append(el('p', 'p-line', 'Why: ________________________________________________'));
      v.append(q);
    });
    // Code tasks
    const ch = el('h2', 'p-break', 'Code tasks'); v.append(ch);
    $$('.codetask').forEach(t => {
      const task = G.codeTasks.find(x => x.id === t.dataset.task);
      const d = el('div', 'p-task');
      d.append(el('h3', null, task.title), el('pre', null, task.header), el('p', null, 'Returns: ' + task.does), el('p', null, 'Precondition: ' + task.pre));
      const ol = el('ol'); task.rubric.forEach(r => ol.append(el('li', null, r))); d.append(el('p', 'p-sub', 'Rubric'), ol, el('div', 'p-box p-tall'));
      v.append(d);
    });
    // Answer key
    if (withKey) {
      const k = el('section', 'p-key');
      k.append(el('h2', null, 'Answer key'));
      numbered.forEach(([num, item]) => {
        const d = el('div', 'p-ans');
        const t = keyText(item);
        d.append(el('p', 'p-q', `${num}. ${t === null ? 'Output:' : t}`));
        if (t === null) d.append(el('pre', null, item.answer.text.replace(/\n$/, '')));
        d.append(el('p', null, item.explain));
        k.append(d);
      });
      k.append(el('p', 'p-sub', 'Code tasks: check your method with the downloadable checker and the rubric. Passing the checker is feedback on its test cases, not proof of correctness.'));
      v.append(k);
    }
    v.append(el('p', 'p-sub', `From ${location.origin}${location.pathname}`));
    document.body.classList.add('printing');
  }
  function buildPrintControls() {
    const box = $('#print-box'); if (!box) return;
    $('#print-short-count').textContent = shortSet().length;
    $('#print-all-count').textContent = BANK.length;
    $('#print-go').addEventListener('click', () => {
      buildPrintView($('input[name="print-set"]:checked').value, $('#print-key').checked);
      const done = () => { document.body.classList.remove('printing'); window.removeEventListener('afterprint', done); };
      window.addEventListener('afterprint', done);
      window.print();
    });
  }
  // ?print=short or ?print=all shows the print view on screen (key included unless &key=0).
  const printParam = new URLSearchParams(location.search).get('print');

  $('#js-note') && ($('#js-note').hidden = true);
  $$('[data-needs-js]').forEach(e => { e.hidden = false; });
  buildRatings(); buildPractice(); buildMock(); buildCode(); renderProgress(); buildPrintControls();
  if (printParam === 'short' || printParam === 'all') buildPrintView(printParam, new URLSearchParams(location.search).get('key') !== '0');
})();
