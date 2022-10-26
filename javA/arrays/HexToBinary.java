package arrays;

import java.util.Scanner;

public class HexToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String hexString = scan.next().toUpperCase();

        int[] hexInDecimal = new int[16];
        final String[] HEX_BITS = generateHexBits(hexInDecimal);

        System.out.println("Input : " + hexString);
        System.out.println("Converted String: ");
        convertHexToBin(HEX_BITS, hexString);
        System.out.println("Hexadecimal In Binary array: ");
        printArray(HEX_BITS);

    }

    public static void convertHexToBin(String[] HEX_BITS, String hexString) {

        for (int i = 0; i < hexString.length(); i++) {
            char character = hexString.charAt(i);

            if (Character.isDigit(character)) {
                System.out.print(HEX_BITS[Integer.parseInt(Character.toString(character))] + " ");
            }

            switch (character) {
                case ('A') -> System.out.print(HEX_BITS[10] + " ");
                case ('B') -> System.out.print(HEX_BITS[11] + " ");
                case ('C') -> System.out.print(HEX_BITS[12] + " ");
                case ('D') -> System.out.print(HEX_BITS[13] + " ");
                case ('E') -> System.out.print(HEX_BITS[14] + " ");
                case ('F') -> System.out.print(HEX_BITS[15] + " ");
            }
        }
        System.out.println();

    }

    public static void printArray(String[] array) {
        for (String item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static String[] generateHexBits(int[] array) {

        String[] HexBits = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            HexBits[i] = convertDecimalToBin(i);
        }

        return HexBits;
    }

    public static String convertDecimalToBin(int number) {
        String reverseBinaryString = "";
        String binaryString = "";

        while (number != 0) {
            if (number % 2 == 0) {
                reverseBinaryString += "0";
            } else {
                reverseBinaryString += "1";
            }

            number /= 2;
        }

        if (reverseBinaryString.length() < 4) { // add "0" if size < 4
            for (int i = 0; i < 4 - reverseBinaryString.length(); i++) {
                binaryString += "0";
            }
        }

        for (int i = reverseBinaryString.length() - 1; i >= 0; i--) { // flip the string

            binaryString += reverseBinaryString.charAt(i);
        }

        return binaryString;
    }

}
