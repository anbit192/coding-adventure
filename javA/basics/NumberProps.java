package basics;
public class NumberProps {


    public static boolean checkPrime(int n) {

        boolean isNotPrime = false;
        
        for (int i = 2; i <n ;i++) {

            if ( n%i == 0 ) {
                isNotPrime = true;
            }
        }


        if ( isNotPrime == false ) {
            return true;
        }


        return false;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        System.out.println(checkPrime(n));
    }
}
