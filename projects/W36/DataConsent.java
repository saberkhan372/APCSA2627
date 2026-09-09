public class DataConsent {
    public static boolean mayReuse(boolean consented, String statedPurpose,
            String requestedPurpose, boolean containsSensitiveData) {
        // TODO: enforce consent, purpose limitation, and sensitivity.
        return false;
    }

    public static void main(String[] args) {
        System.out.println(mayReuse(true, "route", "route", false));
        System.out.println(mayReuse(true, "route", "ads", false));
    }
}

