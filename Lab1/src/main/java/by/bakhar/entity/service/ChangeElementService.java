package by.bakhar.entity.service;

import by.bakhar.entity.array.DoubleArray;
import by.bakhar.entity.exception.DoubleArrayException;

public interface ChangeElementService {
    void changeElement(DoubleArray doubleArray, int start, int finish, double x) throws DoubleArrayException;
}
