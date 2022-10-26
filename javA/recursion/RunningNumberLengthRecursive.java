package recursion;

public class RunningNumberLengthRecursive {
    public static void main(String[] args) {
        System.out.println(len(13));
    }

    public static int numberOfDigits(int n) {
        String number = String.valueOf(n);
        return number.length();
    }

    public static int len(int n) {
        if (n < 1) {
            System.out.print(" : ");
            return 0;
        }

        System.out.print(n);

        return numberOfDigits(n) + len(n - 1);
    }
}
