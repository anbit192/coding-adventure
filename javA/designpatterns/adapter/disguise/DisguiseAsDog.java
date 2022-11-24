package designpatterns.adapter.disguise;

public class DisguiseAsDog extends Dog {
    private Cat cat;

    public DisguiseAsDog(Cat cat) {
        super(cat.getName());
        this.cat = cat;
    }

    @Override
    public String makeNoise() {
        return "woof";
    }
}
