#!/usr/bin/env python3
"""Check the published study guides: pages, downloads without solutions, and links from the course pages."""
from pathlib import Path
import json, re, zipfile

ROOT = Path(__file__).resolve().parents[1]
DOCS = ROOT / 'docs'
STUDY = ROOT / 'content' / 'study'
guides = [json.loads(p.read_text()) for p in sorted(STUDY.glob('*.json')) if not p.name.endswith('-bank.json')]
assert (DOCS / 'study/index.html').exists(), 'Missing study hub'
for name in ('run-study-tests.mjs', 'make-study-java.mjs'):
    assert (ROOT / 'study/tests' / name).exists(), f'Missing study test: {name}'
for g in guides:
    page = (DOCS / 'study' / f'{g["id"]}.html').read_text()
    bank = json.loads((STUDY / f'{g["id"]}-bank.json').read_text())
    data = json.loads(re.search(r'<script type="application/json" id="study-data">(.*?)</script>', page, re.S).group(1).replace('<\\/', '</'))
    assert [i['id'] for i in data['bank']] == [i['id'] for i in bank], f'{g["id"]}: page bank differs from content'
    assert all('java' not in i for i in data['bank']), f'{g["id"]}: Java specs should not be published in the page'
    for t in g['codeTasks']:
        z = DOCS / 'study/downloads' / f'{t["id"]}.zip'
        names = zipfile.ZipFile(z).namelist()
        assert not any('solution' in n.lower() for n in names), f'{t["id"]}: the download must not contain the solution'
        starter = sorted(p.name for p in (ROOT / 'study/code' / t['id']).iterdir() if p.is_file())
        assert sorted(n.split('/', 1)[1] for n in names) == starter, f'{t["id"]}: download differs from the starter files'
    for d in g['linkDates']:
        assert f'../study/{g["id"]}.html' in (DOCS / 'notes' / f'{d}.html').read_text(), f'Study link missing from notes {d}'
        assert f'../study/{g["id"]}.html' in (DOCS / 'days' / f'{d}.html').read_text(), f'Study link missing from day page {d}'
for p in [*DOCS.glob('*.html'), *(DOCS / 'days').glob('*.html'), *(DOCS / 'notes').glob('*.html'), *(DOCS / 'visualizers').glob('*.html')]:
    prefix = '' if p.parent == DOCS else '../'
    assert f'href="{prefix}study/index.html"' in p.read_text(), f'Study link missing from navigation: {p.relative_to(DOCS)}'
print(f'PASS: {len(guides)} study guide(s); pages, downloads without solutions, and navigation/lesson links.')
