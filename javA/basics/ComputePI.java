package basics;

public class ComputePI {

    public static void main(String[] args) {

        double pi = 0;
        double sum = pi;

        for (int i = 1; i<=9999999;i+=2) {

            if (i%4 == 1) {

                sum += (1.0/(double)i);
            }

            else {
                sum -= (1.0 / (double) i);
            }
        }

        pi = 4.0 * sum;

        System.out.println(pi);
    }
}
