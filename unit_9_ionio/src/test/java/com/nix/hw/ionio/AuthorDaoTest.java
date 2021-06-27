package com.nix.hw.ionio;

import com.nix.hw.ionio.dao.AuthorDao;
import com.nix.hw.ionio.entity.Author;
import com.nix.hw.ionio.entity.Book;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;
import org.junit.Assert;

import java.util.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorDaoTest {

    private static AuthorDao authorDao = new AuthorDao();

    @Test
    @Order(1)
    public void create() {

        Author author1 = new Author();
        Author author2 = new Author();

        author1.setVisible(true);
        author2.setVisible(true);

        authorDao.create(author1);
        authorDao.create(author2);

        Assert.assertEquals(2, authorDao.findAll().size());
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

        authorDao.create(author);
        author.setFirstName("newName");
        authorDao.update(author);

        Assert.assertTrue(Objects.equals(authorDao.findById(author.getId()).getFirstName(), "newName"));
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

        authorDao.delete(author);

        Assert.assertEquals(3, authorDao.findAll().size());

    }

    @Test
    @Order(4)
    public void findAll() {
        List<Author> authors = authorDao.findAll();
        Assert.assertEquals(3, authorDao.findAll().size());
    }

}
