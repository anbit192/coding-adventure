package moreexercises;

import java.util.Arrays;
import java.util.Scanner;

public class WordGuess {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        gameplay(scan);
    }

    public static boolean equalArray(String[] array1, String[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (!(array1[i].equals(array2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static void gameplay(Scanner scan) {

        String secretString = "pppppp";
        int count = 0;

        String[] answer = new String[secretString.length()];
        boolean[] booleans = new boolean[secretString.length()];
        String[] secretChars = new String[secretString.length()];

        Arrays.fill(answer, "_");

        for (int i = 0; i < secretString.length(); i++) {
            secretChars[i] = Character.toString(secretString.charAt(i));
        }

        while (true) {
            count++;
            Arrays.fill(booleans, false);

            String input = scan.next().toLowerCase();

            if (input.length() >= 2 && input.equals(secretString)) {
                System.out.println(input);
                System.out.println("You got this in " + count + " times.");
                break;
            } else if (input.length() >= 2 && !(input.equals(secretString))) {
                System.out.println("Incorrect!");
            }

            for (int i = 0; i < secretChars.length; i++) {
                if (secretChars[i].equals(input)) {
                    booleans[i] = true;
                }
            }

            for (int i = 0; i < answer.length; i++) {
                if (booleans[i]) {
                    answer[i] = input;
                }
            }

            printArray(answer);

            if (equalArray(answer, secretChars)) {
                printArray(answer);
                System.out.println("You got this in " + count + " times.");
                break;
            }
        }
    }
}
