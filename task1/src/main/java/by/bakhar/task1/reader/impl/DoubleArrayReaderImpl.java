package by.bakhar.task1.reader.impl;


import by.bakhar.task1.exception.DoubleArrayReaderException;
import by.bakhar.task1.reader.DoubleArrayReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DoubleArrayReaderImpl implements DoubleArrayReader {
    static Logger logger = LogManager.getLogger();

    @Override
    public List<String> readFromTxt(String filepath) throws DoubleArrayReaderException {
        List<String> strings = new ArrayList<>();
        try {
            Files.lines(Paths.get(filepath), StandardCharsets.UTF_8).forEach(strings::add);
        } catch (IOException e) {
            logger.error(filepath + " is a wrong file!");
            throw new DoubleArrayReaderException("Wrong File!");
        }
        logger.info("file was read!");
        return strings;
    }

}
