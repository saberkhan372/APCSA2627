public class InventoryAuditCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        java.nio.file.Path file = java.nio.file.Files.createTempFile("inventory", ".txt");
        java.nio.file.Files.writeString(file, "pencils,4\npaper,18\nmarkers,7\n");
        check("two below ten", InventoryAudit.countLowStock(file.toString(), 10) == 2);
        check("threshold is exclusive", InventoryAudit.countLowStock(file.toString(), 7) == 1);
        check("all below twenty", InventoryAudit.countLowStock(file.toString(), 20) == 3);
        check("none below zero", InventoryAudit.countLowStock(file.toString(), 0) == 0);
        java.nio.file.Path empty = java.nio.file.Files.createTempFile("inventory-empty", ".txt");
        check("empty input", InventoryAudit.countLowStock(empty.toString(), 10) == 0);
        java.nio.file.Files.writeString(file, "single,5");
        check("single record", InventoryAudit.countLowStock(file.toString(), 6) == 1);
        java.nio.file.Files.deleteIfExists(file);
        java.nio.file.Files.deleteIfExists(empty);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

