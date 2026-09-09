import java.util.Arrays;

public class ArrayShift {
    public static void shiftRight(int[] values) {
        // BUG: this direction overwrites source values.
        for (int i = 1; i < values.length; i++) {
            values[i] = values[i - 1];
        }
    }

    public static void insertFront(int[] values, int value) {
        // TODO: shift, then replace index zero when it exists.
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4};
        shiftRight(values);
        System.out.println(Arrays.toString(values));
    }
}

