package com.nix.hw.ionio.dao;

import com.nix.hw.ionio.entity.Author;
import com.nix.hw.ionio.entity.Book;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookCsvConnector {
    public BookCsvConnector() {
        List<String[]> csvData = new ArrayList<>();
        csvData.add(new String[]{"id", "visible", "name", "authors"});
        try (CSVWriter writer = new CSVWriter(new FileWriter("books.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Book book) {
        String[] csvData = new String[4];
        String stringAuthors = "";
        if (book.getAuthors()!= null)
            stringAuthors = book.getAuthors().stream()
                    .map(i -> i.getId() + " " + i.getFirstName() + " " + i.getLastName())
                    .collect(Collectors.joining(","));
        try (CSVWriter writer = new CSVWriter(new FileWriter("books.csv", true))) {

            csvData[0] = book.getId();
            csvData[1] = String.valueOf(book.isVisible());
            csvData[2] = book.getName();
            csvData[3] = stringAuthors;

            writer.writeNext(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Book book) {
        List<Book> books = getData();
        for (int i = 0; i < books.size(); i++)
            if (books.get(i).getId().equals(book.getId())){
                books.get(i).setVisible(book.isVisible());
                books.get(i).setName(book.getName());
                books.get(i).setAuthors(book.getAuthors());
                break;
            }

        try (CSVWriter writer = new CSVWriter(new FileWriter("books.csv"))) {
            List<String[]> csvData = new ArrayList<>();
            csvData.add(new String[]{"id", "visible", "name", "authors"});
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Book b : books) {
            add(b);
        }
    }

    public List<Book> getData() {

        List<String[]> list;
        try (CSVReader reader = new CSVReader(new FileReader("books.csv"))) {
            list = reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return list.stream()
                .skip(1)
                .map(s -> {
                    List<Author> authorList = null;
                    if (s[3].length()>0) {
                        List<String> authorString = Arrays.asList(s[3].split(","));
                        authorList = authorString.stream()
                                .map(i -> {
                                    String[] authorFields = i.split(" ");
                                    Author author = new Author();
                                    author.setId(authorFields[0]);
                                    author.setFirstName(authorFields[1]);
                                    author.setLastName(authorFields[2]);
                                    return author;
                                })
                                .collect(Collectors.toList());
                    }
                    Book b = new Book();
                    b.setId(s[0]);
                    b.setVisible(Boolean.parseBoolean(s[1]));
                    b.setName(s[2]);
                    b.setAuthors(authorList);

                    return b;
                })
                .collect(Collectors.toList());
    }
}
