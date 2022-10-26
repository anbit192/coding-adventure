package polymorphism.animal;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("gau gau");
    }

    public void greets(Dog another) {
        System.out.println("gaaaaaau");
    }
}
