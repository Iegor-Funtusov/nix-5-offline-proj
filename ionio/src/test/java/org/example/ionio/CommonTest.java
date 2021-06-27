package org.example.ionio;

import org.example.ionio.model.Author;
import org.example.ionio.model.Book;
import org.example.ionio.service.AuthorService;
import org.example.ionio.service.BookService;
import org.example.ionio.service.impl.AuthorServiceImpl;
import org.example.ionio.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CommonTest {
    private static final String NAME = "name";
    private static final String NAME_UPD = "nameUPD";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final BookService bookService = new BookServiceImpl();
    private static final AuthorService authorService = new AuthorServiceImpl();

    @BeforeAll
    static void setUp(){
        new File("books.csv").delete();
        new File("authors.csv").delete();
    }

    @Test
    public void bookCRUD(){
        List<Author> authors = new ArrayList<>();
        Author a = new Author();
        a.setId("11");
        a.setFirstName(FIRST_NAME);
        a.setLastName(LAST_NAME);
        authors.add(a);
        Book book = new Book();
        book.setId("11");
        book.setName(NAME);
        book.setAuthors(authors);
        bookService.create(book);
        Book book1 = bookService.readById(book.getId());
        Assertions.assertEquals(book, book1);

        book.setName(NAME_UPD);
        bookService.update(book);
        Book bookUpdated = bookService.readById(book.getId());
        Assertions.assertEquals(book, bookUpdated);

        List<Book> bookList = bookService.readByAuthor(a.getId());
        int size = bookList.size();
        Assertions.assertEquals(1, size);

        bookService.delete(book.getId());
        book1 = bookService.readById(book.getId());
        Assertions.assertNull(book1);
    }

    @Test
    public void authorCRUD(){
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setId("11");
        book.setName(NAME);
        books.add(book);
        Author a = new Author();
        a.setId("11");
        a.setFirstName(FIRST_NAME);
        a.setLastName(LAST_NAME);
        a.setBookList(books);
        authorService.create(a);
        Author a1 = authorService.readById(a.getId());
        Assertions.assertEquals(a, a1);

        a.setFirstName(NAME_UPD);
        authorService.update(a);
        Author authorUpdated = authorService.readById(a.getId());
        Assertions.assertEquals(a, authorUpdated);

        List<Author> authorList = authorService.readByBook(book.getId());
        int size = authorList.size();
        Assertions.assertEquals(1, size);

        authorService.delete(a.getId());
        a1 = authorService.readById(a.getId());
        Assertions.assertNull(a1);
    }
}
