package ua.practice.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private String id;

    private String name;

    private String lastName;

    private List<Book> books;

    private boolean visible = true;

    public Author() {
        books = new ArrayList<>();
    }

    public Author(String name, String lastName) {
        this();
        this.name = name;
        this.lastName = lastName;
    }

    public void addBook(Book book) {
        if (!isBookRelated(book)) {
            books.add(book);
        }
    }

    private boolean isBookRelated(Book book) {
        return books.contains(book);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }
}
