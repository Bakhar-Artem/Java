package com.bakhar.entity.services;

import com.bakhar.entity.array.DynArray;
import com.bakhar.entity.array.DynArrayException;

public class CountNumber {
    public static double countSum(DynArray array) throws DynArrayException {
        double sum = 0;
        for (int i = 0; i < array.getSize(); i++) {
            sum += array.getAt(i);
        }
        return sum;
    }

    public static int countPositive(DynArray array) throws DynArrayException {
        int counter = 0;
        for (int i = 0; i < array.getSize(); i++) {
            if (array.getAt(i) > 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int countNegative(DynArray array) throws DynArrayException {
        int counter = 0;
        for (int i = 0; i < array.getSize(); i++) {
            if (array.getAt(i) < 0) {
                counter++;
            }
        }
        return counter;
    }

    public static double countAverage(DynArray array) throws DynArrayException {
        if (array.getSize() == 0) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < array.getSize(); i++) {
            sum += array.getAt(i);
        }
        return sum / array.getSize();
    }
}
