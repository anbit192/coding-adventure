package oop.mylist;

import java.util.Objects;

public class MyLinkedList extends MyAbstractList {

    MyLinkedListNode head;
    int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private MyLinkedListNode getNodeByIndex(int index) {
        MyLinkedListNode current = this.head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    @Override
    public void add(Object o) {
        this.add(o, this.size());
    }

    @Override
    public void add(Object o, int index) {
        MyLinkedListNode current;
        this.size++;
        if (index == 0) {
            this.head = new MyLinkedListNode(o, this.head);
        } else {
            current = getNodeByIndex(index - 1);
            current.setNext(new MyLinkedListNode(o, current.next));
        }
    }

    @Override
    public Object get(int index) {
        return getNodeByIndex(index).getPayload();
    }

    @Override
    public void remove(int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            this.head = getNodeByIndex(1);
        }

        MyLinkedListNode current = getNodeByIndex(index);
        current.setNext(current.next.next);

        this.size--;
    }

    @Override
    public int size() {
        return this.size;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.get(i) + " ");
        }
        System.out.println();
    }
}
