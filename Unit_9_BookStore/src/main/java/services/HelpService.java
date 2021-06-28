package services;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import obj.Author;
import obj.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

import static services.AuthorService.AUTHORS;
import static services.BookService.BOOKS;

public class HelpService {

    private static final Logger loggerWarnBook = LoggerFactory.getLogger("warnBook");
    private static final Logger loggerErrorBook = LoggerFactory.getLogger("errorBook");

    private static final Logger loggerWarnAuthor = LoggerFactory.getLogger("warnAuthor");
    private static final Logger loggerErrorAuthor = LoggerFactory.getLogger("errorAuthor");

    public static void createBook(Book book) {
        BookService.create(book);
        String Authors = book.getListOfAuthors();
        String[] authors = Authors.split(",");
        try (CSVReader reader = new CSVReader(new FileReader(AUTHORS))) {
            boolean flag = false;
            for (int i = 0; i < authors.length; i++) {
                List<String[]> read = reader.readAll();
                for (int i1 = 0; i1 < read.size(); i1++) {
                    String[] r = read.get(i1);
                    if (r[2].equalsIgnoreCase(authors[i].trim())) {
                        flag = true;
                    }
                }
                if (!flag) {
                    Author author = new Author();
                    String[] fullName = authors[i].trim().split(" ");
                    if (fullName.length != 2) {
                        loggerWarnBook.warn("Incorrect input. The input must contain the first and last name");
                        System.out.println("Incorrect input. The input must contain the first and last name");
                        return;
                    }
                    author.setFirstName(fullName[0]);
                    author.setLastName(fullName[1]);
                    author.setListOfBooks(book.getName());
                    AuthorService.create(author);
                }
                flag = false;
            }
        } catch (IOException | CsvException e) {
            loggerErrorBook.error("Error");
            e.printStackTrace();
        }
    }

    public static void createAuthor(Author author) {
        AuthorService.create(author);
        String string = author.getListOfBooks();
        String[] Books = string.split(",");
        String fullName = author.getFirstName() + " " + author.getLastName();
        try (CSVReader reader = new CSVReader(new FileReader(BOOKS))) {
            boolean flag = false;
            for (int i = 0; i < Books.length; i++) {
                List<String[]> read = reader.readAll();
                for (int i1 = 0; i1 < read.size(); i1++) {
                    String[] r = read.get(i1);
                    if (r[1].equalsIgnoreCase(Books[i].trim()) && r[2].contains(fullName)) {
                        flag = true;
                    }
                }
                if (!flag) {
                    Book book = new Book();
                    book.setName(Books[i].trim());
                    book.setListOfAuthors(fullName);
                    BookService.create(book);
                }
            }
        } catch (IOException | CsvException e) {
            loggerErrorAuthor.error("Error");
            e.printStackTrace();
        }
    }

    public static void readAllBooks() {
        if (!checkBooksFile()) {
            return;
        }
        BookService.readAll();
    }

    public static void readAllBooks(String name) {
        if (!checkBooksFile()) {
            return;
        }
        BookService.readAll(name);
    }

    public static void readAllAuthors() {
        if (!checkAuthorsFile()) {
            return;
        }
        AuthorService.readAll();
    }

    public static void readAllAuthors(String name) {
        if (!checkAuthorsFile()) {
            return;
        }
        AuthorService.readAll(name);
    }

    public static void updateBook(String bookName, String authorName, String newInput, int choice) {
        if (!checkBooksFile() || !checkAuthorsFile()) {
            return;
        }
        BookService.update(bookName, authorName, newInput, choice);
        try (CSVReader reader = new CSVReader(new FileReader(BOOKS))) {
            List<String[]> read = reader.readAll();
            read.stream()
                    .filter(r -> r[1].equalsIgnoreCase(newInput) && r[2].contains(authorName))
                    .filter(r -> choice == 1)
                    .map(r -> r[2].split(","))
                    .forEach(authors -> IntStream.range(0, authors.length)
                            .forEach(i -> AuthorService.update(bookName, authors[i].trim(), newInput, choice)));
        } catch (IOException | CsvException e) {
            loggerErrorBook.error("Error");
            e.printStackTrace();
        }
    }


