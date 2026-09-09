public class ArrayTraversalCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        check("empty sum", ArrayTraversal.sum(new int[]{}) == 0);
        check("one sum", ArrayTraversal.sum(new int[]{7}) == 7);
        check("mixed sum", ArrayTraversal.sum(new int[]{-2, 0, 5, 7}) == 10);
        check("empty positive count", ArrayTraversal.countPositive(new int[]{}) == 0);
        check("zero excluded", ArrayTraversal.countPositive(new int[]{0}) == 0);
        check("mixed positive count", ArrayTraversal.countPositive(new int[]{-2, 0, 5, 7}) == 2);
        int[] input = {1, 2, 3};
        ArrayTraversal.sum(input);
        check("input unchanged", java.util.Arrays.equals(input, new int[]{1, 2, 3}));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

