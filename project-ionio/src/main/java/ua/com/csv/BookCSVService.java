package ua.com.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.model.Book;
import ua.com.reader.Reader;
import ua.com.writer.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookCSVService {
    private final List<String[]> csvBook = new ArrayList<>();
    private static final String PATH = "books.csv";
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    public BookCSVService() {
        LOGGER_INFO.info("Init BookCSV");
        String[] header = new String[2];
        header[0] = "id";
        header[1] = "title";
        csvBook.add(header);
        Writer.writeCSV(csvBook, PATH);
    }

    public void create(Book book) {
        LOGGER_INFO.info("Start create book");
        book.setId(UUID.randomUUID().toString());
        String[] fieldsBook = new String[2];
        fieldsBook[0] = book.getId();
        fieldsBook[1] = book.getTitle();
        csvBook.add(fieldsBook);
        Writer.writeLineCSV(fieldsBook, PATH);
        LOGGER_INFO.info("End create book");
    }

    public Book read(String id) {
        LOGGER_INFO.info("Read book by id");
        return getBookById(id);
    }

    public void update(Book book) {
        LOGGER_INFO.info("Start update book");
        if (isBook(book.getId())) {
            List<String[]> allRows = Reader.readCSV(PATH);
            String[] current = {book.getId(), book.getTitle()};
            allRows.set(getRowId(book.getId()), current);
            Writer.writeCSV(allRows, PATH);
        } else {
            LOGGER_WARN.warn("Book does not exist");
            System.out.println("Book does not exist");
        }
        LOGGER_INFO.info("End update book");
    }

    public void delete(String id) {
        LOGGER_INFO.info("Start delete book");
        if (isBook(id)) {
            List<String[]> allRows = Reader.readCSV(PATH);
            allRows.remove(getRowId(id));
            Writer.writeCSV(allRows, PATH);
        }
        LOGGER_INFO.info("End delete book");
    }

    public static boolean isBook(String id) {
        boolean flag = false;
        Book book = getBookById(id);
        if (book != null) {
            flag = true;
        }
        return flag;
    }

    public static Book getBookById(String id) {
        Book book = null;
        List<String[]> allRows = Reader.readCSV(PATH);
        for (String[] rows : allRows) {
            if (rows[0].equals(id)) {
                book = new Book(rows[1]);
                book.setId(rows[0]);
            }
        }
        return book;
    }

    private int getRowId(String id) {
        int counter = 0;
        List<String[]> allRows = Reader.readCSV(PATH);
        for (String[] row : allRows) {
            if (row[0].equals(id)) {
                return counter;
            }
            counter++;
        }
        throw new IllegalArgumentException("The current row does not exist");
    }

}
