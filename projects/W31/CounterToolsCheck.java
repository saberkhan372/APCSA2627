public class CounterToolsCheck {
    private static int passed;
    private static int total;

    private static void check(String label, boolean condition) {
        total++;
        if (condition) {
            passed++;
            System.out.println("PASS: " + label);
        } else {
            System.out.println("REVISE: " + label);
        }
    }

    public static void main(String[] args) throws Exception {
        int before = CounterTools.getCalls();
        CounterTools a = new CounterTools();
        CounterTools b = new CounterTools();
        a.add(5);
        b.add(12);
        check("first instance count", a.getCount() == 5);
        check("second instance count", b.getCount() == 12);
        check("instances independent", a.getCount() != b.getCount());
        check("static utility first", CounterTools.totalOf(a) == 5);
        check("static utility second", CounterTools.totalOf(b) == 12);
        check("shared call count", CounterTools.getCalls() == before + 2);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

