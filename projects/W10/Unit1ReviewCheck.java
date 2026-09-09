public class Unit1ReviewCheck {
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
        check("numeric expression", 4.5, Unit1Review.average(7, 2));
        check("random-range arithmetic", 4, Unit1Review.scaleSample(0.5, 1, 6));
        check("method call", 5.0, Unit1Review.distanceFromOrigin(3, 4));
        check("reference mutation", 7, Unit1Review.scoreThroughAlias(4, 3));
        check("substring boundary", "rain", Unit1Review.firstWord("rain catcher"));
        check("String traversal", 3, Unit1Review.countLetter("banana", "a"));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
