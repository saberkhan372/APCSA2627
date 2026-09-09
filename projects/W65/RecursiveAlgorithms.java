import java.util.Arrays;

public class RecursiveAlgorithms {
    public static int binarySearch(int[] values, int target, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (values[mid] == target) return mid;
        if (values[mid] < target) {
            return binarySearch(values, target, mid + 1, high);
        }
        return binarySearch(values, target, low, mid - 1);
    }

    public static int[] mergeSort(int[] values) {
        if (values.length <= 1) return values.clone();
        int mid = values.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(values, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(values, mid, values.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) result[k++] = left[i++];
            else result[k++] = right[j++];
        }
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
        return result;
    }

    public static void main(String[] args) {
        int[] values = {2, 5, 8, 11, 14, 17, 20};
        System.out.println("index " + binarySearch(values, 14, 0, values.length - 1));
        System.out.println(Arrays.toString(mergeSort(new int[]{5, 1, 4, 2})));
    }
}

