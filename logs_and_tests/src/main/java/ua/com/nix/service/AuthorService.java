package ua.com.nix.service;

import ua.com.nix.dao.AuthorDao;
import ua.com.nix.model.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

        private final AuthorDao authorDao = new AuthorDao();

        public void create(Author author) {
            if (author != null) {
                LOGGER_INFO.info("Start create author: " + author.getFirstName()+" "+author.getLastName());
                authorDao.create(author);
                LOGGER_INFO.info("End create author: " + author.getFirstName()+" "+author.getLastName());
            }
            else{
                LOGGER_ERROR.error("Author is null!");
            }
        }
        public void update(Author author)
        {
            if (author != null && authorDao.findById(author.getId())!=null) {
                LOGGER_WARN.warn("Start update author: " + author.getId());
                authorDao.update(author);
                LOGGER_WARN.warn("End create author: " + author.getId());
            }
            else {
                LOGGER_ERROR.error("Author doesn't exists");
            }
        }
        public void delete(String id)
        {
            if (authorDao.findById(id)!=null) {
                LOGGER_WARN.warn("Start delete author: " + id);
                authorDao.delete(id);
                LOGGER_WARN.warn("End delete author: " + id);
            }
        else {
                LOGGER_ERROR.error("Author doesn't exists");
        }
        }
        public Author[] findAll() {
            LOGGER_INFO.info("Read all authors");
            return authorDao.findAll();
        }
        public Author findById(String id) {
            if (authorDao.findById(id) != null) {
                return authorDao.findById(id);
            }
            LOGGER_ERROR.error("Author doesn't exists");
            return null;
        }

}



