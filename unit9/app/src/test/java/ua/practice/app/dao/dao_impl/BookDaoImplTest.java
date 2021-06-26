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
class BookDaoImplTest {

    BookDaoImpl bookDao = new BookDaoImpl();
    static Book book;
    static List<Author> authors = new ArrayList<>();
    static List<Book> books = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        book = new Book();
        book.setName("testBookName");
        for (int i = 0; i < 10; i++) {
            Author author = new Author("name" + i, "lname" + i);
            authors.add(author);
            Book book = new Book();
            book.setName("name" + i);
            book.setAuthors(authors);
            books.add(book);
        }
    }

    @AfterAll
    static void afterAll() {
        File file = new File("Book_database.csv");
        file.delete();
    }

    @Test
    @Order(1)
    void createTest() {
        bookDao.create(book);
        List<String[]> rows = IOProcessor.readAllData(Book.class);
        assertEquals(1, rows.size());
        assertEquals(1, bookDao.read().size());
    }

    @Test
    @Order(2)
    void updateTest() {
        String newName = "new testName";
        book.setName(newName);
        bookDao.update(book);
        book = bookDao.read(book.getId());
        assertEquals(newName, book.getName());
    }


    @Test
    @Order(3)
    void deleteTest() {
        bookDao.delete(book.getId());
        List<Book> books = bookDao.read();
        assertEquals(0, books.size());
        assertThrows(RuntimeException.class, () -> bookDao.read(book.getId()));
    }

    @Test
    @Order(4)
    void createTest1() {
        books.forEach(bookDao::create);
        List<Book> books = bookDao.read();
        assertEquals(10, books.size());
        assertEquals(authors, books.get(9).getAuthors());
    }

    @Test
    @Order(5)
    void deleteTest1() {
        books.forEach((book1 -> bookDao.delete(book1.getId())));
        List<Book> books = bookDao.read();
        assertEquals(0, books.size());
    }
}