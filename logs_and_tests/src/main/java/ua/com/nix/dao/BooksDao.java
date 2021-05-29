package ua.com.nix.dao;

import org.apache.commons.beanutils.BeanUtils;
import ua.com.nix.model.Author;
import ua.com.nix.model.Book;
import ua.com.nix.model.Library;

import java.util.Arrays;
import java.util.UUID;

public class BooksDao {
    LibraryDao libraryDao = new LibraryDao();

    private int capacity = 0;
    private static int size = 10;

    private static Book[] books = new Book[size];

    public void create(Book book) {
        if (capacity + 1 > books.length) {
            size = (books.length +1);
            books = Arrays.copyOf(books, size);
        }
        book.setId(UUID.randomUUID().toString());
        books[capacity]=book;
        capacity++;
    }

    public void update(Book book) {
        Book currentBook = findById(book.getId());
        try {
            BeanUtils.copyProperties(currentBook, book);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Book[] findAll() {
        return Arrays.stream(books)
                .filter(book -> book != null)
                .toArray(Book[]::new);
    }

    public Book findById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void delete(String id) {
        Book current = findById(id);
        if (current == null) {
            return;
        }
        int countNulls = 0;
        for(int i=0;i<books.length;i++)
        {
            if(books[i].getId().equals(id))
            {
                books[i]=null;
                break;
            }
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                countNulls++;
            }
        }
        Book[] tempBooks = new Book[books.length - countNulls];
        for (int i = 0, j = 0; i < books.length; i++) {
            if (books[i] != null) {
                tempBooks[j] = books[i];
                j++;
            }
        }
        books=tempBooks;
        Library [] libraries = libraryDao.findAll();
        for (int i = 0; i < libraries.length; i++) {
            if(id.equals(libraries[i].getBook().getId()))
            {
                libraries[i].setBook(null);
            }
        }
    }

}

