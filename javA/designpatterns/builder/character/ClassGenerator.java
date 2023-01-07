package designpatterns.builder.character;

import designpatterns.builder.character.builders.Builder;
import designpatterns.builder.character.product.skills.IcyQuills;
import designpatterns.builder.character.product.skills.Rage;

public class ClassGenerator {

    private static ClassGenerator classGenerator;

    public static ClassGenerator getInstance() {
        if (classGenerator == null) {
            return new ClassGenerator();
        }

        return classGenerator;
    }

    public void Mage(Builder builder) {
        builder.reset().setHP(20).setATK(1).setMP(10).setSkill(new IcyQuills());
    }

    public void Warrior(Builder builder) {
        builder.reset().setHP(40).setATK(3).setMP(8).setSkill(new Rage());
    }
}
