public class HarmonicSum {

    public static void main(String[] args) {

        double sum1 = 0;
        double sum2 = 0;
        double absoluteDifference;

        for (int i = 1; i<50000; i++) {

            sum1 += (1.0/(double) i);
        }

        for (int i = 50000; i>=1 ; i--) {
            sum2 += (1.0/(double) i);
        }

        System.out.println(sum1);
        System.out.println(sum2);

        absoluteDifference = Math.sqrt(Math.pow(sum1-sum2,2));

        System.out.println(absoluteDifference);
    }
}
