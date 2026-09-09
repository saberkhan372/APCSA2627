public class CardCheck {
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
        check("complete constructor rank", new Card("7", "hearts").toString().equals("7 of hearts"));
        check("default suit", new Card("ace").toString().equals("ace of spades"));
        check("blank rank validation", new Card("", "clubs").toString().equals("? of clubs"));
        check("blank suit validation", new Card("king", "").toString().equals("king of ?"));
        check("convenience uses validation", new Card("").toString().equals("? of spades"));
        check("instances remain independent", !new Card("2").toString().equals(new Card("3").toString()));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

