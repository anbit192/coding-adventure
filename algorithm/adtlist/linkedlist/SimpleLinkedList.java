package adtlist.linkedlist;

import java.util.NoSuchElementException;

public class SimpleLinkedList<E> {

    private Node head;
    private Node bot;
    private int size;

    public SimpleLinkedList() {
        this.head = null;
        this.bot = null;
        this.size = 0;
    }

    public void add(E data, int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (this.head == null) {
            this.head = new Node(data, null);
            this.bot = this.head;
        } else if (index == 0) {
            this.head = new Node(data, this.head);
        } else if (index == this.size) {
            Node temp = this.getNode(index - 1);
            temp.next = new Node(data, null);
            this.bot = temp.next;
        } else {
            Node currentNode = getNode(index - 1);
            currentNode.next = new Node(data, currentNode.next.next);
        }

        this.size++;
    }

    public void addTop(E data) {
        this.add(data, 0);
    }

    public void addBot(E data) {
        this.add(data, this.size);
    }

    public void removeIndex(int index) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }

        if (this.head == null) {
            throw new NoSuchElementException();
        } else if (index == 0) {
            this.head = this.head.next;
        } else if (this.size == 1) {
            this.head = null;
            this.bot = null;
        } else if (index == this.size - 1) {
            Node temp = this.getNode(index - 1);
            temp.next = null;
            this.bot = temp;
        } else {
            Node temp = this.getNode(index - 1);
            temp.next = temp.next.next;
        }

        this.size--;
    }

    public void removeTop() {
        this.removeIndex(0);
    }

    public void removeBot() {
        this.removeIndex(this.size - 1);

    }

    public boolean isContain(E data) {
        for (int i = 0; i < this.size; i++) {
            if (this.get(i).equals(data)) {
                return true;
            }
        }

        return false;
    }

    public void remove(E data) {

        for (int i = 0; i < this.size; i++) {
            if (this.get(i).equals(data)) {
                if (i == 0) {
                    this.removeTop();
                    i--;
                } else if (i == this.size - 1) {
                    this.removeBot();
                } else {
                    this.removeIndex(i);
                    i--;
                }
            }
        }
    }


    public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println("size: " + this.size);
    }

    public Node getNode(int index) {

        if (!isValidIndex(index)) {
            throw new NoSuchElementException();
        }

        Node temp = this.head;

        for (int i = 0; i <= index - 1; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public E get(int index) {
        if (!isValidIndex(index)) {
            throw new NoSuchElementException();
        }

        return this.getNode(index).data;
    }

    private boolean isValidIndex(int index) {
        return (index >= 0 && index < this.size);
    }


    class Node {
        E data;
        Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}