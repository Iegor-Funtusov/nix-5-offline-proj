package nix.com.author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");


    private AuthorDao authorDao = new AuthorDao();

    public void create(Author author) {
        LOGGER_INFO.info("start create author: " + author.getId());
        if (!isParamNull(author)) {
            authorDao.create(author);
        }
        LOGGER_INFO.info("end create author: " + author.getId());
    }

    public void update(Author author) {
        LOGGER_INFO.info("start update author: " + author.getId());
        if (!isAuthorExistById(author.getId())) {
            authorDao.update(author);
        }
        LOGGER_INFO.info("end update author: " + author.getId());
    }

    public Author[] readAll() {
        LOGGER_INFO.info("read all authors");
        return authorDao.readAll();
    }

    public Author findById(String id) {
        LOGGER_INFO.info("start find author id: " + id);
        if (!isAuthorExistById(id)) {
            return authorDao.findById(id);
        }
        LOGGER_INFO.info("end find author id: " + id);
        return null;
    }

    public void delete(String id) {
        LOGGER_WARN.warn("start delete author: " + id);
        if (!isAuthorExistById(id)) {
            authorDao.delete(id);
        }
        LOGGER_WARN.warn("end delete author: " + id);
    }

    private boolean isAuthorExistById(String id) {
        Author CurrentAuthor = authorDao.findById(id);
        if (CurrentAuthor.getId() != null) {
            Author[] authorDaoById = authorDao.findByName(CurrentAuthor.getId());
            if (authorDaoById == null) {
                return false;
            } else {
                LOGGER_ERROR.info("this author id is exist: " + CurrentAuthor.getId());
            }
        } else {
            LOGGER_ERROR.error("author id can't be empty");
        }
        return true;
    }

    private boolean isParamNull(Author author) {
        if (author.getAge() == null || author.getName() == null) {
            return true;
        }
        return false;
    }

}
