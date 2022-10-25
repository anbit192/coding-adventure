package oopexercises.classesandobjects.mycomplex;

public class testComplex {
    public static void main(String[] args) {
        MyComplex complex1 = new MyComplex(3.22222,5.9);
        System.out.println(complex1);
        MyComplex complex2 = new MyComplex(1.92, 19);
        System.out.println(complex1.addInto(complex2));
        MyComplex newComplex = complex1.addNew(complex2);
        System.out.println(newComplex);

        System.out.println(complex1.magnitude());

    }
}
