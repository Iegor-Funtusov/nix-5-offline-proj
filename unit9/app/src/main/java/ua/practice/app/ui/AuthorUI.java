package ua.practice.app.ui;

import ua.practice.app.entity.Author;
import ua.practice.app.service.service_impl.AuthorServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class AuthorUI {
    AuthorServiceImpl authorService = new AuthorServiceImpl();

    public void process(BufferedReader bufferedReader) throws IOException {
        String input;
        printOptions();
        while ((input = bufferedReader.readLine()) != null) {
            switch (input) {
                case "1":
                    createAuthor(bufferedReader);
                    break;
                case "2":
                    updateAuthor(bufferedReader);
                    break;
                case "3":
                    deleteAuthor(bufferedReader);
                    break;
                case "4":
                    readAllAuthors();
                    break;
                case "5":
                    readAuthor(bufferedReader);
                    break;
                case "6":
                    readBooksByAuthor(bufferedReader);
                    break;
                case "7":
                    return;
                default:
                    System.out.println("Incorrect input. Try again");
            }
            printOptions();
        }
    }

    private void createAuthor(BufferedReader bufferedReader) throws IOException {
        Author author = new Author();
        System.out.println("Input name:");
        author.setName(bufferedReader.readLine());
        System.out.println("Input last name:");
        author.setLastName(bufferedReader.readLine());
        authorService.create(author);
    }

    private void updateAuthor(BufferedReader bufferedReader) throws IOException {
        System.out.println("Input author's id to update");
        Author author = authorService.read(bufferedReader.readLine());
        System.out.println("Input new name:");
        author.setName(bufferedReader.readLine());
        System.out.println("Input new last name:");
        author.setLastName(bufferedReader.readLine());
        authorService.update(author);
    }

    private void deleteAuthor(BufferedReader bufferedReader) throws IOException {
        System.out.println("Input author's id to delete");
        authorService.delete(bufferedReader.readLine());
    }

    private void readAllAuthors() {
        authorService.read().forEach(System.out::println);
    }

    private void readAuthor(BufferedReader bufferedReader) throws IOException {
        System.out.println("Input author's id to read");
        System.out.println(authorService.read(bufferedReader.readLine()));
    }

    private void readBooksByAuthor(BufferedReader bufferedReader) throws IOException {
        System.out.println("Input author's id to read books");
        Author author = authorService.read(bufferedReader.readLine());
        System.out.println(author.getBooks());
    }

    private void printOptions() {
        System.out.println("1 - Create author");
        System.out.println("2 - Update author");
        System.out.println("3 - Delete author");
        System.out.println("4 - Read all authors");
        System.out.println("5 - Read author by Id");
        System.out.println("6 - Read books by author");
        System.out.println("7 - Stop");

    }
}
