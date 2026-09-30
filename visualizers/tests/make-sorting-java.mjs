import { writeCheck } from './mj-java.mjs';
const r = writeCheck(new URL('sorting-cases.json', import.meta.url), 'SortingCheck', new URL('SortingCheck.java', import.meta.url));
console.log(`Wrote SortingCheck.java with ${r.runs} programs and ${r.compiles} compile checks`);
