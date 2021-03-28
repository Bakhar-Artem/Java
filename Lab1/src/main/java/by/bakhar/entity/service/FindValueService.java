package by.bakhar.entity.service;

import by.bakhar.entity.array.DoubleArray;
import by.bakhar.entity.exception.DoubleArrayException;

public interface FindValueService {
    double findMax(DoubleArray array) throws DoubleArrayException;

    double findMaxDoubleStream(DoubleArray array) throws DoubleArrayException;

    double findMin(DoubleArray array) throws DoubleArrayException;

    double findMinDoubleStream(DoubleArray array) throws DoubleArrayException;
}
