package classexercises2.date;

public class TestDate {
    public static void main(String[] args) {
        MyDate birthday = new MyDate(2003,2,19);
        MyDate date1 = new MyDate(2012, 2,29);
        System.out.println(date1);
        System.out.println(birthday);

        System.out.println(birthday.previousDay());
        System.out.println(birthday.previousMonth());
        System.out.println(birthday.previousYear());

        System.out.println(date1);
        System.out.println(date1.nextDay());

    }
}
