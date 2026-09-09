public class BooleanLab {
    public static boolean mayAccess(boolean hasBadge, boolean isStaff, boolean lockedDown) {
        // Access requires a badge or staff status, and the building must not be locked down.
        return false;
    }

    public static boolean deMorganMatches(boolean a, boolean b) {
        // Return whether !(a && b) and (!a || !b) have the same value.
        return false;
    }

    public static void main(String[] args) {
        System.out.println(mayAccess(true, false, false));
        System.out.println(deMorganMatches(true, false));
    }
}
