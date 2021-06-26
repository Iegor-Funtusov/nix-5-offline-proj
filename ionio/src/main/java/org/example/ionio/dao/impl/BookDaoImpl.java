package org.example.ionio.dao.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.example.ionio.dao.BookDao;
import org.example.ionio.model.Author;
import org.example.ionio.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDaoImpl implements BookDao {
    private static final Logger LOGGER = LoggerFactory.getLogger("BookDaoLogger");

    @Override
    public void create(Book book) {
        List<String[]> csvData = new LinkedList<>();
        if(!new File("books.csv").exists()){
            csvData.add(headerCSV());
        }
        try(CSVWriter writer = new CSVWriter(new FileWriter("books.csv",true))) {
            csvData.add(bookToStringArray(book));
            writer.writeAll(csvData);
        } catch (IOException ex){
            LOGGER.error("Can't write csv" + ex.getMessage());
        }
    }

    private String[] headerCSV(){
        String[] header = new String[4];
        header[0] = "ID";
        header[1] = "Name";
        header[2] = "Authors";
        header[3] = "Visible";
        return header;
    }

    private String[] bookToStringArray(Book book){
        String[] strings = new String[4];
        strings[0] = book.getId();
        strings[1] = book.getName();
        strings[2] = book.getAuthors()
                .stream()
                .map(a -> a.getId()+"/"+a.getFirstName()+"/"+a.getLastName())
                .collect(Collectors.joining(","));
        strings[3] = Boolean.toString(book.isVisible());
        return strings;
    }

    @Override
    public void update(Book book) {
        List<Book> books = readCSVData();
        new File("books.csv").delete();
        for(Book b : books){
            if(b.getId().equals(book.getId())){
                if(book.getName() != null){
                    b.setName(book.getName());
                }
                if(book.getAuthors() != null){
                    b.setAuthors(book.getAuthors());
                }
            }
            create(b);
        }
    }

    @Override
    public void delete(String id){
        List<Book> books = readCSVData();
        new File("books.csv").delete();
        for(Book b : books){
            if(b.getId().equals(id)){
                b.setVisible(false);
            }
            create(b);
        }
    }

    @Override
    public Book readById(String id) {
        return readAll()
                .stream()
                .filter(b -> b.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Book> readAll(){
        return readCSVData()
                .stream()
                .filter(Book::isVisible)
                .collect(Collectors.toList());
    }

    public List<Book> readCSVData() {
        List<Book> books = new LinkedList<>();
        try(CSVReader reader = new CSVReader(new FileReader("books.csv"))) {
            List<String[]> csvData = reader.readAll();
            books = csvData
                    .stream()
                    .skip(1)
                    .map(s -> {
                        Book book = new Book();
                        book.setId(s[0]);
                        book.setName(s[1]);
                        book.setAuthors(parseAuthor(s[2].split(",")));
                        book.setVisible(Boolean.parseBoolean(s[3]));
                        return book;
                    })
                    .collect(Collectors.toList());
        } catch (FileNotFoundException ex){
            LOGGER.error("File isn't exist " + ex.getMessage());
        } catch (CsvException ex){
            LOGGER.error("Can't read csv data " + ex.getMessage());
        } catch (IOException ex){
            LOGGER.error("Can't read " + ex.getMessage());
        }
        return books;
    }

    private List<Author> parseAuthor(String[] stringsOfAuthor){
        List<Author> authorList = new LinkedList<>();
        for(String a : stringsOfAuthor){
            String[] authorString = a.split("/");
            Author author = new Author();
            author.setId(authorString[0]);
            author.setFirstName(authorString[1]);
            author.setLastName(authorString[2]);
            authorList.add(author);
        }
        return authorList;
    }
}
