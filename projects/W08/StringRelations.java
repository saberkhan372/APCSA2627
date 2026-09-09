public class StringRelations {
    public static boolean sameText(String left, String right) {
        // TODO: compare contents, not identity.
        return left == right;
    }

    public static int order(String left, String right) {
        // Return -1, 0, or 1 from the sign of compareTo.
        return 0;
    }

    public static void main(String[] args) {
        String a = "cat";
        String b = new String("cat");
        System.out.println(sameText(a, b));
        System.out.println(order(a, b));
    }
}
