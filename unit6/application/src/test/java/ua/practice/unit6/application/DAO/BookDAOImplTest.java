package ua.practice.unit6.application.DAO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.practice.unit6.application.DAO.daoImpl.BookDAOImpl;
import ua.practice.unit6.application.entity.Book;

import static org.junit.jupiter.api.Assertions.*;

class BookDAOImplTest {
    BookDAOImpl bookDAO;

    @BeforeEach
    void setUp() {
        bookDAO = new BookDAOImpl();
    }

    @AfterEach
    void tearDown() {
        bookDAO = null;
    }

    @Test
    @DisplayName("Size after create increases")
    void create() {
        Book book = new Book();
        book.setName("test");
        book.setYearOfPublishing(1987);
        bookDAO.create(book);
        assertEquals(1, bookDAO.read().size());
    }

    @Test
    @DisplayName("Book exists in DB after create")
    void create1() {
        Book book = new Book();
        book.setName("test");
        book.setYearOfPublishing(1987);
        bookDAO.create(book);
        assertEquals(book.getId(), bookDAO.read(book.getId()).getId());
    }

    @Test
    @DisplayName("Size works properly after multiple create")
    void create2() {
        Book book = new Book();
        book.setName("test");
        Book book1 = new Book();
        book.setName("test1");
        Book book2 = new Book();
        book.setName("test2");
        bookDAO.create(book);
        bookDAO.create(book1);
        bookDAO.create(book2);
        assertEquals(3, bookDAO.read().size());
    }

    @Test
    void update() {
        Book book = new Book();
        book.setName("test");
        book.setYearOfPublishing(1987);
        bookDAO.create(book);
        book.setName("changedName");
        book.setYearOfPublishing(2000);
        bookDAO.update(book);

        assertEquals(book.getName(), bookDAO.read(book.getId()).getName());
        assertEquals(book.getYearOfPublishing(), bookDAO.read(book.getId()).getYearOfPublishing());
    }

    @Test
    void delete() {
        Book book = new Book();
        book.setName("test");
        book.setYearOfPublishing(1987);
        bookDAO.create(book);

        bookDAO.delete(book.getId());
        assertEquals(0, bookDAO.read().size());
    }
}