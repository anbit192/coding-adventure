package oop.mylist;

import java.util.Objects;

public class MyArrayList extends MyAbstractList {

    static final int INITIAL_SIZE = 16;
    Object[] elements;
    int size;

    public MyArrayList() {
        elements = new Object[INITIAL_SIZE];
    }

    private static boolean contain(Object value, Object[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }

        return false;
    }

    void enlarge() {
        Object[] newArray = new Object[elements.length * 2];
        System.arraycopy(this.elements, 0, newArray, 0, this.elements.length);

        this.elements = newArray;
    }

    @Override
    public void add(Object o) {
        if (this.size() >= this.elements.length) {
            enlarge();
        }
        this.add(o, this.size());
    }

    @Override
    public void add(Object o, int index) {
        if (this.size() >= this.elements.length || index >= this.elements.length) {
            enlarge();
        }

        this.size++;

        Object[] newArray = new Object[this.elements.length];

        for (int i = 0; i < this.elements.length; i++) {
            if (i < index) {
                newArray[i] = this.elements[i];
            } else if (i > index) {
                newArray[i] = this.elements[i - 1];
            } else {
                newArray[index] = o;
            }
        }

        this.elements = newArray;
    }

    @Override
    public Object get(int index) {
        return this.elements[index];
    }

    @Override
    public void remove(int index) {

        if (!checkBoundaries(index, this.size()) || !contain(this.elements[index], this.elements)) {
            return;
        }

        Object[] newArray = new Object[this.elements.length - 1];
        for (int i = 0; i < this.elements.length; i++) {
            if (i < index) {
                newArray[i] = this.elements[i];
            } else if (i > index) {
                newArray[i - 1] = this.elements[i];
            }
        }

        this.elements = newArray;
        this.size--;
    }

    @Override
    public int size() {
        return this.size;
    }
}
