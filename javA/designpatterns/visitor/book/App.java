package designpatterns.visitor.book;

import designpatterns.visitor.book.elements.Book;
import designpatterns.visitor.book.elements.BusinessBook;
import designpatterns.visitor.book.elements.DesignPatternBook;
import designpatterns.visitor.book.visitors.Visitor;
import designpatterns.visitor.book.visitors.VisitorImplement;

public class App {
    public static void main(String[] args) {
        Book book1 = new DesignPatternBook(100.0, "alo", "123");
        Book book2 = new BusinessBook(123, "asdlasdasda");

        Visitor visitor = new VisitorImplement();

        book1.accept(visitor);
        book2.accept(visitor);
    }
}
