package com.nix.dao;

import com.nix.pojo_objects.Author;
import com.nix.pojo_objects.Book;

import java.util.List;

public interface DaoBook {
    void create(Book book);
    void update(String id);
    List<Book> read();
    List<Author> readList(Book book);
    void delete(Book book);
}
