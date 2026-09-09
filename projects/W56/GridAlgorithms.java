public class GridAlgorithms {
    public static int rowSum(int[][] grid, int row) {
        // TODO
        return 0;
    }

    public static boolean columnContains(int[][] grid, int col, int target) {
        // TODO
        return false;
    }

    public static int[] locate(int[][] grid, int target) {
        // Return {-1, -1} if absent.
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(rowSum(grid, 1));
        System.out.println(columnContains(grid, 2, 3));
    }
}

