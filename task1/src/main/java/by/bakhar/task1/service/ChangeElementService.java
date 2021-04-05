package by.bakhar.task1.service;

import by.bakhar.task1.array.DoubleArray;
import by.bakhar.task1.exception.DoubleArrayException;

public interface ChangeElementService {
    void changeElement(DoubleArray doubleArray, int start, int finish, double x) throws DoubleArrayException;
}
