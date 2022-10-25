package oops.turnBase;

public class Mage extends Character {

    private Skill basicAttack = new Skill("Basic Attack", 0,this.getAtk(),0,0);
    private Skill normalSkill = new Skill("Wes Wes Quas", 5, 8,2, 2);
    private Skill ultimate = new Skill("Wes Wes Wes", 20, 10,0, 0);

    public Mage(String name) {
        super(name);
        this.setAtk(4);
        this.setMp(20);
        this.setHp(30);
        this.addSkill(basicAttack);
        this.addSkill(normalSkill);
        this.addSkill(ultimate);
    }


    @Override
    public void useSkill(Skill skill, Character foe) {

        if (foe.getDebuffDuration() > 0) {
            System.out.printf("%s takes $1.f damage from %s skill.", foe.getName(),skill.getDamagePerTurn(),skill.getName());
            foe.setHp(foe.getHp()-skill.getDamagePerTurn());
            foe.deductDebuffDuration();
        }

        double damage = this.getDamage(skill, foe);

        if (skill.getName().equals("Wes Wes Quas") && this.getMp()>=skill.getMpCost()) {

            foe.setHp(foe.getHp()-damage);
            foe.setDebuffDuration(2);
        }

        else if (skill.getName().equals("Wes Wes Wes") && this.getMp()>=skill.getMpCost()) {

            this.setAttackModifier(foe.getMp()/2);
            foe.setHp(foe.getHp()-this.getDamage(skill, foe));
            this.setAttackModifier(0);

            this.setMp(foe.getMp()/2 + this.getMp());
            foe.setMp(0);
        }

        deductDef(damage);
    }

    @Override
    public void regenMP() {
        if (this.getMp()<=16) {
            this.setMp(this.getMp()+4);
        }
    }


}
