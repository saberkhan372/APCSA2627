public class Elevator {
    private int floor;
    private int topFloor;

    public Elevator(int topFloor) {
        this.floor = 1;
        this.topFloor = topFloor;
    }

    public int getFloor() {
        // TODO
        return 0;
    }

    public boolean canMoveUp() {
        // TODO
        return false;
    }

    public boolean canMoveDown() {
        // TODO
        return false;
    }

    public void moveUp() {
        floor++;
    }

    public void moveDown() {
        floor--;
    }

    public static void main(String[] args) {
        Elevator lift = new Elevator(4);
        System.out.println("floor " + lift.getFloor());
        System.out.println(lift.canMoveUp());
    }
}

