package ua.com.nix.dao.impl;

import org.apache.commons.beanutils.BeanUtils;
import ua.com.nix.dao.BookDao;
import ua.com.nix.model.Author;
import ua.com.nix.model.Book;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static ua.com.nix.dao.impl.AuthorDaoImpl.authors;


public class BookDaoImpl implements BookDao {
    private static final CSV csv = new CSV();
    static final List<Book> books = new ArrayList<>();

    @Override
    public void create(Book book,Author author) {
        if (!author.isInvisible()) {
            book.setId(UUID.randomUUID().toString());
            book.setAuthorForBook(author);
            List<Book> newBooks = author.getBookList();
            books.add(book);
            newBooks.add(book);
            author.setBookList(newBooks);
            for (Author author1 : authors) {
                if (author1.getId().equals(author.getId())) {
                    try {
                        BeanUtils.copyProperties(author1, author);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            csv.writeBooks();
            csv.writeAuthors();

        } else {
            System.out.println("This author is invisible...");
        }
    }

    @Override
    public void update(Book book) {
        Book currentBook = read(book.getId());
        try {
            BeanUtils.copyProperties(currentBook, book);

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        for (Book book1 : books) {
            if(book1.getId().equals(currentBook.getId()))
            {
                try {
                    BeanUtils.copyProperties(book1,currentBook);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        csv.writeAuthors();
        csv.writeBooks();
    }

    @Override
    public void delete(String id) {
        for (Book book : books) {
            if(book.getId().equals(id))
            {
                book.setInvisible(true);
            }
        }
        csv.writeAuthors();
        csv.writeBooks();
    }

    @Override
    public Book read(String id) {
        List<Book> books = readAll();
        for (Book book : books) {
            if(book.getId().equals(id))
                return book;
        }
        return null;
    }

    @Override
    public List<Book> readAll() {
        List<Book> tempBooks = new ArrayList<>();
        try {
            tempBooks = csv.readBooks();

        } catch (IOException e) {
            System.out.println("Anyone book already");
        }
        return tempBooks;
    }

    @Override
    public Author readAllAuthorsByBook(Book book) {
        return read(book.getId()).getAuthorForBook();
    }

}
