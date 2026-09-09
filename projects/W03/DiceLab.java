public class DiceLab {
    /** Precondition: min <= max and 0.0 <= sample && sample < 1.0 */
    public static int scaleSample(double sample, int min, int max) {
        // TODO: map the sample to the inclusive integer range.
        return min;
    }

    /** Precondition: min <= max */
    public static int roll(int min, int max) {
        // TODO: call scaleSample with Math.random().
        return min;
    }

    public static void main(String[] args) {
        System.out.println(scaleSample(0.0, 1, 6));
        System.out.println(scaleSample(0.5, 1, 6));
        System.out.println(scaleSample(0.999999, 1, 6));
    }
}
