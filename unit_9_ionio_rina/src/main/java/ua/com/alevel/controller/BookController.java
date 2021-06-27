package ua.com.alevel.controller;

import ua.com.alevel.entity.Book;
import ua.com.alevel.service.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookController {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int choice = 0;
    static BookService bookService = new BookService();

    public static void bookController() throws IOException {
        Loop: while (true){
            System.out.println("You are on the book CRUD! \n" +
                    "Please, choose an option below:\n" +
                    "2 Read all books\n" +
                    "3 Read book by id\n" +
                    "4 Update book`s info\n" +
                    "5 Delete book by id\n" +
                    "0 Back to the main menu\n");

            String str = reader.readLine();

            str = str.replaceAll("\\D+","");
            if (!str.isBlank()){
                choice = Integer.parseInt(str);

            }
            else {
                System.out.println("incorrect input");

                continue ;
            }

            if (choice == 2){
                System.out.println("Start reading all books");
                for(Book a : bookService.readAllBooks()){
                    System.out.println(a.toString());
                }
                System.out.println("Operation complete");
            }

            if (choice == 3){
                System.out.println("Enter Book ID for read: ");
                String id = reader.readLine();
                Book a = bookService.readBookById(id);
                System.out.println(a.toString());
            }

            if (choice == 4){
                System.out.println("Enter Book id which you want update: ");
                Book book = new Book();
                book.setId(reader.readLine());
                System.out.println("Enter new name: ");
                book.setName(reader.readLine());
                bookService.updateBook(book);
                System.out.println("book is updated");
            }

            if (choice == 5){
                System.out.println("Enter author ID for delete: ");
                String id = reader.readLine();
                bookService.deleteBookById(id);
                System.out.println("Book is deleted");
            }

            if (choice == 0){
                break Loop;
            }
            else {
                continue ;
            }

        }


    }

}