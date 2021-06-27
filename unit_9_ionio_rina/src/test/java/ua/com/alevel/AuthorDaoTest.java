package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class AuthorDaoTest{
    private static final String NAME = "name";
    private static final String NAME_NEW = "nameNEW";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final AuthorDao authorDao = new AuthorDao();
    private static List<Book> books = new ArrayList<>();
    private static List<Author> authors = new ArrayList<>();

    @BeforeAll
    static void setUp(){
        new File("authors.csv").delete();
        for (int i = 0; i < 8; i++) {
            Book b = new Book();
            b.setId(Integer.toString(i));
            b.setName(NAME+i);

            books.add(b);
        }
        for (int i = 0; i < 4; i++) {
            List<Book> b = new ArrayList<>();
            b.add(books.get(i));
            b.add(books.get(i+1));
            Author a = new Author();
            a.setId(Integer.toString(i));
            a.setFirstName(FIRST_NAME+i);
            a.setLastName(LAST_NAME+i);
            a.setBookList(b);

            authors.add(a);
            authorDao.create(a);
        }
    }

    @Test
    public void create(){
        Author a = authors.get(0);

        Author a1 = authorDao.readById(a.getId());

        Assertions.assertEquals(a, a1);
    }

    @Test
    public void update(){
        Author a = authors.get(1);
        a.setFirstName(NAME_NEW);

        authorDao.update(a);

        Author authorUpdated = authorDao.readById(a.getId());

        Assertions.assertEquals(a, authorUpdated);
    }

    @Test
    public void delete(){
        Author a = authors.get(2);

        authorDao.delete(a.getId());

        Author a1 = authorDao.readById(a.getId());

        Assertions.assertNull(a1);
    }

    @Test
    public void readById(){
        Author a = authors.get(3);

        Author a1 = authorDao.readById(a.getId());

        Assertions.assertNotNull(a1);
    }

    @Test
    public void readAll(){
        List<Author> authorList = authorDao.readAll();
        int size = authorList.size();

        Assertions.assertNotEquals(0, size);
    }
}