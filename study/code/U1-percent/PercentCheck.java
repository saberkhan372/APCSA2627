public class PercentCheck {
    private static int passed = 0;
    private static int total = 0;

    private static void check(String label, double expected, double actual) {
        total++;
        // Doubles are compared with a small tolerance, so 33.333333333333336 matches 33.33333333333333.
        if (Math.abs(expected - actual) < 1e-9) {
            passed++;
            System.out.println("PASS: " + label);
        } else {
            System.out.println("REVISE: " + label + " (expected " + expected + ", got " + actual + ")");
        }
    }

    public static void main(String[] args) {
        check("7 of 8", 87.5, Percent.percentCorrect(7, 8));
        check("1 of 3 (not a whole number)", 100.0 / 3, Percent.percentCorrect(1, 3));
        check("2 of 3", 200.0 / 3, Percent.percentCorrect(2, 3));
        check("none correct", 0.0, Percent.percentCorrect(0, 5));
        check("all correct", 100.0, Percent.percentCorrect(5, 5));
        check("13 of 20", 65.0, Percent.percentCorrect(13, 20));
        System.out.println(passed + " of " + total + " checks passed");
        System.out.println("Passing means your method works on these cases. It is feedback, not proof that it works for every input.");
        if (passed != total) System.exit(1);
    }
}
