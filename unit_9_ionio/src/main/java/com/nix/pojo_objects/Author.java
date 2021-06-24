package com.nix.pojo_objects;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private String firstName;
    private String id;
    private String lastName;
    private boolean visible = true;
    private List<Book> bookList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
