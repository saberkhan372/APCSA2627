// Generated from construct-cases.json by mj-java.mjs. Do not edit by hand.
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

public class ConstructCheck {
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
            int n = 5;
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C1 {

        static void run() {
            int n = 0;
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C2 {

        static void run() {
            int n = 1;
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C3 {

        static void run() {
            int n = 6;
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C4 {

        static void run() {
            int n = 5;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C5 {

        static void run() {
            int n = 0;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C6 {

        static void run() {
            int n = 1;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C7 {

        static void run() {
            int n = 6;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C8 {

        static void run() {
            int n = 5;
            int sum = n;
            for (int i = 0; i < n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C9 {

        static void run() {
            int n = 0;
            int sum = n;
            for (int i = 0; i < n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C10 {

        static void run() {
            int n = 1;
            int sum = n;
            for (int i = 0; i < n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C11 {

        static void run() {
            int n = 6;
            int sum = n;
            for (int i = 0; i < n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C12 {

        static void run() {
            int n = 5;
            int sum = n;
            for (int i = 0; i != n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C13 {

        static void run() {
            int n = 0;
            int sum = n;
            for (int i = 0; i != n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C14 {

        static void run() {
            int n = 1;
            int sum = n;
            for (int i = 0; i != n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C15 {

        static void run() {
            int n = 6;
            int sum = n;
            for (int i = 0; i != n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C16 {

        static void run() {
            int n = 5;
            int sum = n;
            for (int i = 1; i < n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C17 {

        static void run() {
            int n = 0;
            int sum = n;
            for (int i = 1; i < n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C18 {

        static void run() {
            int n = 1;
            int sum = n;
            for (int i = 1; i < n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C19 {

        static void run() {
            int n = 6;
            int sum = n;
            for (int i = 1; i < n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C20 {

        static void run() {
            int n = 5;
            int sum = 1;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C21 {

        static void run() {
            int n = 0;
            int sum = 1;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C22 {

        static void run() {
            int n = 1;
            int sum = 1;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C23 {

        static void run() {
            int n = 6;
            int sum = 1;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C24 {

        static void run() {
            int n = 5;
            int sum = n;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C25 {

        static void run() {
            int n = 0;
            int sum = n;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C26 {

        static void run() {
            int n = 1;
            int sum = n;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C27 {

        static void run() {
            int n = 6;
            int sum = n;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C28 {

        static void run() {
            int n = 5;
            int sum = 0;
            for (int i = 2; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C29 {

        static void run() {
            int n = 0;
            int sum = 0;
            for (int i = 2; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C30 {

        static void run() {
            int n = 1;
            int sum = 0;
            for (int i = 2; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C31 {

        static void run() {
            int n = 6;
            int sum = 0;
            for (int i = 2; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C32 {

        static void run() {
            int n = 5;
            int sum = 0;
            for (int i = 1; i < n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C33 {

        static void run() {
            int n = 0;
            int sum = 0;
            for (int i = 1; i < n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C34 {

        static void run() {
            int n = 1;
            int sum = 0;
            for (int i = 1; i < n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C35 {

        static void run() {
            int n = 6;
            int sum = 0;
            for (int i = 1; i < n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C36 {

        static void run() {
            int n = 5;
            int sum = 0;
            for (int i = 1; i <= n + 1; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C37 {

        static void run() {
            int n = 0;
            int sum = 0;
            for (int i = 1; i <= n + 1; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C38 {

        static void run() {
            int n = 1;
            int sum = 0;
            for (int i = 1; i <= n + 1; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C39 {

        static void run() {
            int n = 6;
            int sum = 0;
            for (int i = 1; i <= n + 1; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C40 {

        static void run() {
            int n = 5;
            int sum = 0;
            for (int i = 1; i != n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C42 {

        static void run() {
            int n = 1;
            int sum = 0;
            for (int i = 1; i != n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C43 {

        static void run() {
            int n = 6;
            int sum = 0;
            for (int i = 1; i != n; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C44 {

        static void run() {
            int n = 5;
            int sum = 0;
            for (int i = 1; i <= n; i += 2) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C45 {

        static void run() {
            int n = 0;
            int sum = 0;
            for (int i = 1; i <= n; i += 2) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C46 {

        static void run() {
            int n = 1;
            int sum = 0;
            for (int i = 1; i <= n; i += 2) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C47 {

        static void run() {
            int n = 6;
            int sum = 0;
            for (int i = 1; i <= n; i += 2) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C49 {

        static void run() {
            int n = 0;
            int sum = 0;
            for (int i = 1; i <= n; i--) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    static class C52 {

        static void run() {
            int n = 5;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
                System.out.println(sum);
            }
            System.out.println(sum);
        }
    }

    static class C53 {

        static void run() {
            int n = 0;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
                System.out.println(sum);
            }
            System.out.println(sum);
        }
    }

    static class C54 {

        static void run() {
            int n = 1;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
                System.out.println(sum);
            }
            System.out.println(sum);
        }
    }

    static class C55 {

        static void run() {
            int n = 6;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
                System.out.println(sum);
            }
            System.out.println(sum);
        }
    }

    static class C56 {

        static void run() {
            int n = 10;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C57 {

        static void run() {
            int n = 0;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C58 {

        static void run() {
            int n = 3;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C59 {

        static void run() {
            int n = 9;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C60 {

        static void run() {
            int n = 2;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C61 {

        static void run() {
            int n = 10;
            int count = 0;
            for (int i = 3; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C62 {

        static void run() {
            int n = 0;
            int count = 0;
            for (int i = 3; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C63 {

        static void run() {
            int n = 3;
            int count = 0;
            for (int i = 3; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C64 {

        static void run() {
            int n = 9;
            int count = 0;
            for (int i = 3; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C65 {

        static void run() {
            int n = 2;
            int count = 0;
            for (int i = 3; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C66 {

        static void run() {
            int n = 10;
            int count = 0;
            for (int i = 3; i <= n; i += 3) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C67 {

        static void run() {
            int n = 0;
            int count = 0;
            for (int i = 3; i <= n; i += 3) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C68 {

        static void run() {
            int n = 3;
            int count = 0;
            for (int i = 3; i <= n; i += 3) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C69 {

        static void run() {
            int n = 9;
            int count = 0;
            for (int i = 3; i <= n; i += 3) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C70 {

        static void run() {
            int n = 2;
            int count = 0;
            for (int i = 3; i <= n; i += 3) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C71 {

        static void run() {
            int n = 10;
            int count = 1;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C72 {

        static void run() {
            int n = 0;
            int count = 1;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C73 {

        static void run() {
            int n = 3;
            int count = 1;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C74 {

        static void run() {
            int n = 9;
            int count = 1;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C75 {

        static void run() {
            int n = 2;
            int count = 1;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C76 {

        static void run() {
            int n = 10;
            int count = n;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C77 {

        static void run() {
            int n = 0;
            int count = n;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C78 {

        static void run() {
            int n = 3;
            int count = n;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C79 {

        static void run() {
            int n = 9;
            int count = n;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C80 {

        static void run() {
            int n = 2;
            int count = n;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C81 {

        static void run() {
            int n = 10;
            int count = 0;
            for (int i = 0; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C82 {

        static void run() {
            int n = 0;
            int count = 0;
            for (int i = 0; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C83 {

        static void run() {
            int n = 3;
            int count = 0;
            for (int i = 0; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C84 {

        static void run() {
            int n = 9;
            int count = 0;
            for (int i = 0; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C85 {

        static void run() {
            int n = 2;
            int count = 0;
            for (int i = 0; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C86 {

        static void run() {
            int n = 10;
            int count = 0;
            for (int i = 1; i < n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C87 {

        static void run() {
            int n = 0;
            int count = 0;
            for (int i = 1; i < n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C88 {

        static void run() {
            int n = 3;
            int count = 0;
            for (int i = 1; i < n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C89 {

        static void run() {
            int n = 9;
            int count = 0;
            for (int i = 1; i < n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C90 {

        static void run() {
            int n = 2;
            int count = 0;
            for (int i = 1; i < n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C91 {

        static void run() {
            int n = 10;
            int count = 0;
            for (int i = 1; i <= n / 3; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C92 {

        static void run() {
            int n = 0;
            int count = 0;
            for (int i = 1; i <= n / 3; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C93 {

        static void run() {
            int n = 3;
            int count = 0;
            for (int i = 1; i <= n / 3; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C94 {

        static void run() {
            int n = 9;
            int count = 0;
            for (int i = 1; i <= n / 3; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C95 {

        static void run() {
            int n = 2;
            int count = 0;
            for (int i = 1; i <= n / 3; i++) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C96 {

        static void run() {
            int n = 10;
            int count = 0;
            for (int i = 1; i <= n; i += 3) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C97 {

        static void run() {
            int n = 0;
            int count = 0;
            for (int i = 1; i <= n; i += 3) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C98 {

        static void run() {
            int n = 3;
            int count = 0;
            for (int i = 1; i <= n; i += 3) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C99 {

        static void run() {
            int n = 9;
            int count = 0;
            for (int i = 1; i <= n; i += 3) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C100 {

        static void run() {
            int n = 2;
            int count = 0;
            for (int i = 1; i <= n; i += 3) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C102 {

        static void run() {
            int n = 0;
            int count = 0;
            for (int i = 1; i <= n; i--) {
                if (i % 3 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C106 {

        static void run() {
            int n = 10;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
                System.out.println(count);
            }
            System.out.println(count);
        }
    }

    static class C107 {

        static void run() {
            int n = 0;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
                System.out.println(count);
            }
            System.out.println(count);
        }
    }

    static class C108 {

        static void run() {
            int n = 3;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
                System.out.println(count);
            }
            System.out.println(count);
        }
    }

    static class C109 {

        static void run() {
            int n = 9;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
                System.out.println(count);
            }
            System.out.println(count);
        }
    }

    static class C110 {

        static void run() {
            int n = 2;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    count++;
                }
                System.out.println(count);
            }
            System.out.println(count);
        }
    }

    static class C111 {

        static void run() {
            int n = 10;
            int total = 0;
            for (int i = 0; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C112 {

        static void run() {
            int n = 7;
            int total = 0;
            for (int i = 0; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C113 {

        static void run() {
            int n = 1;
            int total = 0;
            for (int i = 0; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C114 {

        static void run() {
            int n = 2;
            int total = 0;
            for (int i = 0; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C115 {

        static void run() {
            int n = 0;
            int total = 0;
            for (int i = 0; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C116 {

        static void run() {
            int n = 10;
            int total = 0;
            for (int i = 2; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C117 {

        static void run() {
            int n = 7;
            int total = 0;
            for (int i = 2; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C118 {

        static void run() {
            int n = 1;
            int total = 0;
            for (int i = 2; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C119 {

        static void run() {
            int n = 2;
            int total = 0;
            for (int i = 2; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C120 {

        static void run() {
            int n = 0;
            int total = 0;
            for (int i = 2; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C121 {

        static void run() {
            int n = 10;
            int total = 2;
            for (int i = 2; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C122 {

        static void run() {
            int n = 7;
            int total = 2;
            for (int i = 2; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C123 {

        static void run() {
            int n = 1;
            int total = 2;
            for (int i = 2; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C124 {

        static void run() {
            int n = 2;
            int total = 2;
            for (int i = 2; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C125 {

        static void run() {
            int n = 0;
            int total = 2;
            for (int i = 2; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C126 {

        static void run() {
            int n = 10;
            int total = 0;
            for (int i = 1; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C127 {

        static void run() {
            int n = 7;
            int total = 0;
            for (int i = 1; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C128 {

        static void run() {
            int n = 1;
            int total = 0;
            for (int i = 1; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C129 {

        static void run() {
            int n = 2;
            int total = 0;
            for (int i = 1; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C130 {

        static void run() {
            int n = 0;
            int total = 0;
            for (int i = 1; i <= n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C131 {

        static void run() {
            int n = 10;
            int total = 0;
            for (int i = 2; i < n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C132 {

        static void run() {
            int n = 7;
            int total = 0;
            for (int i = 2; i < n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C133 {

        static void run() {
            int n = 1;
            int total = 0;
            for (int i = 2; i < n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C134 {

        static void run() {
            int n = 2;
            int total = 0;
            for (int i = 2; i < n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C135 {

        static void run() {
            int n = 0;
            int total = 0;
            for (int i = 2; i < n; i += 2) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C136 {

        static void run() {
            int n = 10;
            int total = 0;
            for (int i = 2; i <= n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C137 {

        static void run() {
            int n = 7;
            int total = 0;
            for (int i = 2; i <= n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C138 {

        static void run() {
            int n = 1;
            int total = 0;
            for (int i = 2; i <= n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C139 {

        static void run() {
            int n = 2;
            int total = 0;
            for (int i = 2; i <= n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C140 {

        static void run() {
            int n = 0;
            int total = 0;
            for (int i = 2; i <= n; i++) {
                total += i;
            }
            System.out.println(total);
        }
    }

    static class C141 {

        static void run() {
            int n = 10;
            int total = 0;
            for (int i = 2; i <= n; i += 2) {
                total += i;
                System.out.println(total);
            }
            System.out.println(total);
        }
    }

    static class C142 {

        static void run() {
            int n = 7;
            int total = 0;
            for (int i = 2; i <= n; i += 2) {
                total += i;
                System.out.println(total);
            }
            System.out.println(total);
        }
    }

    static class C143 {

        static void run() {
            int n = 1;
            int total = 0;
            for (int i = 2; i <= n; i += 2) {
                total += i;
                System.out.println(total);
            }
            System.out.println(total);
        }
    }

    static class C144 {

        static void run() {
            int n = 2;
            int total = 0;
            for (int i = 2; i <= n; i += 2) {
                total += i;
                System.out.println(total);
            }
            System.out.println(total);
        }
    }

    static class C145 {

        static void run() {
            int n = 0;
            int total = 0;
            for (int i = 2; i <= n; i += 2) {
                total += i;
                System.out.println(total);
            }
            System.out.println(total);
        }
    }

    static class C146 {

        static void run() {
            int[] a = {-7, -3, -9};
            int max = a[0];
            for (int i = 0; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C147 {

        static void run() {
            int[] a = {4, 9, 2};
            int max = a[0];
            for (int i = 0; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C148 {

        static void run() {
            int[] a = {5};
            int max = a[0];
            for (int i = 0; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C149 {

        static void run() {
            int[] a = {2, 8};
            int max = a[0];
            for (int i = 0; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C150 {

        static void run() {
            int[] a = {6, 1, 3};
            int max = a[0];
            for (int i = 0; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C151 {

        static void run() {
            int[] a = {1, 2, 3, 4, 5};
            int max = a[0];
            for (int i = 0; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C152 {

        static void run() {
            int[] a = {-7, -3, -9};
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C153 {

        static void run() {
            int[] a = {4, 9, 2};
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C154 {

        static void run() {
            int[] a = {5};
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C155 {

        static void run() {
            int[] a = {2, 8};
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C156 {

        static void run() {
            int[] a = {6, 1, 3};
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C157 {

        static void run() {
            int[] a = {1, 2, 3, 4, 5};
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C158 {

        static void run() {
            int[] a = {-7, -3, -9};
            int max = 0;
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C159 {

        static void run() {
            int[] a = {4, 9, 2};
            int max = 0;
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C160 {

        static void run() {
            int[] a = {5};
            int max = 0;
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C161 {

        static void run() {
            int[] a = {2, 8};
            int max = 0;
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C162 {

        static void run() {
            int[] a = {6, 1, 3};
            int max = 0;
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C163 {

        static void run() {
            int[] a = {1, 2, 3, 4, 5};
            int max = 0;
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C164 {

        static void run() {
            int[] a = {-7, -3, -9};
            int max = a.length;
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C165 {

        static void run() {
            int[] a = {4, 9, 2};
            int max = a.length;
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C166 {

        static void run() {
            int[] a = {5};
            int max = a.length;
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C167 {

        static void run() {
            int[] a = {2, 8};
            int max = a.length;
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C168 {

        static void run() {
            int[] a = {6, 1, 3};
            int max = a.length;
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C169 {

        static void run() {
            int[] a = {1, 2, 3, 4, 5};
            int max = a.length;
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C170 {

        static void run() {
            int[] a = {-7, -3, -9};
            int max = a[0];
            for (int i = 2; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C171 {

        static void run() {
            int[] a = {4, 9, 2};
            int max = a[0];
            for (int i = 2; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C172 {

        static void run() {
            int[] a = {5};
            int max = a[0];
            for (int i = 2; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C173 {

        static void run() {
            int[] a = {2, 8};
            int max = a[0];
            for (int i = 2; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C174 {

        static void run() {
            int[] a = {6, 1, 3};
            int max = a[0];
            for (int i = 2; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C175 {

        static void run() {
            int[] a = {1, 2, 3, 4, 5};
            int max = a[0];
            for (int i = 2; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C176 {

        static void run() {
            int[] a = {-7, -3, -9};
            int max = a[0];
            for (int i = 1; i <= a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C177 {

        static void run() {
            int[] a = {4, 9, 2};
            int max = a[0];
            for (int i = 1; i <= a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C178 {

        static void run() {
            int[] a = {5};
            int max = a[0];
            for (int i = 1; i <= a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C179 {

        static void run() {
            int[] a = {2, 8};
            int max = a[0];
            for (int i = 1; i <= a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C180 {

        static void run() {
            int[] a = {6, 1, 3};
            int max = a[0];
            for (int i = 1; i <= a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C181 {

        static void run() {
            int[] a = {1, 2, 3, 4, 5};
            int max = a[0];
            for (int i = 1; i <= a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C182 {

        static void run() {
            int[] a = {-7, -3, -9};
            int max = a[0];
            for (int i = 1; i < a.length - 1; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C183 {

        static void run() {
            int[] a = {4, 9, 2};
            int max = a[0];
            for (int i = 1; i < a.length - 1; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C184 {

        static void run() {
            int[] a = {5};
            int max = a[0];
            for (int i = 1; i < a.length - 1; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C185 {

        static void run() {
            int[] a = {2, 8};
            int max = a[0];
            for (int i = 1; i < a.length - 1; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C186 {

        static void run() {
            int[] a = {6, 1, 3};
            int max = a[0];
            for (int i = 1; i < a.length - 1; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C187 {

        static void run() {
            int[] a = {1, 2, 3, 4, 5};
            int max = a[0];
            for (int i = 1; i < a.length - 1; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C188 {

        static void run() {
            int[] a = {-7, -3, -9};
            int max = a[0];
            for (int i = 1; i < a.length; i += 2) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C189 {

        static void run() {
            int[] a = {4, 9, 2};
            int max = a[0];
            for (int i = 1; i < a.length; i += 2) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C190 {

        static void run() {
            int[] a = {5};
            int max = a[0];
            for (int i = 1; i < a.length; i += 2) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C191 {

        static void run() {
            int[] a = {2, 8};
            int max = a[0];
            for (int i = 1; i < a.length; i += 2) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C192 {

        static void run() {
            int[] a = {6, 1, 3};
            int max = a[0];
            for (int i = 1; i < a.length; i += 2) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C193 {

        static void run() {
            int[] a = {1, 2, 3, 4, 5};
            int max = a[0];
            for (int i = 1; i < a.length; i += 2) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println(max);
        }
    }

    static class C194 {

        static void run() {
            int[] a = {-7, -3, -9};
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
                System.out.println(max);
            }
            System.out.println(max);
        }
    }

    static class C195 {

        static void run() {
            int[] a = {4, 9, 2};
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
                System.out.println(max);
            }
            System.out.println(max);
        }
    }

    static class C196 {

        static void run() {
            int[] a = {5};
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
                System.out.println(max);
            }
            System.out.println(max);
        }
    }

    static class C197 {

        static void run() {
            int[] a = {2, 8};
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
                System.out.println(max);
            }
            System.out.println(max);
        }
    }

    static class C198 {

        static void run() {
            int[] a = {6, 1, 3};
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
                System.out.println(max);
            }
            System.out.println(max);
        }
    }

    static class C199 {

        static void run() {
            int[] a = {1, 2, 3, 4, 5};
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
                System.out.println(max);
            }
            System.out.println(max);
        }
    }

    static class C200 {

        static void run() {
            String word = "pizza";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C201 {

        static void run() {
            String word = "plain";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C202 {

        static void run() {
            String word = "z";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C203 {

        static void run() {
            String word = "fizz";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C204 {

        static void run() {
            String word = "az";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C205 {

        static void run() {
            String word = "pizza";
            boolean found = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C206 {

        static void run() {
            String word = "plain";
            boolean found = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C207 {

        static void run() {
            String word = "z";
            boolean found = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C208 {

        static void run() {
            String word = "fizz";
            boolean found = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C209 {

        static void run() {
            String word = "az";
            boolean found = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C210 {

        static void run() {
            String word = "pizza";
            boolean found = false;
            for (int i = 0; i <= word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C211 {

        static void run() {
            String word = "plain";
            boolean found = false;
            for (int i = 0; i <= word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C212 {

        static void run() {
            String word = "z";
            boolean found = false;
            for (int i = 0; i <= word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C213 {

        static void run() {
            String word = "fizz";
            boolean found = false;
            for (int i = 0; i <= word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C214 {

        static void run() {
            String word = "az";
            boolean found = false;
            for (int i = 0; i <= word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C215 {

        static void run() {
            String word = "pizza";
            boolean found = false;
            for (int i = 0; i < word.length() - 1; i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C216 {

        static void run() {
            String word = "plain";
            boolean found = false;
            for (int i = 0; i < word.length() - 1; i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C217 {

        static void run() {
            String word = "z";
            boolean found = false;
            for (int i = 0; i < word.length() - 1; i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C218 {

        static void run() {
            String word = "fizz";
            boolean found = false;
            for (int i = 0; i < word.length() - 1; i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C219 {

        static void run() {
            String word = "az";
            boolean found = false;
            for (int i = 0; i < word.length() - 1; i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
            }
            System.out.println(found);
        }
    }

    static class C220 {

        static void run() {
            String word = "pizza";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = false;
                }
            }
            System.out.println(found);
        }
    }

    static class C221 {

        static void run() {
            String word = "plain";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = false;
                }
            }
            System.out.println(found);
        }
    }

    static class C222 {

        static void run() {
            String word = "z";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = false;
                }
            }
            System.out.println(found);
        }
    }

    static class C223 {

        static void run() {
            String word = "fizz";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = false;
                }
            }
            System.out.println(found);
        }
    }

    static class C224 {

        static void run() {
            String word = "az";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = false;
                }
            }
            System.out.println(found);
        }
    }

    static class C225 {

        static void run() {
            String word = "pizza";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = !found;
                }
            }
            System.out.println(found);
        }
    }

    static class C226 {

        static void run() {
            String word = "plain";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = !found;
                }
            }
            System.out.println(found);
        }
    }

    static class C227 {

        static void run() {
            String word = "z";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = !found;
                }
            }
            System.out.println(found);
        }
    }

    static class C228 {

        static void run() {
            String word = "fizz";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = !found;
                }
            }
            System.out.println(found);
        }
    }

    static class C229 {

        static void run() {
            String word = "az";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = !found;
                }
            }
            System.out.println(found);
        }
    }

    static class C230 {

        static void run() {
            String word = "pizza";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
                System.out.println(found);
            }
            System.out.println(found);
        }
    }

    static class C231 {

        static void run() {
            String word = "plain";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
                System.out.println(found);
            }
            System.out.println(found);
        }
    }

    static class C232 {

        static void run() {
            String word = "z";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
                System.out.println(found);
            }
            System.out.println(found);
        }
    }

    static class C233 {

        static void run() {
            String word = "fizz";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
                System.out.println(found);
            }
            System.out.println(found);
        }
    }

    static class C234 {

        static void run() {
            String word = "az";
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("z")) {
                    found = true;
                }
                System.out.println(found);
            }
            System.out.println(found);
        }
    }

    static class C235 {

        static void run() {
            String word = "loop";
            String rev = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C236 {

        static void run() {
            String word = "abc";
            String rev = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C237 {

        static void run() {
            String word = "a";
            String rev = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C238 {

        static void run() {
            String word = "ab";
            String rev = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C239 {

        static void run() {
            String word = "loop";
            String rev = word;
            for (int i = word.length() - 1; i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C240 {

        static void run() {
            String word = "abc";
            String rev = word;
            for (int i = word.length() - 1; i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C241 {

        static void run() {
            String word = "a";
            String rev = word;
            for (int i = word.length() - 1; i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C242 {

        static void run() {
            String word = "ab";
            String rev = word;
            for (int i = word.length() - 1; i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C243 {

        static void run() {
            String word = "loop";
            String rev = "";
            for (int i = 0; i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C244 {

        static void run() {
            String word = "abc";
            String rev = "";
            for (int i = 0; i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C245 {

        static void run() {
            String word = "a";
            String rev = "";
            for (int i = 0; i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C246 {

        static void run() {
            String word = "ab";
            String rev = "";
            for (int i = 0; i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C247 {

        static void run() {
            String word = "loop";
            String rev = "";
            for (int i = word.length(); i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C248 {

        static void run() {
            String word = "abc";
            String rev = "";
            for (int i = word.length(); i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C249 {

        static void run() {
            String word = "a";
            String rev = "";
            for (int i = word.length(); i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C250 {

        static void run() {
            String word = "ab";
            String rev = "";
            for (int i = word.length(); i >= 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C251 {

        static void run() {
            String word = "loop";
            String rev = "";
            for (int i = word.length() - 1; i < word.length(); i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C252 {

        static void run() {
            String word = "abc";
            String rev = "";
            for (int i = word.length() - 1; i < word.length(); i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C253 {

        static void run() {
            String word = "a";
            String rev = "";
            for (int i = word.length() - 1; i < word.length(); i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C254 {

        static void run() {
            String word = "ab";
            String rev = "";
            for (int i = word.length() - 1; i < word.length(); i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C255 {

        static void run() {
            String word = "loop";
            String rev = "";
            for (int i = word.length() - 1; i > 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C256 {

        static void run() {
            String word = "abc";
            String rev = "";
            for (int i = word.length() - 1; i > 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C257 {

        static void run() {
            String word = "a";
            String rev = "";
            for (int i = word.length() - 1; i > 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C258 {

        static void run() {
            String word = "ab";
            String rev = "";
            for (int i = word.length() - 1; i > 0; i--) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C259 {

        static void run() {
            String word = "loop";
            String rev = "";
            for (int i = word.length() - 1; i >= 0; i++) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C260 {

        static void run() {
            String word = "abc";
            String rev = "";
            for (int i = word.length() - 1; i >= 0; i++) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C261 {

        static void run() {
            String word = "a";
            String rev = "";
            for (int i = word.length() - 1; i >= 0; i++) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C262 {

        static void run() {
            String word = "ab";
            String rev = "";
            for (int i = word.length() - 1; i >= 0; i++) {
                rev += word.substring(i, i + 1);
            }
            System.out.println(rev);
        }
    }

    static class C263 {

        static void run() {
            String word = "loop";
            String rev = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                rev += word.substring(i, i + 1);
                System.out.println(rev);
            }
            System.out.println(rev);
        }
    }

    static class C264 {

        static void run() {
            String word = "abc";
            String rev = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                rev += word.substring(i, i + 1);
                System.out.println(rev);
            }
            System.out.println(rev);
        }
    }

    static class C265 {

        static void run() {
            String word = "a";
            String rev = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                rev += word.substring(i, i + 1);
                System.out.println(rev);
            }
            System.out.println(rev);
        }
    }

    static class C266 {

        static void run() {
            String word = "ab";
            String rev = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                rev += word.substring(i, i + 1);
                System.out.println(rev);
            }
            System.out.println(rev);
        }
    }

    static class C267 {

        static void run() {
            int n = 10;
            int p = 1;
            while (p < n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C268 {

        static void run() {
            int n = 16;
            int p = 1;
            while (p < n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C269 {

        static void run() {
            int n = 1;
            int p = 1;
            while (p < n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C270 {

        static void run() {
            int n = 17;
            int p = 1;
            while (p < n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C271 {

        static void run() {
            int n = 0;
            int p = 1;
            while (p < n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C276 {

        static void run() {
            int n = 0;
            int p = 0;
            while (p < n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C277 {

        static void run() {
            int n = 10;
            int p = 2;
            while (p < n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C278 {

        static void run() {
            int n = 16;
            int p = 2;
            while (p < n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C279 {

        static void run() {
            int n = 1;
            int p = 2;
            while (p < n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C280 {

        static void run() {
            int n = 17;
            int p = 2;
            while (p < n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C281 {

        static void run() {
            int n = 0;
            int p = 2;
            while (p < n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C282 {

        static void run() {
            int n = 10;
            int p = 1;
            while (p <= n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C283 {

        static void run() {
            int n = 16;
            int p = 1;
            while (p <= n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C284 {

        static void run() {
            int n = 1;
            int p = 1;
            while (p <= n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C285 {

        static void run() {
            int n = 17;
            int p = 1;
            while (p <= n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C286 {

        static void run() {
            int n = 0;
            int p = 1;
            while (p <= n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C287 {

        static void run() {
            int n = 10;
            int p = 1;
            while (p > n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C288 {

        static void run() {
            int n = 16;
            int p = 1;
            while (p > n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C289 {

        static void run() {
            int n = 1;
            int p = 1;
            while (p > n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C290 {

        static void run() {
            int n = 17;
            int p = 1;
            while (p > n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C291 {

        static void run() {
            int n = 0;
            int p = 1;
            while (p > n) {
                p = p * 2;
            }
            System.out.println(p);
        }
    }

    static class C292 {

        static void run() {
            int n = 10;
            int p = 1;
            while (p < n) {
                p = p + 2;
            }
            System.out.println(p);
        }
    }

    static class C293 {

        static void run() {
            int n = 16;
            int p = 1;
            while (p < n) {
                p = p + 2;
            }
            System.out.println(p);
        }
    }

    static class C294 {

        static void run() {
            int n = 1;
            int p = 1;
            while (p < n) {
                p = p + 2;
            }
            System.out.println(p);
        }
    }

    static class C295 {

        static void run() {
            int n = 17;
            int p = 1;
            while (p < n) {
                p = p + 2;
            }
            System.out.println(p);
        }
    }

    static class C296 {

        static void run() {
            int n = 0;
            int p = 1;
            while (p < n) {
                p = p + 2;
            }
            System.out.println(p);
        }
    }

    static class C299 {

        static void run() {
            int n = 1;
            int p = 1;
            while (p < n) {
                p = p * p;
            }
            System.out.println(p);
        }
    }

    static class C301 {

        static void run() {
            int n = 0;
            int p = 1;
            while (p < n) {
                p = p * p;
            }
            System.out.println(p);
        }
    }

    static class C302 {

        static void run() {
            int n = 10;
            int p = 1;
            while (p < n) {
                p = p * 2;
                System.out.println(p);
            }
            System.out.println(p);
        }
    }

    static class C303 {

        static void run() {
            int n = 16;
            int p = 1;
            while (p < n) {
                p = p * 2;
                System.out.println(p);
            }
            System.out.println(p);
        }
    }

    static class C304 {

        static void run() {
            int n = 1;
            int p = 1;
            while (p < n) {
                p = p * 2;
                System.out.println(p);
            }
            System.out.println(p);
        }
    }

    static class C305 {

        static void run() {
            int n = 17;
            int p = 1;
            while (p < n) {
                p = p * 2;
                System.out.println(p);
            }
            System.out.println(p);
        }
    }

    static class C306 {

        static void run() {
            int n = 0;
            int p = 1;
            while (p < n) {
                p = p * 2;
                System.out.println(p);
            }
            System.out.println(p);
        }
    }

    static class C307 {

        static void run() {
            int n = 4721;
            int count = 0;
            while (n > 0) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C308 {

        static void run() {
            int n = 5;
            int count = 0;
            while (n > 0) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C309 {

        static void run() {
            int n = 10;
            int count = 0;
            while (n > 0) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C310 {

        static void run() {
            int n = 100;
            int count = 0;
            while (n > 0) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C311 {

        static void run() {
            int n = 999;
            int count = 0;
            while (n > 0) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C312 {

        static void run() {
            int n = 4721;
            int count = 1;
            while (n > 0) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C313 {

        static void run() {
            int n = 5;
            int count = 1;
            while (n > 0) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C314 {

        static void run() {
            int n = 10;
            int count = 1;
            while (n > 0) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C315 {

        static void run() {
            int n = 100;
            int count = 1;
            while (n > 0) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C316 {

        static void run() {
            int n = 999;
            int count = 1;
            while (n > 0) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C322 {

        static void run() {
            int n = 4721;
            int count = 0;
            while (n > 10) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C323 {

        static void run() {
            int n = 5;
            int count = 0;
            while (n > 10) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C324 {

        static void run() {
            int n = 10;
            int count = 0;
            while (n > 10) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C325 {

        static void run() {
            int n = 100;
            int count = 0;
            while (n > 10) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C326 {

        static void run() {
            int n = 999;
            int count = 0;
            while (n > 10) {
                n /= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C327 {

        static void run() {
            int n = 4721;
            int count = 0;
            while (n > 0) {
                n -= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C328 {

        static void run() {
            int n = 5;
            int count = 0;
            while (n > 0) {
                n -= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C329 {

        static void run() {
            int n = 10;
            int count = 0;
            while (n > 0) {
                n -= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C330 {

        static void run() {
            int n = 100;
            int count = 0;
            while (n > 0) {
                n -= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C331 {

        static void run() {
            int n = 999;
            int count = 0;
            while (n > 0) {
                n -= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C334 {

        static void run() {
            int n = 10;
            int count = 0;
            while (n > 0) {
                n %= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C335 {

        static void run() {
            int n = 100;
            int count = 0;
            while (n > 0) {
                n %= 10;
                count++;
            }
            System.out.println(count);
        }
    }

    static class C337 {

        static void run() {
            int n = 4721;
            int count = 0;
            while (n > 0) {
                n /= 10;
                count++;
                System.out.println(count);
            }
            System.out.println(count);
        }
    }

    static class C338 {

        static void run() {
            int n = 5;
            int count = 0;
            while (n > 0) {
                n /= 10;
                count++;
                System.out.println(count);
            }
            System.out.println(count);
        }
    }

    static class C339 {

        static void run() {
            int n = 10;
            int count = 0;
            while (n > 0) {
                n /= 10;
                count++;
                System.out.println(count);
            }
            System.out.println(count);
        }
    }

    static class C340 {

        static void run() {
            int n = 100;
            int count = 0;
            while (n > 0) {
                n /= 10;
                count++;
                System.out.println(count);
            }
            System.out.println(count);
        }
    }

    static class C341 {

        static void run() {
            int n = 999;
            int count = 0;
            while (n > 0) {
                n /= 10;
                count++;
                System.out.println(count);
            }
            System.out.println(count);
        }
    }

    static class C342 {

        static void run() {
            int n = 5;
            int product = 1;
            for (int i = 1; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C343 {

        static void run() {
            int n = 0;
            int product = 1;
            for (int i = 1; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C344 {

        static void run() {
            int n = 1;
            int product = 1;
            for (int i = 1; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C345 {

        static void run() {
            int n = 3;
            int product = 1;
            for (int i = 1; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C346 {

        static void run() {
            int n = 5;
            int product = 1;
            for (int i = 2; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C347 {

        static void run() {
            int n = 0;
            int product = 1;
            for (int i = 2; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C348 {

        static void run() {
            int n = 1;
            int product = 1;
            for (int i = 2; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C349 {

        static void run() {
            int n = 3;
            int product = 1;
            for (int i = 2; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C350 {

        static void run() {
            int n = 5;
            int product = 0;
            for (int i = 1; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C351 {

        static void run() {
            int n = 0;
            int product = 0;
            for (int i = 1; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C352 {

        static void run() {
            int n = 1;
            int product = 0;
            for (int i = 1; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C353 {

        static void run() {
            int n = 3;
            int product = 0;
            for (int i = 1; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C354 {

        static void run() {
            int n = 5;
            int product = n;
            for (int i = 1; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C355 {

        static void run() {
            int n = 0;
            int product = n;
            for (int i = 1; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C356 {

        static void run() {
            int n = 1;
            int product = n;
            for (int i = 1; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C357 {

        static void run() {
            int n = 3;
            int product = n;
            for (int i = 1; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C358 {

        static void run() {
            int n = 5;
            int product = 1;
            for (int i = 0; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C359 {

        static void run() {
            int n = 0;
            int product = 1;
            for (int i = 0; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C360 {

        static void run() {
            int n = 1;
            int product = 1;
            for (int i = 0; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C361 {

        static void run() {
            int n = 3;
            int product = 1;
            for (int i = 0; i <= n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C362 {

        static void run() {
            int n = 5;
            int product = 1;
            for (int i = 1; i < n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C363 {

        static void run() {
            int n = 0;
            int product = 1;
            for (int i = 1; i < n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C364 {

        static void run() {
            int n = 1;
            int product = 1;
            for (int i = 1; i < n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C365 {

        static void run() {
            int n = 3;
            int product = 1;
            for (int i = 1; i < n; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C366 {

        static void run() {
            int n = 5;
            int product = 1;
            for (int i = 1; i <= n + 1; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C367 {

        static void run() {
            int n = 0;
            int product = 1;
            for (int i = 1; i <= n + 1; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C368 {

        static void run() {
            int n = 1;
            int product = 1;
            for (int i = 1; i <= n + 1; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C369 {

        static void run() {
            int n = 3;
            int product = 1;
            for (int i = 1; i <= n + 1; i++) {
                product *= i;
            }
            System.out.println(product);
        }
    }

    static class C370 {

        static void run() {
            int n = 5;
            int product = 1;
            for (int i = 1; i <= n; i++) {
                product *= i;
                System.out.println(product);
            }
            System.out.println(product);
        }
    }

    static class C371 {

        static void run() {
            int n = 0;
            int product = 1;
            for (int i = 1; i <= n; i++) {
                product *= i;
                System.out.println(product);
            }
            System.out.println(product);
        }
    }

    static class C372 {

        static void run() {
            int n = 1;
            int product = 1;
            for (int i = 1; i <= n; i++) {
                product *= i;
                System.out.println(product);
            }
            System.out.println(product);
        }
    }

    static class C373 {

        static void run() {
            int n = 3;
            int product = 1;
            for (int i = 1; i <= n; i++) {
                product *= i;
                System.out.println(product);
            }
            System.out.println(product);
        }
    }

    static class C374 {

        static void run() {
            int[] a = {-2, 5, -1};
            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C375 {

        static void run() {
            int[] a = {3, 4};
            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C376 {

        static void run() {
            int[] a = {-4};
            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C377 {

        static void run() {
            int[] a = {-1, -1, -1};
            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C378 {

        static void run() {
            int[] a = {-2, 5, -1};
            int count = 1;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C379 {

        static void run() {
            int[] a = {3, 4};
            int count = 1;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C380 {

        static void run() {
            int[] a = {-4};
            int count = 1;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C381 {

        static void run() {
            int[] a = {-1, -1, -1};
            int count = 1;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C382 {

        static void run() {
            int[] a = {-2, 5, -1};
            int count = 0;
            for (int i = 1; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C383 {

        static void run() {
            int[] a = {3, 4};
            int count = 0;
            for (int i = 1; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C384 {

        static void run() {
            int[] a = {-4};
            int count = 0;
            for (int i = 1; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C385 {

        static void run() {
            int[] a = {-1, -1, -1};
            int count = 0;
            for (int i = 1; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C386 {

        static void run() {
            int[] a = {-2, 5, -1};
            int count = 0;
            for (int i = 0; i <= a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C387 {

        static void run() {
            int[] a = {3, 4};
            int count = 0;
            for (int i = 0; i <= a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C388 {

        static void run() {
            int[] a = {-4};
            int count = 0;
            for (int i = 0; i <= a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C389 {

        static void run() {
            int[] a = {-1, -1, -1};
            int count = 0;
            for (int i = 0; i <= a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C390 {

        static void run() {
            int[] a = {-2, 5, -1};
            int count = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C391 {

        static void run() {
            int[] a = {3, 4};
            int count = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C392 {

        static void run() {
            int[] a = {-4};
            int count = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C393 {

        static void run() {
            int[] a = {-1, -1, -1};
            int count = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] < 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class C394 {

        static void run() {
            int[] a = {-2, 5, -1};
            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
                System.out.println(count);
            }
            System.out.println(count);
        }
    }

    static class C395 {

        static void run() {
            int[] a = {3, 4};
            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
                System.out.println(count);
            }
            System.out.println(count);
        }
    }

    static class C396 {

        static void run() {
            int[] a = {-4};
            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
                System.out.println(count);
            }
            System.out.println(count);
        }
    }

    static class C397 {

        static void run() {
            int[] a = {-1, -1, -1};
            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < 0) {
                    count++;
                }
                System.out.println(count);
            }
            System.out.println(count);
        }
    }

    static class C398 {

        static void run() {
            int[] a = {3, 5, 1};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C399 {

        static void run() {
            int[] a = {3, -1, 2};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C400 {

        static void run() {
            int[] a = {0};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C401 {

        static void run() {
            int[] a = {-1, -2};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C402 {

        static void run() {
            int[] a = {4, -3};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C403 {

        static void run() {
            int[] a = {3, 5, 1};
            boolean allPos = false;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C404 {

        static void run() {
            int[] a = {3, -1, 2};
            boolean allPos = false;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C405 {

        static void run() {
            int[] a = {0};
            boolean allPos = false;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C406 {

        static void run() {
            int[] a = {-1, -2};
            boolean allPos = false;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C407 {

        static void run() {
            int[] a = {4, -3};
            boolean allPos = false;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C408 {

        static void run() {
            int[] a = {3, 5, 1};
            boolean allPos = true;
            for (int i = 0; i <= a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C409 {

        static void run() {
            int[] a = {3, -1, 2};
            boolean allPos = true;
            for (int i = 0; i <= a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C410 {

        static void run() {
            int[] a = {0};
            boolean allPos = true;
            for (int i = 0; i <= a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C411 {

        static void run() {
            int[] a = {-1, -2};
            boolean allPos = true;
            for (int i = 0; i <= a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C412 {

        static void run() {
            int[] a = {4, -3};
            boolean allPos = true;
            for (int i = 0; i <= a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C413 {

        static void run() {
            int[] a = {3, 5, 1};
            boolean allPos = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C414 {

        static void run() {
            int[] a = {3, -1, 2};
            boolean allPos = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C415 {

        static void run() {
            int[] a = {0};
            boolean allPos = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C416 {

        static void run() {
            int[] a = {-1, -2};
            boolean allPos = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C417 {

        static void run() {
            int[] a = {4, -3};
            boolean allPos = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C418 {

        static void run() {
            int[] a = {3, 5, 1};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = true;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C419 {

        static void run() {
            int[] a = {3, -1, 2};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = true;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C420 {

        static void run() {
            int[] a = {0};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = true;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C421 {

        static void run() {
            int[] a = {-1, -2};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = true;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C422 {

        static void run() {
            int[] a = {4, -3};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = true;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C423 {

        static void run() {
            int[] a = {3, 5, 1};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = !allPos;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C424 {

        static void run() {
            int[] a = {3, -1, 2};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = !allPos;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C425 {

        static void run() {
            int[] a = {0};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = !allPos;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C426 {

        static void run() {
            int[] a = {-1, -2};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = !allPos;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C427 {

        static void run() {
            int[] a = {4, -3};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = !allPos;
                }
            }
            System.out.println(allPos);
        }
    }

    static class C428 {

        static void run() {
            int[] a = {3, 5, 1};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
                System.out.println(allPos);
            }
            System.out.println(allPos);
        }
    }

    static class C429 {

        static void run() {
            int[] a = {3, -1, 2};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
                System.out.println(allPos);
            }
            System.out.println(allPos);
        }
    }

    static class C430 {

        static void run() {
            int[] a = {0};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
                System.out.println(allPos);
            }
            System.out.println(allPos);
        }
    }

    static class C431 {

        static void run() {
            int[] a = {-1, -2};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
                System.out.println(allPos);
            }
            System.out.println(allPos);
        }
    }

    static class C432 {

        static void run() {
            int[] a = {4, -3};
            boolean allPos = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    allPos = false;
                }
                System.out.println(allPos);
            }
            System.out.println(allPos);
        }
    }

    static class C433 {

        static void run() {
            int n = 8;
            int steps = 0;
            while (n > 1) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C434 {

        static void run() {
            int n = 1;
            int steps = 0;
            while (n > 1) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C435 {

        static void run() {
            int n = 10;
            int steps = 0;
            while (n > 1) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C436 {

        static void run() {
            int n = 2;
            int steps = 0;
            while (n > 1) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C437 {

        static void run() {
            int n = 8;
            int steps = 1;
            while (n > 1) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C438 {

        static void run() {
            int n = 1;
            int steps = 1;
            while (n > 1) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C439 {

        static void run() {
            int n = 10;
            int steps = 1;
            while (n > 1) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C440 {

        static void run() {
            int n = 2;
            int steps = 1;
            while (n > 1) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C441 {

        static void run() {
            int n = 8;
            int steps = 0;
            while (n > 0) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C442 {

        static void run() {
            int n = 1;
            int steps = 0;
            while (n > 0) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C443 {

        static void run() {
            int n = 10;
            int steps = 0;
            while (n > 0) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C444 {

        static void run() {
            int n = 2;
            int steps = 0;
            while (n > 0) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C445 {

        static void run() {
            int n = 8;
            int steps = 0;
            while (n >= 1) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C446 {

        static void run() {
            int n = 1;
            int steps = 0;
            while (n >= 1) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C447 {

        static void run() {
            int n = 10;
            int steps = 0;
            while (n >= 1) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C448 {

        static void run() {
            int n = 2;
            int steps = 0;
            while (n >= 1) {
                n /= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C449 {

        static void run() {
            int n = 8;
            int steps = 0;
            while (n > 1) {
                n -= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C450 {

        static void run() {
            int n = 1;
            int steps = 0;
            while (n > 1) {
                n -= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C451 {

        static void run() {
            int n = 10;
            int steps = 0;
            while (n > 1) {
                n -= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C452 {

        static void run() {
            int n = 2;
            int steps = 0;
            while (n > 1) {
                n -= 2;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C453 {

        static void run() {
            int n = 8;
            int steps = 0;
            while (n > 1) {
                n /= 10;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C454 {

        static void run() {
            int n = 1;
            int steps = 0;
            while (n > 1) {
                n /= 10;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C455 {

        static void run() {
            int n = 10;
            int steps = 0;
            while (n > 1) {
                n /= 10;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C456 {

        static void run() {
            int n = 2;
            int steps = 0;
            while (n > 1) {
                n /= 10;
                steps++;
            }
            System.out.println(steps);
        }
    }

    static class C457 {

        static void run() {
            int n = 8;
            int steps = 0;
            while (n > 1) {
                n /= 2;
                steps++;
                System.out.println(steps);
            }
            System.out.println(steps);
        }
    }

    static class C458 {

        static void run() {
            int n = 1;
            int steps = 0;
            while (n > 1) {
                n /= 2;
                steps++;
                System.out.println(steps);
            }
            System.out.println(steps);
        }
    }

    static class C459 {

        static void run() {
            int n = 10;
            int steps = 0;
            while (n > 1) {
                n /= 2;
                steps++;
                System.out.println(steps);
            }
            System.out.println(steps);
        }
    }

    static class C460 {

        static void run() {
            int n = 2;
            int steps = 0;
            while (n > 1) {
                n /= 2;
                steps++;
                System.out.println(steps);
            }
            System.out.println(steps);
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
        check("int n = 5;\nint sum = 0;\nfor (int i = 0; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "15\n", C0::run);
        check("int n = 0;\nint sum = 0;\nfor (int i = 0; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "0\n", C1::run);
        check("int n = 1;\nint sum = 0;\nfor (int i = 0; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "1\n", C2::run);
        check("int n = 6;\nint sum = 0;\nfor (int i = 0; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "21\n", C3::run);
        check("int n = 5;\nint sum = 0;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "15\n", C4::run);
        check("int n = 0;\nint sum = 0;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "0\n", C5::run);
        check("int n = 1;\nint sum = 0;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "1\n", C6::run);
        check("int n = 6;\nint sum = 0;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "21\n", C7::run);
        check("int n = 5;\nint sum = n;\nfor (int i = 0; i < n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "15\n", C8::run);
        check("int n = 0;\nint sum = n;\nfor (int i = 0; i < n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "0\n", C9::run);
        check("int n = 1;\nint sum = n;\nfor (int i = 0; i < n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "1\n", C10::run);
        check("int n = 6;\nint sum = n;\nfor (int i = 0; i < n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "21\n", C11::run);
        check("int n = 5;\nint sum = n;\nfor (int i = 0; i != n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "15\n", C12::run);
        check("int n = 0;\nint sum = n;\nfor (int i = 0; i != n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "0\n", C13::run);
        check("int n = 1;\nint sum = n;\nfor (int i = 0; i != n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "1\n", C14::run);
        check("int n = 6;\nint sum = n;\nfor (int i = 0; i != n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "21\n", C15::run);
        check("int n = 5;\nint sum = n;\nfor (int i = 1; i < n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "15\n", C16::run);
        check("int n = 0;\nint sum = n;\nfor (int i = 1; i < n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "0\n", C17::run);
        check("int n = 1;\nint sum = n;\nfor (int i = 1; i < n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "1\n", C18::run);
        check("int n = 6;\nint sum = n;\nfor (int i = 1; i < n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "21\n", C19::run);
        check("int n = 5;\nint sum = 1;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "16\n", C20::run);
        check("int n = 0;\nint sum = 1;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "1\n", C21::run);
        check("int n = 1;\nint sum = 1;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "2\n", C22::run);
        check("int n = 6;\nint sum = 1;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "22\n", C23::run);
        check("int n = 5;\nint sum = n;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "20\n", C24::run);
        check("int n = 0;\nint sum = n;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "0\n", C25::run);
        check("int n = 1;\nint sum = n;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "2\n", C26::run);
        check("int n = 6;\nint sum = n;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "27\n", C27::run);
        check("int n = 5;\nint sum = 0;\nfor (int i = 2; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "14\n", C28::run);
        check("int n = 0;\nint sum = 0;\nfor (int i = 2; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "0\n", C29::run);
        check("int n = 1;\nint sum = 0;\nfor (int i = 2; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "0\n", C30::run);
        check("int n = 6;\nint sum = 0;\nfor (int i = 2; i <= n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "20\n", C31::run);
        check("int n = 5;\nint sum = 0;\nfor (int i = 1; i < n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "10\n", C32::run);
        check("int n = 0;\nint sum = 0;\nfor (int i = 1; i < n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "0\n", C33::run);
        check("int n = 1;\nint sum = 0;\nfor (int i = 1; i < n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "0\n", C34::run);
        check("int n = 6;\nint sum = 0;\nfor (int i = 1; i < n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "15\n", C35::run);
        check("int n = 5;\nint sum = 0;\nfor (int i = 1; i <= n + 1; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "21\n", C36::run);
        check("int n = 0;\nint sum = 0;\nfor (int i = 1; i <= n + 1; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "1\n", C37::run);
        check("int n = 1;\nint sum = 0;\nfor (int i = 1; i <= n + 1; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "3\n", C38::run);
        check("int n = 6;\nint sum = 0;\nfor (int i = 1; i <= n + 1; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "28\n", C39::run);
        check("int n = 5;\nint sum = 0;\nfor (int i = 1; i != n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "10\n", C40::run);
        check("int n = 1;\nint sum = 0;\nfor (int i = 1; i != n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "0\n", C42::run);
        check("int n = 6;\nint sum = 0;\nfor (int i = 1; i != n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "15\n", C43::run);
        check("int n = 5;\nint sum = 0;\nfor (int i = 1; i <= n; i += 2) {\n    sum += i;\n}\nSystem.out.println(sum);", "9\n", C44::run);
        check("int n = 0;\nint sum = 0;\nfor (int i = 1; i <= n; i += 2) {\n    sum += i;\n}\nSystem.out.println(sum);", "0\n", C45::run);
        check("int n = 1;\nint sum = 0;\nfor (int i = 1; i <= n; i += 2) {\n    sum += i;\n}\nSystem.out.println(sum);", "1\n", C46::run);
        check("int n = 6;\nint sum = 0;\nfor (int i = 1; i <= n; i += 2) {\n    sum += i;\n}\nSystem.out.println(sum);", "9\n", C47::run);
        check("int n = 0;\nint sum = 0;\nfor (int i = 1; i <= n; i--) {\n    sum += i;\n}\nSystem.out.println(sum);", "0\n", C49::run);
        check("int n = 5;\nint sum = 0;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n    System.out.println(sum);\n}\nSystem.out.println(sum);", "1\n3\n6\n10\n15\n15\n", C52::run);
        check("int n = 0;\nint sum = 0;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n    System.out.println(sum);\n}\nSystem.out.println(sum);", "0\n", C53::run);
        check("int n = 1;\nint sum = 0;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n    System.out.println(sum);\n}\nSystem.out.println(sum);", "1\n1\n", C54::run);
        check("int n = 6;\nint sum = 0;\nfor (int i = 1; i <= n; i++) {\n    sum += i;\n    System.out.println(sum);\n}\nSystem.out.println(sum);", "1\n3\n6\n10\n15\n21\n21\n", C55::run);
        check("int n = 10;\nint count = 0;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "3\n", C56::run);
        check("int n = 0;\nint count = 0;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C57::run);
        check("int n = 3;\nint count = 0;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "1\n", C58::run);
        check("int n = 9;\nint count = 0;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "3\n", C59::run);
        check("int n = 2;\nint count = 0;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C60::run);
        check("int n = 10;\nint count = 0;\nfor (int i = 3; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "3\n", C61::run);
        check("int n = 0;\nint count = 0;\nfor (int i = 3; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C62::run);
        check("int n = 3;\nint count = 0;\nfor (int i = 3; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "1\n", C63::run);
        check("int n = 9;\nint count = 0;\nfor (int i = 3; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "3\n", C64::run);
        check("int n = 2;\nint count = 0;\nfor (int i = 3; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C65::run);
        check("int n = 10;\nint count = 0;\nfor (int i = 3; i <= n; i += 3) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "3\n", C66::run);
        check("int n = 0;\nint count = 0;\nfor (int i = 3; i <= n; i += 3) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C67::run);
        check("int n = 3;\nint count = 0;\nfor (int i = 3; i <= n; i += 3) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "1\n", C68::run);
        check("int n = 9;\nint count = 0;\nfor (int i = 3; i <= n; i += 3) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "3\n", C69::run);
        check("int n = 2;\nint count = 0;\nfor (int i = 3; i <= n; i += 3) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C70::run);
        check("int n = 10;\nint count = 1;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "4\n", C71::run);
        check("int n = 0;\nint count = 1;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "1\n", C72::run);
        check("int n = 3;\nint count = 1;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "2\n", C73::run);
        check("int n = 9;\nint count = 1;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "4\n", C74::run);
        check("int n = 2;\nint count = 1;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "1\n", C75::run);
        check("int n = 10;\nint count = n;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "13\n", C76::run);
        check("int n = 0;\nint count = n;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C77::run);
        check("int n = 3;\nint count = n;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "4\n", C78::run);
        check("int n = 9;\nint count = n;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "12\n", C79::run);
        check("int n = 2;\nint count = n;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "2\n", C80::run);
        check("int n = 10;\nint count = 0;\nfor (int i = 0; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "4\n", C81::run);
        check("int n = 0;\nint count = 0;\nfor (int i = 0; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "1\n", C82::run);
        check("int n = 3;\nint count = 0;\nfor (int i = 0; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "2\n", C83::run);
        check("int n = 9;\nint count = 0;\nfor (int i = 0; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "4\n", C84::run);
        check("int n = 2;\nint count = 0;\nfor (int i = 0; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "1\n", C85::run);
        check("int n = 10;\nint count = 0;\nfor (int i = 1; i < n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "3\n", C86::run);
        check("int n = 0;\nint count = 0;\nfor (int i = 1; i < n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C87::run);
        check("int n = 3;\nint count = 0;\nfor (int i = 1; i < n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C88::run);
        check("int n = 9;\nint count = 0;\nfor (int i = 1; i < n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "2\n", C89::run);
        check("int n = 2;\nint count = 0;\nfor (int i = 1; i < n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C90::run);
        check("int n = 10;\nint count = 0;\nfor (int i = 1; i <= n / 3; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "1\n", C91::run);
        check("int n = 0;\nint count = 0;\nfor (int i = 1; i <= n / 3; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C92::run);
        check("int n = 3;\nint count = 0;\nfor (int i = 1; i <= n / 3; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C93::run);
        check("int n = 9;\nint count = 0;\nfor (int i = 1; i <= n / 3; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "1\n", C94::run);
        check("int n = 2;\nint count = 0;\nfor (int i = 1; i <= n / 3; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C95::run);
        check("int n = 10;\nint count = 0;\nfor (int i = 1; i <= n; i += 3) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C96::run);
        check("int n = 0;\nint count = 0;\nfor (int i = 1; i <= n; i += 3) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C97::run);
        check("int n = 3;\nint count = 0;\nfor (int i = 1; i <= n; i += 3) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C98::run);
        check("int n = 9;\nint count = 0;\nfor (int i = 1; i <= n; i += 3) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C99::run);
        check("int n = 2;\nint count = 0;\nfor (int i = 1; i <= n; i += 3) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C100::run);
        check("int n = 0;\nint count = 0;\nfor (int i = 1; i <= n; i--) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C102::run);
        check("int n = 10;\nint count = 0;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n    System.out.println(count);\n}\nSystem.out.println(count);", "0\n0\n1\n1\n1\n2\n2\n2\n3\n3\n3\n", C106::run);
        check("int n = 0;\nint count = 0;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n    System.out.println(count);\n}\nSystem.out.println(count);", "0\n", C107::run);
        check("int n = 3;\nint count = 0;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n    System.out.println(count);\n}\nSystem.out.println(count);", "0\n0\n1\n1\n", C108::run);
        check("int n = 9;\nint count = 0;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n    System.out.println(count);\n}\nSystem.out.println(count);", "0\n0\n1\n1\n1\n2\n2\n2\n3\n3\n", C109::run);
        check("int n = 2;\nint count = 0;\nfor (int i = 1; i <= n; i++) {\n    if (i % 3 == 0) {\n        count++;\n    }\n    System.out.println(count);\n}\nSystem.out.println(count);", "0\n0\n0\n", C110::run);
        check("int n = 10;\nint total = 0;\nfor (int i = 0; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "30\n", C111::run);
        check("int n = 7;\nint total = 0;\nfor (int i = 0; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "12\n", C112::run);
        check("int n = 1;\nint total = 0;\nfor (int i = 0; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "0\n", C113::run);
        check("int n = 2;\nint total = 0;\nfor (int i = 0; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "2\n", C114::run);
        check("int n = 0;\nint total = 0;\nfor (int i = 0; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "0\n", C115::run);
        check("int n = 10;\nint total = 0;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "30\n", C116::run);
        check("int n = 7;\nint total = 0;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "12\n", C117::run);
        check("int n = 1;\nint total = 0;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "0\n", C118::run);
        check("int n = 2;\nint total = 0;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "2\n", C119::run);
        check("int n = 0;\nint total = 0;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "0\n", C120::run);
        check("int n = 10;\nint total = 2;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "32\n", C121::run);
        check("int n = 7;\nint total = 2;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "14\n", C122::run);
        check("int n = 1;\nint total = 2;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "2\n", C123::run);
        check("int n = 2;\nint total = 2;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "4\n", C124::run);
        check("int n = 0;\nint total = 2;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "2\n", C125::run);
        check("int n = 10;\nint total = 0;\nfor (int i = 1; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "25\n", C126::run);
        check("int n = 7;\nint total = 0;\nfor (int i = 1; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "16\n", C127::run);
        check("int n = 1;\nint total = 0;\nfor (int i = 1; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "1\n", C128::run);
        check("int n = 2;\nint total = 0;\nfor (int i = 1; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "1\n", C129::run);
        check("int n = 0;\nint total = 0;\nfor (int i = 1; i <= n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "0\n", C130::run);
        check("int n = 10;\nint total = 0;\nfor (int i = 2; i < n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "20\n", C131::run);
        check("int n = 7;\nint total = 0;\nfor (int i = 2; i < n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "12\n", C132::run);
        check("int n = 1;\nint total = 0;\nfor (int i = 2; i < n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "0\n", C133::run);
        check("int n = 2;\nint total = 0;\nfor (int i = 2; i < n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "0\n", C134::run);
        check("int n = 0;\nint total = 0;\nfor (int i = 2; i < n; i += 2) {\n    total += i;\n}\nSystem.out.println(total);", "0\n", C135::run);
        check("int n = 10;\nint total = 0;\nfor (int i = 2; i <= n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "54\n", C136::run);
        check("int n = 7;\nint total = 0;\nfor (int i = 2; i <= n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "27\n", C137::run);
        check("int n = 1;\nint total = 0;\nfor (int i = 2; i <= n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "0\n", C138::run);
        check("int n = 2;\nint total = 0;\nfor (int i = 2; i <= n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "2\n", C139::run);
        check("int n = 0;\nint total = 0;\nfor (int i = 2; i <= n; i++) {\n    total += i;\n}\nSystem.out.println(total);", "0\n", C140::run);
        check("int n = 10;\nint total = 0;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n    System.out.println(total);\n}\nSystem.out.println(total);", "2\n6\n12\n20\n30\n30\n", C141::run);
        check("int n = 7;\nint total = 0;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n    System.out.println(total);\n}\nSystem.out.println(total);", "2\n6\n12\n12\n", C142::run);
        check("int n = 1;\nint total = 0;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n    System.out.println(total);\n}\nSystem.out.println(total);", "0\n", C143::run);
        check("int n = 2;\nint total = 0;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n    System.out.println(total);\n}\nSystem.out.println(total);", "2\n2\n", C144::run);
        check("int n = 0;\nint total = 0;\nfor (int i = 2; i <= n; i += 2) {\n    total += i;\n    System.out.println(total);\n}\nSystem.out.println(total);", "0\n", C145::run);
        check("int[] a = {-7, -3, -9};\nint max = a[0];\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "-3\n", C146::run);
        check("int[] a = {4, 9, 2};\nint max = a[0];\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "9\n", C147::run);
        check("int[] a = {5};\nint max = a[0];\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "5\n", C148::run);
        check("int[] a = {2, 8};\nint max = a[0];\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "8\n", C149::run);
        check("int[] a = {6, 1, 3};\nint max = a[0];\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "6\n", C150::run);
        check("int[] a = {1, 2, 3, 4, 5};\nint max = a[0];\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "5\n", C151::run);
        check("int[] a = {-7, -3, -9};\nint max = a[0];\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "-3\n", C152::run);
        check("int[] a = {4, 9, 2};\nint max = a[0];\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "9\n", C153::run);
        check("int[] a = {5};\nint max = a[0];\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "5\n", C154::run);
        check("int[] a = {2, 8};\nint max = a[0];\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "8\n", C155::run);
        check("int[] a = {6, 1, 3};\nint max = a[0];\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "6\n", C156::run);
        check("int[] a = {1, 2, 3, 4, 5};\nint max = a[0];\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "5\n", C157::run);
        check("int[] a = {-7, -3, -9};\nint max = 0;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "0\n", C158::run);
        check("int[] a = {4, 9, 2};\nint max = 0;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "9\n", C159::run);
        check("int[] a = {5};\nint max = 0;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "0\n", C160::run);
        check("int[] a = {2, 8};\nint max = 0;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "8\n", C161::run);
        check("int[] a = {6, 1, 3};\nint max = 0;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "3\n", C162::run);
        check("int[] a = {1, 2, 3, 4, 5};\nint max = 0;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "5\n", C163::run);
        check("int[] a = {-7, -3, -9};\nint max = a.length;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "3\n", C164::run);
        check("int[] a = {4, 9, 2};\nint max = a.length;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "9\n", C165::run);
        check("int[] a = {5};\nint max = a.length;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "1\n", C166::run);
        check("int[] a = {2, 8};\nint max = a.length;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "8\n", C167::run);
        check("int[] a = {6, 1, 3};\nint max = a.length;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "3\n", C168::run);
        check("int[] a = {1, 2, 3, 4, 5};\nint max = a.length;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "5\n", C169::run);
        check("int[] a = {-7, -3, -9};\nint max = a[0];\nfor (int i = 2; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "-7\n", C170::run);
        check("int[] a = {4, 9, 2};\nint max = a[0];\nfor (int i = 2; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "4\n", C171::run);
        check("int[] a = {5};\nint max = a[0];\nfor (int i = 2; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "5\n", C172::run);
        check("int[] a = {2, 8};\nint max = a[0];\nfor (int i = 2; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "2\n", C173::run);
        check("int[] a = {6, 1, 3};\nint max = a[0];\nfor (int i = 2; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "6\n", C174::run);
        check("int[] a = {1, 2, 3, 4, 5};\nint max = a[0];\nfor (int i = 2; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "5\n", C175::run);
        check("int[] a = {-7, -3, -9};\nint max = a[0];\nfor (int i = 1; i <= a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "|throws:ArrayIndexOutOfBoundsException", C176::run);
        check("int[] a = {4, 9, 2};\nint max = a[0];\nfor (int i = 1; i <= a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "|throws:ArrayIndexOutOfBoundsException", C177::run);
        check("int[] a = {5};\nint max = a[0];\nfor (int i = 1; i <= a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "|throws:ArrayIndexOutOfBoundsException", C178::run);
        check("int[] a = {2, 8};\nint max = a[0];\nfor (int i = 1; i <= a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "|throws:ArrayIndexOutOfBoundsException", C179::run);
        check("int[] a = {6, 1, 3};\nint max = a[0];\nfor (int i = 1; i <= a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "|throws:ArrayIndexOutOfBoundsException", C180::run);
        check("int[] a = {1, 2, 3, 4, 5};\nint max = a[0];\nfor (int i = 1; i <= a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "|throws:ArrayIndexOutOfBoundsException", C181::run);
        check("int[] a = {-7, -3, -9};\nint max = a[0];\nfor (int i = 1; i < a.length - 1; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "-3\n", C182::run);
        check("int[] a = {4, 9, 2};\nint max = a[0];\nfor (int i = 1; i < a.length - 1; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "9\n", C183::run);
        check("int[] a = {5};\nint max = a[0];\nfor (int i = 1; i < a.length - 1; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "5\n", C184::run);
        check("int[] a = {2, 8};\nint max = a[0];\nfor (int i = 1; i < a.length - 1; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "2\n", C185::run);
        check("int[] a = {6, 1, 3};\nint max = a[0];\nfor (int i = 1; i < a.length - 1; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "6\n", C186::run);
        check("int[] a = {1, 2, 3, 4, 5};\nint max = a[0];\nfor (int i = 1; i < a.length - 1; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "4\n", C187::run);
        check("int[] a = {-7, -3, -9};\nint max = a[0];\nfor (int i = 1; i < a.length; i += 2) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "-3\n", C188::run);
        check("int[] a = {4, 9, 2};\nint max = a[0];\nfor (int i = 1; i < a.length; i += 2) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "9\n", C189::run);
        check("int[] a = {5};\nint max = a[0];\nfor (int i = 1; i < a.length; i += 2) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "5\n", C190::run);
        check("int[] a = {2, 8};\nint max = a[0];\nfor (int i = 1; i < a.length; i += 2) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "8\n", C191::run);
        check("int[] a = {6, 1, 3};\nint max = a[0];\nfor (int i = 1; i < a.length; i += 2) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "6\n", C192::run);
        check("int[] a = {1, 2, 3, 4, 5};\nint max = a[0];\nfor (int i = 1; i < a.length; i += 2) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n}\nSystem.out.println(max);", "4\n", C193::run);
        check("int[] a = {-7, -3, -9};\nint max = a[0];\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n    System.out.println(max);\n}\nSystem.out.println(max);", "-3\n-3\n-3\n", C194::run);
        check("int[] a = {4, 9, 2};\nint max = a[0];\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n    System.out.println(max);\n}\nSystem.out.println(max);", "9\n9\n9\n", C195::run);
        check("int[] a = {5};\nint max = a[0];\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n    System.out.println(max);\n}\nSystem.out.println(max);", "5\n", C196::run);
        check("int[] a = {2, 8};\nint max = a[0];\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n    System.out.println(max);\n}\nSystem.out.println(max);", "8\n8\n", C197::run);
        check("int[] a = {6, 1, 3};\nint max = a[0];\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n    System.out.println(max);\n}\nSystem.out.println(max);", "6\n6\n6\n", C198::run);
        check("int[] a = {1, 2, 3, 4, 5};\nint max = a[0];\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] > max) {\n        max = a[i];\n    }\n    System.out.println(max);\n}\nSystem.out.println(max);", "2\n3\n4\n5\n5\n", C199::run);
        check("String word = \"pizza\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "true\n", C200::run);
        check("String word = \"plain\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "false\n", C201::run);
        check("String word = \"z\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "true\n", C202::run);
        check("String word = \"fizz\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "true\n", C203::run);
        check("String word = \"az\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "true\n", C204::run);
        check("String word = \"pizza\";\nboolean found = true;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "true\n", C205::run);
        check("String word = \"plain\";\nboolean found = true;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "true\n", C206::run);
        check("String word = \"z\";\nboolean found = true;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "true\n", C207::run);
        check("String word = \"fizz\";\nboolean found = true;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "true\n", C208::run);
        check("String word = \"az\";\nboolean found = true;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "true\n", C209::run);
        check("String word = \"pizza\";\nboolean found = false;\nfor (int i = 0; i <= word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "|throws:StringIndexOutOfBoundsException", C210::run);
        check("String word = \"plain\";\nboolean found = false;\nfor (int i = 0; i <= word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "|throws:StringIndexOutOfBoundsException", C211::run);
        check("String word = \"z\";\nboolean found = false;\nfor (int i = 0; i <= word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "|throws:StringIndexOutOfBoundsException", C212::run);
        check("String word = \"fizz\";\nboolean found = false;\nfor (int i = 0; i <= word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "|throws:StringIndexOutOfBoundsException", C213::run);
        check("String word = \"az\";\nboolean found = false;\nfor (int i = 0; i <= word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "|throws:StringIndexOutOfBoundsException", C214::run);
        check("String word = \"pizza\";\nboolean found = false;\nfor (int i = 0; i < word.length() - 1; i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "true\n", C215::run);
        check("String word = \"plain\";\nboolean found = false;\nfor (int i = 0; i < word.length() - 1; i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "false\n", C216::run);
        check("String word = \"z\";\nboolean found = false;\nfor (int i = 0; i < word.length() - 1; i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "false\n", C217::run);
        check("String word = \"fizz\";\nboolean found = false;\nfor (int i = 0; i < word.length() - 1; i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "true\n", C218::run);
        check("String word = \"az\";\nboolean found = false;\nfor (int i = 0; i < word.length() - 1; i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n}\nSystem.out.println(found);", "false\n", C219::run);
        check("String word = \"pizza\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = false;\n    }\n}\nSystem.out.println(found);", "false\n", C220::run);
        check("String word = \"plain\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = false;\n    }\n}\nSystem.out.println(found);", "false\n", C221::run);
        check("String word = \"z\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = false;\n    }\n}\nSystem.out.println(found);", "false\n", C222::run);
        check("String word = \"fizz\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = false;\n    }\n}\nSystem.out.println(found);", "false\n", C223::run);
        check("String word = \"az\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = false;\n    }\n}\nSystem.out.println(found);", "false\n", C224::run);
        check("String word = \"pizza\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = !found;\n    }\n}\nSystem.out.println(found);", "false\n", C225::run);
        check("String word = \"plain\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = !found;\n    }\n}\nSystem.out.println(found);", "false\n", C226::run);
        check("String word = \"z\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = !found;\n    }\n}\nSystem.out.println(found);", "true\n", C227::run);
        check("String word = \"fizz\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = !found;\n    }\n}\nSystem.out.println(found);", "false\n", C228::run);
        check("String word = \"az\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = !found;\n    }\n}\nSystem.out.println(found);", "true\n", C229::run);
        check("String word = \"pizza\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n    System.out.println(found);\n}\nSystem.out.println(found);", "false\nfalse\ntrue\ntrue\ntrue\ntrue\n", C230::run);
        check("String word = \"plain\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n    System.out.println(found);\n}\nSystem.out.println(found);", "false\nfalse\nfalse\nfalse\nfalse\nfalse\n", C231::run);
        check("String word = \"z\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n    System.out.println(found);\n}\nSystem.out.println(found);", "true\ntrue\n", C232::run);
        check("String word = \"fizz\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n    System.out.println(found);\n}\nSystem.out.println(found);", "false\nfalse\ntrue\ntrue\ntrue\n", C233::run);
        check("String word = \"az\";\nboolean found = false;\nfor (int i = 0; i < word.length(); i++) {\n    if (word.substring(i, i + 1).equals(\"z\")) {\n        found = true;\n    }\n    System.out.println(found);\n}\nSystem.out.println(found);", "false\ntrue\ntrue\n", C234::run);
        check("String word = \"loop\";\nString rev = \"\";\nfor (int i = word.length() - 1; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "pool\n", C235::run);
        check("String word = \"abc\";\nString rev = \"\";\nfor (int i = word.length() - 1; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "cba\n", C236::run);
        check("String word = \"a\";\nString rev = \"\";\nfor (int i = word.length() - 1; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "a\n", C237::run);
        check("String word = \"ab\";\nString rev = \"\";\nfor (int i = word.length() - 1; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "ba\n", C238::run);
        check("String word = \"loop\";\nString rev = word;\nfor (int i = word.length() - 1; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "looppool\n", C239::run);
        check("String word = \"abc\";\nString rev = word;\nfor (int i = word.length() - 1; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "abccba\n", C240::run);
        check("String word = \"a\";\nString rev = word;\nfor (int i = word.length() - 1; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "aa\n", C241::run);
        check("String word = \"ab\";\nString rev = word;\nfor (int i = word.length() - 1; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "abba\n", C242::run);
        check("String word = \"loop\";\nString rev = \"\";\nfor (int i = 0; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "l\n", C243::run);
        check("String word = \"abc\";\nString rev = \"\";\nfor (int i = 0; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "a\n", C244::run);
        check("String word = \"a\";\nString rev = \"\";\nfor (int i = 0; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "a\n", C245::run);
        check("String word = \"ab\";\nString rev = \"\";\nfor (int i = 0; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "a\n", C246::run);
        check("String word = \"loop\";\nString rev = \"\";\nfor (int i = word.length(); i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "|throws:StringIndexOutOfBoundsException", C247::run);
        check("String word = \"abc\";\nString rev = \"\";\nfor (int i = word.length(); i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "|throws:StringIndexOutOfBoundsException", C248::run);
        check("String word = \"a\";\nString rev = \"\";\nfor (int i = word.length(); i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "|throws:StringIndexOutOfBoundsException", C249::run);
        check("String word = \"ab\";\nString rev = \"\";\nfor (int i = word.length(); i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "|throws:StringIndexOutOfBoundsException", C250::run);
        check("String word = \"loop\";\nString rev = \"\";\nfor (int i = word.length() - 1; i < word.length(); i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "|throws:StringIndexOutOfBoundsException", C251::run);
        check("String word = \"abc\";\nString rev = \"\";\nfor (int i = word.length() - 1; i < word.length(); i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "|throws:StringIndexOutOfBoundsException", C252::run);
        check("String word = \"a\";\nString rev = \"\";\nfor (int i = word.length() - 1; i < word.length(); i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "|throws:StringIndexOutOfBoundsException", C253::run);
        check("String word = \"ab\";\nString rev = \"\";\nfor (int i = word.length() - 1; i < word.length(); i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "|throws:StringIndexOutOfBoundsException", C254::run);
        check("String word = \"loop\";\nString rev = \"\";\nfor (int i = word.length() - 1; i > 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "poo\n", C255::run);
        check("String word = \"abc\";\nString rev = \"\";\nfor (int i = word.length() - 1; i > 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "cb\n", C256::run);
        check("String word = \"a\";\nString rev = \"\";\nfor (int i = word.length() - 1; i > 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "\n", C257::run);
        check("String word = \"ab\";\nString rev = \"\";\nfor (int i = word.length() - 1; i > 0; i--) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "b\n", C258::run);
        check("String word = \"loop\";\nString rev = \"\";\nfor (int i = word.length() - 1; i >= 0; i++) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "|throws:StringIndexOutOfBoundsException", C259::run);
        check("String word = \"abc\";\nString rev = \"\";\nfor (int i = word.length() - 1; i >= 0; i++) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "|throws:StringIndexOutOfBoundsException", C260::run);
        check("String word = \"a\";\nString rev = \"\";\nfor (int i = word.length() - 1; i >= 0; i++) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "|throws:StringIndexOutOfBoundsException", C261::run);
        check("String word = \"ab\";\nString rev = \"\";\nfor (int i = word.length() - 1; i >= 0; i++) {\n    rev += word.substring(i, i + 1);\n}\nSystem.out.println(rev);", "|throws:StringIndexOutOfBoundsException", C262::run);
        check("String word = \"loop\";\nString rev = \"\";\nfor (int i = word.length() - 1; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n    System.out.println(rev);\n}\nSystem.out.println(rev);", "p\npo\npoo\npool\npool\n", C263::run);
        check("String word = \"abc\";\nString rev = \"\";\nfor (int i = word.length() - 1; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n    System.out.println(rev);\n}\nSystem.out.println(rev);", "c\ncb\ncba\ncba\n", C264::run);
        check("String word = \"a\";\nString rev = \"\";\nfor (int i = word.length() - 1; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n    System.out.println(rev);\n}\nSystem.out.println(rev);", "a\na\n", C265::run);
        check("String word = \"ab\";\nString rev = \"\";\nfor (int i = word.length() - 1; i >= 0; i--) {\n    rev += word.substring(i, i + 1);\n    System.out.println(rev);\n}\nSystem.out.println(rev);", "b\nba\nba\n", C266::run);
        check("int n = 10;\nint p = 1;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "16\n", C267::run);
        check("int n = 16;\nint p = 1;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "16\n", C268::run);
        check("int n = 1;\nint p = 1;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "1\n", C269::run);
        check("int n = 17;\nint p = 1;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "32\n", C270::run);
        check("int n = 0;\nint p = 1;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "1\n", C271::run);
        check("int n = 0;\nint p = 0;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "0\n", C276::run);
        check("int n = 10;\nint p = 2;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "16\n", C277::run);
        check("int n = 16;\nint p = 2;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "16\n", C278::run);
        check("int n = 1;\nint p = 2;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "2\n", C279::run);
        check("int n = 17;\nint p = 2;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "32\n", C280::run);
        check("int n = 0;\nint p = 2;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "2\n", C281::run);
        check("int n = 10;\nint p = 1;\nwhile (p <= n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "16\n", C282::run);
        check("int n = 16;\nint p = 1;\nwhile (p <= n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "32\n", C283::run);
        check("int n = 1;\nint p = 1;\nwhile (p <= n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "2\n", C284::run);
        check("int n = 17;\nint p = 1;\nwhile (p <= n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "32\n", C285::run);
        check("int n = 0;\nint p = 1;\nwhile (p <= n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "1\n", C286::run);
        check("int n = 10;\nint p = 1;\nwhile (p > n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "1\n", C287::run);
        check("int n = 16;\nint p = 1;\nwhile (p > n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "1\n", C288::run);
        check("int n = 1;\nint p = 1;\nwhile (p > n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "1\n", C289::run);
        check("int n = 17;\nint p = 1;\nwhile (p > n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "1\n", C290::run);
        check("int n = 0;\nint p = 1;\nwhile (p > n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "-2147483648\n", C291::run);
        check("int n = 10;\nint p = 1;\nwhile (p < n) {\n    p = p + 2;\n}\nSystem.out.println(p);", "11\n", C292::run);
        check("int n = 16;\nint p = 1;\nwhile (p < n) {\n    p = p + 2;\n}\nSystem.out.println(p);", "17\n", C293::run);
        check("int n = 1;\nint p = 1;\nwhile (p < n) {\n    p = p + 2;\n}\nSystem.out.println(p);", "1\n", C294::run);
        check("int n = 17;\nint p = 1;\nwhile (p < n) {\n    p = p + 2;\n}\nSystem.out.println(p);", "17\n", C295::run);
        check("int n = 0;\nint p = 1;\nwhile (p < n) {\n    p = p + 2;\n}\nSystem.out.println(p);", "1\n", C296::run);
        check("int n = 1;\nint p = 1;\nwhile (p < n) {\n    p = p * p;\n}\nSystem.out.println(p);", "1\n", C299::run);
        check("int n = 0;\nint p = 1;\nwhile (p < n) {\n    p = p * p;\n}\nSystem.out.println(p);", "1\n", C301::run);
        check("int n = 10;\nint p = 1;\nwhile (p < n) {\n    p = p * 2;\n    System.out.println(p);\n}\nSystem.out.println(p);", "2\n4\n8\n16\n16\n", C302::run);
        check("int n = 16;\nint p = 1;\nwhile (p < n) {\n    p = p * 2;\n    System.out.println(p);\n}\nSystem.out.println(p);", "2\n4\n8\n16\n16\n", C303::run);
        check("int n = 1;\nint p = 1;\nwhile (p < n) {\n    p = p * 2;\n    System.out.println(p);\n}\nSystem.out.println(p);", "1\n", C304::run);
        check("int n = 17;\nint p = 1;\nwhile (p < n) {\n    p = p * 2;\n    System.out.println(p);\n}\nSystem.out.println(p);", "2\n4\n8\n16\n32\n32\n", C305::run);
        check("int n = 0;\nint p = 1;\nwhile (p < n) {\n    p = p * 2;\n    System.out.println(p);\n}\nSystem.out.println(p);", "1\n", C306::run);
        check("int n = 4721;\nint count = 0;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "4\n", C307::run);
        check("int n = 5;\nint count = 0;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "1\n", C308::run);
        check("int n = 10;\nint count = 0;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "2\n", C309::run);
        check("int n = 100;\nint count = 0;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "3\n", C310::run);
        check("int n = 999;\nint count = 0;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "3\n", C311::run);
        check("int n = 4721;\nint count = 1;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "5\n", C312::run);
        check("int n = 5;\nint count = 1;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "2\n", C313::run);
        check("int n = 10;\nint count = 1;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "3\n", C314::run);
        check("int n = 100;\nint count = 1;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "4\n", C315::run);
        check("int n = 999;\nint count = 1;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "4\n", C316::run);
        check("int n = 4721;\nint count = 0;\nwhile (n > 10) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "3\n", C322::run);
        check("int n = 5;\nint count = 0;\nwhile (n > 10) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "0\n", C323::run);
        check("int n = 10;\nint count = 0;\nwhile (n > 10) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "0\n", C324::run);
        check("int n = 100;\nint count = 0;\nwhile (n > 10) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "1\n", C325::run);
        check("int n = 999;\nint count = 0;\nwhile (n > 10) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "2\n", C326::run);
        check("int n = 4721;\nint count = 0;\nwhile (n > 0) {\n    n -= 10;\n    count++;\n}\nSystem.out.println(count);", "473\n", C327::run);
        check("int n = 5;\nint count = 0;\nwhile (n > 0) {\n    n -= 10;\n    count++;\n}\nSystem.out.println(count);", "1\n", C328::run);
        check("int n = 10;\nint count = 0;\nwhile (n > 0) {\n    n -= 10;\n    count++;\n}\nSystem.out.println(count);", "1\n", C329::run);
        check("int n = 100;\nint count = 0;\nwhile (n > 0) {\n    n -= 10;\n    count++;\n}\nSystem.out.println(count);", "10\n", C330::run);
        check("int n = 999;\nint count = 0;\nwhile (n > 0) {\n    n -= 10;\n    count++;\n}\nSystem.out.println(count);", "100\n", C331::run);
        check("int n = 10;\nint count = 0;\nwhile (n > 0) {\n    n %= 10;\n    count++;\n}\nSystem.out.println(count);", "1\n", C334::run);
        check("int n = 100;\nint count = 0;\nwhile (n > 0) {\n    n %= 10;\n    count++;\n}\nSystem.out.println(count);", "1\n", C335::run);
        check("int n = 4721;\nint count = 0;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n    System.out.println(count);\n}\nSystem.out.println(count);", "1\n2\n3\n4\n4\n", C337::run);
        check("int n = 5;\nint count = 0;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n    System.out.println(count);\n}\nSystem.out.println(count);", "1\n1\n", C338::run);
        check("int n = 10;\nint count = 0;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n    System.out.println(count);\n}\nSystem.out.println(count);", "1\n2\n2\n", C339::run);
        check("int n = 100;\nint count = 0;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n    System.out.println(count);\n}\nSystem.out.println(count);", "1\n2\n3\n3\n", C340::run);
        check("int n = 999;\nint count = 0;\nwhile (n > 0) {\n    n /= 10;\n    count++;\n    System.out.println(count);\n}\nSystem.out.println(count);", "1\n2\n3\n3\n", C341::run);
        check("int n = 5;\nint product = 1;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "120\n", C342::run);
        check("int n = 0;\nint product = 1;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "1\n", C343::run);
        check("int n = 1;\nint product = 1;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "1\n", C344::run);
        check("int n = 3;\nint product = 1;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "6\n", C345::run);
        check("int n = 5;\nint product = 1;\nfor (int i = 2; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "120\n", C346::run);
        check("int n = 0;\nint product = 1;\nfor (int i = 2; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "1\n", C347::run);
        check("int n = 1;\nint product = 1;\nfor (int i = 2; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "1\n", C348::run);
        check("int n = 3;\nint product = 1;\nfor (int i = 2; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "6\n", C349::run);
        check("int n = 5;\nint product = 0;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "0\n", C350::run);
        check("int n = 0;\nint product = 0;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "0\n", C351::run);
        check("int n = 1;\nint product = 0;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "0\n", C352::run);
        check("int n = 3;\nint product = 0;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "0\n", C353::run);
        check("int n = 5;\nint product = n;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "600\n", C354::run);
        check("int n = 0;\nint product = n;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "0\n", C355::run);
        check("int n = 1;\nint product = n;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "1\n", C356::run);
        check("int n = 3;\nint product = n;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "18\n", C357::run);
        check("int n = 5;\nint product = 1;\nfor (int i = 0; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "0\n", C358::run);
        check("int n = 0;\nint product = 1;\nfor (int i = 0; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "0\n", C359::run);
        check("int n = 1;\nint product = 1;\nfor (int i = 0; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "0\n", C360::run);
        check("int n = 3;\nint product = 1;\nfor (int i = 0; i <= n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "0\n", C361::run);
        check("int n = 5;\nint product = 1;\nfor (int i = 1; i < n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "24\n", C362::run);
        check("int n = 0;\nint product = 1;\nfor (int i = 1; i < n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "1\n", C363::run);
        check("int n = 1;\nint product = 1;\nfor (int i = 1; i < n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "1\n", C364::run);
        check("int n = 3;\nint product = 1;\nfor (int i = 1; i < n; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "2\n", C365::run);
        check("int n = 5;\nint product = 1;\nfor (int i = 1; i <= n + 1; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "720\n", C366::run);
        check("int n = 0;\nint product = 1;\nfor (int i = 1; i <= n + 1; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "1\n", C367::run);
        check("int n = 1;\nint product = 1;\nfor (int i = 1; i <= n + 1; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "2\n", C368::run);
        check("int n = 3;\nint product = 1;\nfor (int i = 1; i <= n + 1; i++) {\n    product *= i;\n}\nSystem.out.println(product);", "24\n", C369::run);
        check("int n = 5;\nint product = 1;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n    System.out.println(product);\n}\nSystem.out.println(product);", "1\n2\n6\n24\n120\n120\n", C370::run);
        check("int n = 0;\nint product = 1;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n    System.out.println(product);\n}\nSystem.out.println(product);", "1\n", C371::run);
        check("int n = 1;\nint product = 1;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n    System.out.println(product);\n}\nSystem.out.println(product);", "1\n1\n", C372::run);
        check("int n = 3;\nint product = 1;\nfor (int i = 1; i <= n; i++) {\n    product *= i;\n    System.out.println(product);\n}\nSystem.out.println(product);", "1\n2\n6\n6\n", C373::run);
        check("int[] a = {-2, 5, -1};\nint count = 0;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "2\n", C374::run);
        check("int[] a = {3, 4};\nint count = 0;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C375::run);
        check("int[] a = {-4};\nint count = 0;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "1\n", C376::run);
        check("int[] a = {-1, -1, -1};\nint count = 0;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "3\n", C377::run);
        check("int[] a = {-2, 5, -1};\nint count = 1;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "3\n", C378::run);
        check("int[] a = {3, 4};\nint count = 1;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "1\n", C379::run);
        check("int[] a = {-4};\nint count = 1;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "2\n", C380::run);
        check("int[] a = {-1, -1, -1};\nint count = 1;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "4\n", C381::run);
        check("int[] a = {-2, 5, -1};\nint count = 0;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "1\n", C382::run);
        check("int[] a = {3, 4};\nint count = 0;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C383::run);
        check("int[] a = {-4};\nint count = 0;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C384::run);
        check("int[] a = {-1, -1, -1};\nint count = 0;\nfor (int i = 1; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "2\n", C385::run);
        check("int[] a = {-2, 5, -1};\nint count = 0;\nfor (int i = 0; i <= a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "|throws:ArrayIndexOutOfBoundsException", C386::run);
        check("int[] a = {3, 4};\nint count = 0;\nfor (int i = 0; i <= a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "|throws:ArrayIndexOutOfBoundsException", C387::run);
        check("int[] a = {-4};\nint count = 0;\nfor (int i = 0; i <= a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "|throws:ArrayIndexOutOfBoundsException", C388::run);
        check("int[] a = {-1, -1, -1};\nint count = 0;\nfor (int i = 0; i <= a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "|throws:ArrayIndexOutOfBoundsException", C389::run);
        check("int[] a = {-2, 5, -1};\nint count = 0;\nfor (int i = 0; i < a.length - 1; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "1\n", C390::run);
        check("int[] a = {3, 4};\nint count = 0;\nfor (int i = 0; i < a.length - 1; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C391::run);
        check("int[] a = {-4};\nint count = 0;\nfor (int i = 0; i < a.length - 1; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "0\n", C392::run);
        check("int[] a = {-1, -1, -1};\nint count = 0;\nfor (int i = 0; i < a.length - 1; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "2\n", C393::run);
        check("int[] a = {-2, 5, -1};\nint count = 0;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n    System.out.println(count);\n}\nSystem.out.println(count);", "1\n1\n2\n2\n", C394::run);
        check("int[] a = {3, 4};\nint count = 0;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n    System.out.println(count);\n}\nSystem.out.println(count);", "0\n0\n0\n", C395::run);
        check("int[] a = {-4};\nint count = 0;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n    System.out.println(count);\n}\nSystem.out.println(count);", "1\n1\n", C396::run);
        check("int[] a = {-1, -1, -1};\nint count = 0;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] < 0) {\n        count++;\n    }\n    System.out.println(count);\n}\nSystem.out.println(count);", "1\n2\n3\n3\n", C397::run);
        check("int[] a = {3, 5, 1};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "true\n", C398::run);
        check("int[] a = {3, -1, 2};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "false\n", C399::run);
        check("int[] a = {0};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "false\n", C400::run);
        check("int[] a = {-1, -2};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "false\n", C401::run);
        check("int[] a = {4, -3};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "false\n", C402::run);
        check("int[] a = {3, 5, 1};\nboolean allPos = false;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "false\n", C403::run);
        check("int[] a = {3, -1, 2};\nboolean allPos = false;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "false\n", C404::run);
        check("int[] a = {0};\nboolean allPos = false;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "false\n", C405::run);
        check("int[] a = {-1, -2};\nboolean allPos = false;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "false\n", C406::run);
        check("int[] a = {4, -3};\nboolean allPos = false;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "false\n", C407::run);
        check("int[] a = {3, 5, 1};\nboolean allPos = true;\nfor (int i = 0; i <= a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "|throws:ArrayIndexOutOfBoundsException", C408::run);
        check("int[] a = {3, -1, 2};\nboolean allPos = true;\nfor (int i = 0; i <= a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "|throws:ArrayIndexOutOfBoundsException", C409::run);
        check("int[] a = {0};\nboolean allPos = true;\nfor (int i = 0; i <= a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "|throws:ArrayIndexOutOfBoundsException", C410::run);
        check("int[] a = {-1, -2};\nboolean allPos = true;\nfor (int i = 0; i <= a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "|throws:ArrayIndexOutOfBoundsException", C411::run);
        check("int[] a = {4, -3};\nboolean allPos = true;\nfor (int i = 0; i <= a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "|throws:ArrayIndexOutOfBoundsException", C412::run);
        check("int[] a = {3, 5, 1};\nboolean allPos = true;\nfor (int i = 0; i < a.length - 1; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "true\n", C413::run);
        check("int[] a = {3, -1, 2};\nboolean allPos = true;\nfor (int i = 0; i < a.length - 1; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "false\n", C414::run);
        check("int[] a = {0};\nboolean allPos = true;\nfor (int i = 0; i < a.length - 1; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "true\n", C415::run);
        check("int[] a = {-1, -2};\nboolean allPos = true;\nfor (int i = 0; i < a.length - 1; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "false\n", C416::run);
        check("int[] a = {4, -3};\nboolean allPos = true;\nfor (int i = 0; i < a.length - 1; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n}\nSystem.out.println(allPos);", "true\n", C417::run);
        check("int[] a = {3, 5, 1};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = true;\n    }\n}\nSystem.out.println(allPos);", "true\n", C418::run);
        check("int[] a = {3, -1, 2};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = true;\n    }\n}\nSystem.out.println(allPos);", "true\n", C419::run);
        check("int[] a = {0};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = true;\n    }\n}\nSystem.out.println(allPos);", "true\n", C420::run);
        check("int[] a = {-1, -2};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = true;\n    }\n}\nSystem.out.println(allPos);", "true\n", C421::run);
        check("int[] a = {4, -3};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = true;\n    }\n}\nSystem.out.println(allPos);", "true\n", C422::run);
        check("int[] a = {3, 5, 1};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = !allPos;\n    }\n}\nSystem.out.println(allPos);", "true\n", C423::run);
        check("int[] a = {3, -1, 2};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = !allPos;\n    }\n}\nSystem.out.println(allPos);", "false\n", C424::run);
        check("int[] a = {0};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = !allPos;\n    }\n}\nSystem.out.println(allPos);", "false\n", C425::run);
        check("int[] a = {-1, -2};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = !allPos;\n    }\n}\nSystem.out.println(allPos);", "true\n", C426::run);
        check("int[] a = {4, -3};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = !allPos;\n    }\n}\nSystem.out.println(allPos);", "false\n", C427::run);
        check("int[] a = {3, 5, 1};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n    System.out.println(allPos);\n}\nSystem.out.println(allPos);", "true\ntrue\ntrue\ntrue\n", C428::run);
        check("int[] a = {3, -1, 2};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n    System.out.println(allPos);\n}\nSystem.out.println(allPos);", "true\nfalse\nfalse\nfalse\n", C429::run);
        check("int[] a = {0};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n    System.out.println(allPos);\n}\nSystem.out.println(allPos);", "false\nfalse\n", C430::run);
        check("int[] a = {-1, -2};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n    System.out.println(allPos);\n}\nSystem.out.println(allPos);", "false\nfalse\nfalse\n", C431::run);
        check("int[] a = {4, -3};\nboolean allPos = true;\nfor (int i = 0; i < a.length; i++) {\n    if (a[i] <= 0) {\n        allPos = false;\n    }\n    System.out.println(allPos);\n}\nSystem.out.println(allPos);", "true\nfalse\nfalse\n", C432::run);
        check("int n = 8;\nint steps = 0;\nwhile (n > 1) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "3\n", C433::run);
        check("int n = 1;\nint steps = 0;\nwhile (n > 1) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "0\n", C434::run);
        check("int n = 10;\nint steps = 0;\nwhile (n > 1) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "3\n", C435::run);
        check("int n = 2;\nint steps = 0;\nwhile (n > 1) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "1\n", C436::run);
        check("int n = 8;\nint steps = 1;\nwhile (n > 1) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "4\n", C437::run);
        check("int n = 1;\nint steps = 1;\nwhile (n > 1) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "1\n", C438::run);
        check("int n = 10;\nint steps = 1;\nwhile (n > 1) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "4\n", C439::run);
        check("int n = 2;\nint steps = 1;\nwhile (n > 1) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "2\n", C440::run);
        check("int n = 8;\nint steps = 0;\nwhile (n > 0) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "4\n", C441::run);
        check("int n = 1;\nint steps = 0;\nwhile (n > 0) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "1\n", C442::run);
        check("int n = 10;\nint steps = 0;\nwhile (n > 0) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "4\n", C443::run);
        check("int n = 2;\nint steps = 0;\nwhile (n > 0) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "2\n", C444::run);
        check("int n = 8;\nint steps = 0;\nwhile (n >= 1) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "4\n", C445::run);
        check("int n = 1;\nint steps = 0;\nwhile (n >= 1) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "1\n", C446::run);
        check("int n = 10;\nint steps = 0;\nwhile (n >= 1) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "4\n", C447::run);
        check("int n = 2;\nint steps = 0;\nwhile (n >= 1) {\n    n /= 2;\n    steps++;\n}\nSystem.out.println(steps);", "2\n", C448::run);
        check("int n = 8;\nint steps = 0;\nwhile (n > 1) {\n    n -= 2;\n    steps++;\n}\nSystem.out.println(steps);", "4\n", C449::run);
        check("int n = 1;\nint steps = 0;\nwhile (n > 1) {\n    n -= 2;\n    steps++;\n}\nSystem.out.println(steps);", "0\n", C450::run);
        check("int n = 10;\nint steps = 0;\nwhile (n > 1) {\n    n -= 2;\n    steps++;\n}\nSystem.out.println(steps);", "5\n", C451::run);
        check("int n = 2;\nint steps = 0;\nwhile (n > 1) {\n    n -= 2;\n    steps++;\n}\nSystem.out.println(steps);", "1\n", C452::run);
        check("int n = 8;\nint steps = 0;\nwhile (n > 1) {\n    n /= 10;\n    steps++;\n}\nSystem.out.println(steps);", "1\n", C453::run);
        check("int n = 1;\nint steps = 0;\nwhile (n > 1) {\n    n /= 10;\n    steps++;\n}\nSystem.out.println(steps);", "0\n", C454::run);
        check("int n = 10;\nint steps = 0;\nwhile (n > 1) {\n    n /= 10;\n    steps++;\n}\nSystem.out.println(steps);", "1\n", C455::run);
        check("int n = 2;\nint steps = 0;\nwhile (n > 1) {\n    n /= 10;\n    steps++;\n}\nSystem.out.println(steps);", "1\n", C456::run);
        check("int n = 8;\nint steps = 0;\nwhile (n > 1) {\n    n /= 2;\n    steps++;\n    System.out.println(steps);\n}\nSystem.out.println(steps);", "1\n2\n3\n3\n", C457::run);
        check("int n = 1;\nint steps = 0;\nwhile (n > 1) {\n    n /= 2;\n    steps++;\n    System.out.println(steps);\n}\nSystem.out.println(steps);", "0\n", C458::run);
        check("int n = 10;\nint steps = 0;\nwhile (n > 1) {\n    n /= 2;\n    steps++;\n    System.out.println(steps);\n}\nSystem.out.println(steps);", "1\n2\n3\n3\n", C459::run);
        check("int n = 2;\nint steps = 0;\nwhile (n > 1) {\n    n /= 2;\n    steps++;\n    System.out.println(steps);\n}\nSystem.out.println(steps);", "1\n1\n", C460::run);
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        if (javac == null) throw new IllegalStateException("A JDK is needed to check compile claims.");
        compileCheck(javac, "int n = 0;\nint sum = 0;\nfor (int i = 1; i != n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 0;\nint sum = 0;\nfor (int i = 1; i != n; i++) {\n    sum += i;\n}\nSystem.out.println(sum);\n}\n}", true);
        compileCheck(javac, "int n = 5;\nint sum = 0;\nfor (int i = 1; i <= n; i--) {\n    sum += i;\n}\nSystem.out.println(sum);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 5;\nint sum = 0;\nfor (int i = 1; i <= n; i--) {\n    sum += i;\n}\nSystem.out.println(sum);\n}\n}", true);
        compileCheck(javac, "int n = 1;\nint sum = 0;\nfor (int i = 1; i <= n; i--) {\n    sum += i;\n}\nSystem.out.println(sum);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 1;\nint sum = 0;\nfor (int i = 1; i <= n; i--) {\n    sum += i;\n}\nSystem.out.println(sum);\n}\n}", true);
        compileCheck(javac, "int n = 6;\nint sum = 0;\nfor (int i = 1; i <= n; i--) {\n    sum += i;\n}\nSystem.out.println(sum);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 6;\nint sum = 0;\nfor (int i = 1; i <= n; i--) {\n    sum += i;\n}\nSystem.out.println(sum);\n}\n}", true);
        compileCheck(javac, "int n = 10;\nint count = 0;\nfor (int i = 1; i <= n; i--) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 10;\nint count = 0;\nfor (int i = 1; i <= n; i--) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);\n}\n}", true);
        compileCheck(javac, "int n = 3;\nint count = 0;\nfor (int i = 1; i <= n; i--) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 3;\nint count = 0;\nfor (int i = 1; i <= n; i--) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);\n}\n}", true);
        compileCheck(javac, "int n = 9;\nint count = 0;\nfor (int i = 1; i <= n; i--) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 9;\nint count = 0;\nfor (int i = 1; i <= n; i--) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);\n}\n}", true);
        compileCheck(javac, "int n = 2;\nint count = 0;\nfor (int i = 1; i <= n; i--) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 2;\nint count = 0;\nfor (int i = 1; i <= n; i--) {\n    if (i % 3 == 0) {\n        count++;\n    }\n}\nSystem.out.println(count);\n}\n}", true);
        compileCheck(javac, "int n = 10;\nint p = 0;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 10;\nint p = 0;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);\n}\n}", true);
        compileCheck(javac, "int n = 16;\nint p = 0;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 16;\nint p = 0;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);\n}\n}", true);
        compileCheck(javac, "int n = 1;\nint p = 0;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 1;\nint p = 0;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);\n}\n}", true);
        compileCheck(javac, "int n = 17;\nint p = 0;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 17;\nint p = 0;\nwhile (p < n) {\n    p = p * 2;\n}\nSystem.out.println(p);\n}\n}", true);
        compileCheck(javac, "int n = 10;\nint p = 1;\nwhile (p < n) {\n    p = p * p;\n}\nSystem.out.println(p);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 10;\nint p = 1;\nwhile (p < n) {\n    p = p * p;\n}\nSystem.out.println(p);\n}\n}", true);
        compileCheck(javac, "int n = 16;\nint p = 1;\nwhile (p < n) {\n    p = p * p;\n}\nSystem.out.println(p);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 16;\nint p = 1;\nwhile (p < n) {\n    p = p * p;\n}\nSystem.out.println(p);\n}\n}", true);
        compileCheck(javac, "int n = 17;\nint p = 1;\nwhile (p < n) {\n    p = p * p;\n}\nSystem.out.println(p);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 17;\nint p = 1;\nwhile (p < n) {\n    p = p * p;\n}\nSystem.out.println(p);\n}\n}", true);
        compileCheck(javac, "int n = 4721;\nint count = 0;\nwhile (n >= 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 4721;\nint count = 0;\nwhile (n >= 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);\n}\n}", true);
        compileCheck(javac, "int n = 5;\nint count = 0;\nwhile (n >= 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 5;\nint count = 0;\nwhile (n >= 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);\n}\n}", true);
        compileCheck(javac, "int n = 10;\nint count = 0;\nwhile (n >= 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 10;\nint count = 0;\nwhile (n >= 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);\n}\n}", true);
        compileCheck(javac, "int n = 100;\nint count = 0;\nwhile (n >= 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 100;\nint count = 0;\nwhile (n >= 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);\n}\n}", true);
        compileCheck(javac, "int n = 999;\nint count = 0;\nwhile (n >= 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 999;\nint count = 0;\nwhile (n >= 0) {\n    n /= 10;\n    count++;\n}\nSystem.out.println(count);\n}\n}", true);
        compileCheck(javac, "int n = 4721;\nint count = 0;\nwhile (n > 0) {\n    n %= 10;\n    count++;\n}\nSystem.out.println(count);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 4721;\nint count = 0;\nwhile (n > 0) {\n    n %= 10;\n    count++;\n}\nSystem.out.println(count);\n}\n}", true);
        compileCheck(javac, "int n = 5;\nint count = 0;\nwhile (n > 0) {\n    n %= 10;\n    count++;\n}\nSystem.out.println(count);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 5;\nint count = 0;\nwhile (n > 0) {\n    n %= 10;\n    count++;\n}\nSystem.out.println(count);\n}\n}", true);
        compileCheck(javac, "int n = 999;\nint count = 0;\nwhile (n > 0) {\n    n %= 10;\n    count++;\n}\nSystem.out.println(count);", "import java.util.ArrayList;\npublic class Snip {\nstatic class Player {\n    private String name;\n    private int score;\n    public Player(String startName, int startScore) { name = startName; score = startScore; }\n    public String getName() { return name; }\n    public int getScore() { return score; }\n    public void addScore(int amount) { score += amount; }\n}\n\nstatic void run() {\nint n = 999;\nint count = 0;\nwhile (n > 0) {\n    n %= 10;\n    count++;\n}\nSystem.out.println(count);\n}\n}", true);
        System.out.println(failed == 0 ? "PASS: " + passed + " programs match Java " + System.getProperty("java.version") : failed + " of " + (passed + failed) + " programs differ");
    }
}
