// Generated from boundary-cases.json by mj-java.mjs. Do not edit by hand.
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

public class BoundaryCheck {
    static class Player {
        private String name;
        private int score;
        public Player(String startName, int startScore) { name = startName; score = startScore; }
        public String getName() { return name; }
        public int getScore() { return score; }
        public void addScore(int amount) { score += amount; }
    }

    static class C0 {
        static String grade(int score) {
            if (score > 90) {
                return "A";
            } else if (score >= 80) {
                return "B";
            }
            return "C";
        }
        static void run() {
            for (int p0 = 70; p0 <= 100; p0 += 1) {
                System.out.println(grade(p0));
            }
        }
    }

    static class C1 {
        static String grade(int score) {
            if (score >= 91) {
                return "A";
            } else if (score >= 80) {
                return "B";
            }
            return "C";
        }
        static void run() {
            for (int p0 = 70; p0 <= 100; p0 += 1) {
                System.out.println(grade(p0));
            }
        }
    }

    static class C2 {
        static String grade(int score) {
            if (score >= 90) {
                return "A";
            } else if (score >= 80) {
                return "B";
            }
            return "C";
        }
        static void run() {
            for (int p0 = 70; p0 <= 100; p0 += 1) {
                System.out.println(grade(p0));
            }
        }
    }

    static class C3 {
        static String grade(int score) {
            if (score == 90) {
                return "A";
            } else if (score >= 80) {
                return "B";
            }
            return "C";
        }
        static void run() {
            for (int p0 = 70; p0 <= 100; p0 += 1) {
                System.out.println(grade(p0));
            }
        }
    }

    static class C4 {
        static String grade(int score) {
            if (score >= 89) {
                return "A";
            } else if (score >= 80) {
                return "B";
            }
            return "C";
        }
        static void run() {
            for (int p0 = 70; p0 <= 100; p0 += 1) {
                System.out.println(grade(p0));
            }
        }
    }

    static class C5 {
        static boolean isTeen(int age) {
            return age > 13 && age < 19;
        }
        static void run() {
            for (int p0 = 8; p0 <= 24; p0 += 1) {
                System.out.println(isTeen(p0));
            }
        }
    }

    static class C6 {
        static boolean isTeen(int age) {
            return age >= 13 && age < 19;
        }
        static void run() {
            for (int p0 = 8; p0 <= 24; p0 += 1) {
                System.out.println(isTeen(p0));
            }
        }
    }

    static class C7 {
        static boolean isTeen(int age) {
            return age > 13 && age <= 19;
        }
        static void run() {
            for (int p0 = 8; p0 <= 24; p0 += 1) {
                System.out.println(isTeen(p0));
            }
        }
    }

    static class C8 {
        static boolean isTeen(int age) {
            return age >= 13 || age <= 19;
        }
        static void run() {
            for (int p0 = 8; p0 <= 24; p0 += 1) {
                System.out.println(isTeen(p0));
            }
        }
    }

    static class C9 {
        static boolean isTeen(int age) {
            return age >= 13 && age <= 19;
        }
        static void run() {
            for (int p0 = 8; p0 <= 24; p0 += 1) {
                System.out.println(isTeen(p0));
            }
        }
    }

    static class C10 {
        static boolean validMonth(int m) {
            return m >= 1 || m <= 12;
        }
        static void run() {
            for (int p0 = -3; p0 <= 16; p0 += 1) {
                System.out.println(validMonth(p0));
            }
        }
    }

    static class C11 {
        static boolean validMonth(int m) {
            return m > 1 && m < 12;
        }
        static void run() {
            for (int p0 = -3; p0 <= 16; p0 += 1) {
                System.out.println(validMonth(p0));
            }
        }
    }

    static class C12 {
        static boolean validMonth(int m) {
            return m >= 1 && m < 12;
        }
        static void run() {
            for (int p0 = -3; p0 <= 16; p0 += 1) {
                System.out.println(validMonth(p0));
            }
        }
    }

    static class C13 {
        static boolean validMonth(int m) {
            return m >= 1 && m <= 12;
        }
        static void run() {
            for (int p0 = -3; p0 <= 16; p0 += 1) {
                System.out.println(validMonth(p0));
            }
        }
    }

    static class C14 {
        static boolean validMonth(int m) {
            return m <= 1 || m >= 12;
        }
        static void run() {
            for (int p0 = -3; p0 <= 16; p0 += 1) {
                System.out.println(validMonth(p0));
            }
        }
    }

