public class TimeMoment {

    private int hour;

    private int minute;

    static final int MINUTES_IN_HOUR = 60;

    public TimeMoment(){}

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public boolean equals(TimeMoment moment) {
        if (this.hour == moment.hour && this.minute == moment.minute)
            return true;
        else
            return false;
    }

    public boolean isEarly(TimeMoment moment) {
        if (this.hour < moment.hour)
            return true;
        else
            if (this.hour == moment.hour && this.minute < moment.minute)
            return true;

            return false;
    }

    public boolean isLater(TimeMoment moment) {

        if (this.hour > moment.hour)
            return true;
        else
        if (this.hour == moment.hour && this.minute > moment.minute)
            return true;

        return false;
    }



}
