package nix.com.author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");


    private AuthorDao authorDao = new AuthorDao();

    public void create(Author author) {
        if (!(isAuthorExistByAge(author) || isAuthorExistByName(author))) {
            authorDao.create(author);
        }
    }

    public void update(Author author) {
        if (!(isAuthorExistByAge(author) || isAuthorExistByName(author))) {
            authorDao.update(author);
        }
    }

    public Author[] readAll() {
        return authorDao.readAll();
    }

    public Author findById(String id) {
        return authorDao.findById(id);
    }

    public void delete(String id) {
        authorDao.delete(id);
    }

    private boolean isAuthorExistByName(Author author) {
        if (author.getName() != null) {
            Author[] authorDaoByName = authorDao.findByName(author.getName());
            if (authorDaoByName == null) {
                return false;
            } else {
               LOGGER_ERROR.error("this author is exist: " + author.getName());
            }
        } else {
            LOGGER_ERROR.error("name can't be empty");
        }
        return true;
    }

    private boolean isAuthorExistByAge(Author author) {
        if (author.getAge() != null) {
            Author[] authorDaoByAge = authorDao.findByAge(author.getAge());
            if (authorDaoByAge == null) {
                return false;
            } else {
                LOGGER_ERROR.error("this author is exist: " + author.getName());
            }
        } else {
            LOGGER_ERROR.error("name can't be empty");
        }
        return true;
    }
}
