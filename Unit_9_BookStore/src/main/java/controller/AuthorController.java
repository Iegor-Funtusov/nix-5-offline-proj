package controller;

import obj.Author;
import services.HelpService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AuthorController {
    public void authorsController() {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Whats you need:\n" +
                    "1 -> create\n" +
                    "2 -> read all Authors\n" +
                    "3 -> read all books by a particular author\n" +
                    "4 -> update\n" +
                    "5 -> delete\n" +
                    "6 -> back to menu");
            String input = scanner.next();
            switch (input) {
                case "1": {
                    Author author = new Author();
                    System.out.println("Input first name of author");
                    author.setFirstName(FullName());
                    System.out.println("Input last name of author");
                    author.setLastName(FullName());
                    try {
                        String temp;
                        while (true) {
                            System.out.println("Would you like to add books?\n" +
                                    "1 -> yes\n" +
                                    "2 -> no");
                            temp = reader.readLine();
                            if (!(temp.equals("1") || temp.equals("2"))) {
                                System.out.println("Wrong input. Use numbers");
                            } else
                                break;
                        }
                        if (temp.equals("1")) {
                            System.out.println("Input books of author(if need not one use comma)");
                            author.setListOfBooks(listOfBooks());
                        } else
                            author.setListOfBooks("");
                        HelpService.createAuthor(author);
                    } catch (IOException e) {
                        System.out.println("Error");
                    }
                }
                break;
                case "2": {
                    HelpService.readAllAuthors();
                }
                break;
                case "3": {
                    System.out.println("Input name of author which you want to find:");
                    String name;
                    try {
                        name = reader.readLine();
                        HelpService.readAllAuthors(name);
                    } catch (IOException e) {
                        System.out.println("Error");
                    }
                }
                break;
                case "4": {
                    boolean flag = true;
                    while (flag) {
                        String oldBook, authorName, authorLastName, fullName, newInput, choice;
                        try {
                            System.out.println("Input author's first name:");
                            authorName = FullName();
                            System.out.println("Input author's last name");
                            authorLastName = FullName();
                            fullName = authorName + " " + authorLastName;
                            System.out.println("What you want to change:\n" +
                                    "1 -> book name\n" +
                                    "2 -> author's name");
                            choice = reader.readLine();
                            switch (choice) {
                                case "1": {
                                    System.out.println("Enter the name of the book you want to change:");
                                    oldBook = name();
                                    System.out.println("Enter new name of book:");
                                    newInput = name();
                                    HelpService.updateAuthor(oldBook, fullName, newInput, 1);
                                    flag = false;
                                }
                                break;
                                case "2": {
                                    System.out.println("Input new name of author:");
                                    newInput = FullName();
                                    System.out.println("Input new last name of author:");
                                    newInput += " " + FullName();
                                    HelpService.updateAuthor("", fullName, newInput, 2);
                                    flag = false;
                                }
                                break;
                                default:
                                    System.out.println("Error");
                            }
                        } catch (IOException e) {
                            System.out.println("Error");
                        }
                    }
                }
                break;
                case "5": {
                    System.out.println("Enter the author you want to delete: ");
                    String name;
                    try {
                        name = reader.readLine();
                        HelpService.deleteAuthor(name);
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

    private String FullName() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("You haven't entered anything. Enter again");
            return FullName();
        }
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i))) {
                System.out.println("Name have only letters. Try again");
                return FullName();
            }
        }
        return name;
    }

    private String listOfBooks() {
        Scanner scan = new Scanner(System.in);
        String listOfBooks = scan.nextLine();
        if (listOfBooks.isEmpty()) {
            System.out.println("You haven't entered anything. Enter again");
            return listOfBooks();
        }
        for (int i = 0; i < listOfBooks.length(); i++) {
            if (!Character.isLetter(listOfBooks.charAt(i))) {
                System.out.println("Enter a comma-separated list of books. Enter again");
                return listOfBooks();
            }
        }
        String[] books = listOfBooks.split(",");
        String list = "";
        for (int i = 0; i < books.length; i++) {
            if (i == books.length - 1)
                list += books[i];
            else
                list += books[i] + ", ";
        }
        return list;
    }

    private String name() {
        String name;
        try (Scanner scanner = new Scanner(System.in)) {
            name = scanner.nextLine();
        }
        if (name.isEmpty()) {
            System.out.println("You haven't entered anything. Enter again");
            return name();
        }
        return name;
    }
}
