package ua.com.alevel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.ConfectionerDao;
import ua.com.alevel.entity.Confectioner;
import ua.com.alevel.service.ConfectionerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConfectionerController {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ConfectionerService confectionerService = new ConfectionerService();
    private static int choice;

    public static void controller() throws IOException {

        Loop: while (true){
            System.out.println("You are on the Confectioner CRUD! \n" +
                    "Please, choose an option below:\n" +
                    "1 Create new confectioner\n" +
                    "2 Read all confectioners\n" +
                    "3 Read confectioner by id\n" +
                    "4 Update confectioner`s info\n" +
                    "5 Delete confectioner by id\n" +
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
                    LOGGER_INFO.info("Start creation confectioner");
                    System.out.println("Start creation");
                    Confectioner confectioner = new Confectioner();
                    enter(confectioner);
                    confectionerService.create(confectioner);
                    System.out.println(confectioner.toString());
                    System.out.println("Operation complete");
                    LOGGER_INFO.info("Confectioner created " + confectioner.toString());
                    break;
                }

            }

            if (choice == 2){
                LOGGER_INFO.info("Reading all confectioners ");
                System.out.println("Start reading all confectioners");
                System.out.println(confectionerService.readAll().toString());
                System.out.println("Operation complete");
            }

            if (choice == 3){
                while (true){
                    LOGGER_INFO.info("Start reading confectioner by id");
                    ConfectionerDao confectionerDao = new ConfectionerDao();
                    System.out.println("Start reading confectioner by id");
                    System.out.println("Enter confectioner`s id");
                    String id = reader.readLine();
                    Object object = confectionerDao.findById(id);
                    if (object != null){
                        System.out.println( confectionerService.read(id).toString());
                        System.out.println("Operation complete");
                        LOGGER_INFO.info("End reading confectioner by id: "+ confectionerService.read(id).toString());
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
                    LOGGER_INFO.info("Start update confectioner by id");
                    System.out.println("Start updating confectioner`s info");
                    System.out.println("Enter confectioner id");
                    String id = reader.readLine();
                    Confectioner current = (Confectioner) confectionerService.read(id);
                    if (current != null ){
                        enter(current);
                        confectionerService.update(current);
                        System.out.println("Operation complete");
                        LOGGER_INFO.info("Updated confectioner by id" + id);
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
                    LOGGER_WARN.warn("Start deleting confectioner by id");
                    System.out.println("Start deleting confectioner by id");
                    System.out.println("Enter confectioner`s id");
                    String id = reader.readLine();
                    Confectioner current = (Confectioner) confectionerService.read(id);
                    if (current != null ){
                        confectionerService.delete(id);
                        System.out.println("Operation complete");
                        LOGGER_WARN.warn("End deleting confectioner by id");
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

    private static void enter (Confectioner confectioner) throws IOException {
        while (true){
            System.out.println("Enter confectioner`s name");
            String name = reader.readLine();
            if (!name.isBlank())  {
                confectioner.setName(name);
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
            System.out.println("Enter confectioner`s age");
            String str = reader.readLine();
            str = str.replaceAll("\\D+","");
            if (!str.isBlank()){
                int date = Integer.parseInt(str);
                confectioner.setAge(date);
                LOGGER_INFO.info("Age added: "+ date);
            }
            else {
                System.out.println("Confectioner`s age is blanc, try again");
                LOGGER_ERROR.error("Age is blanc");
                continue;
            }
            break;
        }
    }
}