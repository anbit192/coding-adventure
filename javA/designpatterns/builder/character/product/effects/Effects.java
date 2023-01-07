package designpatterns.builder.character.product.effects;

import designpatterns.builder.character.product.Character;

public abstract class Effects {
    protected int duration;
    protected int damagePerTurn;
    protected int initialDamage;

    public abstract void effect(Character character);

}
