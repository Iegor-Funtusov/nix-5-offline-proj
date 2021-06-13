package com.keyplate.project.app;

import com.keyplate.project.lib.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Student extends BaseEntity {
    private String name;
    private int age;

    public Student() {}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "id = " + getId() +  " name = " + name + " age = " + age;
    }
}
