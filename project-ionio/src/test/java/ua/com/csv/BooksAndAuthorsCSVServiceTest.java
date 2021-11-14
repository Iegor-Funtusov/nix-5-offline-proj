package ua.com.csv;

import org.junit.jupiter.api.*;
import ua.com.model.Author;
import ua.com.model.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BooksAndAuthorsCSVServiceTest {

    private static final BooksAndAuthorsCSVService links = new BooksAndAuthorsCSVService();
    private static final AuthorCSVService authorCSV = new AuthorCSVService();
    private static final BookCSVService booksCSV = new BookCSVService();

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < 10; i++) {
            Author author = new Author(String.valueOf(i), String.valueOf(i * 2));
            Book book = new Book(String.valueOf(i));
            authorCSV.create(author);
            booksCSV.create(book);
            links.create(book, author);
        }
    }

    @Test
    @Order(1)
    public void createLink() {
        Author author = new Author("Test", "Demo");
        Book book = new Book("Test");
        authorCSV.create(author);
        booksCSV.create(book);
        links.create(book, author);
        assertEquals(1, author.getBookList().size());
    }

    @Test
    @Order(2)
    public void read(){
        Author author = new Author("Test", "Demo");
        Book book = new Book("Test");
        authorCSV.create(author);
        booksCSV.create(book);
        links.create(book, author);
        List<Book> list = links.readAuthorBooks(author.getId());
        assertEquals(1, list.size());
    }




    @Test
    @Order(3)
    public void delete() {
        Author author = new Author("Test", "Demo");
        Book book = new Book("Test");
        authorCSV.create(author);
        booksCSV.create(book);
        links.create(book, author);
        links.delete(book.getId(), author.getId());
        List<Book> list = links.readAuthorBooks(author.getId());
        assertEquals(0, list.size());
    }
}
