public class SortTraceCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        int[] values = {4,2,3,1};
        SortTrace.selectionPass(values, 0);
        check("first selection pass", java.util.Arrays.equals(values, new int[]{1,2,3,4}));
        int[] partial = {1,5,4,2};
        SortTrace.selectionPass(partial, 1);
        check("selection from index", java.util.Arrays.equals(partial, new int[]{1,2,4,5}));
        int[] duplicate = {3,1,1};
        SortTrace.selectionPass(duplicate, 0);
        check("selection duplicate", java.util.Arrays.equals(duplicate, new int[]{1,3,1}));
        int[] already = {1,2,3};
        SortTrace.selectionPass(already, 0);
        check("selection already ordered", java.util.Arrays.equals(already, new int[]{1,2,3}));
        int[] insert = {1,4,5,2};
        SortTrace.insertionPass(insert, 3);
        check("insertion shift", java.util.Arrays.equals(insert, new int[]{1,2,4,5}));
        int[] insertMiddle = {1,3,5,4};
        SortTrace.insertionPass(insertMiddle, 3);
        check("insertion middle", java.util.Arrays.equals(insertMiddle, new int[]{1,3,4,5}));
        int[] insertFirst = {2,3,4,1};
        SortTrace.insertionPass(insertFirst, 3);
        check("insertion to first", java.util.Arrays.equals(insertFirst, new int[]{1,2,3,4}));
        int[] insertEqual = {1,2,2};
        SortTrace.insertionPass(insertEqual, 2);
        check("insertion equal", java.util.Arrays.equals(insertEqual, new int[]{1,2,2}));
        check("length preserved", insert.length == 4);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

