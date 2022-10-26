package polymorphism.animal;

public class BigDog extends Dog {
    public BigDog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("sua");
    }

    @Override
    public void greets(Dog another) {
        System.out.println("sua gau gau");
    }

    public void greets(BigDog another) {
        System.out.println("sua sua sua");
    }
}
