package service;

import dao.BookDao;
import entity.Author;
import entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private BookDao bookDao = new BookDao();

    public void create(String name, Author newAuthor) {
        LOGGER_INFO.info("Start create book: " + name);

        bookDao.create(name, newAuthor);

        LOGGER_INFO.info("End create book");
    }

    public void readAll(){

        bookDao.readAll();

    }

    public Book[] readAll(Author author){

        Book[] books = bookDao.readAll(author);

        return books;
    }

    public void read(int id){

        bookDao.read(id);

    }
    public void update(int id, String newName, Author newAuthor){
        LOGGER_WARN.warn("Start update book id: " + id);
        bookDao.update(id,newName,newAuthor);
        LOGGER_WARN.warn("End update book");
    }
    public void delete(int id){

        bookDao.delete(id);

    }

}