    public static void updateAuthor(String bookName, String authorName, String newInput, int choice) {
        if (!checkBooksFile() || !checkAuthorsFile()) {
            return;
        }
        try (CSVReader reader = new CSVReader(new FileReader(AUTHORS))) {
            String[] fullName = newInput.split(" ");
            List<String[]> read = reader.readAll();
            for (int i = 0; i < read.size(); i++) {
                String[] r = read.get(i);
                if (choice == 2 && r[1].equalsIgnoreCase(fullName[0]) && r[2].equalsIgnoreCase(fullName[1]) && !r[4].contains("NOTVISIBLE")) {
                    loggerWarnAuthor.warn("Such an author already exists.");
                    System.out.println("Such an author already exists.");
                    return;
                }
            }
            AuthorService.update(bookName, authorName, newInput, choice);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        try (CSVReader reader = new CSVReader(new FileReader(BOOKS))) {
            List<String[]> read = reader.readAll();
            for (int i = 0; i < read.size(); i++) {
                String[] r = read.get(i);
                if (r[2].contains(authorName)) {
                    if (choice == 1) {
                        BookService.update(bookName, authorName, newInput, choice);
                    } else {
                        BookService.update(r[1], authorName, newInput, 2);
                    }
                    break;
                }
            }
        } catch (IOException | CsvException e) {
            loggerErrorAuthor.error("Error");
            e.printStackTrace();
        }
    }

    public static void deleteBook(String bookName, String authorName) {
        if (!checkBooksFile() || !checkAuthorsFile()) {
            return;
        }
        BookService.delete(bookName, authorName, true);
    }

    public static void deleteAuthor(String name) {
        if (!checkBooksFile() || !checkAuthorsFile()) {
            return;
        }
        AuthorService.delete(name);
        name = name.trim();
        try (CSVReader reader = new CSVReader(new FileReader(BOOKS))) {
            List<String[]> read = reader.readAll();
            for (int i = 0; i < read.size(); i++) {
                String[] r = read.get(i);
                if (r[2].equalsIgnoreCase(name)) {
                    BookService.delete(r[1], r[2], true);
                } else if (r[2].contains(name)) {
                    BookService.delete(r[1], r[2], checkAuthorsVisibility(r[2], name));
                }
            }
        } catch (IOException | CsvException e) {
            loggerErrorAuthor.error("Error");
            e.printStackTrace();
        }
    }

    private static boolean checkAuthorsVisibility(String Authors, String name) {
        String[] authors = Authors.split(", ");
        String[] tempName = name.split(" ");
        for (int i = 0; i < authors.length; i++) {
            try (CSVReader reader = new CSVReader(new FileReader(AUTHORS))) {
                List<String[]> read = reader.readAll();
                authors[i].trim();
                String[] fullName = authors[i].split(" ");
                if (read.stream().filter(r -> r[1].equalsIgnoreCase(fullName[0]) && r[2].equalsIgnoreCase(fullName[1]) &&
                        !r[1].equalsIgnoreCase(tempName[0]) && !r[2].equalsIgnoreCase(tempName[1])).anyMatch(r -> r[4].equals("VISIBLE"))) {
                    return false;
                }
            } catch (IOException | CsvException e) {
                loggerErrorAuthor.error("Error");
                e.printStackTrace();
            }
        }
        return true;
    }

    public static boolean checkBooksFile() {
        if (!(new File(BOOKS).exists())) {
            loggerWarnBook.warn("The file does not exist");
            System.out.println("The file does not exist");
            return false;
        }
        return true;
    }

    public static boolean checkAuthorsFile() {
        if (!(new File(AUTHORS).exists())) {
            loggerWarnAuthor.warn("The file does not exist");
            System.out.println("The file does not exist");
            return false;
        }
        return true;
    }
}
