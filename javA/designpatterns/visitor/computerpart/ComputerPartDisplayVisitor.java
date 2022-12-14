package designpatterns.visitor.computerpart;

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
