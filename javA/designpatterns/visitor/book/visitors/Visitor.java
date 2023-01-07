package designpatterns.visitor.book.visitors;

import designpatterns.visitor.book.elements.BusinessBook;
import designpatterns.visitor.book.elements.DesignPatternBook;
import designpatterns.visitor.book.elements.JavaCoreBook;

public interface Visitor {

    void visit(BusinessBook book);
    void visit(DesignPatternBook book);
    void visit(JavaCoreBook book);
}
