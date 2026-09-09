import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeatherData {
    public static double averageFor(String path, String target)
            throws FileNotFoundException {
        Scanner input = new Scanner(new File(path));
        double total = 0.0;
        int count = 0;
        // TODO: parse station,date,value records and average matches.
        input.close();
        return 0.0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(averageFor("weather.txt", "SEA"));
    }
}

