package ua.practice.unit6.application.DAO;

import ua.practice.unit6.application.entity.AuthorToBook;
import ua.practice.unit6.application.library.CrudService;

import java.util.Collection;

public interface AuthorToBookDAO extends CrudService<AuthorToBook> {
    @Override
    void create(AuthorToBook authorToBook);

    @Override
    void update(AuthorToBook authorToBook);

    @Override
    void delete(String id);

    @Override
    Collection<AuthorToBook> read();

    @Override
    AuthorToBook read(String id);
}
