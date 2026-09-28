#!/usr/bin/env python3
"""Rebuild the static course site using Python's standard library only."""
from pathlib import Path
from datetime import date
from collections import defaultdict
import html, json, shutil, zipfile

ROOT=Path(__file__).resolve().parents[1]
DOCS=ROOT/'docs'
COURSE=json.loads((ROOT/'content/course.json').read_text())
MATERIALS=json.loads((ROOT/'content/materials.json').read_text())
LESSONS=json.loads((ROOT/'content/lessons.json').read_text())
PRACTICE=json.loads((ROOT/'content/handout-practice.json').read_text()) if (ROOT/'content/handout-practice.json').exists() else {}
BY_ID={m['id']:m for m in MATERIALS}
ROWS=COURSE['rows']
def e(value):return html.escape(str(value or ''),quote=True)
def human(d):return date.fromisoformat(d).strftime('%A, %B %d, %Y').replace(' 0',' ')
def a(url,label,cls=''):return f'<a href="{e(url)}"'+(f' class="{e(cls)}"' if cls else '')+f'>{e(label)}</a>'
def frame(title,body,depth=0,active=''):
    p='../'*depth
    nav=''.join(f'<a href="{p}{u}"'+(' aria-current="page"' if active==name else '')+f'>{name}</a>' for u,name in [('index.html','Schedule'),('units.html','Units'),('materials.html','Materials'),('setup.html','Setup')])
    return f'''<!doctype html>
<html lang="en"><head><meta charset="utf-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>{e(title)} · AP CSA 2026-27</title><meta name="description" content="AP Computer Science A daily assignments, Java projects and course materials for E block, 2026-27."><link rel="stylesheet" href="{p}assets/site.css"><link rel="stylesheet" href="{p}assets/course.css"></head>
<body><a class="skip-link" href="#main">Skip to content</a><header class="masthead"><div class="wrap"><a class="logo" href="{p}index.html">AP CS A <span class="logo-sub">2026-27</span></a><nav aria-label="Primary">{nav}</nav></div></header>
<main id="main" class="wrap year-main" tabindex="-1">{body}</main><footer><div class="wrap"><p>E block · Submit work through Classroom. Keep your source, test evidence and explanations together.</p></div></footer>
<script src="{p}assets/classroom-links.js"></script><script src="{p}assets/course.js" defer></script></body></html>'''
def write(rel,text):
    p=DOCS/rel;p.parent.mkdir(parents=True,exist_ok=True);p.write_text(text)
def mat_link(key,depth=0):
    m=BY_ID[key];prefix='../'*depth
    tag={'project':'Java project','classroom':'Classroom handout','official':'Official resource'}[m['kind']]
    return f'<li>{a(prefix+"materials/"+key+".html",m["name"])} <span class="meta">{tag}</span></li>'
def lesson_line(r,prefix=''):
    dt=date.fromisoformat(r['date']);no=r['kind']=='No class'
    time='No class' if no else f"{r['start']}-{r['end']}"
    unit=r['unit'] if r['unit'].startswith('U') else r['unit'].replace('-',' ')
    return f'<li class="day-line{ " cancelled" if no else ""}"><time datetime="{r["date"]}"><strong>{dt.strftime("%b %d")}</strong><span>{dt.strftime("%a")} · {time}</span></time><div>{a(prefix+"days/"+r["date"]+".html",r["assignment"])}<span class="meta">{e(unit)}{ " · "+e(r["topics"]) if r["topics"] else ""}</span></div><span class="kind">{e(r["kind"])}</span></li>'
def zip_project(z,key):
    for f in sorted((ROOT/'projects'/key).iterdir()):
        if f.is_file():z.write(f,f'{key}/{f.name}')

def handout_practice(key):
    if key not in PRACTICE:return ''
    p=PRACTICE[key]
    source=f'downloads/handouts/{p["filename"]}'
    notes=f'downloads/handouts/{key}.md'
    write(source,p['code'])
    md=[f'# {p["title"]}',p['intro'],'## Start here',f'Save the program as {p["filename"]}.','```java\n'+p['code']+'```','## Tasks']
    md += [f'{i}. {s}' for i,s in enumerate(p['steps'],1)]
    md += ['## Check after predicting']+['- '+s for s in p['checks']]+['## Evidence',p['evidence']]
    write(notes,'\n\n'.join(md)+'\n')
    return '<section><h2>'+e(p['title'])+'</h2><p>'+e(p['intro'])+'</p><p>'+a('../'+source,'Download Java starter','button')+' '+a('../'+notes,'Download practice instructions')+'</p><pre><code>'+e(p['code'])+'</code></pre><ol>'+''.join('<li>'+e(s)+'</li>' for s in p['steps'])+'</ol><details class="code-example"><summary>Check after predicting</summary><ul>'+''.join('<li>'+e(s)+'</li>' for s in p['checks'])+'</ul></details><h3>Evidence</h3><p>'+e(p['evidence'])+'</p></section>'

