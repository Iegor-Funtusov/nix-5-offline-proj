package ua.practice.app.ui;

import ua.practice.app.entity.Author;
import ua.practice.app.entity.Book;
import ua.practice.app.service.service_impl.AuthorServiceImpl;
import ua.practice.app.service.service_impl.BookServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class BookUI {
    BookServiceImpl bookService = new BookServiceImpl();
    AuthorServiceImpl authorService = new AuthorServiceImpl();

    public void process(BufferedReader bufferedReader) throws IOException {
        String input;
        printOptions();
        while ((input = bufferedReader.readLine()) != null) {
            switch (input) {
                case "1":
                    createBook(bufferedReader);
                    break;
                case "2":
                    updateBook(bufferedReader);
                    break;
                case "3":
                    deleteBook(bufferedReader);
                    break;
                case "4":
                    readAllBooks();
                    break;
                case "5":
                    readBook(bufferedReader);
                    break;
                case "6":
                    readAuthorsByBook(bufferedReader);
                    break;
                case "7":
                    return;
                default:
                    System.out.println("Incorrect input. Try again");
            }
            printOptions();
        }
    }

    private void createBook(BufferedReader bufferedReader) throws IOException {
        Book book = new Book();
        System.out.println("Input name:");
        book.setName(bufferedReader.readLine());
        System.out.println("Add authors? y/n");
        String input = bufferedReader.readLine();
        if (input.equals("y")) {
            if (addAuthors(bufferedReader, book))
                bookService.create(book);
        } else if (input.equals("n")) {
            bookService.create(book);
        } else throw new RuntimeException("Incorrect input. Try again");
    }
    private boolean addAuthors(BufferedReader bufferedReader, Book book) throws IOException {
        System.out.println("Input count of authors");
        int count = 0;
        try {
            count = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < count; i++) {
                System.out.println("Input author's id");
                Author author = authorService.read(bufferedReader.readLine());
                book.addAuthor(author);
            }
        } catch (NumberFormatException e) {
            System.out.println("Incorrect number format");
            return false;
        }
        return true;
    }

    private void updateBook(BufferedReader bufferedReader) throws IOException {
        System.out.println("Input book's id to update");
        Book book = bookService.read(bufferedReader.readLine());
        System.out.println("Input new name:");
        book.setName(bufferedReader.readLine());
        System.out.println("Add authors? y/n");
        String input = bufferedReader.readLine();
        if (input.equals("y")) {
            if (addAuthors(bufferedReader, book))
                bookService.update(book);
        } else if (input.equals("n")) {
            bookService.update(book);
        } else throw new RuntimeException("Incorrect input. Try again");
    }

    private void deleteBook(BufferedReader bufferedReader) throws IOException {
        System.out.println("Input book's id to delete");
        bookService.delete(bufferedReader.readLine());
    }

    private void readAllBooks() {
        bookService.read().forEach(System.out::println);
    }

    private void readBook(BufferedReader bufferedReader) throws IOException {
        System.out.println("Input book's id to read");
        System.out.println(bookService.read(bufferedReader.readLine()));
    }

    private void readAuthorsByBook(BufferedReader bufferedReader) throws IOException {
        System.out.println("Input book's id to read books");
        Book book = bookService.read(bufferedReader.readLine());
        System.out.println(book.getAuthors());
    }

    private void printOptions() {
        System.out.println("1 - Create book");
        System.out.println("2 - Update book");
        System.out.println("3 - Delete book");
        System.out.println("4 - Read all books");
        System.out.println("5 - Read book by Id");
        System.out.println("6 - Read authors by book");
        System.out.println("7 - Stop");
    }
}
