package sorts.genericsort;

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

        ArrayTest<String> arrayTest1 = new ArrayTest<>(String.class);
        arrayTest1.append("a");
        arrayTest1.append("asdad");
        arrayTest1.append("b");

        arrayTest1.bubbleSort();
        System.out.println(arrayTest1);

        ArrayTest<Double> arrayTest2 = new ArrayTest<>(Double.class);
        arrayTest2.append(19.92);
        arrayTest2.append(12.29);
        arrayTest2.append(192.02);

        arrayTest2.selectionSort();
        System.out.println(arrayTest2);

    }

}
