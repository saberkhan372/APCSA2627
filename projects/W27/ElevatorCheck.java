public class ElevatorCheck {
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
        Elevator lift = new Elevator(3);
        check("starts on floor one", lift.getFloor() == 1);
        check("can move up initially", lift.canMoveUp());
        check("cannot move down initially", !lift.canMoveDown());
        lift.moveUp();
        check("moves to floor two", lift.getFloor() == 2);
        lift.moveUp();
        check("reaches top", lift.getFloor() == 3);
        check("cannot move above top", !lift.canMoveUp());
        lift.moveUp();
        check("top guard", lift.getFloor() == 3);
        lift.moveDown();
        check("moves down", lift.getFloor() == 2);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

