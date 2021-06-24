import com.nix.control.ControlAuthor;
import com.nix.control.ControlBook;
import com.nix.pojo_objects.Author;
import com.nix.pojo_objects.Book;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorControlTest {


    final static private String FIRST_NAME = "Hol";
    final static private String LAST_NAME = "Ron";

    private static final ControlAuthor CONTROL_AUTHOR = new ControlAuthor();
    private static final ControlBook CONTROL_BOOK = new ControlBook();

    @Test
    @BeforeAll
    static void CommonTest() {
        for (int i = 0; i < 10; i++) {
            Author author = new Author();
            author.setFirstName(FIRST_NAME + i);
            author.setLastName(LAST_NAME + i);
            CONTROL_AUTHOR.create(author);
        }
        List<Author> authors = CONTROL_AUTHOR.read();

        Author newAuthor;
        newAuthor = authors.get(0);
        newAuthor.setFirstName(FIRST_NAME + "F" + 10);
        CONTROL_AUTHOR.update(newAuthor);

        authors = CONTROL_AUTHOR.read();

        CONTROL_AUTHOR.delete(authors.get(0));
        CONTROL_AUTHOR.delete(authors.get(1));

        authors = CONTROL_AUTHOR.read();

        Assertions.assertEquals(authors.size(), 8);
    }

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Author author = new Author();
            author.setFirstName(FIRST_NAME + i);
            author.setLastName(LAST_NAME + i);
            CONTROL_AUTHOR.create(author);
        }
        List<Author> authors = CONTROL_AUTHOR.read();
        Assertions.assertTrue(authors != null && authors.size() == 18);
    }

    @Test
    @Order(2)
    public void update() {
        List<Author> authors = CONTROL_AUTHOR.read();
        Author newAuthor;
        for (int i = 0; i < authors.size(); i++) {
            newAuthor = authors.get(i);
            newAuthor.setFirstName(FIRST_NAME + i + 10);
            CONTROL_AUTHOR.update(newAuthor);
        }
        Assertions.assertEquals(18, authors.size());
    }

    @Test
    @Order(3)
    public void deleteAll() {
        List<Author> authors = CONTROL_AUTHOR.read();
        for (Author value : authors) {
            CONTROL_AUTHOR.delete(value);
        }
        authors = CONTROL_AUTHOR.read();
        for (Author author : authors) {
            Assertions.assertNull(author);
        }
    }

    @Test
    @Order(4)
    public void readAuthors() {
        Assertions.assertEquals(0, CONTROL_AUTHOR.read().size());
    }

    @Test
    @Order(5)
    public void readAuthorBooks() {
        Author author = new Author();
        author.setFirstName(FIRST_NAME);
        author.setLastName(LAST_NAME);
        CONTROL_AUTHOR.create(author);

        Book book = new Book();
        book.setTitle("Ready player one");
        CONTROL_BOOK.create(book);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        book = new Book();
        book.setTitle("Ready player two");
        CONTROL_BOOK.create(book);
        bookList.add(book);

        author.setBookList(bookList);
        Assertions.assertEquals(CONTROL_AUTHOR.readList(author).size(), 2);
    }
}
