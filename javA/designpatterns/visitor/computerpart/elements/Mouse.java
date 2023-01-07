package designpatterns.visitor.computerpart.elements;

import designpatterns.visitor.computerpart.visitors.ComputerPartVisitor;

public class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}
