package ua.com.nix.UI;

import ua.com.nix.model.Author;
import ua.com.nix.model.Book;
import ua.com.nix.model.Library;
import ua.com.nix.service.AuthorService;
import ua.com.nix.service.BookService;
import ua.com.nix.service.LibraryService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LibraryUI {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    LibraryService libraryService = new LibraryService();
    BookService bookService = new BookService();
    AuthorService authorService = new AuthorService();
    public void libraryInterface() throws IOException {
        while (true){
            System.out.println("""
                                Enter task:
                                1 -> Add relation
                                2 -> Update relation
                                3 -> Delete relation
                                4 -> Read all relation
                                5 -> Find relation by ID
                                0 -> Return to menu selection""");

            String task = reader.readLine();
            if ("1".equals(task)) {
                Book [] books = bookService.findAll();
                Author [] authors = authorService.findAll();
                System.out.println(Arrays.toString(books));
                System.out.println(Arrays.toString(authors));
                Library library = new Library();
                System.out.println("Enter id of book: ");
                String idBook = reader.readLine();
                System.out.println("Enter id of author: ");
                String idAuthor = reader.readLine();
                if (idBook == null || idBook.isBlank()) {
                    System.out.println("Incorrect input id of book,try again...");
                    continue;
                }
                if (idAuthor == null || idAuthor.isBlank()) {
                    System.out.println("Incorrect input id of author,try again...");
                    continue;
                }
                Book book = bookService.findById(idBook);
                Author author = authorService.findById(idAuthor);
                library.setBook(book);
                library.setAuthor(author);
                libraryService.create(library);
            }
            if ("2".equals(task)) {
                System.out.println("Enter id of relation for update: ");
                String idLibrary = reader.readLine();
                Library library = libraryService.findById(idLibrary);
                System.out.println("Enter author ID: ");
                String idAuthor = reader.readLine();
                System.out.println("Enter book ID: ");
                String idBook = reader.readLine();
                if(!idAuthor.isBlank()){
                    library.setAuthor(authorService.findById(idAuthor));
                }
                if(!idBook.isBlank()){
                    library.setBook(bookService.findById(idBook));
                }
                libraryService.update(library);
            }
            if ("3".equals(task)) {
                System.out.println("Enter id for delete relation: ");
                String id = reader.readLine();
                if (id == null || id.isBlank()) {
                    System.out.println("Incorrect input id of relation,try again...");
                    continue;
                }
                try {
                    libraryService.delete(id);
                } catch (Exception e) {
                    System.out.println("ID doesn't exist...");
                }
            }
            if ("4".equals(task)) {
                Library[] libraries = libraryService.findAll();
                System.out.println(Arrays.toString(libraries));
            }
            if ("5".equals(task)) {
                System.out.println("Enter Id of relation: ");
                String id = reader.readLine();
                Library library = libraryService.findById(id);
                System.out.println(library);
            }
            if("0".equals(task)) {
                return;
            }
        }
    }
}
