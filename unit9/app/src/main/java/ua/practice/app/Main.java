package ua.practice.app;

import ua.practice.app.dao.impl.AuthorDaoImpl;
import ua.practice.app.dao.impl.BookDaoImpl;
import ua.practice.app.entity.Author;
import ua.practice.app.entity.Book;
import ua.practice.crud_library.IOProcessor;

public class Main {
    public static void main(String[] args) {
        IOProcessor.createDataBasesIfNotExist(Main.class);
        BookDaoImpl bookDao = new BookDaoImpl();
        Book book = new Book();
        book.setName("nameOfBook");
        bookDao.create(book);

        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        Author author = new Author();
        authorDao.create(author);
    }
}
