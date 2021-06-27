package ua.com.alevel.app.service.book;

import ua.com.alevel.app.service.author.AuthorService;

import java.util.List;

public interface BookCrudService {
    void create(BookService bookService);
    void update(String id);
    void delete(BookService bookService);
    List<BookService> read();
    List<AuthorService> readList(BookService bookService);
}
