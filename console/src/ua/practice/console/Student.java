package ua.practice.console;

import org.apache.commons.lang3.StringUtils;

public class Student extends Person{

    public Student(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String getName() {
        return "ua.practice.console.Student: " + StringUtils.upperCase(this.name) + " " + this.lastName + " Age: " + this.age;
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }
}
