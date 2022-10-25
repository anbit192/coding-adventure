package basics;
public class SumDivisors {

    public static int sumOfDivisors(int n) {

        int sumDivisors = 0;
        for (int i = 1; i <= n; i++) {

            if ((n > 0) && (n%i==0)) {
                sumDivisors += i;
            
            } 

        
        }
        return sumDivisors;
    }
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int sum=sumOfDivisors(n);

        System.out.println(sum);

    }
}