public class StringScanCheck {
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
        check("repeated character", 3, StringScan.countCharacter("banana", "a"));
        check("empty string", 0, StringScan.countCharacter("", "a"));
        check("first position", 0, StringScan.firstIndexOf("loop", "l"));
        check("middle position", 2, StringScan.firstIndexOf("banana", "n"));
        check("missing character", -1, StringScan.firstIndexOf("banana", "z"));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
