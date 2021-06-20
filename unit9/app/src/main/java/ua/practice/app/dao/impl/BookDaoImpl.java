package ua.practice.app.dao.impl;

import ua.practice.app.dao.BookDao;
import ua.practice.app.entity.Book;
import ua.practice.crud_library.ArrayCrudService;

import java.util.Collection;

public class BookDaoImpl implements BookDao {

    ArrayCrudService<Book> bookArrayCrudService = new ArrayCrudService<>();

    @Override
    public void create(Book book) {
        bookArrayCrudService.create(book);
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Collection<Book> read() {
        return null;
    }

    @Override
    public Book read(String id) {
        return null;
    }
}
