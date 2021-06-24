package com.nix.control;

import com.nix.dao.DaoBook;
import com.nix.dao.DaoBookImpl;
import com.nix.pojo_objects.Author;
import com.nix.pojo_objects.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ControlBook implements DaoBook {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    DaoBook daoBook = new DaoBookImpl();

    @Override
    public void create(Book book) {
        LOGGER_INFO.info("start create book: " + book.getId());
        if (!isBookNull(book)) {
            daoBook.create(book);
        } else {
            LOGGER_ERROR.error("create book");
            throw new RuntimeException("book is null");
        }
        LOGGER_INFO.info("end create book: " + book.getId());
    }

    @Override
    public void update(String id) {
        LOGGER_INFO.info("start update book: " + findById(id));
        if (!isBookNull(findById(id))) {
            daoBook.update(id);
        } else {
            LOGGER_ERROR.error("update book");
            throw new RuntimeException("book is null");
        }
        LOGGER_INFO.info("end update book: " + findById(id));
    }

    @Override
    public List<Book> read() {
        LOGGER_INFO.info("start read books");
        return daoBook.read();
    }

    @Override
    public List<Author> readList(Book book) {
        LOGGER_INFO.info("start read authors this book");
        return daoBook.readList(book);
    }

    @Override
    public void delete(Book book) {
        LOGGER_WARN.warn("start delete book: " + book.getId());
        if (!isBookNull(book)) {
            daoBook.delete(book);
        } else {
            LOGGER_ERROR.error("delete book");
            throw new RuntimeException("book is null");
        }
        LOGGER_WARN.warn("end delete book: " + book.getId());
    }

    private boolean isBookNull(Book book) {
        return book == null || book.getTitle() == null || book.getTitle().isBlank();
    }

    private Book findById(String id) {
        Book current = daoBook.read().stream().filter(e -> e.getId().equals(id)).findAny().orElse(null);
        if (current == null) {
            throw new RuntimeException("This id does not exist");
        }
        return current;
    }
}
