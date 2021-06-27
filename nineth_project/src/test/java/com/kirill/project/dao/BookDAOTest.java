package com.kirill.project.dao;

import com.kiril.project.dao.BookDAO;
import com.kiril.project.entities.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOTest {
    private int n;
    private BookDAO bookDAO;

    {
        try {
            bookDAO = new BookDAO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Book[] books = new Book[n];
    private List<String> authors = new ArrayList<>();

    @BeforeEach
    public void init() {
        for (int i = 0; i < n; i++) {
            authors.add(new String("test" + i));
        }
        for (int i = 0; i < n; i++) {
            books[i] = new Book("test" + i, "test" + i*2, true);
        }

        for (int i = 0; i < n; i++) {
            bookDAO.create(books[i]);
        }
    }

    @Test
    public void createTest() {
        for (int i = 0; i < n; i++) {
            Assertions.assertNotNull(bookDAO.readAll().get(i));
        }
    }

    @Test
    public void updateTest() {
        for (int i = n - 1; i >= 0; i--) {
            bookDAO.update(bookDAO.readAll().get(i).getId(), books[i]);
        }
        for (int i = 0; i < n; i++) {
            Assertions.assertEquals(bookDAO.readAll().get(i).getName(), books[i].getName());
        }
    }

    @Test
    public void delete() {
        for (int i = 0; i < n; i++) {
            bookDAO.delete(bookDAO.readAll().get(i).getId());
        }
        Assertions.assertEquals(bookDAO.size(), 0);
    }

    @Test
    public void read() {
        for (int i = 0; i < n; i++) {
            Assertions.assertEquals(1,0);
        }
    }
}
