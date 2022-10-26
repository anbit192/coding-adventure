package stringandchar;

import java.util.Scanner;

public class CountVowelsDigits {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toLowerCase();
        int vowels = 0;
        int digits = 0;

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (character == 'u' || character == 'e' || character == 'o' || character == 'a' || character == 'i') {
                vowels++;
            } else if (Character.isDigit(character)) {
                digits++;
            }
        }

        System.out.printf("number of vowels:%d (%.2f%%)\n", vowels, ((double) vowels / input.length()) * 100.0);
        System.out.printf("number of digits:%d (%.2f%%)", digits, ((double) digits / input.length()) * 100.0);


    }
}
