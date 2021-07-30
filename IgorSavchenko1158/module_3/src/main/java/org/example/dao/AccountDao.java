package org.example.dao;

import org.example.entity.Account;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AccountDao {
    private final Session session;

    public AccountDao(Session session) {
        this.session = session;
    }

    public List<Account> getAccountsByUser(User user) {
        Query<Account> query = session.createQuery("from Account as A where A.user=:user", Account.class);
        query.setParameter("user", user);
        return query.list();
    }
}

