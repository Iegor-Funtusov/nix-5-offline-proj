package com.nixsolutions.courses.obj;

import java.util.Objects;
import java.util.Arrays;

public class Course {

    private String name;
    private final int SIZE;
    private Student[] list;

    public Course(int SIZE) {
        this.SIZE = SIZE;
        list = new Student[SIZE];
    }

    public int getSIZE() {
        return SIZE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getList() {
        return list;
    }

    public void setList(Student[] list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Course [" +
                "Name='" + name + '\'' +
                ", SIZE=" + SIZE +
                ", List=" + Arrays
                .toString(Arrays.stream(list)
                .filter(Objects::nonNull)
                .toArray(Student[]::new)) + ']';
    }
}
