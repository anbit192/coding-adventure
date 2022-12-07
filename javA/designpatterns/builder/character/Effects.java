package designpatterns.builder.character;

public abstract class Effects {
    protected int duration;
    protected int damagePerTurn;
    protected int initialDamage;

    public abstract void effect(Character character);

}
