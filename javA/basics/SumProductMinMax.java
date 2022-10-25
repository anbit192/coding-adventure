import java.util.Scanner;

public class SumProductMinMax {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter 1st number: ");
        int number1 = scan.nextInt();

        System.out.println("Enter 2nd number: ");
        int number2 = scan.nextInt();

        System.out.println("Enter 3rd number: ");
        int number3 = scan.nextInt();

        int sum = number1+number2+number3;
        int product = number1*number2*number3;

        int min = Math.min(Math.min(number1,number2),number3);
        int max = Math.max(Math.max(number1,number2),number3);

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        scan.close();
    }
}
