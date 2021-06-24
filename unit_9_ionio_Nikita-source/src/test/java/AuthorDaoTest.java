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
            author.setName(NAME + i);
            authorDao.create(author);
        }
        Author[] authors = authorDao.getAll();
        Assertions.assertEquals(10, authors.length);
    }

    @Test
    @Order(2)
    public void update() {
        Author newAuthor;
        for (int i = 0; i < authorDao.getAll().length; i++) {
            newAuthor = authorDao.getAll()[i];
            newAuthor.setName("new" + authorDao.getAll()[i].getName());
            authorDao.update(newAuthor);
        }
        Assertions.assertTrue(authorDao.getAll() != null && authorDao.getAll().length == 10
                && authorDao.getAll()[5].getName().contains("new"));
    }

    @Order(3)
    @Test
    public void findById() {
        Assertions.assertNotNull(authorDao.getById(authorDao.getAll()[5].getId()));
    }

    @Order(4)
    @Test
    public void delete() {
        Assertions.assertTrue(authorDao.getAll() != null && authorDao.getAll().length == 10);
        authorDao.delete(authorDao.getAll()[5].getId());
        Assertions.assertTrue(authorDao.getAll() != null && authorDao.getAll().length == 9);
    }
}