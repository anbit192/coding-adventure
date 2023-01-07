package designpatterns.strategy.operations;

import designpatterns.strategy.operations.strategies.ConcreteStrategyAdd;
import designpatterns.strategy.operations.strategies.ConcreteStrategyMultiply;
import designpatterns.strategy.operations.strategies.ConcreteStrategySubtract;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Context context = new Context();
        Scanner scan = new Scanner(System.in);
        int strategyID = scan.nextInt();
        int a = 2;
        int b = 9;

        if (strategyID == 1) {
            context.setStrategy(new ConcreteStrategyAdd());
        } else if (strategyID == 2) {
            context.setStrategy(new ConcreteStrategyMultiply());
        } else {
            context.setStrategy(new ConcreteStrategySubtract());
        }

        System.out.println(context.executeStrategy(a,b));
    }
}
