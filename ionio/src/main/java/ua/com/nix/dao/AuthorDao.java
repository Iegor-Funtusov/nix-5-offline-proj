package ua.com.nix.dao;

import ua.com.nix.model.Author;
import ua.com.nix.model.Book;

import java.util.List;

public interface AuthorDao {
     void create(Author author);
     void update(Author author);
     void delete(String id);
     Author read(String id);
     List<Author> readAll();
     List<Book> readAllBooksByAuthor(Author author);
}
