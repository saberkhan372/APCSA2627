// Generated from recursion-cases.json by mj-java.mjs. Do not edit by hand.
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

public class RecursionCheck {
    static class Player {
        private String name;
        private int score;
        public Player(String startName, int startScore) { name = startName; score = startScore; }
        public String getName() { return name; }
        public int getScore() { return score; }
        public void addScore(int amount) { score += amount; }
    }

    static class C0 {
        static int fact(int n) {
            if (n <= 1) {
                return 1;
            }
            return n * fact(n - 1);
        }
        static void run() {
            System.out.println(fact(4));
        }
    }

    static class C1 {
        static void down(int n) {
            if (n == 0) {
                return;
            }
            System.out.print(n + " ");
            down(n - 1);
        }
        static void run() {
            down(3);
        }
    }

    static class C2 {
        static void up(int n) {
            if (n == 0) {
                return;
            }
            up(n - 1);
            System.out.print(n + " ");
        }
        static void run() {
            up(3);
        }
    }

    static class C3 {
        static void both(int n) {
            if (n == 0) {
                return;
            }
            System.out.print(n);
            both(n - 1);
            System.out.print(n);
        }
        static void run() {
            both(3);
            System.out.println();
        }
    }

    static class C4 {
        static int sum(int n) {
            if (n == 0) {
                return 0;
            }
            int rest = sum(n - 1);
            return n + rest;
        }
        static void run() {
            System.out.println(sum(3));
        }
    }

    static class C5 {
        static String rev(String s) {
            if (s.length() <= 1) {
                return s;
            }
            return rev(s.substring(1)) + s.substring(0, 1);
        }
        static void run() {
            System.out.println(rev("abc"));
        }
    }

    static class C6 {
        static int fib(int n) {
            if (n <= 1) {
                return n;
            }
            return fib(n - 1) + fib(n - 2);
        }
        static void run() {
            System.out.println(fib(4));
        }
    }

    static class C7 {
        static int digitSum(int n) {
            if (n < 10) {
                return n;
            }
            return digitSum(n / 10) + n % 10;
        }
        static void run() {
            System.out.println(digitSum(1234));
        }
    }

