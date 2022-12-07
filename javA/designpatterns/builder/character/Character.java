package designpatterns.builder.character;

public class Character {
    protected int hp;
    protected int atk;
    protected int mp;
    protected Skill skill;
    protected Effects debuff;
    protected Effects buff;
    protected int buffDuration;
    protected int debuffDuration;

    protected int cooldown;

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getBuffDuration() {
        return buffDuration;
    }

    public void setBuffDuration(int buffDuration) {
        this.buffDuration = buffDuration;
    }

    public int getDebuffDuration() {
        return debuffDuration;
    }

    public void setDebuffDuration(int debuffDuration) {
        this.debuffDuration = debuffDuration;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Effects getDebuff() {
        return debuff;
    }

    public void setDebuff(Effects debuff) {
        this.debuff = debuff;
    }

    public Effects getBuff() {
        return buff;
    }

    public void setBuff(Effects buff) {
        this.buff = buff;
    }

    public void hit(Character enemy) {
        enemy.hp -= this.atk;
    }


    @Override
    public String toString() {
        return "Character[" +
                "hp=" + hp +
                ", atk=" + atk +
                ", mp=" + mp +
                ", skill=" + skill.getClass().getSimpleName() +
                ", debuff=" + debuff +
                ", buff=" + buff +
                ", buffDuration=" + buffDuration +
                ", debuffDuration=" + debuffDuration +
                ']';
    }
}
