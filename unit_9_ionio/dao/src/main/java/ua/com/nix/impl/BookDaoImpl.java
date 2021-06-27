package ua.com.nix.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import ua.com.nix.Book;
import ua.com.nix.BookDao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    public void create(Book base) {
        List<String[]> booksData = readFromBookCsv();

        try (CSVWriter writer = new CSVWriter(new FileWriter("datafiles/src/main/java/ua/com/nix/books.csv"))) {
            if (booksData.size() < 1) {
                base.setId(1);
                String[] header = {"ID\t", "Title\t", "Authors\t", "Visible\t"};
                writer.writeNext(header);
            } else if (booksData.size() == 1) base.setId(1);
            else base.setId(Integer.parseInt(booksData.get(booksData.size() - 1)[0] + 1));
            String[] body = new String[4];

            body[0] = String.valueOf(base.getId());
            body[1] = base.getTitle();
            StringBuilder builder = new StringBuilder();
            for (Integer integer : base.getIdAuthorsList()) {
                builder.append(integer);
                builder.append(";");
            }
            body[2] = builder.toString();
            body[3] = String.valueOf(base.isVisible());

            writer.writeNext(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Book base) {

        List<String[]> booksData = readFromBookCsv();

        for (int i = 1; i < booksData.size(); i++) {
            if (Integer.parseInt(booksData.get(i)[0]) == (base.getId())) {
                String[] book = new String[4];
                book[0] = String.valueOf(base.getId());
                book[1] = base.getTitle();
                StringBuilder builder = new StringBuilder();
                for (Integer integer : base.getIdAuthorsList()) {
                    builder.append(integer);
                    builder.append(";");
                }
                book[2] = builder.toString();
                book[3] = String.valueOf(base.isVisible());
                booksData.set(i, book);
            }
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("datafiles/src/main/java/ua/com/nix/books.csv"))) {
            writer.writeAll(booksData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Book read(int id) {

        List<String[]> booksData = readFromBookCsv();

        if (booksData.size() >= 2) {
            for (int i = 1; i < booksData.size(); i++) {
                if (booksData.get(i)[3].equals("true") && Integer.parseInt(booksData.get(i)[0]) == id) {
                    Book book = new Book();
                    book.setId(Integer.parseInt(booksData.get(i)[0]));
                    book.setTitle(booksData.get(i)[1]);
                    String[] inputID = booksData.get(i)[2].split(";");
                    List<Integer> authorsID = new ArrayList<>();
                    for (String s : inputID) {
                        authorsID.add(Integer.parseInt(s));
                    }
                    book.setIdAuthorsList(authorsID);
                    book.setVisible(true);
                    return book;
                }
            }
        }
        return null;
    }

    public void delete(int id) {
        List<String[]> booksData = readFromBookCsv();

        if (booksData.size() >= 2) {
            for (String[] booksDatum : booksData) {
                if(Integer.parseInt(booksDatum[0]) == id){
                    booksDatum[3] = "false";
                }
            }
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("datafiles/src/main/java/ua/com/nix/books.csv"))){
            writer.writeAll(booksData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> findALl() {
        List<Book> bookList = new ArrayList<>();
        List<String[]> booksData = readFromBookCsv();

        for (int i = 1; i < booksData.size(); i++) {
            Book book = new Book();
            book.setId(Integer.parseInt(booksData.get(i)[0]));
            book.setTitle(booksData.get(i)[1]);

            String[] inputID = booksData.get(i)[2].split(";");
            List<Integer> authorsID = new ArrayList<>();
            for (String s : inputID) {
                authorsID.add(Integer.parseInt(s));
            }
            book.setIdAuthorsList(authorsID);
            book.setVisible(Boolean.getBoolean(booksData.get(i)[3]));
            bookList.add(book);
        }
        return bookList;
    }

    public List<Book> findByAuthor(int idAuthor) {
        List<Book> bookList = findALl();
        List<Book> resultList = new ArrayList<>();
        for (Book book : bookList) {
            if(book.getIdAuthorsList().stream().anyMatch(integer -> integer == idAuthor)){
                resultList.add(book);
            }
        }
        return resultList;
    }

    public Book findBookByTitle(String title) {
        List<Book> bookList = findALl();
        Book book = new Book();
        for (Book bookLoop : bookList) {
            if(bookLoop.getTitle().equals(title)){
                book = bookLoop;
            }
        }
        return book;
    }

    public boolean isBookByTitleExist(String title) {
        List<Book> bookList = findALl();
        for (Book book : bookList) {
            if(book.getTitle().equals(title)) return true;
        }
        return false;
    }

    private List<String[]> readFromBookCsv() {
        List<String[]> booksData = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader("datafiles/src/main/java/ua/com/nix/books.csv"))) {
            booksData = reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return booksData;
    }

}
