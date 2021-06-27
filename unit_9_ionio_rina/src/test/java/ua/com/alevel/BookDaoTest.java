package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class BookDaoTest{

    private static final String NAME = "name";
    private static final String NAME_NEW = "nameNEW";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final BookDao bookDao = new BookDao();
    private static List<Book> books = new ArrayList<>();
    private static List<Author> authors = new ArrayList<>();

    @BeforeAll
    static void setUp(){
        new File("books.csv").delete();
        for (int i = 0; i < 8; i++) {
            Author a = new Author();
            a.setId(Integer.toString(i));
            a.setFirstName(FIRST_NAME+i);
            a.setLastName(LAST_NAME+i);
            authors.add(a);
        }
        for (int i = 0; i < 4; i++) {
            List<Author> a = new ArrayList<>();
            a.add(authors.get(i));
            a.add(authors.get(i+1));
            Book b = new Book();
            b.setId(Integer.toString(i));
            b.setName(NAME+i);
            b.setAuthors(a);
            books.add(b);
            bookDao.create(b);
        }
    }

    @Test
    public void create(){
        List<Author> authors = new ArrayList<>();
        Author a = new Author();
        a.setId("11");
        a.setFirstName("fName");
        a.setLastName("lName");
        authors.add(a);
        Book book = new Book();
        book.setId("11");
        book.setName(NAME);
        book.setAuthors(authors);

        bookDao.create(book);

        Book book1 = bookDao.readById(book.getId());

        Assertions.assertEquals(book, book1);
    }

    @Test
    public void update(){
        Book book = books.get(0);
        book.setName(NAME_NEW);

        bookDao.update(book);

        Book bookUpdated = bookDao.readById(book.getId());

        Assertions.assertEquals(book, bookUpdated);
    }

    @Test
    public void delete(){
        Book book = books.get(1);

        bookDao.delete(book.getId());

        Book book1 = bookDao.readById(book.getId());

        Assertions.assertNull(book1);
    }

    @Test
    public void readById(){
        Book book = books.get(2);

        Book book1 = bookDao.readById(book.getId());

        Assertions.assertNotNull(book1);
    }

    @Test
    public void readAll(){
        List<Book> bookList = bookDao.readAll();
        int size = bookList.size();

        Assertions.assertNotEquals(0, size);
    }
}