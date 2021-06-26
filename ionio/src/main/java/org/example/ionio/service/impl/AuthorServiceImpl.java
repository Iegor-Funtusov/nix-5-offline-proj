package org.example.ionio.service.impl;

import org.example.ionio.dao.AuthorDao;
import org.example.ionio.dao.impl.AuthorDaoImpl;
import org.example.ionio.model.Author;
import org.example.ionio.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorServiceImpl implements AuthorService {
    private static final Logger LOGGER = LoggerFactory.getLogger("AuthorServiceLogger");
    private static final AuthorDao authorDao = new AuthorDaoImpl();

    @Override
    public void create(Author author) {
        if(author != null){
            if(!authorIsExist(author.getId())){
                LOGGER.info("Start create author: " + author.getId());
                authorDao.create(author);
                LOGGER.info("End create author: " + author.getId());
            } else {
                LOGGER.error("Author with same id already exists: " + author.getId());
            }
        }
    }

    @Override
    public void update(Author author) {
        if (author != null) {
            if (authorIsExist(author.getId())) {
                LOGGER.warn("Start update author: " + author.getId());
                authorDao.update(author);
                LOGGER.warn("End update author: " + author.getId());
            } else {
                LOGGER.error("Author is not exists: " + author.getId());
            }
        }
    }

    @Override
    public void delete(String id) {
        if(authorIsExist(id)){
            LOGGER.warn("Start delete author ID: " + id);
            authorDao.delete(id);
            LOGGER.warn("Start delete author ID: " + id);
        } else {
            LOGGER.error("Author is not exists: " + id);
        }
    }

    @Override
    public Author readById(String id) {
        return authorDao.readById(id);
    }

    @Override
    public List<Author> readByBook(String bookId) {
        return authorDao.readAll()
                .stream()
                .filter(a ->
                        a.getBookList()
                                .stream()
                                .anyMatch(b -> b.getId().equals(bookId)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Author> readAll() {
        return authorDao.readAll();
    }

    private boolean authorIsExist(String id){
        return authorDao.readById(id) != null;
    }
}
