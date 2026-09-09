public class RecursionTrace {
    public static int sumTo(int n) {
        if (n == 0) return 0;
        return n + sumTo(n - 1);
    }

    public static String reverseDigits(int n) {
        if (n < 10) return String.valueOf(n);
        return (n % 10) + reverseDigits(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(sumTo(4));
        System.out.println(reverseDigits(123));
    }
}

