import org.junit.jupiter.api.*;
import ua.com.alevel.app.service.author.AuthorCrudFactoryService;
import ua.com.alevel.app.service.author.AuthorService;
import ua.com.alevel.app.service.book.BookCrudFactoryService;
import ua.com.alevel.app.service.book.BookService;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookCommonTest {
    final static private String TITLE = "test";
    final static private String NAME = "test1";
    final static private String LAST_NAME = "test2";

    private static final AuthorCrudFactoryService authorCrudFactoryService = new AuthorCrudFactoryService();
    private static final BookCrudFactoryService bookCrudFactoryService = new BookCrudFactoryService();

    @Test
    @BeforeAll
    static void CommonTest() {
        for (int i = 0; i < 10; i++) {
            BookService bookService = new BookService();
            bookService.setTitle(TITLE + i);
            bookCrudFactoryService.create(bookService);
        }
        List<BookService> books = bookCrudFactoryService.read();

        BookService book;
        book = books.get(0);
        book.setTitle(NAME + "F" + 10);
        bookCrudFactoryService.update(books.get(0).getId());

        books = bookCrudFactoryService.read();

        bookCrudFactoryService.delete(books.get(0));
        bookCrudFactoryService.delete(books.get(1));

        books = bookCrudFactoryService.read();

        Assertions.assertEquals(books.size(), 8);
    }

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            BookService bookService = new BookService();
            bookService.setTitle(TITLE + i);
            bookCrudFactoryService.create(bookService);
        }
        List<BookService> books = bookCrudFactoryService.read();
        Assertions.assertTrue(books != null && books.size() == 18);
    }

    @Test
    @Order(2)
    public void update() {
        List<BookService> books = bookCrudFactoryService.read();
        BookService author;
        for (int i = 0; i < books.size(); i++) {
            author = books.get(i);
            author.setTitle(TITLE + i + 10);
            bookCrudFactoryService.update(books.get(0).getId());
        }
        Assertions.assertEquals(18, books.size());
    }

    @Test
    @Order(3)
    public void deleteAll() {
        List<BookService> books = bookCrudFactoryService.read();
        for (BookService value : books) {
            bookCrudFactoryService.delete(value);
        }
        books = bookCrudFactoryService.read();
        for (BookService bookService : books) {
            Assertions.assertNull(bookService);
        }
    }

    @Test
    @Order(4)
    public void readAuthors() {
        Assertions.assertEquals(bookCrudFactoryService.read().size(), 0);
    }

    @Test
    @Order(5)
    public void readAuthorBooks() {
        AuthorService authorService = new AuthorService();
        authorService.setName(NAME);
        authorService.setLastname(LAST_NAME);
        authorCrudFactoryService.create(authorService);

        List<AuthorService> authors = new ArrayList<>();
        authors.add(authorService);

        authorService = new AuthorService();
        authorService.setName(NAME);
        authorService.setLastname(LAST_NAME);
        authorCrudFactoryService.create(authorService);

        authors.add(authorService);

        BookService bookService = new BookService();
        bookService.setTitle(TITLE);
        bookCrudFactoryService.create(bookService);

        bookService.setAuthorList(authors);

        Assertions.assertEquals(bookCrudFactoryService.readList(bookService).size(), 2);
    }
}
