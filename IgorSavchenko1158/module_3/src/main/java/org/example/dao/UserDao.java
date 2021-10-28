package org.example.dao;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserDao {
    private final Session session;

    public UserDao(Session session) {
        this.session = session;
    }

    public User getByEmail(String email) {
        Query<User> query = session.createQuery("from User where email=:email", User.class);
        query.setParameter("email", email);
        return query.uniqueResult();
    }
}
