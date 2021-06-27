package com.nix.hw.ionio;

import com.nix.hw.ionio.dao.BookDao;
import com.nix.hw.ionio.entity.Author;
import com.nix.hw.ionio.entity.Book;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookDaoTest {

    private static BookDao bookDao = new BookDao();

    @Test
    @Order(1)
    public void create() {

        Book book1 = new Book();
        Book book2 = new Book();

        book1.setVisible(true);
        book2.setVisible(true);

        bookDao.create(book1);
        bookDao.create(book2);

        Assert.assertEquals(2, bookDao.findAll().size());
    }

    @Test
    @Order(2)
    public void update() {

        Author author = new Author();
        author.setFirstName("name1");
        author.setLastName("lastName1");
        author.setId(UUID.randomUUID().toString());
        author.setVisible(true);

        Book book = new Book();
        book.setId(UUID.randomUUID().toString());
        book.setVisible(true);
        book.setName("book1");
        book.setAuthors(new ArrayList<>(Arrays.asList(author)));

        bookDao.create(book);
        book.setName("newName");
        bookDao.update(book);

        Assert.assertTrue(Objects.equals(bookDao.findById(book.getId()).getName(), "newName"));
    }

    @Test
    @Order(3)
    public void delete() {

        Author author = new Author();
        author.setFirstName("aln1");
        author.setLastName("aln1");
        author.setId(UUID.randomUUID().toString());
        author.setVisible(true);

        Book book = new Book();
        book.setId(UUID.randomUUID().toString());
        book.setVisible(true);
        book.setName("b2");
        book.setAuthors(new ArrayList<>(Arrays.asList(author)));

        bookDao.delete(book);

        Assert.assertEquals(3, bookDao.findAll().size());

    }

    @Test
    @Order(4)
    public void findAll() {
        List<Book> books = bookDao.findAll();
        Assert.assertEquals(3, bookDao.findAll().size());
    }

}
