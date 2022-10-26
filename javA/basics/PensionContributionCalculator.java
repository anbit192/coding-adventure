package basics;

import java.util.Scanner;

public class PensionContributionCalculator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        final double SALARY_CEILING = 6000;
        final double EMPLOYEE_RATE_55_AND_BELOW = 0.2;
        final double EMPLOYER_RATE_55_AND_BELOW = 0.17;

        final double EMPLOYEE_RATE_55_TO_60 = 0.13;
        final double EMPLOYER_RATE_55_TO_60 = 0.13;

        final double EMPLOYEE_RATE_60_TO_65 = 0.075;
        final double EMPLOYER_RATE_60_TO_65 = 0.09;

        final double EMPLOYEE_RATE_65_AND_ABOVE = 0.05;
        final double EMPLOYER_RATE_65_AND_ABOVE = 0.075;


        double salary;
        int age;
        double employeeContribution;
        double employerContribution;

        while (true) {

            System.out.println("Enter salary: ");
            salary = scan.nextDouble();

            if (salary == -1) {
                break;
            }

            System.out.println("Enter age: ");
            age = scan.nextInt();


            if (salary > 6000) {
                salary = 6000;
            }

            if (age <= 55) {
                employeeContribution = salary * EMPLOYEE_RATE_55_AND_BELOW;
                employerContribution = salary * EMPLOYER_RATE_55_AND_BELOW;
            } else if (age > 55 && age <= 60) {
                employeeContribution = salary * EMPLOYEE_RATE_55_TO_60;
                employerContribution = salary * EMPLOYER_RATE_55_TO_60;
            } else if (age > 60 && age <= 65) {
                employeeContribution = salary * EMPLOYEE_RATE_60_TO_65;
                employerContribution = salary * EMPLOYER_RATE_60_TO_65;
            } else {
                employeeContribution = salary * EMPLOYEE_RATE_65_AND_ABOVE;
                employerContribution = salary * EMPLOYER_RATE_65_AND_ABOVE;
            }

            System.out.println("Employee's contribution: " + employeeContribution);
            System.out.println("Employer's contribution: " + employerContribution);
        }

    }
}
