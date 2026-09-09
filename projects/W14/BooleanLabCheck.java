public class BooleanLabCheck {
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
        check("badge grants access", true, BooleanLab.mayAccess(true, false, false));
        check("staff grants access", true, BooleanLab.mayAccess(false, true, false));
        check("lockdown overrides badge", false, BooleanLab.mayAccess(true, false, true));
        check("neither role is rejected", false, BooleanLab.mayAccess(false, false, false));
        boolean[] values = {false, true};
        for (boolean a : values) {
            for (boolean b : values) {
                check("De Morgan row " + a + "," + b, true, BooleanLab.deMorganMatches(a, b));
            }
        }
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
