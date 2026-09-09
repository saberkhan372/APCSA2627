public class AliasingCheck {
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
        Player a = new Player("Ada", 4);
        Player b = new Player("Ada", 4);
        check("two new expressions create separate objects", false, AliasingLab.sameObject(a, b));
        check("a reference is the same as itself", true, AliasingLab.sameObject(a, a));
        Player alias = a;
        check("assignment creates an alias", true, AliasingLab.sameObject(a, alias));
        check("positive mutation through alias", 7, AliasingLab.scoreAfterAlias(4, 3));
        check("negative mutation through alias", 5, AliasingLab.scoreAfterAlias(8, -3));
        check("primitive assignment copies the value", 4, AliasingLab.primitiveAfterCopy(4, 99));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
