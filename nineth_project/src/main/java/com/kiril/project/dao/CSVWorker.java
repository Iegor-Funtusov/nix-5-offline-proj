package com.kiril.project.dao;

import com.kiril.project.entities.Author;
import com.kiril.project.entities.Book;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVWorker {
    private final String[] authorHeader = {"id", "first_name", "last_name", "books"};
    private final String[] bookHeader = {"id", "name", "author"};


    public CSVWorker() throws IOException {

    }


    public void writeAuthors(List<Author> authorList) {
        try {
            FileWriter authorWriter = new FileWriter("authors.csv");
            CSVPrinter authorPrinter = new CSVPrinter(authorWriter, CSVFormat.DEFAULT.withHeader(authorHeader));
            for (Author author : authorList) {
                if (author.isVisible()) {
                    authorPrinter.printRecord(author.getId(), author.getLastName(), author.getFirstName(), convertAuthorsBooksToSting(author.getAuthorsBooks()));
                }
                authorPrinter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Author readAuthor(String id) {
        try {
            FileReader authorReader = new FileReader("authors.csv");
            CSVParser authorParser = new CSVParser(authorReader, CSVFormat.DEFAULT.withHeader(authorHeader));
            for (CSVRecord author : authorParser.getRecords()) {
                if (author.get(0).equals(id)) {
                    return getAuthor(id, author);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("No such author was found");
    }


    public List<Author> readAllAuthors() {
        List<Author> authors = new ArrayList<>();
        try {
            FileReader authorReader = new FileReader("authors.csv");
            CSVParser authorParser = new CSVParser(authorReader, CSVFormat.DEFAULT.withHeader(authorHeader));
            for (CSVRecord author : authorParser.getRecords()) {
                authors.add(getAuthor(author.get(0), author));
            }
        } catch (IOException e) {
        }
        authors.remove(0);
        return authors;
    }


    public void writeBooks(List<Book> bookList) {
        try {
            FileWriter bookWriter = new FileWriter("books.csv");
            CSVPrinter authorPrinter = new CSVPrinter(bookWriter, CSVFormat.DEFAULT.withHeader(bookHeader));
            for (Book book : bookList) {
                if (book.isVisible()) {
                    authorPrinter.printRecord(book.getId(), book.getName(), book.getAuthor());
                }
                authorPrinter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Book readBook(String id) {
        try {
            FileReader bookReader = new FileReader("books.csv");
            CSVParser bookParser = new CSVParser(bookReader, CSVFormat.DEFAULT.withHeader(bookHeader));
            for (CSVRecord book : bookParser.getRecords()) {
                if (book.get(0).equals(id)) {
                    return getBook(id, book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("No such author was found");
    }


    public List<Book> readAllBooks() {
        List<Book> bookList = new ArrayList<>();
        try {
            FileReader bookReader = new FileReader("books.csv");
            CSVParser bookParser = new CSVParser(bookReader, CSVFormat.DEFAULT.withHeader(bookHeader));
            for (CSVRecord book : bookParser.getRecords()) {
                bookList.add(getBook(book.get(0), book));
            }
        } catch (IOException e) {
        }
        bookList.remove(0);
        return bookList;
    }

    private String convertAuthorsBooksToSting(List<String> str) {
        String result = "";
        for (String s :
                str) {
            result += s + ":";
        }
        return result;
    }

    private Author getAuthor(String id, CSVRecord author) {
        String index, firstName, lastName;
        List<String> listOfAuthorsBooks = new ArrayList<>();
        index = id;
        lastName = author.get(2);
        firstName = author.get(1);
        listOfAuthorsBooks.addAll(Arrays.asList(author.get(3).split(":")));
        Author readingAuthor = new Author(firstName, lastName, listOfAuthorsBooks, true);
        readingAuthor.setId(index);
        return readingAuthor;
    }

    private Book getBook(String id, CSVRecord book) {
        String author, name, index;
        index = id;
        author = book.get(2);
        name = book.get(1);
        Book readingBook = new Book(name, author, true);
        readingBook.setId(index);
        return readingBook;
    }
}
