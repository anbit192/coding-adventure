package designpatterns.visitor.computerpart;

public interface ComputerPart {

    void accept(ComputerPartVisitor visitor);
}
