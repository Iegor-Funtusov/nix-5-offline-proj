package org.example.ionio.dao;

import org.example.ionio.model.Author;

import java.util.List;

public interface AuthorDao {
    void create(Author author);
    void update(Author author);
    void delete(String id);
    Author readById(String id);
    List<Author> readAll();
}
