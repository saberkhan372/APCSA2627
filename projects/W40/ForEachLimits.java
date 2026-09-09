import java.util.Arrays;

public class ForEachLimits {
    public static int sum(int[] values) {
        int total = 0;
        for (int value : values) total += value;
        return total;
    }

    public static void doubleValues(int[] values) {
        // BUG: changing value does not replace an array slot.
        for (int value : values) value *= 2;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        System.out.println(sum(values));
        doubleValues(values);
        System.out.println(Arrays.toString(values));
    }
}

