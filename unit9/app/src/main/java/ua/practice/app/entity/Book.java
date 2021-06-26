package ua.practice.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String id;

    private String name;

    private List<Author> authors;

    private boolean visible = true;

    public Book() {
        authors = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    private boolean isAuthorRelated(Author author) {
        return authors.contains(author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", authors='" + authors.toString() + '\'' +
                '}';
    }
}
