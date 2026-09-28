#!/usr/bin/env python3
"""Build study guide pages from content/study/<id>.json and its verified practice bank."""
from pathlib import Path
from datetime import date
from html import escape
import json, re, zipfile

ROOT = Path(__file__).resolve().parents[1]
DOCS = ROOT / 'docs'
STUDY = ROOT / 'content' / 'study'
CODE = ROOT / 'study' / 'code'
ROWS = {r['date']: r for r in json.loads((ROOT / 'content/course.json').read_text())['rows']}
FIXED_TIME = (2026, 1, 1, 0, 0, 0)  # deterministic ZIPs: rebuilding does not change them


def e(x):
    return escape(str(x), quote=True)


def human(d):
    return date.fromisoformat(d).strftime('%A, %B %d, %Y').replace(' 0', ' ')


def guides():
    return [json.loads(p.read_text()) for p in sorted(STUDY.glob('*.json')) if not p.name.endswith('-bank.json')]


def frame(title, body, depth=1):
    p = '../' * depth
    nav = ''.join(f'<a href="{p}{u}"' + (' aria-current="page"' if label == 'Study' else '') + f'>{label}</a>'
                  for u, label in [('index.html', 'Schedule'), ('units.html', 'Units'), ('materials.html', 'Materials'),
                                   ('teaching.html', 'Notes &amp; slides'), ('study/index.html', 'Study'),
                                   ('visualizers/index.html', 'Visualizers'), ('setup.html', 'Setup')])
    return (f'<!doctype html><html lang="en"><head><meta charset="utf-8"><meta name="viewport" content="width=device-width, initial-scale=1">'
            f'<title>{e(title)} · AP CSA</title><link rel="stylesheet" href="{p}assets/site.css"><link rel="stylesheet" href="{p}assets/course.css">'
            f'<link rel="stylesheet" href="{p}assets/study.css"></head><body><a class="skip-link" href="#main">Skip to content</a>'
            f'<header class="masthead"><div class="wrap"><a href="{p}index.html" class="logo">AP CS A 2026–27</a><nav aria-label="Primary">{nav}</nav></div></header>'
            f'<main id="main" class="wrap year-main" tabindex="-1">{body}</main></body></html>')


def solution_method(task_id):
    """The method from the reference solution, shown to students after they attempt the task."""
    src = next((CODE / task_id / 'solution').glob('*.java')).read_text().splitlines()
    start = next(i for i, l in enumerate(src) if l.strip().startswith('public static') and 'main(' not in l)
    end = next(i for i in range(start, len(src)) if src[i] == '    }')
    return '\n'.join(l[4:] for l in src[start:end + 1])


def write_zip(task_id):
    out = DOCS / 'study' / 'downloads' / f'{task_id}.zip'
    out.parent.mkdir(parents=True, exist_ok=True)
    with zipfile.ZipFile(out, 'w', zipfile.ZIP_DEFLATED) as z:
        for f in sorted((CODE / task_id).iterdir()):
            if f.is_file():  # the solution/ folder is never packaged
                info = zipfile.ZipInfo(f'{task_id}/{f.name}', FIXED_TIME)
                info.compress_type = zipfile.ZIP_DEFLATED
                z.writestr(info, f.read_bytes())
    return f'downloads/{task_id}.zip'


def tab(name, label):
    first = name == 'guide'
    return (f'<button type="button" role="tab" data-tab="{name}" aria-controls="panel-{name}" aria-selected="{"true" if first else "false"}"'
            + ('' if first else ' tabindex="-1"') + f'>{label}</button>')


