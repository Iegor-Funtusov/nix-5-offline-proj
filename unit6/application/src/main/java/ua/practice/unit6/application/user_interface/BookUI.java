package ua.practice.unit6.application.user_interface;

import ua.practice.unit6.application.controller.BookController;

import java.io.BufferedReader;
import java.io.IOException;

public class BookUI {
    BufferedReader bufferedReader;
    BookController bookController;

    public BookUI(BufferedReader bufferedReader, BookController bookController) {
        this.bufferedReader = bufferedReader;
        this.bookController = bookController;
    }

    public void process() throws IOException {
        String command;
        printOptions();
        while ((command = bufferedReader.readLine()) != null) {
            switch (command) {
                case "1":
                    bookController.createBook();
                    break;
                case "2":
                    bookController.updateBook();
                    break;
                case "3":
                    bookController.deleteBook();
                    break;
                case "4":
                    bookController.printAllBooks();
                    break;
                case "5":
                    bookController.printBookById();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Incorrect input. Try again.");
            }
            printOptions();
        }
    }

    private void printOptions() {
        System.out.println("Choose option: ");
        System.out.println("1 - create book");
        System.out.println("2 - update book");
        System.out.println("3 - delete book");
        System.out.println("4 - read all books");
        System.out.println("5 - read book by id");
        System.out.println("6 - stop");
    }
}
