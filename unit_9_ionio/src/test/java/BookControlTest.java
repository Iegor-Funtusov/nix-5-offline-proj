import com.nix.control.ControlAuthor;
import com.nix.control.ControlBook;
import com.nix.pojo_objects.Author;
import com.nix.pojo_objects.Book;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookControlTest {


    final static private String TITLE = "Ready";

    final static private String FIRST_NAME = "Hol";
    final static private String LAST_NAME = "Ron";

    private static final ControlAuthor CONTROL_AUTHOR = new ControlAuthor();
    private static final ControlBook CONTROL_BOOK = new ControlBook();

    @Test
    @BeforeAll
    static void CommonTest() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setTitle(TITLE + i);
            CONTROL_BOOK.create(book);
        }
        List<Book> books = CONTROL_BOOK.read();

        Book newBook;
        newBook = books.get(0);
        newBook.setTitle(FIRST_NAME + "F" + 10);
        CONTROL_BOOK.update(books.get(0).getId());

        books = CONTROL_BOOK.read();

        CONTROL_BOOK.delete(books.get(0));
        CONTROL_BOOK.delete(books.get(1));

        books = CONTROL_BOOK.read();

        Assertions.assertEquals(books.size(), 8);
    }

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setTitle(TITLE + i);
            CONTROL_BOOK.create(book);
        }
        List<Book> books = CONTROL_BOOK.read();
        Assertions.assertTrue(books != null && books.size() == 18);
    }

    @Test
    @Order(2)
    public void update() {
        List<Book> books = CONTROL_BOOK.read();
        Book newAuthor;
        for (int i = 0; i < books.size(); i++) {
            newAuthor = books.get(i);
            newAuthor.setTitle(TITLE + i + 10);
            CONTROL_BOOK.update(books.get(0).getId());
        }
        Assertions.assertEquals(18, books.size());
    }

    @Test
    @Order(3)
    public void deleteAll() {
        List<Book> books = CONTROL_BOOK.read();
        for (Book value : books) {
            CONTROL_BOOK.delete(value);
        }
        books = CONTROL_BOOK.read();
        for (Book book : books) {
            Assertions.assertNull(book);
        }
    }

    @Test
    @Order(4)
    public void readAuthors() {
        Assertions.assertEquals(CONTROL_BOOK.read().size(), 0);
    }

    @Test
    @Order(5)
    public void readAuthorBooks() {
        Author author = new Author();
        author.setFirstName(FIRST_NAME);
        author.setLastName(LAST_NAME);
        CONTROL_AUTHOR.create(author);

        List<Author> authors = new ArrayList<>();
        authors.add(author);

        author = new Author();
        author.setFirstName(FIRST_NAME);
        author.setLastName(LAST_NAME);
        CONTROL_AUTHOR.create(author);

        authors.add(author);

        Book book = new Book();
        book.setTitle(TITLE);
        CONTROL_BOOK.create(book);

        book.setAuthorList(authors);

        Assertions.assertEquals(CONTROL_BOOK.readList(book).size(), 2);
    }
}
