package ua.practice.unit6.application.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.practice.unit6.application.entity.Book;
import ua.practice.unit6.application.service.serviceImpl.BookServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {
    BookServiceImpl bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookServiceImpl();
    }

    @AfterEach
    void tearDown() {
        bookService = null;
    }

    @Test
    void create() {
        Book book = new Book();
        book.setName("test");
        bookService.create(book);
        assertEquals(1, bookService.read().size());
    }

    @Test
    void create1() {;
        assertDoesNotThrow(()->bookService.create(null));
    }

    @Test
    void create2() {;
        for (int i = 0; i < 10; i++) {
            bookService.create(new Book());
        }
        assertEquals(10, bookService.read().size());
    }

    @Test
    void update() {
        Book book = new Book();
        book.setName("test");
        bookService.create(book);

        book.setName("newName");
        bookService.update(book);

        assertEquals(book.getName(), bookService.read(book.getId()).getName());
    }

    @Test
    void update1() {
        assertDoesNotThrow(()->bookService.update(null));
    }

    @Test
    void update2() {
        Book book = new Book();
        book.setId("asdjbasjdbaskkjncl");
        assertDoesNotThrow(()->bookService.update(book));
    }

    @Test
    void delete() {
        Book book = new Book();
        book.setName("test");
        bookService.create(book);

        bookService.delete(book.getId());
        assertEquals(0, bookService.read().size());
    }

    @Test
    void delete1() {
        assertDoesNotThrow(()->bookService.delete(null));
    }

    @Test
    void read() {
        assertEquals(0, bookService.read().size());
    }

    @Test
    void testRead() {
        assertDoesNotThrow(()->bookService.read(null));
    }

    @Test
    void testRead1() {
        assertDoesNotThrow(()->bookService.read("a;sidbasihbcijsdncdsnc"));
    }
}