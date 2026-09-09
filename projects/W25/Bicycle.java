public class Bicycle {
    private String model;
    private int gear;
    private int speed;

    public Bicycle(String model, int gear, int speed) {
        // TODO: initialize every field and prevent negative speed.
        this.model = "unnamed";
        this.gear = 0;
        this.speed = 0;
    }

    public String getModel() { return model; }
    public int getGear() { return gear; }
    public int getSpeed() { return speed; }

    public static void main(String[] args) {
        Bicycle bike = new Bicycle("Comet", 3, 12);
        System.out.println(bike.getModel() + " @ " + bike.getSpeed());
    }
}

