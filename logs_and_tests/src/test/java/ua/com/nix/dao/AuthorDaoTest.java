package ua.com.nix.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.nix.model.Author;

public class AuthorDaoTest {

    final static private String NAME = "Ivan";
    final static private String LAST_NAME = "Ivanov";
    private static final AuthorDao authorDao = new AuthorDao();

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Author authors = new Author();
            authors.setFirstName(NAME + i);
            authors.setLastName(LAST_NAME + i);
            authorDao.create(authors);
        }
        Author[] authors = authorDao.findAll();
        Assertions.assertEquals(10, authors.length);
    }

    @Test
    @Order(2)
    public void delete(){
        Author[] authors = authorDao.findAll();
        String id = authors[5].getId();
        authorDao.delete(authors[5].getId());
        authors = authorDao.findAll();
        for (int i = 0; i < authors.length; i++) {
            Assertions.assertNotEquals(id,authors[i]);
        }
    }
    @Test
    @Order(3)
    public void update() {
        Author[] authors = authorDao.findAll();
        Author updatedAuthor;
        for (int i = 0; i < authors.length; i++) {
            if (i == 3) {
                updatedAuthor = authors[i];
                updatedAuthor.setFirstName("new FirstName" + i);
                updatedAuthor.setLastName("new LastName" + i);
                authorDao.update(updatedAuthor);
            }
        }
        Assertions.assertEquals(9, authors.length);
    }
    @Order(4)
    @Test
    public void findById(){
        Author[] authors = authorDao.findAll();
        Assertions.assertNotNull(authorDao.findById(authors[5].getId()));
    }
    @Order(5)
    @Test
    public void findAll() {
        Author[] authors = authorDao.findAll();
        Assertions.assertNotNull(authors);
    }
}

