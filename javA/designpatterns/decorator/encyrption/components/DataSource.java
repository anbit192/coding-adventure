package designpatterns.decorator.encyrption.components;

public interface DataSource {
    void writeData(String data);
    String readData();
}
