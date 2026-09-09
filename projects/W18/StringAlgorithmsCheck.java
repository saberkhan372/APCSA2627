public class StringAlgorithmsCheck {
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
        check("remove repeated characters", "bnn", StringAlgorithms.removeCharacter("banana", "a"));
        check("remove no characters", "code", StringAlgorithms.removeCharacter("code", "z"));
        check("remove from empty string", "", StringAlgorithms.removeCharacter("", "a"));
        check("two non-overlapping pairs", 2, StringAlgorithms.countDouble("baaaad", "a"));
        check("one pair", 1, StringAlgorithms.countDouble("book", "o"));
        check("short string", 0, StringAlgorithms.countDouble("a", "a"));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
