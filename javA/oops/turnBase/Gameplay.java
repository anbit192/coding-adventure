package oops.turnBase;

import java.util.Scanner;

public class Gameplay {

    public static void printStatus(Character foe, Character you) {

        System.out.printf("============\nYour HP: %.1f\nYour MP: %d\nYour def: %.1f\n============\nEnemy's HP: %.1f\nEnemy's MP: %d\nEnemy's Def: %.1f\n============\n", you.getHp(),you.getMp(),you.getDef(),foe.getHp(),foe.getMp(), foe.getDef());
    }

    public static void battle(Character you, Character foe) {

        Scanner scan = new Scanner(System.in);

        while (true) {

            if (you.getHp()<=0) {
                System.out.printf("%s win.\n", foe.getName());
                break;
            }

            else if (foe.getHp()<=0) {
                System.out.printf("%s win.\n", you.getName());
                break;
            }

            System.out.println("Your choice: ");

            int choice = Integer.parseInt(scan.nextLine());

            if (choice == 0) {
                you.useSkill(you.getSkillList().get(0), foe);
            }

            else if (choice == 1) {
                you.shield();
            }

            else if (choice == 2) {
                you.useSkill(you.getSkillList().get(1), foe);
            }

            else if (choice == 3) {
                you.useSkill(you.getSkillList().get(2), foe);
            }

            else {
                System.out.printf("Choice %d doesn't exist.\n", choice);
            }


            int foeChoice = (int) (Math.random() * 4);
            System.out.println("Foe's choice: ");
            System.out.println(foeChoice);

            if (foeChoice == 0) {
                foe.useSkill(foe.getSkillList().get(0), you);
            }

            else if (foeChoice == 1 ) {
                foe.shield();
            }

            else if (foeChoice == 2 ) {
                foe.useSkill(foe.getSkillList().get(1), you );
            }

            else {
                foe.useSkill(foe.getSkillList().get(2), you );
            }

            printStatus(foe, you);

            you.regenMP();
            foe.regenMP();

        }
    }

    public static void main(String[] args) {

        Gladiator character = new Gladiator("An");
        Mage foe = new Mage("asdasd");

       battle(character, foe);
    }


}
