public class RecursionTraceCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        check("sum base", RecursionTrace.sumTo(0) == 0);
        check("sum one", RecursionTrace.sumTo(1) == 1);
        check("sum four", RecursionTrace.sumTo(4) == 10);
        check("sum six", RecursionTrace.sumTo(6) == 21);
        check("reverse base", RecursionTrace.reverseDigits(7).equals("7"));
        check("reverse three", RecursionTrace.reverseDigits(123).equals("321"));
        check("reverse repeated", RecursionTrace.reverseDigits(112).equals("211"));
        check("reverse internal zero", RecursionTrace.reverseDigits(101).equals("101"));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

