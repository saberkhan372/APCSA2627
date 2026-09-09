public class GridAlgorithmsCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        check("first row sum", GridAlgorithms.rowSum(grid, 0) == 6);
        check("last row sum", GridAlgorithms.rowSum(grid, 2) == 24);
        check("negative row sum", GridAlgorithms.rowSum(new int[][]{{-2,1}}, 0) == -1);
        check("column target present", GridAlgorithms.columnContains(grid, 1, 8));
        check("column target absent", !GridAlgorithms.columnContains(grid, 1, 9));
        check("first column", GridAlgorithms.columnContains(grid, 0, 7));
        check("locate middle", java.util.Arrays.equals(GridAlgorithms.locate(grid, 5), new int[]{1,1}));
        check("locate absent", java.util.Arrays.equals(GridAlgorithms.locate(grid, 10), new int[]{-1,-1}));
        check("row major first match", java.util.Arrays.equals(GridAlgorithms.locate(new int[][]{{2,1},{1,2}}, 1), new int[]{0,1}));
        check("single cell locate", java.util.Arrays.equals(GridAlgorithms.locate(new int[][]{{4}}, 4), new int[]{0,0}));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

