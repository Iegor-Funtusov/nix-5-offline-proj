package org.example.ionio.dao.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.example.ionio.dao.AuthorDao;
import org.example.ionio.model.Author;
import org.example.ionio.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorDaoImpl implements AuthorDao {
    private static final Logger LOGGER = LoggerFactory.getLogger("AuthorDaoLogger");

    @Override
    public void create(Author author) {
        List<String[]> csvData = new LinkedList<>();
        if(!new File("authors.csv").exists()){
            csvData.add(headerCSV());
        }
        try(CSVWriter writer = new CSVWriter(new FileWriter("authors.csv",true))) {
            csvData.add(authorToStringArray(author));
            writer.writeAll(csvData);
        } catch (IOException ex){
            LOGGER.error("Can't write csv" + ex.getMessage());
        }
    }

    private String[] headerCSV(){
        String[] header = new String[5];
        header[0] = "ID";
        header[1] = "firstName";
        header[2] = "lastName";
        header[3] = "Books";
        header[4] = "Visible";
        return header;
    }

    private String[] authorToStringArray(Author author){
        String[] strings = new String[5];
        strings[0] = author.getId();
        strings[1] = author.getFirstName();
        strings[2] = author.getLastName();
        strings[3] = author.getBookList()
                .stream()
                .map(b -> b.getId()+"/"+b.getName())
                .collect(Collectors.joining(","));
        strings[4] = Boolean.toString(author.isVisible());
        return strings;
    }

    @Override
    public void update(Author author) {
        List<Author> authors = readCSVData();
        new File("authors.csv").delete();
        for(Author a : authors){
            if(a.getId().equals(author.getId())){
                if(author.getFirstName() != null){
                    a.setFirstName(author.getFirstName());
                }
                if(author.getLastName() != null){
                    a.setLastName(author.getLastName());
                }
                if(author.getBookList() != null){
                    a.setBookList(author.getBookList());
                }
            }
            create(a);
        }
    }

    @Override
    public void delete(String id){
        List<Author> authors = readCSVData();
        new File("authors.csv").delete();
        for(Author a : authors){
            if(a.getId().equals(id)){
                a.setVisible(false);
            }
            create(a);
        }
    }

    @Override
    public Author readById(String id) {
        return readAll()
                .stream()
                .filter(b -> b.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Author> readAll(){
        return readCSVData()
                .stream()
                .filter(Author::isVisible)
                .collect(Collectors.toList());
    }

    public List<Author> readCSVData() {
        List<Author> authors = new LinkedList<>();
        try(CSVReader reader = new CSVReader(new FileReader("authors.csv"))) {
            List<String[]> csvData = reader.readAll();
            authors = csvData
                    .stream()
                    .skip(1)
                    .map(s -> {
                        Author author = new Author();
                        author.setId(s[0]);
                        author.setFirstName(s[1]);
                        author.setLastName(s[2]);
                        author.setBookList(parseBook(s[3].split(",")));
                        author.setVisible(Boolean.parseBoolean(s[4]));
                        return author;
                    })
                    .collect(Collectors.toList());
        } catch (FileNotFoundException ex){
            LOGGER.error("File isn't exist " + ex.getMessage());
        } catch (CsvException ex){
            LOGGER.error("Can't read csv data " + ex.getMessage());
        } catch (IOException ex){
            LOGGER.error("Can't read " + ex.getMessage());
        }
        return authors;
    }

    private List<Book> parseBook(String[] stringsOfBook){
        List<Book> bookList = new LinkedList<>();
        for(String b : stringsOfBook){
            String[] bookString = b.split("/");
            Book book = new Book();
            book.setId(bookString[0]);
            book.setName(bookString[1]);
            bookList.add(book);
        }
        return bookList;
    }
}
