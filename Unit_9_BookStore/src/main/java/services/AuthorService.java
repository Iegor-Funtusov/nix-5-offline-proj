package services;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import obj.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static services.BookService.checkBookFile;
import static services.HelpService.checkAuthorsFile;

public class AuthorService {
    public final static String AUTHORS = "authors.csv";
    private final static String NOTVISIBLE = "NOTVISIBLE";
    private final static String VISIBLE = "VISIBLE";
    private static int indexOnFile;

    private static final Logger loggerInfo = LoggerFactory.getLogger("infoAuthor");
    private static final Logger loggerWarn = LoggerFactory.getLogger("warnAuthor");
    private static final Logger loggerError = LoggerFactory.getLogger("errorAuthor");

    public static void create(Author author) {
        loggerInfo.info("Adding the Author: " + author.getFirstName() + " " + author.getLastName());
        List<String[]> csv = new ArrayList<>();
        String str = author.getListOfBooks();
        String[] Books = str.split(",");

        checkBookFile();
        checkAuthorFile();

        String[] currentAuthor = new String[5];
        currentAuthor[1] = author.getFirstName();
        currentAuthor[2] = author.getLastName();
        String fullName = currentAuthor[1] + " " + currentAuthor[2];
        currentAuthor[4] = VISIBLE;

        try (CSVReader reader = new CSVReader(new FileReader(AUTHORS))) {
            boolean flag1 = false;
            int counter = 0;
            List<String[]> read = reader.readAll();
            String newBooks = findBooks(read, Books, currentAuthor);
            int i = 0;
            while (i < read.size()) {
                String[] r = read.get(i);
                if (r[1].equalsIgnoreCase(currentAuthor[1].trim()) && r[2].equalsIgnoreCase(currentAuthor[2].trim())) {
                    r[3] += newBooks;
                    if (!r[3].isBlank() && r[3].charAt(0) == ',') {
                        r[3] = newBooks.substring(2);
                    }
                    currentAuthor[3] = r[3];
                    currentAuthor[0] = r[0];
                    flag1 = true;
                    break;
                }
                counter++;
                i++;
            }
            if (counter == read.size()) {
                currentAuthor[3] = author.getListOfBooks();
                indexOnFile = read.size();
                currentAuthor[0] = String.format("%d", indexOnFile);
                csv.add(currentAuthor);
                FileWriter fw = new FileWriter(AUTHORS, true);
                CSVWriter writer = new CSVWriter(fw);
                writer.writeAll(csv);
                writer.close();
            } else {
                FileWriter sw = new FileWriter(AUTHORS);
                CSVWriter writer = new CSVWriter(sw);
                writer.writeAll(read);
                writer.close();
            }
            if (flag1) {
                loggerWarn.warn("Author \"" + fullName + "\" already exists");
                System.out.println("Author \"" + fullName + "\" already exists. New books were added");
            }
        } catch (IOException | CsvException e) {
            loggerError.error("Error");
            e.printStackTrace();
        }
        loggerInfo.info("Author was added");
    }

    public static void checkAuthorFile() {
        List<String[]> csv = new ArrayList<>();
        if (new File(AUTHORS).exists()) {
            return;
        }
        loggerWarn.warn("Creating of file");
        String[] parameters = {"ID", "first name", "last name", "list of books", "visibility"};
        csv.add(parameters);
        try (CSVWriter writer = new CSVWriter(new FileWriter(AUTHORS, true))) {
            writer.writeAll(csv);
        } catch (IOException e) {
            loggerError.error("Error");
            e.printStackTrace();
        }
        loggerWarn.warn("File was created");
    }

    private static String findBooks(List<String[]> read, String[] Books, String[] currentAuthor) {
        String newBooks = "";
        for (int i1 = 0; i1 < read.size(); i1++) {
            String[] r = read.get(i1);
            if (r[1].equalsIgnoreCase(currentAuthor[1].trim()) && r[2].equalsIgnoreCase(currentAuthor[2].trim())) {
                for (int i = 0; i < Books.length; i++) {
                    if (!r[3].contains(Books[i])) newBooks += ", " + Books[i];
                    if (i == Books.length - 1) {
                        return newBooks;
                    }
                }
            }
        }
        return newBooks;
    }

