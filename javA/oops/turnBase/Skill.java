package oops.turnBase;

public class Skill {

    private String name;
    private int mpCost;
    private double atk;
    private double damagePerTurn;
    private int skillDuration;
    private int currentDuration;

    public Skill(String name, int mpCost, double atk, double damagePerTurn, int duration) {
        this.name = name;
        this.mpCost = mpCost;
        this.atk = atk;
        this.damagePerTurn = damagePerTurn;
        this.skillDuration = duration;
        this.currentDuration = duration;
    }

    public int getskillDuration() {
        return skillDuration;
    }

    public void setskillDuration(int duration) {
        this.skillDuration = duration;
    }

    public int getCurrentDuration() {
        return this.currentDuration;
    }

    public void setCurrentDuration(int duration) {
        this.currentDuration = duration;
    }

    public double getDamagePerTurn() {
        return damagePerTurn;
    }

    public void setDamagePerTurn(double damagePerTurn) {
        this.damagePerTurn = damagePerTurn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMpCost() {
        return mpCost;
    }

    public void setMpCost(int mpCost) {
        this.mpCost = mpCost;
    }

    public double getAtk() {
        return atk;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }
}
