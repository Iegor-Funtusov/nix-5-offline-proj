package com.nix.hw.ionio.dao;

import com.nix.hw.ionio.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookDao {

    private final static BookCsvConnector bookCsvConnector = new BookCsvConnector();

    public void create(Book book) {
        bookCsvConnector.add(book);
    }

    public void update(Book book) {
        bookCsvConnector.update(book);
    }

    public void delete(Book book) {
        book.setVisible(false);
        update(book);
    }

    public List<Book> findAll() {
        return bookCsvConnector.getData().stream()
                .filter(Book::isVisible)
                .collect(Collectors.toList());
    }

    public Book findById(String id) {
        return findAll().stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
