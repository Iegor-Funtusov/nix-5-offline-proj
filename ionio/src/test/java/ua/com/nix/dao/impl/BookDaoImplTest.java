package ua.com.nix.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.nix.model.Author;
import ua.com.nix.model.Book;

import java.util.List;

public class BookDaoImplTest {

    final static private String NAME = "book";
    private static final BookDaoImpl booksDao = new BookDaoImpl();
    private static final AuthorDaoImpl authorDao = new AuthorDaoImpl();

    @Test
    @Order(1)
    public void create() {
        Author author = new Author();
        author.setFirstName("Anton");
        author.setLastName("Pupkin");
        authorDao.create(author);
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setTitle(NAME + i);
            booksDao.create(book,author);
        }
        List<Book> books = booksDao.readAll();
        Assertions.assertEquals(10, books.size());
    }

    @Test
    @Order(2)
    public void delete(){
        List<Book> books = booksDao.readAll();
        String id = books.get(5).getId();
        booksDao.delete(books.get(5).getId());
        Book book = books.get(5);
        books = booksDao.readAll();
        Assertions.assertEquals(9, books.size());
        Assertions.assertFalse(book.isInvisible());
    }
    @Test
    @Order(3)
    public void update() {
        List<Book> books = booksDao.readAll();
        Book updatedBook;
        for (int i = 0; i < books.size(); i++) {
            if (i == 3) {
                updatedBook = books.get(i);
                updatedBook.setTitle("new Book" + i);
                booksDao.update(updatedBook);
            }
        }
        Assertions.assertEquals(9, books.size());
    }
    @Test
    @Order(4)
    public void findById(){
        List<Book> books = booksDao.readAll();
        Assertions.assertNotNull(booksDao.read(books.get(5).getId()));
    }
    @Test
    @Order(4)
    public void findAll() {
        List<Book> books = booksDao.readAll();
        Assertions.assertNotNull(books);
    }
}

