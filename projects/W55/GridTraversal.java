public class GridTraversal {
    public static String rowMajor(int[][] grid) {
        String result = "";
        // BUG: grid.length is incorrectly used for both dimensions.
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {
                if (col > 0) result += " ";
                result += grid[row][col];
            }
            if (row < grid.length - 1) result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(rowMajor(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }
}

