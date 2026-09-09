public class AliasingLab {
    public static boolean sameObject(Player first, Player second) {
        // TODO: ask whether the references reach the same object.
        return false;
    }

    public static int scoreAfterAlias(int startScore, int amount) {
        Player original = new Player("Ada", startScore);
        // TODO: make alias refer to the same Player, mutate through alias,
        // and return the score visible through original.
        Player alias = new Player("Ada", startScore);
        return 0;
    }

    public static int primitiveAfterCopy(int start, int replacement) {
        // TODO: copy start, change only the copy, and return the original.
        return 0;
    }

    public static void main(String[] args) {
        Player a = new Player("Ada", 4);
        Player b = new Player("Ada", 4);
        System.out.println(sameObject(a, b));
        System.out.println(scoreAfterAlias(4, 3));
        System.out.println(primitiveAfterCopy(4, 99));
    }
}
