package by.bsu.bakhar.json_reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface CustomJsonReader {
    List readFromJson(String jsonPath) throws IOException;
}
