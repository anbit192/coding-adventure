package designpatterns.visitor.computerpart.visitors;

import designpatterns.visitor.computerpart.elements.Computer;
import designpatterns.visitor.computerpart.elements.Keyboard;
import designpatterns.visitor.computerpart.elements.Monitor;
import designpatterns.visitor.computerpart.elements.Mouse;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor{
    @Override
    public void visit(Computer computer) {
        System.out.println("buy computer");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("buy mouse");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("buy keyboard");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("buy monitor");
    }
}
