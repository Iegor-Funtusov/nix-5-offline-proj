package com.nix.hw.ionio;

import com.nix.hw.ionio.controller.AuthorController;
import com.nix.hw.ionio.controller.BookController;
import com.nix.hw.ionio.entity.Author;
import com.nix.hw.ionio.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;

public class CommonTest {

    public static final AuthorController authorController = new AuthorController();
    public static final BookController bookController = new BookController();

    public static void run() {

        Author author1 = new Author();
        Author author2 = new Author();

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        author1.setFirstName("authorFirstName1");
        author1.setLastName("authorLastName1");

        author2.setFirstName("authorFirstName2");
        author2.setLastName("authorLastName2");

        book1.setName("bookName1");
        book2.setName("bookName2");
        book3.setName("bookName3");

        author1.setBooks(new ArrayList<>(Arrays.asList(book1, book2)));
        author2.setBooks(new ArrayList<>(Arrays.asList(book2)));

        book1.setAuthors(new ArrayList<>(Arrays.asList(author1)));
        book2.setAuthors(new ArrayList<>(Arrays.asList(author1, author2)));
        book3.setAuthors(new ArrayList<>(Arrays.asList(author2)));


        System.out.println("Creating authors");
        authorController.create(author1);
        authorController.create(author2);
        System.out.println("Authors:\n" + authorController.findAll().toString());

        System.out.println("\nCreating books");
        bookController.create(book1);
        bookController.create(book2);
        bookController.create(book3);
        System.out.println("Books:\n" + bookController.findAll().toString());

        System.out.println("\nUpdating author2");
        author2.setLastName("Vasyaa");
        authorController.update(author2);
        System.out.println("Find updated author2 by id:\n" +
                            authorController.findById(author2.getId()));

        System.out.println("\nUpdating book2");
        book2.setName("NewBook2Name");
        bookController.update(book2);
        System.out.println("Find updated book2 by id:\n" +
                            bookController.findById(book2.getId()));

        System.out.println("\nDeleting author1");
        authorController.delete(author1);
        System.out.println("Find all authors:\n" +
                            authorController.findAll());

        System.out.println("\nDeleting book2");
        bookController.delete(book2);
        System.out.println("Find all books:\n" +
                            bookController.findAll());

    }
}
