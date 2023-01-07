package designpatterns.visitor.book.elements;

import designpatterns.visitor.book.visitors.Visitor;

public class JavaCoreBook extends ProgrammingBook {

    private String favouriteBook;

    public JavaCoreBook(double price, String resource, String favouriteBook) {
        super(price, resource);
        this.favouriteBook = favouriteBook;
    }

    @Override
    public String toString() {
        return "JavaCoreBook[" +
                "favouriteBook='" + favouriteBook + '\'' +
                ", resource='" + resource + '\'' +
                ", price=" + price +
                "]";
    }

    @Override
    public String getResource() {
        return this.resource;
    }

    public String getFavouriteBook() {
        return this.favouriteBook;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
