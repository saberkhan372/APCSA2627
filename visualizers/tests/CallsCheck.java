// Generated from calls-cases.json by mj-java.mjs. Do not edit by hand.
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

public class CallsCheck {
    static class Player {
        private String name;
        private int score;
        public Player(String startName, int startScore) { name = startName; score = startScore; }
        public String getName() { return name; }
        public int getScore() { return score; }
        public void addScore(int amount) { score += amount; }
    }

    static class C0 {
        static int twice(int n) {
            return n * 2;
        }
        static void run() {
            int r = twice(4) + twice(1);
            System.out.println(r);
        }
    }

    static class C1 {
        static void addOne(int n) {
            n++;
            System.out.println("in addOne: " + n);
        }
        static void run() {
            int x = 5;
            addOne(x);
            System.out.println("in main: " + x);
        }
    }

    static class C2 {
        static void swap(int a, int b) {
            int t = a;
            a = b;
            b = t;
        }
        static void run() {
            int x = 1;
            int y = 2;
            swap(x, y);
            System.out.println(x + " " + y);
        }
    }

    static class C3 {
        static void bonus(Player p) {
            p.addScore(10);
        }
        static void run() {
            Player a = new Player("Ana", 5);
            bonus(a);
            System.out.println(a.getScore());
        }
    }

    static class C4 {
        static void replace(Player p) {
            p = new Player("Zed", 0);
        }
        static void run() {
            Player a = new Player("Ana", 5);
            replace(a);
            System.out.println(a.getName());
        }
    }

    static class C5 {
        static void update(Player p) {
            p.addScore(3);
            p = new Player("Bo", 0);
            p.addScore(100);
        }
        static void run() {
            Player a = new Player("Ana", 5);
            update(a);
            System.out.println(a.getName() + " " + a.getScore());
        }
    }

    static class C6 {
        static void zeroFirst(int[] arr) {
            arr[0] = 0;
        }
        static void run() {
            int[] nums = {4, 5, 6};
            zeroFirst(nums);
            System.out.println(nums[0] + " " + nums.length);
        }
    }

    static class C7 {
        static void reset(int[] arr) {
            arr = new int[2];
            arr[0] = 9;
        }
        static void run() {
            int[] nums = {4, 5, 6};
            reset(nums);
            System.out.println(nums[0] + " " + nums.length);
        }
    }

    static class C8 {
        static int square(int n) {
            return n * n;
        }
        static void run() {
            int x = 3;
            square(x);
            System.out.println(x);
        }
    }

    static class C9 {
        static int f(int n) {
            System.out.println("f(" + n + ")");
            return n + 1;
        }
        static void run() {
            int y = f(f(1));
            System.out.println(y);
        }
    }

    static class C10 {
        static int a(int n) {
            return b(n) + 1;
        }
        
        static int b(int n) {
            return c(n) * 2;
        }
        
        static int c(int n) {
            return n - 1;
        }
        static void run() {
            System.out.println(a(5));
        }
    }

    static class C11 {
        static int grow(int x) {
            x = x * 10;
            return x + 1;
        }
        static void run() {
            int x = 2;
            int y = grow(x);
            System.out.println(x + " " + y);
        }
    }

    static class C13 {
        static int addUp(int a, int b) {
            a = a + b;
            return a;
        }
        static void run() {
            int x = 3;
            int y = 4;
            int z = addUp(x, y);
            System.out.println(x + " " + y + " " + z);
        }
    }

    static class C14 {
        static void move(Player from, Player to) {
            from.addScore(-5);
            to.addScore(5);
        }
        static void run() {
            Player a = new Player("A", 10);
            Player b = new Player("B", 0);
            move(a, b);
            move(a, b);
            System.out.println(a.getScore() + " " + b.getScore());
        }
    }

    static class C15 {
        static void both(Player p, Player q) {
            p.addScore(1);
            q.addScore(1);
        }
        static void run() {
            Player a = new Player("A", 0);
            both(a, a);
            System.out.println(a.getScore());
        }
    }