    static class C15 {
        static int bonus(int sales) {
            int b = 0;
            if (sales >= 1000) {
                b = 100;
            }
            if (sales >= 500) {
                b = 50;
            }
            return b;
        }
        static void run() {
            for (int p0 = 0; p0 <= 1500; p0 += 50) {
                System.out.println(bonus(p0));
            }
        }
    }

    static class C16 {
        static int bonus(int sales) {
            int b = 0;
            if (sales >= 1000) {
                b = 100;
            }
            else if (sales > 500) {
                b = 50;
            }
            return b;
        }
        static void run() {
            for (int p0 = 0; p0 <= 1500; p0 += 50) {
                System.out.println(bonus(p0));
            }
        }
    }

    static class C17 {
        static int bonus(int sales) {
            int b = 0;
            if (sales >= 1000) {
                b = 100;
            }
            if (sales == 500) {
                b = 50;
            }
            return b;
        }
        static void run() {
            for (int p0 = 0; p0 <= 1500; p0 += 50) {
                System.out.println(bonus(p0));
            }
        }
    }

    static class C18 {
        static int bonus(int sales) {
            int b = 0;
            if (sales >= 1000) {
                b = 100;
            }
            else if (sales >= 500) {
                b = 50;
            }
            return b;
        }
        static void run() {
            for (int p0 = 0; p0 <= 1500; p0 += 50) {
                System.out.println(bonus(p0));
            }
        }
    }

    static class C19 {
        static int bonus(int sales) {
            int b = 0;
            if (sales >= 1000) {
                b = 100;
            }
            if (sales >= 500 || sales < 1000) {
                b = 50;
            }
            return b;
        }
        static void run() {
            for (int p0 = 0; p0 <= 1500; p0 += 50) {
                System.out.println(bonus(p0));
            }
        }
    }

    static class C20 {
        static int bonus(int sales) {
            int b = 0;
            if (sales >= 1000) {
                b = 100;
            }
            if (sales >= 500) {
                b = 50;
            }
            return b;
        }
        static void run() {
            for (int p0 = 0; p0 <= 1500; p0 += 1) {
                System.out.println(bonus(p0));
            }
        }
    }

    static class C21 {
        static int bonus(int sales) {
            int b = 0;
            if (sales >= 1000) {
                b = 100;
            }
            else if (sales >= 500) {
                b = 50;
            }
            return b;
        }
        static void run() {
            for (int p0 = 0; p0 <= 1500; p0 += 1) {
                System.out.println(bonus(p0));
            }
        }
    }

    static class C22 {
        static int sumTo(int n) {
            int total = 0;
            for (int i = 1; i < n; i++) {
                total += i;
            }
            return total;
        }
        static void run() {
            for (int p0 = -3; p0 <= 10; p0 += 1) {
                System.out.println(sumTo(p0));
            }
        }
    }

    static class C23 {
        static int sumTo(int n) {
            int total = 0;
            for (int i = 1; i < n + 2; i++) {
                total += i;
            }
            return total;
        }
        static void run() {
            for (int p0 = -3; p0 <= 10; p0 += 1) {
                System.out.println(sumTo(p0));
            }
        }
    }

    static class C24 {
        static int sumTo(int n) {
            int total = 0;
            for (int i = 1; i <= n - 1; i++) {
                total += i;
            }
            return total;
        }
        static void run() {
            for (int p0 = -3; p0 <= 10; p0 += 1) {
                System.out.println(sumTo(p0));
            }
        }
    }

    static class C25 {
        static int sumTo(int n) {
            int total = 0;
            for (int i = 1; i <= n; i++) {
                total += i;
            }
            return total;
        }
        static void run() {
            for (int p0 = -3; p0 <= 10; p0 += 1) {
                System.out.println(sumTo(p0));
            }
        }
    }

    static class C26 {
        static int sumTo(int n) {
            int total = 0;
            for (int i = 1; i <= n + 1; i++) {
                total += i;
            }
            return total;
        }
        static void run() {
            for (int p0 = -3; p0 <= 10; p0 += 1) {
                System.out.println(sumTo(p0));
            }
        }
    }

    static class C27 {
        static int countThrees(int n) {
            int count = 0;
            for (int i = 0; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            return count;
        }
        static void run() {
            for (int p0 = -3; p0 <= 12; p0 += 1) {
                System.out.println(countThrees(p0));
            }
        }
    }

    static class C28 {
        static int countThrees(int n) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            return count;
        }
        static void run() {
            for (int p0 = -3; p0 <= 12; p0 += 1) {
                System.out.println(countThrees(p0));
            }
        }
    }

