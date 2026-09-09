public class ListRemovalCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        java.util.ArrayList<Integer> values = new java.util.ArrayList<>(java.util.Arrays.asList(1, -2, -3, 2, 3));
        ListRemoval.removeNegatives(values);
        check("adjacent negatives", values.equals(java.util.Arrays.asList(1, 2, 3)));
        java.util.ArrayList<Integer> edges = new java.util.ArrayList<>(java.util.Arrays.asList(-1, 2, -3));
        ListRemoval.removeNegatives(edges);
        check("edge negatives", edges.equals(java.util.Arrays.asList(2)));
        java.util.ArrayList<Integer> all = new java.util.ArrayList<>(java.util.Arrays.asList(-1, -2));
        ListRemoval.removeNegatives(all);
        check("all removed", all.isEmpty());
        java.util.ArrayList<Integer> none = new java.util.ArrayList<>(java.util.Arrays.asList(0, 2));
        ListRemoval.removeNegatives(none);
        check("none removed", none.equals(java.util.Arrays.asList(0, 2)));
        java.util.ArrayList<Integer> dup = new java.util.ArrayList<>(java.util.Arrays.asList(1, 1, 1, 2, 2, 3));
        ListRemoval.removeConsecutiveDuplicates(dup);
        check("runs collapsed", dup.equals(java.util.Arrays.asList(1, 2, 3)));
        java.util.ArrayList<Integer> separated = new java.util.ArrayList<>(java.util.Arrays.asList(1, 2, 1));
        ListRemoval.removeConsecutiveDuplicates(separated);
        check("nonconsecutive retained", separated.equals(java.util.Arrays.asList(1, 2, 1)));
        java.util.ArrayList<Integer> one = new java.util.ArrayList<>(java.util.Arrays.asList(8));
        ListRemoval.removeConsecutiveDuplicates(one);
        check("one safe", one.equals(java.util.Arrays.asList(8)));
        java.util.ArrayList<Integer> empty = new java.util.ArrayList<>();
        ListRemoval.removeConsecutiveDuplicates(empty);
        check("empty safe", empty.isEmpty());
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

