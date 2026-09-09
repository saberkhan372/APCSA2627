public class WeatherDataCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        java.nio.file.Path file = java.nio.file.Files.createTempFile("weather", ".txt");
        java.nio.file.Files.writeString(file, "SEA,d1,48.0\nLAX,d1,70.0\nSEA,d2,52.0\n");
        check("filtered average", Math.abs(WeatherData.averageFor(file.toString(), "SEA") - 50.0) < 0.0001);
        check("single station row", Math.abs(WeatherData.averageFor(file.toString(), "LAX") - 70.0) < 0.0001);
        check("no match contract", WeatherData.averageFor(file.toString(), "NYC") == 0.0);
        java.nio.file.Files.writeString(file, "A,d1,-2.5\nA,d2,2.5");
        check("negative decimal values", WeatherData.averageFor(file.toString(), "A") == 0.0);
        java.nio.file.Files.writeString(file, "A,d1,1.5\nB,d1,100.0\nA,d2,2.5");
        check("other rows excluded", WeatherData.averageFor(file.toString(), "A") == 2.0);
        java.nio.file.Path empty = java.nio.file.Files.createTempFile("weather-empty", ".txt");
        check("empty file", WeatherData.averageFor(empty.toString(), "A") == 0.0);
        java.nio.file.Files.deleteIfExists(file);
        java.nio.file.Files.deleteIfExists(empty);
        check("temporary input removed", !java.nio.file.Files.exists(file));
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

