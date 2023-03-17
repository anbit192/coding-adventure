package adtstack.stack;

import java.util.Iterator;

public class ListStack<E> implements StackInterface<E> {

    private final int DEFAULT_SIZE = 100;

    private int size;
    private E[] array;

    public ListStack() {
        this.array = (E[]) new Object[DEFAULT_SIZE];
    }

    public ListStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public void push(E element) {

        if (this.size >= array.length) {
            this.enlarge();
        }

        E[] newArray = (E[]) new Object[this.array.length];


        newArray[0] = element;

        for (int i = 0; i < this.size; i++) {
            newArray[i + 1] = this.array[i];
        }

        this.array = newArray;
        this.size++;
    }

    @Override
    public E pop() {

        if (this.size < 1) {
            return null;
        }

        E[] newArray = (E[]) new Object[this.array.length];

        for (int i = 1; i < this.size; i++) {
            newArray[i - 1] = this.array[i];
        }

        E removedElement = this.array[0];
        this.array = newArray;
        this.size--;
        return removedElement;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public E top() {
        if (this.size < 1) {
            return null;
        }
        return this.array[0];
    }

    private void enlarge() {
        E[] newArray = (E[]) new Object[array.length + 20];

        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        if (this.size < 1) {
            sb.append(" ]");

            return sb.toString();
        }

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

    public class StackIterator implements Iterator<E> {

        private int currentPos;

        public StackIterator() {
            this.currentPos = 0;
        }

        @Override
        public boolean hasNext() {
            return this.currentPos < size();
        }

        @Override
        public E next() {
            if (this.hasNext()) {
                return array[currentPos++];
            }
            return null;
        }
    }
}
