package org.example.ionio.service;

import org.example.ionio.model.Author;

import java.util.List;

public interface AuthorService {
    void create(Author author);
    void update(Author author);
    void delete(String id);
    Author readById(String id);
    List<Author> readByBook(String bookId);
    List<Author> readAll();
}
