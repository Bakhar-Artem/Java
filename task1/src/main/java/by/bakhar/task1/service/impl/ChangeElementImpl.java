package by.bakhar.task1.service.impl;

import by.bakhar.task1.array.DoubleArray;
import by.bakhar.task1.exception.DoubleArrayException;
import by.bakhar.task1.service.ChangeElementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangeElementImpl implements ChangeElementService {
    static Logger logger = LogManager.getLogger();

    @Override
    public void changeElement(DoubleArray doubleArray, int start, int finish, double x) throws DoubleArrayException {
        if (start < 0 || finish >= doubleArray.getLength() || start > finish) {
            throw new DoubleArrayException("Bad index! " + start + " " + finish);
        }
        for (int i = start; i <= finish; i++) {
            doubleArray.setElement(i, x);
        }
        logger.info("Elements were  changed from " + start + " to " + finish + " on " + x);
    }
}
