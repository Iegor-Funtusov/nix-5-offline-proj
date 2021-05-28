package ua.com.nix.UI;

import ua.com.nix.model.Book;
import ua.com.nix.service.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BookUI {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BookService bookService = new BookService();
    public void bookInterface() throws IOException {
        while (true){
            System.out.println("""
                                Enter task:
                                1 -> Add book
                                2 -> Update book
                                3 -> Delete book
                                4 -> Read all books
                                5 -> Find book by ID
                                0 -> Return to menu selection""");

            String task = reader.readLine();
            if ("1".equals(task)) {
                Book book = new Book();
                System.out.println("Enter name of book: ");
                String name = reader.readLine();
                if (name.isBlank()) {
                    System.out.println("Incorrect input,try again ");
                    return;
                }
                book.setName(name);
                bookService.create(book);
            }
            if ("2".equals(task)) {
                System.out.println("Enter id for update");
                String id = reader.readLine();
                Book book = bookService.findById(id);
                System.out.println("Enter new name of book");
                String name = reader.readLine();
                if(!name.isBlank()){
                    book.setName(name);
                    bookService.update(book);
                }
                else {
                    return;
                }
            }
            if ("3".equals(task)) {
                System.out.println("Enter id");
                String id = reader.readLine();
                if (id == null || id.isBlank()) {
                    System.out.println("Incorrect input,try again...");
                    continue;
                }
                try {
                    bookService.delete(id);
                } catch (Exception e) {
                    System.out.println("ID doesn't exist...");
                }
            }
            if ("4".equals(task)) {
                Book[] books = bookService.findAll();
                System.out.println(Arrays.toString(books));
            }
            if ("5".equals(task)) {
                System.out.println("Enter Id of course: ");
                String id = reader.readLine();
                Book book = bookService.findById(id);
                System.out.println(book);
            }
            if("0".equals(task)) {
                return;
            }
        }
    }
}