def guide_page(g, bank):
    a = g['assessment']
    counts = {s['id']: sum(1 for i in bank if i['section'] == s['id']) for s in g['sections']}
    body = (f'<header class="page-heading"><p class="kicker">{e(g["unit"])}</p><h1>{e(g["title"])}</h1><p class="lede">{e(g["lede"])}</p></header>'
            f'<noscript><p class="calendar-note">The key ideas below work without JavaScript. Practice, the mock and self-ratings need JavaScript.</p></noscript>'
            '<div class="study-tabs" role="tablist" aria-label="Study guide">'
            + ''.join(tab(t, label) for t, label in [('guide', 'Guide'), ('practice', 'Practice'), ('mock', 'Mock test'), ('code', 'Code tasks')])
            + '</div>')
    # Guide
    guide = (f'<section id="panel-guide" role="tabpanel" class="study-panel"><div class="assessment-box"><strong>{e(a["name"])}: {e(human(a["date"]))}</strong>'
             f'<span>{e(a["format"])}</span><span class="small">Self-ratings and results are saved in this browser only. No login, and nothing is sent anywhere.</span></div>')
    for s in g['sections']:
        lessons = ''.join(f'<a href="../notes/{d}.html">{e(ROWS[d]["assignment"])}</a>' for d in s['lessons'])
        vis = ''.join(f'<a href="../visualizers/{f}">{e(t)}</a>' for f, t in s['visualizers'])
        skills = ''.join(f'<div class="skill-row"><span class="can">{e(g["skills"][k])}</span><span class="rating" data-skill="{e(k)}" data-needs-js hidden></span></div>' for k in s['skills'])
        guide += (f'<section class="guide-section" aria-labelledby="sec-{s["id"]}"><h2 id="sec-{s["id"]}">{e(s["title"])}</h2>'
                  f'<p class="meta small">{e(s["topics"])} · {e(s["source"])} · {counts[s["id"]]} practice questions</p>'
                  '<h3>Key ideas</h3><ul class="ideas">' + ''.join(f'<li>{e(i)}</li>' for i in s['ideas']) + '</ul>'
                  f'<h3>I can…</h3>{skills}'
                  f'<div class="links-row"><span class="small">Lessons:</span>{lessons}' + (f'<span class="small">Visualizers:</span>{vis}' if vis else '') + '</div>'
                  f'<div data-needs-js hidden><button type="button" class="btn" data-practice="{s["id"]}">Practice {e(s["title"].lower())}</button></div></section>')
    guide += ('<section class="guide-section" data-needs-js hidden><h2>Your progress</h2><p class="small">Your self-ratings are shown next to what you have '
              'actually shown in practice and your last mock. When they disagree, trust the results.</p><div id="progress"></div></section></section>')
    # Practice
    practice = ('<section id="panel-practice" role="tabpanel" class="study-panel" hidden><p>Each answer is explained right away. Pick a section, or mix them all. '
                'Quiz-style questions practice the same skills as the quizzes, in new contexts; new questions cover the rest of the unit.</p>'
                '<div class="presets" id="practice-sections" aria-label="Practice sections"></div><div id="practice-item"></div></section>')
    # Mock
    m = g['mock']
    mock = (f'<section id="panel-mock" role="tabpanel" class="study-panel" hidden><div id="mock-intro" class="study-panel">'
            f'<p>{m["count"]} questions, {m["perSection"]} from each section, in a new mix each time. Like the real assessment, nothing is checked until you submit. '
            'Then you see every explanation and which skills to practice.</p>'
            f'<label class="row"><input type="checkbox" id="mock-timed"> Time me ({m["minutes"]} minutes, the same as the assessment)</label>'
            '<div><button type="button" class="btn primary" id="mock-start">Start a mock</button></div><div id="mock-history"></div></div>'
            '<div id="mock-run" hidden><div class="mock-bar"><div class="mock-nav" id="mock-nav" aria-label="Questions"></div><span id="mock-timer" aria-live="off"></span></div>'
            '<div id="mock-item"></div><div class="row"><button type="button" class="btn" id="mock-prev">← Previous</button><button type="button" class="btn" id="mock-next">Next →</button>'
            '<button type="button" class="btn primary" id="mock-submit">Submit answers</button></div></div><div id="mock-results" class="study-panel" hidden></div></section>')
    # Code tasks
    code = ('<section id="panel-code" role="tabpanel" class="study-panel" hidden><p>Like the second part of the assessment: write a method from a supplied header. '
            'Download the starter and checker, predict each check first, then run the checker. Passing every check is feedback on those cases, not proof that your method '
            'is correct for every input. After you have written an attempt below, you can compare it with a model solution.</p>')
    for t in g['codeTasks']:
        zip_rel = write_zip(t['id'])
        code += (f'<article class="codetask" data-task="{e(t["id"])}"><h2>{e(t["title"])}</h2><pre><code>{e(t["header"])}</code></pre>'
                 f'<p><strong>Returns:</strong> {e(t["does"])}</p><p><strong>Precondition:</strong> {e(t["pre"])} You do not need to handle other input.</p>'
                 f'<p><a class="button" href="{zip_rel}">Download starter and checker</a></p>'
                 '<h3>Rubric</h3><ol>' + ''.join(f'<li>{e(r)}</li>' for r in t['rubric']) + '</ol>'
                 f'<div data-needs-js hidden><label class="small" for="code-{e(t["id"])}">Your method (saved in this browser)</label>'
                 f'<textarea id="code-{e(t["id"])}" spellcheck="false"></textarea>'
                 '<div class="row"><button type="button" class="btn showmodel" disabled>Compare with a model solution</button></div>'
                 f'<div class="model" hidden><p class="small">One correct solution. Yours can differ and still be right; check it against the rubric.</p><pre><code>{e(solution_method(t["id"]))}</code></pre></div></div></article>')
    code += '</section>'
    public_bank = [{k: v for k, v in i.items() if k not in ('java', 'conceptual')} for i in bank]
    data = json.dumps({'guide': g, 'bank': public_bank}, ensure_ascii=False).replace('</', '<\\/')
    body += guide + practice + mock + code + f'<script type="application/json" id="study-data">{data}</script><script src="../assets/study.js" defer></script>'
    return frame(g['title'], body)


def build():
    out = DOCS / 'study'
    out.mkdir(parents=True, exist_ok=True)
    listing = ''
    for g in guides():
        bank = json.loads((STUDY / f'{g["id"]}-bank.json').read_text())
        (out / f'{g["id"]}.html').write_text(guide_page(g, bank))
        a = g['assessment']
        listing += (f'<li><h2><a href="{g["id"]}.html">{e(g["title"])}</a></h2><p>{e(a["name"])}: {e(human(a["date"]))}. '
                    f'{len(bank)} practice questions, a mixed mock and {len(g["codeTasks"])} code tasks.</p></li>')
    hub = ('<header class="page-heading"><p class="kicker">Assessment preparation</p><h1>Study guides</h1><p class="lede">One guide per unit assessment: key ideas, '
           'practice that explains each answer, a mock test, and code tasks. Your progress stays in this browser.</p></header>'
           f'<ul class="material-list">{listing}</ul><p class="help">Guides for Units 2–4 will be added before those assessments.</p>')
    (out / 'index.html').write_text(frame('Study guides', hub))
    print(f'Built {len(guides())} study guide(s).')


if __name__ == '__main__':
    build()
