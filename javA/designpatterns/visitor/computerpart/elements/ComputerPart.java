package designpatterns.visitor.computerpart.elements;

import designpatterns.visitor.computerpart.visitors.ComputerPartVisitor;

public interface ComputerPart {

    void accept(ComputerPartVisitor visitor);
}
