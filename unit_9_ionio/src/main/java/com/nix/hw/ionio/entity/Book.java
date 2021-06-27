package com.nix.hw.ionio.entity;

import java.util.List;
import java.util.stream.Collectors;

public class Book extends BaseEntity{

    private String name;
    private List<Author> authors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", authors=[" + authors.stream()
                .map(i -> "Author{firstName='" + i.getFirstName()
                        + "', lastName='" + i.getLastName() + "'}")
                .collect(Collectors.joining(",")) + "]}";
    }
}
