#!/usr/bin/env python3
"""Build dated notes and browser slides from the public teaching source."""
from pathlib import Path
from datetime import date
from html import escape
from html.parser import HTMLParser
import json,re,shutil,zipfile

ROOT=Path(__file__).resolve().parents[1];DOCS=ROOT/'docs'
COURSE=json.loads((ROOT/'content/course.json').read_text())
TEACHING=json.loads((ROOT/'content/teaching.json').read_text())
ROWS={r['date']:r for r in COURSE['rows']}
MATERIALS={m['id']:m for m in json.loads((ROOT/'content/materials.json').read_text())}
VISUALIZERS=json.loads((ROOT/'content/visualizers.json').read_text())
VIS_BY_DATE={}
for v in VISUALIZERS:
    for d in v['dates']:VIS_BY_DATE.setdefault(d,[]).append(v)
def e(x):return escape(str(x),quote=True)
def human(d):return date.fromisoformat(d).strftime('%B %d, %Y').replace(' 0',' ')
def a(url,label,cls=''):return f'<a href="{e(url)}"'+(f' class="{e(cls)}"' if cls else '')+f'>{e(label)}</a>'
def write(path,text):
    p=DOCS/path;p.parent.mkdir(parents=True,exist_ok=True);p.write_text(text)
def frame(title,body,depth=1,slides=False):
    p='../'*depth
    css='slides.css' if slides else 'teaching.css'
    nav='' if slides else f'<header class="masthead"><div class="wrap">{a(p+"index.html","AP CS A 2026–27","logo")}<nav aria-label="Primary">{a(p+"index.html","Schedule")}{a(p+"units.html","Units")}{a(p+"materials.html","Materials")}{a(p+"teaching.html","Notes & slides")}{a(p+"visualizers/index.html","Visualizers")}{a(p+"setup.html","Setup")}</nav></div></header>'
    return f'''<!doctype html><html lang="en"><head><meta charset="utf-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>{e(title)} · AP CSA</title><link rel="stylesheet" href="{p}assets/site.css"><link rel="stylesheet" href="{p}assets/course.css"><link rel="stylesheet" href="{p}assets/{css}"></head><body class="{'deck-page' if slides else 'notes-page'}"><a class="skip-link" href="#main">Skip to content</a>{nav}<main id="main" class="{'deck-main' if slides else 'wrap year-main'}" tabindex="-1">{body}</main>{f'<script src="{p}assets/slides.js" defer></script>' if slides else ''}</body></html>'''
def material_list(r,depth=1):return '<ul class="material-list">'+''.join('<li>'+a('../'*depth+'materials/'+k+'.html',MATERIALS[k]['name'])+'</li>' for k in r['sources'])+'</ul>'
def agenda(l):
    elapsed=0;out=[]
    for minutes,label in l['agenda']:
        out.append((f'{elapsed}–{elapsed+minutes} min',label));elapsed+=minutes
    return out
def md(l,r):
    parts=[f'# {r["assignment"]}',f'{human(r["date"])} · {r["minutes"]} minutes', '## Learning goal',l['goal'],'## Key ideas']+['- '+s for s in l['ideas']]
    parts+=['## Opening prompt',l['warm'],'## Worked example'+(' — after the independent attempt' if l['independent'] else ''),'```\n'+l['code']+'\n```',l['reasoning'],'## Practice',l['practice'],'## Common error',l['trap'],'## Exit check',l['exit'],'## Assignment',r['task'],'## Turn in',r['evidence'],'## After class',r['homework']]
    if r['homework_due']:parts+=['Due '+human(r['homework_due'])]
    parts+=['## Materials']+['- '+MATERIALS[k]['name']+' — https://saberkhan372.github.io/APCSA2627/materials/'+k+'.html' for k in r['sources']]
    parts+=['','Original teaching examples supplement the linked course materials. Use the supplied project contract and published question text for exact requirements.']
    return '\n\n'.join(parts)+'\n'

