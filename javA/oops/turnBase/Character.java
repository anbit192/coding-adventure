package oops.turnBase;

import java.util.ArrayList;

public class Character {

    private String name;
    private double hp;
    private double atk;
    private double def;
    private int mp;
    private double critDamage;
    private double critRate;
    private double evasionChance;
    private boolean hurt;
    private double attackModifier;
    private ArrayList<Skill> skillList = new ArrayList<>();
    private int buffDuration;
    private  int debuffDuration;


    public Character(String name) {
        this.name = name;
        this.hp = 50;
        this.atk = 5;
        this.def = 0;
        this.mp = 10;
        this.critDamage = 0;
        this.critRate = 0;
        this.evasionChance = 0;
        this.buffDuration = 0;
        this.debuffDuration = 0;
    }

    public Character(String name, double hp, double atk, double def, int mp, double critDamage, double critRate, double evasionChance) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.mp = mp;
        this.critDamage = critDamage;
        this.critRate = critRate;
        this.evasionChance = evasionChance;
        this.attackModifier = 0;
    }

    public ArrayList<Skill> getSkillList() {
        return skillList;
    }

    public void addSkill(Skill skill) {
        this.skillList.add(skill);
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

    public double getDef() {
        return def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public double getCritDamage() {
        return critDamage;
    }

    public void setCritDamage(double critDamage) {
        this.critDamage = critDamage;
    }

    public double getCritRate() {
        return critRate;
    }

    public void setCritRate(double critRate) {
        this.critRate = critRate;
    }

    public double getEvasionChance() {
        return evasionChance;
    }

    public void setEvasionChance(double evasionChance) {
        this.evasionChance = evasionChance;
    }

    public boolean isHurt() {
        return hurt;
    }

    public void setHurt(boolean hurt) {
        this.hurt = hurt;
    }

    public double getDamage(Skill skill, Character foe) {

        double damage = (skill.getAtk()-foe.getDef()+this.getAttackModifier());

        if (damage <= 0) {
            return 0;
        }

        return damage;
    }


    public int getBuffDuration() {
        return this.buffDuration;
    }

    public void setBuffDuration(int buffDuration) {
        this.buffDuration = buffDuration;
    }

    public int getDebuffDuration() {
        return this.debuffDuration;
    }

    public void setDebuffDuration(int debuffDuration) {
        this.debuffDuration = debuffDuration;
    }

    public void deductBuffDuration() {
        if (this.getBuffDuration()>0) {
            this.setBuffDuration(this.getBuffDuration()-1);
        }
    }

    public void deductDebuffDuration() {
        if (this.getDebuffDuration() >0) {
            this.setDebuffDuration(this.getDebuffDuration()-1);
        }
    }


    public double getAttackModifier() {
        return this.attackModifier;
    }

    public void setAttackModifier(double amount) {
        this.attackModifier = amount;
    }


    public void shield() {

        if (this.getMp()>=6) {
            System.out.printf("%s gained 3 defend.\n", this.getName());
            this.setDef(3);
            this.setMp(this.getMp()-6);
        }

        else {

            System.out.println("Not enough MP!");
        }
    }

    public void useSkill(Skill skill, Character foe) {

    }


    public void passive(Skill skill,Character foe) {

    }

    public void regenMP() {
        if (this.getMp()<=8) {
            this.setMp(this.getMp()+2);
        }
    }

    public void deductMP(Skill skill) {

        this.setMp(this.getMp()-skill.getMpCost());
    }

    public void deductDef(double damage) {
        if (damage > 0) {
            this.setHurt(true);
            this.setDef(0);
        }

        else {
            this.setHurt(false);
            this.setDef(this.getDef()-damage);
        }
    }

}
