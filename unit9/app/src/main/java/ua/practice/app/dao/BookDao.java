package ua.practice.app.dao;

import ua.practice.app.entity.Book;

import java.util.List;

public interface BookDao {
    void create(Book book);
    void update(Book book);
    void delete(String id);
    List<Book> read();
    Book read(String id);
}
