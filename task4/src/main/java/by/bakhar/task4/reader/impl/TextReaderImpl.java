package by.bakhar.task4.reader.impl;

import by.bakhar.task4.reader.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextReaderImpl implements TextReader {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String readTextFromTxt(String filepath) throws IOException {
        String contents = Files.readString(Path.of(filepath));
        logger.info("Text was read!");
        return contents;
    }
}
