public class DataConsentCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        check("same purpose with consent", DataConsent.mayReuse(true, "route", "route", false));
        check("no consent rejected", !DataConsent.mayReuse(false, "route", "route", false));
        check("purpose change rejected", !DataConsent.mayReuse(true, "route", "ads", false));
        check("sensitive reuse rejected", !DataConsent.mayReuse(true, "route", "route", true));
        check("two failures rejected", !DataConsent.mayReuse(false, "route", "ads", false));
        check("purpose comparison uses content", DataConsent.mayReuse(true, new String("route"), new String("route"), false));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

