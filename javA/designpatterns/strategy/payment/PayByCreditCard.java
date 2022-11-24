package designpatterns.strategy.payment;

import java.io.BufferedReader;
import java.io.IOException;

public class PayByCreditCard implements PayStrategy {
    private final BufferedReader READER = Reader.getInstance();
    private CreditCard card;

    private boolean cardIsPresent() {
        return this.card != null;
    }

    @Override
    public boolean pay(int paymentAmount) {

        if (cardIsPresent()) {
            System.out.println("Paying " + paymentAmount + " using Credit Card.");
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        try {
            System.out.println("Enter the card number: ");
            String number = READER.readLine();
            System.out.println("Enter the card expiration date mm/yy: ");
            String date = READER.readLine();
            System.out.println("Enter the Card Verification Value code: ");
            String cardVerificationValue = READER.readLine();

            if (CreditCardValidator.isValid(number)) {
                card = new CreditCard(number, date, cardVerificationValue);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
