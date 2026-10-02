// Generated from loops-cases.json by mj-java.mjs. Do not edit by hand.
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

public class LoopsCheck {
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
            int count = 0;
            for (int i = 0; i < 5; i++) {
                count++;
            }
            System.out.println(count);
        }
    }

    static class C1 {

        static void run() {
            int x = 2;
            while (x < 100) {
                x *= 5;
            }
            System.out.println(x);
        }
    }

    static class C2 {

        static void run() {
            for (int i = 1; i <= 10; i += 3) {
                System.out.print(i + " ");
            }
        }
    }

    static class C3 {

        static void run() {
            int i = 0;
            int last = 0;
            while (i < 4) {
                last = i;
                i++;
            }
            System.out.println(last + " " + i);
        }
    }

    static class C4 {

        static void run() {
            int n = 10;
            while (n < 5) {
                n++;
            }
            System.out.println(n);
        }
    }

    static class C5 {

        static void run() {
            int sum = 0;
            for (int k = 1; k <= 5; k++) {
                sum += k * k;
            }
            System.out.println(sum);
        }
    }

    static class C6 {

        static void run() {
            int count = 0;
            for (int j = 10; j > 0; j -= 3) {
                count++;
            }
            System.out.println(count);
        }
    }

    static class C7 {

        static void run() {
            int i = 5;
            while (i > 0) {
                i -= 2;
            }
            System.out.println(i);
        }
    }

    static class C9 {

        static void run() {
            String s = "banana";
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.substring(i, i + 1).equals("a")) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C10 {

        static void run() {
            int c = 0;
            for (int r = 0; r < 3; r++) {
                for (int k = 0; k < 4; k++) {
                    c++;
                }
            }
            System.out.println(c);
        }
    }

    static class C11 {

        static void run() {
            for (int r = 1; r <= 4; r++) {
                for (int k = 1; k <= r; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    static class C12 {

        static void run() {
            int count = 0;
            for (int i = 3; i < 12; i += 2) {
                count++;
            }
            System.out.println(count);
        }
    }

    static class C13 {

        static void run() {
            int x = 1;
            while (x <= 50) {
                x = x * 2 + 1;
            }
            System.out.println(x);
        }
    }

    static class C15 {

        static void run() {
            for (int i = 10; i >= 0; i -= 4) {
                System.out.print(i + ",");
            }
        }
    }

    static class C16 {

        static void run() {
            String w = "loop";
            String r = "";
            for (int i = w.length() - 1; i >= 0; i--) {
                r += w.substring(i, i + 1);
            }
            System.out.println(r);
        }
    }

    static class C17 {

        static void run() {
            int c = 0;
            for (int a = 1; a <= 3; a++) {
                for (int b = a; b <= 3; b++) {
                    c++;
                }
            }
            System.out.println(c);
        }
    }

    static class C18 {

        static void run() {
            int x = 20;
            while (x > 1) {
                x /= 3;
            }
            System.out.println(x);
        }
    }

    static class C19 {

        static void run() {
            int total = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = i; j < 6; j++) {
                    total++;
                }
            }
            System.out.println(total);
        }
    }

    static class C20 {

        static void run() {
            int[] scores = {8, 5, 9, 6};
            int total = 0;
            for (int s : scores) {
                total += s;
            }
            System.out.println(total);
        }
    }

    static class C21 {

        static void run() {
            int sum = 0;
            {
                int i = 1;
                while (i <= 4) {
                    sum += i;
                    i++;
                }
            }
            System.out.println(sum);
        }
    }

    static class C22 {

        static void run() {
            int n = 0;
            for (int i = 0; i < 5; i++);
            System.out.println(n);
        }
    }

    static class C23 {

        static void run() {
            for (int i = 0; i < 3; i++) {
                System.out.print(i);
            }
            for (int i = 5; i > 3; i--) {
                System.out.print(i);
            }
        }
    }

    static class C24 {

        static void run() {
            int x = 7;
            x += 2.5;
            x -= 1;
            x *= 3;
            x /= 4;
            x %= 4;
            System.out.println(x);
        }
    }

    static class C25 {

        static void run() {
            double d = 1;
            for (int i = 0; i < 3; i++) {
                d = d / 2;
            }
            System.out.println(d);
        }
    }

    static class C26 {

        static void run() {
            int[] a = new int[4];
            for (int i = 0; i < a.length; i++) {
                a[i] = i * i;
            }
            for (int v : a) {
                System.out.print(v + " ");
            }
        }
    }

    static class C27 {

        static void run() {
            int[] a = {1, 2, 3};
            for (int v : a) {
                v = v * 10;
            }
            System.out.println(a[0] + a[1] + a[2]);
        }
    }

    static class C28 {

        static void run() {
            int i = 0;
            while (i < 10 && i * i < 20) {
                i++;
            }
            System.out.println(i);
        }
    }

    static class C29 {

        static void run() {
            boolean done = false;
            int n = 1;
            while (!done) {
                n *= 2;
                if (n > 20) {
                    done = true;
                }
            }
            System.out.println(n);
        }
    }

    static class C30 {

        static void run() {
            int[] a = {3, 1, 2};
            System.out.println(a[3]);
        }
    }

    static class C31 {

        static void run() {
            String s = "abc";
            for (int i = 0; i <= s.length(); i++) {
                System.out.print(s.substring(i, i + 1));
            }
        }
    }

    static class C38 {

        static void run() {
            int n = 0;
            int total = 0;
            for (int i = 1; i <= n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C39 {

        static void run() {
            int visits = 0;
            int n = 0;
            int total = 0;
            for (int i = 1; i <= n; i++) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C40 {

        static void run() {
            int n = 0;
            int total = 0;
            int i = 1;
            while (i <= n) {
                total += i;
                i++;
            }
            System.out.println(total);
        }
    }

    static class C41 {

        static void run() {
            int visits = 0;
            int n = 0;
            int total = 0;
            int i = 1;
            while (i <= n) { visits++;
                total += i;
                i++;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C42 {

        static void run() {
            int n = 1;
            int total = 0;
            for (int i = 1; i <= n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C43 {

        static void run() {
            int visits = 0;
            int n = 1;
            int total = 0;
            for (int i = 1; i <= n; i++) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C44 {

        static void run() {
            int n = 1;
            int total = 0;
            int i = 1;
            while (i <= n) {
                total += i;
                i++;
            }
            System.out.println(total);
        }
    }

    static class C45 {

        static void run() {
            int visits = 0;
            int n = 1;
            int total = 0;
            int i = 1;
            while (i <= n) { visits++;
                total += i;
                i++;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C46 {

        static void run() {
            int n = 5;
            int total = 0;
            for (int i = 1; i <= n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C47 {

        static void run() {
            int visits = 0;
            int n = 5;
            int total = 0;
            for (int i = 1; i <= n; i++) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C48 {

        static void run() {
            int n = 5;
            int total = 0;
            int i = 1;
            while (i <= n) {
                total += i;
                i++;
            }
            System.out.println(total);
        }
    }

    static class C49 {

        static void run() {
            int visits = 0;
            int n = 5;
            int total = 0;
            int i = 1;
            while (i <= n) { visits++;
                total += i;
                i++;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C50 {

        static void run() {
            int n = 6;
            int total = 0;
            for (int i = 1; i <= n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C51 {

        static void run() {
            int visits = 0;
            int n = 6;
            int total = 0;
            for (int i = 1; i <= n; i++) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C52 {

        static void run() {
            int n = 6;
            int total = 0;
            int i = 1;
            while (i <= n) {
                total += i;
                i++;
            }
            System.out.println(total);
        }
    }

    static class C53 {

        static void run() {
            int visits = 0;
            int n = 6;
            int total = 0;
            int i = 1;
            while (i <= n) { visits++;
                total += i;
                i++;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C54 {

        static void run() {
            int n = 0;
            int total = 0;
            for (int i = n; i >= 1; i--) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C55 {

        static void run() {
            int visits = 0;
            int n = 0;
            int total = 0;
            for (int i = n; i >= 1; i--) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C56 {

        static void run() {
            int n = 1;
            int total = 0;
            for (int i = n; i >= 1; i--) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C57 {

        static void run() {
            int visits = 0;
            int n = 1;
            int total = 0;
            for (int i = n; i >= 1; i--) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C58 {

        static void run() {
            int n = 5;
            int total = 0;
            for (int i = n; i >= 1; i--) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C59 {

        static void run() {
            int visits = 0;
            int n = 5;
            int total = 0;
            for (int i = n; i >= 1; i--) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C60 {

        static void run() {
            int n = 6;
            int total = 0;
            for (int i = n; i >= 1; i--) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C61 {

        static void run() {
            int visits = 0;
            int n = 6;
            int total = 0;
            for (int i = n; i >= 1; i--) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C62 {

        static void run() {
            int n = 1;
            int total = 0;
            int i = 0;
            while (i < n) {
                total += i;
                i++;
            }
            System.out.println(total);
        }
    }

    static class C63 {

        static void run() {
            int visits = 0;
            int n = 1;
            int total = 0;
            int i = 0;
            while (i < n) { visits++;
                total += i;
                i++;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C64 {

        static void run() {
            int n = 3;
            int total = 0;
            int i = 0;
            while (i < n) {
                total += i;
                i++;
            }
            System.out.println(total);
        }
    }

    static class C65 {

        static void run() {
            int visits = 0;
            int n = 3;
            int total = 0;
            int i = 0;
            while (i < n) { visits++;
                total += i;
                i++;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C66 {

        static void run() {
            int n = 3;
            int total = 0;
            int i = 1;
            while (i <= n) {
                total += i;
                i++;
            }
            System.out.println(total);
        }
    }

    static class C67 {

        static void run() {
            int visits = 0;
            int n = 3;
            int total = 0;
            int i = 1;
            while (i <= n) { visits++;
                total += i;
                i++;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C68 {

        static void run() {
            int n = 5;
            int total = 0;
            int i = 0;
            while (i < n) {
                total += i;
                i++;
            }
            System.out.println(total);
        }
    }

    static class C69 {

        static void run() {
            int visits = 0;
            int n = 5;
            int total = 0;
            int i = 0;
            while (i < n) { visits++;
                total += i;
                i++;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C70 {

        static void run() {
            int n = 1;
            int total = 0;
            total = 1;
            for (int i = 2; i <= n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C71 {

        static void run() {
            int visits = 0;
            int n = 1;
            int total = 0;
            total = 1;
            for (int i = 2; i <= n; i++) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C72 {

        static void run() {
            int n = 2;
            int total = 0;
            for (int i = 1; i <= n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C73 {

        static void run() {
            int visits = 0;
            int n = 2;
            int total = 0;
            for (int i = 1; i <= n; i++) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C74 {

        static void run() {
            int n = 2;
            int total = 0;
            total = 1;
            for (int i = 2; i <= n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C75 {

        static void run() {
            int visits = 0;
            int n = 2;
            int total = 0;
            total = 1;
            for (int i = 2; i <= n; i++) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C76 {

        static void run() {
            int n = 5;
            int total = 0;
            total = 1;
            for (int i = 2; i <= n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C77 {

        static void run() {
            int visits = 0;
            int n = 5;
            int total = 0;
            total = 1;
            for (int i = 2; i <= n; i++) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C78 {

        static void run() {
            int n = 0;
            int total = 0;
            total = 1;
            for (int i = 2; i <= n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C79 {

        static void run() {
            int visits = 0;
            int n = 0;
            int total = 0;
            total = 1;
            for (int i = 2; i <= n; i++) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C80 {

        static void run() {
            int n = 3;
            int total = 0;
            for (int i = 0; i < n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C81 {

        static void run() {
            int visits = 0;
            int n = 3;
            int total = 0;
            for (int i = 0; i < n; i++) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C82 {

        static void run() {
            int n = 3;
            int total = 0;
            int i = 0;
            while (i != n) {
                total += i;
                i++;
            }
            System.out.println(total);
        }
    }

    static class C83 {

        static void run() {
            int visits = 0;
            int n = 3;
            int total = 0;
            int i = 0;
            while (i != n) { visits++;
                total += i;
                i++;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C84 {

        static void run() {
            int n = 0;
            int total = 0;
            for (int i = 0; i < n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C85 {

        static void run() {
            int visits = 0;
            int n = 0;
            int total = 0;
            for (int i = 0; i < n; i++) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C86 {

        static void run() {
            int n = 0;
            int total = 0;
            int i = 0;
            while (i != n) {
                total += i;
                i++;
            }
            System.out.println(total);
        }
    }

    static class C87 {

        static void run() {
            int visits = 0;
            int n = 0;
            int total = 0;
            int i = 0;
            while (i != n) { visits++;
                total += i;
                i++;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
        }
    }

    static class C88 {

        static void run() {
            int n = -2;
            int total = 0;
            for (int i = 0; i < n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C89 {

        static void run() {
            int visits = 0;
            int n = -2;
            int total = 0;
            for (int i = 0; i < n; i++) { visits++;
                total += i;
            }
            System.out.println(total);
            System.out.println("visits=" + visits);
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
        check("int count = 0;\nfor (int i = 0; i < 5; i++) {\n    count++;\n}\nSystem.out.println(count);", "5\n", C0::run);
        check("int x = 2;\nwhile (x < 100) {\n    x *= 5;\n}\nSystem.out.println(x);", "250\n", C1::run);
        check("for (int i = 1; i <= 10; i += 3) {\n    System.out.print(i + \" \");\n}", "1 4 7 10 ", C2::run);
        check("int i = 0;\nint last = 0;\nwhile (i < 4) {\n    last = i;\n    i++;\n}\nSystem.out.println(last + \" \" + i);", "3 4\n", C3::run);
        check("int n = 10;\nwhile (n < 5) {\n    n++;\n}\nSystem.out.println(n);", "10\n", C4::run);
        check("int sum = 0;\nfor (int k = 1; k <= 5; k++) {\n    sum += k * k;\n}\nSystem.out.println(sum);", "55\n", C5::run);
        check("int count = 0;\nfor (int j = 10; j > 0; j -= 3) {\n    count++;\n}\nSystem.out.println(count);", "4\n", C6::run);
        check("int i = 5;\nwhile (i > 0) {\n    i -= 2;\n}\nSystem.out.println(i);", "-1\n", C7::run);
        check("String s = \"banana\";\nint count = 0;\nfor (int i = 0; i < s.length(); i++) {\n    if (s.substring(i, i + 1).equals(\"a\")) {\n        count++;\n    }\n}\nSystem.out.println(count);", "3\n", C9::run);
        check("int c = 0;\nfor (int r = 0; r < 3; r++) {\n    for (int k = 0; k < 4; k++) {\n        c++;\n    }\n}\nSystem.out.println(c);", "12\n", C10::run);
        check("for (int r = 1; r <= 4; r++) {\n    for (int k = 1; k <= r; k++) {\n        System.out.print(\"*\");\n    }\n    System.out.println();\n}", "*\n**\n***\n****\n", C11::run);
        check("int count = 0;\nfor (int i = 3; i < 12; i += 2) {\n    count++;\n}\nSystem.out.println(count);", "5\n", C12::run);
        check("int x = 1;\nwhile (x <= 50) {\n    x = x * 2 + 1;\n}\nSystem.out.println(x);", "63\n", C13::run);
        check("for (int i = 10; i >= 0; i -= 4) {\n    System.out.print(i + \",\");\n}", "10,6,2,", C15::run);
        check("String w = \"loop\";\nString r = \"\";\nfor (int i = w.length() - 1; i >= 0; i--) {\n    r += w.substring(i, i + 1);\n}\nSystem.out.println(r);", "pool\n", C16::run);
        check("int c = 0;\nfor (int a = 1; a <= 3; a++) {\n    for (int b = a; b <= 3; b++) {\n        c++;\n    }\n}\nSystem.out.println(c);", "6\n", C17::run);
        check("int x = 20;\nwhile (x > 1) {\n    x /= 3;\n}\nSystem.out.println(x);", "0\n", C18::run);
        check("int total = 0;\nfor (int i = 0; i < 6; i++) {\n    for (int j = i; j < 6; j++) {\n        total++;\n    }\n}\nSystem.out.println(total);", "21\n", C19::run);
        check("int[] scores = {8, 5, 9, 6};\nint total = 0;\nfor (int s : scores) {\n    total += s;\n}\nSystem.out.println(total);", "28\n", C20::run);
        check("int sum = 0;\n{\n    int i = 1;\n    while (i <= 4) {\n        sum += i;\n        i++;\n    }\n}\nSystem.out.println(sum);", "10\n", C21::run);
        check("int n = 0;\nfor (int i = 0; i < 5; i++);\nSystem.out.println(n);", "0\n", C22::run);
        check("for (int i = 0; i < 3; i++) {\n    System.out.print(i);\n}\nfor (int i = 5; i > 3; i--) {\n    System.out.print(i);\n}", "01254", C23::run);
        check("int x = 7;\nx += 2.5;\nx -= 1;\nx *= 3;\nx /= 4;\nx %= 4;\nSystem.out.println(x);", "2\n", C24::run);
        check("double d = 1;\nfor (int i = 0; i < 3; i++) {\n    d = d / 2;\n}\nSystem.out.println(d);", "0.125\n", C25::run);
        check("int[] a = new int[4];\nfor (int i = 0; i < a.length; i++) {\n    a[i] = i * i;\n}\nfor (int v : a) {\n    System.out.print(v + \" \");\n}", "0 1 4 9 ", C26::run);
        check("int[] a = {1, 2, 3};\nfor (int v : a) {\n    v = v * 10;\n}\nSystem.out.println(a[0] + a[1] + a[2]);", "6\n", C27::run);
        check("int i = 0;\nwhile (i < 10 && i * i < 20) {\n    i++;\n}\nSystem.out.println(i);", "5\n", C28::run);
        check("boolean done = false;\nint n = 1;\nwhile (!done) {\n    n *= 2;\n    if (n > 20) {\n        done = true;\n    }\n}\nSystem.out.println(n);", "32\n", C29::run);
        check("int[] a = {3, 1, 2};\nSystem.out.println(a[3]);", "|throws:ArrayIndexOutOfBoundsException", C30::run);
        check("String s = \"abc\";\nfor (int i = 0; i <= s.length(); i++) {\n    System.out.print(s.substring(i, i + 1));\n}", "abc|throws:StringIndexOutOfBoundsException", C31::run);
        check("int n = 0;\nint total = 0;\nfor (int i = 1; i <= n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "0\n", C38::run);
        check("int visits = 0;\nint n = 0;\nint total = 0;\nfor (int i = 1; i <= n; i++) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "0\nvisits=0\n", C39::run);
        check("int n = 0;\nint total = 0;\nint i = 1;\nwhile (i <= n) {\n    total += i;\n    i++;\n}\nSystem.out.println(total);", "0\n", C40::run);
        check("int visits = 0;\nint n = 0;\nint total = 0;\nint i = 1;\nwhile (i <= n) { visits++;\n    total += i;\n    i++;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "0\nvisits=0\n", C41::run);
        check("int n = 1;\nint total = 0;\nfor (int i = 1; i <= n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "1\n", C42::run);
        check("int visits = 0;\nint n = 1;\nint total = 0;\nfor (int i = 1; i <= n; i++) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "1\nvisits=1\n", C43::run);
        check("int n = 1;\nint total = 0;\nint i = 1;\nwhile (i <= n) {\n    total += i;\n    i++;\n}\nSystem.out.println(total);", "1\n", C44::run);
        check("int visits = 0;\nint n = 1;\nint total = 0;\nint i = 1;\nwhile (i <= n) { visits++;\n    total += i;\n    i++;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "1\nvisits=1\n", C45::run);
        check("int n = 5;\nint total = 0;\nfor (int i = 1; i <= n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "15\n", C46::run);
        check("int visits = 0;\nint n = 5;\nint total = 0;\nfor (int i = 1; i <= n; i++) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "15\nvisits=5\n", C47::run);
        check("int n = 5;\nint total = 0;\nint i = 1;\nwhile (i <= n) {\n    total += i;\n    i++;\n}\nSystem.out.println(total);", "15\n", C48::run);
        check("int visits = 0;\nint n = 5;\nint total = 0;\nint i = 1;\nwhile (i <= n) { visits++;\n    total += i;\n    i++;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "15\nvisits=5\n", C49::run);
        check("int n = 6;\nint total = 0;\nfor (int i = 1; i <= n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "21\n", C50::run);
        check("int visits = 0;\nint n = 6;\nint total = 0;\nfor (int i = 1; i <= n; i++) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "21\nvisits=6\n", C51::run);
        check("int n = 6;\nint total = 0;\nint i = 1;\nwhile (i <= n) {\n    total += i;\n    i++;\n}\nSystem.out.println(total);", "21\n", C52::run);
        check("int visits = 0;\nint n = 6;\nint total = 0;\nint i = 1;\nwhile (i <= n) { visits++;\n    total += i;\n    i++;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "21\nvisits=6\n", C53::run);
        check("int n = 0;\nint total = 0;\nfor (int i = n; i >= 1; i--) {\n    total += i;\n}\nSystem.out.println(total);", "0\n", C54::run);
        check("int visits = 0;\nint n = 0;\nint total = 0;\nfor (int i = n; i >= 1; i--) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "0\nvisits=0\n", C55::run);
        check("int n = 1;\nint total = 0;\nfor (int i = n; i >= 1; i--) {\n    total += i;\n}\nSystem.out.println(total);", "1\n", C56::run);
        check("int visits = 0;\nint n = 1;\nint total = 0;\nfor (int i = n; i >= 1; i--) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "1\nvisits=1\n", C57::run);
        check("int n = 5;\nint total = 0;\nfor (int i = n; i >= 1; i--) {\n    total += i;\n}\nSystem.out.println(total);", "15\n", C58::run);
        check("int visits = 0;\nint n = 5;\nint total = 0;\nfor (int i = n; i >= 1; i--) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "15\nvisits=5\n", C59::run);
        check("int n = 6;\nint total = 0;\nfor (int i = n; i >= 1; i--) {\n    total += i;\n}\nSystem.out.println(total);", "21\n", C60::run);
        check("int visits = 0;\nint n = 6;\nint total = 0;\nfor (int i = n; i >= 1; i--) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "21\nvisits=6\n", C61::run);
        check("int n = 1;\nint total = 0;\nint i = 0;\nwhile (i < n) {\n    total += i;\n    i++;\n}\nSystem.out.println(total);", "0\n", C62::run);
        check("int visits = 0;\nint n = 1;\nint total = 0;\nint i = 0;\nwhile (i < n) { visits++;\n    total += i;\n    i++;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "0\nvisits=1\n", C63::run);
        check("int n = 3;\nint total = 0;\nint i = 0;\nwhile (i < n) {\n    total += i;\n    i++;\n}\nSystem.out.println(total);", "3\n", C64::run);
        check("int visits = 0;\nint n = 3;\nint total = 0;\nint i = 0;\nwhile (i < n) { visits++;\n    total += i;\n    i++;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "3\nvisits=3\n", C65::run);
        check("int n = 3;\nint total = 0;\nint i = 1;\nwhile (i <= n) {\n    total += i;\n    i++;\n}\nSystem.out.println(total);", "6\n", C66::run);
        check("int visits = 0;\nint n = 3;\nint total = 0;\nint i = 1;\nwhile (i <= n) { visits++;\n    total += i;\n    i++;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "6\nvisits=3\n", C67::run);
        check("int n = 5;\nint total = 0;\nint i = 0;\nwhile (i < n) {\n    total += i;\n    i++;\n}\nSystem.out.println(total);", "10\n", C68::run);
        check("int visits = 0;\nint n = 5;\nint total = 0;\nint i = 0;\nwhile (i < n) { visits++;\n    total += i;\n    i++;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "10\nvisits=5\n", C69::run);
        check("int n = 1;\nint total = 0;\ntotal = 1;\nfor (int i = 2; i <= n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "1\n", C70::run);
        check("int visits = 0;\nint n = 1;\nint total = 0;\ntotal = 1;\nfor (int i = 2; i <= n; i++) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "1\nvisits=0\n", C71::run);
        check("int n = 2;\nint total = 0;\nfor (int i = 1; i <= n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "3\n", C72::run);
        check("int visits = 0;\nint n = 2;\nint total = 0;\nfor (int i = 1; i <= n; i++) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "3\nvisits=2\n", C73::run);
        check("int n = 2;\nint total = 0;\ntotal = 1;\nfor (int i = 2; i <= n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "3\n", C74::run);
        check("int visits = 0;\nint n = 2;\nint total = 0;\ntotal = 1;\nfor (int i = 2; i <= n; i++) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "3\nvisits=1\n", C75::run);
        check("int n = 5;\nint total = 0;\ntotal = 1;\nfor (int i = 2; i <= n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "15\n", C76::run);
        check("int visits = 0;\nint n = 5;\nint total = 0;\ntotal = 1;\nfor (int i = 2; i <= n; i++) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "15\nvisits=4\n", C77::run);
        check("int n = 0;\nint total = 0;\ntotal = 1;\nfor (int i = 2; i <= n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "1\n", C78::run);
        check("int visits = 0;\nint n = 0;\nint total = 0;\ntotal = 1;\nfor (int i = 2; i <= n; i++) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "1\nvisits=0\n", C79::run);
        check("int n = 3;\nint total = 0;\nfor (int i = 0; i < n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "3\n", C80::run);
        check("int visits = 0;\nint n = 3;\nint total = 0;\nfor (int i = 0; i < n; i++) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "3\nvisits=3\n", C81::run);
        check("int n = 3;\nint total = 0;\nint i = 0;\nwhile (i != n) {\n    total += i;\n    i++;\n}\nSystem.out.println(total);", "3\n", C82::run);
        check("int visits = 0;\nint n = 3;\nint total = 0;\nint i = 0;\nwhile (i != n) { visits++;\n    total += i;\n    i++;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "3\nvisits=3\n", C83::run);
        check("int n = 0;\nint total = 0;\nfor (int i = 0; i < n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "0\n", C84::run);
        check("int visits = 0;\nint n = 0;\nint total = 0;\nfor (int i = 0; i < n; i++) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "0\nvisits=0\n", C85::run);
        check("int n = 0;\nint total = 0;\nint i = 0;\nwhile (i != n) {\n    total += i;\n    i++;\n}\nSystem.out.println(total);", "0\n", C86::run);
        check("int visits = 0;\nint n = 0;\nint total = 0;\nint i = 0;\nwhile (i != n) { visits++;\n    total += i;\n    i++;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "0\nvisits=0\n", C87::run);
        check("int n = -2;\nint total = 0;\nfor (int i = 0; i < n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "0\n", C88::run);
        check("int visits = 0;\nint n = -2;\nint total = 0;\nfor (int i = 0; i < n; i++) { visits++;\n    total += i;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "0\nvisits=0\n", C89::run);
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        if (javac == null) throw new IllegalStateException("A JDK is needed to check compile claims.");
        compileCheck(javac, "int x = 0;\nwhile (x < 100) {\n    x *= 3;\n}", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint x = 0;\nwhile (x < 100) {\n    x *= 3;\n}\n}\n}", true);
        compileCheck(javac, "int p = 1;\nfor (int k = 0; k < 4; k++) {\n    p *= 2;\n}\nSystem.out.println(p + \" \" + k);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint p = 1;\nfor (int k = 0; k < 4; k++) {\n    p *= 2;\n}\nSystem.out.println(p + \" \" + k);\n}\n}", false);
        compileCheck(javac, "int x = 10;\nfor (int x = 0; x < 3; x++) {\n    System.out.print(x);\n}", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint x = 10;\nfor (int x = 0; x < 3; x++) {\n    System.out.print(x);\n}\n}\n}", false);
        compileCheck(javac, "while (false) {\n    System.out.println(1);\n}", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nwhile (false) {\n    System.out.println(1);\n}\n}\n}", false);
        compileCheck(javac, "for (int i = 0; i < 3; i++) {\n    System.out.println(i)\n}", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nfor (int i = 0; i < 3; i++) {\n    System.out.println(i)\n}\n}\n}", false);
        compileCheck(javac, "int i = 0;\nwhile (i) {\n    i++;\n}", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint i = 0;\nwhile (i) {\n    i++;\n}\n}\n}", false);
        compileCheck(javac, "int i = 0;\nwhile (i < 3) {\n    i++;\n    break;\n}", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint i = 0;\nwhile (i < 3) {\n    i++;\n    break;\n}\n}\n}", true);
        compileCheck(javac, "int i = 0;\ndo {\n    i++;\n} while (i < 3);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint i = 0;\ndo {\n    i++;\n} while (i < 3);\n}\n}", true);
        compileCheck(javac, "int n = -2;\nint total = 0;\nint i = 0;\nwhile (i != n) {\n    total += i;\n    i++;\n}\nSystem.out.println(total);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = -2;\nint total = 0;\nint i = 0;\nwhile (i != n) {\n    total += i;\n    i++;\n}\nSystem.out.println(total);\n}\n}", true);
        compileCheck(javac, "int visits = 0;\nint n = -2;\nint total = 0;\nint i = 0;\nwhile (i != n) { visits++;\n    total += i;\n    i++;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint visits = 0;\nint n = -2;\nint total = 0;\nint i = 0;\nwhile (i != n) { visits++;\n    total += i;\n    i++;\n}\nSystem.out.println(total);\nSystem.out.println(\"visits=\" + visits);\n}\n}", true);
        System.out.println(failed == 0 ? "PASS: " + passed + " programs match Java " + System.getProperty("java.version") : failed + " of " + (passed + failed) + " programs differ");
    }
}
