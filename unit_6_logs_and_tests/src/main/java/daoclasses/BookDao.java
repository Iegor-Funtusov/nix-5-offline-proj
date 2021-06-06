package daoclasses;

import dataclasses.Book;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class BookDao {
    Book[] books = new Book[5];

    public void create(Book book) {
        book.setId(generateId(RandomStringUtils.randomAlphanumeric(6)));
        if (books[books.length - 1] == null) {
            books[getCount()] = book;
        } else {
            Book[] newArray = new Book[books.length + books.length / 2];
            for (int i = 0; i < books.length; i++) {
                newArray[i] = books[i];
            }
            newArray[books.length] = book;
            books = newArray;
        }
    }

    public void update(Book book) {
        Book current = findById(book.getId());
        try {
            BeanUtils.copyProperties(current, book);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void delete(String id) {
        int index = getIndexById(id);
        books = ArrayUtils.remove(books, index);
    }

    public Book[] getAll() {
        Book[] bookEntities = new Book[getCount()];
        for (int i = 0; i < bookEntities.length; i++) {
            bookEntities[i] = books[i];
        }
        return bookEntities;
    }

    private String generateId(String id) {
        for (Book book : books) {
            if (book != null && book.getId().equals(id)) {
                return generateId(RandomStringUtils.randomAlphanumeric(6));
            }
        }
        return id;
    }

    private Book findById(String id) {
        return books[getIndexById(id)];
    }

    public Book getById(String id) {
        return findById(id);
    }

    private int getIndexById(String id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId().equals(id)) {
                return i;
            }
        }
        System.out.println("dataclasses.Book with this ID does not exist!!!");
        return -1;
    }

    private int getCount() {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                return i;
            }
        }
        return books.length;
    }


}
