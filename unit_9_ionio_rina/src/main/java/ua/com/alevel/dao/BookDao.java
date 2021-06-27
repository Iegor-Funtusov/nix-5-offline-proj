package ua.com.alevel.dao;

import ua.com.alevel.dao.util.ReadCsv;
import ua.com.alevel.entity.Book;

import com.opencsv.CSVWriter;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDao {
    public void create(Book book) {
        List<String[]> csvData = new LinkedList<>();
        try(CSVWriter writer = new CSVWriter(new FileWriter("books.csv",true))) {
            csvData.add(bookToStringArray(book));
            writer.writeAll(csvData);
        } catch (IOException ex){
            System.out.println("Can't write csv" + ex.getMessage());
        }
    }


    public void update(Book book) {
        List<Book> books = ReadCsv.readCSVBook();
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


    public void delete(String id){
        List<Book> books = ReadCsv.readCSVBook();
        new File("books.csv").delete();
        for(Book b : books){
            if(b.getId().equals(id)){
                b.setVisible(false);
            }
            create(b);
        }
    }

    public Book readById(String id) {
        return readAll()
                .stream()
                .filter(b -> b.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public List<Book> readAll(){
        return ReadCsv.readCSVBook()
                .stream()
                .filter(Book::isVisible)
                .collect(Collectors.toList());
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
}