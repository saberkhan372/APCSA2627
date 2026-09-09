import java.util.ArrayList;
import java.util.Arrays;

public class ListMethods {
    public static void rotateLeft(ArrayList<Integer> values) {
        // TODO: use remove and add without a loop.
    }

    public static void replaceMiddle(ArrayList<Integer> values, int replacement) {
        // Precondition: values has odd, positive size.
        // TODO: use set.
    }

    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        rotateLeft(values);
        System.out.println(values);
    }
}

