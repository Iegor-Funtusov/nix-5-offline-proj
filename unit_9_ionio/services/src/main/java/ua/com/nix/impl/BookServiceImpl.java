package ua.com.nix.impl;

import org.apache.log4j.Logger;
import ua.com.nix.*;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final Logger logger = Logger.getLogger(BookServiceImpl.class);
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public void create(Book book) {
        logger.info("Start create new book " + book.getTitle());
        bookDao.create(book);
        logger.info("Operation successful");
    }

    @Override
    public Book read(int id) {
        Book book = bookDao.findALl().stream().filter(book1 -> book1.getId() == id).findFirst().get();

        logger.info("Start read info about book" + id);
        if(bookDao.isBookByTitleExist(book.getTitle())){
            logger.info("Operation ssuccessful");
            return bookDao.read(id);
        }
        throw new RuntimeException("Book doesn't exist");    }

    @Override
    public void update(Book book) {
        logger.info("Start update info about book " + book.getTitle());
        bookDao.update(book);
        logger.info("Operation successful");
    }

    @Override
    public void delete(int id) {
        logger.info("Start delete info about book" + id);
        bookDao.delete(id);
        logger.info("Operation successful");
    }

    @Override
    public List<Book> findAll() {
        logger.info("Start find all books");
        return bookDao.findALl();
    }

    @Override
    public List<Book> findByAuthor(int author) {
        return bookDao.findByAuthor(author);
    }

    public Book findBookByTitle(String title){
        return bookDao.findBookByTitle(title);
    }

    public boolean isBookByTitleExist(String title){
        return bookDao.isBookByTitleExist(title);
    }

}
