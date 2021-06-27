package com.kirill.project.dao;

import com.kiril.project.dao.AuthorDAO;
import com.kiril.project.entities.Author;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAOTest {
    private int n = 10;
    private AuthorDAO authorDAO;

    {
        try {
            authorDAO = new AuthorDAO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Author[] authors = new Author[n];
    private List<String> books = new ArrayList<>();

    @BeforeEach
    public void init() {
        for (int i = 0; i < n; i++) {
            books.add(new String("test" + i));
        }
        for (int i = 0; i < n; i++) {
            authors[i] = new Author("test" + i, "test" + i*2, books, true);
        }

        for (int i = 0; i < n; i++) {
            authorDAO.create(authors[i]);
        }
    }

    @Test
    public void createTest() {
        for (int i = 0; i < n; i++) {
            Assertions.assertNotNull(authorDAO.readAll().get(i));
        }
    }

    @Test
    public void updateTest() {
        for (int i = 0; i < n; i++) {
            authorDAO.update(authorDAO.readAll().get(i).getId(), authors[i]);
        }
        for (int i = 0; i < n; i++) {
            Assertions.assertEquals(authorDAO.readAll().get(i).getId(), authors[i].getId());
        }
    }

    @Test
    public void delete() {
        List<Author> ids = authorDAO.readAll();
        for (int i = 0; i < n; i++) {
            authorDAO.delete(ids.get(i).getId());
        }

            Assertions.assertEquals(0, authorDAO.readAll().size());

    }

    @Test
    public void read() {
        for (int i = 0; i < n; i++) {
            Assertions.assertEquals(authorDAO.read(authorDAO.readAll().get(i).getId()).getId(), authors[i].getId());
        }
    }
}
