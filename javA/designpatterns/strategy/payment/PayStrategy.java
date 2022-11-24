package designpatterns.strategy.payment;

public interface PayStrategy {
    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}