for part in ['assets','days','materials','units','downloads/projects','downloads/lessons']:(DOCS/part).mkdir(parents=True,exist_ok=True)
for f in (ROOT/'web').iterdir():
    if f.is_file():shutil.copy2(f,DOCS/'assets'/f.name)
write('.nojekyll','')
# Interactive visualizers are standalone pages; their tests stay out of the public site.
(DOCS/'visualizers').mkdir(exist_ok=True)
for f in (ROOT/'visualizers').glob('*.html'):shutil.copy2(f,DOCS/'visualizers'/f.name)
project_count=0
for m in MATERIALS:
    if m['kind']=='project':
        key=m['id'];project_count+=1
        with zipfile.ZipFile(DOCS/f'downloads/projects/{key}.zip','w',zipfile.ZIP_DEFLATED) as z:zip_project(z,key)
with zipfile.ZipFile(DOCS/'downloads/all-java-projects.zip','w',zipfile.ZIP_DEFLATED) as z:
    for m in MATERIALS:
        if m['kind']=='project':zip_project(z,m['id'])

groups=defaultdict(list)
for r in ROWS:groups[r['date'][:7]].append(r)
monthnav='<nav class="month-nav" aria-label="Months">'+''.join(a('#month-'+month,date.fromisoformat(month+'-01').strftime('%b')) for month in groups)+'</nav>'
months=''
for month,rr in groups.items():
    count=sum(r['kind'] not in ('No class','Exam') for r in rr)
    months+=f'<section class="month" id="month-{month}"><h2>{date.fromisoformat(month+"-01").strftime("%B %Y")} <span class="meta">{count} classes</span></h2><ul class="day-list">'+''.join(lesson_line(r) for r in rr)+'</ul></section>'
home=f'''<div class="page-heading"><p class="kicker">E BLOCK · 2026-27</p><h1>Daily assignments</h1><p>68 classes before the AP exam. Seven classes for the final project.</p></div>
<section class="next-class" id="next-class" aria-label="Next lesson"><h2>Start with the current lesson</h2><p>{a('days/2026-09-09.html','September 9: Chapter 1 quiz and Lab Exercise 5')}</p></section>
<div class="calendar-note">No class October 12-16. AP exam May 12; no regular E-block lesson that day.</div>
{monthnav}{months}'''
write('index.html',frame('Daily assignments',home,active='Schedule'))

for i,r in enumerate(ROWS):
    dated=human(r['date']);kind=r['kind'];active=kind not in ('No class','Exam')
    number=f'Class {r["class_number"]} · ' if active else ''
    time='No class' if kind=='No class' else r['start']+'-'+r['end']
    note=f'<aside class="calendar-note">{e(r["calendar_note"])}</aside>' if r['calendar_note'] else ''
    evidence=r['evidence'].replace('Teacher','Your teacher')
    materials='<ul class="material-list">'+''.join(mat_link(k,1) for k in r['sources'])+'</ul>' if r['sources'] else '<p>No materials needed.</p>'
    prep=''
    if kind in ('Assessment','Checkpoint','Review') and 'APC' in r['sources']:
        prep='<p class="help">Your teacher supplies the selected questions in AP Classroom or in class.</p>'
    download=a('../downloads/lessons/'+r['date']+'.zip','Download lesson packet','button') if active else ''
    due=f'<p class="meta">Due {human(r["homework_due"])}</p>' if r['homework_due'] else ''
    prev=a(ROWS[i-1]['date']+'.html','Previous date') if i else ''
    nxt=a(ROWS[i+1]['date']+'.html','Next date') if i+1<len(ROWS) else ''
    body=f'''<p>{a('../index.html','← Schedule')}</p><header class="page-heading"><p class="kicker">{number}{e(dated)} · {e(time)}</p><h1>{e(r['assignment'])}</h1><p>{e(r['unit'])}{' · AP '+e(r['topics']) if r['topics'] else ''}</p></header>{note}
<div class="lesson-grid"><div class="lesson-main"><section><h2>In class</h2><p>{e(r['task'])}</p>{prep}</section><section><h2>Turn in</h2><p>{e(evidence)}</p><p data-classroom-course></p></section><section><h2>After class</h2><p>{e(r['homework'])}</p>{due}</section></div><aside class="lesson-materials"><h2>Materials</h2>{materials}{download}<p class="help">Lesson packets include the assignment and available Java projects. Classroom handouts and assessment questions come from your teacher.</p></aside></div><nav class="previous-next" aria-label="Lesson dates">{prev}{nxt}</nav>'''
    write('days/'+r['date']+'.html',frame(r['assignment'],body,1,'Schedule'))
    if active:
        brief=f"# {r['assignment']}\n\n{dated}, {time}\n\n## In class\n{r['task']}\n\n## Turn in\n{r['evidence']}\n\n## After class\n{r['homework']}\n"+(f"\nDue: {r['homework_due']}\n" if r['homework_due'] else '')
        refs=['# Materials','']
        with zipfile.ZipFile(DOCS/f'downloads/lessons/{r["date"]}.zip','w',zipfile.ZIP_DEFLATED) as z:
            z.writestr('ASSIGNMENT.md',brief)
            for key in r['sources']:
                m=BY_ID[key]
                if m['kind']=='project':zip_project(z,key);where=f'included in {key}/'
                elif m['kind']=='official':where=m['url']
                else:where='provided by your teacher in Classroom; not included in this public packet'
                refs += [f"- {key}: {m['name']} — {where}"]
            z.writestr('MATERIALS.md','\n'.join(refs))

