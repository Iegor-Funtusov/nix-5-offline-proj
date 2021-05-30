package ua.davidenko.service;

import ua.davidenko.authors.Authors;
import ua.davidenko.authors.AuthorsService;
import ua.davidenko.books.Books;
import ua.davidenko.books.BooksService;
import ua.davidenko.library.LibraryService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ControlMain {
    public static void main(String[] args) throws IOException {
        chooseOperation();
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static AuthorsService authorsService = new AuthorsService();
    private static BooksService booksService = new BooksService();

    public static void chooseOperation() throws IOException {
        System.out.println("Choose operation with: \n" +
                "1 - Authors, 2 - Books, 3 - Library");
        String choose = br.readLine();
        switch (choose) {
            case "1":
                authorChoose();
                break;
            case "2":
                bookChoose();
                break;
            case "3":
                LibraryService.libraryOptions();
                break;
            default:
                System.out.println("Wrong input");
        }
    }

    public static void authorChoose() throws IOException {
        while (true) {
            System.out.println("Author create: \n" +
                    "1 - create author, 2 - read all authors, 3 - read author by Id, 4 - update author, 5 - delete author\n" +
                    "0 - return to main menu");
            String choose = br.readLine();
            switch (choose) {
                case "1":
                    Authors author = new Authors();
                    System.out.println("Enter author name");
                    String authorName = br.readLine();
                    author.setAuthorName(authorName);
                    authorsService.create(author);
                    break;
                case "2":
                    System.out.println(Arrays.toString(authorsService.readAll()));
                    break;
                case "3":
                    System.out.println("Enter author Id");
                    String authorId = br.readLine();
                    authorsService.readById(authorId);
                    System.out.println(authorsService.readById(authorId));
                    break;
                case "4":
                    System.out.println("Enter author Id for update");
                    String idForUpdate = br.readLine();
                    Authors newAuthor = authorsService.readById(idForUpdate);
                    System.out.println("Enter new author name");
                    String newName = br.readLine();
                    newAuthor.setAuthorName(newName);
                    authorsService.update(newAuthor);
                    break;
                case "5":
                    System.out.println("Enter author Id for delete");
                    String idForDelete = br.readLine();
                    authorsService.delete(idForDelete);
                    break;
                case "0":
                    chooseOperation();
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }

    public static void bookChoose() throws IOException {
        while (true) {
            System.out.println("Book create: \n" +
                    "1 - create book, 2 - read all book, 3 - read book by Id, 4 - update book, 5 - delete book\n" +
                    "0 - return to main menu");
            String choose = br.readLine();
            switch (choose) {
                case "1":
                    Books book = new Books();
                    System.out.println("Enter book name");
                    String bookTitle = br.readLine();
                    book.setTitle(bookTitle);
                    booksService.create(book);
                    break;
                case "2":
                    System.out.println(Arrays.toString(booksService.readAll()));
                    break;
                case "3":
                    System.out.println("Enter book Id");
                    String bookId = br.readLine();
                    booksService.readById(bookId);
                    System.out.println(authorsService.readById(bookId));
                    break;
                case "4":
                    System.out.println("Enter book Id for update");
                    String idForUpdate = br.readLine();
                    Books newBook = booksService.readById(idForUpdate);
                    System.out.println("Enter new book name");
                    String newName = br.readLine();
                    newBook.setTitle(newName);
                    booksService.update(newBook);
                    break;
                case "5":
                    System.out.println("Enter book Id for delete");
                    String idForDelete = br.readLine();
                    booksService.delete(idForDelete);
                    break;
                case "0":
                    chooseOperation();
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
