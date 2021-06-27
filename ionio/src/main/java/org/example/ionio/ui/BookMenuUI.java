package org.example.ionio.ui;

import org.example.ionio.controller.BookController;
import org.example.ionio.model.Author;
import org.example.ionio.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class BookMenuUI {
    private final BufferedReader reader;
    private final BookController controller;
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    public BookMenuUI(BufferedReader reader) {
        this.reader = reader;
        controller = new BookController();
    }

    public void exec() {
        try {
            String helpStr = "Set an action: " + "\n 1 - update Book"
                    + "\n 2 - delete Book" + "\n 3 - get all Books" + "\n 4 - get Book by Id"
                    + "\n 5 - get Books by Author" + "\n 6 - back to menu" + "\n 0 - exit";
            System.out.println(helpStr);
            setAction(reader.readLine());
        } catch (IOException ex) {
            LOGGER_ERROR.error(ex.getMessage());
        }
    }

    private void setAction(String read) throws IOException {
        switch (read) {
            case "1":{
                updateBook();
                exec();
            }
            break;
            case "2":{
                deleteBook();
                exec();
            }
            break;
            case "3":{
                readAllBooks();
                exec();
            }
            break;
            case "4":{
                readBookById();
                exec();
            }
            break;
            case "5":{
                readBookByAuthor();
                exec();
            }
            break;
            case "6":{
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

    private void updateBook() throws IOException{
        System.out.println("Enter book id which you want update: ");
        Book book = new Book();
        book.setId(reader.readLine());
        System.out.println("Enter new book name: ");
        book.setName(reader.readLine());
        controller.update(book);
        System.out.println("Book is updated");
    }

    private void deleteBook() throws IOException{
        System.out.println("Enter book ID for delete: ");
        String id = reader.readLine();
        controller.delete(id);
        System.out.println("Book is deleted");
    }

    private void readAllBooks(){
        for(Book b : controller.readAll()){
            printBook(b);
        }
    }

    private void readBookById() throws IOException{
        System.out.println("Enter book ID for read: ");
        String id = reader.readLine();
        Book b = controller.readById(id);
        printBook(b);
    }

    private void readBookByAuthor() throws IOException{
        System.out.println("Enter author ID for book search: ");
        List<Book> books = controller.readByAuthor(reader.readLine());
        for(Book b : books){
            printBook(b);
        }
    }

    private void printBook(Book b){
        System.out.println("***************");
        System.out.println("ID: " + b.getId());
        System.out.println("Name: " + b.getName());
        System.out.println("----Authors----");
        List<Author> authors = b.getAuthors();
        for(Author a : authors){
            System.out.println("First Name: " + a.getFirstName());
            System.out.println("Last Name: " + a.getLastName());
        }
        System.out.println("***************");
    }
}
