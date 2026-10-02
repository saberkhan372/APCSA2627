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

    static class C42 {

        static void run() {
            int score = 95;
            String grade = "";
            if (score >= 90) {
                grade = "A";
            } else if (score >= 80) {
                grade = "B";
            } else if (score >= 70) {
                grade = "C";
            } else {
                grade = "F";
            }
            System.out.println(grade);
        }
    }

    static class C43 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int score = 95;
            String grade = "";
            if (t("L0", score >= 90)) {
                grade = "A";
            } else if (t("L1", score >= 80)) {
                grade = "B";
            } else if (t("L2", score >= 70)) {
                grade = "C";
            } else {
                grade = "F";
            }
            System.out.println(grade);
        }
    }

    static class C44 {

        static void run() {
            int score = 85;
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

    static class C45 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int score = 85;
            String grade = "F";
            if (t("L0", score >= 90)) {
                grade = "A";
            }
            if (t("L1", score >= 80)) {
                grade = "B";
            }
            if (t("L2", score >= 70)) {
                grade = "C";
            }
            System.out.println(grade);
        }
    }

    static class C46 {

        static void run() {
            int score = 85;
            if (score >= 90) {
                System.out.println("A");
            } else if (score >= 80) {
                System.out.println("B");
            } else if (score >= 70) {
                System.out.println("C");
            }
        }
    }

    static class C47 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int score = 85;
            if (t("L0", score >= 90)) {
                System.out.println("A");
            } else if (t("L1", score >= 80)) {
                System.out.println("B");
            } else if (t("L2", score >= 70)) {
                System.out.println("C");
            }
        }
    }

    static class C48 {

        static void run() {
            int score = 60;
            if (score >= 90) {
                System.out.println("A");
            } else if (score >= 80) {
                System.out.println("B");
            } else if (score >= 70) {
                System.out.println("C");
            } else {
                System.out.println("F");
            }
        }
    }

    static class C49 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int score = 60;
            if (t("L0", score >= 90)) {
                System.out.println("A");
            } else if (t("L1", score >= 80)) {
                System.out.println("B");
            } else if (t("L2", score >= 70)) {
                System.out.println("C");
            } else {
                System.out.println("F");
            }
        }
    }

    static class C50 {

        static void run() {
            int a = -2;
            int b = 5;
            if (a > 0) {
                if (b > 0) {
                    System.out.println("both positive");
                }
            }
            System.out.println("done");
        }
    }

    static class C51 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int a = -2;
            int b = 5;
            if (t("L0", a > 0)) {
                if (t("L1", b > 0)) {
                    System.out.println("both positive");
                }
            }
            System.out.println("done");
        }
    }

    static class C52 {

        static void run() {
            int n = 12;
            if (n % 2 == 0) {
                System.out.println("even");
            } else if (n % 3 == 0) {
                System.out.println("multiple of 3");
            }
            if (n % 4 == 0) {
                System.out.println("multiple of 4");
            }
        }
    }

    static class C53 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int n = 12;
            if (t("L0", n % 2 == 0)) {
                System.out.println("even");
            } else if (t("L1", n % 3 == 0)) {
                System.out.println("multiple of 3");
            }
            if (t("L2", n % 4 == 0)) {
                System.out.println("multiple of 4");
            }
        }
    }

    static class C54 {

        static void run() {
            int t = 55;
            if (t >= 80) {
                System.out.println("hot");
            } else if (t >= 60) {
                System.out.println("mild");
            } else if (t >= 40) {
                System.out.println("cool");
            } else {
                System.out.println("cold");
            }
        }
    }

    static class C55 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int t = 55;
            if (t("L0", t >= 80)) {
                System.out.println("hot");
            } else if (t("L1", t >= 60)) {
                System.out.println("mild");
            } else if (t("L2", t >= 40)) {
                System.out.println("cool");
            } else {
                System.out.println("cold");
            }
        }
    }

    static class C56 {

        static void run() {
            int age = 15;
            boolean member = true;
            if (age >= 18) {
                if (member) {
                    System.out.println("adult member");
                }
            } else {
                System.out.println("minor");
            }
        }
    }

    static class C57 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int age = 15;
            boolean member = true;
            if (t("L0", age >= 18)) {
                if (t("L1", member)) {
                    System.out.println("adult member");
                }
            } else {
                System.out.println("minor");
            }
        }
    }

    static class C58 {

        static void run() {
            int n = 9;
            if (n % 2 == 0) {
                System.out.println("even");
            } else if (n % 3 == 0) {
                System.out.println("multiple of 3");
            }
            if (n % 4 == 0) {
                System.out.println("multiple of 4");
            }
        }
    }

    static class C59 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int n = 9;
            if (t("L0", n % 2 == 0)) {
                System.out.println("even");
            } else if (t("L1", n % 3 == 0)) {
                System.out.println("multiple of 3");
            }
            if (t("L2", n % 4 == 0)) {
                System.out.println("multiple of 4");
            }
        }
    }

    static class C60 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int a = 0;
            int b = 5;
            if (t("L0", a > 0))
                if (t("L1", b < 0))
                    System.out.println("x");
            else
                System.out.println("y");
            System.out.println("done");
        }
    }

    static class C61 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int score = 95;
            String grade = "F";
            if (t("L0", score >= 90)) {
                grade = "A";
            }
            if (t("L1", score >= 80)) {
                grade = "B";
            }
            if (t("L2", score >= 70)) {
                grade = "C";
            }
            System.out.println(grade);
        }
    }

    static class C62 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int score = 95;
            String grade = "F";
            if (t("L0", score >= 90)) {
                grade = "A";
            } else if (t("L1", score >= 80)) {
                grade = "B";
            } else if (t("L2", score >= 70)) {
                grade = "C";
            }
            System.out.println(grade);
        }
    }

    static class C63 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int t = 75;
            if (t("L0", t >= 80)) {
                System.out.println("hot");
            } else if (t("L1", t >= 60)) {
                System.out.println("mild");
            } else {
                System.out.println("cold");
            }
        }
    }

    static class C64 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int n = 15;
            if (t("L0", n % 3 == 0)) {
                System.out.print("Fizz");
            }
            if (t("L1", n % 5 == 0)) {
                System.out.print("Buzz");
            }
            System.out.println();
        }
    }

    static class C65 {

        static void run() {
            int pos = 0;
            int neg = 0;
            for (int x = -2; x <= 2; x++) {
                if (x > 0) {
                    pos++;
                } else if (x < 0) {
                    neg++;
                }
            }
            System.out.println(pos + " " + neg);
        }
    }

    static class C66 {
        static boolean t(String label, boolean r) {
            System.out.println(label);
            return r;
        }
        static void run() {
            int pos = 0;
            int neg = 0;
            for (int x = -2; x <= 2; x++) {
                if (t("L0", x > 0)) {
                    pos++;
                } else if (t("L1", x < 0)) {
                    neg++;
                }
            }
            System.out.println(pos + " " + neg);
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
        check("int score = 95;\nString grade = \"\";\nif (score >= 90) {\n    grade = \"A\";\n} else if (score >= 80) {\n    grade = \"B\";\n} else if (score >= 70) {\n    grade = \"C\";\n} else {\n    grade = \"F\";\n}\nSystem.out.println(grade);", "A\n", C42::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint score = 95;\nString grade = \"\";\nif (t(\"L0\", score >= 90)) {\n    grade = \"A\";\n} else if (t(\"L1\", score >= 80)) {\n    grade = \"B\";\n} else if (t(\"L2\", score >= 70)) {\n    grade = \"C\";\n} else {\n    grade = \"F\";\n}\nSystem.out.println(grade);", "L0\nA\n", C43::run);
        check("int score = 85;\nString grade = \"F\";\nif (score >= 90) {\n    grade = \"A\";\n}\nif (score >= 80) {\n    grade = \"B\";\n}\nif (score >= 70) {\n    grade = \"C\";\n}\nSystem.out.println(grade);", "C\n", C44::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint score = 85;\nString grade = \"F\";\nif (t(\"L0\", score >= 90)) {\n    grade = \"A\";\n}\nif (t(\"L1\", score >= 80)) {\n    grade = \"B\";\n}\nif (t(\"L2\", score >= 70)) {\n    grade = \"C\";\n}\nSystem.out.println(grade);", "L0\nL1\nL2\nC\n", C45::run);
        check("int score = 85;\nif (score >= 90) {\n    System.out.println(\"A\");\n} else if (score >= 80) {\n    System.out.println(\"B\");\n} else if (score >= 70) {\n    System.out.println(\"C\");\n}", "B\n", C46::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint score = 85;\nif (t(\"L0\", score >= 90)) {\n    System.out.println(\"A\");\n} else if (t(\"L1\", score >= 80)) {\n    System.out.println(\"B\");\n} else if (t(\"L2\", score >= 70)) {\n    System.out.println(\"C\");\n}", "L0\nL1\nB\n", C47::run);
        check("int score = 60;\nif (score >= 90) {\n    System.out.println(\"A\");\n} else if (score >= 80) {\n    System.out.println(\"B\");\n} else if (score >= 70) {\n    System.out.println(\"C\");\n} else {\n    System.out.println(\"F\");\n}", "F\n", C48::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint score = 60;\nif (t(\"L0\", score >= 90)) {\n    System.out.println(\"A\");\n} else if (t(\"L1\", score >= 80)) {\n    System.out.println(\"B\");\n} else if (t(\"L2\", score >= 70)) {\n    System.out.println(\"C\");\n} else {\n    System.out.println(\"F\");\n}", "L0\nL1\nL2\nF\n", C49::run);
        check("int a = -2;\nint b = 5;\nif (a > 0) {\n    if (b > 0) {\n        System.out.println(\"both positive\");\n    }\n}\nSystem.out.println(\"done\");", "done\n", C50::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint a = -2;\nint b = 5;\nif (t(\"L0\", a > 0)) {\n    if (t(\"L1\", b > 0)) {\n        System.out.println(\"both positive\");\n    }\n}\nSystem.out.println(\"done\");", "L0\ndone\n", C51::run);
        check("int n = 12;\nif (n % 2 == 0) {\n    System.out.println(\"even\");\n} else if (n % 3 == 0) {\n    System.out.println(\"multiple of 3\");\n}\nif (n % 4 == 0) {\n    System.out.println(\"multiple of 4\");\n}", "even\nmultiple of 4\n", C52::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint n = 12;\nif (t(\"L0\", n % 2 == 0)) {\n    System.out.println(\"even\");\n} else if (t(\"L1\", n % 3 == 0)) {\n    System.out.println(\"multiple of 3\");\n}\nif (t(\"L2\", n % 4 == 0)) {\n    System.out.println(\"multiple of 4\");\n}", "L0\neven\nL2\nmultiple of 4\n", C53::run);
        check("int t = 55;\nif (t >= 80) {\n    System.out.println(\"hot\");\n} else if (t >= 60) {\n    System.out.println(\"mild\");\n} else if (t >= 40) {\n    System.out.println(\"cool\");\n} else {\n    System.out.println(\"cold\");\n}", "cool\n", C54::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint t = 55;\nif (t(\"L0\", t >= 80)) {\n    System.out.println(\"hot\");\n} else if (t(\"L1\", t >= 60)) {\n    System.out.println(\"mild\");\n} else if (t(\"L2\", t >= 40)) {\n    System.out.println(\"cool\");\n} else {\n    System.out.println(\"cold\");\n}", "L0\nL1\nL2\ncool\n", C55::run);
        check("int age = 15;\nboolean member = true;\nif (age >= 18) {\n    if (member) {\n        System.out.println(\"adult member\");\n    }\n} else {\n    System.out.println(\"minor\");\n}", "minor\n", C56::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint age = 15;\nboolean member = true;\nif (t(\"L0\", age >= 18)) {\n    if (t(\"L1\", member)) {\n        System.out.println(\"adult member\");\n    }\n} else {\n    System.out.println(\"minor\");\n}", "L0\nminor\n", C57::run);
        check("int n = 9;\nif (n % 2 == 0) {\n    System.out.println(\"even\");\n} else if (n % 3 == 0) {\n    System.out.println(\"multiple of 3\");\n}\nif (n % 4 == 0) {\n    System.out.println(\"multiple of 4\");\n}", "multiple of 3\n", C58::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint n = 9;\nif (t(\"L0\", n % 2 == 0)) {\n    System.out.println(\"even\");\n} else if (t(\"L1\", n % 3 == 0)) {\n    System.out.println(\"multiple of 3\");\n}\nif (t(\"L2\", n % 4 == 0)) {\n    System.out.println(\"multiple of 4\");\n}", "L0\nL1\nmultiple of 3\nL2\n", C59::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint a = 0;\nint b = 5;\nif (t(\"L0\", a > 0))\n    if (t(\"L1\", b < 0))\n        System.out.println(\"x\");\nelse\n    System.out.println(\"y\");\nSystem.out.println(\"done\");", "L0\ndone\n", C60::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint score = 95;\nString grade = \"F\";\nif (t(\"L0\", score >= 90)) {\n    grade = \"A\";\n}\nif (t(\"L1\", score >= 80)) {\n    grade = \"B\";\n}\nif (t(\"L2\", score >= 70)) {\n    grade = \"C\";\n}\nSystem.out.println(grade);", "L0\nL1\nL2\nC\n", C61::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint score = 95;\nString grade = \"F\";\nif (t(\"L0\", score >= 90)) {\n    grade = \"A\";\n} else if (t(\"L1\", score >= 80)) {\n    grade = \"B\";\n} else if (t(\"L2\", score >= 70)) {\n    grade = \"C\";\n}\nSystem.out.println(grade);", "L0\nA\n", C62::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint t = 75;\nif (t(\"L0\", t >= 80)) {\n    System.out.println(\"hot\");\n} else if (t(\"L1\", t >= 60)) {\n    System.out.println(\"mild\");\n} else {\n    System.out.println(\"cold\");\n}", "L0\nL1\nmild\n", C63::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint n = 15;\nif (t(\"L0\", n % 3 == 0)) {\n    System.out.print(\"Fizz\");\n}\nif (t(\"L1\", n % 5 == 0)) {\n    System.out.print(\"Buzz\");\n}\nSystem.out.println();", "L0\nFizzL1\nBuzz\n", C64::run);
        check("int pos = 0;\nint neg = 0;\nfor (int x = -2; x <= 2; x++) {\n    if (x > 0) {\n        pos++;\n    } else if (x < 0) {\n        neg++;\n    }\n}\nSystem.out.println(pos + \" \" + neg);", "2 2\n", C65::run);
        check("static boolean t(String label, boolean r) {\n    System.out.println(label);\n    return r;\n}\nint pos = 0;\nint neg = 0;\nfor (int x = -2; x <= 2; x++) {\n    if (t(\"L0\", x > 0)) {\n        pos++;\n    } else if (t(\"L1\", x < 0)) {\n        neg++;\n    }\n}\nSystem.out.println(pos + \" \" + neg);", "L0\nL1\nL0\nL1\nL0\nL1\nL0\nL0\n2 2\n", C66::run);
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        if (javac == null) throw new IllegalStateException("A JDK is needed to check compile claims.");
        compileCheck(javac, "int x = 5;\nSystem.out.println(x > 3 && 7);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint x = 5;\nSystem.out.println(x > 3 && 7);\n}\n}", false);
        compileCheck(javac, "int x = 5;\nif (x = 5) {\n}", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint x = 5;\nif (x = 5) {\n}\n}\n}", false);
        compileCheck(javac, "boolean done = false;\nif (done = true) {\n    System.out.println(\"yes\");\n}", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nboolean done = false;\nif (done = true) {\n    System.out.println(\"yes\");\n}\n}\n}", true);
        compileCheck(javac, "String s = \"a\";\nString t = \"a\";\nSystem.out.println(s == t);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nString s = \"a\";\nString t = \"a\";\nSystem.out.println(s == t);\n}\n}", true);
        compileCheck(javac, "int x = 5;\nSystem.out.println(x > 3 & x < 9);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint x = 5;\nSystem.out.println(x > 3 & x < 9);\n}\n}", true);
        compileCheck(javac, "int x = 5;\nSystem.out.println(x > 3 ? 1 : 2);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint x = 5;\nSystem.out.println(x > 3 ? 1 : 2);\n}\n}", true);
        System.out.println(failed == 0 ? "PASS: " + passed + " programs match Java " + System.getProperty("java.version") : failed + " of " + (passed + failed) + " programs differ");
    }
}
