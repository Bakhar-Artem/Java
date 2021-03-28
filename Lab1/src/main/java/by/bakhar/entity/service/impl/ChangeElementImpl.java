package by.bakhar.entity.service.impl;

import by.bakhar.entity.array.DoubleArray;
import by.bakhar.entity.exception.DoubleArrayException;
import by.bakhar.entity.service.ChangeElementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangeElementImpl implements ChangeElementService {
    static Logger logger= LogManager.getLogger();
    @Override
    public void changeElement(DoubleArray doubleArray, int start, int finish, double x) throws DoubleArrayException {
        if (start < 0 || finish >= doubleArray.getLength() || start > finish) {
            throw new DoubleArrayException("Bad index!");
        }
        for (int i = start; i <= finish; i++) {
            doubleArray.setAt(i, x);
        }
        logger.info("Elements were changed to "+x);
    }
}
