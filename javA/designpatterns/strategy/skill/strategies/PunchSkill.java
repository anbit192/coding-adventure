package designpatterns.strategy.skill.strategies;

import designpatterns.strategy.skill.Character;

public class PunchSkill implements SkillStrategy {
    @Override
    public void useSkill(Character p1, Character p2) {
        System.out.printf("%s Punch %s !\n", p1.getName(), p2.getName());
        p2.setHp(p2.getHp() - p1.getAtk());
    }
}
