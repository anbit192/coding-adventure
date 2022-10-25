package classexercises2.date;

public class TestTime {
    public static void main(String[] args) {
        MyTime time1 = new MyTime(23,58,58);
        System.out.println(time1);

        System.out.println(time1.nextSecond().nextSecond());

        time1.setTime(0,0,0);
        System.out.println(time1);
        System.out.println(time1.previousSecond());
        System.out.println(time1.previousMinute());
        System.out.println(time1.previousHour());
    }
}
