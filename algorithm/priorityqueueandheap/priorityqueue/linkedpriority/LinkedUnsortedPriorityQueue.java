package priorityqueueandheap.priorityqueue.linkedpriority;

import priorityqueueandheap.priorityqueue.Entry;
import priorityqueueandheap.priorityqueue.PriorityQueueInterface;

public class LinkedUnsortedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    private Node<K, E> head;
    private Node<K, E> tail;
    private int size;

    public LinkedUnsortedPriorityQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<K, E> findMinNode() {
        Node<K, E> current = this.head;

        Node<K, E> min = this.head;

        while (current != null) {
            if (current.key.compareTo(min.key) < 0) {
                min = current;
            }

            current = current.next;
        }

        return min;
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
        } else {
            Node<K, E> current = this.head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = (Node<K, E>) entry;
            this.tail = current.next;
        }

        this.size++;
    }

    @Override
    public void insert(K key, E value) {
        Node<K, E> node = new Node<>(key, value);
        this.insert(node);
    }

    @Override
    public Entry<K, E> removeMin() {
        if (this.isEmpty()) {
            return null;
        }

        if (this.head.next == null) {
            Node<K, E> temp = this.head;
            this.head = null;
            this.tail = null;
            this.size--;
            return temp;
        }

        Node<K, E> current = this.head;
        Node<K, E> min = this.findMinNode();

        if (min == this.head) {
            this.head = this.head.next;
            this.size--;
            return min;
        }

        while (current.next != min) {
            current = current.next;
        }

        current.next = current.next.next;
        this.size--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        return this.findMinNode();
    }

    public void print() {
        Node<K, E> current = this.head;

        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }

        System.out.println();
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
