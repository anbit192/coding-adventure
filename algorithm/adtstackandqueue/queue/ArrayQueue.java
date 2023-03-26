package adtstackandqueue.queue;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {

    private final int DEFAULT_SIZE = 100;
    private E[] array;
    private int size;

    public ArrayQueue() {
        this.array = (E[]) new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public ArrayQueue(int capacity) {
        this.array = (E[]) new Object[capacity];
        this.size = 0;
    }

    private void enlarge() {
        E[] newArray = (E[]) new Object[this.array.length + 50];

        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;
    }

    @Override
    public void enqueue(E element) {
        if (this.size >= this.array.length) {
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
    public E dequeue() {

        if (this.size < 1) {
            return null;
        }

        E removedItem = this.array[this.size - 1];

        if (this.size == 1) {

            this.array[0] = null;

            this.size--;
            return removedItem;
        }

        E[] newArray = (E[]) new Object[this.array.length];

        for (int i = 0; i < this.size - 1; i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;

        this.size--;

        return removedItem;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        if (this.size < 1) {
            sb.append(" ]\n");

            return sb.toString();
        }

        for (int i = 0; i < this.size; i++) {

            if (i == size - 1) {
                sb.append(array[i]).append(" ]\n");

            } else {
                sb.append(array[i]).append(", ");

            }
        }

        sb.append("\nSize = ").append(this.size);

        return sb.toString();
    }

    class QueueIterator implements Iterator<E> {

        private int currentPos;

        public QueueIterator() {
            this.currentPos = 0;
        }

        @Override
        public boolean hasNext() {
            return this.currentPos < size;
        }

        @Override
        public E next() {

            if (this.hasNext()) {
                return array[this.currentPos++];
            }
            return null;
        }
    }
}
