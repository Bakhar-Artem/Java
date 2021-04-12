package by.bakhar.task3.reader;

import by.bakhar.task3.exception.ConeException;
import by.bakhar.task3.validation.ConeStringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConeReader {
    private static Logger logger = LogManager.getLogger();

    public List<String> readConeFromFile(String filepath) throws ConeException {

        List<String> cones = new ArrayList<>();
        try {
            Files.lines(Paths.get(filepath), StandardCharsets.UTF_8).filter(ConeStringValidator::isStringValid).forEach(cones::add);
        } catch (IOException e) {
            logger.error("Wrong filepath " + filepath);
            throw new ConeException("Wrong filepath " + filepath);
        }
        return cones;
    }
}
