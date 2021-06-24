package com.nix.control;

import com.nix.dao.DaoAuthor;
import com.nix.dao.DaoAuthorImpl;
import com.nix.pojo_objects.Author;
import com.nix.pojo_objects.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ControlAuthor implements DaoAuthor {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    DaoAuthor daoAuthor = new DaoAuthorImpl();

    @Override
    public void create(Author author) {
        LOGGER_INFO.info("start create author: " + author.getId());
        if (!isAuthorNull(author)) {
            daoAuthor.create(author);
        } else {
            LOGGER_ERROR.error("create author");
            throw new RuntimeException("author is null");
        }
        LOGGER_INFO.info("end create author: " + author.getId());
    }

    @Override
    public void update(Author author) {
        LOGGER_INFO.info("start update author: " + author.getId());
        if (!isAuthorNull(author)) {
            daoAuthor.update(author);
        }else {
            LOGGER_ERROR.error("update author");
            throw new RuntimeException("author is null");
        }
        LOGGER_INFO.info("end update author: " + author.getId());
    }

    @Override
    public List<Author> read() {
        LOGGER_INFO.info("read all authors");
        return daoAuthor.read();
    }

    @Override
    public List<Book> readList(Author author) {
        LOGGER_INFO.info("read all books from author");
        return daoAuthor.readList(author);
    }

    @Override
    public void delete(Author author) {
        LOGGER_WARN.warn("start delete author: " + author.getId());
        if (!isAuthorNull(author)) {
            daoAuthor.delete(author);
        }else {
            LOGGER_ERROR.error("delete author");
            throw new RuntimeException("author is null");
        }
        LOGGER_WARN.warn("end delete author: " + author.getId());
    }

    private boolean isAuthorNull(Author author) {
        return author == null || author.getFirstName().isBlank() || author.getLastName().isBlank();
    }
}
