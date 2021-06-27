import daoclasses.AuthorDao;
import dataclasses.Author;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorDaoTest {
    final static private String NAME = "Name";
    private static final AuthorDao authorDao = new AuthorDao();

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Author author = new Author();
            author.setFirstName(NAME + i);
            authorDao.create(author);
        }
        Author[] authors = authorDao.getAllAuthors();
        Assertions.assertEquals(10, authors.length);
    }

    @Test
    @Order(2)
    public void update() {
        Author newAuthor;
        for (int i = 0; i < authorDao.getAllAuthors().length; i++) {
            newAuthor = authorDao.getAllAuthors()[i];
            newAuthor.setFirstName("new" + authorDao.getAllAuthors()[i].getFirstName());
            authorDao.update(newAuthor);
        }
        Assertions.assertTrue(authorDao.getAllAuthors() != null && authorDao.getAllAuthors().length == 10
                && authorDao.getAllAuthors()[5].getFirstName().contains("new"));
    }

    @Order(3)
    @Test
    public void findById() {
        Assertions.assertNotNull(authorDao.getById(authorDao.getAllAuthors()[5].getId()));
    }

    @Order(4)
    @Test
    public void delete() {
        Assertions.assertTrue(authorDao.getAllAuthors() != null && authorDao.getAllAuthors().length == 10);
        authorDao.delete(authorDao.getAllAuthors()[5].getId());
        Assertions.assertTrue(authorDao.getAllAuthors() != null && authorDao.getAllAuthors().length == 9);
    }
}