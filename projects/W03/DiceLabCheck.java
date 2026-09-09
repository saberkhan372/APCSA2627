public class DiceLabCheck {
    private static int passed = 0;
    private static int total = 0;

    private static void check(String label, Object expected, Object actual) {
        total++;
        if (expected.equals(actual)) {
            passed++;
            System.out.println("PASS: " + label);
        } else {
            System.out.println("REVISE: " + label + " (expected " + expected + ", got " + actual + ")");
        }
    }

    public static void main(String[] args) {
        check("minimum sample", 1, DiceLab.scaleSample(0.0, 1, 6));
        check("first bucket", 1, DiceLab.scaleSample(0.16, 1, 6));
        check("middle bucket", 4, DiceLab.scaleSample(0.5, 1, 6));
        check("sample just below one", 6, DiceLab.scaleSample(0.999999, 1, 6));
        check("negative-range minimum", -3, DiceLab.scaleSample(0.0, -3, 4));
        check("negative-range maximum", 4, DiceLab.scaleSample(0.999999, -3, 4));
        boolean inRange = true;
        for (int i = 0; i < 1000; i++) {
            int value = DiceLab.roll(20, 25);
            if (value < 20 || value > 25) inRange = false;
        }
        check("repeated random range", true, inRange);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
