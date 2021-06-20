package ua.practice.app.entity;

import ua.practice.crud_library.BaseEntity;

import java.util.List;

public class Book extends BaseEntity{

    private String name;
//    private List<Author> authors;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
