package basics;

import java.util.Scanner;

public class CheckPassFail {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int mark = scan.nextInt();

        System.out.println("The mark is" + mark);

        if (mark >= 50) {
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }

        System.out.println("DONE");
    }
}
