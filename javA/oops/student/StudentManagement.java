package oops.student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {


    public static ArrayList<Student> readData(String fileName) {

        ArrayList<Student> students = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);

            int numberOfStudents = Integer.parseInt(scan.nextLine());

            for (int i = 0; i<numberOfStudents; i++) {

                int number =Integer.parseInt(scan.nextLine());
                String id = scan.nextLine();
                String name = scan.nextLine();
                int age = Integer.parseInt(scan.nextLine());
                String email = scan.nextLine();
                double gpa = Double.parseDouble(scan.nextLine());
                int noPublications = Integer.parseInt(scan.nextLine());

                if (number == 0) {
                    PhDStudent phDStudent = new PhDStudent(id, name, age, email, gpa, noPublications);
                    students.add(phDStudent);
                }

                else {
                    MasterStudent masterStudent = new MasterStudent(id, name, age, email, gpa, noPublications);
                    students.add(masterStudent);
                }
            }

            scan.close();
        }

        catch (FileNotFoundException fnfe) {
            System.out.println("File not found!");
        }

        return students;
    }


    public static void printInfo(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static void sortByBonus(ArrayList<Student> students) {

        for (int i = 0; i<students.size();i++) {
            for (int j = 0; j<students.size(); j++) {

                if (students.get(i).getBonus() < students.get(j).getBonus()) {
                    Student temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
    }

    public static ArrayList<Student> filterMasterByBonus(ArrayList<Student> students, String faculty) {

        double sum = 0;
        double average;
        ArrayList<MasterStudent> masterStudents = new ArrayList<>();
        ArrayList<Student> result = new ArrayList<>();


        for (Student student : students) {

            if (student.getClass().getName().equals("oops.student.MasterStudent") && student.getFaculty().equals(faculty)) {
                masterStudents.add((MasterStudent) student);
            }
        }

        for (MasterStudent student : masterStudents) {
            sum += student.getBonus();
        }

        System.out.println("Average bonus :");
        average = sum / (double) masterStudents.size();
        System.out.println(average);


        for (MasterStudent student : masterStudents) {
            if (student.getBonus() > average) {
                result.add(student);
            }
        }

        sortByBonus(result);

        return result;
    }

    public static ArrayList<Student> filterPhDByNoPub(ArrayList<Student> students) {

        ArrayList<Student> result = new ArrayList<>();
        int sum=0;
        double average;

        for (Student student : students) {
            if (student.getClass().getName().equals("oops.student.MasterStudent")) {

                sum += ((MasterStudent) student ).getNoPublications();
            }

            else if (student.getClass().getName().equals("oops.student.PhDStudent")) {
                sum += ((PhDStudent) student).getNoPublications();
            }
        }

        System.out.println("Average publications: ");
        average = sum / students.size();
        System.out.println(average);


        for (Student student : students) {
            if (student.getClass().getName().equals("oops.student.PhDStudent") && ((PhDStudent) student).getNoPublications() > average) {
                result.add(student);
            }
        }

        for (int i = 0; i<result.size()-1;i++) {
            for (int j = i+1; j<result.size(); j++) {

                if ( ((PhDStudent) result.get(i)).getNoPublications() < ((PhDStudent) result.get(j)).getNoPublications()) {

                    Student temp = result.get(i);
                    result.set(i, result.get(j));
                    result.set(j, temp);
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {

        ArrayList<Student> students = readData("C:\\Users\\minha\\Desktop\\Tai lieu hoc tap\\THJava\\oops\\student\\student");
        System.out.println("All students :");
        printInfo(students);

        System.out.println("Sort PhD Students: ");
        printInfo(filterPhDByNoPub(students));

        System.out.println("Sort Master Student: ");
        printInfo(filterMasterByBonus(students, "Social Science"));
    }
}
