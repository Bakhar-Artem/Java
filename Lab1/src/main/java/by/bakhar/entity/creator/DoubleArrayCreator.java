package by.bakhar.entity.creator;

import by.bakhar.entity.array.DoubleArray;
import by.bakhar.entity.exception.DoubleArrayException;
import by.bakhar.entity.validator.StringValidator;

public class DoubleArrayCreator {
    public DoubleArray createFromString(String string) throws DoubleArrayException {
        StringValidator validator = new StringValidator();
        if (!validator.IsValid(string)) {
            throw new DoubleArrayException("Wrong string, impossible to create!");
        }
        String[] values = string.split(",");
        double[] array = new double[values.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(values[i]);
        }
        DoubleArray doubleArray = new DoubleArray(array);
        return doubleArray;
    }
}
