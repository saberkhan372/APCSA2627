import java.util.ArrayList;

public class ListTraversal {
    public static String longest(ArrayList<String> words) {
        // Contract: return "" for an empty list and preserve the first tie.
        return "unfinished";
    }

    public static void addSuffix(ArrayList<String> words, String suffix) {
        // TODO: replace every element.
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("cat");
        words.add("tiger");
        System.out.println(longest(words));
        addSuffix(words, "!");
        System.out.println(words);
    }
}

