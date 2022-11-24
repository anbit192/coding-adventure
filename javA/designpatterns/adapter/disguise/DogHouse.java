package designpatterns.adapter.disguise;

import java.util.ArrayList;

public class DogHouse {

    private ArrayList<Dog> houseMember;

    public DogHouse() {
        this.houseMember = new ArrayList<>();
    }

    public boolean isDog(Dog dog) {
        return dog.makeNoise().equalsIgnoreCase("woof");
    }

    public void getInHouse(Dog dog) {
        System.out.println(dog.getName());
        if (isDog(dog)) {
            houseMember.add(dog);
            System.out.println("Welcome!");
        } else {
            System.out.println("Get out!");

        }
    }

    public void printMember() {
        for (Dog dog : this.houseMember) {
            System.out.println(dog.getName() + " ");
        }
        System.out.println();
    }
}
