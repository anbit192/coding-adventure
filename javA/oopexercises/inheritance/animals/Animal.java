package oopexercises.inheritance.animals;

public class Animal {
    protected String name;


    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void greets() {
        System.out.println();
    }

    public void greets(Dog other) {
        System.out.println();
    }

    public String toString() {
        return String.format("Animal[name = %s]", this.getName());
    }
}
