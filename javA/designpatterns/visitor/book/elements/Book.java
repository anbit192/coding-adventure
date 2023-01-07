package designpatterns.visitor.book.elements;

import designpatterns.visitor.book.visitors.Visitor;

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
