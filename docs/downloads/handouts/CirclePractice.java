import java.util.Scanner;

public class CirclePractice {
    public static void main(String[] args) {
        final double PI = 3.14159;
        Scanner input = new Scanner(System.in);
        System.out.print("Radius: ");
        double radius = input.nextDouble();
        double area = 0.0; // TODO: replace with PI times radius squared
        double circumference = 0.0; // TODO: replace with 2 times PI times radius
        System.out.println("Area: " + area);
        System.out.println("Circumference: " + circumference);
        input.close();
    }
}
