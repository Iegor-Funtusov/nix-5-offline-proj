package ua.davidenko.library;


import ua.davidenko.authors.Authors;
import ua.davidenko.authors.AuthorsService;
import ua.davidenko.books.Books;
import ua.davidenko.books.BooksService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LibraryService {
    private static LibraryArrayCrud libraryCrud = new LibraryArrayCrud();
    private static BooksService booksService = new BooksService();
    private static AuthorsService authorsService = new AuthorsService();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void libraryOptions() throws IOException {

        System.out.println("Enter library operation: \n" +
                "1 - add Author&Book to library");
                String options = br.readLine();
        switch (options) {
            case "1":
                Authors author = new Authors();
                Books book = new Books();
                author.setAuthorName(author.getAuthorName());
                authorsService.create(author);
                book.setTitle(book.getTitle());
                booksService.create(book);
                Library library = new Library(author, book);
                System.out.println(library);
        }
    }
}



