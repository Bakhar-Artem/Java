package by.bakhar.entity.service.impl;

import by.bakhar.entity.array.DoubleArray;
import by.bakhar.entity.exception.DoubleArrayException;
import by.bakhar.entity.service.CountNumberService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class CountNumberImpl implements CountNumberService {
    static Logger logger = LogManager.getLogger();

    @Override
    public double countSum(DoubleArray array) throws DoubleArrayException {
        if (array == null || array.getLength() == 0) {
            throw new DoubleArrayException("Array is empty!");
        }
        double sum = 0;
        for (double value : array.getArray()) {
            sum += value;
        }
        logger.info("Sum is " + sum);
        return sum;
    }

    @Override
    public double countSumDoubleStream(DoubleArray array) throws DoubleArrayException {
        if (array == null || array.getLength() == 0) {
            throw new DoubleArrayException("Array is empty!");
        }
        double sum = DoubleStream.of(array.getArray()).sum();
        logger.info("Sum by DoubleStream is " + sum);
        return sum;
    }

    @Override
    public long countPositiveDoubleStream(DoubleArray array, int start, int finish) throws DoubleArrayException {
        if (array == null || array.getLength() == 0) {
            throw new DoubleArrayException("Array is empty!");
        }
        long counter = DoubleStream.of(array.getArray()).filter(x -> x > 0.).count();
        logger.info("Number of positive is " + counter);
        return counter;
    }

    @Override
    public long countNegativeDoubleStream(DoubleArray array, int start, int finish) throws DoubleArrayException {
        if (array == null || array.getLength() == 0) {
            throw new DoubleArrayException("Array is empty!");
        }
        long counter = DoubleStream.of(array.getArray()).filter(x -> x < 0.).count();
        logger.info("Number of negative is " + counter);
        return counter;
    }

    @Override
    public double countAverageDoubleStream(DoubleArray array) throws DoubleArrayException {
        if (array == null || array.getLength() == 0) {
            throw new DoubleArrayException("Array is empty!");
        }
        OptionalDouble average = DoubleStream.of(array.getArray()).average();
        double averageOfArray = average.getAsDouble();
        logger.info("Average is " + averageOfArray);
        return averageOfArray;
    }

    @Override
    public int countPositive(DoubleArray array, int start, int finish) throws DoubleArrayException {
        if (array == null || array.getLength() == 0) {
            throw new DoubleArrayException("Array is empty!");
        }
        if (start < 0 || finish >= array.getLength() || start > finish) {
            throw new DoubleArrayException("Bad index!");
        }
        double[] tempArray = array.getArray();
        int counter = 0;
        for (double value : tempArray) {
            if (value > 0.) {
                counter++;
            }
        }
        logger.info("Number of positive is " + counter);
        return counter;
    }

    @Override
    public int countNegative(DoubleArray array, int start, int finish) throws DoubleArrayException {
        if (array == null || array.getLength() == 0) {
            throw new DoubleArrayException("Array is empty!");
        }
        if (start < 0 || finish >= array.getLength() || start > finish) {
            throw new DoubleArrayException("Bad index!");
        }
        double[] tempArray = array.getArray();
        int counter = 0;
        for (double value : tempArray) {
            if (value < 0.) {
                counter++;
            }
        }
        logger.info("Number of negative is " + counter);
        return counter;
    }

    @Override
    public double countAverage(DoubleArray array) throws DoubleArrayException {
        if (array == null || array.getLength() == 0) {
            throw new DoubleArrayException("Array is empty!");
        }
        double sum = countSum(array);
        logger.info("Average is " + sum);
        return sum / array.getLength();
    }

}
