package org.example.controller;

import org.example.dto.AccountDTO;
import org.example.entity.User;
import org.example.service.StatementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StatementController {

    private static final Logger log = LoggerFactory.getLogger(StatementController.class);

    public void start(User user) {
        log.info("StatementController started by " + user.getName());
        StatementService statementService = new StatementService();

        System.out.println("Your accounts:");
        List<AccountDTO> accountsByUser = statementService.getAccountsByUser(user);
        System.out.println(accountsByUser.stream().map(a -> a.getAlias() + ": " + a.getBalance()).collect(Collectors.toList()));

        System.out.println("Choose account by name:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        AccountDTO account = null;
        for (AccountDTO acc : accountsByUser) {
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
        Instant from;
        Instant to;
        try {
            System.out.println("Enter start of time period:");
            input = scanner.nextLine();
            from = LocalDateTime.parse(input).toInstant(ZoneOffset.UTC);

            System.out.println("Enter end of time period:");
            input = scanner.nextLine();
            to = LocalDateTime.parse(input).toInstant(ZoneOffset.UTC);

            if (from.isAfter(to)) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Incorrect input");
            return;
        }
        log.info("User entered time frame from " + from + " to " + to);
        try {
            statementService.operationsToCsv(account, from, to);
        } catch (Exception e) {
            System.out.println("Operation unsuccessful: " + e);
            return;
        }
        System.out.println("Operation successful");
        log.info("StatementController finished normally");
    }

}
