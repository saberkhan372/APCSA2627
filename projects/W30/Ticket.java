public class Ticket {
    private static int nextId = 1;
    private int id;

    public Ticket() {
        // TODO: assign id and advance the shared counter.
        id = 0;
    }

    public int getId() { return id; }

    public static int getCreatedCount() {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Ticket first = new Ticket();
        Ticket second = new Ticket();
        System.out.println(first.getId() + ", " + second.getId());
        System.out.println("created: " + getCreatedCount());
    }
}

