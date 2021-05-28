package ua.practice.unit6.application;

import ua.practice.unit6.application.controller.AuthorController;
import ua.practice.unit6.application.controller.AuthorToBookController;
import ua.practice.unit6.application.controller.BookController;
import ua.practice.unit6.application.user_interface.AuthorToBookUI;
import ua.practice.unit6.application.user_interface.AuthorUI;
import ua.practice.unit6.application.user_interface.BookUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BookUI bookUI;
    private static AuthorUI authorUI;
    private static AuthorToBookUI authorToBookUI;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        initFields(bufferedReader);
        printOptions();
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            switch (input) {
                case "1":
                    authorUI.process();
                    break;
                case "2":
                    bookUI.process();
                    break;
                case "3":
                    authorToBookUI.process();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Incorrect input. Try again.");
            }
            printOptions();
        }
    }

    private static void printOptions() {
        System.out.println("1 - process authors");
        System.out.println("2 - process books");
        System.out.println("3 - process relation between authors and books");
        System.out.println("4 - stop");
    }


    private static void initFields(BufferedReader bufferedReader) {
        AuthorController authorController = new AuthorController(bufferedReader);
        BookController bookController = new BookController(bufferedReader);
        AuthorToBookController authorToBookController = new AuthorToBookController(bufferedReader,
                authorController.getAuthorService(), bookController.getBookService());

        bookUI = new BookUI(bufferedReader, bookController);
        authorUI = new AuthorUI(bufferedReader, authorController);
        authorToBookUI = new AuthorToBookUI(bufferedReader, authorToBookController);
    }
}
