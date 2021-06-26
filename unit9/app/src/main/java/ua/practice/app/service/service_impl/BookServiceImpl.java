package ua.practice.app.service.service_impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.practice.app.dao.dao_impl.BookDaoImpl;
import ua.practice.app.entity.Book;
import ua.practice.app.service.BookService;

import java.util.Collection;

public class BookServiceImpl implements BookService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final BookDaoImpl bookDAO = new BookDaoImpl();

    public void create(Book book) {
        if (book != null) {
            LOGGER_INFO.info("Start create book: " + book.getName());
            if (!isBookExistByName(book.getName()) && !isBookExist(book.getId())) {
                bookDAO.create(book);
            }
        } else
            LOGGER_ERROR.error("book == null in create");
        LOGGER_INFO.info("End create book");
    }

    public void update(Book book) {
        if (book != null) {
            LOGGER_WARN.warn("Start update book: " + book.getName());
            if (isBookExist(book.getId())) {
                bookDAO.update(book);
            } else
                LOGGER_ERROR.error("Book == null in update");
            LOGGER_WARN.warn("End update book");
        }
    }

    public void delete(String id) {
        LOGGER_WARN.warn("Start delete book " + id);
        if (isBookExist(id))
            bookDAO.delete(id);
        LOGGER_WARN.warn("End delete book");
    }

    public Collection<Book> read() {
        LOGGER_WARN.warn("Start reading books");
        Collection<Book> books = bookDAO.read();
        LOGGER_WARN.warn("End reading books");
        return books;
    }

    public Book read(String id) {
        if (isBookExist(id))
            return bookDAO.read(id);
        return null;
    }

    private boolean isBookExistByName(String name) {
        if (name != null) {
            boolean result = bookDAO.read().stream().anyMatch(book -> name.equals(book.getName()));
            if (!result) {
                LOGGER_ERROR.error("book does not exist");
            }
            return result;
        } else {
            LOGGER_ERROR.error("Input name == null");
        }
        return false;
    }

    private boolean isBookExist(String id) {
        if (id != null) {
            boolean result = bookDAO.read().stream().anyMatch(book -> book.getId().equals(id));
            if (!result)
                LOGGER_ERROR.error("book with id " + id + "doesn't exist");
            return result;
        } else {
            LOGGER_ERROR.error("Input id == null");
        }
        return false;
    }
}
