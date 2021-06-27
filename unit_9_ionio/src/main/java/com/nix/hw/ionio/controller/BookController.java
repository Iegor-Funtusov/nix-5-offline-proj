package com.nix.hw.ionio.controller;

import com.nix.hw.ionio.entity.Book;
import com.nix.hw.ionio.service.BookService;

import java.util.List;

public class BookController {

    public final BookService bookService = new BookService();

    public void create(Book book) {
        bookService.create(book);
    }

    public void update(Book book) {
        bookService.update(book);
    }

    public void delete(Book book) {
        bookService.delete(book);
    }

    public List<Book> findAll() {
        return bookService.findAll();
    }

    public Book findById(String id) {
        return bookService.findById(id);
    }
}
