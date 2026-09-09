public class LoopTraceCheck {
    private static int passed = 0;
    private static int total = 0;

    private static void check(String label, int expected, int actual) {
        total++;
        if (expected == actual) {
            passed++;
            System.out.println("PASS: " + label);
        } else {
            System.out.println("REVISE: " + label + " (expected " + expected + ", got " + actual + ")");
        }
    }

    public static void main(String[] args) {
        check("empty sum", 0, LoopTrace.sumTo(0));
        check("sum through five", 15, LoopTrace.sumTo(5));
        check("one inclusive value", 1, LoopTrace.countBy(4, 4, 3));
        check("count evens", 5, LoopTrace.countBy(2, 10, 2));
        check("step does not have to land on stop", 4, LoopTrace.countBy(1, 8, 2));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
