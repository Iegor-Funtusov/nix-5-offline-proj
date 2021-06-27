package com.kiril.project.services;

import checkers.units.quals.A;
import com.kiril.project.dao.AuthorDAO;
import com.kiril.project.dao.BookDAO;
import com.kiril.project.entities.Author;
import com.kiril.project.entities.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LibraryService {
    private BookDAO bookDAO = new BookDAO();
    private AuthorDAO authorDAO = new AuthorDAO();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public LibraryService() throws IOException {
        while (true) {
            choseRightMethod();
        }
    }

    private void printMenu() {
        System.out.println("" +
                "1 - Creat Book\n" +
                "2 - Creat Author\n" +
                "3 - Update Book\n" +
                "4 - Update Author\n" +
                "5 - Print Library\n" +
                "6 - Delete Book\n" +
                "7 - Delete Author\n" +
                "8 - Read Book by id\n" +
                "9 - Read Author by id\n" +
                "10 - Get all books from author\n"+
                "11 - System.exit()");
    }

    private void choseRightMethod() {
        printMenu();
        int userInput = getUserInt();
        switch (userInput) {
            case 1:
                createBook();
                break;
            case 2:
                creatAuthor();
                break;
            case 3:
                updateBook();
                break;
            case 4:
                updateAuthor();
                break;
            case 5:
                print();
                break;
            case 6:
                deleteBook();
                break;
            case 7:
                deleteAuthor();
                break;
            case 8:
                readBook();
                break;
            case 9:
                readAuthor();
                break;
            case 10:
                printAllAuthorsBooks();
                break;
            case 11:
                System.exit(0);
                break;

        }
    }

    private void createBook() {
        try {
            String title, author;
            System.out.print("What is the name of the book >");
            title = reader.readLine();
            System.out.print("Who is the author(id) >");
            author = reader.readLine();
            bookDAO.create(new Book(title, author, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void creatAuthor() {
        try {
            String firstName, lastName;
            List<String> books = new ArrayList<>();
            System.out.print("What is author's first name >");
            firstName = reader.readLine();
            System.out.print("What is author's last name >");
            lastName = reader.readLine();
            System.out.print("How much books do you want to add >");
            int amountOfBooks = getUserInt();
            for (int i = 0; i < amountOfBooks; i++) {
                System.out.print("Enter name of the book >");
                books.add(reader.readLine());
                bookDAO.create(new Book(books.get(i), firstName + " " + lastName, true));
            }
            authorDAO.create(new Author(firstName, lastName, books, true));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateBook() {
        try {
        System.out.print("Enter id of book >");
            String id = reader.readLine();
            String title, author;
            System.out.printf("New title?");
            title = reader.readLine();
            System.out.println("New author?");
            author = reader.readLine();
            bookDAO.update(id, (new Book(title,author, true)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateAuthor() {
        try {
            System.out.print("Enter id of author >");
            String id = reader.readLine();
            String firstName, lastName;
            List<String> books = new ArrayList<>();
            System.out.print("New first name >");
            firstName = reader.readLine();
            System.out.print("New last name >");
            lastName = reader.readLine();
            System.out.print("How much books do you want to add >");
            int amountOfBooks = getUserInt();
            for (int i = 0; i < amountOfBooks; i++) {
                System.out.print("Enter name of the book >");
                books.add(reader.readLine());
            }
            authorDAO.update(id, new Author(firstName, lastName, books, true));
        } catch (IOException e) {

        }
    }

    private void deleteBook() {
        try {
            System.out.print("Enter id of book >");
            String id = null;
            id = reader.readLine();
            bookDAO.delete(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteAuthor() {
        try{
            System.out.print("Enter id of author >");
            String id = null;
            id = reader.readLine();
            authorDAO.delete(id);
        }catch (IOException e){}
    }

    private void print() {
        if (authorDAO.size() > 0)
        System.out.println(authorDAO.readAll());
        if(bookDAO.size() > 0)
        System.out.println(bookDAO.readAll());
    }

    private void readBook() {
        System.out.println("Enter id of book which you want to read!");
        String id = readLine();
        System.out.println(bookDAO.read(id));
    }

    private void readAuthor() {
        System.out.println("Enter id of author who you want to read!");
        String id = readLine();
        System.out.println(authorDAO.read(id));
    }

    private Integer getUserInt() {
        String regex = "[0-9]+";
        try {
            String userInput = reader.readLine();
            if(userInput.matches(regex)){
                return Integer.parseInt(userInput);
            }else {
                System.out.println("Wrong input, try again");
                return getUserInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Something went wrong in getUserInt() method");
    }

    private String readLine() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        }catch (IOException e) {
            System.out.println("some troubles with reaching console input");
            throw new RuntimeException();
        }
    }

    private void printAllAuthorsBooks() {
        System.out.println("Enter author's id >");
        String userInput = readLine();
        System.out.println(authorDAO.read(userInput).getAuthorsBooks());
    }

}
