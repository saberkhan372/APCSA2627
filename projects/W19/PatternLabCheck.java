public class PatternLabCheck {
    private static int passed = 0;
    private static int total = 0;

    private static void check(String label, Object expected, Object actual) {
        total++;
        if (expected.equals(actual)) {
            passed++;
            System.out.println("PASS: " + label);
        } else {
            System.out.println("REVISE: " + label + " (expected " + expected + ", got " + actual + ")");
        }
    }

    public static void main(String[] args) {
        check("one-row staircase", "*", PatternLab.staircase(1));
        check("three-row staircase", "***\n-**\n--*", PatternLab.staircase(3));
        check("no factor pair under two", 0, PatternLab.countFactorPairs(2));
        check("factor pairs through five", 2, PatternLab.countFactorPairs(5));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
