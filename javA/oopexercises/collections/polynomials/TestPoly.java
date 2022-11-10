package oopexercises.collections.polynomials;

import java.util.ArrayList;

public class TestPoly {
    public static void main(String[] args) {
        Poly ap = new ArrayPoly(new double[]{1,3,4,8,123,42,3});
        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(1.0);
        arrayList.add(3.0);
        arrayList.add(4.0);
        arrayList.add(8.0);
        Poly lp = new ListPoly(arrayList);

        System.out.println("AP = "+ ap);
        System.out.println("LP = " + lp);

        System.out.println(ap.derivative());
        System.out.println(lp.derivative());



    }
}
