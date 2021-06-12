package ua.practice.unit6.application.entity;

import ua.practice.unit6.application.library.BaseEntity;

public class AuthorToBook extends BaseEntity {
    private Author authors;
    private Book books;

    public Author getAuthors() {
        return authors;
    }

    public void setAuthors(Author authors) {
        this.authors = authors;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "AuthorToBook{" +
                "id='" + super.getId() + '\'' +
                "authors=" + authors +
                ", books=" + books +
                '}';
    }
}
