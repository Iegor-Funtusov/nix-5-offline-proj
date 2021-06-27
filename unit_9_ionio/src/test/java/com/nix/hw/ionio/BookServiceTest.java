package com.nix.hw.ionio;

import com.nix.hw.ionio.entity.Author;
import com.nix.hw.ionio.entity.Book;
import com.nix.hw.ionio.service.BookService;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookServiceTest {

    private static final BookService bookService = new BookService();

    @Test
    @Order(1)
    public void create() {

        Author author = new Author();
        author.setFirstName("a");
        author.setLastName("lastA");
        author.setId(UUID.randomUUID().toString());
        author.setVisible(true);

        Book book1 = new Book();
        Book book2 = new Book();

        book1.setId(UUID.randomUUID().toString());
        book1.setVisible(true);
        book1.setName("b1");
        book1.setAuthors(new ArrayList<>(Arrays.asList(author)));

        book2.setId(UUID.randomUUID().toString());
        book2.setVisible(true);
        book2.setName("b2");
        book2.setAuthors(new ArrayList<>(Arrays.asList(author)));

        bookService.create(book1);
        bookService.create(book2);

        Assert.assertEquals(2, bookService.findAll().size());
    }

    @Test
    @Order(2)
    public void update() {


        Author author = new Author();
        author.setFirstName("newA");
        author.setLastName("newLastA");
        author.setId(UUID.randomUUID().toString());
        author.setVisible(true);

        Book book1 = new Book();

        book1.setId(UUID.randomUUID().toString());
        book1.setVisible(true);
        book1.setName("b3");
        book1.setAuthors(new ArrayList<>(Arrays.asList(author)));

        bookService.create(book1);
        book1.setName("newB3");
        bookService.update(book1);

        Assert.assertTrue(Objects.equals(bookService.findById(book1.getId()).getName(), "newB3"));
    }

    @Test
    @Order(3)
    public void delete() {

        Author author = new Author();
        author.setFirstName("authooooor");
        author.setLastName("lNameA");
        author.setId(UUID.randomUUID().toString());
        author.setVisible(true);

        Book book1 = new Book();

        book1.setId(UUID.randomUUID().toString());
        book1.setVisible(true);
        book1.setName("b3");
        book1.setAuthors(new ArrayList<>(Arrays.asList(author)));

        bookService.create(book1);
        book1.setName("newB3");
        bookService.update(book1);

        bookService.delete(book1);

        Assert.assertEquals(3, bookService.findAll().size());

    }

    @Test
    @Order(4)
    public void findAll() {
        List<Book> books = bookService.findAll();
        Assert.assertEquals(3, bookService.findAll().size());
    }
}
