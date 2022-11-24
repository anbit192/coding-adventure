package designpatterns.strategy.skill;

public class ThunderboltSkill implements SkillStrategy {
    @Override
    public void useSkill(Character p1, Character p2) {
        System.out.printf("%s Struck %s \n", p1.getName(), p2.getName());
        p2.setHp(p2.getHp() - p1.getAtk() * 2);
    }
}
