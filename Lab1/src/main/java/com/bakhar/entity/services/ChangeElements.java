package com.bakhar.entity.services;

import com.bakhar.entity.array.DynArray;
import com.bakhar.entity.exception.DynArrayException;

public class ChangeElements {
    public static void changeElements(DynArray array, int start, int finish, double value) throws DynArrayException {
        if (start > finish || start < 0 || finish >= array.getSize()){
            throw new DynArrayException("impossible to change elements");
        }
        for (int i = start; i < finish; i++) {
            array.setAt(i,value);
        }
    }
}
