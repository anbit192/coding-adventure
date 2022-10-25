package revisionForFinalTest.motorbike;

import java.util.ArrayList;
import java.util.Scanner;

public class MotorbikeManagement {

    public static void inputMotorbike(ArrayList<Motorbike> motorbikes , int n, Scanner scan) {

        for (int i = 0; i<n; i++) {
            String id = scan.nextLine();
            String name = scan.nextLine();
            String manu = scan.nextLine();
            int quantity = Integer.parseInt(scan.nextLine());
            double price = Double.parseDouble(scan.nextLine());
            double weight = Double.parseDouble(scan.nextLine());
            String date = scan.nextLine();

            Motorbike motorbike = new Motorbike(id, name, manu, quantity, price, weight, date);
            motorbikes.add(motorbike);
        }
    }

    public static void outputMotorbike(ArrayList<Motorbike> motorbikes) {
        for (int i = 0; i<motorbikes.size();i++) {
            motorbikes.get(i).printMotorbike();
        }
    }

    public static ArrayList<Motorbike> search(String manu, ArrayList<Motorbike> motorbikes) {

        ArrayList<Motorbike> manuList = new ArrayList<>();

        for (int i = 0; i<motorbikes.size();i++) {
            if (motorbikes.get(i).getManu().equals(manu)) {
                manuList.add(motorbikes.get(i));
            }
        }

        return manuList;
    }

    public static ArrayList<Motorbike> maxWeight(ArrayList<Motorbike> motorbikes) {
        ArrayList<Motorbike> maxWeight = new ArrayList<>();
        double max = motorbikes.get(0).getWeight();

        for (int i = 0 ; i<motorbikes.size(); i++) {
            if (motorbikes.get(i).getWeight()>max) {
                max = motorbikes.get(i).getWeight();
            }
        }

        for (int i = 0; i<motorbikes.size(); i++) {
            if (motorbikes.get(i).getWeight()==max) {
                maxWeight.add(motorbikes.get(i));
            }
        }

        return maxWeight;
    }

    public static ArrayList<Motorbike> minQuantity(ArrayList<Motorbike> motorbikes) {
        ArrayList<Motorbike> minList = new ArrayList<>();
        int min = motorbikes.get(0).getQuantity();

        for (int i = 0; i < motorbikes.size();i++) {
            if (motorbikes.get(i).getQuantity()<min) {
                min = motorbikes.get(i).getQuantity();
            }
        }

        for (int i = 0; i<motorbikes.size();i++) {
            if (motorbikes.get(i).getQuantity() == min) {
                minList.add(motorbikes.get(i));
            }
        }

        return minList;
    }

    public static void main(String[] args) {

    }
}
