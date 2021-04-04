package by.bakhar.task1.parser;

import by.bakhar.task1.exception.DoubleArrayException;

public class DoubleArrayParser {
    private final static String REGEX = ",";

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
            throw new DoubleArrayException("Parsing impossible! " + data);
        }
        return array;
    }
}
