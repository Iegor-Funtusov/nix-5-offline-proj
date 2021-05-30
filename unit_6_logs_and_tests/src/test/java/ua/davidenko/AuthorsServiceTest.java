package ua.davidenko;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import ua.davidenko.authors.Authors;
import ua.davidenko.authors.AuthorsService;

public class AuthorsServiceTest {

    AuthorsService authorsService = new AuthorsService();

    @Test
    @Order(1)
    public void create() {
        Authors author = new Authors();
        author.setAuthorName("bookTitle");
        authorsService.create(author);
        String id = author.getAuthorId();
        Assertions.assertNotNull(authorsService.readById(id));
    }

    @Test
    @Order(2)
    public void update() {
        Authors[] authors = authorsService.readAll();
        for (int i = 0; i < authors.length; i++) {
            Authors updateAuthor = authors[i];
            updateAuthor.setAuthorName("newAuthorName" + i);
            authorsService.update(updateAuthor);
        }
        Assertions.assertEquals(0, authors.length);
        Assertions.assertNotNull(authors);
    }

    @Test
    @Order(3)
    public void readAll() {
        Authors[] authors = authorsService.readAll();
        Assertions.assertNotNull(authors);
    }

    @Test
    @Order(4)
    public void readAuthor() {
        Authors author = new Authors();
        author.setAuthorName("authorName");
        authorsService.create(author);
        Assertions.assertSame(author, authorsService.readById(author.getAuthorId()));
    }
    @Test
    @Order(5)
    public void deleteAll() {
        Authors[] authors = authorsService.readAll();
        for (int i = 0; i < authors.length; i++) {
            authorsService.delete(authors[i].getAuthorId());
        }
        authors = authorsService.readAll();
        for (int i = 0; i < authors.length; i++) {
            Assertions.assertNull(authors[i]);
        }
    }
}
