package designpatterns.decorator.encyrption;

public interface DataSource {
    void writeData(String data);
    String readData();
}
