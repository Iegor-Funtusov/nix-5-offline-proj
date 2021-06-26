package ua.davidenko;

import com.opencsv.exceptions.CsvException;
import ua.davidenko.author.Author;
import ua.davidenko.book.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class CvsWriter {
    List<Book> books;
    List<Author> authors;

    public CvsWriter(List<Book> books, List<Author> authors) {
        if (books == null) {
            throw new RuntimeException(" No any books");
        }
        if (authors == null) {
            throw new RuntimeException("No any authors");
        }

        List<String[]> csvData = new ArrayList<>();
        String[] header = {"Book id", "Book title", "Author id", "Author name", "Author SureName"};
        csvData.add(header);

        for (int i = 0, j = 0; i < books.size(); i++, j++) {
            String[] authorsAndBooks = new String[5];
            authorsAndBooks[0] = books.get(i).getBookId();
            authorsAndBooks[1] = books.get(i).getTitle();
            authorsAndBooks[2] = authors.get(j).getAuthorId();
            authorsAndBooks[3] = authors.get(j).getAuthorName();
            authorsAndBooks[4] = authors.get(j).getAuthorSurName();
            csvData.add(authorsAndBooks);
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("unit_9_ionio/BooksAndAuthors.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
