package oop.fraction;

import java.util.ArrayList;
import java.util.List;

public class TestFraction {
    private List<Fraction> fractions;

    public TestFraction() {
        fractions = new ArrayList<>();
    }

    public static void main(String[] args) {
        TestFraction fractionTest = new TestFraction();
        fractionTest.generateRandomList();
        print(fractionTest.fractions);
        print(sortByDenominator(fractionTest.fractions));
        print(sortByValue(fractionTest.fractions));
        System.out.println(secondLargestFraction(fractionTest.fractions));
    }

    public void generateRandomList() {
        for (int i = 0; i < 30; i++) {
            fractions.add(new Fraction(generateRandomNumber(1000), generateRandomNumber(1000)));
        }
    }

    public static int generateRandomNumber(int max) {
        int randomNumber = 0;

        while (randomNumber == 0) {
            randomNumber = (int) ((Math.random()) * max);
        }

        return randomNumber;
    }

    public static void print(List<Fraction> fractions) {
        for (Fraction fraction : fractions) {
            System.out.print(fraction + " ");
        }
        System.out.println();
    }

    public static List<Fraction> sortByValue(List<Fraction> fractions) {

        List<Fraction> sortedFractions = new ArrayList<>(fractions);

        for (int i = 0; i < sortedFractions.size(); i++) {
            for (int j = 0; j < sortedFractions.size() - 1; j++) {
                if (sortedFractions.get(j).compareTo(sortedFractions.get(j + 1)) == 1) {
                    Fraction temp = sortedFractions.get(j);
                    sortedFractions.set(j, sortedFractions.get(j + 1));
                    sortedFractions.set(j + 1, temp);
                }
            }
        }

        return sortedFractions;
    }

    public static List<Fraction> sortByDenominator(List<Fraction> fractions) {
        List<Fraction> sortedFractions = new ArrayList<>(fractions);

        for (int i = 0; i < sortedFractions.size(); i++) {
            for (int j = 1; j < sortedFractions.size(); j++) {
                if (sortedFractions.get(j).getDenominator() < sortedFractions.get(j - 1).getDenominator()) {
                    Fraction temp = sortedFractions.get(j);
                    sortedFractions.set(j, sortedFractions.get(j - 1));
                    sortedFractions.set(j - 1, temp);
                }
            }
        }

        return sortedFractions;
    }

    public static Fraction secondLargestFraction(List<Fraction> fractions) {
        List<Fraction> sortDecreasingFraction = new ArrayList<>(fractions);

        for (int i = 0; i < sortDecreasingFraction.size(); i++) {
            for (int j = 0; j < sortDecreasingFraction.size() - 1; j++) {
                if (sortDecreasingFraction.get(j).compareTo(sortDecreasingFraction.get(j + 1)) == -1) {
                    Fraction temp = sortDecreasingFraction.get(j);
                    sortDecreasingFraction.set(j, sortDecreasingFraction.get(j + 1));
                    sortDecreasingFraction.set(j + 1, temp);
                }
            }
        }

        return sortDecreasingFraction.get(1);
    }
}
