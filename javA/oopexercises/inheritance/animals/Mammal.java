package oopexercises.inheritance.animals;

public class Mammal extends Animal {
    public Mammal(String name) {
        super(name);
    }

    public String toString() {
        return String.format("Mammal[%s]", super.toString());
    }
}
