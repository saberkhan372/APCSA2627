import { writeCheck } from './mj-java.mjs';
const r = writeCheck(new URL('boolean-cases.json', import.meta.url), 'BooleanCheck', new URL('BooleanCheck.java', import.meta.url));
console.log(`Wrote BooleanCheck.java with ${r.runs} programs and ${r.compiles} compile checks`);
