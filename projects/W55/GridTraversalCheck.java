public class GridTraversalCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        check("two by three", GridTraversal.rowMajor(new int[][]{{1,2,3},{4,5,6}}).equals("1 2 3\n4 5 6"));
        check("three by two", GridTraversal.rowMajor(new int[][]{{1,2},{3,4},{5,6}}).equals("1 2\n3 4\n5 6"));
        check("one row", GridTraversal.rowMajor(new int[][]{{7,8}}).equals("7 8"));
        check("one column", GridTraversal.rowMajor(new int[][]{{7},{8}}).equals("7\n8"));
        check("one cell", GridTraversal.rowMajor(new int[][]{{9}}).equals("9"));
        check("zero rows", GridTraversal.rowMajor(new int[][]{}).equals(""));
        check("ragged rows supported", GridTraversal.rowMajor(new int[][]{{1},{2,3}}).equals("1\n2 3"));
        check("negative values", GridTraversal.rowMajor(new int[][]{{-1,0}}).equals("-1 0"));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

