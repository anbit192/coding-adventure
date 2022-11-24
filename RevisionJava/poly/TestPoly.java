package oop.poly;

import java.util.ArrayList;
import java.util.List;

public class TestPoly {
    List<Poly> polyList;

    public TestPoly() {
        this.polyList = new ArrayList<>();
    }

    public static ArrayPoly createArrayPoly(int[] coefficients) {
        return new ArrayPoly(coefficients);
    }

    public static ListPoly createListPoly(int[] coefficients) {
        return new ListPoly(coefficients);
    }

    public static int[] createRandomArray(int degree) {
        int[] array = new int[degree + 1];
        int randomNumber;
        for (int i = 0; i <= degree; i++) {
            do {
                randomNumber = (int) ((Math.random()) * 10);
            } while (randomNumber == 0);
            array[i] = randomNumber;
        }

        return array;
    }

    public static void main(String[] args) {
        TestPoly polyTest = new TestPoly();

        for (int i = 0; i < 5; i++) {
            polyTest.polyList.add(createArrayPoly(createRandomArray(5)));
        }

        for (int i = 0; i < 5; i++) {
            polyTest.polyList.add(createListPoly(createRandomArray(4)));
        }

        for (Poly item : polyTest.polyList) {
            System.out.println(item);
            System.out.println("degree : "+item.degree());
            System.out.println(item.derivative());
            System.out.println("evaluate at x = " + 2);
            System.out.println(item.evaluate(2));

            if (item instanceof ArrayPoly) {
                System.out.println(((ArrayPoly) item).type());
            }
            else {
                System.out.println(((ListPoly) item).type());
            }

        }


    }
}
