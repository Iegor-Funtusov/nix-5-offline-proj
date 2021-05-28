package ua.practice.unit6.application.user_interface;

import ua.practice.unit6.application.controller.AuthorController;

import java.io.BufferedReader;
import java.io.IOException;

public class AuthorUI {
    BufferedReader bufferedReader;
    AuthorController authorController;

    public AuthorUI(BufferedReader bufferedReader, AuthorController authorController) {
        this.bufferedReader = bufferedReader;
        this.authorController = authorController;
    }

    public void process() throws IOException {
        String command;
        printOptions();
        while ((command = bufferedReader.readLine())!= null) {
            switch (command){
                case "1":
                    authorController.createAuthor();
                    break;
                case "2":
                    authorController.updateAuthor();
                    break;
                case "3":
                    authorController.deleteAuthor();
                    break;
                case "4":
                    authorController.printAllAuthors();
                    break;
                case "5":
                    authorController.printAuthorById();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Incorrect input. Try again.");
            }
            printOptions();
        }
    }

    private void printOptions(){
        System.out.println("Choose option: ");
        System.out.println("1 - create author");
        System.out.println("2 - update author");
        System.out.println("3 - delete author");
        System.out.println("4 - read all authors");
        System.out.println("5 - read author by id");
        System.out.println("6 - stop");
    }
}
