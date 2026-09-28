public class Initials {
    /**
     * Returns the initials of a two-part name, each followed by a period.
     * Example: initials("Ada Lovelace") returns "A.L."
     *
     * Precondition: fullName contains exactly one space, which separates two
     * non-empty names. There are no spaces at the start or end.
     */
    public static String initials(String fullName) {
        int space = fullName.indexOf(" ");
        return fullName.substring(0, 1) + "." + fullName.substring(space + 1, space + 2) + ".";
    }

    public static void main(String[] args) {
        System.out.println(initials("Ada Lovelace"));
    }
}
