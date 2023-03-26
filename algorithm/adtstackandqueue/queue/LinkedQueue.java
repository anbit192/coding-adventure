package adtstackandqueue.queue;

import java.util.Iterator;

public class LinkedQueue<E> implements QueueInterface<E> {

    private Node head;

    public LinkedQueue() {
        this.head = null;
    }

    @Override
    public void enqueue(E element) {

        if (this.head == null) {
            this.head = new Node(element);

        } else {

            Node tempNode = this.head;
            this.head = new Node(element, tempNode);
        }

    }

    @Override
    public E dequeue() {
        if (this.head == null) {
            return null;
        } else if (this.head.getNextNode() == null) {
            Node tempNode = this.head;
            this.head = null;
            return tempNode.getData();
        } else {
            Node tempNode = this.head;
            Node removedNode;
            while (tempNode.getNextNode().getNextNode() != null) {
                tempNode = tempNode.getNextNode();
            }

            removedNode = tempNode.getNextNode();
            tempNode.setNextNode(null);
            return removedNode.getData();

        }
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedQueueIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");
        if (this.head == null) {
            sb.append(" ]\n");
            return sb.toString();
        }

        Node tempNode = this.head;
        while (tempNode.getNextNode() != null) {

            sb.append(tempNode.getData()).append(", ");
            tempNode = tempNode.getNextNode();
        }

        sb.append(tempNode.getData()).append(" ]\n");

        return sb.toString();
    }

    class LinkedQueueIterator implements Iterator<E> {

        private Node currentNode;

        public LinkedQueueIterator() {
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return this.currentNode != null;
        }

        @Override
        public E next() {
            E data = this.currentNode.getData();
            this.currentNode = this.currentNode.getNextNode();
            return data;
        }
    }

    class Node {
        private E data;
        private Node nextNode;

        public Node(E data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }

        public Node(E data) {
            this.data = data;
            this.nextNode = null;
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
