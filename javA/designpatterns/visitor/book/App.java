package designpatterns.visitor.book;

public class App {
    public static void main(String[] args) {
        Book book1 = new DesignPatternBook(100.0, "alo", "123");
        Book book2 = new BusinessBook(123, "asdlasdasda");

        Visitor visitor = new VisitorImplement();

        book1.accept(visitor);
        book2.accept(visitor);
    }
}
