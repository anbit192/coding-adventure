package NumberOfTheory;

public class GCDLoops {
    public static void main(String[] args) {
        System.out.println(gcd(16,18));
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }
}
