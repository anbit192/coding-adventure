package designpatterns.strategy.payment.strategies;

import designpatterns.strategy.payment.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PayByPaypal implements PayStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();

    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    private final BufferedReader READER = Reader.getInstance();
    private String email;
    private String password;
    private boolean signedIn;

    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.printf("Paying %d using Paypal", paymentAmount);
            return true;
        }
        return false;
    }

    @Override
    public void collectPaymentDetails() {
        try {
            while (!signedIn) {
                System.out.println("Enter the user's email: ");
                email = READER.readLine();
                System.out.println("Enter the password: ");
                password = READER.readLine();
                if (verify()) {
                    System.out.println("Successful");
                } else {
                    System.out.println("Wrong");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean verify() {
        this.setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
