package designpatterns.observer.numbersystem;

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
    void update() {
        this.hexa = convertDecimalToHexa(this.subject.getState());
    }

    @Override
    public String toString() {
        return "HexaObserver{" +
                "hexa='" + hexa + '\'' +
                "} ";
    }
}
