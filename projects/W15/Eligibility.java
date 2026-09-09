public class Eligibility {
    public static boolean outsideScoreRange(int score) {
        // TODO: return true when score is below 0 or above 100.
        return false;
    }

    public static boolean notBoth(boolean submitted, boolean signed) {
        // TODO: negate "submitted and signed" using De Morgan's law.
        return false;
    }

    public static boolean notWeekend(int day) {
        // 1 is Sunday and 7 is Saturday. Precondition: 1 <= day <= 7.
        // Repair this incorrect condition.
        return day != 1 || day != 7;
    }

    public static void main(String[] args) {
        System.out.println(outsideScoreRange(105));
        System.out.println(notBoth(true, false));
        System.out.println(notWeekend(7));
    }
}
