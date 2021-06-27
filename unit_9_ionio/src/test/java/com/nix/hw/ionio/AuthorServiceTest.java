package com.nix.hw.ionio;

import com.nix.hw.ionio.entity.Author;
import com.nix.hw.ionio.entity.Book;
import com.nix.hw.ionio.service.AuthorService;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorServiceTest {

    private static final AuthorService authorService = new AuthorService();

    @Test
    @Order(1)
    public void create() {

        Book book = new Book();
        book.setName("a");
        book.setId(UUID.randomUUID().toString());
        book.setVisible(true);

        Author author1 = new Author();
        Author author2 = new Author();

        author1.setFirstName("a1");
        author1.setLastName("lastN1");
        author1.setBooks(new ArrayList<>(Arrays.asList(book)));

        author2.setFirstName("a2");
        author2.setLastName("lastN2");
        author2.setBooks(new ArrayList<>(Arrays.asList(book)));

        authorService.create(author1);
        authorService.create(author2);

        Assert.assertEquals(2, authorService.findAll().size());
    }

    @Test
    @Order(2)
    public void update() {

        Book book = new Book();
        book.setName("a");
        book.setId(UUID.randomUUID().toString());
        book.setVisible(true);

        Author author = new Author();
        author.setId(UUID.randomUUID().toString());
        author.setVisible(true);
        author.setFirstName("name1");
        author.setLastName("lastName1");
        author.setBooks(new ArrayList<>(Arrays.asList(book)));

        authorService.create(author);
        author.setFirstName("newName");
        authorService.update(author);

        Assert.assertTrue(Objects.equals(authorService.findById(author.getId()).getFirstName(), "newName"));
    }

    @Test
    @Order(3)
    public void delete() {

        Book book = new Book();
        book.setName("booook");
        book.setId(UUID.randomUUID().toString());
        book.setVisible(true);

        Author author = new Author();
        author.setId(UUID.randomUUID().toString());
        author.setVisible(true);
        author.setFirstName("name1");
        author.setLastName("lastName1");
        author.setBooks(new ArrayList<>(Arrays.asList(book)));

        authorService.delete(author);

        Assert.assertEquals(3, authorService.findAll().size());

    }

    @Test
    @Order(4)
    public void findAll() {
        List<Author> authors = authorService.findAll();
        Assert.assertEquals(3, authorService.findAll().size());
    }

}
