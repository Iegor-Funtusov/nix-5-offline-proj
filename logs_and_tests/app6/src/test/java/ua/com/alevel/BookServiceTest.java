package ua.com.alevel;

import ua.com.alevel.app.Book;
import ua.com.alevel.app.BookService;
import ua.com.alevel.lib.CrudFactory;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookServiceTest {
    private static Book testBook;
    private static final BookService bookService = new BookService();
    private static CrudFactory crudFactory;
    private static final String TITLE = "title";

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setTitle(TITLE);
            bookService.createBook(book);
        }
        crudFactory = bookService.readBook();
        testBook = (Book) crudFactory.get(9);
    }

    @Test
    @Order(1)
    public void createBook() {
        Book book = new Book();
        book.setTitle(TITLE);
        assertEquals(10, bookService.readBook().size());
        assertEquals(TITLE, book.getTitle());
    }

    @Test
    @Order(2)
    public void readBook() {
            testBook = (Book) crudFactory.get(5);
        assertNotEquals(null, bookService.readBook(testBook.getId()));
    }

    @Test
    @Order(3)
    public void updateBook() {
        CrudFactory crudFactory = bookService.readBook();
        Book book = (Book) crudFactory.get(5);
        book.setTitle(TITLE);
        bookService.updateBook(book);
        book = (Book) crudFactory.get(5);
        assertEquals(TITLE, book.getTitle());
    }

    @Test
    @Order(4)
    public void deleteBook() {
        bookService.deleteBook(testBook.getId());
        assertEquals(9, bookService.readBook().size());
    }
}
