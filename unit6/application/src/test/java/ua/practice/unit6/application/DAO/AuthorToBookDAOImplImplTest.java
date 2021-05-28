package ua.practice.unit6.application.DAO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.practice.unit6.application.DAO.daoImpl.AuthorDAOImpl;
import ua.practice.unit6.application.DAO.daoImpl.AuthorToBookDAOImpl;
import ua.practice.unit6.application.DAO.daoImpl.BookDAOImpl;
import ua.practice.unit6.application.entity.Author;
import ua.practice.unit6.application.entity.AuthorToBook;
import ua.practice.unit6.application.entity.Book;

import static org.junit.jupiter.api.Assertions.*;

class AuthorToBookDAOImplImplTest {
    AuthorToBookDAOImpl authorToBookDAO;
    AuthorDAOImpl authorDAO;
    BookDAOImpl bookDAO;

    @BeforeEach
    void setUp()
    {
        authorToBookDAO = new AuthorToBookDAOImpl();
        authorDAO = new AuthorDAOImpl();
        bookDAO = new BookDAOImpl();
    }

    @AfterEach
    void tearDown() {
        authorToBookDAO = null;
        authorDAO = null;
        bookDAO = null;
    }

    @Test
    void create() {
        Author author = new Author();
        author.setName("nameAuthor");
        authorDAO.create(author);

        Book book = new Book();
        book.setName("nameBook");
        book.setYearOfPublishing(1989);

        AuthorToBook authorToBook = new AuthorToBook();
        authorToBook.setAuthors(author);
        authorToBook.setBooks(book);
        authorToBookDAO.create(authorToBook);

        assertEquals(1, authorToBookDAO.read().size());
    }

    @Test
    void update() {
        Author author = new Author();
        author.setName("nameAuthor");
        authorDAO.create(author);

        Author author1 = new Author();
        author.setName("secondAuthor");
        authorDAO.create(author);
        authorDAO.create(author1);

        Book book = new Book();
        book.setName("nameBook");
        book.setYearOfPublishing(1989);

        AuthorToBook authorToBook = new AuthorToBook();
        authorToBook.setAuthors(author);
        authorToBook.setBooks(book);
        authorToBookDAO.create(authorToBook);

        authorToBook.setAuthors(author1);
        authorToBookDAO.update(authorToBook);
        assertEquals(authorToBook, authorToBookDAO.read(authorToBook.getId()));

    }

    @Test
    void delete() {
        Author author = new Author();
        author.setName("nameAuthor");
        authorDAO.create(author);

        Book book = new Book();
        book.setName("nameBook");
        book.setYearOfPublishing(1989);

        AuthorToBook authorToBook = new AuthorToBook();
        authorToBook.setAuthors(author);
        authorToBook.setBooks(book);
        authorToBookDAO.create(authorToBook);

        authorToBookDAO.delete(authorToBook.getId());
        assertEquals(0, authorToBookDAO.read().size());
    }

    @Test
    void readAllBooksByAuthorId() {
        Author author = new Author();
        author.setName("nameAuthor");
        authorDAO.create(author);

        Book book = new Book();
        book.setName("nameBook");
        book.setYearOfPublishing(1989);

        Book book1 = new Book();
        book1.setName("nameBook2");
        book1.setYearOfPublishing(1999);

        AuthorToBook authorToBook = new AuthorToBook();
        authorToBook.setAuthors(author);
        authorToBook.setBooks(book);
        authorToBookDAO.create(authorToBook);

        AuthorToBook authorToBook2 = new AuthorToBook();
        authorToBook2.setAuthors(author);
        authorToBook2.setBooks(book1);
        authorToBookDAO.create(authorToBook2);

        assertEquals(book, authorToBookDAO.readAllBooksByAuthorId(author.getId()).get(0));
        assertEquals(book1, authorToBookDAO.readAllBooksByAuthorId(author.getId()).get(1));

    }

    @Test
    void readAllAuthorsByBookId() {
        Author author = new Author();
        author.setName("nameAuthor");
        authorDAO.create(author);


        Author author1 = new Author();
        author1.setName("nameAuthor2");
        authorDAO.create(author1);

        Book book = new Book();
        book.setName("nameBook");
        book.setYearOfPublishing(1989);
        bookDAO.create(book);


        AuthorToBook authorToBook = new AuthorToBook();
        authorToBook.setAuthors(author);
        authorToBook.setBooks(book);
        authorToBookDAO.create(authorToBook);

        AuthorToBook authorToBook2 = new AuthorToBook();
        authorToBook2.setAuthors(author1);
        authorToBook2.setBooks(book);
        authorToBookDAO.create(authorToBook2);

        assertEquals(author, authorToBookDAO.readAllAuthorsByBookId(book.getId()).get(0));
        assertEquals(author1, authorToBookDAO.readAllAuthorsByBookId(book.getId()).get(1));
    }
}