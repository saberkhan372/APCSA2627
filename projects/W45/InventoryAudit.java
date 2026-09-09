import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InventoryAudit {
    public static int countLowStock(String path, int threshold)
            throws FileNotFoundException {
        Scanner input = new Scanner(new File(path));
        int count = 0;
        // TODO: read name,quantity records and count quantity < threshold.
        input.close();
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("low stock: " + countLowStock("inventory.txt", 10));
    }
}

