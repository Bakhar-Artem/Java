package by.bakhar.task1.creator;

import by.bakhar.task1.array.DoubleArray;

public class DoubleArrayCreator {
    public DoubleArray create(double... array){
        DoubleArray doubleArray = new DoubleArray(array);
        return doubleArray;
    }
}
