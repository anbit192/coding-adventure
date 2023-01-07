package designpatterns.observer.numbersystem.observers;

import designpatterns.observer.numbersystem.Subject;

public class HexaObserver extends Observer {

    private String hexa;

    public HexaObserver(Subject subject) {
        super(subject);
        subject.attach(this);
    }

    private static String convertDecimalToHexa(int decimal) {
        return Integer.toHexString(decimal);
    }

    @Override
    public void update() {
        this.hexa = convertDecimalToHexa(this.subject.getState());
    }

    @Override
    public String toString() {
        return "HexaObserver{" +
                "hexa='" + hexa + '\'' +
                "} ";
    }
}
