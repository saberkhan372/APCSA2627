public class ArrayAccessCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        check("first value", ArrayAccess.first(new int[]{4, 7, 9}) == 4);
        check("last value", ArrayAccess.last(new int[]{4, 7, 9}) == 9);
        check("one first", ArrayAccess.first(new int[]{8}) == 8);
        check("one last", ArrayAccess.last(new int[]{8}) == 8);
        check("empty first contract", ArrayAccess.first(new int[]{}) == 0);
        check("empty last contract", ArrayAccess.last(new int[]{}) == 0);
        int[] values = {1, 2, 3};
        ArrayAccess.replace(values, 1, 9);
        check("valid replacement", values[1] == 9);
        ArrayAccess.replace(values, 3, 7);
        check("invalid replacement ignored", values[0] == 1 && values[1] == 9 && values[2] == 3);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

