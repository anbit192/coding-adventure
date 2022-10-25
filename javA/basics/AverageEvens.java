public class AverageEvens {

    public static double getAverage(double n) {

        double averageOdds= 0;
        int oddCount=0;

        for (int i = 0; i <= n ; i++) {
            if  ( i%2 != 0 ) {

                oddCount++;
                averageOdds+=i;

            }
        }
        return ( averageOdds/ (double) oddCount);

    }
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        System.out.println(getAverage(n));
    }
    
}
