package ua.practice.unit6.application.DAO;

import ua.practice.unit6.application.entity.Author;
import ua.practice.unit6.application.library.CrudService;

import java.util.Collection;

public interface AuthorDAO extends CrudService<Author> {
    @Override
    void create(Author author);

    @Override
    void update(Author author);

    @Override
    void delete(String id);

    @Override
    Collection<Author> read();

    @Override
    Author read(String id);
}
