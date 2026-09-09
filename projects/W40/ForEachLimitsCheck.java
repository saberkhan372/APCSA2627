public class ForEachLimitsCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        check("enhanced for sum", ForEachLimits.sum(new int[]{1, 2, 3}) == 6);
        check("empty sum", ForEachLimits.sum(new int[]{}) == 0);
        check("negative sum", ForEachLimits.sum(new int[]{-2, 1}) == -1);
        int[] values = {1, 2, 3};
        ForEachLimits.doubleValues(values);
        check("all slots doubled", java.util.Arrays.equals(values, new int[]{2, 4, 6}));
        int[] one = {-4};
        ForEachLimits.doubleValues(one);
        check("negative doubled", one[0] == -8);
        int[] empty = {};
        ForEachLimits.doubleValues(empty);
        check("empty safe", empty.length == 0);
        check("size preserved", values.length == 3);
        check("sum after mutation", ForEachLimits.sum(values) == 12);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

