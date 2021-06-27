package com.nix.hw.ionio.dao;

import com.nix.hw.ionio.entity.Author;
import com.nix.hw.ionio.entity.Book;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorCsvConnector {

    public AuthorCsvConnector() {
        List<String[]> csvData = new ArrayList<>();
        csvData.add(new String[]{"id", "visible", "firstName", "lastName", "books"});
        try (CSVWriter writer = new CSVWriter(new FileWriter("authors.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Author author) {
        String[] csvData = new String[5];
        String stringBooks = "";
        if (author.getBooks()!= null)
            stringBooks = author.getBooks().stream()
                                .map(i -> i.getId() + " " + i.getName())
                                .collect(Collectors.joining(","));
        try (CSVWriter writer = new CSVWriter(new FileWriter("authors.csv", true))) {

            csvData[0] = author.getId();
            csvData[1] = String.valueOf(author.isVisible());
            csvData[2] = author.getFirstName();
            csvData[3] = author.getLastName();
            csvData[4] = stringBooks;

            writer.writeNext(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Author author) {
        List<Author> authors = getData();
        for (int i = 0; i < authors.size(); i++)
            if (authors.get(i).getId().equals(author.getId())){
                authors.get(i).setVisible(author.isVisible());
                authors.get(i).setFirstName(author.getFirstName());
                authors.get(i).setLastName(author.getLastName());
                authors.get(i).setBooks(author.getBooks());
                break;
            }

        try (CSVWriter writer = new CSVWriter(new FileWriter("authors.csv"))) {
            List<String[]> csvData = new ArrayList<>();
            csvData.add(new String[]{"id", "visible", "firstName", "lastName", "books"});
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Author a : authors) {
            add(a);
        }
    }

    public List<Author> getData() {

        List<String[]> list;
        try (CSVReader reader = new CSVReader(new FileReader("authors.csv"))) {
             list = reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return list.stream()
                .skip(1)
                .map(s -> {
                    List<Book> bookList = null;
                    if (s[4].length()>0) {
                        List<String> bookStrings = Arrays.asList(s[4].split(","));
                        bookList = bookStrings.stream()
                                .map(i -> {
                                    String[] bookFields = i.split(" ");
                                    Book book = new Book();
                                    book.setId(bookFields[0]);
                                    book.setName(bookFields[1]);
                                    return book;
                                })
                                .collect(Collectors.toList());
                    }
                    Author a = new Author();
                    a.setId(s[0]);
                    a.setVisible(Boolean.parseBoolean(s[1]));
                    a.setFirstName(s[2]);
                    a.setLastName(s[3]);
                    a.setBooks(bookList);

                    return a;
                })
                .collect(Collectors.toList());
    }
}
