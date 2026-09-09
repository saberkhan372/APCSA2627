#!/usr/bin/env python3
"""Check the generated student site and download boundaries; no network needed."""
from pathlib import Path, PurePosixPath
from html.parser import HTMLParser
from urllib.parse import urlsplit, unquote
from datetime import date
import json, re, zipfile

ROOT=Path(__file__).resolve().parents[1]
DOCS=ROOT/'docs'
course=json.loads((ROOT/'content/course.json').read_text())
materials=json.loads((ROOT/'content/materials.json').read_text())
rows=course['rows']
errors=[]
def check(ok,msg):
    if not ok:errors.append(msg)

class Page(HTMLParser):
    def __init__(self,text):
        super().__init__();self.links=[];self.ids=set();self.titles=0;self.main=0;self.h1=0
        self.feed(text)
    def handle_starttag(self,tag,attrs):
        a=dict(attrs)
        if 'id' in a:self.ids.add(a['id'])
        if tag=='title':self.titles+=1
        if tag=='main':self.main+=1
        if tag=='h1':self.h1+=1
        for attr in ('href','src'):
            if a.get(attr):self.links.append(a[attr])

pages={p.resolve():Page(p.read_text()) for p in DOCS.rglob('*.html')}
link_count=0
for path,page in pages.items():
    check(page.titles==1 and page.main==1 and page.h1==1,f'Page landmarks: {path.relative_to(DOCS)}')
    for link in page.links:
        u=urlsplit(link)
        if u.scheme or u.netloc:continue
        link_count+=1
        check(not u.path.startswith('/'),f'Root-relative link: {link}')
        dest=(path.parent/unquote(u.path)).resolve() if u.path else path
        if dest.is_dir():dest=dest/'index.html'
        check(dest.is_relative_to(DOCS),f'Link leaves public site: {link}')
        check(dest.exists(),f'Broken link: {path.name} -> {link}')
        if u.fragment and dest in pages:check(unquote(u.fragment) in pages[dest].ids,f'Broken anchor: {link}')

dates=[r['date'] for r in rows]
check(len(dates)==len(set(dates))==79,'Expected 79 unique calendar dates')
check(dates==sorted(dates),'Calendar dates must be ordered')
cancelled=[r['date'] for r in rows if r['kind']=='No class']
check(cancelled==['2026-10-12','2026-10-14','2026-10-16'],'October no-class dates')
classes=[r for r in rows if r['kind'] not in ('No class','Exam')]
check(len(classes)==75,'Expected 75 instructional lessons')
check(sum(r['date']<'2027-05-12' for r in classes)==68,'Expected 68 pre-exam classes')
check([r['date'] for r in rows if r['kind']=='Exam']==['2027-05-12'],'Exam calendar slot')
check([r['class_number'] for r in classes]==list(range(1,76)),'Class numbering')
check((DOCS/'.nojekyll').exists(),'Missing .nojekyll')
check(len(list((DOCS/'days').glob('*.html')))==79,'Missing calendar pages')
check(len(list((DOCS/'downloads/lessons').glob('*.zip')))==75,'Lesson packet count')
project_ids={m['id'] for m in materials if m['kind']=='project'}
check(len(project_ids)==45,'Java project count')
check(len(list((DOCS/'downloads/projects').glob('*.zip')))==45,'Project ZIP count')
material_ids={m['id'] for m in materials}
for r in rows:
    date.fromisoformat(r['date'])
    check(set(r['sources'])<=material_ids,f'Missing material for {r["date"]}')
    check((DOCS/'downloads/lessons'/f'{r["date"]}.zip').exists()==(r in classes),f'Wrong lesson download on {r["date"]}')
    if r['homework_due']:check(r['homework_due'] in {x['date'] for x in classes},f'Homework due on nonclass: {r["date"]}')

def allowed_name(name):
    p=PurePosixPath(name)
    return '..' not in p.parts and not p.is_absolute() and not any(x.lower() in ('solution','solutions','student-work','.git') for x in p.parts) and p.suffix in ('.md','.java','.txt','.csv')

zip_count=0;entry_count=0
for zpath in (DOCS/'downloads').rglob('*.zip'):
    zip_count+=1
    with zipfile.ZipFile(zpath) as z:
        check(z.testzip() is None,f'Corrupt ZIP: {zpath.name}')
        check(len(z.namelist())==len(set(z.namelist())),f'Duplicate ZIP entries: {zpath.name}')
        for name in z.namelist():
            entry_count+=1
            check(allowed_name(name),f'Unexpected public ZIP file: {name}')
        if zpath.parent.name=='lessons':
            check({'ASSIGNMENT.md','MATERIALS.md'}<=set(z.namelist()),f'Incomplete lesson packet: {zpath.name}')
            r=next(x for x in rows if x['date']==zpath.stem)
            expected={k for k in r['sources'] if k in project_ids}
            actual={PurePosixPath(n).parts[0] for n in z.namelist() if '/' in n}
            check(expected==actual,f'Wrong projects in lesson packet: {zpath.name}')

java_count=0
for m in materials:
    if m['kind']!='project':continue
    p=ROOT/'projects'/m['id']
    for target in (m['runTarget'],m['checkTarget']):
        check((p/f'{target}.java').exists(),f'Missing runner/check: {m["id"]}/{target}')
    for f in p.glob('*.java'):
        java_count+=1
        match=re.search(r'public\s+(?:final\s+)?(?:class|interface|enum)\s+(\w+)',f.read_text())
        if match:check(match[1]==f.stem,f'Public Java class filename: {f}')
    with zipfile.ZipFile(DOCS/f'downloads/projects/{m["id"]}.zip') as z:
        for f in p.iterdir():
            if f.is_file():check(z.read(f'{m["id"]}/{f.name}')==f.read_bytes(),f'Project download differs: {f.name}')

for p in DOCS.rglob('*'):
    if not p.is_file():continue
    check(p.suffix not in ('.pdf','.docx','.class','.env'),f'Unexpected public file: {p.name}')
    if p.suffix in ('.html','.js','.css','.json'):
        text=p.read_text()
        check('/Users/' not in text and '/private/tmp/' not in text,f'Local path in public page: {p.name}')
workflow=(ROOT/'.github/workflows/pages.yml').read_text()
check('workflow_dispatch:' in workflow and '\n  push:' not in workflow,'Workflow must be manual')
check('path: docs' in workflow,'Workflow must upload docs only')
if errors:
    raise SystemExit('\n'.join(['VERIFICATION FAILED']+errors))
print(f'PASS: {len(pages)} pages; {link_count} internal links; 79 calendar dates; 75 classes; {zip_count} ZIPs/{entry_count} entries; {java_count} Java source files.')
print('PASS: no-class dates, exam conflict, homework dates, relative URLs, download integrity and public/private file boundaries.')
print('Java compilation and live GitHub Pages deployment are separate checks; not performed by this script.')
