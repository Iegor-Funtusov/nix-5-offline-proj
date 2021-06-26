package com.nix.csv;

import com.nix.pojo_objects.Author;
import com.nix.pojo_objects.Book;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVwriter {

    public CSVwriter(List<Book> books, List<Author> authors) {
        if (books == null && authors == null) throw new RuntimeException("Books || Authors is null");

        List<Book> writeBooks;
        writeBooks = books;

        List<Author> writeAuthors;
        writeAuthors = authors;

        List<String[]> csvData = new ArrayList<>();
        String[] header = new String[5];
        header[0] = "Book id";
        header[1] = "Book title";
        header[2] = "Author id";
        header[3] = "Author first name";
        header[4] = "Author last name";
        csvData.add(header);

        int size = books.size();
        if (size < authors.size()) {
            size = authors.size();
        }

        for (int i = 0, j = 0; i < size; i++, j++) {
            String[] argObjects = new String[5];
            try {
                if (books.size() != 0) {
                    argObjects[0] = writeBooks.get(i).getId();
                    argObjects[1] = writeBooks.get(i).getTitle();
                }

                argObjects[2] = writeAuthors.get(j).getId();
                argObjects[3] = writeAuthors.get(j).getFirstName();
                argObjects[4] = writeAuthors.get(j).getLastName();
            } catch (IndexOutOfBoundsException e) {

            }
            csvData.add(argObjects);
        }

        try(CSVWriter writer = new CSVWriter(new FileWriter("BookAuthor.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
