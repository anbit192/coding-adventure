package oopexercises.collections.lists2;

public class TestApp {
    public static void main(String[] args) {
        MyList l = new MyArrayList();
        l.add("a",0);
        l.add("b");
        l.add("c");
        l.add("c", 0);
        l.add("c", 3);
        System.out.println(l);
        l.remove(3);
        System.out.println(l.size());
        System.out.println(l);


        MyList linkedList = new MyLinkedList();
        linkedList.add(0,0);
        linkedList.add(1,1);
        linkedList.add(2,2);
        linkedList.add(3,3);
        linkedList.add(192);
        linkedList.add(123);

        ((MyLinkedList) linkedList).print();
        linkedList.remove(1);
        ((MyLinkedList) linkedList).print();











    }
}