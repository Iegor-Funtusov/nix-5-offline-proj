package com.nix.hw.ionio.service;

import com.nix.hw.ionio.dao.AuthorDao;
import com.nix.hw.ionio.entity.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

public class AuthorService {

    private static final Logger LOGGER_INFO  = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN  = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final AuthorDao authorDao = new AuthorDao();

    public void create(Author author) {
        LOGGER_INFO.info("Start creating author: " + author.getFirstName());
        if (!author.getFirstName().isBlank() &&
                !author.getLastName().isBlank() &&
                !author.getBooks().equals(null)) {
            author.setId(UUID.randomUUID().toString());
            author.setVisible(true);
            authorDao.create(author);
        } else {
            LOGGER_ERROR.error("Empty value");
            return;
        }
        LOGGER_INFO.info("End creating author");

    }

    public void update(Author author) {
        LOGGER_WARN.warn("Start updating author: " + author.getFirstName());
        if (author.isVisible())
            authorDao.update(author);
        else {
            LOGGER_ERROR.error("Author is deleted or not exists");
            return;
        }
        LOGGER_WARN.warn("End updating author");
    }

    public void delete(Author author) {
        LOGGER_WARN.warn("Start deleting author: " + author.getFirstName());
        if (author.isVisible())
            authorDao.delete(author);
        else {
            LOGGER_ERROR.error("Author is already deleted or not exists");
            return;
        }
        LOGGER_WARN.warn("End deleting author");
    }

    public List<Author> findAll() {
        return authorDao.findAll();
    }

    public Author findById(String id) {
        return authorDao.findById(id);
    }

}
