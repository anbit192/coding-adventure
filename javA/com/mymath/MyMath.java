package com.mymath;

public class MyMath {
    public MyMath() {

    }

    public static void main(String[] args) {
        double expValue = exp(4);
        double cosValue = cos(9);

        double value = expValue * cosValue;

        System.out.println("Using man made functions: ");
        System.out.println(value);
        System.out.println("Using java function: ");
        System.out.println(Math.cos(9)*Math.exp(4));

        System.out.println("Using hand made functions: ");
        String radixInput = "123456789";
        System.out.println(toDecimal(radixInput, 13));
        String radixOut = toRadix(radixInput, 13, 8);
        System.out.println(radixOut);

        System.out.println("Using java:");


    }

    public static double cos(double x) {

        double sum = 0;
        double term;

        for (int i = 0; i < 50 * 2; i += 2) {

            term = 1;
            for (int j = 1; j <= i; j++) {
                term *= x / (double) j;
            }

            if (i % 4 == 2) {
                sum -= term;
            } else {
                sum += term;
            }
        }

        return sum;
    }

    public static double exp(double x) {
        double sum = 0;
        double factor = 1;

        for (int i = 1; i < 100; i++) {
            sum += factor;
            factor *= (x / (double) i);
        }

        return sum;
    }

    public static String generateBaseCharacters(int radixNumber) {

        String baseCharacters = "";

        if (radixNumber < 10) {
            for (int i = 0; i < radixNumber; i++) {
                baseCharacters += String.valueOf(i);
            }
        } else {
            for (int i = 0; i < 10; i++) {
                baseCharacters += String.valueOf(i);
            }
            for (int i = 65; i < 65 + radixNumber - 10; i++) {
                baseCharacters += (char) i;
            }
        }

        return baseCharacters;
    }

    private static char toRadixChar(int number, int radixNumber) {
        String base = generateBaseCharacters(radixNumber);
        return base.charAt(number);
    }

    private static int toDigit(char character, int radixNumber) {

        String base = generateBaseCharacters(radixNumber);

        return base.indexOf(character);
    }

    private static String reverseString(String originalString) {
        String reverseString = "";
        for (int i = 0; i < originalString.length(); i++) {
            reverseString += originalString.charAt(originalString.length() - i - 1);
        }

        return reverseString;
    }

    public static String decimalTo(String number, int radix) {

        int decimal = Integer.parseInt(number);

        String convertedString = "";
        while (decimal != 0) {
            int remainder = decimal % radix;
            convertedString += toRadixChar(remainder, radix);
            decimal /= radix;
        }

        return reverseString(convertedString);
    }

    public static String toRadix(String radixString, int inRadix, int outRadix) {
        String decimalFromInRadix = toDecimal(radixString, inRadix);

        return decimalTo(decimalFromInRadix, outRadix);
    }

    public static String toDecimal(String radixString, int radixNumber) {
        int decimal = 0;

        for (int i = 0; i < radixString.length(); i++) {
            decimal += toDigit(radixString.charAt(radixString.length() - i - 1), radixNumber) * Math.pow(radixNumber, i);
        }

        return String.valueOf(decimal);
    }


}

