package review4.list;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {

    private final int DEFAULT_SIZE = 100;
    private T[] array;
    private int size;


    public SimpleArrayList() {
        this.array = (T[]) new Object[DEFAULT_SIZE];
    }

    public SimpleArrayList(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    private void enlarge() {
        T[] newArray = (T[]) new Object[array.length * 2];

        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;
    }

    @Override
    public void add(T data) {
        // TODO Auto-generated method stub
        if (size >= this.array.length) {
            this.enlarge();
        }

        this.array[size] = data;
        size++;

    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        if (index >= size) {
            return null;
        }
        return this.array[index];
    }

    @Override
    public boolean isContain(T data) {
        // TODO Auto-generated method stub
        for (int i = 0; i < size; i++) {
            if (this.array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return this.size == 0;
    }

    private int findIndex(T data) {

        for (int i = 0; i < this.size; i++) {
            if (this.array[i].equals(data)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void remove(T data) {
        // TODO Auto-generated method stub
        if (!this.isContain(data) || this.size <= 0) {
            return;
        }

        T[] newArray = (T[]) new Object[this.array.length];

        int index = this.findIndex(data);

        for (int i = 0; i < index; i++) {
            newArray[i] = this.array[i];
        }

        for (int j = index + 1; j < this.size; j++) {
            newArray[j - 1] = this.array[j];
        }

        this.size--;

        this.array = newArray;

    }

    @Override
    public void set(int index, T data) {
        // TODO Auto-generated method stub
        if (index >= size) {
            return;
        }

        this.array[index] = data;

    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new SimpleIterator();
    }

    public class SimpleIterator implements Iterator<T> {

        private int currentPos = 0;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return currentPos < size;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub

            if (currentPos < size) {
                return array[currentPos++];
            }

            return null;
        }
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


}