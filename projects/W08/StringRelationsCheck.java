public class StringRelationsCheck {
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
        check("constructed equal Strings", true, StringRelations.sameText("cat", new String("cat")));
        check("same literal", true, StringRelations.sameText("Ada", "Ada"));
        check("different contents", false, StringRelations.sameText("cat", "dog"));
        check("before", -1, StringRelations.order("ant", "bee"));
        check("equal", 0, StringRelations.order("bee", new String("bee")));
        check("after", 1, StringRelations.order("dog", "cat"));
        check("prefix comes first", -1, StringRelations.order("app", "apple"));
        check("longer prefix comes after", 1, StringRelations.order("apple", "app"));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
