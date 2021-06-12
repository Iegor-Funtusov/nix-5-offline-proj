package ua.practice.unit6.application.DAO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.practice.unit6.application.DAO.daoImpl.AuthorDAOImpl;
import ua.practice.unit6.application.entity.Author;

import static org.junit.jupiter.api.Assertions.*;

class AuthorDAOImplTest {
    AuthorDAOImpl authorDAO;

    @BeforeEach
    void setUp() {
        authorDAO = new AuthorDAOImpl();
    }

    @AfterEach
    void tearDown() {
        authorDAO = null;
    }

    @Test
    @DisplayName("Size after create increases")
    void create() {
        Author author = new Author();
        author.setName("test");
        authorDAO.create(author);
        assertEquals(1, authorDAO.read().size());
    }

    @Test
    @DisplayName("Author exists in DB after create")
    void create1() {
        Author author = new Author();
        author.setName("test");
        authorDAO.create(author);
        assertEquals(author.getId(), authorDAO.read(author.getId()).getId());
    }

    @Test
    @DisplayName("Size works properly after multiple create")
    void create2() {
        Author author = new Author();
        author.setName("test");
        Author author1 = new Author();
        author.setName("test1");
        Author author2 = new Author();
        author.setName("test2");
        authorDAO.create(author);
        authorDAO.create(author1);
        authorDAO.create(author2);
        assertEquals(3, authorDAO.read().size());
    }

    @Test
    void update() {
        Author author = new Author();
        author.setName("test");
        authorDAO.create(author);
        author.setName("changedName");
        authorDAO.update(author);

        assertEquals(author.getName(), authorDAO.read(author.getId()).getName());
    }

    @Test
    void delete() {
        Author author = new Author();
        author.setName("test");
        authorDAO.create(author);

        authorDAO.delete(author.getId());
        assertEquals(0, authorDAO.read().size());
    }
}