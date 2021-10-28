package org.example.controller;

import org.example.entity.Account;
import org.example.entity.Category;
import org.example.entity.User;
import org.example.service.OperationService;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OperationController {

    private static final Logger log = LoggerFactory.getLogger(OperationController.class);
    private final SessionFactory sessionFactory;

    public OperationController(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void start(User user) {
        log.info("OperationController started by " + user.getName());
        OperationService service = new OperationService(sessionFactory);

        System.out.println("Your accounts:");
        List<Account> accountsByUser = service.getAccountsByUser(user);
        System.out.println(accountsByUser.stream().map(a -> a.getAlias() + ": " + a.getBalance()).collect(Collectors.toList()));

        System.out.println("Choose account by name:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Account account = null;
        for (Account acc : accountsByUser) {
            if (input.equalsIgnoreCase(acc.getAlias())) {
                account = acc;
                break;
            }
        }
        if (account == null) {
            System.out.println("Incorrect input");
            return;
        }
        log.info("User picked account " + account.getAlias());
        System.out.println("Select category:");
        List<Category> categories = service.getCategories();
        System.out.println(categories.stream().map(c -> c.getName() + ": " + c.getDescription()).collect(Collectors.toList()));
        input = scanner.nextLine();
        Category category = null;
        for (Category cat : categories) {
            if (cat.getName().equalsIgnoreCase(input)) {
                category = cat;
                break;
            }
        }
        if (category == null) {
            System.out.println("Incorrect input");
            return;
        }
        log.info("User picked category " + category.getName());
        if (category.getType() == Category.CategoryType.INCOME) {
            System.out.println("Enter amount of money to add:");
        } else {
            System.out.println("Enter amount of money to remove:");
        }
        input = scanner.nextLine();
        Long amount;
        try {
            amount = Long.parseLong(input);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input");
            return;
        }
        log.info("User entered amount " + amount);
        try {
            service.performOperation(account, category, amount);
        } catch (Exception e) {
            System.out.println("Operation unsuccessful");
            return;
        }
        System.out.println("Operation successful");
        log.info("OperationController finished normally");
    }
}
