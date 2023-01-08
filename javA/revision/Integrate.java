package revision;

public class Integrate {

    public static double f(double x) {
        return Math.sin(x) * Math.sin(x) * Math.cos(x);
    }

    public static double integrate(double a, double b) {

        int partitions = 2;

        double ln; // integral value at partition n
        double l2n; // integral value at partition 2*n

        do {
            ln = 0;
            l2n = 0;
            double h = (b - a) / partitions; // dx

            for (int i = 0; i <= partitions; i++) {
                double xi = a + i * h;
                if (i == 0 || i == partitions) {
                    ln += (f(xi) / 2);
                }

                ln += f(xi);
            }

            ln *= h;

            h /= 2;

            for (int i = 0; i <= 2 * partitions; i++) {
                double xi = a + i * h;
                if (i == 0 || i == 2 * partitions) {
                    l2n += (f(xi) / 2);
                }

                l2n += f(xi);
            }

            l2n *= h;

            partitions *= 2;

        } while (l2n - ln >= 1 * Math.pow(10, -10));

        return ln;
    }

    public static void main(String[] args) {
        System.out.println(integrate(0, Math.PI / 2));
    }
}
