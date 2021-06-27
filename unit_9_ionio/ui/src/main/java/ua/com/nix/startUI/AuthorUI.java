package ua.com.nix.startUI;

import ua.com.nix.Author;
import ua.com.nix.Book;
import ua.com.nix.impl.AuthorServiceImpl;
import ua.com.nix.impl.BookServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AuthorUI {

    private static final AuthorServiceImpl authorService = new AuthorServiceImpl();
    private static final BookServiceImpl bookService = new BookServiceImpl();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String firstName;
    private static String lastName;
    private static final List<Book> bookList = new LinkedList<>();

    public static void create() throws IOException {

        Author author = new Author();

        System.out.print("Please input First name of author : ");
        firstName = reader.readLine();
        System.out.print("Please input Last name of author : ");
        lastName = reader.readLine();
        System.out.print("Input value of book of it author = ");

        if(authorService.findAll().size() >= 1){
            author.setId(authorService.findAll().get(authorService.findAll().size()-1).getId() + 1);
        }
        else author.setId(1);
        author.setFirstName(firstName);
        author.setLastName(lastName);

        int num = Integer.parseInt(reader.readLine());

        for (int i = 0; i < num; i++) {
            Book b = new Book();
            String title;

            System.out.print("Input title of " + (i + 1) + " book: ");
            title = reader.readLine();

            if(bookService.findAll().size()>=1){
                b.setId(bookService.findAll().get(bookService.findAll().size()-1).getId() + 1);
            }else b.setId(1);

            b.setTitle(title);
            b.setIdAuthorsList(Collections.singletonList(author.getId()));

            bookList.add(b);

            if(bookService.isBookByTitleExist(b.getTitle())){
                bookService.update(b);
            }else {
                bookService.create(b);
            }
        }

        List<Integer> booksID = new ArrayList<>();
        for (Book book : bookList) {
            booksID.add(book.getId());
        }
        author.setIdBooks(booksID);

        authorService.create(author);

        System.out.println("Your variant: if you want exit, please input 0, else, repeat logic");
    }

    public static void read() throws IOException {

        System.out.print("Please input First name of author to search info about him : ");
        firstName = reader.readLine();
        System.out.print("Please input Last name of author to search info about him : ");
        lastName = reader.readLine();
        Author a = authorService.findAuthorByFirstNameAndLastName(firstName, lastName);

        if (a != null) {
            authorService.read(a.getId());
        } else throw new RuntimeException("Author not found");
        System.out.println("Your variant: if you want exit, please input 0, else, repeat logic");
    }

    public static void update() throws IOException {

        System.out.print("Please input First name of author to search him : ");
        firstName = reader.readLine();
        System.out.print("Please input Last name of author to search him : ");
        lastName = reader.readLine();

        Author a = authorService.findAuthorByFirstNameAndLastName(firstName, lastName);
        if (a != null) {
            System.out.println("Input new First name for author");
            firstName = reader.readLine();
            System.out.println("Input new Last name for author");
            lastName = reader.readLine();
            a.setFirstName(firstName);
            a.setLastName(lastName);
            authorService.update(a);
        } else throw new RuntimeException("Author not found");

        System.out.println("Your variant: if you want exit, please input 0, else, repeat logic");
    }

    public static void delete() throws IOException {
        System.out.print("Please input First name of author to delete him : ");
        firstName = reader.readLine();
        System.out.print("Please input Last name of author to delete him : ");
        lastName = reader.readLine();

        Author a = authorService.findAuthorByFirstNameAndLastName(firstName, lastName);
        if (a != null) {
            authorService.delete(a.getId());
        } else throw new RuntimeException("Author not found");

        System.out.println("Your variant: if you want exit, please input 0, else, repeat logic");
    }
}
