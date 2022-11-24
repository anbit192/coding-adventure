package designpatterns.adapter.disguise;

public class Party {
    public static void main(String[] args) {
        DogHouse dogHouse = new DogHouse();
        Cat cat = new Cat("Shironeko");
        Dog dog = new Dog("Taroumarou");

        dogHouse.getInHouse(dog);

        Dog disguisedCat = new DisguiseAsDog(cat);
        dogHouse.getInHouse(disguisedCat);

        System.out.println("Current members: ");
        dogHouse.printMember();

    }
}
