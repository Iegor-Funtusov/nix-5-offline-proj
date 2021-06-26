package ua.com.nix.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.nix.model.Author;

import java.util.List;

public class AuthorDaoImplTest {

    final static private String NAME = "Ivan";
    final static private String LAST_NAME = "Ivanov";
    private static final AuthorDaoImpl authorDao = new AuthorDaoImpl();

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Author author = new Author();
            author.setFirstName(NAME + i);
            author.setLastName(LAST_NAME + i);
            authorDao.create(author);
        }
        List<Author> authors = authorDao.readAll();
        Assertions.assertEquals(10, authors.size());
    }

    @Test
    @Order(2)
    public void delete(){
        List<Author> authors = authorDao.readAll();
        String id = authors.get(5).getId();
        Author author = authors.get(5);
        authorDao.delete(authors.get(5).getId());
        authors = authorDao.readAll();
            Assertions.assertEquals(9, authors.size());
            Assertions.assertFalse(author.isInvisible());
    }
    @Test
    @Order(3)
    public void update() {
        List<Author> authors = authorDao.readAll();
        Author updatedAuthor;
        for (int i = 0; i < authors.size(); i++) {
            if (i == 3) {
                updatedAuthor = authors.get(i);
                updatedAuthor.setFirstName("new FirstName" + i);
                updatedAuthor.setLastName("new LastName" + i);
                authorDao.update(updatedAuthor);
            }
        }
        Assertions.assertEquals(9, authors.size());
    }
    @Order(4)
    @Test
    public void findById(){
        List<Author> authors = authorDao.readAll();
        Assertions.assertNotNull(authorDao.read(authors.get(5).getId()));
    }
    @Order(5)
    @Test
    public void findAll() {
        List<Author> authors = authorDao.readAll();
        Assertions.assertNotNull(authors);
    }
}

