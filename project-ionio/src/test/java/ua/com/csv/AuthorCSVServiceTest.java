package ua.com.csv;

import org.junit.jupiter.api.*;
import ua.com.model.Author;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorCSVServiceTest {

    private static final AuthorCSVService authorCSVService = new AuthorCSVService();

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < 10; i++) {
            Author author = new Author(String.valueOf(i), String.valueOf(i*2));
            authorCSVService.create(author);
        }
    }

    @Test
    @Order(1)
    public void createBook() {
        Author author = new Author("Test", "Demo");
        authorCSVService.create(author);
        author = authorCSVService.read(author.getId());
        assertEquals("Test", author.getFirstName());
    }

    @Test
    @Order(2)
    public void readBook() {
        assertNull(authorCSVService.read("123"));
    }

    @Test
    @Order(3)
    public void updateBook() {
        Author author = new Author("Test", "Demo");
        authorCSVService.create(author);
        author.setFirstName("Demo");
        authorCSVService.update(author);
        author = authorCSVService.read(author.getId());
        assertEquals("Demo", author.getFirstName());
    }

    @Test
    @Order(4)
    public void deleteBook() {
        Author author = new Author("Test", "Demp");
        authorCSVService.create(author);
        authorCSVService.delete(author.getId());
        assertNull(authorCSVService.read(author.getId()));
    }


}

