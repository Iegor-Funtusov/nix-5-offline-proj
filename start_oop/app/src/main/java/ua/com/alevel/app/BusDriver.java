package ua.com.alevel.app;

import ua.com.alevel.lib.BaseEntity;

public class BusDriver extends BaseEntity {

    private int age;
    private String name;
    private String color;

    public BusDriver(int age, String name, String color) {
        this.age = age;
        this.name = name;
        this.color = color;
    }

    public String getBusColor() {
        return color;
    }

    public void setBusColor(String busColor) {
        this.color = busColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BusDriver{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
