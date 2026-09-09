public class ExpressionLabCheck {
    private static int passed = 0;
    private static int total = 0;

    private static void check(String label, double expected, double actual) {
        total++;
        if (Math.abs(expected - actual) < 0.0000001) {
            passed++;
            System.out.println("PASS: " + label);
        } else {
            System.out.println("REVISE: " + label + " (expected " + expected + ", got " + actual + ")");
        }
    }

    public static void main(String[] args) {
        check("fractional average", 86.33333333333333, ExpressionLab.average(90, 85, 84));
        check("exact average", 80.0, ExpressionLab.average(70, 80, 90));
        check("average of small values", 2.0, ExpressionLab.average(1, 2, 3));
        check("positive whole part", 4, ExpressionLab.wholePart(4.9));
        check("negative cast truncates toward zero", -4, ExpressionLab.wholePart(-4.9));
        check("typical remainder", 1, ExpressionLab.remainder(17, 4));
        check("zero remainder", 0, ExpressionLab.remainder(20, 5));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
