package recursion;

public class FactorialRecursive {
    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    public static int factorial(int n) {
        if (n == 1) {
            System.out.print(n + " = ");
            return 1;
        }
        System.out.print(n + " * ");

        return n * factorial(n - 1);
    }
}
