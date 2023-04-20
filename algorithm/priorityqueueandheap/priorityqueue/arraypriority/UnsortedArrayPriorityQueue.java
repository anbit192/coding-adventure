package priorityqueueandheap.priorityqueue.arraypriority;

import priorityqueueandheap.priorityqueue.Entry;
import priorityqueueandheap.priorityqueue.PriorityQueueInterface;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    final static int DEFAULT_SIZE = 100;
    protected ArrayEntry<K, E>[] arrayEntries;
    protected int size;

    public UnsortedArrayPriorityQueue() {
        arrayEntries = (ArrayEntry<K, E>[]) new ArrayEntry[DEFAULT_SIZE];
        size = 0;
    }

    private void enlarge() {
        ArrayEntry<K, E>[] newArrayEntries = new ArrayEntry[arrayEntries.length * 2];
        System.arraycopy(arrayEntries, 0, newArrayEntries, 0, arrayEntries.length);
        arrayEntries = newArrayEntries;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (this.size >= this.arrayEntries.length) {
            this.enlarge();
        }

        arrayEntries[this.size] = new ArrayEntry<>(entry);
        this.size++;
    }

    @Override
    public void insert(K key, E value) {
        if (this.size >= this.arrayEntries.length) {
            this.enlarge();
        }

        arrayEntries[this.size] = new ArrayEntry<>(key, value);
        this.size++;
    }

    private int findMinIndex() {

        int minIndex = 0;
        for (int i = 1; i < this.size; i++) {
            if (arrayEntries[i].getKey().compareTo(arrayEntries[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    @Override
    public Entry<K, E> removeMin() {

        int minIndex = findMinIndex();
        Entry<K, E> minEntry = this.min();
        ArrayEntry<K, E>[] newArray = new ArrayEntry[this.arrayEntries.length];

        for (int i = 0; i < minIndex; i++) {
            newArray[i] = arrayEntries[i];
        }

        for (int i = minIndex + 1; i < this.size; i++) {
            newArray[i - 1] = arrayEntries[i];
        }
        this.size--;
        this.arrayEntries = newArray;
        return minEntry;
    }

    @Override
    public Entry<K, E> min() {

        if (this.size == 0) {
            return null;
        }

        int minIndex = findMinIndex();
        Entry<K, E> entry = arrayEntries[minIndex];

        return entry;
    }

    public void print() {
        if (this.size < 1) {
            return;
        }

        for (int i = 0; i < this.size; i++) {
            System.out.println(this.arrayEntries[i]);
        }

    }

    protected static class ArrayEntry<K, E> implements Entry<K, E> {

        K key;
        E value;


        public ArrayEntry(Entry<K, E> entry) {
            this.key = entry.getKey();
            this.value = entry.getValue();
        }

        public ArrayEntry(K key, E value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public E getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return String.format("%s : %s", this.key,this.value);
        }
    }
}
