package org.example.dao;

import org.example.entity.Category;
import org.hibernate.Session;

import java.util.List;

public class CategoryDao {
    private final Session session;

    public CategoryDao(Session session) {
        this.session = session;
    }

    public List<Category> getAll() {
        return session.createQuery("from Category", Category.class).list();
    }
}
