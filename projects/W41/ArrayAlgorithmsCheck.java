public class ArrayAlgorithmsCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        check("positive minimum", ArrayAlgorithms.minimum(new int[]{8, 3, 10}) == 3);
        check("negative minimum", ArrayAlgorithms.minimum(new int[]{-2, -9, 4}) == -9);
        check("single minimum", ArrayAlgorithms.minimum(new int[]{7}) == 7);
        check("target repeated", ArrayAlgorithms.countMatches(new int[]{8, 3, 3, 10}, 3) == 2);
        check("target absent", ArrayAlgorithms.countMatches(new int[]{8, 3, 3, 10}, 5) == 0);
        check("empty count", ArrayAlgorithms.countMatches(new int[]{}, 5) == 0);
        check("all match", ArrayAlgorithms.countMatches(new int[]{2, 2, 2}, 2) == 3);
        check("zero target", ArrayAlgorithms.countMatches(new int[]{0, 1, 0}, 0) == 2);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

