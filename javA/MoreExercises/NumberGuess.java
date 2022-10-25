package MoreExercises;

import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        gameplay(scan);
    }

    public static int generateRandom() {

        while (true) {
            int number = (int) (Math.random() * 100);
            if (number < 100) {
                return number;
            }
        }
    }

    public static void gameplay(Scanner scan) {
        int number = generateRandom();
        int count = 0;

        while (true) {

            count++;

            int input = scan.nextInt();

            if (input < number) {
                System.out.println("Guess higher");
            } else if (input > number) {
                System.out.println("Guess lower");
            } else {
                System.out.println("You got it in " + count + " times.");
            }
        }
    }
}
