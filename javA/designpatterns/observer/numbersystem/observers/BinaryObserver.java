package designpatterns.observer.numbersystem.observers;

import designpatterns.observer.numbersystem.Subject;

public class BinaryObserver extends Observer {
    private String binary;

    public BinaryObserver(Subject subject) {
        super(subject);
        subject.attach(this);
    }

    private static String convertDecimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    @Override
    public void update() {
        this.binary = convertDecimalToBinary(this.subject.getState());
    }

    @Override
    public String toString() {
        return "BinaryObserver{" +
                "binary='" + binary + '\'' +
                "} ";
    }
}
