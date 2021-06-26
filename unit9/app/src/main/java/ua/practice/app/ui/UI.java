package ua.practice.app.ui;

import ua.practice.app.ui.AuthorUI;
import ua.practice.app.ui.BookUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final AuthorUI authorUI = new AuthorUI();
    private final BookUI bookUI = new BookUI();


    public void process() {
        String input;
        printOptions();
        try {
            while ((input = bufferedReader.readLine()) != null) {
                switch (input) {
                    case "1":
                        authorUI.process(bufferedReader);
                        break;
                    case "2":
                        bookUI.process(bufferedReader);
                        break;
                    case "3":
                        break;
                    case "4":
                        return;
                    default:
                        System.out.println("Incorrect input. Try again.");
                }
                printOptions();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException.getMessage());
        }

    }

    public void printOptions() {
        System.out.println("1 - Author operations");
        System.out.println("2 - Book operations");
        System.out.println("3 - Test all operations by CommonTest");
        System.out.println("4 - Stop");
    }
}
