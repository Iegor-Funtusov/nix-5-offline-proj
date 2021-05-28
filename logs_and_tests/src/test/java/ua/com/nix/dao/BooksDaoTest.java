package ua.com.nix.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.nix.model.Book;

public class BooksDaoTest {

    final static private String NAME = "book";
    private static final BooksDao booksDao = new BooksDao();

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setName(NAME + i);
            booksDao.create(book);
        }
        Book[] books = booksDao.findAll();
        Assertions.assertEquals(10, books.length);
    }

    @Test
    @Order(2)
    public void delete(){
        Book[] books = booksDao.findAll();
        String id = books[5].getId();
        booksDao.delete(books[5].getId());
        books = booksDao.findAll();
        Assertions.assertEquals(9, books.length);
    }
    @Test
    @Order(3)
    public void update() {
        Book[] books = booksDao.findAll();
        Book updatedBook;
        for (int i = 0; i < books.length; i++) {
            if (i == 3) {
                updatedBook = books[i];
                updatedBook.setName("new Book" + i);
                booksDao.update(updatedBook);
            }
        }
        Assertions.assertEquals(9, books.length);
    }
    @Test
    @Order(4)
    public void findById(){
        Book[] books = booksDao.findAll();
        Assertions.assertNotNull(booksDao.findById(books[5].getId()));
    }
    @Test
    @Order(4)
    public void findAll() {
        Book[] books = booksDao.findAll();
        Assertions.assertNotNull(books);
    }
}

