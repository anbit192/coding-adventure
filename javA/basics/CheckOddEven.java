package basics;

import java.util.Scanner;

public class CheckOddEven {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();

        System.out.println("The number is " + number);

        if (number % 2 == 0) {
            System.out.println("The number is Even");
        }

        else {
            System.out.println("The number is Odd");
        }

        System.out.println("GOODBYE");
    }
}
