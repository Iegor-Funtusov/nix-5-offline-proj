package org.example.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    public static SessionFactory createSessionFactory(String username, String password) {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.username", username);
        configuration.setProperty("hibernate.connection.password", password);
        return configuration.configure().buildSessionFactory();
    }
}
