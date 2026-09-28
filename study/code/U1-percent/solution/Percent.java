public class Percent {
    /**
     * Returns the percentage of questions answered correctly, from 0.0 to 100.0,
     * without rounding. Example: percentCorrect(7, 8) returns 87.5
     *
     * Precondition: total > 0 and 0 <= correct <= total.
     */
    public static double percentCorrect(int correct, int total) {
        return 100.0 * correct / total;
    }

    public static void main(String[] args) {
        System.out.println(percentCorrect(7, 8));
    }
}
