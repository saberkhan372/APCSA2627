/* Optional conveniences; all assignments and material pages are static HTML. */
(() => {
  const valid = value => {
    if(typeof value !== 'string' || !value)return null;
    try{const u=new URL(value);return u.protocol==='https:'?u.href:null;}catch{return null;}
  };
  const add = (target,url,label) => {
    const href=valid(url);if(!href)return;
    const link=document.createElement('a');link.href=href;link.textContent=label;link.className='button';target.replaceChildren(link);
  };
  const config=window.CLASSROOM_LINKS||{};
  document.querySelectorAll('[data-classroom-resource]').forEach(el=>{
    const id=el.getAttribute('data-classroom-resource');
    add(el,config.materials?.[id]||config.course,'Open in Classroom');
  });
  document.querySelectorAll('[data-classroom-course]').forEach(el=>add(el,config.course,'Open course Classroom'));
  const box=document.querySelector('#next-class');
  if(box&&Array.isArray(window.COURSE_DATES)){
    const today=new Intl.DateTimeFormat('en-CA',{timeZone:'America/Los_Angeles',year:'numeric',month:'2-digit',day:'2-digit'}).format(new Date());
    const next=window.COURSE_DATES.find(r=>r.date>=today&&r.kind!=='No class');
    const h=document.createElement('h2'),p=document.createElement('p');
    if(next){h.textContent=next.date===today?'Today':'Next scheduled date';const link=document.createElement('a');link.href='days/'+next.date+'.html';link.textContent=next.date+' · '+next.title;p.append(link);}
    else{h.textContent='Course archive';p.textContent='All lessons and project downloads remain available below.';}
    box.replaceChildren(h,p);
  }
})();
