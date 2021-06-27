package ua.com.csv;

import org.junit.jupiter.api.*;
import ua.com.model.Book;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookCSVServiceTest {
    private static final BookCSVService bookCSVService = new BookCSVService();

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book(String.valueOf(i));
            bookCSVService.create(book);
        }
    }

    @Test
    @Order(1)
    public void createBook() {
        Book book = new Book("Test");
        bookCSVService.create(book);
        book = bookCSVService.read(book.getId());
        assertEquals("Test",book.getTitle());
    }

    @Test
    @Order(2)
    public void readBook() {
        assertNull(bookCSVService.read("123"));
    }

    @Test
    @Order(3)
    public void updateBook() {
        Book book = new Book("Test");
        bookCSVService.create(book);
        book.setTitle("Demo");
        bookCSVService.update(book);
        book = bookCSVService.read(book.getId());
        assertEquals("Demo", book.getTitle());
    }

    @Test
    @Order(4)
    public void deleteBook() {
        Book book = new Book("Test");
        bookCSVService.create(book);
        bookCSVService.delete(book.getId());
        assertNull(bookCSVService.read(book.getId()));
    }


}
