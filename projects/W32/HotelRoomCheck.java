public class HotelRoomCheck {
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
        HotelRoom room = new HotelRoom(7102);
        check("constructor uses parameter", room.getNumber() == 7102);
        check("starts vacant", !room.isOccupied());
        room.checkIn();
        check("check in changes field", room.isOccupied());
        room.setNumber(7103);
        check("valid setter", room.getNumber() == 7103);
        room.setNumber(0);
        check("zero ignored", room.getNumber() == 7103);
        room.setNumber(-1);
        check("negative ignored", room.getNumber() == 7103);
        check("text uses local status", room.toString().equals("room 7103: occupied"));
        check("invalid constructor repaired", new HotelRoom(-4).getNumber() == 1);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

