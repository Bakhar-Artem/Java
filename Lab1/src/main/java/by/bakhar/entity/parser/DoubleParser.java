package by.bakhar.entity.parser;

import by.bakhar.entity.exception.DoubleArrayException;

public class DoubleParser {
    public double[] parseToDouble(String data) throws DoubleArrayException {
        String[] values = data.split(",");
        double[] array = new double[values.length];
        double value;
        try {
            for (int i = 0; i < array.length; i++) {
                value = Double.parseDouble(values[i]);
                array[i] = value;
            }
        } catch (NumberFormatException e) {
            throw new DoubleArrayException("Parsing impossible!");
        }
        return array;
    }
}
