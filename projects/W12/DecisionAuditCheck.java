public class DecisionAuditCheck {
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
        check("negative values", "negative", DecisionAudit.classify(-3));
        check("zero has its own branch", "zero", DecisionAudit.classify(0));
        check("positive even values", "even", DecisionAudit.classify(8));
        check("positive odd values", "odd", DecisionAudit.classify(9));
        check("range includes low endpoint", true, DecisionAudit.inRange(1, 1, 10));
        check("range rejects values above high", false, DecisionAudit.inRange(11, 1, 10));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
