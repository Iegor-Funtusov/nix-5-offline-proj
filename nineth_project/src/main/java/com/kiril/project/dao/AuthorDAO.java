package com.kiril.project.dao;

import com.kiril.project.entities.Author;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuthorDAO {

    private ArrayList<Author> authors = new ArrayList<>();
    private CSVWorker csv = new CSVWorker();
    private Logger WARN = LoggerFactory.getLogger("warning");
    private Logger ERR = LoggerFactory.getLogger("error");
    private Logger INF = LoggerFactory.getLogger("info");
    public AuthorDAO() throws IOException {
    }

    public void create(Author item) {
        INF.info("Author.create method start");
        item.setId(getNewId(item.getId()));
        authors.add(item);
        csv.writeAuthors(authors);
        INF.info("Author.create method end");
    }

    public Author read(String id) {
        INF.info("Author.read start");
        return csv.readAuthor(id);
    }

    public List<Author> readAll() {
        INF.info("Author.readAll start");
       return csv.readAllAuthors();
    }


    public void update(String id, Author author) {
        WARN.warn("Author.update start");
        Author thisAuthor = read(id);
        try {
            author.setId(thisAuthor.getId());
            BeanUtils.copyProperties(thisAuthor, author);
            for (int i = 0; i < size(); i++) {
                if(author.getId().equals(authors.get(i).getId())) {
                    authors.set(i, author);
                }
            }
            csv.writeAuthors(authors);
            WARN.warn("Author.update end");
        } catch (Exception e) {
            ERR.error("Author.update error, book doesn't exist");
            throw new RuntimeException("Can not update this Book yet");
        }
    }

    public void delete(String id) {
        WARN.warn("Deletion started");
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).getId().equals(id))
                authors.get(i).setVisible(false);
        }
        csv.writeAuthors(authors);
        WARN.warn("Deletion end");
    }

    private String getNewId(String id) {
        if (!authors.stream().anyMatch(author -> author.getId().equals(id))) {
            return UUID.randomUUID().toString();
        }
        return id;
    }

    public int size() {
        return authors.size();
    }


}
