package designpatterns.visitor.computerpart;

import designpatterns.visitor.computerpart.elements.*;
import designpatterns.visitor.computerpart.visitors.ComputerPartDisplayVisitor;
import designpatterns.visitor.computerpart.visitors.ComputerPartVisitor;

public class App {
    public static void main(String[] args) {
        ComputerPartVisitor visitor = new ComputerPartDisplayVisitor();
        ComputerPart computer = new Computer();
        ComputerPart mouse = new Mouse();
        ComputerPart keyboard = new Keyboard();
        ComputerPart monitor = new Monitor();

        computer.accept(visitor);
        mouse.accept(visitor);
        keyboard.accept(visitor);
        monitor.accept(visitor);
    }
}