    static class C29 {
        static int countThrees(int n) {
            int count = 0;
            for (int i = 1; i < n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            return count;
        }
        static void run() {
            for (int p0 = -3; p0 <= 12; p0 += 1) {
                System.out.println(countThrees(p0));
            }
        }
    }

    static class C30 {
        static int countThrees(int n) {
            int count = 0;
            for (int i = 1; i <= n; i += 3) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            return count;
        }
        static void run() {
            for (int p0 = -3; p0 <= 12; p0 += 1) {
                System.out.println(countThrees(p0));
            }
        }
    }

    static class C31 {
        static int countThrees(int n) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            return count;
        }
        static void run() {
            for (int p0 = -3; p0 <= 12; p0 += 1) {
                System.out.println(countThrees(p0));
            }
        }
    }

    static class C32 {
        static boolean canRide(int age, int height) {
            return age > 10 && height >= 120;
        }
        static void run() {
            for (int p0 = 8; p0 <= 12; p0 += 1) {
                for (int p1 = 110; p1 <= 130; p1 += 5) {
                    System.out.println(canRide(p0, p1));
                }
            }
        }
    }

    static class C33 {
        static boolean canRide(int age, int height) {
            return age >= 10 || height >= 120;
        }
        static void run() {
            for (int p0 = 8; p0 <= 12; p0 += 1) {
                for (int p1 = 110; p1 <= 130; p1 += 5) {
                    System.out.println(canRide(p0, p1));
                }
            }
        }
    }

    static class C34 {
        static boolean canRide(int age, int height) {
            return age >= 10 && height > 120;
        }
        static void run() {
            for (int p0 = 8; p0 <= 12; p0 += 1) {
                for (int p1 = 110; p1 <= 130; p1 += 5) {
                    System.out.println(canRide(p0, p1));
                }
            }
        }
    }

    static class C35 {
        static boolean canRide(int age, int height) {
            return age > 10 && height > 120;
        }
        static void run() {
            for (int p0 = 8; p0 <= 12; p0 += 1) {
                for (int p1 = 110; p1 <= 130; p1 += 5) {
                    System.out.println(canRide(p0, p1));
                }
            }
        }
    }

    static class C36 {
        static boolean canRide(int age, int height) {
            return age >= 10 && height >= 120;
        }
        static void run() {
            for (int p0 = 8; p0 <= 12; p0 += 1) {
                for (int p1 = 110; p1 <= 130; p1 += 5) {
                    System.out.println(canRide(p0, p1));
                }
            }
        }
    }

    static class C37 {
        static boolean canRide(int age, int height) {
            return age > 10 && height >= 120;
        }
        static void run() {
            for (int p0 = 8; p0 <= 12; p0 += 1) {
                for (int p1 = 110; p1 <= 130; p1 += 1) {
                    System.out.println(canRide(p0, p1));
                }
            }
        }
    }

    static class C38 {
        static boolean canRide(int age, int height) {
            return age >= 10 && height >= 120;
        }
        static void run() {
            for (int p0 = 8; p0 <= 12; p0 += 1) {
                for (int p1 = 110; p1 <= 130; p1 += 1) {
                    System.out.println(canRide(p0, p1));
                }
            }
        }
    }

    static class C39 {
        static String size(int n) {
            if (n < 100) {
                return "medium";
            } else if (n < 10) {
                return "small";
            }
            return "large";
        }
        static void run() {
            for (int p0 = -3; p0 <= 120; p0 += 1) {
                System.out.println(size(p0));
            }
        }
    }

    static class C40 {
        static String size(int n) {
            if (n < 100) {
                return "small";
            } else if (n < 10) {
                return "medium";
            }
            return "large";
        }
        static void run() {
            for (int p0 = -3; p0 <= 120; p0 += 1) {
                System.out.println(size(p0));
            }
        }
    }

    static class C41 {
        static String size(int n) {
            if (n < 10) {
                return "medium";
            } else if (n < 100) {
                return "small";
            }
            return "large";
        }
        static void run() {
            for (int p0 = -3; p0 <= 120; p0 += 1) {
                System.out.println(size(p0));
            }
        }
    }

    static class C42 {
        static String size(int n) {
            if (n < 10) {
                return "small";
            } else if (n < 100) {
                return "medium";
            }
            return "large";
        }
        static void run() {
            for (int p0 = -3; p0 <= 120; p0 += 1) {
                System.out.println(size(p0));
            }
        }
    }

    static class C43 {
        static String size(int n) {
            if (n <= 10) {
                return "small";
            } else if (n <= 100) {
                return "medium";
            }
            return "large";
        }
        static void run() {
            for (int p0 = -3; p0 <= 120; p0 += 1) {
                System.out.println(size(p0));
            }
        }
    }

