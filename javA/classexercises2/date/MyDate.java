package classexercises2.date;

import java.util.Calendar;

public class MyDate {
    public final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public final String[] DAYS_IN_WEEK = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
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

    public int[] generateDays(int year) {

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            days[1] = 29;
        }

        return days;
    }

    public boolean isValid(int day, int month, int year) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private String getDayString(int day) {
        if (day < 10) {
            return String.format("%02d", day);
        }

        return String.valueOf(day);
    }

    public String getDayOfWeek(int year, int month, int day) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DATE, day);
        calendar.set(Calendar.MONTH, month - 1);

        return DAYS_IN_WEEK[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    public MyDate nextYear() {
        int nextYear = this.getYear() + 1;

        return new MyDate(nextYear, this.getMonth(), this.getDay());
    }

    public MyDate nextMonth() {

        int[] daysMonth = generateDays(this.getYear());

        int nextMonth = this.getMonth() + 1;
        int nextYear = this.getYear();
        int nextDay = this.getDay();

        if (this.getMonth() == 11) {
            nextMonth = 0;
            nextYear = this.nextYear().getYear();
        } else if (this.getDay() == daysMonth[this.getMonth() - 1]) {
            nextDay = daysMonth[nextMonth - 1];
        }

        return new MyDate(nextYear, nextMonth, nextDay);
    }

    public MyDate nextDay() {

        int[] days_max = generateDays(this.getYear());

        int nextDay = this.getDay() + 1;
        int nextMonth = this.getMonth();
        int nextYear = this.getYear();

        if (this.getDay() == days_max[this.getMonth() - 1]) {
            nextDay = 1;
            nextMonth = this.nextMonth().getMonth();
            nextYear = this.nextMonth().getYear();
        }

        return new MyDate(nextYear, nextMonth, nextDay);
    }

    public MyDate previousYear() {
        int prevYear = this.getYear() - 1;

        return new MyDate(prevYear, this.getMonth(), this.getDay());
    }

    public MyDate previousMonth() {

        int[] daysMonth = generateDays(this.getYear());

        int prevMonth = this.getMonth() - 1;
        int prevYear = this.getYear();
        int prevDay = this.getDay();

        if (this.getMonth() <= 1) {
            prevMonth = 12;
            prevYear = this.previousYear().getYear();
        } else if (this.getDay() == daysMonth[this.getMonth() - 1]) {
            prevDay = daysMonth[prevMonth - 1];
        }


        return new MyDate(prevYear, prevMonth, prevDay);
    }

    public MyDate previousDay() {
        int[] days_max = generateDays(this.getYear());

        int prevDay = this.getDay() - 1;
        int prevMonth = this.getMonth();
        int prevYear = this.getYear();

        if (this.getDay() == 1) {
            prevMonth = this.previousMonth().getMonth(); //1 -> 12
            prevDay = days_max[prevMonth - 1]; //
            prevYear = this.previousMonth().getYear();
        }

        return new MyDate(prevYear, prevMonth, prevDay);
    }

    @Override
    public String toString() {
        return String.format("%s, %s %s %d", this.getDayOfWeek(this.getYear(), this.getMonth(), this.getDay()), this.getDayString(this.getDay()), MONTHS[this.getMonth() - 1], this.getYear());
    }


}
