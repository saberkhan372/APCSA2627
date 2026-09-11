import java.util.Scanner;

public class PaintPractice {
    public static void main(String[] args) {
        final double COVERAGE = 350.0;
        Scanner input = new Scanner(System.in);
        System.out.print("Length, width, height in feet: ");
        double length = input.nextDouble();
        double width = input.nextDouble();
        double height = input.nextDouble();
        double wallArea = 0.0; // TODO: total area of the four walls
        double gallons = 0.0; // TODO: divide area by coverage
        System.out.println("Wall area: " + wallArea);
        System.out.println("Gallons: " + gallons);
        input.close();
    }
}
