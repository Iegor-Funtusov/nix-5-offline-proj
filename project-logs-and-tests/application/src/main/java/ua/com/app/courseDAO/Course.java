package ua.com.app.courseDAO;

import ua.com.lib.Entity;

public class Course extends Entity {
    private String title;
    private int duration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + getId() + '\'' +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
