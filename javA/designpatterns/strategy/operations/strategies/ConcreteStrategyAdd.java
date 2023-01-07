package designpatterns.strategy.operations.strategies;

public class ConcreteStrategyAdd implements Strategy {
    @Override
    public double execute(double a, double b) {
        return a + b;
    }
}
