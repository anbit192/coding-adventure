package designpatterns.visitor.book.elements;

import designpatterns.visitor.book.visitors.Visitor;

public class DesignPatternBook extends ProgrammingBook {
    private String bestSellerBook;

    public DesignPatternBook(Double price, String resource, String bestSellerBook) {
        super(price, resource);
        this.bestSellerBook = bestSellerBook;
    }

    @Override
    public String toString() {
        return "DesignPatternBook[" +
                "bestSellerBook='" + bestSellerBook + '\'' +
                ", resource='" + resource + '\'' +
                ", price=" + price +
                "] ";
    }

    @Override
    public String getResource() {
        return this.resource;
    }

    public String getBestSeller() {
        return this.bestSellerBook;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
