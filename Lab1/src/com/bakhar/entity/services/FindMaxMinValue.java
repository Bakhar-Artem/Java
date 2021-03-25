package com.bakhar.entity.services;

import com.bakhar.entity.array.DynArray;
import com.bakhar.entity.array.DynArrayException;

public class FindMaxMinValue {
    public static double findMax(DynArray array) throws DynArrayException {
        double max = array.getAt(0);
        for (int i = 1; i < array.getSize(); i++) {
            if (array.getAt(i) > max) {
                max = array.getAt(1);
            }
        }
        return max;
    }

    public static double findMin(DynArray array) throws DynArrayException {
        double min = array.getAt(0);
        for (int i = 1; i < array.getSize(); i++) {
            if (min > array.getAt(i)) {
                min = array.getAt(i);
            }
        }
        return min;
    }
}