    static class C16 {
        static void fill(int[] arr, int v) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = v;
            }
            v = 0;
        }
        static void run() {
            int[] d = new int[3];
            int k = 7;
            fill(d, k);
            System.out.println(d[2] + " " + k);
        }
    }

    static class C17 {
        static int f(int n) {
            return g(n) + g(n + 1);
        }
        
        static int g(int n) {
            return n * n;
        }
        static void run() {
            System.out.println(f(2));
        }
    }

    static class C18 {
        static String tag(String s) {
            s = "[" + s + "]";
            return s;
        }
        static void run() {
            String w = "hi";
            String t = tag(w);
            System.out.println(w + " " + t);
        }
    }

    static class C19 {
        static int count(int[] arr, int target) {
            int c = 0;
            for (int x : arr) {
                if (x == target) {
                    c++;
                }
            }
            return c;
        }
        static void run() {
            int[] v = {3, 1, 3, 3};
            System.out.println(count(v, 3));
        }
    }

    static class C20 {
        static void swapFirstTwo(int[] arr) {
            int t = arr[0];
            arr[0] = arr[1];
            arr[1] = t;
        }
        static void run() {
            int[] p = {1, 2, 3};
            swapFirstTwo(p);
            System.out.println(p[0] + " " + p[1]);
        }
    }

    static class C21 {
        static void addTwice(ArrayList<Integer> list, int v) {
            list.add(v);
            list.add(v);
        }
        static void run() {
            ArrayList<Integer> nums = new ArrayList<Integer>();
            nums.add(1);
            addTwice(nums, 7);
            System.out.println(nums);
        }
    }

    static class C31 {
        static double half(int n) {
            return n / 2;
        }
        static void run() {
            System.out.println(half(5));
        }
    }

    static class C32 {
        static double avg(int a, int b) {
            return (a + b) / 2.0;
        }
        static void run() {
            System.out.println(avg(3, 4));
        }
    }

    static class C33 {
        static boolean isEven(int n) {
            return n % 2 == 0;
        }
        static void run() {
            System.out.println(isEven(7) + " " + isEven(10));
        }
    }

    static class C34 {
        static int sign(int n) {
            if (n > 0) {
                return 1;
            }
            return -1;
        }
        static void run() {
            System.out.println(sign(3) + sign(-3));
        }
    }

    static class C35 {
        static String initial(String name) {
            return name.substring(0, 1);
        }
        static void run() {
            System.out.println(initial("Ana") + initial("Bo"));
        }
    }

    static class C36 {
        static void shout(String s) {
            s = s + "!";
        }
        static void run() {
            String w = "hi";
            shout(w);
            System.out.println(w);
        }
    }

    static class C37 {
        static void bonus(Player p) {
            p.addScore(1);
        }
        static void run() {
            Player a = null;
            bonus(a);
        }
    }

    static class C38 {
        static int first(int[] arr) {
            return arr[0];
        }
        static void run() {
            int[] e = new int[0];
            System.out.println("start");
            System.out.println(first(e));
        }
    }

    static class C39 {
        static Player best(Player a, Player b) {
            if (a.getScore() >= b.getScore()) {
                return a;
            }
            return b;
        }
        static void run() {
            Player x = new Player("X", 4);
            Player y = new Player("Y", 9);
            Player w = best(x, y);
            w.addScore(1);
            System.out.println(y.getScore());
        }
    }

    static class C40 {
        static int[] makeArray(int n) {
            int[] arr = new int[n];
            arr[n - 1] = n;
            return arr;
        }
        static void run() {
            int[] r = makeArray(3);
            System.out.println(r.length + " " + r[2]);
        }
    }

    static int passed = 0, failed = 0;
    static String capture(Runnable r) {
        PrintStream old = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buf, true));
        String tail = "";
        try { r.run(); } catch (RuntimeException e) { tail = "|throws:" + e.getClass().getSimpleName(); } finally { System.setOut(old); }
        return buf.toString().replace(System.lineSeparator(), "\n") + tail;
    }
    static void check(String code, String want, Runnable r) {
        String got = capture(r);
        if (got.equals(want)) passed++;
        else { failed++; System.out.println("FAIL " + show(code) + "\n  Java  " + show(got) + "\n  table " + show(want)); }
    }
    static void compileCheck(JavaCompiler javac, String code, String source, boolean shouldCompile) throws Exception {
        JavaFileObject src = new SimpleJavaFileObject(URI.create("string:///Snip.java"), JavaFileObject.Kind.SOURCE) {
            @Override public CharSequence getCharContent(boolean ignore) { return source; }
        };
        String out = Files.createTempDirectory("snip").toString();
        boolean ok = javac.getTask(null, null, new DiagnosticCollector<JavaFileObject>(), List.of("-d", out), null, List.of(src)).call();
        if (ok == shouldCompile) passed++;
        else { failed++; System.out.println("FAIL " + show(code) + ": Java " + (ok ? "compiles" : "rejects") + " it, the table says it " + (shouldCompile ? "is valid Java" : "does not compile")); }
    }
    static String show(String s) { return "\"" + s.replace("\n", "\\n") + "\""; }

    public static void main(String[] args) throws Exception {
        check("static int twice(int n) {\n    return n * 2;\n}\n\nint r = twice(4) + twice(1);\nSystem.out.println(r);", "10\n", C0::run);
        check("static void addOne(int n) {\n    n++;\n    System.out.println(\"in addOne: \" + n);\n}\n\nint x = 5;\naddOne(x);\nSystem.out.println(\"in main: \" + x);", "in addOne: 6\nin main: 5\n", C1::run);
        check("static void swap(int a, int b) {\n    int t = a;\n    a = b;\n    b = t;\n}\n\nint x = 1;\nint y = 2;\nswap(x, y);\nSystem.out.println(x + \" \" + y);", "1 2\n", C2::run);
        check("static void bonus(Player p) {\n    p.addScore(10);\n}\n\nPlayer a = new Player(\"Ana\", 5);\nbonus(a);\nSystem.out.println(a.getScore());", "15\n", C3::run);
        check("static void replace(Player p) {\n    p = new Player(\"Zed\", 0);\n}\n\nPlayer a = new Player(\"Ana\", 5);\nreplace(a);\nSystem.out.println(a.getName());", "Ana\n", C4::run);
        check("static void update(Player p) {\n    p.addScore(3);\n    p = new Player(\"Bo\", 0);\n    p.addScore(100);\n}\n\nPlayer a = new Player(\"Ana\", 5);\nupdate(a);\nSystem.out.println(a.getName() + \" \" + a.getScore());", "Ana 8\n", C5::run);
        check("static void zeroFirst(int[] arr) {\n    arr[0] = 0;\n}\n\nint[] nums = {4, 5, 6};\nzeroFirst(nums);\nSystem.out.println(nums[0] + \" \" + nums.length);", "0 3\n", C6::run);
        check("static void reset(int[] arr) {\n    arr = new int[2];\n    arr[0] = 9;\n}\n\nint[] nums = {4, 5, 6};\nreset(nums);\nSystem.out.println(nums[0] + \" \" + nums.length);", "4 3\n", C7::run);
        check("static int square(int n) {\n    return n * n;\n}\n\nint x = 3;\nsquare(x);\nSystem.out.println(x);", "3\n", C8::run);
        check("static int f(int n) {\n    System.out.println(\"f(\" + n + \")\");\n    return n + 1;\n}\n\nint y = f(f(1));\nSystem.out.println(y);", "f(1)\nf(2)\n3\n", C9::run);
        check("static int a(int n) {\n    return b(n) + 1;\n}\n\nstatic int b(int n) {\n    return c(n) * 2;\n}\n\nstatic int c(int n) {\n    return n - 1;\n}\n\nSystem.out.println(a(5));", "9\n", C10::run);
        check("static int grow(int x) {\n    x = x * 10;\n    return x + 1;\n}\n\nint x = 2;\nint y = grow(x);\nSystem.out.println(x + \" \" + y);", "2 21\n", C11::run);
        check("static int addUp(int a, int b) {\n    a = a + b;\n    return a;\n}\n\nint x = 3;\nint y = 4;\nint z = addUp(x, y);\nSystem.out.println(x + \" \" + y + \" \" + z);", "3 4 7\n", C13::run);
        check("static void move(Player from, Player to) {\n    from.addScore(-5);\n    to.addScore(5);\n}\n\nPlayer a = new Player(\"A\", 10);\nPlayer b = new Player(\"B\", 0);\nmove(a, b);\nmove(a, b);\nSystem.out.println(a.getScore() + \" \" + b.getScore());", "0 10\n", C14::run);
        check("static void both(Player p, Player q) {\n    p.addScore(1);\n    q.addScore(1);\n}\n\nPlayer a = new Player(\"A\", 0);\nboth(a, a);\nSystem.out.println(a.getScore());", "2\n", C15::run);
        check("static void fill(int[] arr, int v) {\n    for (int i = 0; i < arr.length; i++) {\n        arr[i] = v;\n    }\n    v = 0;\n}\n\nint[] d = new int[3];\nint k = 7;\nfill(d, k);\nSystem.out.println(d[2] + \" \" + k);", "7 7\n", C16::run);
        check("static int f(int n) {\n    return g(n) + g(n + 1);\n}\n\nstatic int g(int n) {\n    return n * n;\n}\n\nSystem.out.println(f(2));", "13\n", C17::run);
        check("static String tag(String s) {\n    s = \"[\" + s + \"]\";\n    return s;\n}\n\nString w = \"hi\";\nString t = tag(w);\nSystem.out.println(w + \" \" + t);", "hi [hi]\n", C18::run);
        check("static int count(int[] arr, int target) {\n    int c = 0;\n    for (int x : arr) {\n        if (x == target) {\n            c++;\n        }\n    }\n    return c;\n}\n\nint[] v = {3, 1, 3, 3};\nSystem.out.println(count(v, 3));", "3\n", C19::run);
        check("static void swapFirstTwo(int[] arr) {\n    int t = arr[0];\n    arr[0] = arr[1];\n    arr[1] = t;\n}\n\nint[] p = {1, 2, 3};\nswapFirstTwo(p);\nSystem.out.println(p[0] + \" \" + p[1]);", "2 1\n", C20::run);
        check("static void addTwice(ArrayList<Integer> list, int v) {\n    list.add(v);\n    list.add(v);\n}\n\nArrayList<Integer> nums = new ArrayList<Integer>();\nnums.add(1);\naddTwice(nums, 7);\nSystem.out.println(nums);", "[1, 7, 7]\n", C21::run);
        check("static double half(int n) {\n    return n / 2;\n}\n\nSystem.out.println(half(5));", "2.0\n", C31::run);
        check("static double avg(int a, int b) {\n    return (a + b) / 2.0;\n}\n\nSystem.out.println(avg(3, 4));", "3.5\n", C32::run);
        check("static boolean isEven(int n) {\n    return n % 2 == 0;\n}\n\nSystem.out.println(isEven(7) + \" \" + isEven(10));", "false true\n", C33::run);
        check("static int sign(int n) {\n    if (n > 0) {\n        return 1;\n    }\n    return -1;\n}\n\nSystem.out.println(sign(3) + sign(-3));", "0\n", C34::run);
        check("static String initial(String name) {\n    return name.substring(0, 1);\n}\n\nSystem.out.println(initial(\"Ana\") + initial(\"Bo\"));", "AB\n", C35::run);
        check("static void shout(String s) {\n    s = s + \"!\";\n}\n\nString w = \"hi\";\nshout(w);\nSystem.out.println(w);", "hi\n", C36::run);
        check("static void bonus(Player p) {\n    p.addScore(1);\n}\n\nPlayer a = null;\nbonus(a);", "|throws:NullPointerException", C37::run);
        check("static int first(int[] arr) {\n    return arr[0];\n}\n\nint[] e = new int[0];\nSystem.out.println(\"start\");\nSystem.out.println(first(e));", "start\n|throws:ArrayIndexOutOfBoundsException", C38::run);
        check("static Player best(Player a, Player b) {\n    if (a.getScore() >= b.getScore()) {\n        return a;\n    }\n    return b;\n}\n\nPlayer x = new Player(\"X\", 4);\nPlayer y = new Player(\"Y\", 9);\nPlayer w = best(x, y);\nw.addScore(1);\nSystem.out.println(y.getScore());", "10\n", C39::run);
        check("static int[] makeArray(int n) {\n    int[] arr = new int[n];\n    arr[n - 1] = n;\n    return arr;\n}\n\nint[] r = makeArray(3);\nSystem.out.println(r.length + \" \" + r[2]);", "3 3\n", C40::run);
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        if (javac == null) throw new IllegalStateException("A JDK is needed to check compile claims.");
        compileCheck(javac, "static void greet(String name) {\n    System.out.println(\"Hi \" + name);\n}\n\nString s = greet(\"Ana\");", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic void greet(String name) {\n    System.out.println(\"Hi \" + name);\n}\nstatic void run() {\n\nString s = greet(\"Ana\");\n}\n}", false);
        compileCheck(javac, "static int twice(int n) {\n    return n * 2;\n}\n\nSystem.out.println(twice(1, 2));", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic int twice(int n) {\n    return n * 2;\n}\nstatic void run() {\n\nSystem.out.println(twice(1, 2));\n}\n}", false);
        compileCheck(javac, "static int twice(int n) {\n    return n * 2;\n}\n\nSystem.out.println(twice(\"4\"));", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic int twice(int n) {\n    return n * 2;\n}\nstatic void run() {\n\nSystem.out.println(twice(\"4\"));\n}\n}", false);
        compileCheck(javac, "static int twice(int n) {\n    return n * 2;\n}\n\nint r = twice(2.5);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic int twice(int n) {\n    return n * 2;\n}\nstatic void run() {\n\nint r = twice(2.5);\n}\n}", false);
        compileCheck(javac, "static double half(int n) {\n    return n / 2.0;\n}\n\nint h = half(5);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic double half(int n) {\n    return n / 2.0;\n}\nstatic void run() {\n\nint h = half(5);\n}\n}", false);
        compileCheck(javac, "static int sign(int n) {\n    if (n > 0) {\n        return 1;\n    }\n}\n\nSystem.out.println(sign(3));", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic int sign(int n) {\n    if (n > 0) {\n        return 1;\n    }\n}\nstatic void run() {\n\nSystem.out.println(sign(3));\n}\n}", false);
        compileCheck(javac, "static void show(int n) {\n    return n;\n}\n\nshow(1);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic void show(int n) {\n    return n;\n}\nstatic void run() {\n\nshow(1);\n}\n}", false);
        compileCheck(javac, "static int twice(int n) {\n    return n * 2;\n}\n\ntwice(3);\nSystem.out.println(n);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic int twice(int n) {\n    return n * 2;\n}\nstatic void run() {\n\ntwice(3);\nSystem.out.println(n);\n}\n}", false);
        compileCheck(javac, "System.out.println(triple(2));", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nSystem.out.println(triple(2));\n}\n}", false);
        compileCheck(javac, "static int one() {\n    return 1;\n    System.out.println(\"after\");\n}\n\nSystem.out.println(one());", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic int one() {\n    return 1;\n    System.out.println(\"after\");\n}\nstatic void run() {\n\nSystem.out.println(one());\n}\n}", false);
        compileCheck(javac, "static void countdown(int n) {\n    System.out.println(n);\n    countdown(n - 1);\n}\n\ncountdown(3);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic void countdown(int n) {\n    System.out.println(n);\n    countdown(n - 1);\n}\nstatic void run() {\n\ncountdown(3);\n}\n}", true);
        compileCheck(javac, "static int twice(int n) {\n    return n * 2;\n}\n\nstatic int twice(double d) {\n    return (int) d * 2;\n}\n\nSystem.out.println(twice(3));", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic int twice(int n) {\n    return n * 2;\n}\nstatic int twice(double d) {\n    return (int) d * 2;\n}\nstatic void run() {\n\n\nSystem.out.println(twice(3));\n}\n}", true);
        System.out.println(failed == 0 ? "PASS: " + passed + " programs match Java " + System.getProperty("java.version") : failed + " of " + (passed + failed) + " programs differ");
    }
}
