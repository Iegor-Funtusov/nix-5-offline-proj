package ua.com.nix.service;

import ua.com.nix.dao.BooksDao;
import ua.com.nix.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private final BooksDao booksDao = new BooksDao();

    public void create(Book book) {
        if (book != null) {
            LOGGER_INFO.info("Start create book: " + book.getName());
            booksDao.create(book);
            LOGGER_INFO.info("End create book: " + book.getName());
        }
        else{
            LOGGER_ERROR.error("Book is null!");
        }
    }
    public void update(Book book)
    {
        if (book != null && booksDao.findById(book.getId())!=null) {
            LOGGER_WARN.warn("Start update book: " + book.getId());
            booksDao.update(book);
            LOGGER_WARN.warn("End create book: " + book.getId());
        }
        else {
            LOGGER_ERROR.error("Book doesn't exists");
        }
    }
    public void delete(String id)
    {
        if (booksDao.findById(id)!=null) {
            LOGGER_WARN.warn("Start delete book: " + id);
            booksDao.delete(id);
            LOGGER_WARN.warn("End delete book: " + id);
        }
        else {
            LOGGER_ERROR.error("Book doesn't exists");
        }
    }
    public Book[] findAll() {
        LOGGER_INFO.info("Read all books");
        return booksDao.findAll();
    }
    public Book findById(String id) {
        if (booksDao.findById(id) != null) {
            return booksDao.findById(id);
        }
        LOGGER_ERROR.error("Book doesn't exists");
        return null;
    }

}