    static class C44 {
        static boolean isValidHour(int h) {
            return h > 0 && h < 23;
        }
        static void run() {
            for (int p0 = -2; p0 <= 26; p0 += 1) {
                System.out.println(isValidHour(p0));
            }
        }
    }

    static class C45 {
        static boolean isValidHour(int h) {
            return h >= 0 && h <= 23;
        }
        static void run() {
            for (int p0 = -2; p0 <= 26; p0 += 1) {
                System.out.println(isValidHour(p0));
            }
        }
    }

    static class C46 {
        static int discount(int items) {
            if (items > 10) {
                return 20;
            }
            return 0;
        }
        static void run() {
            for (int p0 = 0; p0 <= 20; p0 += 1) {
                System.out.println(discount(p0));
            }
        }
    }

    static class C47 {
        static int discount(int items) {
            if (items >= 10) {
                return 20;
            }
            return 0;
        }
        static void run() {
            for (int p0 = 0; p0 <= 20; p0 += 1) {
                System.out.println(discount(p0));
            }
        }
    }

    static class C48 {
        static int sumOdd(int n) {
            int total = 0;
            for (int i = 1; i < n; i += 2) {
                total += i;
            }
            return total;
        }
        static void run() {
            for (int p0 = 0; p0 <= 9; p0 += 1) {
                System.out.println(sumOdd(p0));
            }
        }
    }

    static class C49 {
        static int sumOdd(int n) {
            int total = 0;
            for (int i = 1; i <= n; i += 2) {
                total += i;
            }
            return total;
        }
        static void run() {
            for (int p0 = 0; p0 <= 9; p0 += 1) {
                System.out.println(sumOdd(p0));
            }
        }
    }

    static class C50 {
        static boolean canCheckout(int age, int books) {
            return age >= 12 && books <= 5;
        }
        static void run() {
            for (int p0 = 10; p0 <= 14; p0 += 1) {
                for (int p1 = 3; p1 <= 7; p1 += 1) {
                    System.out.println(canCheckout(p0, p1));
                }
            }
        }
    }

