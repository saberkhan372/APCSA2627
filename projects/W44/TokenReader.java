import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TokenReader {
    public static int countTokens(String path) throws FileNotFoundException {
        Scanner input = new Scanner(new File(path));
        // TODO: guard next() with hasNext() and count every token.
        input.close();
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(countTokens("tokens.txt"));
    }
}

