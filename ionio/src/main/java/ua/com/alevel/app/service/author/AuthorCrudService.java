package ua.com.alevel.app.service.author;

import ua.com.alevel.app.service.book.BookService;

import java.util.List;

public interface AuthorCrudService {
    void create(AuthorService authorService);
    void update(AuthorService authorService);
    void delete(AuthorService authorService);
    List<AuthorService> read();
    List<BookService> readList(AuthorService authorService);
}
