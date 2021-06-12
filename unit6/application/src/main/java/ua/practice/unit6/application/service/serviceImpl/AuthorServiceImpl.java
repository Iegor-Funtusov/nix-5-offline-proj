package ua.practice.unit6.application.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.practice.unit6.application.DAO.daoImpl.AuthorDAOImpl;
import ua.practice.unit6.application.entity.Author;
import ua.practice.unit6.application.service.AuthorService;

import java.util.Collection;

public class AuthorServiceImpl implements AuthorService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final AuthorDAOImpl authorDao = new AuthorDAOImpl();

    public void create(Author author) {
        if (author != null) {
            LOGGER_INFO.info("Start create author: " + author.getName());
            if (!isAuthorExistByName(author.getName()) && !isAuthorExist(author.getId())) {
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

    private boolean isAuthorExistByName(String name) {
        if (name != null) {
            boolean result = authorDao.read().stream().anyMatch(author -> name.equals(author.getName()));
            if (!result) {
                LOGGER_ERROR.error("author does not exist");
            }
            return result;
        } else {
            LOGGER_ERROR.error("Input name == null");
        }
        return false;
    }

    private boolean isAuthorExist(String id) {
        if (id != null) {
            boolean result = authorDao.read().stream().anyMatch(author -> author.getId().equals(id));
            if (!result)
                LOGGER_ERROR.error("author with id " + id + "doesn't exist");
            return result;
        } else {
            LOGGER_ERROR.error("Input id == null");
        }
        return false;
    }
}
