package ua.davidenko;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import ua.davidenko.books.Books;
import ua.davidenko.books.BooksService;

public class BookServiceTest {

    BooksService booksService = new BooksService();

    @Test
    @Order(1)
    public void create() {
        Books book = new Books();
        book.setTitle("bookTitle");
        booksService.create(book);
        String id = book.getBookId();
        Assertions.assertNotNull(booksService.readById(id));
    }

    @Test
    @Order(2)
    public void readAll() {
        Books[] books = booksService.readAll();
        Assertions.assertNotNull(books);
    }
    @Test
    @Order(3)
    public void update() {
        Books[] books = booksService.readAll();
        for (int i = 0; i < books.length; i++) {
            Books updateBook = books[i];
            updateBook.setTitle("newBookTitle" + i);
            booksService.update(updateBook);
        }
        Assertions.assertEquals(0, books.length);
        Assertions.assertNotNull(books);
    }
    @Test
    @Order(4)
    public void deleteAll() {
        Books[] books = booksService.readAll();
        for (int i = 0; i < books.length; i++) {
            booksService.delete(books[i].getBookId());
        }
        books = booksService.readAll();
        for (int i = 0; i < books.length; i++) {
            Assertions.assertNull(books[i]);
        }
    }
}
