public class SearchLabCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        int[] values = {2,5,8,11,14,17,20};
        check("sequential first", SearchLab.sequentialSearch(values, 2) == 0);
        check("sequential last", SearchLab.sequentialSearch(values, 20) == 6);
        check("sequential miss", SearchLab.sequentialSearch(values, 9) == -1);
        check("binary first", SearchLab.binarySearch(values, 2) == 0);
        check("binary middle", SearchLab.binarySearch(values, 11) == 3);
        check("binary last", SearchLab.binarySearch(values, 20) == 6);
        check("binary miss between", SearchLab.binarySearch(values, 9) == -1);
        check("binary miss low", SearchLab.binarySearch(values, 1) == -1);
        check("binary miss high", SearchLab.binarySearch(values, 21) == -1);
        check("empty binary", SearchLab.binarySearch(new int[]{}, 4) == -1);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

