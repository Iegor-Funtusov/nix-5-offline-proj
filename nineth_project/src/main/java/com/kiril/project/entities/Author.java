package com.kiril.project.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Author extends BaseEntity{
    private String firstName;
    private String lastName;
    private List<String> authorsBooks = new ArrayList<>();
    private boolean isVisible;

    @Override
    public String toString() {
        return "Author: " + getId() + " " + firstName + " " + lastName + " " + authorsBooks;
    }
}
