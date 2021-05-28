package ua.practice.unit6.application.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.practice.unit6.application.DAO.daoImpl.AuthorToBookDAOImpl;
import ua.practice.unit6.application.entity.Author;
import ua.practice.unit6.application.entity.AuthorToBook;
import ua.practice.unit6.application.entity.Book;
import ua.practice.unit6.application.service.AuthorToBookService;

import java.util.Collection;
import java.util.List;

public class AuthorToBookServiceImpl implements AuthorToBookService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final AuthorToBookDAOImpl authorToBookDAO = new AuthorToBookDAOImpl();

    public void create(AuthorToBook authorToBook) {
        LOGGER_INFO.info("Start create authorToBook");
        boolean isAuthorExist = authorToBook.getAuthors() != null;
        boolean isBookExist = authorToBook.getBooks() != null;
        if (!isAuthorToBookExist(authorToBook.getId()) && isAuthorExist && isBookExist) {
            authorToBookDAO.create(authorToBook);
        }
        LOGGER_INFO.info("End create author");
    }

    public void update(AuthorToBook authorToBook) {
        LOGGER_WARN.warn("Start update authorToBook: ");
        if (isAuthorToBookExist(authorToBook.getId())) {
            authorToBookDAO.update(authorToBook);
        }
        LOGGER_WARN.warn("End update authorToBook");
    }

    public void delete(String id) {
        LOGGER_WARN.warn("Start delete authorToBook " + id);
        if (isAuthorToBookExist(id))
            authorToBookDAO.delete(id);
        LOGGER_WARN.warn("End delete authorToBook");
    }

    public Collection<AuthorToBook> read() {
        LOGGER_WARN.warn("Start reading authorToBook");
        Collection<AuthorToBook> authors = authorToBookDAO.read();
        LOGGER_WARN.warn("End reading authorToBook");
        return authors;
    }

    public AuthorToBook read(String id) {
        if (isAuthorToBookExist(id))
            return authorToBookDAO.read(id);
        return null;
    }

    public List<Author> readAllAuthorsByBookId(String id) {
        return authorToBookDAO.readAllAuthorsByBookId(id);
    }

    public List<Book> readAllBooksByAuthorId(String id) {
        return authorToBookDAO.readAllBooksByAuthorId(id);
    }

    private boolean isAuthorToBookExist(String id) {
        if (id != null) {
            boolean result = authorToBookDAO.read().stream().anyMatch(author -> author.getId().equals(id));
            if (!result)
                LOGGER_ERROR.error("AuthorToBook with id " + id + "doesn't exist");
            return result;
        } else {
            LOGGER_ERROR.error("Input id == null");
        }
        return false;
    }
}
