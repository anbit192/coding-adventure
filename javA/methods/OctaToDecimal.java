package methods;

import java.util.Scanner;

public class OctaToDecimal {

    public static int searchCharacter(char character) {
        String octalCharacters = "01234567";
        return octalCharacters.indexOf(character);

    }

    public static boolean isValidOctalString(String octString) {
        for (int i = 0; i < octString.length(); i++) {
            if (searchCharacter(octString.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

    public static int toDigit(char character) {
        String octChars = "01234567";
        return octChars.indexOf(character);
    }

    public static int convertOctalToDecimal(String octString) {

        int decimalNumber = 0;
        for (int i = 0; i < octString.length(); i++) {

            decimalNumber += toDigit(octString.charAt(octString.length() - i - 1)) * Math.pow(8, i);
        }

        return decimalNumber;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String octalNumber = scan.next();
        System.out.println(convertOctalToDecimal(octalNumber));


    }
}
