package oop.mylist;

import java.util.Random;

public class TestMyList {
    public TestMyList() {
    }

    public static void main(String[] args) {

        MyArrayList arrayList = generateDataArrayList();
        MyLinkedList linkedList = generateDataLinkedList();

        System.out.println("Array List: ");
        System.out.println(arrayList);
        arrayList.add(9);
        arrayList.remove(0);
        System.out.println(arrayList);

        System.out.println("========================");
        System.out.println("Linked List: ");
        System.out.println(linkedList);
        linkedList.add(3,0);
        linkedList.remove(5);
        System.out.println(linkedList);

    }

    public static MyArrayList generateDataArrayList() {
        Random random = new Random();
        MyArrayList arrayList = new MyArrayList();

        for (int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(1, 100));
        }

        return arrayList;
    }

    public static MyLinkedList generateDataLinkedList() {
        MyLinkedList linkedList = new MyLinkedList();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            linkedList.add(random.nextInt(100), i);
        }

        return linkedList;
    }
}
