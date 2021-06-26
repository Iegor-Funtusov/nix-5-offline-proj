package ua.practice.app.service.service_impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.practice.app.dao.dao_impl.AuthorDaoImpl;
import ua.practice.app.entity.Author;
import ua.practice.app.service.AuthorService;

import java.util.Collection;

public class AuthorServiceImpl implements AuthorService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final AuthorDaoImpl authorDao = new AuthorDaoImpl();

    public void create(Author author) {
        if (author != null) {
            LOGGER_INFO.info("Start create author: " + author.getName());
            if (!isAuthorExist(author.getId())) {
                authorDao.create(author);
            }
        } else
            LOGGER_ERROR.error("Author == null in create");
        LOGGER_INFO.info("End create author");
    }

    public void update(Author author) {
        if (author != null) {
            LOGGER_WARN.warn("Start update author: " + author.getName());
            if (isAuthorExist(author.getId())) {
                authorDao.update(author);
            }
        } else
            LOGGER_ERROR.error("Author == null in update");
        LOGGER_WARN.warn("End update author");
    }

    public void delete(String id) {
        LOGGER_WARN.warn("Start delete author " + id);
        if (isAuthorExist(id))
            authorDao.delete(id);
        else
            LOGGER_ERROR.error("Author with id " + id + "doesn't exist");
        LOGGER_WARN.warn("End delete author");
    }

    public Collection<Author> read() {
        LOGGER_WARN.warn("Start reading authors");
        Collection<Author> authors = authorDao.read();
        LOGGER_WARN.warn("End reading authors");
        return authors;
    }

    public Author read(String id) {
        if (isAuthorExist(id))
            return authorDao.read(id);
        return null;
    }

    private boolean isAuthorExist(String id) {
        if (id != null) {
            boolean result = authorDao.read().stream().anyMatch(author -> author.getId().equals(id));
            if (!result)
                LOGGER_ERROR.error("Author with id " + id + "doesn't exist");
            return result;
        } else {
            LOGGER_ERROR.error("Input id == null");
        }
        return false;
    }
}
