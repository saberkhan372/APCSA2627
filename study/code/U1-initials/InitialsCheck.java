public class InitialsCheck {
    private static int passed = 0;
    private static int total = 0;

    private static void check(String label, String expected, String actual) {
        total++;
        if (expected.equals(actual)) {
            passed++;
            System.out.println("PASS: " + label);
        } else {
            System.out.println("REVISE: " + label + " (expected \"" + expected + "\", got \"" + actual + "\")");
        }
    }

    public static void main(String[] args) {
        check("typical name", "A.L.", Initials.initials("Ada Lovelace"));
        check("another name", "G.H.", Initials.initials("Grace Hopper"));
        check("one-letter names", "X.Y.", Initials.initials("X Y"));
        check("lower case stays lower case", "b.h.", Initials.initials("bell hooks"));
        check("hyphenated first name", "M.W.", Initials.initials("Mary-Jane Watson"));
        check("short first, long last", "J.O.", Initials.initials("Jo Oyelaran-Okafor"));
        System.out.println(passed + " of " + total + " checks passed");
        System.out.println("Passing means your method works on these cases. It is feedback, not proof that it works for every name.");
        if (passed != total) System.exit(1);
    }
}
