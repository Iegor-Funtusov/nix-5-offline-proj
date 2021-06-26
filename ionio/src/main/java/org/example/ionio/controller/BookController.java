package org.example.ionio.controller;

import org.example.ionio.model.Book;
import org.example.ionio.service.BookService;
import org.example.ionio.service.impl.BookServiceImpl;

import java.util.List;

public class BookController {
    private final BookService bookService = new BookServiceImpl();

    public void create(Book book){
        bookService.create(book);
    }

    public void update(Book book){
        bookService.update(book);
    }

    public void delete(String id){
        bookService.delete(id);
    }

    public Book readById(String id){
        return bookService.readById(id);
    }

    public List<Book> readByAuthor(String authorId){
        return bookService.readByAuthor(authorId);
    }

    public List<Book> readAll(){
        return bookService.readAll();
    }
}
