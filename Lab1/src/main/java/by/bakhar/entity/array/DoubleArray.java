package by.bakhar.entity.array;


import by.bakhar.entity.exception.DoubleArrayException;

import java.util.Arrays;

public class DoubleArray {
    private double[] array;

    public int getLength() {
        return array.length;
    }


    public DoubleArray(double... array) {
        this.array = array;
    }

    public DoubleArray() {
        array = new double[0];
    }

    public double[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(double[] array) {
        this.array = array;
    }

    public DoubleArray(int length) {
        array = new double[length];
    }

    public double getAt(int index) throws DoubleArrayException {
        if (index >= array.length || index < 0) {
            throw new DoubleArrayException("Out of index!");
        }
        return array[index];
    }


    public void setAt(int index, double x) throws DoubleArrayException {
        if (index >= array.length || index < 0) {
            throw new DoubleArrayException("Out of index!");
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
