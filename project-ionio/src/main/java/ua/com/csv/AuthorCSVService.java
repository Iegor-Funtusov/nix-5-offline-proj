package ua.com.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.model.Author;
import ua.com.reader.Reader;
import ua.com.writer.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuthorCSVService {
    private static final List<String[]> csvAuthor = new ArrayList<>();
    private static final String PATH = "authors.csv";
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    public AuthorCSVService() {
        LOGGER_INFO.info("Init AuthorCSV");
        String[] header = new String[3];
        header[0] = "id";
        header[1] = "first_name";
        header[2] = "last_name";
        csvAuthor.add(header);
        Writer.writeCSV(csvAuthor, PATH);
    }

    public void create(Author author) {
        LOGGER_INFO.info("Start create author");
        author.setId(UUID.randomUUID().toString());
        String[] fieldsAuthor = new String[3];
        fieldsAuthor[0] = author.getId();
        fieldsAuthor[1] = author.getFirstName();
        fieldsAuthor[2] = author.getLastName();
        csvAuthor.add(fieldsAuthor);
        Writer.writeCSV(csvAuthor, PATH);
        LOGGER_INFO.info("End create author");
    }

    public Author read(String id) {
        LOGGER_INFO.info("Read author by id");
        return getAuthorById(id);
    }

    public void update(Author author) {
        LOGGER_INFO.info("Start update author");
        if (isAuthor(author.getId())) {
            List<String[]> allRows = Reader.readCSV(PATH);
            String[] current = {author.getId(), author.getFirstName(), author.getLastName()};
            allRows.set(getRowId(author.getId()), current);
            Writer.writeCSV(allRows, PATH);
        } else {
            LOGGER_WARN.warn("Author does not exist");
            System.out.println("Author does not exist");
        }
        LOGGER_INFO.info("End update author");
    }

    public void delete(String id) {
        LOGGER_INFO.info("Start delete author by id");
        if (isAuthor(id)) {
            List<String[]> allRows = Reader.readCSV(PATH);
            allRows.remove(getRowId(id));
            Writer.writeCSV(allRows, PATH);
        }
        LOGGER_INFO.info("End delete author by id");
    }

    public static boolean isAuthor(String id) {
        boolean flag = false;
        Author author = getAuthorById(id);
        if (author != null) {
            flag = true;
        }
        return flag;
    }

    public static Author getAuthorById(String id) {
        Author author = null;
        List<String[]> allRows = Reader.readCSV(PATH);
        for (String[] rows : allRows) {
            if (rows[0].equals(id)) {
                author = new Author(rows[1], rows[2]);
                author.setId(rows[0]);
            }
        }
        return author;
    }

    private int getRowId(String id) {
        List<String[]> allRows = Reader.readCSV(PATH);
        int counter = 0;
        for (String[] row : allRows) {
            if (row[0].equals(id)) {
                return counter;
            }
            counter++;
        }
        throw new IllegalArgumentException("The current row does not exist");
    }

}

