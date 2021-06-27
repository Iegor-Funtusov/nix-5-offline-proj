package daoclasses;

import dataclasses.Author;
import dataclasses.Book;
import dataclasses.EntityWrapper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class BookDao {
    EntityWrapper<Book>[] books = new EntityWrapper[5];

    public void create(Book book) {
        book.setId(generateId(RandomStringUtils.randomAlphanumeric(6)));
        if (books[books.length - 1] == null) {
            books[getCount()] = new EntityWrapper<Book>(book, false);
        } else {
            EntityWrapper<Book>[] newArray = new EntityWrapper[books.length + books.length / 2];
            for (int i = 0; i < books.length; i++) {
                newArray[i] = books[i];
            }
            newArray[books.length] = new EntityWrapper<Book>(book, false);
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
        books[index].setDeleted(true);
    }

    public Book[] getAllBooks() {
        Book[] bookEntities = new Book[getCount()];
        for (int i = 0; i < bookEntities.length; i++) {
            if (!books[i].isDeleted()) {
                bookEntities[i] = books[i].getEntity();
            }
        }
        for (int i = 0; i < bookEntities.length; i++) {
            if (bookEntities[i] == null) {
                bookEntities = ArrayUtils.remove(bookEntities, i);
            }
        }
        return bookEntities;
    }

    public EntityWrapper<Book>[] getAllEntities() {
        EntityWrapper<Book>[] bookEntities = new EntityWrapper[getCount()];
        for (int i = 0; i < bookEntities.length; i++) {
            bookEntities[i] = books[i];
        }
        return bookEntities;
    }

    public void addBooks(EntityWrapper<Book>[] newBooks) {
        for (EntityWrapper<Book> newBook : newBooks) {
            if (findById(newBook.getEntity().getId()) == null) {
                if (books[books.length - 1] == null) {
                    books[getCount()] = newBook;
                } else {
                    EntityWrapper<Book>[] newArray = new EntityWrapper[books.length + books.length / 2];
                    for (int i = 0; i < books.length; i++) {
                        newArray[i] = books[i];
                    }
                    newArray[books.length] = newBook;
                    books = newArray;
                }
            } else return;
        }
    }

    private String generateId(String id) {
        for (EntityWrapper<Book> book : books) {
            if (book != null && book.getEntity().getId().equals(id)) {
                return generateId(RandomStringUtils.randomAlphanumeric(6));
            }
        }
        return id;
    }

    private Book findById(String id) {
        if (getIndexById(id) == -1) return null;
        return books[getIndexById(id)].getEntity();
    }

    public Book getById(String id) {
        return findById(id);
    }

    private int getIndexById(String id) {
        for (int i = 0; i < getCount(); i++) {
            if (books[i].getEntity().getId().equals(id)) {
                return i;
            }
        }
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