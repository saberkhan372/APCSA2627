public class WordToolsCheck {
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
        check("first word in phrase", "rain", WordTools.firstWord("rain catcher game"));
        check("one word", "solo", WordTools.firstWord("solo"));
        check("empty String", "", WordTools.firstWord(""));
        check("typical slice", "mpu", WordTools.safeSlice("computer", 2, 5));
        check("zero-length slice", "", WordTools.safeSlice("computer", 3, 3));
        check("end may equal length", "ter", WordTools.safeSlice("computer", 5, 8));
        boolean invalid = WordTools.safeSlice("computer", -1, 2).equals("invalid")
                && WordTools.safeSlice("computer", 5, 2).equals("invalid")
                && WordTools.safeSlice("computer", 2, 9).equals("invalid");
        check("illegal bounds", true, invalid);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
