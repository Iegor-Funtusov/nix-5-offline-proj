package ua.practice.app;

import ua.practice.app.date.DateReader;
import ua.practice.app.name.NameReader;
import ua.practice.app.way.FileHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        ReaderUtil.changeWorkingDirectory();
        DateReader dateReader = new DateReader();
        NameReader nameReader = new NameReader();
        FileHandler fileHandler = new FileHandler();
        printOptions();
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            try {
                switch (input) {
                    case "1":
                        dateReader.read().forEach(System.out::println);
                        break;
                    case "2":
                        System.out.println(nameReader.findUniqueName());
                        break;
                    case "3":
                        fileHandler.processFile();
                        break;
                    case "4":
                        return;
                    default:
                        System.out.println("Incorrect input.");
                }
            } catch (RuntimeException e) {
                System.out.println("Something went wrong. Try again.");
            }
            printOptions();
        }
    }

    private static void printOptions() {
        System.out.println("1 - date task");
        System.out.println("2 - unique name task");
        System.out.println("3 - shortest path task");
        System.out.println("4 - exit");
    }
}
