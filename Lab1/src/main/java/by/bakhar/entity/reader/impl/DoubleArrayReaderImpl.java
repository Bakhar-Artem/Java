package by.bakhar.entity.reader.impl;


import by.bakhar.entity.exception.DoubleArrayReaderException;
import by.bakhar.entity.reader.DoubleArrayReader;
import by.bakhar.entity.validator.StringValidator;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DoubleArrayReaderImpl implements DoubleArrayReader {
    private final String FILEPATH = "src/main/resources/data/data.txt";

    @Override
    public List<String> readFromTxt() throws DoubleArrayReaderException {
        List<String> strings = new ArrayList<>();
        try {
            Files.lines(Paths.get(FILEPATH), StandardCharsets.UTF_8).forEach(strings::add);
        } catch (IOException e) {
            throw new DoubleArrayReaderException("Wrong File!");
        }
        return strings;
    }

}
