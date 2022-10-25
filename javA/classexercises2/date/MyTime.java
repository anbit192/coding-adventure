package classexercises2.date;

public class MyTime {
    private int hour;
    private int minute;
    private int second;

    public MyTime() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public MyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    private String getHourString(int hour) {
        if (hour < 10) {
            return String.format("%02d", hour);
        }

        return String.valueOf(hour);
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    private String getMinuteString(int minute) {
        if (minute < 10) {
            return String.format("%02d", minute);
        }

        return String.valueOf(minute);
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    private String getSecondString(int second) {
        if (second < 10) {
            return String.format("%02d", second);
        }

        return String.valueOf(second);
    }

    public void setTime(int hour, int minute, int second) {
        this.setHour(hour);
        this.setMinute(minute);
        this.setSecond(second);
    }

    public MyTime nextHour() {
        int nextHour = this.getHour() + 1;

        if (this.getHour() == 23) {
            nextHour = 0;
        }

        MyTime newTime = new MyTime(nextHour, this.getMinute(), this.getSecond());
        return newTime;
    }

    public MyTime nextMinute() {
        int nextMinute = this.getMinute() + 1;
        int nextHour = this.getHour();

        if (this.getMinute() == 59) {
            nextMinute = 0;
            nextHour = this.nextHour().getHour();
        }

        MyTime newTime = new MyTime(nextHour, nextMinute, this.getSecond());
        return newTime;
    }

    public MyTime nextSecond() {
        int nextSecond = this.getSecond() + 1;
        int nextMinute = this.getMinute();
        int nextHour = this.getHour();

        if (this.getSecond() == 59) {
            nextSecond = 0;
            nextMinute = this.nextMinute().getMinute();
            nextHour = this.nextMinute().getHour();
        }

        MyTime newTime = new MyTime(nextHour, nextMinute, nextSecond);
        return newTime;
    }

    public MyTime previousHour() {
        int prevHour = this.getHour() - 1;

        if (this.getHour() == 0) {
            prevHour = 23;
        }

        MyTime newTime = new MyTime(prevHour, this.getMinute(), this.getSecond());
        return newTime;
    }

    public MyTime previousMinute() {
        int prevMinute = this.getMinute() - 1;
        int prevHour = this.getHour();

        if (this.getMinute() == 0) {
            prevMinute = 59;
            prevHour = this.previousHour().getHour();
        }

        MyTime newTime = new MyTime(prevHour, prevMinute, this.getSecond());
        return newTime;
    }

    public MyTime previousSecond() {
        int prevSecond = this.getSecond() - 1;
        int prevMinute = this.getMinute();
        int prevHour = this.getHour();

        if (this.getHour() == 0) {
            prevSecond = 59;
            prevMinute = this.previousMinute().getMinute();
            prevHour = this.previousMinute().getHour();
        }

        MyTime newTime = new MyTime(prevHour, prevMinute, prevSecond);
        return newTime;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s", this.getHourString(this.getHour()), this.getMinuteString(this.getMinute()), this.getSecondString(this.getSecond()));
    }
}
