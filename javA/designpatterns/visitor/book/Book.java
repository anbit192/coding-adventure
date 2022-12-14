package designpatterns.visitor.book;

public abstract class Book {
    protected double price;

    public Book(double price) {
        this.price = price;
    }

    public abstract void accept(Visitor visitor);

    public double getPrice() {
        return price;
    }
}
