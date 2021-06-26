package org.example.ionio.service.impl;

import org.example.ionio.dao.BookDao;
import org.example.ionio.dao.impl.BookDaoImpl;
import org.example.ionio.model.Book;
import org.example.ionio.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
    private static final Logger LOGGER = LoggerFactory.getLogger("BookServiceLogger");
    private static final BookDao bookDao = new BookDaoImpl();

    @Override
    public void create(Book book) {
        if(book != null){
            if(!bookIsExist(book.getId())){
                LOGGER.info("Start create book: " + book.getName());
                bookDao.create(book);
                LOGGER.info("End create book: " + book.getName());
            } else {
                LOGGER.error("Book with same id already exists: " + book.getId());
            }
        }
    }

    @Override
    public void update(Book book) {
        if(book != null){
            if(bookIsExist(book.getId())){
                LOGGER.warn("Start update book: " + book.getName());
                bookDao.update(book);
                LOGGER.warn("End update book: " + book.getName());
            } else {
                LOGGER.error("Book is not exists: " + book.getId());
            }
        }
    }

    @Override
    public void delete(String id) {
        if(bookIsExist(id)){
            LOGGER.warn("Start delete book ID: " + id);
            bookDao.delete(id);
            LOGGER.warn("End delete book ID: " + id);
        } else {
            LOGGER.error("Book is not exists: " + id);
        }
    }

    @Override
    public Book readById(String id) {
        return bookDao.readById(id);
    }

    @Override
    public List<Book> readByAuthor(String authorId) {
        return bookDao.readAll()
                .stream()
                .filter(b ->
                    b.getAuthors()
                            .stream()
                            .anyMatch(a -> a.getId().equals(authorId)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> readAll() {
        return bookDao.readAll();
    }

    private boolean bookIsExist(String id){
        return bookDao.readById(id) != null;
    }
}
