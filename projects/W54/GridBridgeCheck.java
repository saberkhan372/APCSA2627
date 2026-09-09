public class GridBridgeCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        check("row mapping", GridBridge.rowFor(249, 100) == 2);
        check("column mapping", GridBridge.colFor(349, 100) == 3);
        check("origin valid", GridBridge.isValidPixel(new int[][]{{1,2},{3,4}}, 0, 0, 100));
        check("last interior valid", GridBridge.isValidPixel(new int[][]{{1,2},{3,4}}, 199, 199, 100));
        check("right edge invalid", !GridBridge.isValidPixel(new int[][]{{1,2},{3,4}}, 200, 100, 100));
        check("negative invalid", !GridBridge.isValidPixel(new int[][]{{1,2},{3,4}}, -1, 0, 100));
        check("rectangular width", !GridBridge.isValidPixel(new int[][]{{1,2,3},{4,5,6}}, 300, 0, 100));
        check("pixel value", GridBridge.valueAtPixel(new int[][]{{1,2,3},{4,5,6}}, 250, 150, 100) == 6);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

