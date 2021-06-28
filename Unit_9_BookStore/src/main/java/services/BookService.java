package services;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import obj.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static services.AuthorService.checkAuthorFile;

public class BookService {

    public final static String BOOKS = "books.csv";
    private final static String NOTVISIBLE = "NOTVISIBLE";
    private final static String VISIBLE = "VISIBLE";
    private static int indexOnFile;

    private static final Logger loggerInfo = LoggerFactory.getLogger("infoBook");
    private static final Logger loggerWarn = LoggerFactory.getLogger("warnBook");
    private static final Logger loggerError = LoggerFactory.getLogger("errorBook");

    public static void create(Book book) {
        loggerInfo.info("Creating the book: " + book.getName());
        String[] currentBook = new String[4];
        currentBook[1] = book.getName().trim();
        currentBook[2] = book.getListOfAuthors();
        currentBook[3] = VISIBLE;

        if (currentBook[1].isBlank() || currentBook[2].isBlank()) {
            return;
        }

        checkBookFile();
        checkAuthorFile();

        List<String[]> csv = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(BOOKS))) {
            List<String[]> read = reader.readAll();
            for (int i = 0; i < read.size(); i++) {
                String[] r = read.get(i);
                if (r[1].equalsIgnoreCase(currentBook[1].trim()) && r[2].equalsIgnoreCase(currentBook[2].trim()) && !r[3].contains(NOTVISIBLE)) {
                    loggerWarn.warn("Book \"" + r[1] + "\" already exists");
                    System.out.println("Book \"" + r[1] + "\" already exists");
                    return;
                }
            }
            indexOnFile = read.size();
        } catch (IOException | CsvException e) {
            loggerError.error("Error");
            e.printStackTrace();
        }
        currentBook[0] = String.format("%d", indexOnFile);
        csv.add(currentBook);
        try (CSVWriter writer = new CSVWriter(new FileWriter(BOOKS, true))) {
            writer.writeAll(csv);
        } catch (IOException e) {
            loggerError.error("Error");
            e.printStackTrace();
        }
        loggerInfo.info("Book was created");
    }

    public static void checkBookFile() {
        List<String[]> csv = new ArrayList<>();
        if (new File(BOOKS).exists()) {
            return;
        }
        loggerWarn.warn("Creating of file");
        String[] parameters = {"ID", "name", "list of authors", "visibility"};
        csv.add(parameters);
        try (CSVWriter writer = new CSVWriter(new FileWriter(BOOKS, true))) {
            writer.writeAll(csv);
        } catch (IOException e) {
            loggerError.error("Error");
            e.printStackTrace();
        }
        loggerWarn.warn("File was created");
    }

    public static void readAll() {
        loggerInfo.info("start reading the entire file");
        try (CSVReader reader = new CSVReader(new FileReader(BOOKS))) {
            List<String[]> read = reader.readAll();
            for (String[] r : read) {
                if (!r[3].contains(NOTVISIBLE))
                    System.out.println(r[0] + "   " + r[1] + "   " + r[2]);
            }
        } catch (IOException | CsvException e) {
            loggerError.error("Error");
            e.printStackTrace();
        }
        loggerInfo.info("end of reading the entire file ");
    }

    public static void readAll(String name) {
        loggerInfo.info("start reading the entire file");
        int counter = 0;
        try (CSVReader reader = new CSVReader(new FileReader(BOOKS))) {
            List<String[]> read = reader.readAll();
            for (int i = 0; i < read.size(); i++) {
                String[] r = read.get(i);
                if (r[1].equalsIgnoreCase(name) && !r[3].contains(NOTVISIBLE)) {
                    System.out.println("Authors: " + r[2]);
                    break;
                }
                counter++;
            }
            if (counter == read.size()) {
                loggerWarn.warn("There is no such book: " + name);
                System.out.println("There is no such book");
            }
        } catch (IOException | CsvException e) {
            loggerError.error("Error");
            e.printStackTrace();
        }
    }

    public static void update(String bookName, String authorName, String newInput, int choice) {
        loggerInfo.info("start updating the data in the file");
        int counter = 0;
        try (CSVReader reader = new CSVReader(new FileReader(BOOKS))) {
            List<String[]> read = reader.readAll();
            for (int i = 0; i < read.size(); i++) {
                String[] r = read.get(i);
                if (choice == 1 && r[1].equalsIgnoreCase(newInput) && r[2].contains(authorName) && !r[3].contains(NOTVISIBLE)) {
                    loggerWarn.warn("Such book already exists");
                    System.out.println("Such book already exists");
                    return;
                }
                if (r[1].equalsIgnoreCase(bookName) && r[2].contains(authorName) && !r[3].contains(NOTVISIBLE)) {
                    if (choice == 1) {
                        r[1] = newInput;
                        break;
                    }
                    if (choice == 2) {
                        r[2] = newInput;
                        break;
                    }
                }
                counter++;
            }
            if (counter == read.size()) {
                loggerWarn.warn("There is no such entry");
                System.out.println("This entry does not exist in the book file");
                return;
            }
            FileWriter fw = new FileWriter(BOOKS);
            CSVWriter writer = new CSVWriter(fw);
            writer.writeAll(read);
            writer.close();
        } catch (IOException | CsvException e) {
            loggerError.error("Error");
            e.printStackTrace();
        }
        loggerInfo.info("end of file update");
    }

    public static void delete(String bookName, String authorName, boolean check) {
        loggerWarn.warn("Start of deleting");
        int counter = 0;
        boolean flag = false;
        try (CSVReader reader = new CSVReader(new FileReader(BOOKS));) {
            List<String[]> allElements = reader.readAll();
            for (int i = 0; i < allElements.size(); i++) {
                String[] r = allElements.get(i);
                if (r[1].equalsIgnoreCase(bookName) && r[2].contains(authorName) && !(r[3].contains(NOTVISIBLE)) && check) {
                    r[3] = NOTVISIBLE;
                    flag = true;
                    break;
                }
                if (r[1].equalsIgnoreCase(bookName) && r[2].contains(authorName) && !(r[3].contains(NOTVISIBLE)) && !check) {
                    flag = true;
                }
                counter++;
            }
            if (counter == allElements.size() && !flag) {
                loggerWarn.warn("This entry does not exist in the file");
                System.out.println("This entry does not exist in the file");
                return;
            }
            FileWriter sw = new FileWriter(BOOKS);
            CSVWriter writer = new CSVWriter(sw);
            writer.writeAll(allElements);
            writer.close();
        } catch (CsvException | IOException e) {
            loggerError.error("Error");
            e.printStackTrace();
        }
        loggerWarn.warn("end of deleting");
    }
}
