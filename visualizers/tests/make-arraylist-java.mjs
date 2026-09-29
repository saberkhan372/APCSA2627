import { writeCheck } from './mj-java.mjs';
const r = writeCheck(new URL('arraylist-cases.json', import.meta.url), 'ArrayListCheck', new URL('ArrayListCheck.java', import.meta.url));
console.log(`Wrote ArrayListCheck.java with ${r.runs} programs and ${r.compiles} compile checks`);
