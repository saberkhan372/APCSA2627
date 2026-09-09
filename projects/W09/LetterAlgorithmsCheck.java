public class LetterAlgorithmsCheck {
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
        check("repeated letter count", 3, LetterAlgorithms.countLetter("banana", "a"));
        check("missing letter count", 0, LetterAlgorithms.countLetter("banana", "z"));
        check("first and last count", 2, LetterAlgorithms.countLetter("level", "l"));
        check("empty count", 0, LetterAlgorithms.countLetter("", "a"));
        check("remove repeated letters", "bnn", LetterAlgorithms.removeLetter("banana", "a"));
        check("remove missing letter", "banana", LetterAlgorithms.removeLetter("banana", "z"));
        check("remove every letter", "", LetterAlgorithms.removeLetter("aaaa", "a"));
        check("remove from empty String", "", LetterAlgorithms.removeLetter("", "a"));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
