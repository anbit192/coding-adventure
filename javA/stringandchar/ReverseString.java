package stringandchar;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String reverseInput = "";
        int length = input.length();

        for (int i = 0; i < length; i++) {
            char character = input.charAt(length - 1 - i);
            reverseInput += character;
        }

        System.out.println(reverseInput);
    }
}
