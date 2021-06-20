package obj;

import java.util.Objects;

public class Time implements Comparable<Time> {

    private Integer hours;
    private Integer mins;
    private Integer secs;

    public Time() {
        hours = 0;
        mins = 0;
        secs = 0;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMins() {
        return mins;
    }

    public void setMins(Integer mins) {
        this.mins = mins;
    }

    public Integer getSecs() {
        return secs;
    }

    public void setSecs(Integer secs) {
        this.secs = secs;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hours=" + hours +
                ", minutes=" + mins +
                ", seconds=" + secs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hours.equals(time.hours) && mins.equals(time.mins) && secs.equals(time.secs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, mins, secs);
    }

    @Override
    public int compareTo(Time o) {
        int result = this.getHours().compareTo(o.getHours());
        if (result == 0) {
            result = this.getMins().compareTo(o.getMins());
            if (result == 0) {
                result = this.getSecs().compareTo(o.getSecs());
            }
        }
        return result;
    }
}
