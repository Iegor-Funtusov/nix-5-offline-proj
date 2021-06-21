package ua.practice.app.dao.impl;

import ua.practice.app.dao.AuthorDao;
import ua.practice.app.entity.Author;
import ua.practice.crud_library.ArrayCrudService;

import java.util.Collection;

public class AuthorDaoImpl implements AuthorDao {

    ArrayCrudService<Author> authorArrayCrudService = new ArrayCrudService<>(Author.class);

    @Override
    public void create(Author author) {
        authorArrayCrudService.create(author);
    }

    @Override
    public void update(Author author) {
        authorArrayCrudService.update(author);
    }

    @Override
    public void delete(String id) {
        authorArrayCrudService.delete(id);
    }

    @Override
    public Collection<Author> read() {
        return authorArrayCrudService.read();
    }

    @Override
    public Author read(String id) {
        return authorArrayCrudService.read(id);
    }
}
