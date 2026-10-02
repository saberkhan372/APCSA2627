import { writeCheck } from './mj-java.mjs';
const r = writeCheck(new URL('boundary-cases.json', import.meta.url), 'BoundaryCheck', new URL('BoundaryCheck.java', import.meta.url));
console.log(`Wrote BoundaryCheck.java with ${r.runs} programs and ${r.compiles} compile checks`);