def project_guide(m):
    key=m['id'];l=LESSONS.get(key,{})
    b=f'<p class="lede">{e(l.get("outcome",""))}</p><p>Complete the tasks named in your daily assignment. This page contains the full project.</p><p>{a("../downloads/projects/"+key+".zip","Download starter + checks","button")}</p><section><h2>Run the project</h2><ol><li>Unzip into its own project folder. If you have already started this project, continue your existing working copy.</li><li>Compile all Java files together. Keep any data file in the project folder.</li><li>Run <code>{e(m["runTarget"])}</code>, then complete the starter tasks.</li><li>Run <code>{e(m["checkTarget"])}</code> and explain any failing case. Do not change the check file.</li></ol><p>{a("../setup.html","Eclipse and command-line setup")}</p></section>'
    if l.get('prediction'):b+=f'<section><h2>Predict before running</h2><p>{e(l["prediction"])}</p></section>'
    if l.get('model'):b+=f'<details class="code-example"><summary>Worked example</summary><pre><code>{e(l["model"])}</code></pre><p>{e(l.get("explanation",""))}</p></details>'
    if l.get('missions'):
        b+='<section><h2>Project tasks</h2><ol class="missions">'
        for mission in l['missions']:
            if isinstance(mission,list):b+=f'<li><strong>{e(mission[0])}</strong><p>{e(mission[1] if len(mission)>1 else "")}</p>'+ (f'<p class="help">Check: {e(mission[2])}</p>' if len(mission)>2 else '')+'</li>'
            else:b+=f'<li>{e(mission)}</li>'
        b+='</ol></section>'
    if l.get('apTransfer'):b+=f'<section><h2>AP transfer</h2><p>{e(l["apTransfer"])}</p></section>'
    if l.get('reflection'):b+=f'<section><h2>Explain your work</h2><p>{e(l["reflection"])}</p></section>'
    b+='<section><h2>Included files</h2><ul>'+''.join(f'<li><code>{e(f)}</code></li>' for f in m['files'])+'</ul></section>'
    for f in sorted((ROOT/'projects'/key).glob('*.java')):
        if f.name.endswith('Check.java'):continue
        b+=f'<details class="code-example"><summary>Read starter: {e(f.name)}</summary><pre><code>{e(f.read_text())}</code></pre></details>'
    return b

for m in MATERIALS:
    key=m['id'];kind=m['kind'];guide=''
    if kind=='project':guide=project_guide(m)
    elif kind=='official':guide=f'<p>{a(m["url"],"Open official resource","button")}</p><p>Use the question or section named in your daily assignment.</p>'
    else:guide=handout_practice(key)+f'<section class="handout"><h2>Classroom handout</h2><p>Your teacher provides <strong>{e(m["name"])}</strong> in Classroom. Use the selections named in the daily assignment.</p><p data-classroom-resource="{key}">{a("https://classroom.google.com/","Open Classroom dashboard","button")}</p><p class="help">Choose your AP CSA class, open Classwork, and find the handout by title.</p></section>'
    dates=[r for r in ROWS if key in r['sources']]
    uses='<section><h2>Used in these lessons</h2><ul class="day-list">'+''.join(lesson_line(r,'../') for r in dates)+'</ul></section>' if dates else '<p class="help">Optional extension or course reference.</p>'
    b=f'<p>{a("../materials.html","← Materials")}</p><header class="page-heading"><p class="kicker">{e(key)} · {e(kind)}</p><h1>{e(m["name"])}</h1></header>{guide}{uses}'
    write('materials/'+key+'.html',frame(m['name'],b,1,'Materials'))

