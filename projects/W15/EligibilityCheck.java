public class EligibilityCheck {
    private static int passed = 0;
    private static int total = 0;

    private static void check(String label, boolean expected, boolean actual) {
        total++;
        if (expected == actual) {
            passed++;
            System.out.println("PASS: " + label);
        } else {
            System.out.println("REVISE: " + label + " (expected " + expected + ", got " + actual + ")");
        }
    }

    public static void main(String[] args) {
        check("negative score is outside", true, Eligibility.outsideScoreRange(-1));
        check("zero is inside", false, Eligibility.outsideScoreRange(0));
        check("100 is inside", false, Eligibility.outsideScoreRange(100));
        check("101 is outside", true, Eligibility.outsideScoreRange(101));
        check("one missing requirement", true, Eligibility.notBoth(true, false));
        check("both requirements present", false, Eligibility.notBoth(true, true));
        check("Saturday is weekend", false, Eligibility.notWeekend(7));
        check("Wednesday is not weekend", true, Eligibility.notWeekend(4));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
