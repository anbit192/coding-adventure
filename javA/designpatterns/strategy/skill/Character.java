package designpatterns.strategy.skill;

public class Character {
    private String name;
    private double hp;
    private double atk;
    private SkillStrategy skill;

    public Character(double hp, double atk, String name) {
        this.hp = hp;
        this.atk = atk;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getAtk() {
        return atk;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public void setSkill(SkillStrategy skill) {
        this.skill = skill;
    }

    public void useSkill(Character enemy) {
        skill.useSkill(this, enemy);
    }

    @Override
    public String toString() {
        return String.format("%s[HP = %.2f, ATK = %.2f]", this.getName(), this.getHp(), this.getAtk());
    }
}
