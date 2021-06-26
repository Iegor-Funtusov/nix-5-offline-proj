package ua.com.nix.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import ua.com.nix.model.Author;
import ua.com.nix.model.Book;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ua.com.nix.dao.impl.AuthorDaoImpl.authors;
import static ua.com.nix.dao.impl.BookDaoImpl.books;


public class CSV {

    protected void writeAuthors() {
        List<String[]> csvData = new ArrayList<>();
        String[] header = new String[5];
        header[0] = "id";
        header[1] = "firstName";
        header[2] = "lastName";
        header[3] = "bookList";
        header[4] = "invisible";
        csvData.add(header);

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        for (Author author : authors) {
            String[] u = new String[5];
            u[0] = author.getId();
            u[1] = author.getFirstName();
            u[2] = author.getLastName();
            u[3] = gson.toJson(author.getBookList());
            u[4] = String.valueOf(author.isInvisible());
            csvData.add(u);
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter("authors.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private List<Author> SortAuthor(){
        return new ArrayList<>(authors);
    }
    protected List<Author> readAuthors() throws IOException {
        List<Author> authors = SortAuthor();
        try (CSVReader reader = new CSVReader(new FileReader("authors.csv"))) {
            try {
                List<String[]> strings = reader.readAll();
                ObjectMapper objectMapper = new ObjectMapper();
                authors = strings
                        .stream()
                        .skip(1)
                        .map(s -> {
                            Author u = new Author();
                            u.setId(s[0]);
                            u.setFirstName(s[1]);
                            u.setLastName(s[2]);
                            try {
                                u.setBookList(objectMapper.readValue(s[3], new TypeReference<List<Book>>() {
                                }));
                            } catch (JsonProcessingException e) {
                                e.printStackTrace();
                            }
                            u.setInvisible(Boolean.parseBoolean(s[4]));

                            return u;
                        })
                        .filter(s->!s.isInvisible())
                        .collect(Collectors.toList());
            } catch (CsvException e) {
                e.printStackTrace();
            }
        }
        return authors;
    }
    private List<Book> sortBook(){
        return new ArrayList<>(books);
    }
    protected void writeBooks() {
        List<String[]> csvData = new ArrayList<>();
        String[] header = new String[4];
        header[0] = "id";
        header[1] = "title";
        header[2] = "authorForBook";
        header[3] = "invisible";
        csvData.add(header);


        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        for (Book book : books) {

            String[] u = new String[4];
            u[0] = book.getId();
            u[1] = book.getTitle();
            u[2] = gson.toJson(book.getAuthorForBook());
            u[3] = String.valueOf(book.isInvisible());
            csvData.add(u);
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter("books.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected List<Book> readBooks() throws IOException {
        List<Book> books = sortBook();
        try (CSVReader reader = new CSVReader(new FileReader("books.csv"))) {
            try {
                List<String[]> strings = reader.readAll();
                ObjectMapper objectMapper = new ObjectMapper();
                books = strings
                        .stream()
                        .skip(1)
                        .map(s -> {
                            Book u = new Book();
                            u.setId(s[0]);
                            u.setTitle(s[1]);
                            try {
                                u.setAuthorForBook(objectMapper.readValue(s[2], new TypeReference<Author>() { }));
                            } catch (JsonProcessingException e) {
                                e.printStackTrace();
                            }
                            u.setInvisible(Boolean.parseBoolean(s[3]));
                            return u;
                        })
                        .filter(s->!s.isInvisible())
                        .collect(Collectors.toList());
            } catch (CsvException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

}
