package ua.practice.unit6.application.DAO;

import ua.practice.unit6.application.entity.Book;
import ua.practice.unit6.application.library.CrudService;

import java.util.Collection;

public interface BookDAO extends CrudService<Book> {
    @Override
    void create(Book book);

    @Override
    void update(Book book);

    @Override
    void delete(String id);

    @Override
    Collection<Book> read();

    @Override
    Book read(String id);
}
