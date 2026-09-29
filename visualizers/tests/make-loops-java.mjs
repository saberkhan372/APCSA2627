import { writeCheck } from './mj-java.mjs';
const r = writeCheck(new URL('loops-cases.json', import.meta.url), 'LoopsCheck', new URL('LoopsCheck.java', import.meta.url));
console.log(`Wrote LoopsCheck.java with ${r.runs} programs and ${r.compiles} compile checks`);
