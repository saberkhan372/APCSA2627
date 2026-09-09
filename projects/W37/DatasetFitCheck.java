public class DatasetFitCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        check("all coverage usable", DatasetFit.isUsable(true, true, true));
        check("missing variable unusable", !DatasetFit.isUsable(false, true, true));
        check("population gap unusable", !DatasetFit.isUsable(true, false, true));
        check("time gap unusable", !DatasetFit.isUsable(true, true, false));
        check("variable classified first", DatasetFit.firstMismatch(false, false, false).equals("variable"));
        check("population classified", DatasetFit.firstMismatch(true, false, true).equals("population"));
        check("time classified", DatasetFit.firstMismatch(true, true, false).equals("time"));
        check("usable classified", DatasetFit.firstMismatch(true, true, true).equals("usable"));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

