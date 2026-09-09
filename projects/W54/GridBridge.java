public class GridBridge {
    public static int rowFor(int y, int cellSize) {
        // TODO
        return 0;
    }

    public static int colFor(int x, int cellSize) {
        // TODO
        return 0;
    }

    public static boolean isValidPixel(int[][] grid, int x, int y, int cellSize) {
        // TODO
        return false;
    }

    public static int valueAtPixel(int[][] grid, int x, int y, int cellSize) {
        // Precondition: isValidPixel(...) is true.
        return grid[0][0];
    }

    public static void main(String[] args) {
        System.out.println("row " + rowFor(249, 100)
                + ", col " + colFor(349, 100));
    }
}

