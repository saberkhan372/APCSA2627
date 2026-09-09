public class RecursiveAlgorithmsCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        int[] values = {2,5,8,11,14,17,20};
        check("recursive hit first", RecursiveAlgorithms.binarySearch(values, 2, 0, 6) == 0);
        check("recursive hit middle", RecursiveAlgorithms.binarySearch(values, 11, 0, 6) == 3);
        check("recursive hit last", RecursiveAlgorithms.binarySearch(values, 20, 0, 6) == 6);
        check("recursive miss", RecursiveAlgorithms.binarySearch(values, 9, 0, 6) == -1);
        check("recursive empty interval", RecursiveAlgorithms.binarySearch(values, 2, 1, 0) == -1);
        check("merge four", java.util.Arrays.equals(RecursiveAlgorithms.mergeSort(new int[]{5,1,4,2}), new int[]{1,2,4,5}));
        check("merge duplicates", java.util.Arrays.equals(RecursiveAlgorithms.mergeSort(new int[]{3,1,3}), new int[]{1,3,3}));
        check("merge empty", java.util.Arrays.equals(RecursiveAlgorithms.mergeSort(new int[]{}), new int[]{}));
        check("merge one", java.util.Arrays.equals(RecursiveAlgorithms.mergeSort(new int[]{7}), new int[]{7}));
        int[] original = {2,1};
        RecursiveAlgorithms.mergeSort(original);
        check("input preserved", java.util.Arrays.equals(original, new int[]{2,1}));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

