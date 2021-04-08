package by.bakhar.task1.service.impl;

import by.bakhar.task1.array.DoubleArray;
import by.bakhar.task1.exception.DoubleArrayException;
import by.bakhar.task1.service.FindValueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class FindValueImpl implements FindValueService {
    static Logger logger = LogManager.getLogger();

    @Override
    public double findMax(DoubleArray array) throws DoubleArrayException {
        if (array == null) {
            logger.error("null pointer");
            throw new DoubleArrayException("Null pointer!");
        }
        if (array.getLength() == 0) {
            logger.error("empty array!");
            throw new DoubleArrayException("Array is empty!");
        }
        double[] tempArray = array.getArray();
        double max = tempArray[0];
        for (double value : tempArray) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public double findMaxDoubleStream(DoubleArray array) throws DoubleArrayException {
        if (array == null) {
            logger.error("null pointer");
            throw new DoubleArrayException("Null pointer!");
        }
        if (array.getLength() == 0) {
            logger.error("empty array!");
            throw new DoubleArrayException("Array is empty!");
        }
        double[] tempArray = array.getArray();
        OptionalDouble max = DoubleStream.of(tempArray).max();
        return max.getAsDouble();
    }


    @Override
    public double findMin(DoubleArray array) throws DoubleArrayException {
        if (array == null) {
            logger.error("null pointer");
            throw new DoubleArrayException("Null pointer!");
        }
        if (array.getLength() == 0) {
            logger.error("empty array!");
            throw new DoubleArrayException("Array is empty!");
        }
        double[] tempArray = array.getArray();
        double min = tempArray[0];
        for (double value : tempArray) {
            if (min > value) {
                min = value;
            }
        }
        return min;
    }

    @Override
    public double findMinDoubleStream(DoubleArray array) throws DoubleArrayException {
        if (array == null) {
            logger.error("null pointer");
            throw new DoubleArrayException("Null pointer!");
        }
        if (array.getLength() == 0) {
            logger.error("empty array!");
            throw new DoubleArrayException("Array is empty!");
        }
        double[] tempArray = array.getArray();
        OptionalDouble min = DoubleStream.of(tempArray).min();
        return min.getAsDouble();
    }
}
