public class AdmissionCheck {
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
        check("invalid age comes first", "invalid", Admission.ticketGroup(-1, true));
        check("child boundary", "child", Admission.ticketGroup(12, false));
        check("senior branch", "senior", Admission.ticketGroup(65, true));
        check("student branch", "student", Admission.ticketGroup(14, true));
        check("adult enters without pass", true, Admission.mayEnter(16, false, false));
        check("minor needs adult and pass", false, Admission.mayEnter(14, true, false));
        check("minor with adult and pass", true, Admission.mayEnter(14, true, true));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}
