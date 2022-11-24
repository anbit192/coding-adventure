package designpatterns.strategy.skill;

public class Gameplay {

    public static void main(String[] args) {
        Character an = new Character(100, 10, "An");
        Character thai = new Character(50, 5, "Thai");
        System.out.println(an);
        System.out.println(thai);
        an.setSkill(new ThunderboltSkill());
        an.useSkill(thai);

        System.out.println(thai);

        thai.setSkill(new PunchSkill());
        thai.useSkill(an);
        System.out.println(an);
    }


}
