# Aliasing trace

For each line, draw every `Player` object and every reference arrow. Cross out an object only when
no reference reaches it.

1. `Player a = new Player("Ada", 4);`
2. `Player b = new Player("Grace", 12);`
3. `a = b;`
4. `b.addScore(3);`

Then contrast the result with `int x = 4; int y = x; y = 99;`.
