package arrays;

import java.util.Scanner;

public class Dec2Hex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimalNumber = sc.nextInt();
        String hexString = findString(decimalNumber);
        System.out.println(hexString);

    }

    public static String findString(int decimalNumber) {
        String reverseHexString = "";
        while (decimalNumber != 0) {
            int remainder = decimalNumber % 16;
            reverseHexString += convertDecToHex(remainder);
            decimalNumber /= 16;
        }

        return reverseString(reverseHexString);
    }

    public static String convertDecToHex(int number) {
        String character = "";
        if (number >= 0 && number <= 9) {
            character = String.valueOf(number);
        }
        switch (number) {
            case (10) -> character = "A";
            case (11) -> character = "B";
            case (12) -> character = "C";
            case (13) -> character = "D";
            case (14) -> character = "E";
            case (15) -> character = "F";

        }
        return character;
    }

    public static String reverseString(String reverse) {
        String realString = "";
        for (int i = 0; i < reverse.length(); i++) {
            realString += reverse.charAt(reverse.length()-i-1);

        }
        return realString;

    }
}
