package by.bakhar.entity.creator;

import by.bakhar.entity.array.DoubleArray;
import by.bakhar.entity.exception.DoubleArrayException;
import by.bakhar.entity.parser.DoubleParser;
import by.bakhar.entity.validator.StringValidator;

public class DoubleArrayCreator {
    public DoubleArray create(String string) throws DoubleArrayException {
        StringValidator validator = new StringValidator();
        if (!validator.isValid(string)) {
            throw new DoubleArrayException("Wrong string, impossible to create!");
        }
        DoubleParser doubleParser = new DoubleParser();
        double[] array = doubleParser.parseToDouble(string);
        DoubleArray doubleArray = new DoubleArray(array);
        return doubleArray;
    }
}
