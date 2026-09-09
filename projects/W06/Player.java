public class Player {
    private String name;
    private int score;

    public Player(String startName, int startScore) {
        name = startName;
        score = startScore;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int amount) {
        score += amount;
    }
}
