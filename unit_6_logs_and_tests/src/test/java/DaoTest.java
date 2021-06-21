import dao.AuthorDao;
import dao.BookDao;
import entity.Author;
import entity.Book;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import service.AuthorService;
import service.BookService;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DaoTest {
    private static final String NAME = "test";
    private static final String NAME_UPDATE = "test10";
    private static BookDao bookDao = new BookDao();
    private static AuthorDao authorDao = new AuthorDao();


    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < 10; i++) {

            authorDao.create(NAME+i);

            Author author = authorDao.read(i+1);
            if (author == null) {
                break;
            }
            for (int j = 0; j < 10; j++) {

                bookDao.create(NAME + j, author);
            }
        }
        ArrayList<Book> books = bookDao.readAll();
        ArrayList<Author> authors = authorDao.readAll();
        Assert.assertTrue(books != null && books.size() == 100 && authors != null && authors.size() == 10);
    }

    @Test
    @Order(1)
    public void create() {

        authorDao.create(NAME);

        ArrayList<Author> authors = authorDao.findByName(NAME);

        bookDao.create(NAME,authors.get(0));

        ArrayList<Book> books = bookDao.findByName(NAME);

        Assert.assertTrue(books != null && books.size() == 1 && authors != null && authors.size() == 1);

    }

    @Test
    @Order(2)
    public void delete() {

        List<Book> books = bookDao.findByName(NAME);
        Assert.assertTrue(books != null && books.size() == 1);

        bookDao.delete(books.get(0).getId());

        books = bookDao.readAll();
        Assert.assertTrue(books != null && books.size() == 100);






        List<Author> authors = authorDao.findByName(NAME);
        Assert.assertTrue(authors != null && authors.size() == 1);

        authorDao.delete(authors.get(0).getId());

        authors = authorDao.readAll();
        Assert.assertTrue(authors != null && authors.size() == 10);
    }

    @Test
    @Order(3)
    public void update() {

        authorDao.update(5,NAME_UPDATE);

        Author author = authorDao.read(5);
        Assert.assertEquals(author.getName(), NAME_UPDATE);

        bookDao.update(5,NAME_UPDATE,author);

        Book book = bookDao.read(5);
        Assert.assertEquals(book.getName(), NAME_UPDATE);
    }
}

