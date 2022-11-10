package oopexercises.collections.lists2;

public class MyLinkedList extends MyAbstractList {

    private int size;
    private MyLinkedListNode head;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private MyLinkedListNode getNodeByIndex(int index) {
        MyLinkedListNode current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }

    @Override
    public void add(Object o, int index) {
        checkBoundaries(index, this.size);
        if (index == 0) {
            head = new MyLinkedListNode(o, head);
        } else {
            MyLinkedListNode current = getNodeByIndex(index - 1);
            current.setNext(new MyLinkedListNode(o, current.getNext()));
        }

        size++;
    }

    @Override
    public void remove(int index) {
        checkBoundaries(index, this.size);
        MyLinkedListNode current = getNodeByIndex(index - 1);

        if (index == 0) {
            head = getNodeByIndex(1);
        }

        current.setNext(current.getNext().getNext());
        size--;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.get(i) + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Object get(int index) {
        MyLinkedListNode current = getNodeByIndex(index);
        return current.getPayload();
    }

    @Override
    public void add(Object o) {
        this.add(o, size);

    }
}
