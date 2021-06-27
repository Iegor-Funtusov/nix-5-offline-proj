package com.nix.hw.ionio.controller;

import com.nix.hw.ionio.entity.Author;
import com.nix.hw.ionio.service.AuthorService;

import java.util.List;

public class AuthorController {

    public final AuthorService authorService = new AuthorService();

    public void create(Author author) {
        authorService.create(author);
    }

    public void update(Author author) {
        authorService.update(author);
    }

    public void delete(Author author) {
        authorService.delete(author);
    }

    public List<Author> findAll() {
        return authorService.findAll();
    }

    public Author findById(String id) {
        return authorService.findById(id);
    }

}
