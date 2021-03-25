package test.java;

import com.bakhar.entity.array.DynArray;
import com.bakhar.entity.array.DynArrayException;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "Data")
    public Object[] initParams() throws DynArrayException {
        Object[] arrays = new Object[5];
        DynArray dynArray1 = new DynArray(6);
        for (int i = 0; i < dynArray1.getSize(); i++) {
            dynArray1.setAt(i, 1.);
        }
        arrays[0] = dynArray1;
        DynArray dynArray2 = new DynArray(2);
        for (int i = 0; i < dynArray2.getSize(); i++) {
            dynArray2.setAt(i, i + 2);
        }
        arrays[1] = dynArray2;
        DynArray dynArray3 = new DynArray(6);
        for (int i = 0; i < dynArray3.getSize(); i++) {
            dynArray3.setAt(i, 0);
        }
        arrays[2] = dynArray3;
        DynArray dynArray4 = new DynArray(6);
        for (int i = 0; i < dynArray4.getSize(); i++) {
            dynArray4.setAt(i, i);
        }
        arrays[3] = dynArray4;
        DynArray dynArray5 = new DynArray(6);
        for (int i = 0; i < dynArray5.getSize(); i++) {
            dynArray5.setAt(i, (-1) * i * i - 1);
        }
        arrays[4] = dynArray5;
        return arrays;
    }
}
