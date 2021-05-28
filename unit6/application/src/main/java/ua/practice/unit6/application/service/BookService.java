package ua.practice.unit6.application.service;

import ua.practice.unit6.application.entity.Book;

import java.util.Collection;

public interface BookService {
    void create(Book book);

    void update(Book book);

    void delete(String id);

    Collection<Book> read();

    Book read(String id);
}
