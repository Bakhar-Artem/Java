package by.bakhar.task1.service.impl;

import by.bakhar.task1.array.DoubleArray;
import by.bakhar.task1.exception.DoubleArrayException;
import by.bakhar.task1.service.SortService;

public class SortImpl implements SortService {
    @Override
    public void bubbleSort(DoubleArray array) throws DoubleArrayException {
        if (array == null) {
            throw new DoubleArrayException("Null pointer!");
        }
        if (array.getLength() > 1) {
            boolean flag = true;
            double[] tempArray = array.getArray();
            while (flag) {
                flag = false;
                for (int i = 1; i < tempArray.length; i++) {
                    if (tempArray[i] < tempArray[i - 1]) {
                        swapElement(tempArray, i, i - 1);
                        flag = true;
                    }
                }
            }
            array.setArray(tempArray);
        }
    }

    private void swapElement(double[] array, int first, int second) {
        double temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    @Override
    public void mergeSort(DoubleArray array) throws DoubleArrayException {
        if (array == null) {
            throw new DoubleArrayException("Null pointer!");
        }
        if (array.getLength() > 1) {
            double[] tempArray = array.getArray();
            mergeSortHelper(tempArray,0,tempArray.length-1);
            array.setArray(tempArray);
        }
    }

    private void mergeSortHelper(double[] array, int left, int right) {
        int middle = left + ((right - left) / 2) + 1;
        if (middle > 0 && right > (left + 1)) {
            mergeSortHelper(array, left, middle - 1);
            mergeSortHelper(array, middle, right);
        }
        double[] temp = new double[right - left + 1];
        int pos = left;
        for (int i = 0; i < temp.length; i++) {
            if (middle > right || array[pos] > array[pos]) {
                temp[i] = array[pos];
                pos++;
            } else {
                temp[i] = array[middle];
                middle++;
            }
        }
        System.arraycopy(temp, 0, array, left, temp.length);
    }

    @Override
    public void selectionSort(DoubleArray array) throws DoubleArrayException {
        if (array == null) {
            throw new DoubleArrayException("Null pointer!");
        }
        if (array.getLength() > 1) {
            double[] tempArray = array.getArray();
            for (int i = 0; i < tempArray.length; i++) {
                int min = i;
                for (int k = i; k < tempArray.length; k++) {
                    if (tempArray[k] < tempArray[min]) {
                        min = k;
                    }
                }
                swapElement(tempArray, i, min);
            }
            array.setArray(tempArray);
        }
    }
}
