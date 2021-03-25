package com.bakhar.entity.array;


public class DynArray {
    private int size;
    private int capacity;
    private double[] data;

    public int getSize() {
        return size;
    }

    public DynArray() {
        size = 0;
        capacity = 0;
        data = null;
    }

    public DynArray(int size) {
        this.size = size;
        this.capacity = size;
        data = new double[capacity];
    }

    public void add(double x) {
        if (size == capacity) {
            resize();
        }
        data[size] = x;
        size++;
    }

    public double getAt(int pos) throws DynArrayException {
        if (pos >= size || pos < 0) {
            throw new DynArrayException("Wrong pos!");
        }
        return data[pos];
    }
    
    public void eraseAt(int pos) throws DynArrayException {
        if (size == 0) {
            throw new DynArrayException("No Elements");
        }
        if (pos >= size || pos < 0) {
            throw new DynArrayException("Wrong pos!");
        }
        for (int i = pos; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    private void resize() {
        this.capacity = (this.capacity + 1) * 2;
        double[] tempData = new double[this.capacity];
        for (int i = 0; i < size; i++) {
            tempData[i] = data[i];
        }
        data = tempData;
    }

    public void setAt(int pos, double x) throws DynArrayException {
        if (size == 0 || pos >= size || pos < 0) {
            throw new DynArrayException("Wrong pos");
        }
        data[pos] = x;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]).append(" ");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
