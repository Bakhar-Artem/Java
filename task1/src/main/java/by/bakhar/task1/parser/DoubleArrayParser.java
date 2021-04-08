package by.bakhar.task1.parser;

import by.bakhar.task1.exception.DoubleArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DoubleArrayParser {
    private final static String REGEX = ",";
    static Logger logger = LogManager.getLogger();

    public double[] parseToDouble(String data) throws DoubleArrayException {
        String[] values = data.split(REGEX);
        double[] array = new double[values.length];
        double value;
        try {
            for (int i = 0; i < array.length; i++) {
                value = Double.parseDouble(values[i]);
                array[i] = value;
            }
        } catch (NumberFormatException e) {
            logger.error("parsing impossible" + data);
            throw new DoubleArrayException("Parsing impossible! " + data);
        }
        return array;
    }
}
