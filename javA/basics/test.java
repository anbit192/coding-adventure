package basics;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class test {
    public static void main(String[] args) {

        Set<Integer> source = new HashSet<>();
        source.add(3);
        source.add(1);
        source.add(5);

        for (int value : source) {
            System.out.println(value);
        }
        Integer[] intArray = new Integer[source.size()];

        intArray = source.toArray(intArray);
        System.out.println(intArray[1]);





    }
}
