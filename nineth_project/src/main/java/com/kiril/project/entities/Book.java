package com.kiril.project.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book extends BaseEntity{
    private String name;
    private String author;
    private boolean isVisible;

    @Override
    public String toString() {
        return "Book: " + getId() + " " + name + " " + author;
    }
}