lib='<header class="page-heading"><h1>Course materials</h1><p>Java projects download here. Classroom handouts come from your teacher. Released AP questions open at College Board.</p></header><p>'+a('downloads/all-java-projects.zip',f'Download all {project_count} Java projects','button')+'</p>'
for kind,label in [('project','Java starter projects'),('classroom','Classroom handouts'),('official','AP references and practice')]:
    lib+='<section><h2>'+label+'</h2><ul class="library-list">'+''.join(mat_link(m['id']) for m in MATERIALS if m['kind']==kind)+'</ul></section>'
write('materials.html',frame('Materials',lib,active='Materials'))

unit_index='<header class="page-heading"><h1>Units and projects</h1><p>Follow the dated schedule for assignments. Use these pages to revisit a topic.</p></header><div class="unit-list">'
for u,name,start,end,focus,anchor in COURSE['units']:
    if u=='Exam':continue
    rr=[r for r in ROWS if r['unit']==u and r['kind']!='No class'];slug=u.lower()
    unit_index+=f'<article><p class="kicker">{e(u)}</p><h2>{a("units/"+slug+".html",name)}</h2><p>{e(focus)}</p><p class="meta">{len(rr)} classes · {e(start)} to {e(end)}</p></article>'
    content=f'<header class="page-heading"><p class="kicker">{e(u)}</p><h1>{e(name)}</h1><p>{e(focus)}</p></header><ul class="day-list">'+''.join(lesson_line(r,'../') for r in rr)+'</ul>'
    write('units/'+slug+'.html',frame(name,content,1,'Units'))
write('units.html',frame('Units',unit_index+'</div>',active='Units'))
setup='''<header class="page-heading"><h1>Work with a Java project</h1><p>Use Eclipse and the course JDK. Download one project into its own folder.</p></header>
<section><h2>In Eclipse</h2><ol><li>Unzip the project download.</li><li>Create a Java project and copy all included <code>.java</code> files into its source folder. Keep each public class in the matching filename.</li><li>Put any <code>.txt</code> or <code>.csv</code> fixtures in the project’s working directory, usually the project root.</li><li>Open the runner class named on the material page. Choose <strong>Run As → Java Application</strong>.</li><li>After completing the task, run the named check class. Use its messages to find the next case to fix.</li></ol></section>
<section><h2>From a terminal</h2><p>Inside the unzipped project folder:</p><pre><code>javac *.java
java ExpressionLab
java ExpressionLabCheck</code></pre><p>Replace these example class names with the runner and check listed on your material page.</p></section>
<section><h2>Before changing code</h2><p>Downloads contain original starters. Continue your existing working copy when a project appears again; save a backup before starting a new version.</p><ol><li>Read the specification and predict the baseline.</li><li>Run the unchanged starter and record what you see.</li><li>Implement one method or behavior at a time.</li><li>Test a normal case and a boundary case; explain any mismatch.</li></ol></section>
<section><h2>Turn in evidence</h2><p>Follow the daily assignment. Usually you submit source files, predicted/actual test results and a short explanation through Classroom. This website does not upload or collect your work.</p><p data-classroom-course></p></section>'''
write('setup.html',frame('Setup',setup,active='Setup'))
# Only the small public calendar subset is used for the next-lesson convenience.
write('assets/dates.js','window.COURSE_DATES = '+json.dumps([{'date':r['date'],'title':r['assignment'],'kind':r['kind']} for r in ROWS])+';')
p=DOCS/'index.html';p.write_text(p.read_text().replace('<script src="assets/course.js"','<script src="assets/dates.js"></script><script src="assets/course.js"'))
print(f'Built {len(list(DOCS.rglob("*.html")))} static pages, {project_count} project ZIPs and 75 lesson packets.')
if (ROOT/'content/teaching.json').exists():
    import runpy
    runpy.run_path(str(ROOT/'tools/build_teaching.py'),run_name='__main__')
