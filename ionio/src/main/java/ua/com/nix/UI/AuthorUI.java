package ua.com.nix.UI;

import ua.com.nix.model.Author;
import ua.com.nix.service.AuthorService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class AuthorUI {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    AuthorService authorService = new AuthorService();
    public void authorInterface() throws IOException {
        while (true){
            System.out.println("""
                                Enter task:
                                1 -> Add author
                                2 -> Update author
                                3 -> Delete author
                                4 -> Read all authors
                                5 -> Find author by ID
                                6 -> Find all books by author
                                0 -> Return to menu selection""");

            String task = reader.readLine();
            if ("1".equals(task)) {
                Author author = new Author();
                System.out.println("Enter author first name: ");
                String firstName = reader.readLine();
                System.out.println("Enter author last name: ");
                String lastName = reader.readLine();

                if (firstName.isBlank() || lastName.isBlank() ) {
                    System.out.println("Incorrect input,try again...");
                    return;
                }
                author.setFirstName(firstName);
                author.setLastName(lastName);
                authorService.create(author);
            }
            if ("2".equals(task)) {
                System.out.println("Enter id for update: ");
                String id = reader.readLine();
                Author author = authorService.read(id);
                if(author==null){
                    break;
                }
                System.out.println("Enter new first name of author");
                String firstName = reader.readLine();
                System.out.println("Enter new last name of author");
                String lastName = reader.readLine();
                if(!firstName.isBlank()||!lastName.isBlank()){
                    author.setFirstName(firstName);
                    author.setLastName(lastName);
                    authorService.update(author);
                }
                else {
                    return;
                }
            }
            if ("3".equals(task)) {
                System.out.println("Enter id for delete: ");
                String id = reader.readLine();
                if (id == null || id.isBlank()) {
                    System.out.println("Incorrect input,try again...");
                    continue;
                }
                try {
                    authorService.delete(id);
                } catch (Exception e) {
                    System.out.println("ID doesn't exist...");
                }
            }
            if ("4".equals(task)) {
                List<Author> authors = authorService.readAll();
                System.out.println(authors);
            }
            if ("5".equals(task)) {
                System.out.println("Enter Id of author: ");
                String id = reader.readLine();
                Author author = authorService.read(id);
                System.out.println(author);
            }
            if ("6".equals(task)) {
                System.out.println("Enter Id of author: ");
                String id = reader.readLine();
                Author author = authorService.read(id);
                System.out.println(authorService.readAllBooksByAuthor(author));
            }
            if("0".equals(task)) {
                return;
            }
        }
    }
}

