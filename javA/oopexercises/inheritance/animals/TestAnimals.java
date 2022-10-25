package oopexercises.inheritance.animals;

public class TestAnimals {
    public static void main(String[] args) {
        Animal animal1 = new Cat("chin chin");
        Animal animal2 = new Dog("courage");
        Dog dog2 = new Dog("Sua");

        System.out.println(animal2);
        System.out.println(animal1);

        animal2.greets();
        animal1.greets();
        dog2.greets((Dog)animal2);
    }
}
