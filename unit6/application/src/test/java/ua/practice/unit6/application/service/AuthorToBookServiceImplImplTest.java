package ua.practice.unit6.application.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.practice.unit6.application.entity.Author;
import ua.practice.unit6.application.entity.AuthorToBook;
import ua.practice.unit6.application.entity.Book;
import ua.practice.unit6.application.service.serviceImpl.AuthorServiceImpl;
import ua.practice.unit6.application.service.serviceImpl.AuthorToBookServiceImpl;
import ua.practice.unit6.application.service.serviceImpl.BookServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class AuthorToBookServiceImplImplTest {
    AuthorToBookServiceImpl authorToBookService;
    AuthorServiceImpl authorService;
    BookServiceImpl bookService;

    @BeforeEach
    void setUp()
    {
        authorToBookService = new AuthorToBookServiceImpl();
        authorService = new AuthorServiceImpl();
        bookService = new BookServiceImpl();
    }

    @AfterEach
    void tearDown() {
        authorToBookService = null;
        authorService = null;
        bookService = null;
    }

    @Test
    void create() {
        Author author = new Author();
        author.setName("nameAuthor");
        authorService.create(author);

        Book book = new Book();
        book.setName("nameBook");
        book.setYearOfPublishing(1989);

        AuthorToBook authorToBook = new AuthorToBook();
        authorToBook.setAuthors(author);
        authorToBook.setBooks(book);
        authorToBookService.create(authorToBook);

        assertEquals(1, authorToBookService.read().size());
    }

    @Test
    void update() {
        Author author = new Author();
        author.setName("nameAuthor");
        authorService.create(author);

        Author author1 = new Author();
        author.setName("secondAuthor");
        authorService.create(author);
        authorService.create(author1);

        Book book = new Book();
        book.setName("nameBook");
        book.setYearOfPublishing(1989);

        AuthorToBook authorToBook = new AuthorToBook();
        authorToBook.setAuthors(author);
        authorToBook.setBooks(book);
        authorToBookService.create(authorToBook);

        authorToBook.setAuthors(author1);
        authorToBookService.update(authorToBook);
        assertEquals(authorToBook, authorToBookService.read(authorToBook.getId()));

    }

    @Test
    void delete() {
        Author author = new Author();
        author.setName("nameAuthor");
        authorService.create(author);

        Book book = new Book();
        book.setName("nameBook");
        book.setYearOfPublishing(1989);

        AuthorToBook authorToBook = new AuthorToBook();
        authorToBook.setAuthors(author);
        authorToBook.setBooks(book);
        authorToBookService.create(authorToBook);

        authorToBookService.delete(authorToBook.getId());
        assertEquals(0, authorToBookService.read().size());
    }

    @Test
    void delete1() {
        assertDoesNotThrow(()->authorToBookService.delete("asodasjdnsakdn"));
    }

    @Test
    void delete2() {
        assertDoesNotThrow(()->authorToBookService.delete(null));
    }

    @Test
    void readAllBooksByAuthorId() {
        Author author = new Author();
        author.setName("nameAuthor");
        authorService.create(author);

        Book book = new Book();
        book.setName("nameBook");
        book.setYearOfPublishing(1989);

        Book book1 = new Book();
        book1.setName("nameBook2");
        book1.setYearOfPublishing(1999);

        AuthorToBook authorToBook = new AuthorToBook();
        authorToBook.setAuthors(author);
        authorToBook.setBooks(book);
        authorToBookService.create(authorToBook);

        AuthorToBook authorToBook2 = new AuthorToBook();
        authorToBook2.setAuthors(author);
        authorToBook2.setBooks(book1);
        authorToBookService.create(authorToBook2);

        assertEquals(book, authorToBookService.readAllBooksByAuthorId(author.getId()).get(0));
        assertEquals(book1, authorToBookService.readAllBooksByAuthorId(author.getId()).get(1));

    }

    @Test
    void readAllBooksByAuthorId1() {
        assertDoesNotThrow(()->authorToBookService.readAllBooksByAuthorId(null));
    }

    @Test
    void readAllAuthorsByBookId() {
        Author author = new Author();
        author.setName("nameAuthor");
        authorService.create(author);


        Author author1 = new Author();
        author1.setName("nameAuthor2");
        authorService.create(author1);

        Book book = new Book();
        book.setName("nameBook");
        book.setYearOfPublishing(1989);
        bookService.create(book);


        AuthorToBook authorToBook = new AuthorToBook();
        authorToBook.setAuthors(author);
        authorToBook.setBooks(book);
        authorToBookService.create(authorToBook);

        AuthorToBook authorToBook2 = new AuthorToBook();
        authorToBook2.setAuthors(author1);
        authorToBook2.setBooks(book);
        authorToBookService.create(authorToBook2);

        assertEquals(author, authorToBookService.readAllAuthorsByBookId(book.getId()).get(0));
        assertEquals(author1, authorToBookService.readAllAuthorsByBookId(book.getId()).get(1));
    }
    @Test
    void readAllAuthorsByBookId1() {
        assertDoesNotThrow(()->authorToBookService.readAllAuthorsByBookId(null));
    }
}