import dataclasses.Author;
import dataclasses.Book;
import org.junit.jupiter.api.*;
import serviceclasses.BookManagementService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookManagementServiceTest {
    final static private String NAME = "Name";
    final static private String TITLE = "Title";
    private static final BookManagementService bookManagementService = new BookManagementService();

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Author author = new Author();
            author.setFirstName(NAME + i);
            bookManagementService.createAuthor(author);
        }
        Assertions.assertEquals(10, bookManagementService.getAllAuthors().length);

        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setTitle(TITLE + i);
            bookManagementService.createBook(book);
        }
        Assertions.assertEquals(10, bookManagementService.getAllBooks().length);
    }

    @Test
    @Order(2)
    public void update() {
        Author newAuthor;
        for (int i = 0; i < bookManagementService.getAllAuthors().length; i++) {
            newAuthor = bookManagementService.getAllAuthors()[i];
            newAuthor.setFirstName("new" + bookManagementService.getAllAuthors()[i].getFirstName());
            bookManagementService.updateAuthor(newAuthor);
        }
        Assertions.assertTrue(bookManagementService.getAllAuthors() != null && bookManagementService.getAllAuthors().length == 10
                && bookManagementService.getAllAuthors()[5].getFirstName().contains("new"));

        Book newBook;
        for (int i = 0; i < bookManagementService.getAllBooks().length; i++) {
            newBook = bookManagementService.getAllBooks()[i];
            newBook.setTitle("new" + bookManagementService.getAllBooks()[i].getTitle());
            bookManagementService.updateBook(newBook);
        }
        Assertions.assertTrue(bookManagementService.getAllBooks() != null && bookManagementService.getAllBooks().length == 10
                && bookManagementService.getAllBooks()[5].getTitle().contains("new"));
    }

    @Test
    @Order(3)
    public void setRelation() {
        Author author = bookManagementService.getAllAuthors()[0];
        author.setBooks(bookManagementService.getAllBooks());
        bookManagementService.updateAuthor(author);

        Book book = bookManagementService.getAllBooks()[0];
        book.setAuthors(bookManagementService.getAllAuthors());
        bookManagementService.updateBook(book);

        Assertions.assertTrue(bookManagementService.getAllBooks()[0].getAuthors().length == 10
                && bookManagementService.getAllAuthors()[0].getBooks().length == 10
                && bookManagementService.getAllAuthors()[5].getBooks().length == 1
                && bookManagementService.getAllBooks()[5].getAuthors().length == 1);
    }

    @Order(4)
    @Test
    public void findById() {
        Assertions.assertNotNull(bookManagementService.getAuthorById(bookManagementService.getAllAuthors()[5].getId()));
        Assertions.assertNotNull(bookManagementService.getBookById(bookManagementService.getAllBooks()[5].getId()));
    }

    @Order(5)
    @Test
    public void delete() {
        Assertions.assertTrue(bookManagementService.getAllAuthors() != null && bookManagementService.getAllAuthors().length == 10);
        bookManagementService.deleteAuthor(bookManagementService.getAllAuthors()[5]);
        Assertions.assertTrue(bookManagementService.getAllAuthors() != null && bookManagementService.getAllAuthors().length == 9);

        Assertions.assertTrue(bookManagementService.getAllBooks() != null && bookManagementService.getAllBooks().length == 10);
        bookManagementService.deleteBook(bookManagementService.getAllBooks()[5]);
        Assertions.assertTrue(bookManagementService.getAllBooks() != null && bookManagementService.getAllBooks().length == 9);
    }
}