package by.bakhar.entity.reader;

import by.bakhar.entity.exception.DoubleArrayReaderException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface DoubleArrayReader {
    List<String> readFromTxt(File file) throws DoubleArrayReaderException, IOException;
}
