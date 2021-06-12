package ua.practice.unit6.application.controller;

import ua.practice.unit6.application.entity.Book;
import ua.practice.unit6.application.service.serviceImpl.BookServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class BookController {
    BookServiceImpl bookService = new BookServiceImpl();
    BufferedReader bufferedReader;

    public BookController(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public BookServiceImpl getBookService() {
        return bookService;
    }

    public void createBook() throws IOException {
        Book book = new Book();
        System.out.println("Input book's name: ");
        book.setName(bufferedReader.readLine());
        System.out.println("Input book's year of publishing: ");
        try {
            book.setYearOfPublishing(Integer.parseInt(bufferedReader.readLine()));
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input.");
            return;
        }
        bookService.create(book);
    }

    public void updateBook() throws IOException {
        System.out.println("Input book's id:");
        String bookId = bufferedReader.readLine();
        Book book = new Book();
        book.setId(bookId);
        System.out.println("Input book's name");
        book.setName(bufferedReader.readLine());
        System.out.println("Input book's year of publishing");
        try {
            book.setYearOfPublishing(Integer.parseInt(bufferedReader.readLine()));
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input.");
            return;
        }
        bookService.update(book);
    }

    public void printAllBooks() {
        bookService.read().forEach(System.out::println);
    }

    public void printBookById() throws IOException {
        System.out.println("Input book's id to print");
        System.out.println(bookService.read(bufferedReader.readLine()));
    }

    public void deleteBook() throws IOException {
        System.out.println("Input book's id to delete");
        bookService.delete(bufferedReader.readLine());
    }
}
