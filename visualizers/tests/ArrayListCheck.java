// Generated from arraylist-cases.json by mj-java.mjs. Do not edit by hand.
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

public class ArrayListCheck {
    static class Player {
        private String name;
        private int score;
        public Player(String startName, int startScore) { name = startName; score = startScore; }
        public String getName() { return name; }
        public int getScore() { return score; }
        public void addScore(int amount) { score += amount; }
    }

    static class C0 {

        static void run() {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(10);
            list.add(20);
            list.add(1);
            list.remove(1);
            System.out.println(list);
        }
    }

    static class C1 {

        static void run() {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(10);
            list.add(20);
            list.add(1);
            list.remove(Integer.valueOf(1));
            System.out.println(list);
        }
    }

    static class C2 {

        static void run() {
            ArrayList<String> w = new ArrayList<String>();
            w.add("a");
            w.add("b");
            w.add("c");
            w.add(1, "x");
            System.out.println(w.get(2) + " " + w.size());
        }
    }

    static class C3 {

        static void run() {
            ArrayList<String> w = new ArrayList<String>();
            w.add("a");
            w.add("b");
            w.add("c");
            w.set(1, "x");
            System.out.println(w + " " + w.size());
        }
    }

    static class C4 {

        static void run() {
            ArrayList<Integer> nums = new ArrayList<Integer>();
            nums.add(2);
            nums.add(4);
            nums.add(5);
            nums.add(6);
            nums.add(8);
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) % 2 == 0) {
                    nums.remove(i);
                }
            }
            System.out.println(nums);
        }
    }

    static class C5 {

        static void run() {
            ArrayList<Integer> nums = new ArrayList<Integer>();
            nums.add(2);
            nums.add(4);
            nums.add(5);
            nums.add(6);
            nums.add(8);
            for (int i = nums.size() - 1; i >= 0; i--) {
                if (nums.get(i) % 2 == 0) {
                    nums.remove(i);
                }
            }
            System.out.println(nums);
        }
    }

    static class C6 {

        static void run() {
            ArrayList<Integer> nums = new ArrayList<Integer>();
            nums.add(2);
            nums.add(4);
            nums.add(5);
            nums.add(6);
            nums.add(8);
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) % 2 == 0) {
                    nums.remove(i);
                    i--;
                }
            }
            System.out.println(nums);
        }
    }

    static class C7 {

        static void run() {
            ArrayList<String> w = new ArrayList<String>();
            w.add("a");
            w.add("b");
            w.add("c");
            for (String s : w) {
                if (s.equals("a")) {
                    w.remove(s);
                }
            }
            System.out.println(w);
        }
    }

    static class C8 {

        static void run() {
            ArrayList<String> w = new ArrayList<String>();
            w.add("a");
            w.add("b");
            w.add("c");
            for (String s : w) {
                if (s.equals("b")) {
                    w.remove(s);
                }
            }
            System.out.println(w);
        }
    }

    static class C9 {

        static void run() {
            ArrayList<Integer> v = new ArrayList<Integer>();
            for (int i = 1; i <= 5; i++) {
                v.add(i);
            }
            v.remove(1);
            v.remove(1);
            System.out.println(v);
        }
    }

    static class C10 {

        static void run() {
            ArrayList<Integer> v = new ArrayList<Integer>();
            v.add(1);
            v.add(2);
            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) < 3) {
                    v.add(v.get(i) + 3);
                }
            }
            System.out.println(v);
        }
    }

    static class C11 {

        static void run() {
            ArrayList<String> w = new ArrayList<String>();
            w.add("a");
            w.add("a");
            w.add("b");
            w.add("a");
            for (int i = 0; i < w.size(); i++) {
                if (w.get(i).equals("a")) {
                    w.remove(i);
                }
            }
            System.out.println(w);
        }
    }

    static class C12 {

        static void run() {
            ArrayList<String> w = new ArrayList<String>();
            w.add("a");
            w.add("a");
            w.add("b");
            w.add("a");
            for (int i = w.size() - 1; i >= 0; i--) {
                if (w.get(i).equals("a")) {
                    w.remove(i);
                }
            }
            System.out.println(w);
        }
    }

    static class C13 {

        static void run() {
            ArrayList<Integer> v = new ArrayList<Integer>();
            v.add(2);
            v.add(3);
            v.add(2);
            v.add(4);
            v.remove(2);
            System.out.println(v);
        }
    }

    static class C14 {

        static void run() {
            ArrayList<Integer> v = new ArrayList<Integer>();
            v.add(7);
            v.add(3);
            v.add(9);
            v.add(1);
            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) > 5) {
                    v.remove(i);
                }
            }
            System.out.println(v);
        }
    }

    static class C15 {

        static void run() {
            ArrayList<String> w = new ArrayList<String>();
            w.add(0, "x");
            w.add(0, "y");
            w.add(0, "z");
            w.add(1, "q");
            System.out.println(w);
        }
    }

    static class C16 {

        static void run() {
            ArrayList<Integer> v = new ArrayList<Integer>();
            v.add(1);
            v.add(2);
            for (int x : v) {
                v.add(x);
            }
            System.out.println(v);
        }
    }

    static class C17 {

        static void run() {
            ArrayList<String> w = new ArrayList<String>();
            w.add("a");
            w.add("b");
            w.add("c");
            String old = w.set(1, "z");
            System.out.println(old + " " + w);
        }
    }

    static class C18 {

        static void run() {
            ArrayList<Integer> v = new ArrayList<Integer>();
            v.add(7);
            v.add(8);
            v.add(9);
            int r = v.remove(0);
            System.out.println(r + " " + v + " " + v.get(0));
        }
    }

    static class C19 {

        static void run() {
            ArrayList<Integer> v = new ArrayList<Integer>();
            v.add(4);
            v.add(5);
            System.out.println(v.remove("a") + " " + v);
        }
    }

    static class C26 {

        static void run() {
            ArrayList<Integer> v = new ArrayList<Integer>();
            v.add(4);
            v.add(5);
            System.out.println(v.get(2));
        }
    }

    static class C27 {

        static void run() {
            ArrayList<Integer> v = new ArrayList<Integer>();
            v.add(4);
            v.add(5);
            v.add(3, 9);
        }
    }

    static class C28 {

        static void run() {
            ArrayList<Integer> v = new ArrayList<Integer>();
            v.add(4);
            v.add(5);
            v.add(2, 9);
            System.out.println(v);
        }
    }

    static class C30 {

        static void run() {
            ArrayList<Integer> v = new ArrayList<Integer>();
            v.add(4);
            v.add(5);
            v.remove(Integer.valueOf(7));
            System.out.println(v);
        }
    }

    static class C31 {

        static void run() {
            ArrayList<Double> d = new ArrayList<Double>();
            d.add(1.5);
            d.add(2.0);
            d.remove(0);
            System.out.println(d);
        }
    }

    static class C32 {

        static void run() {
            ArrayList<String> w = new ArrayList<String>();
            w.add("x");
            String s = w.get(0) + w.size();
            System.out.println(s);
        }
    }

    static class C33 {

        static void run() {
            ArrayList<Integer> v = new ArrayList<Integer>();
            v.add(4);
            v.add(5);
            v.remove(-1);
        }
    }

    static class C34 {

        static void run() {
            ArrayList<Integer> v = new ArrayList<Integer>();
            v.add(4);
            v.add(5);
            System.out.println(v.remove(4.0) + " " + v);
        }
    }

    static class C35 {

        static void run() {
            ArrayList<Double> d = new ArrayList<Double>();
            d.add(4.0);
            d.remove(4.0);
            System.out.println(d);
        }
    }

    static class C36 {

        static void run() {
            ArrayList<Integer> v = new ArrayList<Integer>();
            v.add(4);
            v.add(5);
            System.out.println(v.remove(Integer.valueOf(4)) + " " + v);
        }
    }

    static class C37 {

        static void run() {
            Integer x = null;
            int y = x;
            System.out.println(y);
        }
    }

    static class C38 {

        static void run() {
            ArrayList<Integer> a = new ArrayList<Integer>();
            a.add(null);
            for (int x : a) System.out.println(x);
        }
    }

    static class C39 {

        static void run() {
            ArrayList<Double> a = new ArrayList<Double>();
            a.add(-0.0);
            System.out.println(a.remove(0.0));
            System.out.println(a);
        }
    }

    static class C40 {

        static void run() {
            ArrayList<Double> a = new ArrayList<Double>();
            a.add(0.0 / 0.0);
            System.out.println(a.remove(0.0 / 0.0));
            System.out.println(a);
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
        check("ArrayList<Integer> list = new ArrayList<Integer>();\nlist.add(10);\nlist.add(20);\nlist.add(1);\nlist.remove(1);\nSystem.out.println(list);", "[10, 1]\n", C0::run);
        check("ArrayList<Integer> list = new ArrayList<Integer>();\nlist.add(10);\nlist.add(20);\nlist.add(1);\nlist.remove(Integer.valueOf(1));\nSystem.out.println(list);", "[10, 20]\n", C1::run);
        check("ArrayList<String> w = new ArrayList<String>();\nw.add(\"a\");\nw.add(\"b\");\nw.add(\"c\");\nw.add(1, \"x\");\nSystem.out.println(w.get(2) + \" \" + w.size());", "b 4\n", C2::run);
        check("ArrayList<String> w = new ArrayList<String>();\nw.add(\"a\");\nw.add(\"b\");\nw.add(\"c\");\nw.set(1, \"x\");\nSystem.out.println(w + \" \" + w.size());", "[a, x, c] 3\n", C3::run);
        check("ArrayList<Integer> nums = new ArrayList<Integer>();\nnums.add(2);\nnums.add(4);\nnums.add(5);\nnums.add(6);\nnums.add(8);\nfor (int i = 0; i < nums.size(); i++) {\n    if (nums.get(i) % 2 == 0) {\n        nums.remove(i);\n    }\n}\nSystem.out.println(nums);", "[4, 5, 8]\n", C4::run);
        check("ArrayList<Integer> nums = new ArrayList<Integer>();\nnums.add(2);\nnums.add(4);\nnums.add(5);\nnums.add(6);\nnums.add(8);\nfor (int i = nums.size() - 1; i >= 0; i--) {\n    if (nums.get(i) % 2 == 0) {\n        nums.remove(i);\n    }\n}\nSystem.out.println(nums);", "[5]\n", C5::run);
        check("ArrayList<Integer> nums = new ArrayList<Integer>();\nnums.add(2);\nnums.add(4);\nnums.add(5);\nnums.add(6);\nnums.add(8);\nfor (int i = 0; i < nums.size(); i++) {\n    if (nums.get(i) % 2 == 0) {\n        nums.remove(i);\n        i--;\n    }\n}\nSystem.out.println(nums);", "[5]\n", C6::run);
        check("ArrayList<String> w = new ArrayList<String>();\nw.add(\"a\");\nw.add(\"b\");\nw.add(\"c\");\nfor (String s : w) {\n    if (s.equals(\"a\")) {\n        w.remove(s);\n    }\n}\nSystem.out.println(w);", "|throws:ConcurrentModificationException", C7::run);
        check("ArrayList<String> w = new ArrayList<String>();\nw.add(\"a\");\nw.add(\"b\");\nw.add(\"c\");\nfor (String s : w) {\n    if (s.equals(\"b\")) {\n        w.remove(s);\n    }\n}\nSystem.out.println(w);", "[a, c]\n", C8::run);
        check("ArrayList<Integer> v = new ArrayList<Integer>();\nfor (int i = 1; i <= 5; i++) {\n    v.add(i);\n}\nv.remove(1);\nv.remove(1);\nSystem.out.println(v);", "[1, 4, 5]\n", C9::run);
        check("ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(1);\nv.add(2);\nfor (int i = 0; i < v.size(); i++) {\n    if (v.get(i) < 3) {\n        v.add(v.get(i) + 3);\n    }\n}\nSystem.out.println(v);", "[1, 2, 4, 5]\n", C10::run);
        check("ArrayList<String> w = new ArrayList<String>();\nw.add(\"a\");\nw.add(\"a\");\nw.add(\"b\");\nw.add(\"a\");\nfor (int i = 0; i < w.size(); i++) {\n    if (w.get(i).equals(\"a\")) {\n        w.remove(i);\n    }\n}\nSystem.out.println(w);", "[a, b]\n", C11::run);
        check("ArrayList<String> w = new ArrayList<String>();\nw.add(\"a\");\nw.add(\"a\");\nw.add(\"b\");\nw.add(\"a\");\nfor (int i = w.size() - 1; i >= 0; i--) {\n    if (w.get(i).equals(\"a\")) {\n        w.remove(i);\n    }\n}\nSystem.out.println(w);", "[b]\n", C12::run);
        check("ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(2);\nv.add(3);\nv.add(2);\nv.add(4);\nv.remove(2);\nSystem.out.println(v);", "[2, 3, 4]\n", C13::run);
        check("ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(7);\nv.add(3);\nv.add(9);\nv.add(1);\nfor (int i = 0; i < v.size(); i++) {\n    if (v.get(i) > 5) {\n        v.remove(i);\n    }\n}\nSystem.out.println(v);", "[3, 1]\n", C14::run);
        check("ArrayList<String> w = new ArrayList<String>();\nw.add(0, \"x\");\nw.add(0, \"y\");\nw.add(0, \"z\");\nw.add(1, \"q\");\nSystem.out.println(w);", "[z, q, y, x]\n", C15::run);
        check("ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(1);\nv.add(2);\nfor (int x : v) {\n    v.add(x);\n}\nSystem.out.println(v);", "|throws:ConcurrentModificationException", C16::run);
        check("ArrayList<String> w = new ArrayList<String>();\nw.add(\"a\");\nw.add(\"b\");\nw.add(\"c\");\nString old = w.set(1, \"z\");\nSystem.out.println(old + \" \" + w);", "b [a, z, c]\n", C17::run);
        check("ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(7);\nv.add(8);\nv.add(9);\nint r = v.remove(0);\nSystem.out.println(r + \" \" + v + \" \" + v.get(0));", "7 [8, 9] 8\n", C18::run);
        check("ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nSystem.out.println(v.remove(\"a\") + \" \" + v);", "false [4, 5]\n", C19::run);
        check("ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nSystem.out.println(v.get(2));", "|throws:IndexOutOfBoundsException", C26::run);
        check("ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nv.add(3, 9);", "|throws:IndexOutOfBoundsException", C27::run);
        check("ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nv.add(2, 9);\nSystem.out.println(v);", "[4, 5, 9]\n", C28::run);
        check("ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nv.remove(Integer.valueOf(7));\nSystem.out.println(v);", "[4, 5]\n", C30::run);
        check("ArrayList<Double> d = new ArrayList<Double>();\nd.add(1.5);\nd.add(2.0);\nd.remove(0);\nSystem.out.println(d);", "[2.0]\n", C31::run);
        check("ArrayList<String> w = new ArrayList<String>();\nw.add(\"x\");\nString s = w.get(0) + w.size();\nSystem.out.println(s);", "x1\n", C32::run);
        check("ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nv.remove(-1);", "|throws:IndexOutOfBoundsException", C33::run);
        check("ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nSystem.out.println(v.remove(4.0) + \" \" + v);", "false [4, 5]\n", C34::run);
        check("ArrayList<Double> d = new ArrayList<Double>();\nd.add(4.0);\nd.remove(4.0);\nSystem.out.println(d);", "[]\n", C35::run);
        check("ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nSystem.out.println(v.remove(Integer.valueOf(4)) + \" \" + v);", "true [5]\n", C36::run);
        check("Integer x = null;\nint y = x;\nSystem.out.println(y);", "|throws:NullPointerException", C37::run);
        check("ArrayList<Integer> a = new ArrayList<Integer>();\na.add(null);\nfor (int x : a) System.out.println(x);", "|throws:NullPointerException", C38::run);
        check("ArrayList<Double> a = new ArrayList<Double>();\na.add(-0.0);\nSystem.out.println(a.remove(0.0));\nSystem.out.println(a);", "false\n[-0.0]\n", C39::run);
        check("ArrayList<Double> a = new ArrayList<Double>();\na.add(0.0 / 0.0);\nSystem.out.println(a.remove(0.0 / 0.0));\nSystem.out.println(a);", "true\n[]\n", C40::run);
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        if (javac == null) throw new IllegalStateException("A JDK is needed to check compile claims.");
        compileCheck(javac, "ArrayList<int> v = new ArrayList<int>();", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nArrayList<int> v = new ArrayList<int>();\n}\n}", false);
        compileCheck(javac, "ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nSystem.out.println(v.get(1.5));", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nSystem.out.println(v.get(1.5));\n}\n}", false);
        compileCheck(javac, "ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nv.add(\"x\");", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nv.add(\"x\");\n}\n}", false);
        compileCheck(javac, "ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nSystem.out.println(v.size);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nSystem.out.println(v.size);\n}\n}", false);
        compileCheck(javac, "ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nSystem.out.println(v.length());", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nSystem.out.println(v.length());\n}\n}", false);
        compileCheck(javac, "ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nSystem.out.println(v[0]);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nSystem.out.println(v[0]);\n}\n}", false);
        compileCheck(javac, "ArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nSystem.out.println(v.contains(4));", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nArrayList<Integer> v = new ArrayList<Integer>();\nv.add(4);\nv.add(5);\nSystem.out.println(v.contains(4));\n}\n}", true);
        System.out.println(failed == 0 ? "PASS: " + passed + " programs match Java " + System.getProperty("java.version") : failed + " of " + (passed + failed) + " programs differ");
    }
}
