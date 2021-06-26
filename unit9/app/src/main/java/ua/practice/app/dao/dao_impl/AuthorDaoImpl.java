package ua.practice.app.dao.dao_impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.beanutils.BeanUtils;
import ua.practice.app.io_processor.IOProcessor;
import ua.practice.app.converters.AuthorConverter;
import ua.practice.app.dao.AuthorDao;
import ua.practice.app.data_base_creator.DatabaseCreator;
import ua.practice.app.entity.Author;
import ua.practice.app.entity.Book;

import java.util.*;
import java.util.stream.Collectors;

public class AuthorDaoImpl implements AuthorDao {
    private final ArrayList<Author> authors;

    public AuthorDaoImpl() {
        DatabaseCreator.createDataBasesIfNotExist(Author.class);
        Gson gson = new Gson();
        TypeToken<List<Book>> list = new TypeToken<>() {};
        authors = IOProcessor.readAllData(Author.class).stream()
                .map(row -> {
                    Author author = new Author();
                    author.setId(row[0]);
                    author.setName(row[1]);
                    author.setLastName(row[2]);
                    author.setBooks(gson.fromJson(row[3], list.getType()));
                    author.setVisible(Boolean.parseBoolean(row[4]));
                    return author;
                }).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void create(Author author) {
        author.setId(generateId(UUID.randomUUID().toString()));
        String[] fields = AuthorConverter.convertAuthorToStringArray(author);
        IOProcessor.inputDataToFile(Author.class, fields, true);
        authors.add(author);
    }

    @Override
    public void update(Author author) {
        Author currentAuthor = findById(author.getId());
        try {
            BeanUtils.copyProperties(currentAuthor, author);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        ArrayList<String[]> csvData = new ArrayList<>();
        csvData.addAll(authors.stream()
                .map(AuthorConverter::convertAuthorToStringArray)
                .collect(Collectors.toList()));
        IOProcessor.updateDataToFile(Author.class, csvData);
    }

    @Override
    public void delete(String id) {
        Author currentAuthor = findById(id);
        currentAuthor.setVisible(false);
        ArrayList<String[]> csvData = new ArrayList<>();
        csvData.addAll(authors.stream()
                .map(AuthorConverter::convertAuthorToStringArray)
                .collect(Collectors.toList()));
        IOProcessor.updateDataToFile(Author.class, csvData);
    }

    @Override
    public List<Author> read() {
        return authors
                .stream()
                .filter(Author::isVisible)
                .collect(Collectors.toList());
    }

    @Override
    public Author read(String id) {
        return findById(id);
    }

    private String generateId(String id) {
        if (authors.stream().anyMatch(e -> e.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }

    private Author findById(String id) {
        return authors
                .stream()
                .filter(author -> author.getId().equals(id) && author.isVisible())
                .findAny()
                .orElseThrow(() -> new RuntimeException("Author with id " + id + " doesn't exist or deleted"));
    }
}
