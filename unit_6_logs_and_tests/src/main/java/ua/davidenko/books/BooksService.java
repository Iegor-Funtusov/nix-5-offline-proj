package ua.davidenko.books;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BooksService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    BooksArrayCrud booksCrud = new BooksArrayCrud();

    public void create(Books book) {
        if (book != null) {
            LOGGER_INFO.info("Create book " + book.getTitle());
            booksCrud.create(book);
            LOGGER_INFO.info("Book created " + book.getTitle());
        } else
            LOGGER_ERROR.error("Book is null");

    }

    public void update(Books book) {
        if (book != null) {
            LOGGER_INFO.info("Update book " + book.getTitle() + book.getBookId());
            booksCrud.update(book);
            LOGGER_INFO.info("Book updated " + book.getTitle() + book.getBookId());
        } else
            LOGGER_ERROR.error("Book not found");
    }

    public void delete(String id) {
        LOGGER_INFO.info("delete book with id " + id);
        booksCrud.delete(id);
        LOGGER_INFO.info("Book " + id + "deleted");
    }

    public Books readById(String id) {
        LOGGER_INFO.info("Read book with id " + id);
        return booksCrud.read(id);
    }

    public Books[] readAll() {
        LOGGER_INFO.info("Read all books");
        return booksCrud.read();
    }
}
