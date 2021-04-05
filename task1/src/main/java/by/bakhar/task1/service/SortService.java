package by.bakhar.task1.service;

import by.bakhar.task1.array.DoubleArray;
import by.bakhar.task1.exception.DoubleArrayException;

public interface SortService {
    void bubbleSort(DoubleArray array) throws DoubleArrayException;

    void mergeSort(DoubleArray array) throws DoubleArrayException;

    void selectionSort(DoubleArray array) throws DoubleArrayException;
}
