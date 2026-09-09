import java.util.ArrayList;
import java.util.Arrays;

public class ListRemoval {
    public static void removeNegatives(ArrayList<Integer> values) {
        // BUG: incrementing after removal skips adjacent matches.
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) < 0) values.remove(i);
        }
    }

    public static void removeConsecutiveDuplicates(ArrayList<Integer> values) {
        // TODO: leave one value from each run.
    }

    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>(Arrays.asList(1, -2, -3, 2, 3));
        removeNegatives(values);
        System.out.println(values);
    }
}

