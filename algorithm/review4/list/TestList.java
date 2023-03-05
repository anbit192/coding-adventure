package review4.list;

import java.util.Iterator;

public class TestList {
    public static void main(String[] args) {
        // Constructor
        SimpleArrayList<Double> list = new SimpleArrayList<>(3);
        System.out.println(list);
        System.out.println("============================================================");

        //Add
        list.add(1.9);
        list.add(1.92);
        list.add(19.2);
        list.add(192.0);
        System.out.println("============================================================");


        // Iterable
        for (Double item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("============================================================");


        //Remove
        list.remove(192.0);
        list.remove(123.9);
        System.out.println(list);

        System.out.println("============================================================");


        //Contain
        System.out.println(list.isContain(19.2));
        System.out.println(list.isContain(1.0));
        System.out.println("============================================================");


        //Empty
        System.out.println(list.isEmpty());
        System.out.println("============================================================");


        //toString
        System.out.println(list);
        System.out.println("============================================================");


        //Iterator
        Iterator<Double> testIterator = list.iterator();

        System.out.println(testIterator.hasNext());
        System.out.println(testIterator.next());
        System.out.println(testIterator.next());
        System.out.println(testIterator.next());
        System.out.println(testIterator.next());
        System.out.println(testIterator.next());

    }
}
