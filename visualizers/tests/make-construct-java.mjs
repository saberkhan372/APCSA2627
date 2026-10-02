import { writeCheck } from './mj-java.mjs';
const r = writeCheck(new URL('construct-cases.json', import.meta.url), 'ConstructCheck', new URL('ConstructCheck.java', import.meta.url));
console.log(`Wrote ConstructCheck.java with ${r.runs} programs and ${r.compiles} compile checks`);
