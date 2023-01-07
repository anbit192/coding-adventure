package designpatterns.builder.character.product.skills;

import designpatterns.builder.character.product.Character;

public abstract class Skill {

    protected int skillDamg;
    protected int skillMP;
    protected int skillCD;

    protected int skillDuration;

    public int getSkillDuration() {
        return skillDuration;
    }

    public void setSkillDuration(int skillDuration) {
        this.skillDuration = skillDuration;
    }

    public int getSkillDamg() {
        return skillDamg;
    }

    public void setSkillDamg(int skillDamg) {
        this.skillDamg = skillDamg;
    }

    public int getSkillMP() {
        return skillMP;
    }

    public void setSkillMP(int skillMP) {
        this.skillMP = skillMP;
    }

    public int getSkillCD() {
        return skillCD;
    }

    public void setSkillCD(int skillCD) {
        this.skillCD = skillCD;
    }
    public abstract void skillEffects(Character character);
}
