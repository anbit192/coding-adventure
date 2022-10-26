package polymorphism.animal;

public class TestAnimal {
    public static void main(String[] args) {
        Cat cat1 = new Cat("non");
        cat1.greets();
        Dog dog1 = new Dog("ho");
        dog1.greets();
        BigDog bigDog1 = new BigDog("amksladmlaskdm");
        bigDog1.greets();


        Animal animal1 = new Cat("a");
        animal1.greets();
        Animal animal2 = new Dog("b ");
        animal2.greets();
        Animal animal3 = new BigDog("c");
        animal3.greets();

        Dog dog2 = (Dog) animal2;
        BigDog bigDog2 = (BigDog) animal3;

        bigDog2.greets(dog2);
        bigDog2.greets(bigDog1);
    }
}
