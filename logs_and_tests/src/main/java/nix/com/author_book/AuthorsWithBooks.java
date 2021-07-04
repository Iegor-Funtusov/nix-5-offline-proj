package nix.com.author_book;

import nix.com.author.Author;
import nix.com.book.Book;

public class AuthorsWithBooks {
    private Book book;
    private Author author;

    public AuthorsWithBooks(Book book, Author author) {
        this.book = book;
        this.author = author;
    }

    public AuthorsWithBooks(Author author, Book book) {
        this.book = book;
        this.author = author;
    }

    @Override
    public String toString() {
        return "AuthorsWithBooks{" +
                " book id=" + book.getId() +
                " book title=" + book.getTitle() +
                " book numPg=" + book.getNumPg() +
                "\n author id=" + author.getId() +
                ", author name=" + author.getName() +
                ", author age=" + author.getAge() +
                '}';
    }
}
