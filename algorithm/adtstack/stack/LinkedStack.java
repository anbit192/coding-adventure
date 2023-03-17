package adtstack.stack;

import java.util.Iterator;

public class LinkedStack<E> implements StackInterface<E> {

    private Node head;
    private int size;

    public LinkedStack() {
        this.head = null;
    }

    private Node getNode(int index) {

        Node currentNode = this.head;

        for (int i = 0; i <= index - 1; i++) {
            currentNode = currentNode.getNextNode();
        }

        return currentNode;
    }

    @Override
    public void push(E element) {
        Node newHead = new Node(element, this.head);
        this.head = newHead;
        this.size++;
    }

    @Override
    public E pop() {
        Node tempNode = this.head;

        if (this.size < 1) {
            return null;
        } else if (this.size == 1) {
            this.head = null;
            this.size--;

            return tempNode.getData();
        } else {

            this.head = this.head.getNextNode();
            this.size--;
        }
        return tempNode.getData();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public E top() {
        return this.head.getData();
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size = ").append(this.size).append("\n");
        sb.append("[ ");

        if (this.size < 1) {
            sb.append(" ]\n");

            return sb.toString();
        }

        for (int i = 0; i < this.size; i++) {
            if (i == this.size - 1) {
                sb.append(this.getNode(i).getData()).append(" ]\n");
            } else {
                sb.append(this.getNode(i).getData()).append(" ");
            }
        }


        return sb.toString();
    }

    class StackIterator implements Iterator<E> {

        private Node currentNode;

        public StackIterator() {
            this.currentNode = head;
        }


        @Override
        public boolean hasNext() {
            return this.currentNode != null;
        }

        @Override
        public E next() {
            if (this.hasNext()) {
                E data = this.currentNode.getData();
                this.currentNode = currentNode.getNextNode();
                return data;
            }

            return null;
        }
    }

    public class Node {
        private E data;
        private Node nextNode;

        public Node(E data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}
