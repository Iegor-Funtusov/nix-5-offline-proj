package org.example.ionio.ui;

import org.example.ionio.controller.AuthorController;
import org.example.ionio.controller.BookController;
import org.example.ionio.model.Author;
import org.example.ionio.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainMenuUI {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private final BookController bookController = new BookController();
    private final AuthorController authorController = new AuthorController();

    public void exec() {
        try {
            String helpStr = "Set an action: " + "\n 1 - create Book" + "\n 2 - Book manager" + "\n 3 - Author manager"
                    + "\n 0 - exit";
            System.out.println(helpStr);
            setAction(reader.readLine());
        } catch (IOException ex) {
            LOGGER_ERROR.error(ex.getMessage());
        }
    }

    private void setAction(String read) throws IOException {
        switch (read) {
            case "1":{
                createBook();
                exec();
            }
            break;
            case "2":{
                bookMenu();
                exec();
            }
            break;
            case "3":{
                authorMenu();
                exec();
            }
            break;
            case "0":{
                System.exit(0);
            }
            break;
            default:{
                System.out.println("Enter correct operation!");
                exec();
            }
        }
    }

    private void createBook(){
        try {
            System.out.println("Enter book ID: ");
            Book book = new Book();
            book.setId(reader.readLine());
            System.out.println("Enter book NAME: ");
            book.setName(reader.readLine());
            List<Author> authors = createAuthorList();
            book.setAuthors(authors);
            for(Author a : authors){
                saveAuthor(a, book);
            }
            bookController.create(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAuthor(Author a, Book book){
        List<Book> books = new ArrayList<>();
        books.add(book);
        if(authorController.readById(a.getId()) == null){
            a.setBookList(books);
            authorController.create(a);
        } else {
            Author a1 = authorController.readById(a.getId());
            books = a1.getBookList();
            books.add(book);
            a.setBookList(books);
            authorController.update(a);
        }
    }

    private List<Author> createAuthorList() throws IOException{
        List<Author> authors = new ArrayList<>();
        System.out.println("Enter number of authors: ");
        int numberOfAuthors = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfAuthors; i++) {
            Author author = createAuthor();
            authors.add(author);
        }
        return authors;
    }

    private Author createAuthor() throws IOException{
        Author author = new Author();
        System.out.println("Enter author ID: ");
        author.setId(reader.readLine());
        System.out.println("Enter first name: ");
        author.setFirstName(reader.readLine());
        System.out.println("Enter last name: ");
        author.setLastName(reader.readLine());
        return author;
    }

    private void bookMenu(){
        BookMenuUI menu = new BookMenuUI(reader);
        menu.exec();
    }

    private void authorMenu(){
        AuthorMenuUI menu = new AuthorMenuUI(reader);
        menu.exec();
    }

}