    public static void readAll() {
        loggerInfo.info("start reading the entire file");
        try (CSVReader reader = new CSVReader(new FileReader(AUTHORS))) {
            List<String[]> read = reader.readAll();
            read.stream()
                    .filter(r -> !(r[4].contains(NOTVISIBLE)))
                    .map(r -> r[0] + "  " + r[1] + "  " + r[2] + "  " + r[3])
                    .forEach(System.out::println);
        } catch (IOException | CsvException e) {
            loggerError.error("Error");
            e.printStackTrace();
        }
        loggerInfo.info("end of reading the entire file");
    }

    public static void readAll(String name) {
        if (checkAuthorsFile()) {
            String[] fullName = name.split(" ");
            loggerInfo.info("start reading the entire file");
            int count = 0;
            String books = "";
            try (CSVReader reader = new CSVReader(new FileReader(AUTHORS))) {
                List<String[]> read = reader.readAll();
                for (int i = 0; i < read.size(); i++) {
                    String[] r = read.get(i);
                    if (r[1].contains(fullName[0]) && r[2].contains(fullName[1]) && !(r[4].contains(NOTVISIBLE))) {
                        books += r[3];
                    }
                    count++;
                }
                String[] arrBooks = books.split(",");
                if (count == read.size()) {
                    loggerWarn.warn("There is no such author: " + name);
                    System.out.println("There is no such author");
                    return;
                }
                System.out.println("All books by this author: ");
                Arrays.stream(arrBooks)
                        .map(String::trim)
                        .forEach(System.out::println);
            } catch (IOException | CsvException e) {
                loggerError.error("Error");
                e.printStackTrace();
            }
            loggerInfo.info("end of reading the entire file");
        } else {
            return;
        }
    }

    public static void update(String bookName, String authorName, String newInput, int choice) {
        String[] input = authorName.split(" ");
        loggerInfo.info("start updating the data in the file");
        try (CSVReader reader = new CSVReader(new FileReader(AUTHORS))) {
            int counter = 0;
            List<String[]> read = reader.readAll();
            for (int i1 = 0; i1 < read.size(); i1++) {
                String[] r = read.get(i1);
                if (r[1].equalsIgnoreCase(input[0]) && r[2].equalsIgnoreCase(input[1]) && !r[4].contains(NOTVISIBLE)) {
                    if (choice == 1) {
                        if (r[3].contains(bookName)) {
                            String[] books = r[3].split(", ");
                            boolean flag = false;
                            for (int i = 0; i < books.length; i++) {
                                if (books[i].equalsIgnoreCase(newInput)) {
                                    flag = true;
                                    break;
                                }
                            }
                            if (!flag) {
                                r[3] = r[3].replace(bookName, newInput);
                                break;
                            } else {
                                loggerWarn.warn("The author has such a book. Nothing will be updated");
                                System.out.println("The author has such a book. Nothing will be updated");
                                return;
                            }
                        }
                    }
                    if (choice == 2) {
                        input = newInput.split(" ");
                        r[1] = input[0];
                        r[2] = input[1];
                        break;
                    }
                }
                counter++;
            }
            if (counter == read.size()) {
                loggerWarn.warn("There is no such entry");
                System.out.println("This entry does not exist in the author's file");
                return;
            }
            FileWriter sw = new FileWriter(AUTHORS);
            CSVWriter writer = new CSVWriter(sw);
            writer.writeAll(read);
            writer.close();
        } catch (IOException | CsvException e) {
            loggerError.error("Error");
            e.printStackTrace();
        }
        loggerInfo.info("end of file update");
    }

    public static void delete(String name) {
        loggerWarn.warn("Start of deleting");
        try (CSVReader reader = new CSVReader(new FileReader(AUTHORS))) {
            List<String[]> read = reader.readAll();
            String[] fullName = name.split(" ");
            boolean flag = false;
            for (int i = 0; i < read.size(); i++) {
                String[] r = read.get(i);
                if (r[1].contains(fullName[0]) && r[2].contains(fullName[1]) && !(r[4].contains(NOTVISIBLE))) {
                    r[4] = NOTVISIBLE;
                    flag = true;
                }
            }
            FileWriter sw = new FileWriter(AUTHORS);
            CSVWriter writer = new CSVWriter(sw);
            writer.writeAll(read);
            writer.close();
            if (!flag) {
                System.out.println("There is no such entry");
                return;
            }
        } catch (CsvException | IOException e) {
            loggerError.error("Error");
            e.printStackTrace();
        }
        loggerWarn.warn("end of deleting");
    }
}
