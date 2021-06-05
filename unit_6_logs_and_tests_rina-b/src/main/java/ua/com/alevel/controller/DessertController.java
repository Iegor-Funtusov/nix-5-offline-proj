package ua.com.alevel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.DessertDao;
import ua.com.alevel.entity.Dessert;
import ua.com.alevel.service.DessertService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DessertController {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static DessertService dessertService = new DessertService();
    private static int choice;

    public static void controller() throws IOException {

        Loop: while (true){
            System.out.println("You are on the Dessert CRUD! \n" +
                    "Please, choose an option below:\n" +
                    "1 Create new dessert\n" +
                    "2 Read all desserts\n" +
                    "3 Read dessert by id\n" +
                    "4 Update dessert`s info\n" +
                    "5 Delete dessert by id\n" +
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
                    LOGGER_INFO.info("Start creation dessert");
                    System.out.println("Start creation");
                    Dessert dessert = new Dessert();
                    enter(dessert);
                    dessertService.create(dessert);
                    System.out.println(dessert.toString());
                    System.out.println("Operation complete");
                    LOGGER_INFO.info("Dessert created " + dessert.toString());
                    break;
                }

            }

            if (choice == 2){
                LOGGER_INFO.info("Reading all desserts ");
                System.out.println("Start reading all desserts");
                System.out.println(dessertService.readAll().toString());
                System.out.println("Operation complete");
            }

            if (choice == 3){
                while (true){
                    DessertDao dessertDao = new DessertDao();
                    LOGGER_INFO.info("Start reading dessert by id");
                    System.out.println("Start reading dessert by id");
                    System.out.println("Enter dessert id");
                    String id = reader.readLine();
                    Object object = dessertDao.findById(id);
                    if (object != null){
                        System.out.println( dessertService.read(id).toString());
                        System.out.println("Operation complete");
                        LOGGER_INFO.info("End reading dessert by id: "+ dessertService.read(id).toString());
                        break;
                    }
                    else {
                        LOGGER_ERROR.error("Reading dessert: Incorrect id: "+ id);
                        System.out.println("Incorrect id, try again");
                        continue;
                    }
                }
            }

            if (choice == 4){
                while (true){
                    LOGGER_INFO.info("Start update dessert by id");
                    System.out.println("Start updating dessert`s info");
                    System.out.println("Enter dessert id");
                    String id = reader.readLine();
                    Dessert current = (Dessert) dessertService.read(id);
                    if (current != null ){
                        enter(current);
                        dessertService.update(current);
                        System.out.println("Operation complete");
                        LOGGER_INFO.info("Updated dessert by id" + id);
                    }
                    else {
                        System.out.println("This id does not exist, try again");
                        LOGGER_ERROR.error("Update dessert: Incorrect id: "+ id);
                        continue;
                    }
                    break;
                }
            }

            if (choice == 5){
                while (true){
                    LOGGER_WARN.warn("Start deleting dessert by id");
                    System.out.println("Start deleting dessert by id");
                    System.out.println("Enter dessert id");
                    String id = reader.readLine();
                    Dessert current = (Dessert) dessertService.read(id);
                    if (current != null ){
                        dessertService.delete(id);
                        LOGGER_WARN.warn("End deleting dessert by id");
                        System.out.println("Operation complete");
                    }
                    else {
                        LOGGER_ERROR.error("Deleting: Incorrect id: "+ id);
                        System.out.println("This id does not exist, try again");
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

    private static void enter (Dessert dessert) throws IOException {
        while (true){
            System.out.println("Enter dessert`s name");
            String name = reader.readLine();
            if (!name.isBlank()) {
                dessert.setName(name);
                LOGGER_INFO.info("Name added: "+ name);
            }
            else{
                System.out.println("Name is blanc, try again");
                LOGGER_ERROR.error("Name is blanc");
                continue;
            }
            break;
        }
        while (true){
            System.out.println("Enter year of dessert`s creation");
            String str = reader.readLine();
            str = str.replaceAll("\\D+","");
            if (!str.isBlank()){
                int date = Integer.parseInt(str);
                dessert.setDateOfCreation(date);
                LOGGER_INFO.info("Year of dessert`s creation added: "+ date);
            }
            else {
                LOGGER_ERROR.error("Year of dessert`s creation is blanc");
                System.out.println("Year of dessert`s creation is blanc, try again");
                continue;
            }
            break;
        }
    }
}