package org.example.ionio.controller;

import org.example.ionio.model.Author;
import org.example.ionio.service.AuthorService;
import org.example.ionio.service.impl.AuthorServiceImpl;

import java.util.List;

public class AuthorController {
    private final AuthorService authorService = new AuthorServiceImpl();

    public void create(Author author){
        authorService.create(author);
    }

    public void update(Author author){
        authorService.update(author);
    }

    public void delete(String id){
        authorService.delete(id);
    }

    public Author readById(String id){
        return authorService.readById(id);
    }

    public List<Author> readByBook(String bookId){
        return authorService.readByBook(bookId);
    }

    public List<Author> readAll(){
        return authorService.readAll();
    }

}
