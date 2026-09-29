// Loads the mini-Java interpreter (with the Expression Tracer engine it relies on) for tests and tools.
import { readFileSync } from 'node:fs';
import { exprEngineSource } from './sync-expr-engine.mjs';
const dir = new URL('../', import.meta.url);
export function mjSource() { return readFileSync(new URL('lib/minijava.js', dir), 'utf8').trimEnd(); }
export function loadMJ() { return new Function(exprEngineSource() + '\n' + mjSource() + '\nreturn MJ;')(); }
