package ua.practice.unit6.application.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.practice.unit6.application.DAO.daoImpl.AuthorDAOImpl;
import ua.practice.unit6.application.entity.Author;
import ua.practice.unit6.application.service.serviceImpl.AuthorServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class AuthorServiceImplTest {
    AuthorServiceImpl authorService;

    @BeforeEach
    void setUp() {
        authorService = new AuthorServiceImpl();
    }

    @AfterEach
    void tearDown() {
        authorService = null;
    }

    @Test
    void create() {
        Author author = new Author();
        author.setName("test");
        authorService.create(author);
        assertEquals(1, authorService.read().size());
    }

    @Test
    void create1() {;
        assertDoesNotThrow(()->authorService.create(null));
    }

    @Test
    void create2() {;
        for (int i = 0; i < 10; i++) {
            authorService.create(new Author());
        }
        assertEquals(10, authorService.read().size());
    }

    @Test
    void update() {
        Author author = new Author();
        author.setName("test");
        authorService.create(author);

        author.setName("newName");
        authorService.update(author);

        assertEquals(author.getName(), authorService.read(author.getId()).getName());
    }

    @Test
    void update1() {
        assertDoesNotThrow(()->authorService.update(null));
    }

    @Test
    void update2() {
        Author author = new Author();
        author.setId("asdjbasjdbaskkjncl");
        assertDoesNotThrow(()->authorService.update(author));
    }

    @Test
    void delete() {
        Author author = new Author();
        author.setName("test");
        authorService.create(author);

        authorService.delete(author.getId());
        assertEquals(0, authorService.read().size());
    }

    @Test
    void delete1() {
        assertDoesNotThrow(()->authorService.delete(null));
    }

    @Test
    void read() {
        assertEquals(0, authorService.read().size());
    }

    @Test
    void testRead() {
        assertDoesNotThrow(()->authorService.read(null));
    }

    @Test
    void testRead1() {
        assertDoesNotThrow(()->authorService.read("a;sidbasihbcijsdncdsnc"));
    }
}