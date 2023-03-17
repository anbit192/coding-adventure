package reviewlist.genericarray;

public class TestSort {

    public static void main(String[] args) {
        ArrayTest<Integer> arrayTest = new ArrayTest<>(Integer.class);
        arrayTest.append(2);
        arrayTest.append(-2);
        arrayTest.append(192);
        arrayTest.append(-69);
        arrayTest.append(68);

        arrayTest.insertionSort();

        System.out.println(arrayTest);

    }

}
