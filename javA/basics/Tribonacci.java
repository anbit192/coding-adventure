public class Tribonacci {

    public static void main(String[] args) {

        int k = 0;
        int k1 = 1;
        int k2 = 0;
        int k3 = 0;

        int count = 0;

        while (count<20) {
            k = k1 + k2 + k3;

            System.out.println(k);
            count++;
            k1 = k2;
            k2 = k3;
            k3=k;
        }

    }
}
