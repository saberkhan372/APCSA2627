public class TicketCheck {
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
        int before = Ticket.getCreatedCount();
        Ticket first = new Ticket();
        Ticket second = new Ticket();
        check("first next id", first.getId() == before + 1);
        check("second next id", second.getId() == before + 2);
        check("ids differ", first.getId() != second.getId());
        check("created count advances", Ticket.getCreatedCount() == before + 2);
        int firstId = first.getId();
        new Ticket();
        check("old id remains", first.getId() == firstId);
        check("count shared", Ticket.getCreatedCount() == before + 3);
        check("ids are positive", first.getId() > 0);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

