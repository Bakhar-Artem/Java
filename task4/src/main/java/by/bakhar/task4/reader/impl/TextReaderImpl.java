package by.bakhar.task4.reader.impl;

import by.bakhar.task4.reader.TextReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextReaderImpl implements TextReader {
    @Override
    public String readTextFromTxt(String filepath) throws IOException {
        String contents = Files.readString(Path.of(filepath));
        return contents;
    }
}
