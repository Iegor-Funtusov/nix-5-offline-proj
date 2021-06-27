package com.kiril.project.dao;

import com.kiril.project.entities.Book;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookDAO {

    private List<Book> booksList = new ArrayList<>();
    private CSVWorker csv = new CSVWorker();
    private Logger WARN = LoggerFactory.getLogger("warning");
    private Logger ERR = LoggerFactory.getLogger("error");
    private Logger INF = LoggerFactory.getLogger("info");

    public BookDAO() throws IOException {
    }

    public void create(Book item) {
        INF.info("BookDAO.create method start");
        item.setId(getNewId(item.getId()));
        booksList.add((Book) item);
        csv.writeBooks(booksList);
        INF.info("BookDAO.create method end");
    }

    public Book read(String id) {
        INF.info("BookDAO.read method start");
        return csv.readBook(id);
    }

    public List<Book> readAll() {
        INF.info("BookDAO.readAll method start");
        return csv.readAllBooks();
    }

    public void update(String id, Book book) {
        WARN.warn("BookDAO.update start");
        Book thisBook = read(id);
        try {
            book.setId(thisBook.getId());
            BeanUtils.copyProperties(thisBook, book);
            for (int i = 0; i < size(); i++) {
                if (thisBook.getId().equals(booksList.get(i).getId())) {
                    booksList.set(i, thisBook);
                }
            }
            csv.writeBooks(booksList);
            WARN.warn("BookDAO.update start");
        } catch (Exception e) {
            ERR.error("BookDAO.update crashed, can not update this book yet");
            throw new RuntimeException("Can not update this Book yet");
        }
    }

    public void delete(String id) {
        WARN.warn("BookDAO.delete start");
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getId().equals(id))
                booksList.get(i).setVisible(false);
        }
        csv.writeBooks(booksList);
        WARN.warn("BookDAO.end start");
    }

    private String getNewId(String id) {
        if (!booksList.stream().anyMatch(book -> book.getId().equals(id))) {
            return UUID.randomUUID().toString();
        }
        return id;
    }

    public int size() {
        return booksList.size();
    }
}
