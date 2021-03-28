package by.bakhar.entity.service.impl;

import by.bakhar.entity.array.DoubleArray;
import by.bakhar.entity.exception.DoubleArrayException;
import by.bakhar.entity.service.FindValueService;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class FindValueImpl implements FindValueService {
    @Override
    public double findMax(DoubleArray array) throws DoubleArrayException {
        if (array == null || array.getLength() == 0) {
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
        if (array == null || array.getLength() == 0) {
            throw new DoubleArrayException("Array is empty!");
        }
        double[] tempArray = array.getArray();
        OptionalDouble max = DoubleStream.of(tempArray).max();
        return max.getAsDouble();
    }


    @Override
    public double findMin(DoubleArray array) throws DoubleArrayException {
        if (array == null || array.getLength() == 0) {
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
        if (array == null || array.getLength() == 0) {
            throw new DoubleArrayException("Array is empty!");
        }
        double[] tempArray = array.getArray();
        OptionalDouble min = DoubleStream.of(tempArray).min();
        return min.getAsDouble();
    }
}
