package ua.practice.app.dao.dao_impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.beanutils.BeanUtils;
import ua.practice.app.io_processor.IOProcessor;
import ua.practice.app.converters.BookConverter;
import ua.practice.app.dao.BookDao;
import ua.practice.app.data_base_creator.DatabaseCreator;
import ua.practice.app.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookDaoImpl implements BookDao {
    private final ArrayList<Book> books;


    public BookDaoImpl() {
        DatabaseCreator.createDataBasesIfNotExist(Book.class);
        Gson gson = new Gson();
        TypeToken<List<Book>> list = new TypeToken<>() {};
        books = IOProcessor.readAllData(Book.class).stream()
                .map(row->{
                    Book book = new Book();
                    book.setId(row[0]);
                    book.setName(row[1]);
                    book.setAuthors(gson.fromJson(row[2], list.getType()));
                    book.setVisible(Boolean.parseBoolean(row[3]));
                    return book;
                }).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void create(Book book) {
        book.setId(generateId(UUID.randomUUID().toString()));
        String[] fields = BookConverter.convertBookToStringArray(book);
        IOProcessor.inputDataToFile(Book.class, fields, true);
        books.add(book);
    }

    @Override
    public void update(Book book) {
        Book currentBook = findById(book.getId());
        try {
            BeanUtils.copyProperties(currentBook, book);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        ArrayList<String[]> csvData = new ArrayList<>();
        csvData.addAll(books.stream().map(BookConverter::convertBookToStringArray).collect(Collectors.toList()));
        IOProcessor.updateDataToFile(Book.class, csvData);
    }

    @Override
    public void delete(String id) {
        Book currentBook = findById(id);
        currentBook.setVisible(false);
        ArrayList<String[]> csvData = new ArrayList<>();
        csvData.addAll(books
                .stream()
                .map(BookConverter::convertBookToStringArray)
                .collect(Collectors.toList()));
        IOProcessor.updateDataToFile(Book.class, csvData);
    }

    @Override
    public List<Book> read() {
        return books.stream().filter(Book::isVisible).collect(Collectors.toList());
    }

    @Override
    public Book read(String id) {
        return findById(id);
    }

    private Book findById(String id) {
        return books
                .stream()
                .filter(book -> book.getId().equals(id) && book.isVisible())
                .findAny()
                .orElseThrow(() -> new RuntimeException("Book with id" + id + "doesn't exist"));
    }

    private String generateId(String id) {
        if (books.stream().anyMatch(e ->e.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }

}
