package com.nix.dao;

import com.nix.pojo_objects.Author;
import com.nix.pojo_objects.Book;

import java.util.List;

public interface DaoAuthor {
    void create(Author author);
    void update(Author author);
    List<Author> read();
    List<Book> readList(Author author);
    void delete(Author author);
}
