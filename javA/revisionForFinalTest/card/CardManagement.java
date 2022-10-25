package revisionForFinalTest.card;

import oops.car.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CardManagement {

    public ArrayList<Card> readData(String fileName) {
        ArrayList<Card> cards = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);

            int numberOfCard = Integer.parseInt(scan.nextLine());

            for (int i = 0; i<numberOfCard; i++) {
                int typeOfCard = Integer.parseInt(scan.nextLine());
                String id = scan.nextLine();
                int year = Integer.parseInt(scan.nextLine());
                double days = Double.parseDouble(scan.nextLine());
                double price = Double.parseDouble(scan.nextLine());

                if (typeOfCard == 0) {
                    double fee = Double.parseDouble(scan.nextLine());
                    StudentCard studentCard = new StudentCard(id, year, days, price, fee);
                    cards.add(studentCard);
                }

                else {
                    double tax = Double.parseDouble(scan.nextLine());
                    StaffCard staffCard = new StaffCard(id, year, days, price, tax);
                    cards.add(staffCard);
                }
            }

            scan.close();
        }
        catch (FileNotFoundException fnfe) {

        }

        return cards;
    }

    public void printArrayList(ArrayList<Card> cards) {
        for (int i = 0; i<cards.size(); i++) {
            System.out.println(cards.get(i).toString());
        }
    }

    public ArrayList<Card> findCards(ArrayList<Card> cards, int year) {
        ArrayList<Card> yearList = new ArrayList<>();

        for (int i = 0; i<cards.size();i++) {
            if (cards.get(i).getYear()==year) {
                yearList.add(cards.get(i));
            }
        }

        return yearList;
    }


    public ArrayList<Card> getMaxAmount(ArrayList<Card> cards, String typeOfCard) {
        ArrayList<Card> maxAmountList = new ArrayList<>();

        double max = cards.get(0).getAmount();
        for (int i = 0; i<cards.size();i++) {

            if (cards.get(i).getAmount()>max && cards.get(i).getClass().getName().equals(typeOfCard)) {
                max = cards.get(i).getAmount();
            }
        }

        for (int i = 0; i<cards.size();i++) {
            if (cards.get(i).getAmount()==max && cards.get(i).getClass().getName().equals(typeOfCard)) {
                maxAmountList.add(cards.get(i));
            }
        }

        return maxAmountList;
    }


    public void sortByAmount(ArrayList<Card> cards) {

        for (int i = 0; i<cards.size()-1;i++) {
            for (int j = i+1; j<cards.size();j++) {

                if (cards.get(i).getAmount()>cards.get(j).getAmount()) {
                    Card temp = cards.get(i);
                    cards.set(i, cards.get(j));
                    cards.set(j,temp);
                }
            }
        }
    }


    public static void main(String[] args) {

    }

}
