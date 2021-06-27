package ua.com.alevel.service;

import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.entity.Author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AuthorService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private static final AuthorDao authorDao = new AuthorDao();

    public static void createAuthor(Author author){
        if (author != null){
            if ( authorDao.readById(author.getId()) == null){
                LOGGER_INFO.info("Creating author");
                authorDao.create(author);
                LOGGER_INFO.info("Author created" + author.getId());
            } else
                LOGGER_ERROR.error("Such author already exist " + author);
        }

    }

    public static void updateAuthor(Author author){
        if (author != null){
            if ( authorDao.readById(author.getId()) != null){
                LOGGER_INFO.info("Updating author " + author.getId());
                authorDao.update(author);
                LOGGER_INFO.info("Author updated "+ author.getId());
            }else
                LOGGER_ERROR.error("Such author does not exist "+ author.getId());
        }

    }

    public static void deleteAuthorById(String id){
        if (authorDao.readById(id) != null){
            LOGGER_WARN.warn("Deleting author " + id);
            authorDao.delete(id);
            LOGGER_WARN.warn("Author deleted " + id);
        }else
            LOGGER_ERROR.error("Author does not exist " + id);
    }

    public static Author readAuthorById(String id){
        LOGGER_INFO.info("Reading author by id" + id);
        return authorDao.readById(id);
    }

    public static List<Author> readAllAuthors(){
        LOGGER_INFO.info("Reading all authors ");
        return authorDao.readAll();
    }
}