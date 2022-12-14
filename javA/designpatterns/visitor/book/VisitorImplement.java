package designpatterns.visitor.book;

public class VisitorImplement implements Visitor {

    private double totalPrice;
    @Override
    public void visit(BusinessBook book) {
        this.totalPrice += book.getPrice();
        System.out.println(book);
        System.out.println("Total price:" + totalPrice);

    }

    @Override
    public void visit(DesignPatternBook book) {
        this.totalPrice += book.getPrice();
        System.out.println(book);
        System.out.println("Total price:" + totalPrice);



    }

    @Override
    public void visit(JavaCoreBook book) {
        this.totalPrice += book.getPrice();
        System.out.println(book);
        System.out.println("Total price:" + totalPrice);



    }
}
