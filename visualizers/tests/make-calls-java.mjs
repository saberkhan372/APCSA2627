import { writeCheck } from './mj-java.mjs';
const r = writeCheck(new URL('calls-cases.json', import.meta.url), 'CallsCheck', new URL('CallsCheck.java', import.meta.url));
console.log(`Wrote CallsCheck.java with ${r.runs} programs and ${r.compiles} compile checks`);
