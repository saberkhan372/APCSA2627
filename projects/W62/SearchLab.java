public class SearchLab {
    public static int sequentialSearch(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] values, int target) {
        // Precondition: values is sorted in ascending order.
        // TODO
        return -1;
    }

    public static void main(String[] args) {
        int[] values = {2, 5, 8, 11, 14, 17, 20};
        System.out.println(sequentialSearch(values, 11));
        System.out.println(binarySearch(values, 14));
    }
}

