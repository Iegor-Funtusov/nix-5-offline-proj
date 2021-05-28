package ua.com.nix.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import ua.com.nix.model.Library;

import ua.com.nix.model.Book;
import ua.com.nix.model.Author;


public class LibraryDaoTest {
    private static final LibraryDao libraryDao = new LibraryDao();
    private static Library[] libraries;

    @BeforeAll
    static void setUp() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setName("book" + i);

            Author author = new Author();
            author.setFirstName("Ivan" + i);
            author.setLastName("Ivanov" + i);

            Library library = new Library();
            library.setBook(book);
            library.setAuthor(author);

            libraryDao.create(library);
        }
        libraries = libraryDao.findAll();
        Assertions.assertEquals(10, libraries.length);
    }

    @Test
    @Order(1)
    public void create() {
        Book book = new Book();
        book.setName("Book 11");
        Author author = new Author();
        author.setFirstName("Vasya");
        author.setFirstName("Vas'kin");
        Library library = new Library();
        library.setAuthor(author);
        library.setBook(book);
        libraryDao.create(library);

        libraries = libraryDao.findAll();
        Assertions.assertEquals(11, libraries.length);

    }

    @Test
    @Order(2)
    public void delete(){
        libraries=libraryDao.findAll();
        String id = libraries[5].getId();
        libraryDao.delete(libraries[5].getId());
        libraries = libraryDao.findAll();
        for (int i = 0; i < libraries.length; i++) {
            Assertions.assertNotEquals(id,libraries[i]);
        }
        }

    @Test
    @Order(3)
    public void update() {
        Author author = new Author();
        author.setFirstName("New firstName");
        author.setLastName("New lastName");
        Library library = libraries[5];
        Library library1 = new Library();

        library1.setId(library.getId());
        library.setAuthor(author);
        library1.setBook(libraries[5].getBook());

        libraryDao.update(library1);
        Assertions.assertEquals(10, libraries.length);
    }
    @Test
    @Order(4)
    public void findById(){
        Library[] libraries = libraryDao.findAll();
        Assertions.assertNotNull(libraryDao.findById(libraries[5].getId()));
    }
    @Test
    @Order(5)
    public void findAll() {
        Library[] libraries = libraryDao.findAll();
        Assertions.assertNotNull(libraries);
    }

}