    static class C9 {
        static int find(int[] a, int target, int lo, int hi) {
            if (lo > hi) {
                return -1;
            }
            int mid = (lo + hi) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[mid] < target) {
                return find(a, target, mid + 1, hi);
            }
            return find(a, target, lo, mid - 1);
        }
        static void run() {
            int[] a = {2, 5, 8, 12, 16, 23, 38};
            System.out.println(find(a, 23, 0, 6));
        }
    }

    static class C10 {
        static int total(int[] a, int i) {
            if (i == a.length) {
                return 0;
            }
            return a[i] + total(a, i + 1);
        }
        static void run() {
            int[] v = {3, 1, 4};
            System.out.println(total(v, 0));
        }
    }

    static class C11 {
        static int power(int b, int e) {
            if (e == 0) {
                return 1;
            }
            return b * power(b, e - 1);
        }
        static void run() {
            System.out.println(power(2, 5));
        }
    }

    static class C12 {
        static void pattern(int n) {
            if (n <= 0) {
                return;
            }
            System.out.print(n);
            pattern(n - 2);
            System.out.print(n);
        }
        static void run() {
            pattern(5);
            System.out.println();
        }
    }

    static class C13 {
        static int fib(int n) {
            if (n <= 1) {
                return n;
            }
            return fib(n - 1) + fib(n - 2);
        }
        static void run() {
            System.out.println(fib(5));
        }
    }

    static class C14 {
        static int countA(String s) {
            if (s.length() == 0) {
                return 0;
            }
            int rest = countA(s.substring(1));
            if (s.substring(0, 1).equals("a")) {
                return 1 + rest;
            }
            return rest;
        }
        static void run() {
            System.out.println(countA("banana"));
        }
    }

    static class C15 {
        static int countA(String s) {
            if (s.length() == 0) {
                return 0;
            }
            int rest = countA(s.substring(1));
            if (s.substring(0, 1).equals("a")) {
                return 1 + rest;
            }
            return rest;
        }
        static void run() {
            System.out.println(countA("abc"));
        }
    }

    static class C17 {
        static int digits(int n) {
            if (n < 10) {
                return 1;
            }
            return 1 + digits(n / 10);
        }
        static void run() {
            System.out.println(digits(40521));
        }
    }

    static class C18 {
        static int find(int[] a, int target, int lo, int hi) {
            if (lo > hi) {
                return -1;
            }
            int mid = (lo + hi) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[mid] < target) {
                return find(a, target, mid + 1, hi);
            }
            return find(a, target, lo, mid - 1);
        }
        static void run() {
            int[] a = {2, 5, 8, 12, 16, 23, 38};
            System.out.println(find(a, 2, 0, 6));
        }
    }

    static class C19 {
        static int fib(int n) {
            System.out.print("*");
            if (n <= 1) {
                return n;
            }
            return fib(n - 1) + fib(n - 2);
        }
        static void run() {
            System.out.println(fib(4));
        }
    }

    static class C20 {
        static int find(int[] a, int target, int lo, int hi) {
            System.out.print("*");
            if (lo > hi) {
                return -1;
            }
            int mid = (lo + hi) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[mid] < target) {
                return find(a, target, mid + 1, hi);
            }
            return find(a, target, lo, mid - 1);
        }
        static void run() {
            int[] a = {2, 5, 8, 12, 16, 23, 38};
            System.out.println(find(a, 23, 0, 6));
        }
    }

    static class C21 {
        static int fib(int n) {
            System.out.print("*");
            if (n <= 1) {
                return n;
            }
            return fib(n - 1) + fib(n - 2);
        }
        static void run() {
            System.out.println(fib(5));
        }
    }

    static class C22 {
        static int find(int[] a, int target, int lo, int hi) {
            System.out.print("*");
            if (lo > hi) {
                return -1;
            }
            int mid = (lo + hi) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[mid] < target) {
                return find(a, target, mid + 1, hi);
            }
            return find(a, target, lo, mid - 1);
        }
        static void run() {
            int[] a = {2, 5, 8, 12, 16, 23, 38};
            System.out.println(find(a, 2, 0, 6));
        }
    }

    static class C24 {
        static int sum(int n) {
            if (n == 0) {
                return 0;
            }
            sum(n - 1);
            return n;
        }
        static void run() {
            System.out.println(sum(3));
        }
    }

    static class C25 {
        static void p(int n) {
            if (n > 0) {
                p(n - 1);
                System.out.print(n);
                p(n - 1);
            }
        }
        static void run() {
            p(3);
            System.out.println();
        }
    }

    static class C26 {
        static String stars(int n) {
            if (n == 0) {
                return "";
            }
            return "*" + stars(n - 1);
        }
        static void run() {
            System.out.println(stars(3));
        }
    }

    static class C27 {
        static int sumList(ArrayList<Integer> list, int i) {
            if (i == list.size()) {
                return 0;
            }
            return list.get(i) + sumList(list, i + 1);
        }
        static void run() {
            ArrayList<Integer> nums = new ArrayList<Integer>();
            nums.add(4);
            nums.add(6);
            System.out.println(sumList(nums, 0));
        }
    }

    static class C28 {
        static int f(int[] a, int i) {
            return a[i] + f(a, i + 1);
        }
        static void run() {
            int[] v = {1, 2};
            System.out.println(f(v, 0));
        }
    }

    static class C30 {
        static int fact(int n) {
            if (n <= 1) {
                return 1;
            }
            return n * fact(n - 1);
        }
        static void run() {
            System.out.println(fact(13));
        }
    }

    static class C31 {
        static boolean isPal(String s) {
            if (s.length() <= 1) {
                return true;
            }
            if (!s.substring(0, 1).equals(s.substring(s.length() - 1))) {
                return false;
            }
            return isPal(s.substring(1, s.length() - 1));
        }
        static void run() {
            System.out.println(isPal("racecar") + " " + isPal("ab"));
        }
    }

    static class C32 {
        static int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }
        static void run() {
            System.out.println(gcd(48, 18));
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
        check("static int fact(int n) {\n    if (n <= 1) {\n        return 1;\n    }\n    return n * fact(n - 1);\n}\n\nSystem.out.println(fact(4));", "24\n", C0::run);
        check("static void down(int n) {\n    if (n == 0) {\n        return;\n    }\n    System.out.print(n + \" \");\n    down(n - 1);\n}\n\ndown(3);", "3 2 1 ", C1::run);
        check("static void up(int n) {\n    if (n == 0) {\n        return;\n    }\n    up(n - 1);\n    System.out.print(n + \" \");\n}\n\nup(3);", "1 2 3 ", C2::run);
        check("static void both(int n) {\n    if (n == 0) {\n        return;\n    }\n    System.out.print(n);\n    both(n - 1);\n    System.out.print(n);\n}\n\nboth(3);\nSystem.out.println();", "321123\n", C3::run);
        check("static int sum(int n) {\n    if (n == 0) {\n        return 0;\n    }\n    int rest = sum(n - 1);\n    return n + rest;\n}\n\nSystem.out.println(sum(3));", "6\n", C4::run);
        check("static String rev(String s) {\n    if (s.length() <= 1) {\n        return s;\n    }\n    return rev(s.substring(1)) + s.substring(0, 1);\n}\n\nSystem.out.println(rev(\"abc\"));", "cba\n", C5::run);
        check("static int fib(int n) {\n    if (n <= 1) {\n        return n;\n    }\n    return fib(n - 1) + fib(n - 2);\n}\n\nSystem.out.println(fib(4));", "3\n", C6::run);
        check("static int digitSum(int n) {\n    if (n < 10) {\n        return n;\n    }\n    return digitSum(n / 10) + n % 10;\n}\n\nSystem.out.println(digitSum(1234));", "10\n", C7::run);
        check("static int find(int[] a, int target, int lo, int hi) {\n    if (lo > hi) {\n        return -1;\n    }\n    int mid = (lo + hi) / 2;\n    if (a[mid] == target) {\n        return mid;\n    }\n    if (a[mid] < target) {\n        return find(a, target, mid + 1, hi);\n    }\n    return find(a, target, lo, mid - 1);\n}\n\nint[] a = {2, 5, 8, 12, 16, 23, 38};\nSystem.out.println(find(a, 23, 0, 6));", "5\n", C9::run);
        check("static int total(int[] a, int i) {\n    if (i == a.length) {\n        return 0;\n    }\n    return a[i] + total(a, i + 1);\n}\n\nint[] v = {3, 1, 4};\nSystem.out.println(total(v, 0));", "8\n", C10::run);
        check("static int power(int b, int e) {\n    if (e == 0) {\n        return 1;\n    }\n    return b * power(b, e - 1);\n}\n\nSystem.out.println(power(2, 5));", "32\n", C11::run);
        check("static void pattern(int n) {\n    if (n <= 0) {\n        return;\n    }\n    System.out.print(n);\n    pattern(n - 2);\n    System.out.print(n);\n}\n\npattern(5);\nSystem.out.println();", "531135\n", C12::run);
        check("static int fib(int n) {\n    if (n <= 1) {\n        return n;\n    }\n    return fib(n - 1) + fib(n - 2);\n}\n\nSystem.out.println(fib(5));", "5\n", C13::run);
        check("static int countA(String s) {\n    if (s.length() == 0) {\n        return 0;\n    }\n    int rest = countA(s.substring(1));\n    if (s.substring(0, 1).equals(\"a\")) {\n        return 1 + rest;\n    }\n    return rest;\n}\n\nSystem.out.println(countA(\"banana\"));", "3\n", C14::run);
        check("static int countA(String s) {\n    if (s.length() == 0) {\n        return 0;\n    }\n    int rest = countA(s.substring(1));\n    if (s.substring(0, 1).equals(\"a\")) {\n        return 1 + rest;\n    }\n    return rest;\n}\n\nSystem.out.println(countA(\"abc\"));", "1\n", C15::run);
        check("static int digits(int n) {\n    if (n < 10) {\n        return 1;\n    }\n    return 1 + digits(n / 10);\n}\n\nSystem.out.println(digits(40521));", "5\n", C17::run);
        check("static int find(int[] a, int target, int lo, int hi) {\n    if (lo > hi) {\n        return -1;\n    }\n    int mid = (lo + hi) / 2;\n    if (a[mid] == target) {\n        return mid;\n    }\n    if (a[mid] < target) {\n        return find(a, target, mid + 1, hi);\n    }\n    return find(a, target, lo, mid - 1);\n}\n\nint[] a = {2, 5, 8, 12, 16, 23, 38};\nSystem.out.println(find(a, 2, 0, 6));", "0\n", C18::run);
        check("static int fib(int n) {\n    System.out.print(\"*\");\n    if (n <= 1) {\n        return n;\n    }\n    return fib(n - 1) + fib(n - 2);\n}\n\nSystem.out.println(fib(4));", "*********3\n", C19::run);
        check("static int find(int[] a, int target, int lo, int hi) {\n    System.out.print(\"*\");\n    if (lo > hi) {\n        return -1;\n    }\n    int mid = (lo + hi) / 2;\n    if (a[mid] == target) {\n        return mid;\n    }\n    if (a[mid] < target) {\n        return find(a, target, mid + 1, hi);\n    }\n    return find(a, target, lo, mid - 1);\n}\n\nint[] a = {2, 5, 8, 12, 16, 23, 38};\nSystem.out.println(find(a, 23, 0, 6));", "**5\n", C20::run);
        check("static int fib(int n) {\n    System.out.print(\"*\");\n    if (n <= 1) {\n        return n;\n    }\n    return fib(n - 1) + fib(n - 2);\n}\n\nSystem.out.println(fib(5));", "***************5\n", C21::run);
        check("static int find(int[] a, int target, int lo, int hi) {\n    System.out.print(\"*\");\n    if (lo > hi) {\n        return -1;\n    }\n    int mid = (lo + hi) / 2;\n    if (a[mid] == target) {\n        return mid;\n    }\n    if (a[mid] < target) {\n        return find(a, target, mid + 1, hi);\n    }\n    return find(a, target, lo, mid - 1);\n}\n\nint[] a = {2, 5, 8, 12, 16, 23, 38};\nSystem.out.println(find(a, 2, 0, 6));", "***0\n", C22::run);
        check("static int sum(int n) {\n    if (n == 0) {\n        return 0;\n    }\n    sum(n - 1);\n    return n;\n}\n\nSystem.out.println(sum(3));", "3\n", C24::run);
        check("static void p(int n) {\n    if (n > 0) {\n        p(n - 1);\n        System.out.print(n);\n        p(n - 1);\n    }\n}\n\np(3);\nSystem.out.println();", "1213121\n", C25::run);
        check("static String stars(int n) {\n    if (n == 0) {\n        return \"\";\n    }\n    return \"*\" + stars(n - 1);\n}\n\nSystem.out.println(stars(3));", "***\n", C26::run);
        check("static int sumList(ArrayList<Integer> list, int i) {\n    if (i == list.size()) {\n        return 0;\n    }\n    return list.get(i) + sumList(list, i + 1);\n}\n\nArrayList<Integer> nums = new ArrayList<Integer>();\nnums.add(4);\nnums.add(6);\nSystem.out.println(sumList(nums, 0));", "10\n", C27::run);
        check("static int f(int[] a, int i) {\n    return a[i] + f(a, i + 1);\n}\n\nint[] v = {1, 2};\nSystem.out.println(f(v, 0));", "|throws:ArrayIndexOutOfBoundsException", C28::run);
        check("static int fact(int n) {\n    if (n <= 1) {\n        return 1;\n    }\n    return n * fact(n - 1);\n}\n\nSystem.out.println(fact(13));", "1932053504\n", C30::run);
        check("static boolean isPal(String s) {\n    if (s.length() <= 1) {\n        return true;\n    }\n    if (!s.substring(0, 1).equals(s.substring(s.length() - 1))) {\n        return false;\n    }\n    return isPal(s.substring(1, s.length() - 1));\n}\n\nSystem.out.println(isPal(\"racecar\") + \" \" + isPal(\"ab\"));", "true false\n", C31::run);
        check("static int gcd(int a, int b) {\n    if (b == 0) {\n        return a;\n    }\n    return gcd(b, a % b);\n}\n\nSystem.out.println(gcd(48, 18));", "6\n", C32::run);
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        if (javac == null) throw new IllegalStateException("A JDK is needed to check compile claims.");
        compileCheck(javac, "static int count(int n) {\n    return 1 + count(n - 1);\n}\n\nSystem.out.println(count(3));", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic int count(int n) {\n    return 1 + count(n - 1);\n}\nstatic void run() {\n\nSystem.out.println(count(3));\n}\n}", true);
        compileCheck(javac, "static int down2(int n) {\n    if (n == 0) {\n        return 0;\n    }\n    return down2(n - 2);\n}\n\nSystem.out.println(down2(5));", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic int down2(int n) {\n    if (n == 0) {\n        return 0;\n    }\n    return down2(n - 2);\n}\nstatic void run() {\n\nSystem.out.println(down2(5));\n}\n}", true);
        compileCheck(javac, "static int f(int n) {\n    if (n == 0) {\n        return 0;\n    }\n    f(n - 1);\n}\n\nSystem.out.println(f(3));", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic int f(int n) {\n    if (n == 0) {\n        return 0;\n    }\n    f(n - 1);\n}\nstatic void run() {\n\nSystem.out.println(f(3));\n}\n}", false);
        compileCheck(javac, "static int calls = 0;\n\nstatic int fact(int n) {\n    calls++;\n    if (n <= 1) {\n        return 1;\n    }\n    return n * fact(n - 1);\n}\n\nSystem.out.println(fact(3));", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic int calls = 0;\nstatic int fact(int n) {\n    calls++;\n    if (n <= 1) {\n        return 1;\n    }\n    return n * fact(n - 1);\n}\nstatic void run() {\n\n\nSystem.out.println(fact(3));\n}\n}", true);
        System.out.println(failed == 0 ? "PASS: " + passed + " programs match Java " + System.getProperty("java.version") : failed + " of " + (passed + failed) + " programs differ");
    }
}
