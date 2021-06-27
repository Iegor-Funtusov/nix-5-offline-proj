import org.junit.jupiter.api.*;
import ua.com.alevel.app.service.author.AuthorCrudFactoryService;
import ua.com.alevel.app.service.author.AuthorService;
import ua.com.alevel.app.service.book.BookCrudFactoryService;
import ua.com.alevel.app.service.book.BookService;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorCommonTest {
    final static private String NAME = "Test";
    final static private String LAST_NAME = "Test1";

    private static final AuthorCrudFactoryService authorCrudFactoryService = new AuthorCrudFactoryService();
    private static final BookCrudFactoryService bookCrudFactoryService = new BookCrudFactoryService();

    @Test
    @BeforeAll
    static void CommonTest() {
        for (int i = 0; i < 10; i++) {
            AuthorService authorService = new AuthorService();
            authorService.setName(NAME + i);
            authorService.setLastname(LAST_NAME + i);
            authorCrudFactoryService.create(authorService);
        }
        List<AuthorService> authors = authorCrudFactoryService.read();

        AuthorService author;
        author = authors.get(0);
        author.setName(NAME + "test" + 10);
        authorCrudFactoryService.update(author);

        authors = authorCrudFactoryService.read();

        authorCrudFactoryService.delete(authors.get(0));
        authorCrudFactoryService.delete(authors.get(1));

        authors = authorCrudFactoryService.read();

        Assertions.assertEquals(authors.size(), 8);
    }

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            AuthorService authorService = new AuthorService();
            authorService.setName(NAME + i);
            authorService.setLastname(LAST_NAME + i);
            authorCrudFactoryService.create(authorService);
        }
        List<AuthorService> authors = authorCrudFactoryService.read();
        Assertions.assertTrue(authors != null && authors.size() == 18);
    }

    @Test
    @Order(2)
    public void update() {
        List<AuthorService> authors = authorCrudFactoryService.read();
        AuthorService author;
        for (int i = 0; i < authors.size(); i++) {
            author = authors.get(i);
            author.setName(NAME + i + 10);
            authorCrudFactoryService.update(author);
        }
        Assertions.assertEquals(18, authors.size());
    }

    @Test
    @Order(3)
    public void deleteAll() {
        List<AuthorService> authors = authorCrudFactoryService.read();
        for (AuthorService value : authors) {
            authorCrudFactoryService.delete(value);
        }
        authors = authorCrudFactoryService.read();
        for (AuthorService authorService : authors) {
            Assertions.assertNull(authorService);
        }
    }

    @Test
    @Order(4)
    public void readAuthors() {
        Assertions.assertEquals(0, authorCrudFactoryService.read().size());
    }

    @Test
    @Order(5)
    public void readAuthorBooks() {
        AuthorService authorService = new AuthorService();
        authorService.setName(NAME);
        authorService.setLastname(LAST_NAME);
        authorCrudFactoryService.create(authorService);

        BookService bookService = new BookService();
        bookService.setTitle("Test2");
        bookCrudFactoryService.create(bookService);

        List<BookService> bookList = new ArrayList<>();
        bookList.add(bookService);

        bookService = new BookService();
        bookService.setTitle("Ready player two");
        bookCrudFactoryService.create(bookService);
        bookList.add(bookService);

        authorService.setBookList(bookList);
        Assertions.assertEquals(authorCrudFactoryService.readList(authorService).size(), 2);
    }
}
