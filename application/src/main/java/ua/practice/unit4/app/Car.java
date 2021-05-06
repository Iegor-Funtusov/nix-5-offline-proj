package ua.practice.unit4.app;

import ua.practice.unit4.lib.BaseEntity;

public class Car extends BaseEntity {
    private String brand;
    private String age;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Car{" + "ID= " + super.getId() +
                "brand='" + brand + '\'' +
                ", age=" + age +
                '}';
    }
}
