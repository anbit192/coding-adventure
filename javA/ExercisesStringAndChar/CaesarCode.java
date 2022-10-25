package ExercisesStringAndChar;

import java.util.Scanner;

public class CaesarCode {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String plainString = scan.next().toUpperCase();
        int n = Integer.parseInt(scan.next());
        if (n > 26) {
            n %= 26;
        }

        for (int i = 0; i < plainString.length(); i++) {

            char character = plainString.charAt(i);
            int totalAsciiNumber = character + n;

            if (totalAsciiNumber > 90) {
                System.out.print((char) (65 + (totalAsciiNumber - 91)));
            } else {
                System.out.print((char) (totalAsciiNumber));
            }
        }

    }
}
