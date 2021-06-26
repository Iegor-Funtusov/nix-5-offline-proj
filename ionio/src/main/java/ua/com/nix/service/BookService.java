package ua.com.nix.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.nix.dao.impl.BookDaoImpl;
import ua.com.nix.model.Author;
import ua.com.nix.model.Book;

import java.util.List;

public class BookService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private final BookDaoImpl booksDao = new BookDaoImpl();

    public void create(Book book, Author author) {
        if (book != null) {
            LOGGER_INFO.info("Start create book: " + book.getTitle());
            booksDao.create(book,author);
            LOGGER_INFO.info("End create book: " + book.getTitle());
        }
        else{
            LOGGER_ERROR.error("Book is null!");
        }
    }
    public void update(Book book)
    {
        if (book != null && booksDao.read(book.getId())!=null) {
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
        if (booksDao.read(id)!=null) {
            LOGGER_WARN.warn("Start delete book: " + id);
            booksDao.delete(id);
            LOGGER_WARN.warn("End delete book: " + id);
        }
        else {
            LOGGER_ERROR.error("Book doesn't exists");
        }
    }
    public List<Book> readAll() {
        LOGGER_INFO.info("Read all books");
        return booksDao.readAll();
    }
    public Book read(String id) {
        if (booksDao.read(id) != null) {
            return booksDao.read(id);
        }
        LOGGER_ERROR.error("Book doesn't exists");
        return null;
    }
    public Author readAllAuthorsByBook(Book book) {
        LOGGER_INFO.info("Read author by book: " + book.getTitle());
        return booksDao.readAllAuthorsByBook(book);
    }

}


