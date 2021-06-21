package ua.practice.app.dao.impl;

import ua.practice.app.dao.BookDao;
import ua.practice.app.entity.Book;
import ua.practice.crud_library.ArrayCrudService;

import java.util.Collection;

public class BookDaoImpl implements BookDao {

    ArrayCrudService<Book> bookArrayCrudService = new ArrayCrudService<>(Book.class);

    @Override
    public void create(Book book) {
        bookArrayCrudService.create(book);
    }

    @Override
    public void update(Book book) {
        bookArrayCrudService.update(book);
    }

    @Override
    public void delete(String id) {
        bookArrayCrudService.delete(id);
    }

    @Override
    public Collection<Book> read() {
        return bookArrayCrudService.read();
    }

    @Override
    public Book read(String id) {
        return bookArrayCrudService.read(id);
    }
}
