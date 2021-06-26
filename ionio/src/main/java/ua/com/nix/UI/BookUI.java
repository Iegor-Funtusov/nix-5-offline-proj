package ua.com.nix.UI;

import ua.com.nix.model.Author;
import ua.com.nix.model.Book;
import ua.com.nix.service.AuthorService;
import ua.com.nix.service.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BookUI {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BookService bookService = new BookService();
    AuthorService authorService = new AuthorService();
    public void bookInterface() throws IOException {
        while (true){
            System.out.println("""
                                Enter task:
                                1 -> Add book
                                2 -> Update book
                                3 -> Delete book
                                4 -> Read all books
                                5 -> Find book by ID
                                6 -> Find author of book
                                0 -> Return to menu selection""");

            String task = reader.readLine();
            if ("1".equals(task)) {
                Book book = new Book();
                System.out.println("Enter id of author: ");
                String idAuthor = reader.readLine();
                Author author = authorService.read(idAuthor);
                if(author==null){
                    break;
                }
                System.out.println("Enter name of book: ");
                String name = reader.readLine();
                if (name.isBlank() || idAuthor.isBlank()) {
                    System.out.println("Incorrect input,try again ");
                    return;
                }
                book.setTitle(name);
                bookService.create(book,author);
            }
            if ("2".equals(task)) {
                System.out.println("Enter id for update");
                String id = reader.readLine();
                Book book = bookService.read(id);
                System.out.println("Enter new name of book");
                String name = reader.readLine();
                if(!name.isBlank()){
                    book.setTitle(name);
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
                    List<Book> books = bookService.readAll();
                    System.out.println(books);
            }
            if ("5".equals(task)) {
                System.out.println("Enter Id of book: ");
                String id = reader.readLine();
                Book book = bookService.read(id);
                System.out.println(book);
            }
            if ("6".equals(task)) {
                System.out.println("Enter Id of book: ");
                String id = reader.readLine();
                Book book = bookService.read(id);
                System.out.println(bookService.readAllAuthorsByBook(book));
            }
            if("0".equals(task)) {
                return;
            }
        }
    }
}


