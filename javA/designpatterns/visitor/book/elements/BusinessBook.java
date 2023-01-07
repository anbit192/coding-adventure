package designpatterns.visitor.book.elements;

import designpatterns.visitor.book.visitors.Visitor;

public class BusinessBook extends Book {

    private String publisher;

    public BusinessBook(double price, String publisher) {
        super(price);
        this.publisher = publisher;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getPublisher() {
        return this.publisher;
    }

    @Override
    public String toString() {
        return "BusinessBook[" +
                "publisher='" + publisher + '\'' +
                ", price=" + price +
                "] ";
    }
}
