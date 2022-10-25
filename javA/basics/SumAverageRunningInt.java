public class SumAverageRunningInt {

    public static void main(String[] args) {

        final int lowerBound = 0;
        final int upperBound = 100;
        int sum = 0;
        double average;

        for (int i = 1;i<=100;i++) {

            sum += i;
        }

        average = (double) sum /100;

        System.out.println("The sum is "+sum);
        System.out.println("The average is "+average);


    }
}
