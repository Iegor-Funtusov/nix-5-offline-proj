package ua.practice.app.dao;

import ua.practice.app.entity.Author;

import java.util.List;

public interface AuthorDao {
    void create(Author author);
    void update(Author author);
    void delete(String id);
    List<Author> read();
    Author read(String id);
}
