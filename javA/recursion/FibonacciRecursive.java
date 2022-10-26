package recursion;

public class FibonacciRecursive {
    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }

    public static int fibonacci(int n) {
        if (n == 1) {
            return 1;

        } else if (n == 0) {
            return 0;

        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
