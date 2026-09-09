public class CounterTools {
    private static int calls;
    private int count;

    public void add(int amount) {
        count += amount;
        calls++;
    }

    public int getCount() {
        // TODO
        return 0;
    }

    public static int totalOf(CounterTools item) {
        // TODO: access the supplied object's state.
        return 0;
    }

    public static int getCalls() {
        return calls;
    }

    public static void main(String[] args) {
        CounterTools counter = new CounterTools();
        counter.add(12);
        System.out.println(counter.getCount());
        System.out.println(totalOf(counter));
    }
}

