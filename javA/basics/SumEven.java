package basics;
public class SumEven {

    public static int checkSumEven(int n) {

        int sumEven =0;

        for (int i = 0; i < n; i++) {

            if (i%2 == 0) {
                sumEven += i;

            }
        }

        return sumEven;

    }
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        System.out.println(checkSumEven(n));
    }
    
}
