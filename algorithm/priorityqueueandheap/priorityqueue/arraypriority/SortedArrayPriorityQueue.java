package priorityqueueandheap.priorityqueue.arraypriority;

import priorityqueueandheap.priorityqueue.Entry;
import priorityqueueandheap.priorityqueue.PriorityQueueInterface;
@SuppressWarnings("unchecked")
public class SortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    final static int DEFAULT_SIZE = 100;
    protected ArrayEntry<K, E>[] arrayEntries;
    protected int size;

    public SortedArrayPriorityQueue() {
        this.arrayEntries = new ArrayEntry[DEFAULT_SIZE];
        this.size = 0;
    }

    protected void enlarge() {
        ArrayEntry<K, E>[] newArrayEntries = new ArrayEntry[arrayEntries.length * 2];
        System.arraycopy(arrayEntries, 0, newArrayEntries, 0, arrayEntries.length);
        arrayEntries = newArrayEntries;
    }

    private void sort() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 1; j < this.size; j++) {
                if (arrayEntries[j].key.compareTo(arrayEntries[j - 1].key) < 0) {
                    ArrayEntry<K, E> temp = arrayEntries[j];
                    arrayEntries[j] = arrayEntries[j - 1];
                    arrayEntries[j - 1] = temp;
                }
            }
        }
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
        insert(entry.getKey(), entry.getValue());
    }

    @Override
    public void insert(K key, E value) {
        if (this.size == this.arrayEntries.length) {
            this.enlarge();
        }

        this.arrayEntries[this.size] = new ArrayEntry<>(key, value);
        this.size++;
        sort();
    }

    @Override
    public Entry<K, E> removeMin() {
        if (this.size == 0) {
            return null;
        }

        ArrayEntry<K, E>[] newArray = new ArrayEntry[this.arrayEntries.length];
        for (int i = 1; i < this.size; i++) {
            newArray[i - 1] = this.arrayEntries[i];
        }

        this.size--;
        Entry<K, E> removedItem = this.arrayEntries[0];
        this.arrayEntries = newArray;
        return removedItem;
    }

    @Override
    public Entry<K, E> min() {
        return this.arrayEntries[0];
    }

    public void print() {
        if (this.size < 1) {
            System.out.println("Empty.");
            return;
        }

        for (int i = 0; i < this.size - 1; i++) {
            System.out.print(this.arrayEntries[i] + ", ");
        }
        System.out.println(this.arrayEntries[this.size - 1]);
        System.out.println("Size: " + this.size);
    }

    protected static class ArrayEntry<K, E> implements Entry<K, E> {
        protected K key;
        protected E value;

        public ArrayEntry(K key, E value) {
            this.key = key;
            this.value = value;
        }

        public ArrayEntry(Entry<K, E> entry) {
            this.key = entry.getKey();
            this.value = entry.getValue();
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
