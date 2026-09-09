public class RuntimeLabCheck {
    private static int passed = 0;
    private static int total = 0;

    private static void check(String label, int expected, int actual) {
        total++;
        if (expected == actual) {
            passed++;
            System.out.println("PASS: " + label);
        } else {
            System.out.println("REVISE: " + label + " (expected " + expected + ", got " + actual + ")");
        }
    }

    public static void main(String[] args) {
        check("linear zero", 0, RuntimeLab.linearCount(0));
        check("linear five", 5, RuntimeLab.linearCount(5));
        check("triangular one", 1, RuntimeLab.triangularCount(1));
        check("triangular five", 15, RuntimeLab.triangularCount(5));
        check("square five", 25, RuntimeLab.squareCount(5));
        check("square ten", 100, RuntimeLab.squareCount(10));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
