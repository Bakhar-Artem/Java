package by.bakhar.entity.service;

import by.bakhar.entity.array.DoubleArray;
import by.bakhar.entity.exception.DoubleArrayException;

public interface CountNumberService {
    double countSum(DoubleArray array) throws DoubleArrayException;

    double countSumDoubleStream(DoubleArray array) throws DoubleArrayException;

    int countPositive(DoubleArray array) throws DoubleArrayException;

    long countPositiveDoubleStream(DoubleArray array) throws DoubleArrayException;

    int countNegative(DoubleArray array) throws DoubleArrayException;

    long countNegativeDoubleStream(DoubleArray array) throws DoubleArrayException;

    double countAverage(DoubleArray array) throws DoubleArrayException;

    double countAverageDoubleStream(DoubleArray array) throws DoubleArrayException;
}
