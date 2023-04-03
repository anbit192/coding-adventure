package spoj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class STPAR {
    public static void main(String[] args) {
        Queue<Short> cars = input();
        StringBuilder sb = new StringBuilder();
        if (arrangeCars(cars)) {
            sb.append("yes\n");
        } else {
            sb.append("no\n");
        }

        System.out.println(sb);
    }

    public static Queue<Short> input() {
        Scanner scan = new Scanner(System.in);
        short numberOfCars = scan.nextShort();
        Queue<Short> cars = new LinkedList<>();

        do {
            short number = scan.nextShort();
            if (number == 0) {
                break;
            }

            cars.offer(number);

        } while (true);

        return cars;
    }

    public static boolean arrangeCars(Queue<Short> cars) {
        Stack<Short> stack = new Stack<>();

        short order = 1;

        while ((!cars.isEmpty() || !stack.isEmpty())) {
            if (!cars.isEmpty() && cars.peek() == order) {
                order++;
                cars.poll();
            } else if (!stack.isEmpty() && stack.peek() == order) {
                order++;
                stack.pop();
            } else {
                if (!cars.isEmpty()) {
                    stack.push(cars.poll());
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
