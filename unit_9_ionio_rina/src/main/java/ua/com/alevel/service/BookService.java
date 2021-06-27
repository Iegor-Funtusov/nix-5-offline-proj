package ua.com.alevel.service;

import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Book;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private static final BookDao bookDao = new BookDao();

    public static void createBook(Book book){
        if (book != null){
            if ( bookDao.readById(book.getId()) == null){
                LOGGER_INFO.info("Creating book");
                bookDao.create(book);
                LOGGER_INFO.info("book created" + book.getId());
            } else
                LOGGER_ERROR.error("Such book already exist " + book);
        }

    }

    public static void updateBook(Book book){
        if (book != null){
            if ( bookDao.readById(book.getId()) != null){
                LOGGER_INFO.info("Updating book " + book.getId());
                bookDao.update(book);
                LOGGER_INFO.info("book updated "+ book.getId());
            }else
                LOGGER_ERROR.error("Such book does not exist "+ book.getId());
        }

    }

    public static void deleteBookById(String id){
        if (bookDao.readById(id) != null){
            LOGGER_WARN.warn("Deleting book " + id);
            bookDao.delete(id);
            LOGGER_WARN.warn("book deleted " + id);
        }else
            LOGGER_ERROR.error("book does not exist " + id);
    }

    public static Book readBookById(String id){
        LOGGER_INFO.info("Reading book by id" + id);
        return bookDao.readById(id);
    }

    public static List<Book> readAllBooks(){
        LOGGER_INFO.info("Reading all books ");
        return bookDao.readAll();
    }
}