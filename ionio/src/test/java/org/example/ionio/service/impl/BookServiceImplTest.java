package org.example.ionio.service.impl;

import org.example.ionio.model.Author;
import org.example.ionio.model.Book;
import org.example.ionio.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class BookServiceImplTest {
    private static final String NAME = "name";
    private static final String NAME_UPD = "nameUPD";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final BookService bookService = new BookServiceImpl();
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
            bookService.create(b);
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

        bookService.create(book);

        Book book1 = bookService.readById(book.getId());

        Assertions.assertEquals(book, book1);
    }

    @Test
    public void update(){
        Book book = books.get(0);
        book.setName(NAME_UPD);

        bookService.update(book);

        Book bookUpdated = bookService.readById(book.getId());

        Assertions.assertEquals(book, bookUpdated);
    }

    @Test
    public void delete(){
        Book book = books.get(1);

        bookService.delete(book.getId());

        Book book1 = bookService.readById(book.getId());

        Assertions.assertNull(book1);
    }

    @Test
    public void readById(){
        Book book = books.get(2);

        Book book1 = bookService.readById(book.getId());

        Assertions.assertNotNull(book1);
    }

    @Test
    public void readByAuthor(){
        Author a = authors.get(3);

        List<Book> bookList = bookService.readByAuthor(a.getId());
        int size = bookList.size();

        Assertions.assertEquals(2, size);
    }

    @Test
    public void readAll(){
        List<Book> bookList = bookService.readAll();
        int size = bookList.size();

        Assertions.assertNotEquals(0, size);
    }

}