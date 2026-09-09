public class BicycleCheck {
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
        Bicycle bike = new Bicycle("Comet", 3, 12);
        check("model initialized", bike.getModel().equals("Comet"));
        check("gear initialized", bike.getGear() == 3);
        check("speed initialized", bike.getSpeed() == 12);
        Bicycle stopped = new Bicycle("City", 1, -4);
        check("negative speed repaired", stopped.getSpeed() == 0);
        check("second model independent", stopped.getModel().equals("City"));
        check("first model unchanged", bike.getModel().equals("Comet"));
        check("zero speed accepted", new Bicycle("Zero", 1, 0).getSpeed() == 0);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

