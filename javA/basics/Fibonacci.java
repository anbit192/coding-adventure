public class Fibonacci {

    public static void main(String[] args) {
        int sum = 0 ;
        int secondNumber=0;
        int firstNumber=1;
        int count = 1;

        while (count<21) {

            sum = firstNumber + secondNumber;

            System.out.println(sum);

            firstNumber=secondNumber;
            secondNumber=sum;

            count++;

        }
    }

}
