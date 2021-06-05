package ua.com.alevel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.controller.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClassApp {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int choice;

    public static void main(String[] args) throws IOException {
        while (true){

            System.out.println("Choose the option:\n" +
                    "1 Dessert CRUD\n" +
                    "2 Confectioner CRUD\n" +
                    "3 Recipe Book\n" +
                    "0 Exit");

            String str = reader.readLine();
            str = str.replaceAll("\\D+","");
            if (!str.isBlank()){
                choice = Integer.parseInt(str);
                LOGGER_INFO.info("Choice is correct " + choice);
            }
            else {
                System.out.println("incorrect input");
                LOGGER_ERROR.error("Choice is not correct " + str);
                continue ;
            }

            switch (choice){
                case 1:
                    LOGGER_INFO.info("Work with Dessert CRUD");
                    DessertController.controller();
                    break;
                case 2:
                    LOGGER_INFO.info("Work with Confectioner CRUD");
                    ConfectionerController.controller();
                    break;
                case 3:
                    LOGGER_INFO.info("Work with Recipe Book");
                    RecipeBookController.controller();
                    break;
                case 0:
                    LOGGER_WARN.warn("Exit");
                    System.exit(0);
                    break;
                default:
                    LOGGER_ERROR.error("Incorrect numeric data ");
                    continue;
            }
        }
    }
}