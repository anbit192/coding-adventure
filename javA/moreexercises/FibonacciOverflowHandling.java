package moreexercises;

public class FibonacciOverflowHandling {

    public static int fibonacci(int n) {
        int k = 0;
        int k1 = 1;
        int k2 = 0;

        int count = 0;

        while (count <= n) {
            k = k1 + k2;
            k1 = k2;
            k2 = k;
            count++;
        }

        return k;
    }

    public static void main(String[] args) {
        int n = 0;
        int number = 0;
        while (true) {
            number = fibonacci(n);
            n++;
            System.out.println(number);

            if (Integer.MAX_VALUE - fibonacci(n - 1) < fibonacci(n - 2)) {
                System.out.println("Out of range");
                break;
            }
        }
    }
}
