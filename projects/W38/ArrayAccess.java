public class ArrayAccess {
    public static int first(int[] values) {
        // Contract: return 0 for an empty array.
        return 0;
    }

    public static int last(int[] values) {
        // Contract: return 0 for an empty array.
        return 0;
    }

    public static void replace(int[] values, int index, int replacement) {
        // TODO: ignore an invalid index.
    }

    public static void main(String[] args) {
        int[] values = {4, 7, 9};
        System.out.println(first(values));
        System.out.println(last(values));
    }
}

