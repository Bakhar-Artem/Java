package by.bakhar.task1.service;

import by.bakhar.task1.array.DoubleArray;
import by.bakhar.task1.exception.DoubleArrayException;

public interface FindValueService {
    double findMax(DoubleArray array) throws DoubleArrayException;

    double findMaxDoubleStream(DoubleArray array) throws DoubleArrayException;

    double findMin(DoubleArray array) throws DoubleArrayException;

    double findMinDoubleStream(DoubleArray array) throws DoubleArrayException;
}
