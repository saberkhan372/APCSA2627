import java.util.Arrays;

public class SortTrace {
    public static void selectionPass(int[] values, int start) {
        // TODO: find the minimum from start onward and swap once.
    }

    public static void insertionPass(int[] values, int index) {
        // TODO: insert values[index] into the sorted prefix.
    }

    public static void main(String[] args) {
        int[] values = {4, 2, 3, 1};
        selectionPass(values, 0);
        System.out.println(Arrays.toString(values));
    }
}

