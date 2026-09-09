public class WrapperLabCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        check("positive round trip", WrapperLab.roundTrip(7) == 7);
        check("negative round trip", WrapperLab.roundTrip(-4) == -4);
        check("zero round trip", WrapperLab.roundTrip(0) == 0);
        check("text addition", WrapperLab.addTextNumbers("12", "30") == 42);
        check("negative text", WrapperLab.addTextNumbers("-5", "2") == -3);
        check("multi digit text", WrapperLab.addTextNumbers("100", "250") == 350);
        Integer boxed = WrapperLab.roundTrip(9);
        check("autobox result usable", boxed.intValue() == 9);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

