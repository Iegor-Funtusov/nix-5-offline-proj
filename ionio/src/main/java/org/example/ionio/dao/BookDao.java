package org.example.ionio.dao;

import org.example.ionio.model.Book;

import java.util.List;

public interface BookDao {
    void create(Book book);
    void update(Book book);
    void delete(String id);
    Book readById(String id);
    List<Book> readAll();
}
