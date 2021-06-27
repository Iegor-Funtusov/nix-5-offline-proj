package ua.com.alevel.controller;

import ua.com.alevel.entity.Author;
import ua.com.alevel.service.AuthorService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AuthorController {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int choice = 0;
    static AuthorService authorService = new AuthorService();

    public static void authorController() throws IOException {
        Loop: while (true){
            System.out.println("You are on the Author CRUD! \n" +
                    "Please, choose an option below:\n" +
                    "2 Read all Authors\n" +
                    "3 Read Author by id\n" +
                    "4 Update Author`s info\n" +
                    "5 Delete Author by id\n" +
                    "0 Back to the main menu\n");

            String str = reader.readLine();

            str = str.replaceAll("\\D+","");
            if (!str.isBlank()){
                choice = Integer.parseInt(str);

            }
            else {
                System.out.println("incorrect input");

                continue ;
            }

            if (choice == 2){
                System.out.println("Start reading all authors");
                for(Author a : authorService.readAllAuthors()){
                    System.out.println(a.toString());
                }
                System.out.println("Operation complete");
            }

            if (choice == 3){
                System.out.println("Enter author ID for read: ");
                String id = reader.readLine();
                Author a = authorService.readAuthorById(id);
                System.out.println(a.toString());
            }

            if (choice == 4){
                System.out.println("Enter author id which you want update: ");
                Author author = new Author();
                author.setId(reader.readLine());
                System.out.println("Enter new first name: ");
                author.setFirstName(reader.readLine());
                System.out.println("Enter new last name: ");
                author.setLastName(reader.readLine());
                authorService.updateAuthor(author);
                System.out.println("Author is updated");
            }

            if (choice == 5){
                System.out.println("Enter author ID for delete: ");
                String id = reader.readLine();
                authorService.deleteAuthorById(id);
                System.out.println("Author is deleted");
            }

            if (choice == 0){
                break Loop;
            }
            else {
                continue ;
            }

        }


    }
}