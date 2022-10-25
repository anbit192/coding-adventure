package MoreExercises;

import java.util.Scanner;

public class DateUtil {

    public static int[] inputDate(Scanner scan) {
        int[] ddmmyy = new int[3];

        String input = scan.next();
        String[] splitString = input.split("/");
        for (int i = 0; i < splitString.length; i++) {
            ddmmyy[i] = Integer.valueOf(splitString[i]);
        }

        return ddmmyy;
    }

    public static String[] generateDaysInWeeks() {
        String[] daysOfWeeks = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};

        return daysOfWeeks;
    }

    public static String[] generateMonths() {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return months;

    }

    public static int[] generateDays(int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            days[1] = 29;
        }

        return days;
    }

    public static boolean isValid(int day, int month, int year) {
        int[] days = generateDays(year);

        if (month < 0 || month > 11) {
            return false;
        } else if (day <= 0 || day > days[month]) {
            return false;
        } else if (year <= 0 || year > 9999) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 == 0 && year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }

    public static int getDayOfweek(int year, int month, int day) {
        
        int[] twoYearDigit = {4, 2, 0, 6};
        int newYear = year / 100;
        int key1 = 0;
        for (int i = 0; i < 4; i++) {
            if (((newYear - i) % 4) == 1) {
                key1 = twoYearDigit[i];
            }
        }
        int[][] monthTable = {
                {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5},
                {6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5}
        };
        int key2 = 0;
        if (isLeapYear(year)) {
            key2 = monthTable[1][month - 1];
        }
        if (isLeapYear(year) == false) {
            key2 = monthTable[0][month - 1];
        }
        int output = (key1 + year % 100 + (year % 100) / 4 + key2 + day) % 7;
        return output;
    }

    public static void printDate(int year, int month, int day) {
        String[] daysInWeek = generateDaysInWeeks();

        System.out.printf("%s %d %d %d", daysInWeek[getDayOfweek(year, month, day)], year, month, day);

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dates;
        while (true) {
            dates = inputDate(scan);
            if (isValid(dates[0], dates[1], dates[2])) {
                break;
            } else {
                System.out.println("Invalid date!");
            }
        }

        printDate(dates[0], dates[1], dates[2]);


    }
}
