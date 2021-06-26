package ua.practice.app.service;

import ua.practice.app.entity.Book;

import java.util.Collection;

public interface BookService {
    void create(Book book);

    void update(Book book);

    void delete(String id);

    Collection<Book> read();

    Book read(String id);
}
