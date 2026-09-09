public class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank.length() == 0 ? "?" : rank;
        this.suit = suit.length() == 0 ? "?" : suit;
    }

    public Card(String rank) {
        // TODO: delegate to the complete constructor with "spades".
        this.rank = "?";
        this.suit = "?";
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public static void main(String[] args) {
        System.out.println(new Card("7", "hearts"));
        System.out.println(new Card("ace"));
    }
}

