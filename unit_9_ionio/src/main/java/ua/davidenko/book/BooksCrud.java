package ua.davidenko.book;

import org.apache.commons.beanutils.BeanUtils;
import ua.davidenko.author.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BooksCrud {

    private List<Book> booksArray = new ArrayList<>();

    private String generateId(String id) {
        if (booksArray.stream().anyMatch(e -> e.getBookId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }

    public void create(Book book) {
        book.setBookId(generateId(UUID.randomUUID().toString()));
        booksArray.add(book);
    }

    public void update(String id) {
        Book thisBook = findByBookId(id);
        try {
            BeanUtils.copyProperties(thisBook, findByBookId(id));
        } catch (Exception ex) {
            throw new RuntimeException("Something wrong");
        }
    }

    public void delete(Book book) {
        book.setVisible(false);
    }

    public Book findByBookId(String id) {
        Book thisBook = booksArray
                .stream()
                .filter(e -> e.getBookId().equals(id))
                .findAny()
                .orElse(null);
        if (thisBook == null) {
            throw new RuntimeException("Can not find this book");
        }
        return thisBook;
    }

    public List<Book> readBooks() {
        return booksArray;
    }

        public List<Author>readAuthors (Book book){
            return book.getAllAuthors();
        }
    }
