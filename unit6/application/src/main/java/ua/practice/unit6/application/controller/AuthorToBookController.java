package ua.practice.unit6.application.controller;

import ua.practice.unit6.application.entity.Author;
import ua.practice.unit6.application.entity.AuthorToBook;
import ua.practice.unit6.application.entity.Book;
import ua.practice.unit6.application.service.serviceImpl.AuthorServiceImpl;
import ua.practice.unit6.application.service.serviceImpl.AuthorToBookServiceImpl;
import ua.practice.unit6.application.service.serviceImpl.BookServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class AuthorToBookController {
    AuthorServiceImpl authorService;
    BookServiceImpl bookService;
    AuthorToBookServiceImpl authorToBookService;
    BufferedReader bufferedReader;

    public AuthorToBookController(BufferedReader bufferedReader, AuthorServiceImpl authorService, BookServiceImpl bookService) {
        this.bufferedReader = bufferedReader;
        this.authorService = authorService;
        this.bookService = bookService;
        this.authorToBookService = new AuthorToBookServiceImpl();
    }

    public void createAuthorToBook() throws IOException {
        AuthorToBook authorToBook = new AuthorToBook();
        System.out.println("To create relation between author and book input both's id");

        System.out.println("Input Author's id: ");
        Author author = authorService.read(bufferedReader.readLine());

        System.out.println("Input Book's id: ");
        Book book = bookService.read(bufferedReader.readLine());

        authorToBook.setAuthors(author);
        authorToBook.setBooks(book);
        authorToBookService.create(authorToBook);
    }

    public void updateAuthorToBook() throws IOException {
        System.out.println("Input authorToBook's id:");
        String authorToBookId = bufferedReader.readLine();
        AuthorToBook authorToBook = authorToBookService.read(authorToBookId);

        System.out.println("Input new book's id:");
        Book book = bookService.read(bufferedReader.readLine());
        authorToBook.setBooks(book);

        System.out.println("Input new author's id:");
        Author author = authorService.read(bufferedReader.readLine());
        authorToBook.setAuthors(author);

        authorToBookService.update(authorToBook);
    }

    public void printAllAuthorToBooks() {
        authorToBookService.read().forEach(System.out::println);
    }

    public void printAuthorToBookById() throws IOException {
        System.out.println("Input authorToBook's id to print");
        System.out.println(authorToBookService.read(bufferedReader.readLine()));
    }

    public void printAllAuthorsByBookId() throws IOException {
        System.out.println("Input book's id ");
        authorToBookService.readAllAuthorsByBookId(bufferedReader.readLine()).forEach(System.out::println);
    }

    public void printAllBooksByAuthorId() throws IOException {
        System.out.println("Input author's id ");
        authorToBookService.readAllBooksByAuthorId(bufferedReader.readLine()).forEach(System.out::println);
    }

    public void deleteAuthorToBook() throws IOException {
        System.out.println("Input authorToBook's id to delete");
        authorToBookService.delete(bufferedReader.readLine());
    }

}