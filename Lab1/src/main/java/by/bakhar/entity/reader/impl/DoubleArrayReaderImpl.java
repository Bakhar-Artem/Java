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
    @Override
    public List<String> readFromTxt(File file) throws DoubleArrayReaderException, IOException {
        if(file==null) {
            throw new DoubleArrayReaderException("Null pointer!");
        }
        List<String> strings=new ArrayList<>();
        Files.lines(Paths.get(String.valueOf(file)), StandardCharsets.UTF_8).forEach(strings::add);
        return strings;
    }
}
