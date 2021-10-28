package org.example.service;

import org.example.dao.AccountDao;
import org.example.dao.CategoryDao;
import org.example.entity.Account;
import org.example.entity.Category;
import org.example.entity.Operation;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.Instant;
import java.util.List;

public class OperationService {
    private final SessionFactory sessionFactory;

    public OperationService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<Account> getAccountsByUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            return new AccountDao(session).getAccountsByUser(user);
        }
    }

    public List<Category> getCategories() {
        try (Session session = sessionFactory.openSession()) {
            return new CategoryDao(session).getAll();
        }
    }

    public void performOperation(Account account, Category category, Long amount) {
        Operation operation = new Operation();
        operation.setAccount(account);
        operation.setCategory(category);
        operation.setSum(amount);
        operation.setTime(Instant.now());

        if (category.getType() == Category.CategoryType.INCOME) {
            account.setBalance(account.getBalance() + amount);
        } else {
            account.setBalance(account.getBalance() - amount);
        }

        try(Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.save(operation);
                session.update(account);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RuntimeException(e);
            }
        }
    }
}
