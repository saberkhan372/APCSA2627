// Exercise navigation behavior without a browser or third-party dependencies.
import assert from 'node:assert/strict';
import {readFileSync} from 'node:fs';
import vm from 'node:vm';

const source=readFileSync(new URL('../web/slides.js',import.meta.url),'utf8');
const slides=Array.from({length:9},()=>({hidden:false}));
const buttons=Object.fromEntries(['previous','next','position','fullscreen','print-slides'].map(id=>[id,{
  listeners:{},addEventListener(type,fn){this.listeners[type]=fn;}
}]));
const events={},windowEvents={};
let printed=0,full=false;
const location={hash:'#slide-3'};
const document={
  querySelectorAll:()=>slides,getElementById:id=>buttons[id],
  documentElement:{classList:{add:name=>assert.equal(name,'presenting')}},
  body:{requestFullscreen:async()=>{full=true;document.fullscreenElement=true;}},
  exitFullscreen:async()=>{full=false;document.fullscreenElement=null;},
  addEventListener:(name,fn)=>{events[name]=fn;}
};
vm.runInNewContext(source,{
  document,location,history:{replaceState:(_s,_t,hash)=>{location.hash=hash;}},
  window:{addEventListener:(name,fn)=>{windowEvents[name]=fn;},print:()=>{printed++;}}
});
function active(n){
  assert.deepEqual(slides.map(s=>s.hidden),slides.map((_,i)=>i!==n-1));
  assert.equal(buttons.position.textContent,`${n} / 9`);
  assert.equal(buttons.previous.disabled,n===1);
  assert.equal(buttons.next.disabled,n===9);
}
function key(key,extra={}){
  events.keydown({key,target:{closest:()=>false},preventDefault(){},...extra});
}
active(3);
buttons.next.listeners.click();active(4);assert.equal(location.hash,'#slide-4');
buttons.previous.listeners.click();active(3);
key('Home');active(1);key('ArrowLeft');active(1);
key('End');active(9);key('PageDown');active(9);
key('PageUp');active(8);key('ArrowLeft');active(7);key(' ');active(8);
key('Home',{ctrlKey:true});active(8);
key('Home',{target:{closest:()=>true}});active(8);
key(' ',{target:{closest:selector=>selector==='a,button'}});active(8);
location.hash='#slide-2';windowEvents.hashchange();active(2);
location.hash='#slide-999';windowEvents.hashchange();active(9);
location.hash='#invalid';windowEvents.hashchange();active(1);
buttons['print-slides'].listeners.click();assert.equal(printed,1);
await buttons.fullscreen.listeners.click();assert.equal(full,true);
await buttons.fullscreen.listeners.click();assert.equal(full,false);
console.log('PASS: slide buttons, keyboard navigation, first/last bounds, hash links, form/modifier handling, print dispatch and fullscreen toggle.');
