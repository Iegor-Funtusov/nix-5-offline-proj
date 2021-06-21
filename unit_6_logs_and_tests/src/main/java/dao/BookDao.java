package dao;

import entity.Author;
import entity.Book;

import java.util.ArrayList;
import java.util.Arrays;

public class BookDao {

    Book[] books = new Book[10];
    private int curId = 0;
    private int lastIndex = 0;

    public void changeLength() {

        if (books.length <= lastIndex) {

            Book[] bufferAr = new Book[books.length + 1];
            bufferAr = Arrays.copyOf(books, books.length + 1);
            books = bufferAr;
        }
    }

    public void create(String name, Author author) {

        changeLength();

        Book book = new Book();
        book.setId(++curId);
        book.setName(name);
        book.setAuthor(author);

        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;

                if (lastIndex == i) {
                    lastIndex = lastIndex + 1;
                }
                break;
            }
        }
    }

    public Book read(int id) {
        Book book = null;
        for (int i = 0; i < books.length; i++) {

            if (books[i] == null) {
                continue;
            }
            if (books[i].getId() == id) {
                book = books[i];
                System.out.println("entity.Book: id - " + id + ", name - " + books[i].getName());
                return book;
            }
        }
        return book;
    }

    public ArrayList<Book> readAll() {
        String s = "Books: ";
        StringBuilder builder = new StringBuilder();
        ArrayList<Book> booksAr = new ArrayList<>();
        for (int i = 0; i < books.length; i++) {

            if (books[i] == null) {
                continue;
            }
            builder.append(s);
            builder.append(" id - ");
            builder.append(books[i].getId());
            builder.append(" name - ");
            builder.append(books[i].getName());
            s = ", ";
            booksAr.add(books[i] );
        }
        System.out.println(builder.toString());
        return booksAr;
    }

    public Book[] readAll(Author author) {

        Book[] booksDel = new Book[0];
        for (int i = 0; i < books.length; i++) {

            if (books[i] == null) {
                continue;
            }
            if (!books[i].getAuthor().equals(author)) {
                continue;
            }

            Book[] bufferAr = new Book[booksDel.length + 1];
            bufferAr = Arrays.copyOf(booksDel, booksDel.length + 1);
            booksDel = bufferAr;
            booksDel[booksDel.length - 1] = books[i];
        }

        return booksDel;
    }

    public void update(int id, String newName, Author author) {
        for (int i = 0; i < books.length; i++) {

            if (books[i] == null) {
                continue;
            }
            if (books[i].getId() == id) {
                books[i].setName(newName);
                books[i].setAuthor(author);
                System.out.println("book updated");

                break;
            }
        }
    }

    public void delete(int id) {
        for (int i = 0; i < books.length; i++) {

            if (books[i] == null) {
                continue;
            }
            if (books[i].getId() == id) {

                books[i] = null;
                System.out.println("entity.Author deleted");
                break;
            }
        }
    }

    public ArrayList<Book> findByName(String name) {
        ArrayList<Book> booksAr = new ArrayList<>();
        for (int i = 0; i < books.length; i++) {

            if (books[i] == null) {
                continue;
            }
            if (books[i].getName().equals(name)) {
                booksAr.add(books[i]);
            }
        }

        return booksAr;
    }
}
