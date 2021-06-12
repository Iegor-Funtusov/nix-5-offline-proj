package ua.practice.unit6.application.DAO.daoImpl;

import ua.practice.unit6.application.DAO.BookDAO;
import ua.practice.unit6.application.entity.Book;
import ua.practice.unit6.application.library.ArrayCrudService;

import java.util.Collection;

public class BookDAOImpl implements BookDAO {
    ArrayCrudService<Book> crudService = new ArrayCrudService<>();

    @Override
    public void create(Book book) {
        crudService.create(book);
    }

    @Override
    public void update(Book book) {
        crudService.update(book);
    }

    @Override
    public void delete(String id) {
        crudService.delete(id);
    }

    @Override
    public Collection<Book> read() {
        return crudService.read();
    }

    @Override
    public Book read(String id) {
        return crudService.read(id);
    }
}
