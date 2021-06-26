package ua.practice.app.dao.dao_impl;

import org.junit.jupiter.api.*;
import ua.practice.app.io_processor.IOProcessor;
import ua.practice.app.entity.Author;
import ua.practice.app.entity.Book;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AuthorDaoImplTest {
    AuthorDaoImpl authorDao = new AuthorDaoImpl();
    static Author author;
    static List<Author> authors = new ArrayList<>();
    static List<Book> books = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        author = new Author("testName", "testLastName");
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setName("name" + i);
            books.add(book);
            Author author = new Author("name" + i, "lname" + i);
            author.setBooks(books);
            authors.add(author);
        }
    }

    @AfterAll
    static void afterAll() {
        File file = new File("Author_database.csv");
        file.delete();
    }

    @Test
    @Order(1)
    void createTest() {
        authorDao.create(author);
        List<String[]> rows = IOProcessor.readAllData(Author.class);
        assertEquals(1, rows.size());
    }

    @Test
    @Order(2)
    void updateTest() {
        String newName = "new testName";
        author.setName(newName);
        authorDao.update(author);
        author = authorDao.read(author.getId());
        assertEquals(newName, author.getName());
    }

    @Test
    @Order(3)
    void deleteTest() {
        authorDao.delete(author.getId());
        List<Author> authors = authorDao.read();
        assertEquals(0, authors.size());
        assertThrows(RuntimeException.class, () -> authorDao.read(author.getId()));
    }

    @Test
    @Order(4)
    void createTest1() {
        authors.forEach(authorDao::create);
        List<Author> authors = authorDao.read();
        assertEquals(10, authors.size());
        assertEquals(books, authors.get(9).getBooks());
    }

    @Test
    @Order(5)
    void deleteTest1() {
        authors.forEach((author1 -> authorDao.delete(author1.getId())));
        List<Author> authors = authorDao.read();
        assertEquals(0, authors.size());
    }
}