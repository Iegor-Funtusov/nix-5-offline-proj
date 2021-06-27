package com.nix.hw.ionio.dao;

import com.nix.hw.ionio.entity.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorDao {

    private final static AuthorCsvConnector authorCsvConnector = new AuthorCsvConnector();

    public void create(Author author) {
        authorCsvConnector.add(author);
    }

    public void update(Author author) {
        authorCsvConnector.update(author);
    }

    public void delete(Author author) {
        author.setVisible(false);
        update(author);
    }

    public List<Author> findAll() {
        return authorCsvConnector.getData().stream()
                .filter(Author::isVisible)
                .collect(Collectors.toList());
    }

    public Author findById(String id) {
        return findAll().stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
