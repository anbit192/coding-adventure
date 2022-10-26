package basics;

import java.util.Scanner;

public class InputValidation {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int input;

        while (true) {
            input = scan.nextInt();

            if ((input >= 0 && input <=10) || (input >=90 && input<=100)) {
                System.out.println("Valid.");
                break;
            }

            else {
                System.out.println("Invalid!");
            }

        }
    }
}
