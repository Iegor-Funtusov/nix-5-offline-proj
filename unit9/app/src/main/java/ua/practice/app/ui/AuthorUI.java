package ua.practice.app.ui;

import ua.practice.app.entity.Author;
import ua.practice.app.entity.Book;
import ua.practice.app.service.service_impl.AuthorServiceImpl;
import ua.practice.app.service.service_impl.BookServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class AuthorUI {
    AuthorServiceImpl authorService = new AuthorServiceImpl();
    BookServiceImpl bookService = new BookServiceImpl();

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
        System.out.println("Add books? y/n");
        String input = bufferedReader.readLine();
        if (input.equals("y")) {
            if (addBooks(bufferedReader, author))
                authorService.create(author);
        } else if (input.equals("n")) {
            authorService.create(author);
        } else throw new RuntimeException("Incorrect input. Try again");
    }

    private boolean addBooks(BufferedReader bufferedReader, Author author) throws IOException {
        System.out.println("Input count of books");
        int count = 0;
        try {
            count = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < count; i++) {
                System.out.println("Input book's id");
                Book book = bookService.read(bufferedReader.readLine());
                author.addBook(book);
            }
        } catch (NumberFormatException e) {
            System.out.println("Incorrect number format");
            return false;
        }
        return true;
    }

    private void updateAuthor(BufferedReader bufferedReader) throws IOException {
        System.out.println("Input author's id to update");
        Author author = authorService.read(bufferedReader.readLine());
        System.out.println("Input new name:");
        author.setName(bufferedReader.readLine());
        System.out.println("Input new last name:");
        author.setLastName(bufferedReader.readLine());
        System.out.println("Add authors? y/n");
        String input = bufferedReader.readLine();
        if (input.equals("y")) {
            if (addBooks(bufferedReader, author))
                authorService.update(author);
        } else if (input.equals("n")) {
            authorService.update(author);
        } else throw new RuntimeException("Incorrect input. Try again");
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
