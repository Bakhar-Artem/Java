package by.bakhar.task1.reader;

import by.bakhar.task1.exception.DoubleArrayReaderException;

import java.util.List;

public interface DoubleArrayReader {
    List<String> readFromTxt(String filepath) throws DoubleArrayReaderException;
}
