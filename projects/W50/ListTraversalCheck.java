public class ListTraversalCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        java.util.ArrayList<String> words = new java.util.ArrayList<>(java.util.Arrays.asList("cat", "tiger", "horse"));
        check("longest value", ListTraversal.longest(words).equals("tiger"));
        check("first tie preserved", ListTraversal.longest(words).equals("tiger"));
        check("empty contract", ListTraversal.longest(new java.util.ArrayList<>()).equals(""));
        check("single longest", ListTraversal.longest(new java.util.ArrayList<>(java.util.Arrays.asList("one"))).equals("one"));
        int before = words.size();
        ListTraversal.addSuffix(words, "!");
        check("all replaced", words.equals(java.util.Arrays.asList("cat!", "tiger!", "horse!")));
        check("size preserved", words.size() == before);
        java.util.ArrayList<String> empty = new java.util.ArrayList<>();
        ListTraversal.addSuffix(empty, "?");
        check("empty replacement safe", empty.isEmpty());
        ListTraversal.addSuffix(words, "");
        check("empty suffix preserves text", words.get(0).equals("cat!"));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

