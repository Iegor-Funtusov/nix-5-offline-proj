package ua.davidenko.library;


import ua.davidenko.authors.Authors;
import ua.davidenko.books.Books;

public class Library {
private Authors authors;
private Books books;

    public Library(Authors authors, Books books) {
        this.authors = authors;
        this.books = books;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{" +
                " book id=" + books.getBookId() +
                " book title=" + books.getTitle() +
                "\n author id=" + authors.getAuthorId() +
                " author name=" + authors.getAuthorName() + '}';

    }
}
