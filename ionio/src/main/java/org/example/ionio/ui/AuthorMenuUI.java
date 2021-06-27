package org.example.ionio.ui;

import org.example.ionio.controller.AuthorController;
import org.example.ionio.model.Author;
import org.example.ionio.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class AuthorMenuUI {
    private final BufferedReader reader;
    private final AuthorController controller;
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    public AuthorMenuUI(BufferedReader reader) {
        this.reader = reader;
        controller = new AuthorController();
    }

    public void exec() {
        try {
            String helpStr = "Set an action: " + "\n 1 - update Author"
                    + "\n 2 - delete Author" + "\n 3 - get all Authors" + "\n 4 - get Author by Id"
                    + "\n 5 - get Authors by Book" + "\n 6 - back to menu" + "\n 0 - exit";
            System.out.println(helpStr);
            setAction(reader.readLine());
        } catch (IOException ex) {
            LOGGER_ERROR.error(ex.getMessage());
        }
    }

    private void setAction(String read) throws IOException {
        switch (read) {
            case "1":{
                updateAuthor();
                exec();
            }
            break;
            case "2":{
                deleteAuthor();
                exec();
            }
            break;
            case "3":{
                readAllAuthors();
                exec();
            }
            break;
            case "4":{
                readAuthorById();
                exec();
            }
            break;
            case "5":{
                readAuthorsByBook();
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

    private void updateAuthor() throws IOException{
        System.out.println("Enter author id which you want update: ");
        Author author = new Author();
        author.setId(reader.readLine());
        System.out.println("Enter new first name: ");
        author.setFirstName(reader.readLine());
        System.out.println("Enter new last name: ");
        author.setLastName(reader.readLine());
        controller.update(author);
        System.out.println("Author is updated");
    }

    private void deleteAuthor() throws IOException{
        System.out.println("Enter author ID for delete: ");
        String id = reader.readLine();
        controller.delete(id);
        System.out.println("Author is deleted");
    }

    private void readAllAuthors(){
        for(Author a : controller.readAll()){
            printAuthor(a);
        }
    }

    private void readAuthorById() throws IOException{
        System.out.println("Enter author ID for read: ");
        String id = reader.readLine();
        Author a = controller.readById(id);
        printAuthor(a);
    }

    private void readAuthorsByBook() throws IOException{
        System.out.println("Enter book ID for author search: ");
        List<Author> authors = controller.readByBook(reader.readLine());
        for(Author a : authors){
            printAuthor(a);
        }
    }

    private void printAuthor(Author a){
        System.out.println("***************");
        System.out.println("ID: " + a.getId());
        System.out.println("First Name: " + a.getFirstName());
        System.out.println("Last Name: " + a.getLastName());
        System.out.println("----Books----");
        List<Book> books = a.getBookList();
        for(Book b : books){
            System.out.println("Name: " + b.getName());
        }
        System.out.println("***************");
    }

}
