package ua.practice.unit6.application.user_interface;

import ua.practice.unit6.application.controller.AuthorToBookController;

import java.io.BufferedReader;
import java.io.IOException;

public class AuthorToBookUI {
    BufferedReader bufferedReader;
    AuthorToBookController authorToBookController;

    public AuthorToBookUI(BufferedReader bufferedReader, AuthorToBookController authorToBookController) {
        this.bufferedReader = bufferedReader;
        this.authorToBookController = authorToBookController;
    }

    public void process() throws IOException {
        String command;
        printOptions();
        while ((command = bufferedReader.readLine())!= null) {
            switch (command){
                case "1":
                    authorToBookController.createAuthorToBook();
                    break;
                case "2":
                    authorToBookController.updateAuthorToBook();
                    break;
                case "3":
                    authorToBookController.deleteAuthorToBook();
                    break;
                case "4":
                    authorToBookController.printAllAuthorToBooks();
                    break;
                case "5":
                    authorToBookController.printAuthorToBookById();
                    break;
                case "6":
                    authorToBookController.printAllAuthorsByBookId();
                    break;
                case "7":
                    authorToBookController.printAllBooksByAuthorId();
                    break;
                case "8":
                    return;
                default:
                    System.out.println("Incorrect input. Try again.");
            }
            printOptions();
        }
    }

    private void printOptions(){
        System.out.println("Choose option: ");
        System.out.println("1 - create authorToBook");
        System.out.println("2 - update authorToBook");
        System.out.println("3 - delete authorToBook");
        System.out.println("4 - read all authorToBooks");
        System.out.println("5 - read authorToBook by id");
        System.out.println("6 - read all authors by book id");
        System.out.println("7 - read all books by author id");
        System.out.println("8 - stop");
    }
}
