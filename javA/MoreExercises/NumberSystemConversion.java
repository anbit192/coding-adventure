package MoreExercises;

import java.util.Scanner;

public class NumberSystemConversion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the input radix number: ");
        int radixNumberInput = scan.nextInt();
        System.out.println("Enter the input radix String");
        String radixStringInput = scan.next().toUpperCase();
        System.out.println("Enter the output radix number: ");
        int radixNumberOutput = scan.nextInt();

        int decimalOutput = convertRadixToDecimal(radixStringInput, radixNumberInput);

        String radixOutput = convertDecimalToRadix(decimalOutput, radixNumberOutput);
        System.out.printf("%s in %d base convert to %d base is: ", radixStringInput, radixNumberInput, radixNumberOutput);

        System.out.println(radixOutput);

    }

    public static String generateBaseCharacters(int radixNumber) { /*generate the base for radix string
                                                                     e.g : base 2 => base = {0,1} => binary.
                                                                           base 16 => base = {0,1,...,9,A,B,...,F} => hexadecimal.*/
        String baseCharacters = "";

        if (radixNumber < 10) {
            for (int i = 0; i < radixNumber; i++) {
                baseCharacters += String.valueOf(i);
            }
        } else {
            for (int i = 0; i < 10; i++) {
                baseCharacters += String.valueOf(i);
            }
            for (int i = 65; i < 65 + radixNumber - 10; i++) { // ascii code of ABCDE....XYZ range = (65 - 90)
                baseCharacters += (char) i;
            }
        }

        return baseCharacters;
    }

    public static int toDigit(char character, int radixNumber) { /*search the character of radix string and return the index of that character
                                                                 e.g : base 16 => base = "0123456789ABCDEF", find index of 'B' => return 11.*/

        String base = generateBaseCharacters(radixNumber);

        return base.indexOf(character);
    }

    public static char toRadixString(int number, int radixNumber) {
        String base = generateBaseCharacters(radixNumber);
        return base.charAt(number);
    }

    public static int convertRadixToDecimal(String radixString, int radixNumber) {
        int decimal = 0;

        for (int i = 0; i < radixString.length(); i++) {
            decimal += toDigit(radixString.charAt(radixString.length() - i - 1), radixNumber) * Math.pow(radixNumber, i);
        }

        return decimal;
    }

    public static boolean isValidRadix(String radixString, int radixNumber) { //check if the input radix string is valid in a base.
        for (int i = 0; i < radixString.length(); i++) {
            if (toDigit(radixString.charAt(i), radixNumber) == -1) {
                return false;
            }
        }

        return true;
    }

    public static String reverseString(String originalString) {
        String reverseString = "";
        for (int i = 0; i < originalString.length(); i++) {
            reverseString += originalString.charAt(originalString.length() - i - 1);
        }

        return reverseString;
    }

    public static String convertDecimalToRadix(int decimal, int radix) {
        String convertedString = "";
        while (decimal != 0) {
            int remainder = decimal % radix;
            convertedString += toRadixString(remainder, radix);
            decimal /= radix;
        }

        return reverseString(convertedString);
    }


}
