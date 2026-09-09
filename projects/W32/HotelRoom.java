public class HotelRoom {
    private int number;
    private boolean occupied;

    public HotelRoom(int number) {
        // BUG: parameter assigns to itself.
        number = number;
        occupied = false;
    }

    public void setNumber(int number) {
        // TODO: accept positive room numbers.
    }

    public void checkIn() { occupied = true; }
    public int getNumber() { return number; }
    public boolean isOccupied() { return occupied; }

    public String toString() {
        String status = occupied ? "occupied" : "vacant";
        return "room " + number + ": " + status;
    }

    public static void main(String[] args) {
        System.out.println(new HotelRoom(7102));
    }
}

