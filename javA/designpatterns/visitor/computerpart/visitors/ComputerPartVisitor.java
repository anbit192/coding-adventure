package designpatterns.visitor.computerpart.visitors;

import designpatterns.visitor.computerpart.elements.Computer;
import designpatterns.visitor.computerpart.elements.Keyboard;
import designpatterns.visitor.computerpart.elements.Monitor;
import designpatterns.visitor.computerpart.elements.Mouse;

public interface ComputerPartVisitor {
    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);
}
