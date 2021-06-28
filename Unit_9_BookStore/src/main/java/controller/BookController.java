package controller;

import obj.Book;
import services.HelpService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BookController extends AuthorController {

    public void bookController() {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Whats you need:\n" +
                    "1 -> create\n" +
                    "2 -> read all books\n" +
                    "3 -> read all Authors of a certain Book\n" +
                    "4 -> update\n" +
                    "5 -> delete\n" +
                    "6 -> back to menu");
            String input = scanner.next();
            switch (input) {
                case "1": {
                    System.out.println("Input name of book:");
                    String name = name();
                    System.out.println("Input Authors of book separated by comma:");
                    String list = list();
                    Book book = new Book();
                    book.setName(name);
                    book.setListOfAuthors(list);
                    HelpService.createBook(book);
                }
                break;
                case "2": {
                    HelpService.readAllBooks();
                }
                break;
                case "3": {
                    System.out.println("Enter the name of the book to find out their authors:");
                    String name;
                    name = name();
                    HelpService.readAllBooks(name);
                }
                break;
                case "4": {
                    boolean flag = true;
                    while (flag) {
                        String bookName, authorName, newInput;
                        try {
                            System.out.println("Enter the name of the book you want to change");
                            bookName = name();
                            System.out.println("Enter the name or names of the authors ");
                            authorName = reader.readLine();

                            System.out.println("Input new name of book");
                            newInput = name();
                            HelpService.updateBook(bookName, authorName, newInput, 1);
                            flag = false;

                        } catch (IOException e) {
                            System.out.println("Error");
                        }
                    }
                }
                break;
                case "5": {
                    System.out.println("Enter the name of the book you want to delete");
                    String bookName, authorName;
                    try {
                        bookName = name();
                        System.out.println("Enter the name or names of the authors that you want to delete");
                        authorName = reader.readLine();
                        HelpService.deleteBook(bookName, authorName);
                    } catch (IOException e) {
                        System.out.println("Error");
                    }
                }
                break;
                case "6": {
                    return;
                }
                default:
                    System.out.println("Wrong input. Use numbers");
            }
        }
    }

    private String name() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("You haven't entered anything. Enter again");
            return name();
        }
        return name;
    }

    private String list() {
        Scanner scanner = new Scanner(System.in);
        String authors = scanner.nextLine();
        if (authors.isEmpty()) {
            System.out.println("You haven't entered anything. Enter again");
            return list();
        }
        for (int i = 0; i < authors.length(); i++) {
            if (!(Character.isLetter(authors.charAt(i)) || authors.charAt(i) == ' ' || authors.charAt(i) == ',')) {
                System.out.println("Enter the first and last names of the authors and separate them with a comma");
                return list();
            }
        }
        String[] listOfAuthors = authors.split(",");
        {
            int i = 0;
            while (i < listOfAuthors.length) {
                listOfAuthors[i] = listOfAuthors[i].trim();
                String[] fullName = listOfAuthors[i].split(" ");
                if (fullName.length == 2) {
                    i++;
                } else {
                    System.out.println("Incorrect input. Enter just the first and last name");
                    return list();
                }
            }
        }
        String list = "";
        for (int i = 0; i < listOfAuthors.length; i++) {
            if (i == listOfAuthors.length - 1)
                list += listOfAuthors[i];
            else
                list += listOfAuthors[i] + ", ";
        }
        return list;
    }
}
