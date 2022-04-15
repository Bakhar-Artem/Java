package by.bsu.bakhar.json_writer;

import java.io.IOException;
import java.util.List;

public interface CustomJsonWriter<T> {
    void writeJson(List<T> list, String jsonPath) throws IOException;
}
