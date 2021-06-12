package ua.practice.unit6.application.entity;

import ua.practice.unit6.application.library.BaseEntity;

public class Author extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Author{ ID = '" + super.getId() + '\'' +
                " name='" + name + '\'' +
                '}';
    }
}