    static class C51 {
        static boolean canCheckout(int age, int books) {
            return age >= 12 && books < 5;
        }
        static void run() {
            for (int p0 = 10; p0 <= 14; p0 += 1) {
                for (int p1 = 3; p1 <= 7; p1 += 1) {
                    System.out.println(canCheckout(p0, p1));
                }
            }
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
        check("static String grade(int score) {\n    if (score > 90) {\n        return \"A\";\n    } else if (score >= 80) {\n        return \"B\";\n    }\n    return \"C\";\n}\nfor (int p0 = 70; p0 <= 100; p0 += 1) {\n    System.out.println(grade(p0));\n}", "C\nC\nC\nC\nC\nC\nC\nC\nC\nC\nB\nB\nB\nB\nB\nB\nB\nB\nB\nB\nB\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\n", C0::run);
        check("static String grade(int score) {\n    if (score >= 91) {\n        return \"A\";\n    } else if (score >= 80) {\n        return \"B\";\n    }\n    return \"C\";\n}\nfor (int p0 = 70; p0 <= 100; p0 += 1) {\n    System.out.println(grade(p0));\n}", "C\nC\nC\nC\nC\nC\nC\nC\nC\nC\nB\nB\nB\nB\nB\nB\nB\nB\nB\nB\nB\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\n", C1::run);
        check("static String grade(int score) {\n    if (score >= 90) {\n        return \"A\";\n    } else if (score >= 80) {\n        return \"B\";\n    }\n    return \"C\";\n}\nfor (int p0 = 70; p0 <= 100; p0 += 1) {\n    System.out.println(grade(p0));\n}", "C\nC\nC\nC\nC\nC\nC\nC\nC\nC\nB\nB\nB\nB\nB\nB\nB\nB\nB\nB\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\n", C2::run);
        check("static String grade(int score) {\n    if (score == 90) {\n        return \"A\";\n    } else if (score >= 80) {\n        return \"B\";\n    }\n    return \"C\";\n}\nfor (int p0 = 70; p0 <= 100; p0 += 1) {\n    System.out.println(grade(p0));\n}", "C\nC\nC\nC\nC\nC\nC\nC\nC\nC\nB\nB\nB\nB\nB\nB\nB\nB\nB\nB\nA\nB\nB\nB\nB\nB\nB\nB\nB\nB\nB\n", C3::run);
        check("static String grade(int score) {\n    if (score >= 89) {\n        return \"A\";\n    } else if (score >= 80) {\n        return \"B\";\n    }\n    return \"C\";\n}\nfor (int p0 = 70; p0 <= 100; p0 += 1) {\n    System.out.println(grade(p0));\n}", "C\nC\nC\nC\nC\nC\nC\nC\nC\nC\nB\nB\nB\nB\nB\nB\nB\nB\nB\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\n", C4::run);
        check("static boolean isTeen(int age) {\n    return age > 13 && age < 19;\n}\nfor (int p0 = 8; p0 <= 24; p0 += 1) {\n    System.out.println(isTeen(p0));\n}", "false\nfalse\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\n", C5::run);
        check("static boolean isTeen(int age) {\n    return age >= 13 && age < 19;\n}\nfor (int p0 = 8; p0 <= 24; p0 += 1) {\n    System.out.println(isTeen(p0));\n}", "false\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\n", C6::run);
        check("static boolean isTeen(int age) {\n    return age > 13 && age <= 19;\n}\nfor (int p0 = 8; p0 <= 24; p0 += 1) {\n    System.out.println(isTeen(p0));\n}", "false\nfalse\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\nfalse\nfalse\nfalse\nfalse\nfalse\n", C7::run);
        check("static boolean isTeen(int age) {\n    return age >= 13 || age <= 19;\n}\nfor (int p0 = 8; p0 <= 24; p0 += 1) {\n    System.out.println(isTeen(p0));\n}", "true\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\n", C8::run);
        check("static boolean isTeen(int age) {\n    return age >= 13 && age <= 19;\n}\nfor (int p0 = 8; p0 <= 24; p0 += 1) {\n    System.out.println(isTeen(p0));\n}", "false\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\nfalse\nfalse\nfalse\nfalse\nfalse\n", C9::run);
        check("static boolean validMonth(int m) {\n    return m >= 1 || m <= 12;\n}\nfor (int p0 = -3; p0 <= 16; p0 += 1) {\n    System.out.println(validMonth(p0));\n}", "true\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\n", C10::run);
        check("static boolean validMonth(int m) {\n    return m > 1 && m < 12;\n}\nfor (int p0 = -3; p0 <= 16; p0 += 1) {\n    System.out.println(validMonth(p0));\n}", "false\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\nfalse\nfalse\nfalse\nfalse\nfalse\n", C11::run);
        check("static boolean validMonth(int m) {\n    return m >= 1 && m < 12;\n}\nfor (int p0 = -3; p0 <= 16; p0 += 1) {\n    System.out.println(validMonth(p0));\n}", "false\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\nfalse\nfalse\nfalse\nfalse\nfalse\n", C12::run);
        check("static boolean validMonth(int m) {\n    return m >= 1 && m <= 12;\n}\nfor (int p0 = -3; p0 <= 16; p0 += 1) {\n    System.out.println(validMonth(p0));\n}", "false\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\nfalse\nfalse\nfalse\nfalse\n", C13::run);
        check("static boolean validMonth(int m) {\n    return m <= 1 || m >= 12;\n}\nfor (int p0 = -3; p0 <= 16; p0 += 1) {\n    System.out.println(validMonth(p0));\n}", "true\ntrue\ntrue\ntrue\ntrue\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\n", C14::run);
        check("static int bonus(int sales) {\n    int b = 0;\n    if (sales >= 1000) {\n        b = 100;\n    }\n    if (sales >= 500) {\n        b = 50;\n    }\n    return b;\n}\nfor (int p0 = 0; p0 <= 1500; p0 += 50) {\n    System.out.println(bonus(p0));\n}", "0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n", C15::run);
        check("static int bonus(int sales) {\n    int b = 0;\n    if (sales >= 1000) {\n        b = 100;\n    }\n    else if (sales > 500) {\n        b = 50;\n    }\n    return b;\n}\nfor (int p0 = 0; p0 <= 1500; p0 += 50) {\n    System.out.println(bonus(p0));\n}", "0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n50\n50\n50\n50\n50\n50\n50\n50\n50\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n", C16::run);
        check("static int bonus(int sales) {\n    int b = 0;\n    if (sales >= 1000) {\n        b = 100;\n    }\n    if (sales == 500) {\n        b = 50;\n    }\n    return b;\n}\nfor (int p0 = 0; p0 <= 1500; p0 += 50) {\n    System.out.println(bonus(p0));\n}", "0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n50\n0\n0\n0\n0\n0\n0\n0\n0\n0\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n", C17::run);
        check("static int bonus(int sales) {\n    int b = 0;\n    if (sales >= 1000) {\n        b = 100;\n    }\n    else if (sales >= 500) {\n        b = 50;\n    }\n    return b;\n}\nfor (int p0 = 0; p0 <= 1500; p0 += 50) {\n    System.out.println(bonus(p0));\n}", "0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n", C18::run);
        check("static int bonus(int sales) {\n    int b = 0;\n    if (sales >= 1000) {\n        b = 100;\n    }\n    if (sales >= 500 || sales < 1000) {\n        b = 50;\n    }\n    return b;\n}\nfor (int p0 = 0; p0 <= 1500; p0 += 50) {\n    System.out.println(bonus(p0));\n}", "50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n", C19::run);
        check("static int bonus(int sales) {\n    int b = 0;\n    if (sales >= 1000) {\n        b = 100;\n    }\n    if (sales >= 500) {\n        b = 50;\n    }\n    return b;\n}\nfor (int p0 = 0; p0 <= 1500; p0 += 1) {\n    System.out.println(bonus(p0));\n}", "0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n", C20::run);
        check("static int bonus(int sales) {\n    int b = 0;\n    if (sales >= 1000) {\n        b = 100;\n    }\n    else if (sales >= 500) {\n        b = 50;\n    }\n    return b;\n}\nfor (int p0 = 0; p0 <= 1500; p0 += 1) {\n    System.out.println(bonus(p0));\n}", "0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n50\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n100\n", C21::run);
        check("static int sumTo(int n) {\n    int total = 0;\n    for (int i = 1; i < n; i++) {\n        total += i;\n    }\n    return total;\n}\nfor (int p0 = -3; p0 <= 10; p0 += 1) {\n    System.out.println(sumTo(p0));\n}", "0\n0\n0\n0\n0\n1\n3\n6\n10\n15\n21\n28\n36\n45\n", C22::run);
        check("static int sumTo(int n) {\n    int total = 0;\n    for (int i = 1; i < n + 2; i++) {\n        total += i;\n    }\n    return total;\n}\nfor (int p0 = -3; p0 <= 10; p0 += 1) {\n    System.out.println(sumTo(p0));\n}", "0\n0\n0\n1\n3\n6\n10\n15\n21\n28\n36\n45\n55\n66\n", C23::run);
        check("static int sumTo(int n) {\n    int total = 0;\n    for (int i = 1; i <= n - 1; i++) {\n        total += i;\n    }\n    return total;\n}\nfor (int p0 = -3; p0 <= 10; p0 += 1) {\n    System.out.println(sumTo(p0));\n}", "0\n0\n0\n0\n0\n1\n3\n6\n10\n15\n21\n28\n36\n45\n", C24::run);
        check("static int sumTo(int n) {\n    int total = 0;\n    for (int i = 1; i <= n; i++) {\n        total += i;\n    }\n    return total;\n}\nfor (int p0 = -3; p0 <= 10; p0 += 1) {\n    System.out.println(sumTo(p0));\n}", "0\n0\n0\n0\n1\n3\n6\n10\n15\n21\n28\n36\n45\n55\n", C25::run);
        check("static int sumTo(int n) {\n    int total = 0;\n    for (int i = 1; i <= n + 1; i++) {\n        total += i;\n    }\n    return total;\n}\nfor (int p0 = -3; p0 <= 10; p0 += 1) {\n    System.out.println(sumTo(p0));\n}", "0\n0\n0\n1\n3\n6\n10\n15\n21\n28\n36\n45\n55\n66\n", C26::run);
        check("static int countThrees(int n) {\n    int count = 0;\n    for (int i = 0; i <= n; i++) {\n        if (i % 3 == 0) {\n            count++;\n        }\n    }\n    return count;\n}\nfor (int p0 = -3; p0 <= 12; p0 += 1) {\n    System.out.println(countThrees(p0));\n}", "0\n0\n0\n1\n1\n1\n2\n2\n2\n3\n3\n3\n4\n4\n4\n5\n", C27::run);
        check("static int countThrees(int n) {\n    int count = 0;\n    for (int i = 0; i < n; i++) {\n        if (i % 3 == 0) {\n            count++;\n        }\n    }\n    return count;\n}\nfor (int p0 = -3; p0 <= 12; p0 += 1) {\n    System.out.println(countThrees(p0));\n}", "0\n0\n0\n0\n1\n1\n1\n2\n2\n2\n3\n3\n3\n4\n4\n4\n", C28::run);
        check("static int countThrees(int n) {\n    int count = 0;\n    for (int i = 1; i < n; i++) {\n        if (i % 3 == 0) {\n            count++;\n        }\n    }\n    return count;\n}\nfor (int p0 = -3; p0 <= 12; p0 += 1) {\n    System.out.println(countThrees(p0));\n}", "0\n0\n0\n0\n0\n0\n0\n1\n1\n1\n2\n2\n2\n3\n3\n3\n", C29::run);
        check("static int countThrees(int n) {\n    int count = 0;\n    for (int i = 1; i <= n; i += 3) {\n        if (i % 3 == 0) {\n            count++;\n        }\n    }\n    return count;\n}\nfor (int p0 = -3; p0 <= 12; p0 += 1) {\n    System.out.println(countThrees(p0));\n}", "0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n", C30::run);
        check("static int countThrees(int n) {\n    int count = 0;\n    for (int i = 1; i <= n; i++) {\n        if (i % 3 == 0) {\n            count++;\n        }\n    }\n    return count;\n}\nfor (int p0 = -3; p0 <= 12; p0 += 1) {\n    System.out.println(countThrees(p0));\n}", "0\n0\n0\n0\n0\n0\n1\n1\n1\n2\n2\n2\n3\n3\n3\n4\n", C31::run);
        check("static boolean canRide(int age, int height) {\n    return age > 10 && height >= 120;\n}\nfor (int p0 = 8; p0 <= 12; p0 += 1) {\n    for (int p1 = 110; p1 <= 130; p1 += 5) {\n        System.out.println(canRide(p0, p1));\n    }\n}", "false\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\nfalse\nfalse\ntrue\ntrue\ntrue\n", C32::run);
        check("static boolean canRide(int age, int height) {\n    return age >= 10 || height >= 120;\n}\nfor (int p0 = 8; p0 <= 12; p0 += 1) {\n    for (int p1 = 110; p1 <= 130; p1 += 5) {\n        System.out.println(canRide(p0, p1));\n    }\n}", "false\nfalse\ntrue\ntrue\ntrue\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\n", C33::run);
        check("static boolean canRide(int age, int height) {\n    return age >= 10 && height > 120;\n}\nfor (int p0 = 8; p0 <= 12; p0 += 1) {\n    for (int p1 = 110; p1 <= 130; p1 += 5) {\n        System.out.println(canRide(p0, p1));\n    }\n}", "false\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\nfalse\nfalse\nfalse\ntrue\ntrue\nfalse\nfalse\nfalse\ntrue\ntrue\n", C34::run);
        check("static boolean canRide(int age, int height) {\n    return age > 10 && height > 120;\n}\nfor (int p0 = 8; p0 <= 12; p0 += 1) {\n    for (int p1 = 110; p1 <= 130; p1 += 5) {\n        System.out.println(canRide(p0, p1));\n    }\n}", "false\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\nfalse\nfalse\nfalse\ntrue\ntrue\n", C35::run);
        check("static boolean canRide(int age, int height) {\n    return age >= 10 && height >= 120;\n}\nfor (int p0 = 8; p0 <= 12; p0 += 1) {\n    for (int p1 = 110; p1 <= 130; p1 += 5) {\n        System.out.println(canRide(p0, p1));\n    }\n}", "false\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\nfalse\nfalse\ntrue\ntrue\ntrue\nfalse\nfalse\ntrue\ntrue\ntrue\n", C36::run);
        check("static boolean canRide(int age, int height) {\n    return age > 10 && height >= 120;\n}\nfor (int p0 = 8; p0 <= 12; p0 += 1) {\n    for (int p1 = 110; p1 <= 130; p1 += 1) {\n        System.out.println(canRide(p0, p1));\n    }\n}", "false\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\n", C37::run);
        check("static boolean canRide(int age, int height) {\n    return age >= 10 && height >= 120;\n}\nfor (int p0 = 8; p0 <= 12; p0 += 1) {\n    for (int p1 = 110; p1 <= 130; p1 += 1) {\n        System.out.println(canRide(p0, p1));\n    }\n}", "false\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\n", C38::run);
        check("static String size(int n) {\n    if (n < 100) {\n        return \"medium\";\n    } else if (n < 10) {\n        return \"small\";\n    }\n    return \"large\";\n}\nfor (int p0 = -3; p0 <= 120; p0 += 1) {\n    System.out.println(size(p0));\n}", "medium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\n", C39::run);
        check("static String size(int n) {\n    if (n < 100) {\n        return \"small\";\n    } else if (n < 10) {\n        return \"medium\";\n    }\n    return \"large\";\n}\nfor (int p0 = -3; p0 <= 120; p0 += 1) {\n    System.out.println(size(p0));\n}", "small\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\n", C40::run);
        check("static String size(int n) {\n    if (n < 10) {\n        return \"medium\";\n    } else if (n < 100) {\n        return \"small\";\n    }\n    return \"large\";\n}\nfor (int p0 = -3; p0 <= 120; p0 += 1) {\n    System.out.println(size(p0));\n}", "medium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\n", C41::run);
        check("static String size(int n) {\n    if (n < 10) {\n        return \"small\";\n    } else if (n < 100) {\n        return \"medium\";\n    }\n    return \"large\";\n}\nfor (int p0 = -3; p0 <= 120; p0 += 1) {\n    System.out.println(size(p0));\n}", "small\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\n", C42::run);
        check("static String size(int n) {\n    if (n <= 10) {\n        return \"small\";\n    } else if (n <= 100) {\n        return \"medium\";\n    }\n    return \"large\";\n}\nfor (int p0 = -3; p0 <= 120; p0 += 1) {\n    System.out.println(size(p0));\n}", "small\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nsmall\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nmedium\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\nlarge\n", C43::run);
        check("static boolean isValidHour(int h) {\n    return h > 0 && h < 23;\n}\nfor (int p0 = -2; p0 <= 26; p0 += 1) {\n    System.out.println(isValidHour(p0));\n}", "false\nfalse\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\nfalse\nfalse\nfalse\nfalse\n", C44::run);
        check("static boolean isValidHour(int h) {\n    return h >= 0 && h <= 23;\n}\nfor (int p0 = -2; p0 <= 26; p0 += 1) {\n    System.out.println(isValidHour(p0));\n}", "false\nfalse\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\ntrue\nfalse\nfalse\nfalse\n", C45::run);
        check("static int discount(int items) {\n    if (items > 10) {\n        return 20;\n    }\n    return 0;\n}\nfor (int p0 = 0; p0 <= 20; p0 += 1) {\n    System.out.println(discount(p0));\n}", "0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n20\n20\n20\n20\n20\n20\n20\n20\n20\n20\n", C46::run);
        check("static int discount(int items) {\n    if (items >= 10) {\n        return 20;\n    }\n    return 0;\n}\nfor (int p0 = 0; p0 <= 20; p0 += 1) {\n    System.out.println(discount(p0));\n}", "0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n20\n20\n20\n20\n20\n20\n20\n20\n20\n20\n20\n", C47::run);
        check("static int sumOdd(int n) {\n    int total = 0;\n    for (int i = 1; i < n; i += 2) {\n        total += i;\n    }\n    return total;\n}\nfor (int p0 = 0; p0 <= 9; p0 += 1) {\n    System.out.println(sumOdd(p0));\n}", "0\n0\n1\n1\n4\n4\n9\n9\n16\n16\n", C48::run);
        check("static int sumOdd(int n) {\n    int total = 0;\n    for (int i = 1; i <= n; i += 2) {\n        total += i;\n    }\n    return total;\n}\nfor (int p0 = 0; p0 <= 9; p0 += 1) {\n    System.out.println(sumOdd(p0));\n}", "0\n1\n1\n4\n4\n9\n9\n16\n16\n25\n", C49::run);
        check("static boolean canCheckout(int age, int books) {\n    return age >= 12 && books <= 5;\n}\nfor (int p0 = 10; p0 <= 14; p0 += 1) {\n    for (int p1 = 3; p1 <= 7; p1 += 1) {\n        System.out.println(canCheckout(p0, p1));\n    }\n}", "false\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\ntrue\nfalse\nfalse\ntrue\ntrue\ntrue\nfalse\nfalse\ntrue\ntrue\ntrue\nfalse\nfalse\n", C50::run);
        check("static boolean canCheckout(int age, int books) {\n    return age >= 12 && books < 5;\n}\nfor (int p0 = 10; p0 <= 14; p0 += 1) {\n    for (int p1 = 3; p1 <= 7; p1 += 1) {\n        System.out.println(canCheckout(p0, p1));\n    }\n}", "false\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\nfalse\ntrue\ntrue\nfalse\nfalse\nfalse\ntrue\ntrue\nfalse\nfalse\nfalse\ntrue\ntrue\nfalse\nfalse\nfalse\n", C51::run);
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        if (javac == null) throw new IllegalStateException("A JDK is needed to check compile claims.");

        System.out.println(failed == 0 ? "PASS: " + passed + " programs match Java " + System.getProperty("java.version") : failed + " of " + (passed + failed) + " programs differ");
    }
}
