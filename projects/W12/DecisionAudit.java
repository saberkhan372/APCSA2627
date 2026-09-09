public class DecisionAudit {
    public static String classify(int value) {
        // TODO: return "negative", "zero", "even", or "odd".
        return "unfinished";
    }

    public static boolean inRange(int value, int low, int high) {
        // Precondition: low <= high
        // TODO: include both endpoints.
        return false;
    }

    public static void main(String[] args) {
        System.out.println(classify(-3));
        System.out.println(classify(8));
        System.out.println(inRange(7, 1, 10));
    }
}
