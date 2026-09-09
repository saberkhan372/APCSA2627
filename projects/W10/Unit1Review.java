public class Unit1Review {
    public static double average(int a, int b) {
        return 0.0;
    }

    /** Precondition: min <= max and 0.0 <= sample && sample < 1.0 */
    public static int scaleSample(double sample, int min, int max) {
        return 0;
    }

    public static double distanceFromOrigin(double x, double y) {
        return 0.0;
    }

    public static int scoreThroughAlias(int start, int amount) {
        return 0;
    }

    public static String firstWord(String text) {
        return "";
    }

    public static int countLetter(String text, String target) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(average(7, 2));
        System.out.println(scaleSample(0.5, 1, 6));
        System.out.println(distanceFromOrigin(3, 4));
        System.out.println(scoreThroughAlias(4, 3));
        System.out.println(firstWord("rain catcher"));
        System.out.println(countLetter("banana", "a"));
    }

    private static class ReviewPlayer {
        private int score;
        public ReviewPlayer(int startScore) { score = startScore; }
        public void addScore(int amount) { score += amount; }
        public int getScore() { return score; }
    }
}
