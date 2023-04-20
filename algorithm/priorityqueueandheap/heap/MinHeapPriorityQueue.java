package priorityqueueandheap.heap;

import priorityqueueandheap.priorityqueue.Entry;
import priorityqueueandheap.priorityqueue.arraypriority.SortedArrayPriorityQueue;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {

    public MinHeapPriorityQueue() {
        super();
    }

    public int getParentIndex(int childIndex) {
        if (childIndex < 0 || childIndex >= this.arrayEntries.length) {
            return -1;
        }

        if (childIndex == 0) {
            return 0;
        }

        if (childIndex % 2 == 0) {
            return childIndex / 2 - 1;
        } else {
            return childIndex / 2;
        }
    }

    public int getLeftIndex(int parentIndex) {
        if (parentIndex < 0 || parentIndex >= this.arrayEntries.length) {
            return -1;
        }

        return parentIndex * 2 + 1;
    }

    public int getRightIndex(int parentIndex) {
        if (parentIndex < 0 || parentIndex >= this.arrayEntries.length) {
            return -1;
        }

        return parentIndex * 2 + 2;
    }

    protected void upHeap() {
        if (this.size <= 1) {
            return;
        }
        int index = this.size() - 1;
        int parentIndex = this.getParentIndex(index);

        while (this.arrayEntries[index].getKey().compareTo(this.arrayEntries[parentIndex].getKey()) < 0 && index > 0) {
            ArrayEntry<K, E> temp = this.arrayEntries[index];
            this.arrayEntries[index] = this.arrayEntries[parentIndex];
            this.arrayEntries[parentIndex] = temp;

            index = parentIndex;
            parentIndex = this.getParentIndex(parentIndex);
        }
    }

    @Override
    public void insert(K key, E value) {
        if (this.size >= this.arrayEntries.length) {
            this.enlarge();
        }

        this.arrayEntries[this.size] = new ArrayEntry<>(key, value);
        this.size++;

        this.upHeap();
    }

    @Override
    public void insert(Entry<K, E> entry) {
        insert(entry.getKey(), entry.getValue());
    }

    @Override
    public Entry<K, E> removeMin() {
        if (this.size == 0) {
            return null;
        }

        Entry<K, E> removedEntry = this.arrayEntries[0];

        this.arrayEntries[0] = this.arrayEntries[this.size - 1];
        this.arrayEntries[this.size - 1] = null;
        this.size--;

        this.downHeap();

        return removedEntry;
    }

    private int getMin(int index1, int index2) {
        if (arrayEntries[index1].getKey().compareTo(arrayEntries[index2].getKey()) < 0
                || (arrayEntries[index1] != null && arrayEntries[index2] == null)) {
            return index1;
        } else if (arrayEntries[index1] == null && arrayEntries[index2] == null) {
            return -1;
        }

        return index2;
    }

    public int numChildren(int parentIndex) {
        int leftIndex = parentIndex * 2 + 1;
        int rightIndex = parentIndex * 2 + 2;

        if (arrayEntries[leftIndex] != null && arrayEntries[rightIndex] != null) {
            return 2;
        } else if (arrayEntries[leftIndex] == null && arrayEntries[rightIndex] == null) {
            return 0;
        }

        return 1;
    }

    protected void downHeap() {

        int index = 0;
        int leftIndex = this.getLeftIndex(index);
        int rightIndex = this.getRightIndex(index);

        while (index < this.size) {
            if (this.numChildren(index) == 2) {
                if (arrayEntries[index].getKey().compareTo(arrayEntries[leftIndex].getKey()) > 0 ||
                        arrayEntries[index].getKey().compareTo(arrayEntries[rightIndex].getKey()) > 0) {

                    int minIndex = this.getMin(leftIndex, rightIndex);
                    ArrayEntry<K, E> temp = this.arrayEntries[index];
                    this.arrayEntries[index] = this.arrayEntries[minIndex];
                    this.arrayEntries[minIndex] = temp;

                    index = minIndex;
                    leftIndex = this.getLeftIndex(index);
                    rightIndex = this.getRightIndex(index);
                }

            } else if (numChildren(index) == 1) { // always left child due to the property of complete binary tree

                if (arrayEntries[index].getKey().compareTo(arrayEntries[leftIndex].getKey()) > 0) {
                    ArrayEntry<K, E> temp = this.arrayEntries[index];
                    this.arrayEntries[index] = this.arrayEntries[leftIndex];
                    this.arrayEntries[leftIndex] = temp;

                } else {
                    break;
                }

            } else { // num child = 0 => reach the leaf node
                break;
            }
        }
    }

}
