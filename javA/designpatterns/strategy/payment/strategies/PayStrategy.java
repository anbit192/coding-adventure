package designpatterns.strategy.payment.strategies;

public interface PayStrategy {
    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}
