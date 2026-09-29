import { writeCheck } from './mj-java.mjs';
const r = writeCheck(new URL('recursion-cases.json', import.meta.url), 'RecursionCheck', new URL('RecursionCheck.java', import.meta.url));
console.log(`Wrote RecursionCheck.java with ${r.runs} programs and ${r.compiles} compile checks`);
