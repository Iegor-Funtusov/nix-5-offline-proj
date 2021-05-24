package nix.com;

import nix.com.author.Author;
import nix.com.author.AuthorService;
import nix.com.book.Book;
import nix.com.book.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AppMain {
    public static void main(String[] args) throws IOException {
        BookService bookService = new BookService();
        Book book = null;
        Book[] books;
        AuthorService authorService = new AuthorService();
        BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));
        String choose;
        String title;
        String numPg;
        String id;

        while (true) {
            System.out.println(" " +
                    "Menu\n 1. Add book\n " +
                    "2. Display all book\n " +
                    "3. Find book by id\n " +
                    "4. Update book\n " +
                    "5. Delete book by id\n");

            choose = enter.readLine();
            try {
                Integer.parseInt(choose);
            } catch(Exception e) {
                System.out.println("Wrong input");
                continue;
            }

            switch (Integer.parseInt(choose)) {
                case 1:
                    System.out.println("Enter title of book");
                    title = enter.readLine();
                    System.out.println("Enter num of pages of book");
                    numPg = enter.readLine();
                    if (title.isBlank() || numPg.isBlank()) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    try {
                        Integer.parseInt(numPg);
                    } catch(Exception e) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    book.setTitle(title);
                    book.setNumPg(Integer.parseInt(numPg));
                    break;
                case 2:
                    books = bookService.readAll();
                    System.out.println(Arrays.toString(books));
                    break;
                case 3:
                    System.out.println("Enter id");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    System.out.println(bookService.findById(id).toString());
                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Enter id");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    bookService.delete(id);
                    break;
            }

        }
//        BookService bookService = new BookService();
//
//        Book book1 = new Book();
//        book1.setNumPg(10);
//        book1.setTitle("Player ready one");
//        bookService.create(book1);
//
//        Book book2 = new Book();
//        book2.setNumPg(20);
//        book2.setTitle("Player ready one2");
//        bookService.create(book2);
//
//        Book[] books = (bookService.readAll());
//        System.out.println("create " + books[0] + " " + books[1]);
//
//        bookService.delete(books[0].getId());
//
//        books = bookService.readAll();
//        System.out.println("delete " + books[0] + " " + books[1]);
//
//        System.out.println("find id" + bookService.findById(books[0].getId()).toString());
//
//        Book bookUpdate = bookService.findById(books[0].getId());
//        bookUpdate.setTitle("Hello");
//        bookUpdate.setNumPg(10000);
//
//        bookService.update(bookUpdate);
//
//        books = bookService.readAll();
//        System.out.println("update " + books[0] + " " + books[1]);
//
//        AuthorService authorService = new AuthorService();
//
//        Author author = new Author();
//        author.setAge(10);
//        author.setName("a");
//
//        authorService.create(author);
//
//        Author[] authors = authorService.readAll();
//
//        System.out.println("read create " + authors[0] + " " + authors[1]);
    }

    public static boolean isInt(String x) throws NumberFormatException
    {
        try {
            Integer.parseInt(x);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
