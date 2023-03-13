package spoj;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class EZQUEUE {
    public static void main(String[] args) {

        Queue<Integer> queue = new PriorityQueue<>();
        query(queue);


    }

    public static void query(Queue<Integer> queue) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        while (T > 0) {

            int n = scan.nextInt();
            if (n == 1) {
                queue.offer(scan.nextInt());
            } else if (n == 2) {
                if (queue.peek() != null) {
                    queue.poll();
                }
            } else if (n == 3) {
                Integer number = queue.peek();

                if (number == null) {
                    System.out.println("Empty!");
                } else {
                    System.out.println(number);
                }
            }

            T--;
        }
    }

}
