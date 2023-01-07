package designpatterns.strategy.operations;

import designpatterns.strategy.operations.strategies.Strategy;

public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(double a, double b) {
        return this.strategy.execute(a, b);

    }
}
