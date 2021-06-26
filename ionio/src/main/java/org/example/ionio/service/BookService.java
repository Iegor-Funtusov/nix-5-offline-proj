package org.example.ionio.service;

import org.example.ionio.model.Book;

import java.util.List;

public interface BookService {
    void create(Book book);
    void update(Book book);
    void delete(String id);
    Book readById(String id);
    List<Book> readByAuthor(String authorId);
    List<Book> readAll();
}
