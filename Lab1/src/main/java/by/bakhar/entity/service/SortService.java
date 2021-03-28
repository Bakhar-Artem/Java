package by.bakhar.entity.service;

import by.bakhar.entity.array.DoubleArray;
import by.bakhar.entity.exception.DoubleArrayException;

public interface SortService {
    void bubbleSort(DoubleArray array) throws DoubleArrayException;

    void mergeSort(DoubleArray array) throws DoubleArrayException;

    void selectionSort(DoubleArray array) throws DoubleArrayException;
}
