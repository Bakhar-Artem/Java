import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reader {
    public static String read() throws IOException {
        String path = "resources\\text.txt";
        String contents = Files.readString(Path.of(path));
        return contents;
    }
}
