package service;

import dao.AuthorDao;
import entity.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private AuthorDao authorDao = new AuthorDao();

    public void create(String name) {
        LOGGER_INFO.info("Start create author: " + name);

        authorDao.create(name);

        LOGGER_INFO.info("End create author");
    }

    public void readAll(){

        authorDao.readAll();

    }

    public Author read(int id){

        Author author = authorDao.read(id);

        return author;
    }
    public void update(int id, String newName){
        LOGGER_WARN.warn("Start update author id: " + id);
        authorDao.update(id,newName);
        LOGGER_WARN.warn("End update author");

    }
    public void delete(int id){

        authorDao.delete(id);

    }
}
