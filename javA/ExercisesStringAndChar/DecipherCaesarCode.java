package ExercisesStringAndChar;

import java.util.Scanner;

public class DecipherCaesarCode {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String cipherString = scan.next().toUpperCase();
        int n = Integer.parseInt(scan.next());
        if (n > 26) {
            n %= 26;
        }

        for (int i = 0; i < cipherString.length(); i++) {

            char character = cipherString.charAt(i);
            int totalAsciiNumber = character - n;
            if (totalAsciiNumber < 65) {
                System.out.print((char) (90 - (64 - totalAsciiNumber)));
            } else {
                System.out.print((char) totalAsciiNumber);
            }

        }
    }
}
