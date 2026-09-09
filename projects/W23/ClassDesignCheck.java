public class ClassDesignCheck {
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
        check("store state belongs to model", ClassDesign.ownerOf("store score").equals("model"));
        check("change state belongs to model", ClassDesign.ownerOf("change score").equals("model"));
        check("calculate result belongs to model", ClassDesign.ownerOf("calculate total").equals("model"));
        check("drawing belongs to interface", ClassDesign.ownerOf("draw score").equals("interface"));
        check("mouse belongs to interface", ClassDesign.ownerOf("read mouse").equals("interface"));
        check("keyboard belongs to interface", ClassDesign.ownerOf("keyboard input").equals("interface"));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

