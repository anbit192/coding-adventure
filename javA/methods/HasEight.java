package methods;

import java.util.Scanner;

public class HasEight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        magicSum(scan);
    }

    public static boolean hasEight(int number) {
        String numberString = String.valueOf(number);

        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) == '8') {
                return true;
            }
        }

        return false;
    }

    public static void magicSum(Scanner scan) {
        int sum = 0;
        int number;

        do {
            number = scan.nextInt();
            if (hasEight(number)) {
                sum += number;
            }
        } while (number != -1);

        System.out.println(sum);
    }
}
