public class PlayerRosterCheck {
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
        Player original = new Player("Mina", 10);
        PlayerRoster roster = new PlayerRoster(original);
        check("alias is same reference", roster.getCaptainAlias() == original);
        original.setScore(20);
        check("alias mutation visible", roster.getCaptainAlias().getScore() == 20);
        Player copy = roster.getCaptainCopy();
        check("copy is different reference", copy != original);
        check("copy keeps name", copy.getName().equals("Mina"));
        check("copy keeps score", copy.getScore() == 20);
        copy.setScore(99);
        check("copy mutation isolated", roster.getCaptainAlias().getScore() == 20);
        check("copy now has own state", copy.getScore() == 99);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

