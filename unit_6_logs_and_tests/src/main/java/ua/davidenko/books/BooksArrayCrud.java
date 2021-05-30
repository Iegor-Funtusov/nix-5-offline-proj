package ua.davidenko.books;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.UUID;

public class BooksArrayCrud {
    private Books[] booksArray = new Books[0];

    public void create(Books book) {
        book.setBookId(generateId(UUID.randomUUID().toString()));
        Books[] newBooksArray = new Books[booksArray.length + 1];
        newBooksArray[booksArray.length] = book;
        System.arraycopy(booksArray,0,newBooksArray,0,booksArray.length);
        booksArray = newBooksArray;
    }

    public void update(Books book){
        int numId = findByBookId(book.getBookId());
        Books current = booksArray[numId];
        try {
            BeanUtils.copyProperties(current, book);
        } catch (Exception ex) {
            throw new RuntimeException("Something wrong");
        }
    }

    public void delete(String id) {
        int numId = findByBookId(id);
        booksArray = ArrayUtils.remove(booksArray, numId);
    }

    public Books read(String id) {
        return booksArray[findByBookId(id)];
    }


    public Books[] read() {
        return booksArray;
    }

    private String generateId(String id) {
        if (Arrays.stream(booksArray).anyMatch(e -> e.getBookId().equals(id))) {
            return generateId(generateId(UUID.randomUUID().toString()));
        }
        return id;
    }

    private int findByBookId(String id) {
        for (int i = 0; i < booksArray.length; i++) {
            if (booksArray[i].getBookId().equals(id))
                return i;
        }
        return -1;
    }
}




