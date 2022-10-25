import java.util.Scanner;

public class ExtractDigitsInReverse {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int reverseNumber = 0;
        int remainder;

        while (number != 0) {
            remainder = number % 10;
            reverseNumber = reverseNumber * 10 + remainder;
            number /= 10;

        }

        System.out.println(reverseNumber);
    }
}
