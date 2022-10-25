package ExercisesMethod;

import java.util.Scanner;

public class RadixNToDecimal {

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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the radix number: ");
        int radixNumber = scan.nextInt();

        System.out.println("Enter the radix String: ");
        String radixString = scan.next().toUpperCase();

        if (!isValidRadix(radixString, radixNumber)) {
            System.out.printf("The String %s is not valid in base %d.\n", radixString, radixNumber);
        } else {

            System.out.println("Base of the radix :");
            String base = generateBaseCharacters(radixNumber);
            System.out.println(base);
            System.out.println();

            System.out.printf("Convert radix string %s to decimal number:\n", radixString);
            System.out.println(convertRadixToDecimal(radixString, radixNumber));
        }


    }
}
