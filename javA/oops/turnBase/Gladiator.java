package oops.turnBase;

public class Gladiator extends Character {

    private Skill normalSkill = new Skill("Throw Sword", 2, 4,0,0);
    private Skill ultimate = new Skill("Beserk", 10, 0,0,2);
    private Skill basicAttack = new Skill("Basic Attack", 0, this.getAtk(),0,0);

    public Gladiator(String name) {
        super(name);
        this.addSkill(basicAttack);
        this.addSkill(normalSkill);
        this.addSkill(ultimate);
    }


    public Skill getNormalSkill() {
        return normalSkill;
    }

    public Skill getUltimate() {
        return ultimate;
    }

    @Override
    public void passive(Skill skill,Character foe) {
        if (foe.isHurt()) {
            System.out.printf("%s's atk increased by 1.\n", this.getName());
            skill.setAtk(skill.getAtk()+1);
        }
    }

    @Override
    public void useSkill(Skill skill, Character foe) {


        if (this.getBuffDuration() > 0) {
            this.setAttackModifier(skill.getAtk());
            this.deductBuffDuration();
        }

        else if (this.getBuffDuration() == 0) {
            this.setAttackModifier(0);
        }

        double damage = this.getDamage(skill, foe);


        if (this.getMp()>=skill.getMpCost()) {

            if (skill.getName().equals("Beserk")) {

                this.setAttackModifier(skill.getAtk());
                System.out.printf("%s used %s.\n",this.getName(), skill.getName());
                System.out.printf("%s's atk is multiplied by 2 for 2 turns.\n", this.getName());
                this.setBuffDuration(skill.getskillDuration());
                System.out.println(skill.getCurrentDuration());

            }

            else if (skill.getName().equals("Throw Sword")) {

                System.out.printf("%s used %s, the sword pierced through defense.\n", this.getName(),skill.getName());
                System.out.printf("%s lost %.1f HP.\n", foe.getName(), skill.getAtk());
                foe.setHp(foe.getHp() - skill.getAtk());
            }

            else if (skill.getName().equals("Basic Attack")) {

                System.out.printf("%s dealt %.1f damage to %s\n", this.getName(), damage, foe.getName());
                foe.setHp(foe.getHp() - damage);

            }

        }

        else {
            System.out.println("Not enough MP!");
        }

        foe.deductDef(damage);

        if (foe.isHurt()) {
            this.passive(skill, foe);
        }

        this.deductMP(skill);


    }
}
