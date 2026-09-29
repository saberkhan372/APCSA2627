// Generated from boolean-cases.json by mj-java.mjs. Do not edit by hand.
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

public class BooleanCheck {
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
            int x = 5;
            int y = 4;
            System.out.println(x > 3 && y < 2);
        }
    }

    static class C1 {
        
        static void run() {
            int x = 0;
            int y = 10;
            System.out.println(x != 0 && y / x > 1);
        }
    }

    static class C2 {
        
        static void run() {
            int x = 0;
            int y = 10;
            System.out.println(y / x > 1 && x != 0);
        }
    }

    static class C3 {
        
        static void run() {
            String s = null;
            System.out.println(s != null && s.length() > 3);
        }
    }

    static class C4 {
        
        static void run() {
            String s = null;
            System.out.println(s.length() > 3 && s != null);
        }
    }

    static class C5 {
        
        static void run() {
            String s = null;
            System.out.println(s == null || s.length() == 0);
        }
    }

    static class C6 {
        
        static void run() {
            int x = 20;
            System.out.println(x >= 10 && x <= 20);
        }
    }

    static class C7 {
        
        static void run() {
            boolean a = false;
            boolean b = true;
            System.out.println(!(a || b));
        }
    }

    static class C8 {
        
        static void run() {
            int x = 8;
            int y = 8;
            System.out.println(x > 5 || y / 0 > 1);
        }
    }

    static class C9 {
        
        static void run() {
            int x = 3;
            int y = 8;
            System.out.println(x > 5 || y / 0 > 1);
        }
    }

    static class C10 {
        
        static void run() {
            String name = "";
            System.out.println(name != null && name.length() > 0);
        }
    }

    static class C11 {
        
        static void run() {
            int n = 7;
            System.out.println(n % 2 == 0 || n > 5 && n < 10);
        }
    }

    static class C12 {
        
        static void run() {
            boolean a = true;
            boolean b = false;
            System.out.println(!a || !b);
        }
    }

    static class C13 {
        
        static void run() {
            boolean a = true;
            boolean b = false;
            System.out.println(!(a && b));
        }
    }

    static class C14 {
        
        static void run() {
            int x = 6;
            int y = 3;
            System.out.println(!(x > 5 && y == 3));
        }
    }

    static class C15 {
        
        static void run() {
            int x = 6;
            int y = 3;
            System.out.println(x < 5 || y != 3);
        }
    }

    static class C16 {
        
        static void run() {
            int diff = 0;
            for (int x = -2; x <= 10; x++) {
                for (int y = -2; y <= 10; y++) {
                    if ((!(x > 5 && y == 3)) != (x <= 5 || y != 3)) {
                        diff++;
                    }
                }
            }
            System.out.println(diff);
        }
    }

    static class C17 {
        
        static void run() {
            int diff = 0;
            for (int x = -2; x <= 10; x++) {
                for (int y = -2; y <= 10; y++) {
                    if ((!(x > 5 && y == 3)) != (x <= 5 && y != 3)) {
                        diff++;
                    }
                }
            }
            System.out.println(diff);
        }
    }

    static class C18 {
        
        static void run() {
            int diff = 0;
            for (int x = -2; x <= 10; x++) {
                for (int y = -2; y <= 10; y++) {
                    if ((!(x > 5 && y == 3)) != (x < 5 || y != 3)) {
                        diff++;
                    }
                }
            }
            System.out.println(diff);
        }
    }

    static class C19 {
        
        static void run() {
            int diff = 0;
            for (int x = -2; x <= 10; x++) {
                for (int y = -2; y <= 10; y++) {
                    if ((!(x > 5 && y == 3)) != (!(x > 5) && !(y == 3))) {
                        diff++;
                    }
                }
            }
            System.out.println(diff);
        }
    }

    static class C20 {
        
        static void run() {
            int diff = 0;
            for (int x = -2; x <= 10; x++) {
                for (int y = -2; y <= 10; y++) {
                    if ((!(x < 3 || y >= 7)) != (x >= 3 && y < 7)) {
                        diff++;
                    }
                }
            }
            System.out.println(diff);
        }
    }

    static class C21 {
        
        static void run() {
            int diff = 0;
            for (int x = -2; x <= 10; x++) {
                for (int y = -2; y <= 10; y++) {
                    if ((!(x < 3 || y >= 7)) != (x >= 3 || y < 7)) {
                        diff++;
                    }
                }
            }
            System.out.println(diff);
        }
    }

    static class C22 {
        
        static void run() {
            int diff = 0;
            for (int x = -2; x <= 10; x++) {
                for (int y = -2; y <= 10; y++) {
                    if ((!(x < 3 || y >= 7)) != (x > 3 && y < 7)) {
                        diff++;
                    }
                }
            }
            System.out.println(diff);
        }
    }

    static class C23 {
        
        static void run() {
            int diff = 0;
            for (int x = -2; x <= 10; x++) {
                for (int y = -2; y <= 10; y++) {
                    if ((!(x < 3 || y >= 7)) != (!(x < 3) || !(y >= 7))) {
                        diff++;
                    }
                }
            }
            System.out.println(diff);
        }
    }

    static class C24 {
        
        static void run() {
            int a = 0;
            int b = 5;
            if (a > 0)
                if (b < 0)
                    System.out.println("x");
            else
                System.out.println("y");
            System.out.println("done");
        }
    }

    static class C25 {
        
        static void run() {
            int score = 95;
            String grade = "F";
            if (score >= 90) {
                grade = "A";
            }
            if (score >= 80) {
                grade = "B";
            }
            if (score >= 70) {
                grade = "C";
            }
            System.out.println(grade);
        }
    }

    static class C26 {
        
        static void run() {
            int score = 95;
            String grade = "F";
            if (score >= 90) {
                grade = "A";
            } else if (score >= 80) {
                grade = "B";
            } else if (score >= 70) {
                grade = "C";
            }
            System.out.println(grade);
        }
    }

    static class C27 {
        
        static void run() {
            int t = 75;
            if (t >= 80) {
                System.out.println("hot");
            } else if (t >= 60) {
                System.out.println("mild");
            } else {
                System.out.println("cold");
            }
        }
    }

    static class C28 {
        
        static void run() {
            int a = 5;
            int b = -1;
            if (a > 0)
                if (b > 0)
                    System.out.println("both");
                else
                    System.out.println("only a");
            System.out.println("end");
        }
    }

    static class C29 {
        
        static void run() {
            int n = 15;
            if (n % 3 == 0) {
                System.out.print("Fizz");
            }
            if (n % 5 == 0) {
                System.out.print("Buzz");
            }
            System.out.println();
        }
    }

    static class C30 {
        static boolean t(String s) {
            System.out.print(s);
            return true;
        }
        
        static boolean f(String s) {
            System.out.print(s);
            return false;
        }
        static void run() {
            if (f("a") && t("b")) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

    static class C31 {
        static boolean t(String s) {
            System.out.print(s);
            return true;
        }
        
        static boolean f(String s) {
            System.out.print(s);
            return false;
        }
        static void run() {
            if (t("a") || t("b")) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

    static class C32 {
        static boolean t(String s) {
            System.out.print(s);
            return true;
        }
        
        static boolean f(String s) {
            System.out.print(s);
            return false;
        }
        static void run() {
            if (f("a") || t("b") && f("c")) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

    static class C33 {
        static boolean t(String s) {
            System.out.print(s);
            return true;
        }
        
        static boolean f(String s) {
            System.out.print(s);
            return false;
        }
        static void run() {
            if (t("a") && t("b") || t("c")) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

    static class C34 {
        static boolean t(String s) {
            System.out.print(s);
            return true;
        }
        
        static boolean f(String s) {
            System.out.print(s);
            return false;
        }
        static void run() {
            if (!f("a") && t("b")) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

    static class C35 {
        static boolean t(String s) {
            System.out.print(s);
            return true;
        }
        
        static boolean f(String s) {
            System.out.print(s);
            return false;
        }
        static void run() {
            boolean r = f("a") && t("b") || f("c") && t("d");
            System.out.println(r);
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
        check("int x = 5;\nint y = 4;\nSystem.out.println(x > 3 && y < 2);", "false\n", C0::run);
        check("int x = 0;\nint y = 10;\nSystem.out.println(x != 0 && y / x > 1);", "false\n", C1::run);
        check("int x = 0;\nint y = 10;\nSystem.out.println(y / x > 1 && x != 0);", "|throws:ArithmeticException", C2::run);
        check("String s = null;\nSystem.out.println(s != null && s.length() > 3);", "false\n", C3::run);
        check("String s = null;\nSystem.out.println(s.length() > 3 && s != null);", "|throws:NullPointerException", C4::run);
        check("String s = null;\nSystem.out.println(s == null || s.length() == 0);", "true\n", C5::run);
        check("int x = 20;\nSystem.out.println(x >= 10 && x <= 20);", "true\n", C6::run);
        check("boolean a = false;\nboolean b = true;\nSystem.out.println(!(a || b));", "false\n", C7::run);
        check("int x = 8;\nint y = 8;\nSystem.out.println(x > 5 || y / 0 > 1);", "true\n", C8::run);
        check("int x = 3;\nint y = 8;\nSystem.out.println(x > 5 || y / 0 > 1);", "|throws:ArithmeticException", C9::run);
        check("String name = \"\";\nSystem.out.println(name != null && name.length() > 0);", "false\n", C10::run);
        check("int n = 7;\nSystem.out.println(n % 2 == 0 || n > 5 && n < 10);", "true\n", C11::run);
        check("boolean a = true;\nboolean b = false;\nSystem.out.println(!a || !b);", "true\n", C12::run);
        check("boolean a = true;\nboolean b = false;\nSystem.out.println(!(a && b));", "true\n", C13::run);
        check("int x = 6;\nint y = 3;\nSystem.out.println(!(x > 5 && y == 3));", "false\n", C14::run);
        check("int x = 6;\nint y = 3;\nSystem.out.println(x < 5 || y != 3);", "false\n", C15::run);
        check("int diff = 0;\nfor (int x = -2; x <= 10; x++) {\n    for (int y = -2; y <= 10; y++) {\n        if ((!(x > 5 && y == 3)) != (x <= 5 || y != 3)) {\n            diff++;\n        }\n    }\n}\nSystem.out.println(diff);", "0\n", C16::run);
        check("int diff = 0;\nfor (int x = -2; x <= 10; x++) {\n    for (int y = -2; y <= 10; y++) {\n        if ((!(x > 5 && y == 3)) != (x <= 5 && y != 3)) {\n            diff++;\n        }\n    }\n}\nSystem.out.println(diff);", "68\n", C17::run);
        check("int diff = 0;\nfor (int x = -2; x <= 10; x++) {\n    for (int y = -2; y <= 10; y++) {\n        if ((!(x > 5 && y == 3)) != (x < 5 || y != 3)) {\n            diff++;\n        }\n    }\n}\nSystem.out.println(diff);", "1\n", C18::run);
        check("int diff = 0;\nfor (int x = -2; x <= 10; x++) {\n    for (int y = -2; y <= 10; y++) {\n        if ((!(x > 5 && y == 3)) != (!(x > 5) && !(y == 3))) {\n            diff++;\n        }\n    }\n}\nSystem.out.println(diff);", "68\n", C19::run);
        check("int diff = 0;\nfor (int x = -2; x <= 10; x++) {\n    for (int y = -2; y <= 10; y++) {\n        if ((!(x < 3 || y >= 7)) != (x >= 3 && y < 7)) {\n            diff++;\n        }\n    }\n}\nSystem.out.println(diff);", "0\n", C20::run);
        check("int diff = 0;\nfor (int x = -2; x <= 10; x++) {\n    for (int y = -2; y <= 10; y++) {\n        if ((!(x < 3 || y >= 7)) != (x >= 3 || y < 7)) {\n            diff++;\n        }\n    }\n}\nSystem.out.println(diff);", "77\n", C21::run);
        check("int diff = 0;\nfor (int x = -2; x <= 10; x++) {\n    for (int y = -2; y <= 10; y++) {\n        if ((!(x < 3 || y >= 7)) != (x > 3 && y < 7)) {\n            diff++;\n        }\n    }\n}\nSystem.out.println(diff);", "9\n", C22::run);
        check("int diff = 0;\nfor (int x = -2; x <= 10; x++) {\n    for (int y = -2; y <= 10; y++) {\n        if ((!(x < 3 || y >= 7)) != (!(x < 3) || !(y >= 7))) {\n            diff++;\n        }\n    }\n}\nSystem.out.println(diff);", "77\n", C23::run);
        check("int a = 0;\nint b = 5;\nif (a > 0)\n    if (b < 0)\n        System.out.println(\"x\");\nelse\n    System.out.println(\"y\");\nSystem.out.println(\"done\");", "done\n", C24::run);
        check("int score = 95;\nString grade = \"F\";\nif (score >= 90) {\n    grade = \"A\";\n}\nif (score >= 80) {\n    grade = \"B\";\n}\nif (score >= 70) {\n    grade = \"C\";\n}\nSystem.out.println(grade);", "C\n", C25::run);
        check("int score = 95;\nString grade = \"F\";\nif (score >= 90) {\n    grade = \"A\";\n} else if (score >= 80) {\n    grade = \"B\";\n} else if (score >= 70) {\n    grade = \"C\";\n}\nSystem.out.println(grade);", "A\n", C26::run);
        check("int t = 75;\nif (t >= 80) {\n    System.out.println(\"hot\");\n} else if (t >= 60) {\n    System.out.println(\"mild\");\n} else {\n    System.out.println(\"cold\");\n}", "mild\n", C27::run);
        check("int a = 5;\nint b = -1;\nif (a > 0)\n    if (b > 0)\n        System.out.println(\"both\");\n    else\n        System.out.println(\"only a\");\nSystem.out.println(\"end\");", "only a\nend\n", C28::run);
        check("int n = 15;\nif (n % 3 == 0) {\n    System.out.print(\"Fizz\");\n}\nif (n % 5 == 0) {\n    System.out.print(\"Buzz\");\n}\nSystem.out.println();", "FizzBuzz\n", C29::run);
        check("static boolean t(String s) {\n    System.out.print(s);\n    return true;\n}\n\nstatic boolean f(String s) {\n    System.out.print(s);\n    return false;\n}\n\nif (f(\"a\") && t(\"b\")) {\n    System.out.print(\"X\");\n}\nSystem.out.println();", "a\n", C30::run);
        check("static boolean t(String s) {\n    System.out.print(s);\n    return true;\n}\n\nstatic boolean f(String s) {\n    System.out.print(s);\n    return false;\n}\n\nif (t(\"a\") || t(\"b\")) {\n    System.out.print(\"X\");\n}\nSystem.out.println();", "aX\n", C31::run);
        check("static boolean t(String s) {\n    System.out.print(s);\n    return true;\n}\n\nstatic boolean f(String s) {\n    System.out.print(s);\n    return false;\n}\n\nif (f(\"a\") || t(\"b\") && f(\"c\")) {\n    System.out.print(\"X\");\n}\nSystem.out.println();", "abc\n", C32::run);
        check("static boolean t(String s) {\n    System.out.print(s);\n    return true;\n}\n\nstatic boolean f(String s) {\n    System.out.print(s);\n    return false;\n}\n\nif (t(\"a\") && t(\"b\") || t(\"c\")) {\n    System.out.print(\"X\");\n}\nSystem.out.println();", "abX\n", C33::run);
        check("static boolean t(String s) {\n    System.out.print(s);\n    return true;\n}\n\nstatic boolean f(String s) {\n    System.out.print(s);\n    return false;\n}\n\nif (!f(\"a\") && t(\"b\")) {\n    System.out.print(\"X\");\n}\nSystem.out.println();", "abX\n", C34::run);
        check("static boolean t(String s) {\n    System.out.print(s);\n    return true;\n}\n\nstatic boolean f(String s) {\n    System.out.print(s);\n    return false;\n}\n\nboolean r = f(\"a\") && t(\"b\") || f(\"c\") && t(\"d\");\nSystem.out.println(r);", "acfalse\n", C35::run);
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        if (javac == null) throw new IllegalStateException("A JDK is needed to check compile claims.");
        compileCheck(javac, "int x = 5;\nSystem.out.println(x > 3 && 7);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic void run() {\nint x = 5;\nSystem.out.println(x > 3 && 7);\n}\n}", false);
        compileCheck(javac, "int x = 5;\nif (x = 5) {\n}", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic void run() {\nint x = 5;\nif (x = 5) {\n}\n}\n}", false);
        compileCheck(javac, "boolean done = false;\nif (done = true) {\n    System.out.println(\"yes\");\n}", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic void run() {\nboolean done = false;\nif (done = true) {\n    System.out.println(\"yes\");\n}\n}\n}", true);
        compileCheck(javac, "String s = \"a\";\nString t = \"a\";\nSystem.out.println(s == t);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic void run() {\nString s = \"a\";\nString t = \"a\";\nSystem.out.println(s == t);\n}\n}", true);
        compileCheck(javac, "int x = 5;\nSystem.out.println(x > 3 & x < 9);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic void run() {\nint x = 5;\nSystem.out.println(x > 3 & x < 9);\n}\n}", true);
        compileCheck(javac, "int x = 5;\nSystem.out.println(x > 3 ? 1 : 2);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\nstatic void run() {\nint x = 5;\nSystem.out.println(x > 3 ? 1 : 2);\n}\n}", true);
        System.out.println(failed == 0 ? "PASS: " + passed + " programs match Java " + System.getProperty("java.version") : failed + " of " + (passed + failed) + " programs differ");
    }
}
