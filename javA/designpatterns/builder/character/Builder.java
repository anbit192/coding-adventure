package designpatterns.builder.character;

public interface Builder {

    Builder reset();
    Builder setHP(int hp);
    Builder setATK(int atk);
    Builder setMP(int mp);
    Builder setSkill(Skill skill);

}
