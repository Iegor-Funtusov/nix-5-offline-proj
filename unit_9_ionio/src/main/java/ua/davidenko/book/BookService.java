package ua.davidenko.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.davidenko.author.Author;

import java.util.List;

public class BookService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    static BooksCrud booksCrud = new BooksCrud();

    public void create(Book book) {
        if (book != null) {
            LOGGER_INFO.info("Create book " + book.getTitle());
            booksCrud.create(book);
            LOGGER_INFO.info("Book created " + book.getTitle());
        } else
            LOGGER_ERROR.error("Book is null");

    }

    public void update(String id) {
        if (findBookById(id) != null) {
            LOGGER_INFO.info("Update book " + findBookById(id));
            booksCrud.update(id);
            LOGGER_INFO.info("Book updated" + findBookById(id) + "updated");
        } else
            LOGGER_ERROR.error("Book not found");
    }

    public void delete(Book book) {
        LOGGER_INFO.info("deleting book with id " + book.getBookId());
        booksCrud.delete(book);
        LOGGER_INFO.info("Book " + book.getBookId() + "deleted");
    }

    public Book findBookById(String id) {
        Book thisBook = booksCrud.readBooks()
                .stream()
                .filter(e -> e.getBookId().equals(id))
                .findAny()
                .orElse(null);
        if (thisBook == null) {
            throw new RuntimeException("There is no this id");
        }
        return thisBook;
    }

    public List<Book> readBooks() {
        LOGGER_INFO.info("Read all books");
        return booksCrud.readBooks();
    }

    public List<Author> readAuthors(Book book) {
        LOGGER_INFO.info(" Read  all authors of this book");
        return booksCrud.readAuthors(book);
    }
}
