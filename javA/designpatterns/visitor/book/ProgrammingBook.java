package designpatterns.visitor.book;

public abstract class ProgrammingBook extends Book {
    protected String resource;

    public ProgrammingBook(double price, String resource) {
        super(price);
        this.resource = resource;
    }

    public abstract String getResource();
}
