public class ExpressionLab {
    public static double average(int a, int b, int c) {
        // TODO: keep the fractional part.
        return (a + b + c) / 3;
    }

    public static int wholePart(double value) {
        // TODO: use an explicit cast.
        return 0;
    }

    public static int remainder(int value, int divisor) {
        // Precondition: divisor != 0
        // TODO: return the remainder.
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(average(90, 85, 84));
        System.out.println(wholePart(4.9));
        System.out.println(remainder(17, 4));
    }
}
