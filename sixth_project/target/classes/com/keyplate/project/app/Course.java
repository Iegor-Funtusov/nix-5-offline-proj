package com.keyplate.project.app;

import com.keyplate.project.lib.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course extends BaseEntity {
    private String name;
    private int duration;

    public Course() {}

    public Course(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String toString() {
        return "id = " + getId() + " Name = " + name + " Duration = " + duration;
    }
}
