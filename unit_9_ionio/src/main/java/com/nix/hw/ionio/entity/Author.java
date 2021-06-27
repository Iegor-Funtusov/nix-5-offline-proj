package com.nix.hw.ionio.entity;

import java.util.List;
import java.util.stream.Collectors;

public class Author extends BaseEntity{

    private String firstName;
    private String lastName;
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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

    @Override
    public String toString() {
        return "Author{" +
                "id='" + getId() + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=[" + books.stream()
                .map(i -> "Book{name='" + i.getName() + "'}")
                .collect(Collectors.joining(",")) + "]}";
    }
}
