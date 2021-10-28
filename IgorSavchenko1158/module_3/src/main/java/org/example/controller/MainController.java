package org.example.controller;

import org.example.dao.UserDao;
import org.example.entity.User;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Scanner;

public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    public static void start(SessionFactory sessionFactory, String userEmail) {
        User user = new UserDao(sessionFactory.openSession()).getByEmail(userEmail);
        log.info("User logged in: " + user.getName());
        while (true) {
            System.out.println("Logged in as " + user.getName());
            System.out.println("Choose action:");
            System.out.println("1. Execute new operation");
            System.out.println("2. Export bank statement as csv");
            System.out.println("exit");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input.toLowerCase(Locale.ROOT)) {
                case "1":
                    new OperationController(sessionFactory).start(user);
                    break;
                case "2":
                    new StatementController().start(user);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Incorrect input");
            }
        }
    }
}
