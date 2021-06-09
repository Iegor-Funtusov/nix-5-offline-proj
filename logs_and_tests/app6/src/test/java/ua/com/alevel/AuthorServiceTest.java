package ua.com.alevel;

import ua.com.alevel.app.Author;
import ua.com.alevel.app.AuthorService;
import ua.com.alevel.lib.CrudFactory;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorServiceTest {
    private static Author testAuthor;
    private static final AuthorService authorService = new AuthorService();
    private static CrudFactory crudFactory;
    private static final String NAME = "test";
    private static final String LASTNAME = "test1";

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < 10; i++) {
            Author author = new Author();
            author.setName(NAME);
            author.setLastname(String.valueOf(i * 2));
            authorService.createAuthor(author);
        }
        crudFactory = authorService.readAuthor();
        testAuthor = (Author) crudFactory.get(9);
    }

    @Test
    @Order(1)
    public void createAuthor() {
        Author author = new Author();
        author.setName(NAME);
        author.setLastname(LASTNAME);
        assertEquals(10, authorService.readAuthor().size());
        assertEquals(NAME, author.getName());
        assertEquals(LASTNAME, author.getLastname());
    }

    @Test
    @Order(2)
    public void readAuthor() {
        testAuthor = (Author) crudFactory.get(5);
        assertNotEquals(null, authorService.readAuthor(testAuthor.getId()));
    }

    @Test
    @Order(3)
    public void updateAuthor() {
        CrudFactory crudFactory = authorService.readAuthor();
        Author author = (Author) crudFactory.get(5);
        author.setName(NAME);
        author.setLastname(LASTNAME);
        authorService.updateAuthor(author);
        author = (Author) crudFactory.get(5);
        assertEquals(LASTNAME, author.getLastname());
    }

    @Test
    @Order(4)
    public void deleteAuthor() {
        authorService.deleteAuthor(testAuthor.getId());
        assertEquals(9, authorService.readAuthor().size());
    }
}
