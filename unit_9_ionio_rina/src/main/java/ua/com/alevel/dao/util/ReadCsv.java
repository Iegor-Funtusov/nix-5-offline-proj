package ua.com.alevel.dao.util;

import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadCsv {
    public static List<Author> readCSVAuthor() {
        List<Author> authors = new LinkedList<>();
        try(CSVReader reader = new CSVReader(new FileReader("authors.csv"))) {
            List<String[]> csvData = reader.readAll();
            authors = csvData
                    .stream()
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
            System.out.println("File isn't exist " + ex.getMessage());
        } catch (CsvException ex){
            System.out.println("Can't read csv data " + ex.getMessage());
        } catch (IOException ex){
            System.out.println("Can't read " + ex.getMessage());
        }
        return authors;
    }

    private static List<Book> parseBook(String[] stringsOfBook){
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


    public static List<Book> readCSVBook() {
        List<Book> books = new LinkedList<>();
        try(CSVReader reader = new CSVReader(new FileReader("books.csv"))) {
            List<String[]> csvData = reader.readAll();
            books = csvData
                    .stream()
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
            System.out.println("File isn't exist " + ex.getMessage());
        } catch (CsvException ex){
            System.out.println("Can't read csv data " + ex.getMessage());
        } catch (IOException ex){
            System.out.println("Can't read " + ex.getMessage());
        }
        return books;
    }

    private static List<Author> parseAuthor(String[] stringsOfAuthor){
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