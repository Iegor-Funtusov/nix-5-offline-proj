package ua.com.nix.dao;

import ua.com.nix.model.Author;
import ua.com.nix.model.Book;

import java.util.List;

public interface BookDao {
    void create(Book book,Author author);
    void update(Book book);
    void delete(String id);
    Book read(String id);
    List<Book> readAll();
    Author readAllAuthorsByBook(Book book);
}
