package by.bakhar.task1.array;


import by.bakhar.task1.exception.DoubleArrayException;

import java.util.Arrays;

public class DoubleArray {
    private double[] array;

    public DoubleArray(double... array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public DoubleArray(int length) throws DoubleArrayException {
        if (length <= 0) {
            throw new DoubleArrayException("Bad length! " + length);
        }
        array = new double[length];
    }

    public double[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public int getLength() {
        return array.length;
    }

    public void setArray(double[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public double getElement(int index) throws DoubleArrayException {
        if (index >= array.length || index < 0) {
            throw new DoubleArrayException("Out of index! " + index);
        }
        return array[index];
    }


    public void setElement(int index, double x) throws DoubleArrayException {
        if (index >= array.length || index < 0) {
            throw new DoubleArrayException("Out of index! " + index);
        }
        array[index] = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DoubleArray that = (DoubleArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int hash = (25 * Arrays.hashCode(array) + 27) % 101;
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (double v : array) {
            stringBuilder.append(v).append(" ");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
