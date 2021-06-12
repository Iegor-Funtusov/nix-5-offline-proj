package ua.practice.unit6.application.DAO.daoImpl;

import ua.practice.unit6.application.DAO.AuthorDAO;
import ua.practice.unit6.application.entity.Author;
import ua.practice.unit6.application.library.ArrayCrudService;

import java.util.Collection;

public class AuthorDAOImpl implements AuthorDAO {
    ArrayCrudService<Author> crudService = new ArrayCrudService<>();

    @Override
    public void create(Author author) {
        crudService.create(author);
    }

    @Override
    public void update(Author author) {
        crudService.update(author);
    }

    @Override
    public void delete(String id) {
        crudService.delete(id);
    }

    @Override
    public Collection<Author> read() {
        return crudService.read();
    }

    @Override
    public Author read(String id) {
        return crudService.read(id);
    }
}
