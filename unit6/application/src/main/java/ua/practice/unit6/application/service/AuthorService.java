package ua.practice.unit6.application.service;

import ua.practice.unit6.application.entity.Author;

import java.util.Collection;

public interface AuthorService {
    void create(Author author);

    void update(Author author);

    void delete(String id);

    Collection<Author> read();

    Author read(String id);
}
