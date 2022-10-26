package basicrevision.baby;

import java.util.Scanner;

public class BabyManagement {

    public static Baby[] createData(Scanner scan) {

        System.out.println("Enter number of babies: ");
        int n = Integer.parseInt(scan.nextLine());

        Baby[] babies = new Baby[n];

        for (int i = 0; i<n; i++) {
            System.out.println("Enter baby's name: ");
            String name = scan.nextLine();
            System.out.println("Enter date of birth: ");
            String day = scan.nextLine();
            System.out.println("Enter gender: ");
            Boolean gender = Boolean.parseBoolean(scan.nextLine());
            System.out.println("Enter weight: ");
            Double weight = Double.parseDouble(scan.nextLine());
            System.out.println("Enter height: ");
            Double height = Double.parseDouble(scan.nextLine());

            Baby baby = new Baby(name, day, gender, weight, height);
            babies[i] = baby;
        }

        return babies;
    }

    public static void printInfoBabies(Baby[] babies) {
        for (Baby baby : babies) {
            System.out.println(baby.toString());
        }
    }

    public static void sortWeight(Baby[] babies) {
        boolean check = false;
        while (check==false) {

            check = true;

            for (int i = 0; i<babies.length-1;i++) {
                if (babies[i].getWeight()<babies[i+1].getWeight()) {
                    check=false;
                    Baby temp = babies[i];
                    babies[i] = babies[i+1];
                    babies[i+1] = temp;
                }
            }
        }
    }

    public static void filterGender(Baby[] babies, String gender) {
        for (Baby baby : babies) {
            if (baby.getGender().equals(gender)) {
                System.out.println(baby.toString());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Baby[] babies = createData(scan);

        System.out.println("unsort: ");
        printInfoBabies(babies);

        System.out.println("sort babies :");
        sortWeight(babies);
        printInfoBabies(babies);

        filterGender(babies, "Boy");

    }
}
