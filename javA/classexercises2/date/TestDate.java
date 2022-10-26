package classexercises2.date;

public class TestDate {
    public static void main(String[] args) {
        MyDate birthday = new MyDate(2003,2,19);
        MyDate date1 = new MyDate(2012, 1,28);
        System.out.println(date1);
        System.out.println(birthday);

        System.out.println(birthday.previousDay());
        System.out.println(birthday.previousMonth());
        System.out.println(birthday.previousYear());

        System.out.println(date1);
        System.out.println(date1.nextDay());
        System.out.println(date1.nextMonth());
        date1.setMonth(3);
        System.out.println(date1.previousMonth().nextDay().nextDay());



    }
}
