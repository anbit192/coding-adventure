package priorityqueueandheap.priorityqueue.linkedpriority;

import priorityqueueandheap.priorityqueue.Entry;
import priorityqueueandheap.priorityqueue.PriorityQueueInterface;

public class LinkedSortedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    private Node<K, E> head;
    private Node<K, E> tail;
    private int size;

    public LinkedSortedPriorityQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    public void print() {
        Node<K, E> current = this.head;

        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }

        System.out.println();
    }

    private void sort() {

        Node<K, E> current = this.head;
        Node<K, E> indexNode = this.head;

        while (current != null) {
            indexNode = current.next;

            while (indexNode != null) {
                if (indexNode.key.compareTo(current.key) < 0) {
                    K temp = indexNode.key;
                    indexNode.key = current.key;
                    current.key = temp;

                    E tempValue = indexNode.value;
                    indexNode.value = current.value;
                    current.value = tempValue;

                }

                indexNode = indexNode.next;
            }

            current = current.next;
        }
    }

    public Node<K, E> getNode(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }

        Node<K, E> current = this.head;
        for (int i = 0; i < this.size; i++) {
            current = current.next;
        }

        return current;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public void insert(Entry<K, E> entry) {

        if (this.head == null) {
            this.head = (Node<K, E>) entry;
            this.tail = this.head;
            this.size++;
            return;
        }

        Node<K, E> current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        Node<K, E> newNode = (Node<K, E>) entry;
        current.next = newNode;
        this.size++;
        this.sort();
        this.tail = this.getNode(this.size - 1);
    }

    @Override
    public void insert(K key, E value) {
        this.insert(new Node<>(key, value));
    }

    @Override
    public Entry<K, E> removeMin() {
        if (this.head == null) {
            return null;
        }

        Node<K,E> current = this.head;
        this.head = this.head.next;

        return current;
    }

    @Override
    public Entry<K, E> min() {
        return this.head;
    }

    static class Node<K, E> implements Entry<K, E> {

        K key;
        E value;
        Node<K, E> next;

        public Node(K key, E value, Node<K, E> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(Entry<K, E> entry) {
            this.key = entry.getKey();
            this.value = entry.getValue();
            this.next = null;
        }

        public Node(K key, E value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public E getValue() {
            return null;
        }

        @Override
        public String toString() {
            return String.format("(key=%s, value=%s)", this.key, this.value);
        }
    }
}
