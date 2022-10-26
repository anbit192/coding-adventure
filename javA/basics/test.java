package basics;

import java.util.Calendar;

public class test {
    public static void main(String[] args) {
        int[] array1 = {1,2,3};
        int[] array2 = array1.clone();

        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }

    }
}
