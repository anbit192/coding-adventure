package basics;

import java.util.Scanner;

public class PrintNumberInWord {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();

        if (number == 1) {
            System.out.println("ONE");
        }

        else if (number == 2) {
            System.out.println("TWO");
        }

        else if (number == 3) {
            System.out.println("THREE");
        }

        System.out.println();
    }
}
