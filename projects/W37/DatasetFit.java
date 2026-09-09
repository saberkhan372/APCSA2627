public class DatasetFit {
    public static boolean isUsable(boolean hasVariable,
            boolean coversPopulation, boolean coversTimePeriod) {
        // TODO
        return false;
    }

    public static String firstMismatch(boolean hasVariable,
            boolean coversPopulation, boolean coversTimePeriod) {
        // TODO: return "variable", "population", "time", or "usable".
        return "insufficient";
    }

    public static void main(String[] args) {
        System.out.println(firstMismatch(false, true, true));
        System.out.println(firstMismatch(true, true, true));
    }
}

