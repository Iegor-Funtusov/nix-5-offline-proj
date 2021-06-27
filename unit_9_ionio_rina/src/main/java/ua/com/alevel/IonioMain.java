package ua.com.alevel;

import ua.com.alevel.controller.AuthorController;
import ua.com.alevel.controller.BookController;
import ua.com.alevel.controller.CreateController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IonioMain {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int choice;

    public static void main(String[] args) throws IOException {
        while (true){

            System.out.println("Choose the option:\n" +
                    "1 Create entity\n" +
                    "2 Author CRUD\n" +
                    "3 Book CRUD\n" +
                    "0 Exit");

            String str = reader.readLine();
            str = str.replaceAll("\\D+","");
            if (!str.isBlank()){
                choice = Integer.parseInt(str);
            }
            else {
                System.out.println("incorrect input");
                continue ;
            }

            switch (choice){
                case 1:
                    CreateController.createBook();
                    break;
                case 2:
                    AuthorController.authorController();
                    break;
                case 3:
                    BookController.bookController();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    continue;
            }
        }
    }
}