package ua.com.nix.startUI;

import ua.com.nix.Author;
import ua.com.nix.AuthorService;
import ua.com.nix.Book;
import ua.com.nix.BookService;
import ua.com.nix.impl.AuthorServiceImpl;
import ua.com.nix.impl.BookServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BookUI {
    private static final BookService bookService = new BookServiceImpl();
    private static final AuthorService authorService = new AuthorServiceImpl();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String title;
    private static final List<Author> authorList = new LinkedList<>();


    public static void create() throws IOException {

        Book book = new Book();

        System.out.print("Input title of new book: ");
        title = reader.readLine();
        System.out.print("Input count of authors, who work with this book = ");

        if(bookService.findAll().size() >= 1){
            book.setId(bookService.findAll().get(bookService.findAll().size()-1).getId() + 1);
        }else book.setId(1);
        book.setTitle(title);

        int num = Integer.parseInt(reader.readLine());

        for (int i = 0; i < num; i++) {
            Author a = new Author();
            String firstName, lastName;

            System.out.print("Input First name of " + (i + 1) + " author: ");
            firstName = reader.readLine();
            System.out.print("Input Last name of " + (i + 1) + " author: ");
            lastName = reader.readLine();

            if(authorService.findAll().size() >= 1){
                a.setId(authorService.findAll().get(authorService.findAll().size()-1).getId() + 1);
            }
            else a.setId(1);
            a.setFirstName(firstName);
            a.setLastName(lastName);
            a.setIdBooks(Collections.singletonList(book.getId()));

            authorList.add(a);

            if(authorService.isAuthorExist(a)){
                authorService.update(a);
            }else {
                authorService.create(a);
            }

        }

        List<Integer> authorsID = new ArrayList<>();
        for (Author author : authorList) {
            authorsID.add(author.getId());
        }
        book.setIdAuthorsList(authorsID);

        bookService.create(book);
        System.out.println("Your variant: if you want exit, please input 0, else, repeat logic");
    }

    public static void read() throws IOException {

        System.out.print("Please input title of book to search info about it -> ");
        title = reader.readLine();
        Book b = bookService.findBookByTitle(title);

        if (b != null) {
            bookService.read(b.getId());
        } else throw new RuntimeException("Author not found");

        System.out.println("Your variant: if you want exit, please input 0, else, repeat logic");
    }

    public static void update() throws IOException {
        System.out.print("Please input title of book to update info about it -> ");
        title = reader.readLine();
        Book b = bookService.findBookByTitle(title);

        if (b != null) {
            System.out.println("Input new title for this book:");
            title = reader.readLine();
            b.setTitle(title);
            bookService.update(b);
        } else throw new RuntimeException("Author not found");

        System.out.println("Your variant: if you want exit, please input 0, else, repeat logic");
    }

    public static void delete() throws IOException {
        System.out.print("Please input title of book to delete it -> ");
        title = reader.readLine();
        Book b = bookService.findBookByTitle(title);

        if (b != null) {
            bookService.delete(b.getId());
        } else throw new RuntimeException("Author not found");

        System.out.println("Your variant: if you want exit, please input 0, else, repeat logic");
    }
}
