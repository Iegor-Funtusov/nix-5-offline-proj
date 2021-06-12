package ua.practice.unit6.application.service;

import ua.practice.unit6.application.entity.Author;
import ua.practice.unit6.application.entity.AuthorToBook;
import ua.practice.unit6.application.entity.Book;

import java.util.Collection;

public interface AuthorToBookService {
    void create(AuthorToBook authorToBook);

    void update(AuthorToBook authorToBook);

    void delete(String id);

    Collection<AuthorToBook> read();

    AuthorToBook read(String id);

    Collection<Author> readAllAuthorsByBookId(String id);

    Collection<Book> readAllBooksByAuthorId(String id);

}
