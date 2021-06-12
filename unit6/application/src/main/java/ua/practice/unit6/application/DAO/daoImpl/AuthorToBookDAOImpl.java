package ua.practice.unit6.application.DAO.daoImpl;

import ua.practice.unit6.application.DAO.AuthorToBookDAO;
import ua.practice.unit6.application.entity.Author;
import ua.practice.unit6.application.entity.AuthorToBook;
import ua.practice.unit6.application.entity.Book;
import ua.practice.unit6.application.library.ArrayCrudService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorToBookDAOImpl implements AuthorToBookDAO {
    ArrayCrudService<AuthorToBook> authorToBookArrayCrudService = new ArrayCrudService<>();

    @Override
    public void create(AuthorToBook authorToBook) {
        authorToBookArrayCrudService.create(authorToBook);
    }

    @Override
    public void update(AuthorToBook authorToBook) {
        authorToBookArrayCrudService.update(authorToBook);
    }

    @Override
    public void delete(String id) {
        authorToBookArrayCrudService.delete(id);
    }

    @Override
    public Collection<AuthorToBook> read() {
        return authorToBookArrayCrudService.read();
    }

    @Override
    public AuthorToBook read(String id) {
        return authorToBookArrayCrudService.read(id);
    }

    public List<Book> readAllBooksByAuthorId(String authorId) {
        return read()
                .stream()
                .filter(authorToBook -> authorToBook.getAuthors().getId().equals(authorId))
                .map(AuthorToBook::getBooks)
                .collect(Collectors.toList());
    }

    public List<Author> readAllAuthorsByBookId(String bookId) {
        return read()
                .stream()
                .filter(authorToBook -> authorToBook.getBooks().getId().equals(bookId))
                .map(AuthorToBook::getAuthors)
                .collect(Collectors.toList());
    }
}
