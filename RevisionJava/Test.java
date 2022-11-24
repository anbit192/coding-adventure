package oop;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>(list1);
        list2.add(4);
        print(list1);


        print(list2);


    }

    public static void print(ArrayList<Integer> list) {
        for (int item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
