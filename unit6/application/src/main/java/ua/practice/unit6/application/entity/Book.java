package ua.practice.unit6.application.entity;

import ua.practice.unit6.application.library.BaseEntity;

public class Book extends BaseEntity {
    private String name;
    private int yearOfPublishing;

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + super.getId() + '\'' +
                "name='" + name + '\'' +
                ", yearOfPublishing='" + yearOfPublishing + '\'' +
                '}';
    }
}
