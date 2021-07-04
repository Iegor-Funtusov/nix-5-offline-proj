package nix.com.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookService {
    
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    
    private final BookDao bookDao = new BookDao();

    public void create(Book book) {
        LOGGER_INFO.info("start create book: " + book.getId());
        if (!(isParamNull(book))) {
            bookDao.create(book);
        }
        LOGGER_INFO.info("end create book: " + book.getId());
    }

    public void update(Book book) {
        LOGGER_INFO.info("start update book: " + book.getId());
        if (!(isBookExistById(book.getId()))) {
            bookDao.update(book);
        }
        LOGGER_INFO.info("end update book: " + book.getId());
    }

    public Book[] readAll() {
        LOGGER_INFO.info("read all books");
        return bookDao.readAll();
    }

    public Book findById(String id) {
        LOGGER_INFO.info("start find book id: " + id);
        if (!isBookExistById(id)) {
            return bookDao.findById(id);
        }
        LOGGER_INFO.info("end find book id: " + id);
        return null;
    }

    public void delete(String id) {
        LOGGER_WARN.warn("start delete book: " + id);
        if (!isBookExistById(id)) {
            bookDao.delete(id);
        }
        LOGGER_WARN.warn("end delete book: " + id);
    } 
    
    private boolean isBookExistById(String id) {
        Book CurrentBook = bookDao.findById(id);
        if (CurrentBook.getId() != null) {
            if (CurrentBook.getId().equals(id)) {
                return false;
            } else {
                LOGGER_ERROR.info("this book id is exist: " + CurrentBook.getId());
            }
        } else {
            LOGGER_ERROR.error("id book can't be empty");
        }
        return true;
    }

    public boolean isParamNull(Book book) {
        return book.getTitle() == null || book.getNumPg() == null;
    }
}
