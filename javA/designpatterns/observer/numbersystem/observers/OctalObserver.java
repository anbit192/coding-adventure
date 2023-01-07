package designpatterns.observer.numbersystem.observers;

import designpatterns.observer.numbersystem.Subject;

public class OctalObserver extends Observer {

    private String octal;

    public OctalObserver(Subject subject) {
        super(subject);
        subject.attach(this);
    }

    @Override
    public void update() {
        this.octal = convertDecimalToOctal(this.subject.getState());
    }

    private static String convertDecimalToOctal(int decimal) {
        return Integer.toOctalString(decimal);
    }

    @Override
    public String toString() {
        return "OctalObserver{" +
                "octal='" + octal + '\'' +
                "} ";
    }
}
