package ua.com.alevel.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.alevel.dao.*;
import ua.com.alevel.entity.*;
import ua.com.alevel.service.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecipeBookController {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static RecipeBookService recipeBookService = new RecipeBookService();
    private static int choice;

    public static void controller() throws IOException {

        Loop: while (true){
            System.out.println("You are on the recipe book! \n" +
                    "Please, choose an option below:\n" +
                    "1 Create new recipe book\n" +
                    "2 Read all recipe books\n" +
                    "3 Read recipe book by id\n" +
                    "4 Update recipe book`s info\n" +
                    "5 Delete recipe book by id\n" +
                    "0 Back to the main menu\n");

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

            if (choice == 1 ){
                while (true){
                    LOGGER_INFO.info("Start creation recipe book");
                    System.out.println("Start creation");
                    RecipeBook recipeBook = new RecipeBook();
                    System.out.println(DessertService.readAll());
                    System.out.println(ConfectionerService.readAll());
                    enter(recipeBook);
                    recipeBookService.create(recipeBook);
                    System.out.println(recipeBook.toString());
                    System.out.println("Operation complete");
                    LOGGER_INFO.info("Recipe book created " + recipeBook.toString());
                    break;
                }

            }

            if (choice == 2){
                LOGGER_INFO.info(" reading all recipe books");
                System.out.println("Start reading all recipe books");
                System.out.println(recipeBookService.readAll().toString());
                System.out.println("Operation complete");
            }

            if (choice == 3){
                while (true){
                    LOGGER_INFO.info("Start reading recipe book by id");
                    RecipeBookDao recipeBookDao = new RecipeBookDao();
                    System.out.println("Start reading recipe book by id");
                    System.out.println("Enter recipe book id");
                    String id = reader.readLine();
                    Object object = recipeBookDao.findById(id);
                    if (object != null){
                        System.out.println( recipeBookService.read(id).toString());
                        System.out.println("Operation complete");
                        LOGGER_INFO.info("End reading recipe book by id: "+ recipeBookService.read(id).toString());
                        break;
                    }
                    else {
                        System.out.println("Incorrect id, try again");
                        LOGGER_ERROR.error("Incorrect id: "+ id);
                        continue;
                    }
                }
            }

            if (choice == 4){
                while (true){
                    System.out.println("Start updating recipe book`s info");
                    System.out.println("Enter recipe book id");
                    String id = reader.readLine();
                    RecipeBook current = (RecipeBook) recipeBookService.read(id);
                    if (current != null ){
                        enter(current);
                        recipeBookService.update(current);
                        System.out.println("Operation complete");
                        LOGGER_INFO.info("Updated recipe book by id" + id);
                    }
                    else {
                        System.out.println("This id does not exist, try again");
                        LOGGER_ERROR.error("Incorrect id: "+ id);
                        continue;
                    }
                    break;
                }
            }

            if (choice == 5){
                while (true){
                    LOGGER_WARN.warn("Start deleting recipe book by id");
                    System.out.println("Start deleting recipe book by id");
                    System.out.println("Enter recipe book id");
                    String id = reader.readLine();
                    RecipeBook current = (RecipeBook) recipeBookService.read(id);
                    if (current != null ){
                        recipeBookService.delete(id);
                        System.out.println("Operation complete");
                        LOGGER_WARN.warn("End deleting recipe book by id");
                    }
                    else {
                        System.out.println("This id does not exist, try again");
                        LOGGER_ERROR.error("Incorrect id: "+ id);
                        continue;
                    }
                    break;
                }
            }

            if (choice == 0){
                LOGGER_INFO.info("Exit to main menu");
                break Loop;
            }
            else {
                LOGGER_ERROR.error("Incorrect numeric data ");
                continue ;
            }

        }

    }

    private static void enter (RecipeBook recipeBook) throws IOException {
        while (true){
            ConfectionerDao confectionerDao = new ConfectionerDao();
            Confectioner confectioner = new Confectioner();
            System.out.println("Enter confectioner`s id");
            String id = reader.readLine();
            Object object = confectionerDao.findById(id);
            if (object != null){
                confectioner = (Confectioner) ConfectionerService.read(id);
                recipeBook.setConfectioner(confectioner);
                LOGGER_INFO.info("Confectioner added: "+ confectioner);
                break;
            }
            else {
                System.out.println("Incorrect id, try again");
                LOGGER_ERROR.error("Incorrect id");
                continue;
            }

        }
        while (true){
            DessertDao confectionerDao = new DessertDao();
            Dessert dessert = new Dessert();
            System.out.println("Enter dessert`s id");
            String id = reader.readLine();
            Object object = confectionerDao.findById(id);
            if (object != null){
                dessert = (Dessert) DessertService.read(id);
                recipeBook.setDessert(dessert);
                LOGGER_INFO.info("Dessert added: "+ dessert);
                break;
            }
            else {
                System.out.println("Incorrect id, try again");
                LOGGER_ERROR.error("Incorrect id");
                continue;
            }
        }
    }
}