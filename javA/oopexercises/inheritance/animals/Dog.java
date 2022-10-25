package oopexercises.inheritance.animals;

public class Dog extends  Mammal {
    public Dog(String name) {
        super(name);
    }

    public void greets() {
        System.out.println("Sua");
    }

    public void greets(Dog other) {
        System.out.println("Sua sua");
    }

    @Override
    public String toString() {
        return String.format("Dog[%s]", super.toString());
    }
}
