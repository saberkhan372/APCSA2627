public class PlayerRoster {
    private Player captain;

    public PlayerRoster(Player captain) {
        this.captain = captain;
    }

    public Player getCaptainAlias() {
        return captain;
    }

    public Player getCaptainCopy() {
        // TODO: return a different Player with the same state.
        return captain;
    }

    public static void main(String[] args) {
        PlayerRoster roster = new PlayerRoster(new Player("Mina", 10));
        Player outside = roster.getCaptainAlias();
        System.out.println(outside);
        outside.setScore(99);
        System.out.println(roster.getCaptainAlias());
    }
}

