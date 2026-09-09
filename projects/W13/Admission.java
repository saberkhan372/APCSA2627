public class Admission {
    public static String ticketGroup(int age, boolean student) {
        // TODO: invalid, child, senior, student, or regular.
        return "unfinished";
    }

    public static boolean mayEnter(int age, boolean withAdult, boolean hasPass) {
        // A person may enter when they are at least 16,
        // or when an adult accompanies them and they have a pass.
        return false;
    }

    public static void main(String[] args) {
        System.out.println(ticketGroup(14, true));
        System.out.println(mayEnter(14, true, true));
    }
}
