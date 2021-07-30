package org.example;

import org.example.controller.MainController;
import org.example.utils.HibernateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        log.info("App started");
        MainController.start(HibernateUtils.createSessionFactory(System.getenv("username"), System.getenv("password")), System.getenv("email"));
        log.info("App finished");
    }
}
