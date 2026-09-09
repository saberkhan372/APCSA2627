public class ListMethodsCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        java.util.ArrayList<Integer> values = new java.util.ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4));
        ListMethods.rotateLeft(values);
        check("rotate four", values.equals(java.util.Arrays.asList(2, 3, 4, 1)));
        java.util.ArrayList<Integer> one = new java.util.ArrayList<>(java.util.Arrays.asList(8));
        ListMethods.rotateLeft(one);
        check("rotate one", one.equals(java.util.Arrays.asList(8)));
        java.util.ArrayList<Integer> empty = new java.util.ArrayList<>();
        ListMethods.rotateLeft(empty);
        check("rotate empty", empty.isEmpty());
        java.util.ArrayList<Integer> odd = new java.util.ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4, 5));
        ListMethods.replaceMiddle(odd, 9);
        check("replace middle", odd.equals(java.util.Arrays.asList(1, 2, 9, 4, 5)));
        check("set preserves size", odd.size() == 5);
        check("get reads replacement", odd.get(2) == 9);
        odd.add(2, 7);
        check("indexed add shifts", odd.equals(java.util.Arrays.asList(1, 2, 7, 9, 4, 5)));
        Integer removed = odd.remove(2);
        check("remove returns value", removed == 7);
        check("remove shifts left", odd.get(2) == 9);
        check("final size", odd.size() == 5);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

