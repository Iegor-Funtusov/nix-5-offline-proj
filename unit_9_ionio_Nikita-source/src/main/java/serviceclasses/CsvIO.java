package serviceclasses;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import dataclasses.Author;
import dataclasses.Book;
import dataclasses.EntityWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvIO {
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    public static void CsvAuthorWriter(EntityWrapper<Author>[] authors) {
        List<String[]> csvData = new ArrayList<>();

        for (EntityWrapper<Author> author : authors) {
            String[] authorStr = new String[5];
            authorStr[0] = author.getEntity().getId();
            authorStr[1] = author.getEntity().getFirstName();
            authorStr[2] = author.getEntity().getLastName();
            authorStr[3] = "";
            for (int i = 0; i < author.getEntity().getBooks().length; i++) {
                authorStr[3] += author.getEntity().getBooks()[i].getId() + " ";
            }
            authorStr[3] = authorStr[3].trim();
            if (author.isDeleted()) {
                authorStr[4] = "DELETE";
            } else {
                authorStr[4] = "EXIST";
            }
            csvData.add(authorStr);
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("authors.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            LOGGER_ERROR.error("Author Writer problem");
            e.printStackTrace();
        }
    }

    public static EntityWrapper<Author>[] CsvAuthorReader() {
        EntityWrapper<Author>[] authors = new EntityWrapper[0];
        try (CSVReader reader = new CSVReader(new FileReader("authors.csv"))) {
            try {
                List<String[]> strings = reader.readAll();
                authors = new EntityWrapper[strings.size()];
                int i = 0;
                for (String[] s : strings) {
                    Author a = new Author();
                    a.setId(s[0]);
                    a.setFirstName(s[1]);
                    a.setLastName(s[2]);
                    if (!s[3].isEmpty()) {
                        String IDs[] = s[3].split(" ");
                        for (String id : IDs) {
                            a.setBook(new Book(id));
                        }
                    }
                    if (s[4].equals("DELETE")) {
                        authors[i] = new EntityWrapper<Author>(a, true);
                        i++;
                    } else {
                        authors[i] = new EntityWrapper<Author>(a, false);
                        i++;
                    }
                }
            } catch (CsvException e) {
                LOGGER_ERROR.error("Author Reader problem");
                e.printStackTrace();
            }
        } catch (IOException e) {
            LOGGER_ERROR.error("Author Reader problem");
            e.printStackTrace();
        }

        return authors;
    }

    public static void CsvBookWriter(EntityWrapper<Book>[] books) {
        List<String[]> csvData = new ArrayList<>();

        for (EntityWrapper<Book> book : books) {
            String[] bookStr = new String[4];
            bookStr[0] = book.getEntity().getId();
            bookStr[1] = book.getEntity().getTitle();
            bookStr[2] = "";
            for (int i = 0; i < book.getEntity().getAuthors().length; i++) {
                bookStr[2] += book.getEntity().getAuthors()[i].getId() + " ";
            }
            bookStr[2] = bookStr[2].trim();
            if (book.isDeleted()) {
                bookStr[3] = "DELETE";
            } else {
                bookStr[3] = "EXIST";
            }
            csvData.add(bookStr);
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("books.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            LOGGER_ERROR.error("Book Writer problem");
            e.printStackTrace();
        }
    }

    public static EntityWrapper<Book>[] CsvBookReader() {
        EntityWrapper<Book>[] books = new EntityWrapper[0];
        try (CSVReader reader = new CSVReader(new FileReader("books.csv"))) {
            try {
                List<String[]> strings = reader.readAll();
                books = new EntityWrapper[strings.size()];
                int i = 0;
                for (String[] s : strings) {
                    Book b = new Book();
                    b.setId(s[0]);
                    b.setTitle(s[1]);
                    if (!s[2].isEmpty()) {
                        String IDs[] = s[2].split(" ");
                        for (String id : IDs) {
                            b.setAuthor(new Author(id));
                        }
                    }
                    if (s[3].equals("DELETE")) {
                        books[i] = new EntityWrapper<Book>(b, true);
                        i++;
                    } else {
                        books[i] = new EntityWrapper<Book>(b, false);
                        i++;
                    }
                }
            } catch (CsvException e) {
                LOGGER_ERROR.error("Book Reader problem");
                e.printStackTrace();
            }
        } catch (IOException e) {
            LOGGER_ERROR.error("Book Reader problem");
            e.printStackTrace();
        }

        return books;
    }
}
