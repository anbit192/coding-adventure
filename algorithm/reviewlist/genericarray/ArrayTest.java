package reviewlist.genericarray;

import java.lang.reflect.Array;

public class ArrayTest<T extends Comparable<T>> {
    private int size;
    private T[] array;

    public ArrayTest(Class<T> dataType) {

        array = (T[]) Array.newInstance(dataType, 10);
    }

    public void set(int index, T data) {
        if (index < size) {
            array[index] = data;
        } else {
            enlarge();
            array[index] = data;
            this.size++;
        }
    }

    public T get(int index) {
        if (index <= size) {
            return array[index];
        }

        return null;
    }

    public void enlarge() {
        T[] newArray = (T[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public int getSize() {
        return size;
    }

    public void append(T data) {
        if (this.size == array.length) {
            enlarge();
        }

        array[size] = data;
        size++;
    }

    public void remove(int index) {
        if (index >= size) {
            return;
        }

        T[] newArray = (T[]) new Object[size - 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = this.array[i];
        }

        for (int i = index + 1; i < size; i++) {
            newArray[i - 1] = array[i];
        }

        this.size--;

        array = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        for (int i = 0; i < this.size; i++) {

            if (i == size - 1) {
                sb.append(array[i]).append(" ]");

            } else {
                sb.append(array[i]).append(", ");

            }
        }

        sb.append("\nSize = ").append(this.size);

        return sb.toString();
    }

    public void bubbleSort() {
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size ; j++) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    T temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public void selectionSort() {
        for (int i = 0; i < this.size - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (this.get(j).compareTo(this.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public void insertionSort() {
        for (int i = 0; i < this.size; i++) {
            T key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

}
