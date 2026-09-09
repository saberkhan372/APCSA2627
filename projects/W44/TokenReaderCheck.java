public class TokenReaderCheck {
    private static int passed, total;
    private static void check(String label, boolean ok) {
        total++;
        if (ok) { passed++; System.out.println("PASS: " + label); }
        else System.out.println("REVISE: " + label);
    }
    public static void main(String[] args) throws Exception {
        java.nio.file.Path many = java.nio.file.Files.createTempFile("tokens", ".txt");
        java.nio.file.Files.writeString(many, "one two\nthree   four");
        check("four tokens", TokenReader.countTokens(many.toString()) == 4);
        java.nio.file.Path empty = java.nio.file.Files.createTempFile("empty", ".txt");
        check("empty file", TokenReader.countTokens(empty.toString()) == 0);
        java.nio.file.Path one = java.nio.file.Files.createTempFile("one", ".txt");
        java.nio.file.Files.writeString(one, "solo");
        check("one token", TokenReader.countTokens(one.toString()) == 1);
        java.nio.file.Path whitespace = java.nio.file.Files.createTempFile("space", ".txt");
        java.nio.file.Files.writeString(whitespace, "  a\t b \n c  ");
        check("mixed whitespace", TokenReader.countTokens(whitespace.toString()) == 3);
        java.nio.file.Files.deleteIfExists(many);
        java.nio.file.Files.deleteIfExists(empty);
        java.nio.file.Files.deleteIfExists(one);
        java.nio.file.Files.deleteIfExists(whitespace);
        check("temporary inputs removed", !java.nio.file.Files.exists(many));
        check("method remains reusable", TokenReader.countTokens(java.nio.file.Files.createTempFile("again", ".txt").toString()) == 0);
        System.out.println(passed + " of " + total + " checks passed");
        if (passed != total) System.exit(1);
    }
}

