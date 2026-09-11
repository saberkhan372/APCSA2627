#!/usr/bin/env python3
"""Compile every project and verify that its starter checker finishes reporting.

Incomplete starters may report REVISE and exit 1. A crash, timeout, missing
summary, inconsistent count, or compilation error fails this verification.
Compilation output stays in a temporary directory outside the project tree.
"""
from pathlib import Path
import argparse
import json
import re
import shutil
import subprocess
import tempfile

ROOT = Path(__file__).resolve().parents[1]


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--java-home', type=Path, help='JDK directory containing bin/java and bin/javac')
    args = parser.parse_args()
    java = str(args.java_home / 'bin/java') if args.java_home else shutil.which('java')
    javac = str(args.java_home / 'bin/javac') if args.java_home else shutil.which('javac')
    if not java or not javac:
        parser.exit(2, 'Java tools not found. Supply --java-home with an installed JDK directory.\n')
    try:
        version = subprocess.run([javac, '-version'], capture_output=True, text=True, timeout=15)
    except (OSError, subprocess.TimeoutExpired) as error:
        parser.exit(2, f'Cannot execute the configured JDK: {error}\n')
    if version.returncode:
        parser.exit(2, f'Cannot use the configured javac:\n{version.stdout}{version.stderr}')
    print((version.stdout + version.stderr).strip())

    projects = [m for m in json.loads((ROOT / 'content/materials.json').read_text()) if m['kind'] == 'project']
    errors = []
    practice_count = 0
    with tempfile.TemporaryDirectory(prefix='apcsa-java-checks-') as temporary:
        for project in projects:
            key = project['id']
            source = ROOT / 'projects' / key
            classes = Path(temporary) / key
            classes.mkdir()
            try:
                compiled = subprocess.run(
                    [javac, '-encoding', 'UTF-8', '-d', str(classes), *map(str, sorted(source.glob('*.java')))],
                    cwd=source, capture_output=True, text=True, timeout=30)
                if compiled.returncode:
                    errors.append(f'{key}: compilation failed\n{compiled.stdout}{compiled.stderr}')
                    continue
                checked = subprocess.run([java, '-cp', str(classes), project['checkTarget']],
                                         cwd=source, capture_output=True, text=True, timeout=15)
                summaries = re.findall(r'^(\d+) of (\d+) checks passed\s*$', checked.stdout, re.MULTILINE)
                reported = re.findall(r'^(PASS|REVISE):', checked.stdout, re.MULTILINE)
                if len(summaries) != 1:
                    errors.append(f'{key}: missing or ambiguous check summary\n{checked.stdout}{checked.stderr}')
                    continue
                passed, total = map(int, summaries[0])
                expected_exit = 0 if passed == total else 1
                if total == 0 or len(reported) != total or reported.count('PASS') != passed or checked.returncode != expected_exit:
                    errors.append(f'{key}: inconsistent count or exit status\n{checked.stdout}{checked.stderr}')
                    continue
                if 'Exception in thread' in checked.stderr:
                    errors.append(f'{key}: uncaught exception\n{checked.stderr}')
                    continue
                print(f'PASS: {key} compiled; checker completed {total} cases ({passed} passed, {total - passed} to revise).')
            except (OSError, subprocess.TimeoutExpired) as error:
                errors.append(f'{key}: {error}')
        practice_file = ROOT / 'content/handout-practice.json'
        practice = json.loads(practice_file.read_text()) if practice_file.exists() else {}
        for key, activity in practice.items():
            classes = Path(temporary) / ('practice-' + key)
            classes.mkdir()
            source = ROOT / 'docs/downloads/handouts' / activity['filename']
            try:
                compiled = subprocess.run([javac, '-encoding', 'UTF-8', '-d', str(classes), str(source)],
                                          capture_output=True, text=True, timeout=30)
                if compiled.returncode:
                    errors.append(f'{key}: practice compilation failed\n{compiled.stdout}{compiled.stderr}')
                else:
                    practice_count += 1
                    print(f'PASS: {key} practice starter compiled.')
            except (OSError, subprocess.TimeoutExpired) as error:
                errors.append(f'{key}: {error}')
    if errors:
        raise SystemExit('\n'.join(['JAVA VERIFICATION FAILED'] + errors))
    print(f'PASS: all {len(projects)} projects compiled and all starter checkers finished reporting.')
    print(f'PASS: {practice_count} introductory practice starters compiled; interactive programs were not run.')
    print('REVISE results are expected for unfinished starters; this check does not assert that their implementations are complete.')


if __name__ == '__main__':
    main()
