package ua.com.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.model.Author;
import ua.com.model.Book;
import ua.com.reader.Reader;
import ua.com.writer.Writer;

import java.util.ArrayList;
import java.util.List;

public class BooksAndAuthorsCSVService {
    private static final List<String[]> csvLinks = new ArrayList<>();
    private static final String PATH = "links.csv";
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    public BooksAndAuthorsCSVService() {
        LOGGER_INFO.info("Init BooksAndAuthorsCSV");
        String[] header = new String[4];
        header[0] = "id_book";
        header[1] = "title";
        header[2] = "id_author";
        header[3] = "last_name";
        csvLinks.add(header);
        Writer.writeCSV(csvLinks, PATH);
    }

    public void create(Book book, Author author) {
        LOGGER_INFO.info("Start create links");
        if (BookCSVService.isBook(book.getId()) && AuthorCSVService.isAuthor(author.getId())) {
            if (isUnique(book.getId(), author.getId())) {
                book.addAuthor(author);
                author.addBook(book);
                String[] fields = new String[4];
                fields[0] = book.getId();
                fields[1] = book.getTitle();
                fields[2] = author.getId();
                fields[3] = author.getLastName();
                csvLinks.add(fields);
                Writer.writeLineCSV(fields, PATH);
            } else {
                LOGGER_WARN.warn("Pair is not unique");
                System.out.println("Pair is not unique");
            }
        } else {
            LOGGER_WARN.warn("Book or Author don't exist");
            System.out.println("Book or Author don't exist");
        }
        LOGGER_INFO.info("End create links");
    }

    public List<Book> readAuthorBooks(String id) {
        LOGGER_INFO.info("Read Author books");
        List<Book> list = new ArrayList<>();
        if (AuthorCSVService.isAuthor(id)) {
            list = getAuthorBooksById(id);
        }
        return list;
    }

    public List<Author> readBookAuthors(String id) {
        LOGGER_INFO.info("Read Book authors");
        List<Author> list = new ArrayList<>();
        if (BookCSVService.isBook(id)) {
            list = getBookAuthorsById(id);
        }
        return list;
    }

    public void delete(String idBook, String idAuthor) {
        LOGGER_INFO.info("Start delete links");
        List<String[]> allRows = Reader.readCSV(PATH);
        allRows.remove(getRowId(idBook, idAuthor));
        Writer.writeCSV(allRows, PATH);
        LOGGER_INFO.info("End delete links");
    }

    private int getRowId(String idBook, String idAuthor) {
        int counter = 0;
        List<String[]> allRows = Reader.readCSV(PATH);
        for (String[] row : allRows) {
            if (row[0].equals(idBook) && row[2].equals(idAuthor)) {
                return counter;
            }
            counter++;
        }
        throw new IllegalArgumentException("The current row does not exist");
    }

    private boolean isUnique(String idBook, String idAuthor) {
        boolean flag = true;
        List<String[]> allRows = Reader.readCSV(PATH);
        for (String[] rows : allRows) {
            if (rows[0].equals(idBook) && rows[2].equals(idAuthor)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private List<Book> getAuthorBooksById(String authorId) {
        List<Book> list = new ArrayList<>();
        Book book;
        List<String[]> allRows = Reader.readCSV(PATH);
        for (String[] rows : allRows) {
            if (rows[2].equals(authorId)) {
                book = BookCSVService.getBookById(rows[0]);
                list.add(book);
            }
        }
        return list;
    }

    private List<Author> getBookAuthorsById(String bookId) {
        List<Author> list = new ArrayList<>();
        Author author;
        List<String[]> allRows = Reader.readCSV(PATH);
        for (String[] rows : allRows) {
            if (rows[0].equals(bookId)) {
                author = AuthorCSVService.getAuthorById(rows[2]);
                list.add(author);
            }
        }
        return list;
    }

}
