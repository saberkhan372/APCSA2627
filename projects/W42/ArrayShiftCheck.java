public class ArrayShiftCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        int[] values = {1, 2, 3, 4};
        ArrayShift.shiftRight(values);
        check("right shift", java.util.Arrays.equals(values, new int[]{1, 1, 2, 3}));
        int[] inserted = {1, 2, 3, 4};
        ArrayShift.insertFront(inserted, 9);
        check("front insert", java.util.Arrays.equals(inserted, new int[]{9, 1, 2, 3}));
        int[] one = {5};
        ArrayShift.shiftRight(one);
        check("one shift safe", one[0] == 5);
        ArrayShift.insertFront(one, 7);
        check("one insert", one[0] == 7);
        int[] empty = {};
        ArrayShift.shiftRight(empty);
        check("empty shift safe", empty.length == 0);
        ArrayShift.insertFront(empty, 4);
        check("empty insert safe", empty.length == 0);
        int[] duplicates = {2, 2, 3};
        ArrayShift.shiftRight(duplicates);
        check("duplicates preserved", java.util.Arrays.equals(duplicates, new int[]{2, 2, 2}));
        check("length preserved", inserted.length == 4);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

