package service;

import dao.BookDAO;
import dataclasses.Author;
import dataclasses.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class BookService {

    private static final Logger loggerInfo = LoggerFactory.getLogger("info");
    private static final Logger loggerWarn = LoggerFactory.getLogger("warn");
    private static final Logger loggerError = LoggerFactory.getLogger("error");

    private BookDAO bookDAO = new BookDAO();
    private AuthorService authorService = new AuthorService();


    public void createBook(Author author, Book book) {
        loggerInfo.info("Create book " + "\"" + book.getTitle() + "\"");
        if (!book.getTitle().isEmpty()) {
            boolean exist = bookDAO.findByTitle(author, book.getTitle());
            if (exist) {
                loggerError.error("Book  " + "\"" + book.getTitle() + "\"" + " already exist");
                System.out.println("Book  " + "\"" + book.getTitle() + "\"" + " already exist");
            } else {
                bookDAO.createBook(author, book);
                System.out.println("Книга " + "\"" + book.getTitle() + "\"" + " создана");
                loggerInfo.info("Книга " + "\"" + book.getTitle() + "\"" + " создана");
            }
        } else {
            loggerError.error("Book name can't be empty");
            System.out.println("Book name can't be empty");
        }
    }

    public void deleteBook(Author author, String bookId) {
        loggerWarn.warn("Delete book for bookId: " + bookId);
        bookDAO.deleteBook(author, bookId);
        loggerWarn.warn("Book deleted");
    }

    public void updateBook(Author author, Book book) {
        loggerWarn.warn("Update book " + "\"" + book.getTitle() + "\"");
        bookDAO.updateBook(author, book);
        loggerWarn.warn("Book " + "\"" + book.getTitle() + "\"" + " updated");
    }

    public Collection<Book> findBooks(Collection<Author> list) {
        Collection<Book> books = new ArrayList<Book>();
        Collection<Book> authorBooks = new ArrayList<Book>();
        for (Author author : list) {
            if (author != null) {
                if ((int) Arrays.stream(author.getBooks()).filter(Objects::nonNull).count() != 0) {
                    System.out.println("Show author books " + author.getFirstName() + " "
                        + author.getLastName() + ":");
                    loggerInfo.info("Show author books " + author.getFirstName() + " "
                     + author.getLastName() + ":");
                    authorBooks = bookDAO.findBooks(author);
                    System.out.println(authorBooks);
                    loggerInfo.info(String.valueOf(authorBooks));
                }
                books.addAll(authorBooks);
            }
        }
        return books;
    }

    public Collection<Book> findBooks(Collection<Author> list, String lastName) {
        Author author = authorService.checkAuthor(list, lastName);
        if (author != null) {
                if ((int) Arrays.stream(author.getBooks()).filter(Objects::nonNull).count() != 0) {
                    System.out.println("Show author books " + author.getFirstName() + " "
                        + author.getLastName() + ":");
                    Collection<Book> books = bookDAO.findBooks(author);
                    loggerInfo.info("Show author books " + author.getFirstName() + " "
                        + author.getLastName() + ":");
                    loggerInfo.info(String.valueOf(books));
                    System.out.println(books);
                    return books;
                } else {
                    System.out.println("Author don't have books " + author.getFirstName() + " " +
                        author.getLastName());
                    return null;
                }
        } else {
                System.out.println("Author don't exist" + " " + lastName);
                return null;
        }
    }

    public Book bookCheck(Author bookAuthor, String title) {
        Book bookBook = null;
        for (Book book : bookAuthor.getBooks()) {
            if (book != null) {
                if (book.getTitle().equals(title)) {
                    bookBook = book;
                }
            }
        }
        return bookBook;
    }

    public void errorMessage() {
        loggerError.error("Book don't exist");
        System.out.println("Book don't exist");
    }

    public void errorCreateBookMessage() {
        loggerError.error("Author don't exist");
        System.out.println("Author don't exist");
    }
}
