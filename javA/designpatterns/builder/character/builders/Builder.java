package designpatterns.builder.character.builders;

import designpatterns.builder.character.product.skills.Skill;

public interface Builder {

    Builder reset();
    Builder setHP(int hp);
    Builder setATK(int atk);
    Builder setMP(int mp);
    Builder setSkill(Skill skill);

}
