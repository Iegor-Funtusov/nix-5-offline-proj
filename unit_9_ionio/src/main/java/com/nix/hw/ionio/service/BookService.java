package com.nix.hw.ionio.service;

import com.nix.hw.ionio.dao.BookDao;
import com.nix.hw.ionio.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

public class BookService {

    private static final Logger LOGGER_INFO  = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN  = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final BookDao bookDao = new BookDao();

    public void create(Book book) {
        LOGGER_INFO.info("Start creating book: " + book.getName());
        if (!book.getName().isBlank() &&
                !book.getName().isBlank() &&
                !book.getAuthors().equals(null)) {
            book.setId(UUID.randomUUID().toString());
            book.setVisible(true);
            bookDao.create(book);
        } else {
            LOGGER_ERROR.error("Empty value");
            return;
        }
        LOGGER_INFO.info("End creating book");

    }

    public void update(Book book) {
        LOGGER_WARN.warn("Start updating book: " + book.getName());
        if (book.isVisible())
            bookDao.update(book);
        else {
            LOGGER_ERROR.error("Book is deleted or not exists");
            return;
        }
        LOGGER_WARN.warn("End updating book");
    }

    public void delete(Book book) {
        LOGGER_WARN.warn("Start deleting book: " + book.getName());
        if (book.isVisible())
            bookDao.delete(book);
        else {
            LOGGER_ERROR.error("Book is already deleted or not exists");
            return;
        }
        LOGGER_WARN.warn("End deleting book");
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public Book findById(String id) {
        return bookDao.findById(id);
    }

}