for f in ('teaching.css','slides.css','slides.js'):shutil.copy2(ROOT/'web'/f,DOCS/'assets'/f)
slide_total=0
for l in TEACHING:
    d=l['date'];r=ROWS[d];timing=agenda(l)
    note='<header class="page-heading"><p class="kicker">'+e(human(d))+'</p><h1>'+e(r['assignment'])+'</h1><p class="lede">'+e(l['goal'])+'</p></header>'
    note+='<nav class="resource-actions" aria-label="Lesson resources">'+a('../slides/'+d+'.html','Open slides','button')+a('../days/'+d+'.html','Daily assignment')+a('../downloads/notes/'+d+'.md','Download notes')+''.join(a('../visualizers/'+v['file'],v['title']) for v in VIS_BY_DATE.get(d,[]))+'</nav>'
    if l['independent']:note+='<aside class="calendar-note">Complete the independent attempt before using the worked review example. Your teacher supplies the selected assessment questions.</aside>'
    note+='<section><h2>Key ideas</h2><ul class="idea-list">'+''.join('<li>'+e(s)+'</li>' for s in l['ideas'])+'</ul></section>'
    note+='<section><h2>Opening prompt</h2><p>'+e(l['warm'])+'</p></section>'
    note+='<section><h2>Worked '+('review ' if l['independent'] else '')+'example</h2><pre><code>'+e(l['code'])+'</code></pre><p>'+e(l['reasoning'])+'</p></section>'
    note+='<section><h2>Practice</h2><p>'+e(l['practice'])+'</p></section><section><h2>Common error</h2><p>'+e(l['trap'])+'</p></section><section><h2>Exit check</h2><p>'+e(l['exit'])+'</p></section>'
    note+='<section><h2>Turn in</h2><p>'+e(r['evidence'])+'</p></section><section><h2>After class</h2><p>'+e(r['homework'])+'</p>'+('<p class="meta">Due '+human(r['homework_due'])+'</p>' if r['homework_due'] else '')+'</section>'
    note+='<section><h2>Materials</h2>'+material_list(r)+'<p class="help">These original examples supplement the course materials. Follow the supplied project contract and official question text for exact requirements.</p></section>'
    write('notes/'+d+'.html',frame(r['assignment']+' — notes',note))
    write('downloads/notes/'+d+'.md',md(l,r))

    # Each screen has a single instructional purpose. Answers to practice/exit prompts stay outside the public site.
    if l['independent']:
        slides=[
          ('cover',r['assignment'],[l['goal'],human(d)]),
          ('agenda','Independent work', [f'{when}: {label}' for when,label in timing]),
          ('text','Before the attempt',[l['warm'],'Use the prompt and reference your teacher provides.']),
          ('text','Today’s response',[l['practice']]),
          ('text','After submission',l['ideas']),
          ('code','Worked review example',[l['code']]),
          ('text','Reasoning',[l['reasoning']]),
          ('text','Reflection and next steps',[l['exit'],r['homework']])]
    else:
        slides=[
          ('cover',r['assignment'],[l['goal'],human(d)]),
          ('text','Opening prompt',[l['warm']]),
          ('text','Key ideas',l['ideas']),
          ('code','Worked example',[l['code']]),
          ('text','Reasoning',[l['reasoning']]),
          ('text','Practice',[l['practice']]),
          ('text','A common error',[l['trap']]),
          ('text','Assignment and evidence',[r['task'],r['evidence']]),
          ('text','Exit check and next class',[l['exit'],r['homework']])]
    slide_total+=len(slides)
    toolbar=f'<div class="deck-toolbar"><div>{a("../days/"+d+".html","Assignment")}{a("../notes/"+d+".html","Notes")}</div><div class="deck-controls"><button type="button" id="previous" aria-label="Previous slide">Previous</button><span id="position" aria-live="polite">1 / {len(slides)}</span><button type="button" id="next" aria-label="Next slide">Next</button><button type="button" id="fullscreen">Fullscreen</button><button type="button" id="print-slides">Print</button></div></div>'
    body=toolbar+f'<h1 class="sr-only">{e(r["assignment"])} — {e(human(d))}</h1><div class="slides">'
    for i,(kind,title,items) in enumerate(slides,1):
        inner='<pre><code>'+e(items[0])+'</code></pre>' if kind=='code' else ''.join('<p>'+e(s)+'</p>' for s in items)
        body+=f'<section class="slide slide-{kind}" id="slide-{i}" aria-labelledby="title-{i}"><h2 id="title-{i}">{e(title)}</h2><div class="slide-content">{inner}</div><footer>{e(human(d))}<span>{i} / {len(slides)}</span></footer></section>'
    body+='</div><p class="deck-hint">Arrow keys change slides. Home and End jump to the first and last slide. Print shows the whole deck.</p>'
    write('slides/'+d+'.html',frame(r['assignment']+' — slides',body,slides=True))
    # Idempotent integration preserves the rest of every existing lesson page.
    p=DOCS/'days'/f'{d}.html';text=p.read_text()
    links=f'<nav class="daily-teaching-links resource-actions" aria-label="Notes and slides">{a("../notes/"+d+".html","Study notes","button")}{a("../slides/"+d+".html","Class slides","button")}</nav>'
    text=re.sub(r'<nav class="daily-teaching-links.*?</nav>','',text)
    text=text.replace('<div class="lesson-grid">',links+'<div class="lesson-grid">')
    if 'assets/teaching.css' not in text:text=text.replace('</head>','<link rel="stylesheet" href="../assets/teaching.css"></head>')
    p.write_text(text)

groups={}
for l in TEACHING:groups.setdefault(ROWS[l['date']]['unit'],[]).append(l)
index='<header class="page-heading"><h1>Notes and slides</h1><p>Choose a date for study notes, a worked example, and the class slide deck.</p></header>'
for unit,ll in groups.items():
    index+='<section><h2>'+e(unit.replace('-',' '))+'</h2><ul class="teaching-list">'
    for l in ll:
        d=l['date'];r=ROWS[d]
        index+='<li><div><time datetime="'+d+'">'+e(human(d))+'</time><strong>'+e(r['assignment'])+'</strong></div><div>'+a('notes/'+d+'.html','Notes')+a('slides/'+d+'.html','Slides')+'</div></li>'
    index+='</ul></section>'
write('teaching.html',frame('Notes and slides',index,depth=0))

# Add navigation in existing generated pages while preserving any unrelated local edits.
for p in list(DOCS.glob('*.html'))+list((DOCS/'days').glob('*.html'))+list((DOCS/'materials').glob('*.html'))+list((DOCS/'units').glob('*.html')):
    text=p.read_text();prefix='' if p.parent==DOCS else '../'
    if f'href="{prefix}teaching.html"' not in text:
        text=re.sub(r'(<a href="'+re.escape(prefix)+r'setup\.html"[^>]*>)',a(prefix+'teaching.html','Notes & slides')+r'\1',text,count=1)
    if f'href="{prefix}visualizers/index.html"' not in text:
        text=re.sub(r'(<a href="'+re.escape(prefix)+r'setup\.html"[^>]*>)',a(prefix+'visualizers/index.html','Visualizers')+r'\1',text,count=1)
    p.write_text(text)
print(f'Built {len(TEACHING)} notes pages, {len(TEACHING)} browser decks, {slide_total} slides, and {len(TEACHING)} Markdown downloads.')
