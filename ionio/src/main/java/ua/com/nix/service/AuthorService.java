package ua.com.nix.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.nix.dao.impl.AuthorDaoImpl;
import ua.com.nix.model.Author;
import ua.com.nix.model.Book;

import java.util.List;

public class AuthorService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

        private final AuthorDaoImpl authorDao = new AuthorDaoImpl();

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
            if (author != null && authorDao.read(author.getId())!=null) {
                LOGGER_WARN.warn("Start update author: " + author.getId());
                authorDao.update(author);
                LOGGER_WARN.warn("End update author: " + author.getId());
            }
            else {
                LOGGER_ERROR.error("Author doesn't exists");
            }
        }
        public void delete(String id)
        {
            if (authorDao.read(id)!=null) {
                LOGGER_WARN.warn("Start delete author: " + id);
                authorDao.delete(id);
                LOGGER_WARN.warn("End delete author: " + id);
            }
        else {
                LOGGER_ERROR.error("Author doesn't exists");
        }
        }
        public List<Author> readAll() {
            LOGGER_INFO.info("Read all authors");
            return authorDao.readAll();
        }
        public Author read(String id) {
            if (authorDao.read(id) != null) {
                return authorDao.read(id);
            }
            LOGGER_ERROR.error("Author doesn't exists");
            return null;
        }
        public List<Book> readAllBooksByAuthor(Author author)
        {
            LOGGER_INFO.info("Read all books by author: " + author.getLastName());
            return authorDao.readAllBooksByAuthor(author);
        }

}



