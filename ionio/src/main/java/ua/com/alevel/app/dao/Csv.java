package ua.com.alevel.app.dao;

import com.opencsv.CSVWriter;
import ua.com.alevel.app.service.author.AuthorService;
import ua.com.alevel.app.service.book.BookService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Csv {

    public Csv(List<BookService> books, List<AuthorService> authors) {
        if (books == null || authors == null) throw new RuntimeException("AuthorAndBook is not exist!");

        List<BookService> listBook;
        listBook = books;
        List<AuthorService> listAuthor;
        listAuthor = authors;

        List<String[]> csvData = new ArrayList<>();
        String[] header = new String[5];
        header[0] = "Author id";
        header[1] = "Author name";
        header[2] = "Author lastname";
        header[3] = "Book id";
        header[4] = "Book title";
        csvData.add(header);

        for (int i = 0, j = 0; i < listBook.size(); i++, j++) {
            String[] argObjects = new String[5];

            argObjects[0] = listAuthor.get(i).getId();
            argObjects[1] = listAuthor.get(i).getName();
            argObjects[2] = listAuthor.get(i).getLastname();
            argObjects[3] = listBook.get(j).getId();
            argObjects[4] = listBook.get(j).getTitle();

            csvData.add(argObjects);
        }

        try(CSVWriter writer = new CSVWriter(new FileWriter("AuthorAndBook.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}