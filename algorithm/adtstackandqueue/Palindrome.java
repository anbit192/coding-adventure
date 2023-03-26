package adtstackandqueue;

import adtstackandqueue.queue.LinkedQueue;
import adtstackandqueue.queue.QueueInterface;
import adtstackandqueue.stack.LinkedStack;
import adtstackandqueue.stack.StackInterface;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        //tacocat
        //radar
        //madam
        //racecar

        System.out.println(palindromeCheckStack(str));
        System.out.println(palindromeCheckQueue(str));


    }

    public static boolean palindromeCheckStack(String str) {
        StackInterface<Character> stack = new LinkedStack<>();
        String originalString = str.toLowerCase().replaceAll("\\s+", "");

        char[] chars = originalString.toCharArray();

        StringBuilder reverseStr = new StringBuilder();

        for (char c : chars) {
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            reverseStr.append(stack.pop());
        }
        System.out.println(reverseStr);

        return reverseStr.toString().equals(originalString);
    }

    public static boolean palindromeCheckQueue(String str) {
        QueueInterface<Character> queue = new LinkedQueue<>();
        String originalString = str.toLowerCase().replaceAll("\\s+", "");

        char[] chars = originalString.toCharArray();

        StringBuilder reverseStr = new StringBuilder();

        for (int i = chars.length - 1; i >= 0; i--) {
            queue.enqueue(chars[i]);
        }

        while (!queue.isEmpty()) {
            reverseStr.append(queue.dequeue());
        }

        System.out.println(reverseStr);

        return reverseStr.toString().equals(originalString);


    }
}
