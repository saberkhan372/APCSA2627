# AP CSA 2026-27

Course website: [AP CSA 2026–27](https://saberkhan372.github.io/APCSA2627/).

This repository is a standalone static course website generated from the daily plan. It contains 75 instructional lesson pages, dated study notes and browser slide decks for all 75 classes, three explicit no-class dates, the AP exam date, 45 Java starter/check bundles, a materials library, setup directions and a reproducible standard-library Python build.

## Folder guide

```text
docs/                    Ready-to-publish website; select this in GitHub Pages
  index.html             Full dated assignment schedule
  days/                  One page per calendar date
  teaching.html          Notes and slides by date
  notes/                 Study notes with examples and practice
  slides/                Browser decks with keyboard and print controls
  downloads/notes/        Editable Markdown study notes
  units/                 Topic and project navigation
  materials/             Guides for each resource
  downloads/lessons/      Daily assignment packets
  downloads/projects/    Individual Java project ZIPs
  downloads/handouts/    Original introductory practice instructions and starters
  assets/                Styles and optional Classroom links
content/                 Editable course, material and lesson JSON
projects/Wxx/            Original Java starters, checks and data fixtures
web/                     Source styles and optional Classroom configuration
tools/                   Build and verification scripts
.github/workflows/       Optional manual Pages publishing workflow
```

Keep the separate `classroom-only` folder and PRIVATE ZIP outside this repository. The `Wxx` IDs identify source projects, not calendar lesson numbers.

## Open locally

Open `docs/index.html` directly, or run `python3 -m http.server 8765 --directory docs`. There is no npm install or backend. Every lesson and material page is static HTML and remains readable with JavaScript disabled.

## Put it on GitHub Pages

1. This repository contains the website package at its root. The prebuilt public website is in `docs/`.
2. In **Settings > Pages**, choose **Deploy from a branch**, **main**, and **/docs**. The prebuilt site needs no custom build step.
3. Alternatively, select **GitHub Actions** as the Pages source, then run **Publish course to GitHub Pages** manually. The included workflow builds, verifies and publishes only `docs/`. It does not deploy automatically on every push.

All internal links are relative, so both `username.github.io/` and `username.github.io/repository-name/` work without a base-URL edit.

Official instructions: https://docs.github.com/en/pages/getting-started-with-github-pages/configuring-a-publishing-source-for-your-github-pages-site and https://docs.github.com/en/pages/getting-started-with-github-pages/using-custom-workflows-with-github-pages

## Update the course

- Edit `content/course.json` for dates, assignments, evidence and homework.
- Edit `content/lessons.json` for the existing Java lesson guides.
- Edit `content/teaching.json` for daily goals, examples, practice prompts, and slides. This file contains student-facing content only.
- Edit `content/handout-practice.json` for the four original introductory activities and their downloadable starters.
- Edit a source in `projects/Wxx/` to revise a starter, check or fixture.
- Add Classroom handout URLs in `web/classroom-links.js`, using the material IDs. Optionally add a single course Classroom URL for submissions.
- Run `python3 tools/build_pages.py` and `python3 tools/verify_pages.py`, then upload the rebuilt site through your normal workflow.

## Daily notes and slides

Open **Notes & slides** from the main navigation, or use **Study notes** and **Class slides** on any instructional day. The 75 decks contain 656 slides. Arrow keys, Previous/Next, Home and End navigate the deck; Print includes every slide. Decks and notes also work as ordinary pages with JavaScript disabled. No presentation service, account, or external font is required.

Each lesson includes a goal, key ideas, a worked example, practice, a common error, and an exit check tied to the dated assignment. The notes can be printed or downloaded as Markdown. Assessment-day examples are marked for use after the independent attempt; teachers provide the actual assessment prompts and scoring guides.

Teacher agendas, scaffolds, extensions and suggested answers are delivered in a separate private pack outside this repository. The September 4 and 9 materials document the opening lessons; October 12–16 and the May 12 exam have no regular lesson deck.

## Materials available elsewhere

Publisher/APSI handouts are packaged separately in `APCSA-Classroom-Materials-PRIVATE.zip`, outside this repository. Upload those to Classroom or another authorized course system and enter their URLs by ID. The site labels these as Classroom handouts, without fake download links. Publicly released AP questions and the Java Quick Reference link directly to College Board. The posted Chapter 1 quiz/videos and future teacher-selected assessments are not invented or copied into the website.

L01–L04 also contain original on-site practice instructions and Java starters for compiler errors, addition/concatenation, circle calculations, and room-paint calculations. They state their own assumptions and preserve the already-posted Chapter 1 submission. Other handout pages provide an explicitly labeled Classroom dashboard link until their direct resource URLs are configured; a dashboard link does not guarantee a handout has been posted.

The repository contains no teacher solution directories, answer-key PDFs, student submissions, grade records, recordings or prior-course student export. The Java checks and worked teaching examples are intentionally student-facing; they are not private assessment keys.

## Visualizers

`visualizers/` holds standalone interactive pages (no libraries, no build step) that `tools/build_pages.py` copies to `docs/visualizers/`. `content/visualizers.json` lists which dated notes pages link to each tool; `tools/verify_teaching.py` checks those links and copies.

Each tool keeps its expected results in `visualizers/tests/`. For each tool, `node visualizers/tests/run-<tool>-tests.mjs` checks the page's JavaScript against its case table, and `node visualizers/tests/make-<tool>-java.mjs` regenerates a self-contained `*Check.java` program that checks the same table against real Java. The **Check visualizers against real Java** workflow runs both on GitHub whenever `visualizers/` changes, so no local JDK is needed; the file can also be pasted into any online Java runner.

## Verification limits

Static links, date coverage, downloads, agendas, deck structure and public source fields are checked by `python3 tools/verify_pages.py`. Run `node tools/test_slides.mjs` for navigation behavior checks.

Run `python3 tools/verify_java.py` with a JDK on your PATH, or supply its installation directory, for example `python3 tools/verify_java.py --java-home /opt/homebrew/opt/openjdk@17`. This compiles all 45 projects into temporary folders and runs each check class, then compiles the four introductory practice starters. Unfinished starters may report `REVISE`; compilation errors, crashes, missing summaries, inconsistent counts, and timeouts fail verification. The prediction exercises can pass unchanged because their code is already complete; collect the written predictions and explanations named in their assignments.

These automated checks do not verify browser rendering or live deployment. Java verification requires permission to execute the configured JDK.
