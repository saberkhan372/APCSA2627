public class GridTraversalCheck {
    private static int passed, total;
    private static void check(String label, int[][] grid, String expected) {
        total++;
        try {
            String actual = GridTraversal.rowMajor(grid);
            if (expected.equals(actual)) {
                passed++;
                System.out.println("PASS: " + label);
            } else {
                System.out.println("REVISE: " + label);
            }
        } catch (RuntimeException error) {
            System.out.println("REVISE: " + label + " threw "
                    + error.getClass().getSimpleName() + ": " + error.getMessage());
        }
    }
    public static void main(String[] args) throws Exception {
        check("two by three", new int[][]{{1,2,3},{4,5,6}}, "1 2 3\n4 5 6");
        check("three by two", new int[][]{{1,2},{3,4},{5,6}}, "1 2\n3 4\n5 6");
        check("one row", new int[][]{{7,8}}, "7 8");
        check("one column", new int[][]{{7},{8}}, "7\n8");
        check("one cell", new int[][]{{9}}, "9");
        check("zero rows", new int[][]{}, "");
        check("ragged rows supported", new int[][]{{1},{2,3}}, "1\n2 3");
        check("negative values", new int[][]{{-1,0}}, "-1 0");
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
