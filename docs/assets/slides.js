/* Accessible, dependency-free browser slide navigation. No answers or teacher data. */
(() => {
  const slides=[...document.querySelectorAll('.slide')];
  if(!slides.length)return;
  const prev=document.getElementById('previous'),next=document.getElementById('next');
  const position=document.getElementById('position');
  let index=0;
  function fromHash(){const m=location.hash.match(/^#slide-(\d+)$/);return m?Number(m[1])-1:0;}
  function show(n,writeHash=true){
    index=Math.max(0,Math.min(slides.length-1,n));
    slides.forEach((s,i)=>{s.hidden=i!==index;});
    prev.disabled=index===0;next.disabled=index===slides.length-1;
    position.textContent=`${index+1} / ${slides.length}`;
    if(writeHash)history.replaceState(null,'',`#slide-${index+1}`);
  }
  document.documentElement.classList.add('presenting');
  prev.addEventListener('click',()=>show(index-1));
  next.addEventListener('click',()=>show(index+1));
  window.addEventListener('hashchange',()=>show(fromHash(),false));
  document.addEventListener('keydown',e=>{
    if(e.altKey||e.ctrlKey||e.metaKey||e.target.closest('input,textarea,select'))return;
    if(e.key===' '&&e.target.closest('a,button'))return;
    if(['ArrowRight','PageDown',' '].includes(e.key)){e.preventDefault();show(index+1);}
    else if(['ArrowLeft','PageUp'].includes(e.key)){e.preventDefault();show(index-1);}
    else if(e.key==='Home'){e.preventDefault();show(0);}
    else if(e.key==='End'){e.preventDefault();show(slides.length-1);}
  });
  const full=document.getElementById('fullscreen');
  if(!document.body.requestFullscreen)full.hidden=true;
  full.addEventListener('click',async()=>{
    try{if(document.fullscreenElement)await document.exitFullscreen();else await document.body.requestFullscreen();}
    catch{full.textContent='Fullscreen unavailable';}
  });
  document.getElementById('print-slides').addEventListener('click',()=>window.print());
  show(fromHash(),false);
})();
