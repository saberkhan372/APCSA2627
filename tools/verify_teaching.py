#!/usr/bin/env python3
"""Check instructional coverage, presentation structure, and public note boundaries."""
from pathlib import Path
from html.parser import HTMLParser
import json

ROOT = Path(__file__).resolve().parents[1]
DOCS = ROOT / 'docs'
course = json.loads((ROOT / 'content/course.json').read_text())
lessons = json.loads((ROOT / 'content/teaching.json').read_text())
rows = {r['date']: r for r in course['rows'] if r['kind'] not in ('No class', 'Exam')}
assert len(lessons) == len(rows) == 75
assert [l['date'] for l in lessons] == sorted(rows)
expected = set(rows)
for folder, suffix in [('notes', '.html'), ('slides', '.html'), ('downloads/notes', '.md')]:
    assert {p.stem for p in (DOCS / folder).glob('*' + suffix)} == expected, folder

class Deck(HTMLParser):
    def __init__(self, text):
        super().__init__()
        self.ids = []; self.slides = []; self.scripts = []; self.controls = set()
        self.feed(text)
    def handle_starttag(self, tag, attrs):
        attrs = dict(attrs)
        if 'id' in attrs: self.ids.append(attrs['id'])
        if tag == 'section' and 'slide' in attrs.get('class', '').split():
            self.slides.append(attrs)
        if tag == 'script': self.scripts.append(attrs.get('src'))
        if tag == 'button': self.controls.add(attrs.get('id'))

allowed = {'date', 'goal', 'ideas', 'warm', 'code', 'reasoning', 'practice', 'trap', 'exit', 'agenda', 'independent', 'slide_kind'}
count = 0
for lesson in lessons:
    d = lesson['date']; row = rows[d]
    assert set(lesson) == allowed, f'Unexpected public field: {d}'
    assert len(lesson['ideas']) == 3
    assert all(isinstance(lesson[k], str) and lesson[k].strip() for k in ('goal', 'warm', 'code', 'reasoning', 'practice', 'trap', 'exit'))
    assert all(m > 0 and label.strip() for m, label in lesson['agenda'])
    assert sum(m for m, _ in lesson['agenda']) == row['minutes'], f'Timing: {d}'
    html = (DOCS / 'slides' / f'{d}.html').read_text()
    deck = Deck(html)
    n = 8 if lesson['independent'] else 9
    assert len(deck.slides) == n, f'Slide count: {d}'
    assert [s['id'] for s in deck.slides] == [f'slide-{i}' for i in range(1, n + 1)]
    assert all(s.get('aria-labelledby') in deck.ids for s in deck.slides)
    assert len(deck.ids) == len(set(deck.ids)), f'Duplicate element ID: {d}'
    assert deck.scripts == ['../assets/slides.js']
    assert deck.controls == {'previous', 'next', 'fullscreen', 'print-slides'}
    assert 'hidden' not in deck.slides[0], 'Slides must be readable without JavaScript'
    daily = (DOCS / 'days' / f'{d}.html').read_text()
    assert daily.count('class="daily-teaching-links') == 1
    assert f'../notes/{d}.html' in daily and f'../slides/{d}.html' in daily
    notes = (DOCS / 'notes' / f'{d}.html').read_text()
    assert f'../downloads/notes/{d}.md' in notes
    if lesson['independent']:
        assert 'Complete the independent attempt' in notes
        assert 'After submission' in html
    count += n

visualizers = json.loads((ROOT / 'content/visualizers.json').read_text())
assert (DOCS / 'visualizers/index.html').exists(), 'Missing visualizer hub'
for v in visualizers:
    page = DOCS / 'visualizers' / v['file']
    assert page.exists() and page.read_bytes() == (ROOT / 'visualizers' / v['file']).read_bytes(), f'Visualizer copy: {v["file"]}'
    for d in v['dates']:
        assert f'../visualizers/{v["file"]}' in (DOCS / 'notes' / f'{d}.html').read_text(), f'Visualizer link: {d}'

for name in ('teaching.css', 'slides.css', 'slides.js'):
    assert (ROOT / 'web' / name).read_bytes() == (DOCS / 'assets' / name).read_bytes()
index = (DOCS / 'teaching.html').read_text()
for d in rows:
    assert f'notes/{d}.html' in index and f'slides/{d}.html' in index
print(f'PASS: 75 dated note pages, 75 Markdown notes, 75 decks / {count} slides; exact class coverage, timing, controls, and student-only source fields.')

practice_file = ROOT / 'content/handout-practice.json'
if practice_file.exists():
    practice = json.loads(practice_file.read_text())
    assert set(practice) == {'L01', 'L02', 'L03', 'L04'}
    for key, activity in practice.items():
        source = DOCS / 'downloads/handouts' / activity['filename']
        assert source.read_text() == activity['code']
        assert (DOCS / 'downloads/handouts' / (key + '.md')).exists()
        page = (DOCS / 'materials' / (key + '.html')).read_text()
        assert activity['filename'] in page and 'Original' in page
    print('PASS: four original introductory activities have matching Java starters, Markdown instructions, and material-page links.')
