import daoclasses.BookDao;
import dataclasses.Book;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookDaoTest {
    final static private String TITLE = "Title";
    private static final BookDao bookDao = new BookDao();

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setTitle(TITLE + i);
            bookDao.create(book);
        }
        Book[] books = bookDao.getAllBooks();
        Assertions.assertEquals(10, books.length);
    }

    @Test
    @Order(2)
    public void update() {
        Book newBook;
        for (int i = 0; i < bookDao.getAllBooks().length; i++) {
            newBook = bookDao.getAllBooks()[i];
            newBook.setTitle("new" + bookDao.getAllBooks()[i].getTitle());
            bookDao.update(newBook);
        }
        Assertions.assertTrue(bookDao.getAllBooks() != null && bookDao.getAllBooks().length == 10
                && bookDao.getAllBooks()[5].getTitle().contains("new"));
    }

    @Order(3)
    @Test
    public void findById() {
        Assertions.assertNotNull(bookDao.getById(bookDao.getAllBooks()[5].getId()));
    }

    @Order(4)
    @Test
    public void delete() {
        Assertions.assertTrue(bookDao.getAllBooks() != null && bookDao.getAllBooks().length == 10);
        bookDao.delete(bookDao.getAllBooks()[5].getId());
        Assertions.assertTrue(bookDao.getAllBooks() != null && bookDao.getAllBooks().length == 9);
    }
}